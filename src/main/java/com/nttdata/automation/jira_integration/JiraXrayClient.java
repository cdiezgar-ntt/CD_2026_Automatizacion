package com.nttdata.automation.jira_integration;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class JiraXrayClient {

    private final XrayConfig config;
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public JiraXrayClient(XrayConfig config) {
        this.config = config;
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    public String createTestExecution(TestExecutionRequest request) {
        Map<String, Object> fields = new LinkedHashMap<>();

        fields.put("project", Map.of("key", config.projectKey()));
        fields.put("summary", request.summary());
        fields.put("issuetype", Map.of("name", config.testExecutionIssueType()));

        if (!config.testPlanCustomField().isBlank()) {
            fields.put(config.testPlanCustomField(), List.of(request.testPlanKey()));
        }

        if (!config.environmentCustomField().isBlank()) {
            fields.put(config.environmentCustomField(), request.environment());
        }

        Map<String, Object> payload = Map.of("fields", fields);

        JsonNode response = postJson(config.jiraApiBase() + "/issue", payload);

        return response.path("key").asText();
    }

    public String createTestSet(String summary, List<String> testKeys) {
        Map<String, Object> fields = new LinkedHashMap<>();
        fields.put("project", Map.of("key", config.projectKey()));
        fields.put("summary", summary);
        fields.put("issuetype", Map.of("name", config.testSetIssueType()));

        JsonNode response = postJson("/rest/api/2/issue", Map.of("fields", fields));
        String testSetKey = response.path("key").asText();

        addTestsToTestSet(testSetKey, testKeys);

        return testSetKey;
    }

    public void addTestsToTestExecution(String testExecutionKey, List<String> testKeys) {
        if (testKeys == null || testKeys.isEmpty()) {
            return;
        }

        String path = config.xrayApiBase()
                + "/api/testexec/"
                + encode(testExecutionKey)
                + "/test";

        postJson(path, Map.of("add", testKeys));
    }

    public void addTestsToTestSet(String testSetKey, List<String> testKeys) {
        if (testKeys == null || testKeys.isEmpty()) {
            return;
        }

        String path = config.xrayApiBase()
                + "/api/testset/"
                + encode(testSetKey)
                + "/test";

        postJson(path, Map.of("add", testKeys));
    }

    public int getTestRunId(String testExecutionKey, String testKey) {
        String path = config.xrayApiBase()
                + "/api/testrun?testExecIssueKey="
                + encode(testExecutionKey)
                + "&testIssueKey="
                + encode(testKey);

        JsonNode response = getJson(path);

        if (response.has("id")) {
            return response.path("id").asInt();
        }

        throw new XrayIntegrationException(
                "No se ha podido resolver Test Run para Test Execution "
                        + testExecutionKey
                        + " y Test "
                        + testKey
        );
    }

    public void updateTestRunStatus(int testRunId, String status) {
        String path = config.xrayApiBase()
                + "/api/testrun/"
                + testRunId
                + "/status?status="
                + encode(status);

        putWithoutBody(path);
    }

    public void uploadEvidenceToTestRun(int testRunId, Path evidencePath, String contentType) {
        try {
            byte[] fileBytes = Files.readAllBytes(evidencePath);
            String base64 = Base64.getEncoder().encodeToString(fileBytes);

            Map<String, Object> evidence = new LinkedHashMap<>();
            evidence.put("filename", evidencePath.getFileName().toString());
            evidence.put("data", base64);
            evidence.put("contentType", contentType);

            String path = config.xrayApiBase()
                    + "/api/testrun/"
                    + testRunId
                    + "/attachment";

            postJson(path, evidence);

        } catch (IOException e) {
            throw new XrayIntegrationException("Error leyendo evidencia: " + evidencePath, e);
        }
    }

    public void attachFileToIssue(String issueKey, Path filePath) {
        /*
         * Alternativa: adjuntar el HTML al issue Test Execution en Jira.
         * No sustituye a la evidencia del Test Run en Xray, pero puede ser útil.
         *
         * Jira DC usa:
         * POST /rest/api/2/issue/{issueKey}/attachments
         * Header X-Atlassian-Token: no-check / nocheck según versión/configuración.
         *
         * Este método se deja como placeholder porque multipart/form-data con HttpClient
         * requiere construir el boundary manualmente o usar Apache HttpClient.
         */
        throw new UnsupportedOperationException("Implementar si quieres adjuntos a nivel issue");
    }

    private JsonNode getJson(String path) {
        HttpRequest request = baseRequest(path)
                .GET()
                .header("Accept", "application/json")
                .build();

        return sendForJson(request);
    }

    private JsonNode postJson(String path, Object body) {
        String json = toJson(body);

        HttpRequest request = baseRequest(path)
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .build();

        return sendForJson(request);
    }

    private void putWithoutBody(String path) {
        HttpRequest request = baseRequest(path)
                .PUT(HttpRequest.BodyPublishers.noBody())
                .header("Accept", "application/json")
                .build();

        send(request);
    }

    private HttpRequest.Builder baseRequest(String path) {
        String normalizedHost = config.jiraHost().replaceAll("/+$", "");
        String normalizedPath = path.startsWith("/") ? path : "/" + path;

        HttpRequest.Builder builder = HttpRequest.newBuilder()
                .uri(URI.create(normalizedHost + normalizedPath));

        if ("BEARER".equalsIgnoreCase(config.authType())) {
            builder.header("Authorization", "Bearer " + config.apiKey());
        } else {
            throw new XrayIntegrationException("Auth type no soportado: " + config.authType());
        }

        return builder;
    }

    private JsonNode sendForJson(HttpRequest request) {
        HttpResponse<String> response = send(request);

        try {
            if (response.body() == null || response.body().isBlank()) {
                return objectMapper.createObjectNode();
            }
            return objectMapper.readTree(response.body());
        } catch (IOException e) {
            throw new XrayIntegrationException("Respuesta no parseable como JSON: " + response.body(), e);
        }
    }

    private HttpResponse<String> send(HttpRequest request) {
        try {
            HttpResponse<String> response = httpClient.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );

            int statusCode = response.statusCode();

            if (statusCode < 200 || statusCode >= 300) {
                throw new XrayIntegrationException(
                        "Error HTTP "
                                + statusCode
                                + " llamando a "
                                + request.uri()
                                + ". Body: "
                                + response.body()
                );
            }

            return response;

        } catch (IOException e) {
            throw new XrayIntegrationException("Error IO llamando a Jira/Xray: " + request.uri(), e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new XrayIntegrationException("Thread interrumpido llamando a Jira/Xray", e);
        }
    }

    private String toJson(Object body) {
        try {
            return objectMapper.writeValueAsString(body);
        } catch (IOException e) {
            throw new XrayIntegrationException("No se ha podido serializar payload JSON", e);
        }
    }

    private String encode(String value) {
        return URLEncoder.encode(value, StandardCharsets.UTF_8);
    }

    public void addTestExecutionToTestPlan(String testPlanKey, String testExecutionKey) {
        if (testPlanKey == null || testPlanKey.isBlank()) {
            return;
        }

        String path = config.xrayApiBase()
                + "/api/testplan/"
                + encode(testPlanKey)
                + "/testexecution";

        postJson(path, Map.of("add", List.of(testExecutionKey)));
    }


}
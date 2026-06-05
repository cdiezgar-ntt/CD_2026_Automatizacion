package com.nttdata.automation.jira_integration;

import java.util.List;

public class XrayPublisher {

    private final XrayConfig config;
    private final EvidenceFileScanner evidenceFileScanner;
    private final JiraXrayClient jiraXrayClient;

    public XrayPublisher(
            XrayConfig config,
            EvidenceFileScanner evidenceFileScanner,
            JiraXrayClient jiraXrayClient
    ) {
        this.config = config;
        this.evidenceFileScanner = evidenceFileScanner;
        this.jiraXrayClient = jiraXrayClient;
    }

    public void publish() {
        if (!config.publishEnabled()) {
            System.out.println("[XRAY] Publicación deshabilitada por configuración.");
            return;
        }

        List<TestRunResult> results = evidenceFileScanner.scan(
                config.reportDir(),
                config.defaultStatus()
        );

        if (results.isEmpty()) {
            String message = "[XRAY] No se encontraron evidencias HTML en " + config.reportDir();

            if (config.failOnMissingEvidence()) {
                throw new XrayIntegrationException(message);
            }

            System.out.println(message);
            return;
        }

        List<String> testKeys = results.stream()
                .map(TestRunResult::testKey)
                .distinct()
                .toList();

        TestExecutionRequest request = TestExecutionRequest.fromConfig(config);
        String testExecutionKey = jiraXrayClient.createTestExecution(request);

        System.out.println("[XRAY] Test Execution creada: " + testExecutionKey);

        jiraXrayClient.addTestExecutionToTestPlan(
                config.testPlanKey(),
                testExecutionKey
        );

        System.out.println("[XRAY] Test Execution asociada al Test Plan: " + config.testPlanKey());

        jiraXrayClient.addTestsToTestExecution(
                testExecutionKey,
                testKeys
        );

        System.out.println("[XRAY] Tests añadidos a la Test Execution: " + testKeys);

        if (config.createTestSet()) {
            String testSetKey = jiraXrayClient.createTestSet(
                    "Tests automatizados - " + config.environment(),
                    testKeys
            );
            System.out.println("[XRAY] Test Set creado: " + testSetKey);
        }

        for (TestRunResult result : results) {
            int testRunId = jiraXrayClient.getTestRunId(
                    testExecutionKey,
                    result.testKey()
            );

            jiraXrayClient.updateTestRunStatus(testRunId, result.status());

            jiraXrayClient.uploadEvidenceToTestRun(
                    testRunId,
                    result.evidencePath(),
                    config.evidenceContentType()
            );

            System.out.println("[XRAY] Evidencia subida para "
                    + result.testKey()
                    + " en Test Run "
                    + testRunId);
        }
    }
}
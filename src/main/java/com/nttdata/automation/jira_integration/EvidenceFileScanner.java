package com.nttdata.automation.jira_integration;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

public class EvidenceFileScanner {

    private static final Pattern JIRA_TEST_KEY_PATTERN =
            Pattern.compile("^[A-Z][A-Z0-9]+-\\d+$");

    public List<TestRunResult> scan(Path reportDir, String defaultStatus) {
        if (!Files.exists(reportDir)) {
            throw new XrayIntegrationException("No existe el directorio de evidencias: " + reportDir);
        }

        Properties statuses = loadStatuses(reportDir.resolve("xray-results.properties"));

        try {
            return Files.list(reportDir)
                    .filter(Files::isRegularFile)
                    .filter(path -> path.getFileName().toString().endsWith(".html"))
                    .map(path -> {
                        String fileName = path.getFileName().toString();
                        String testKey = fileName.substring(0, fileName.length() - ".html".length());

                        String status = XrayResultCollector.getStatus(testKey, defaultStatus);

                        return new TestRunResult(testKey, status, path);
                    })
                    .filter(result -> JIRA_TEST_KEY_PATTERN.matcher(result.testKey()).matches())
                    .peek(result -> System.out.println("[XRAY] Evidencia detectada: "
                            + result.testKey()
                            + " -> status="
                            + result.status()
                            + " -> "
                            + result.evidencePath()))
                    .toList();

        } catch (IOException e) {
            throw new XrayIntegrationException("Error leyendo evidencias desde: " + reportDir, e);
        }
    }

    private Properties loadStatuses(Path statusFile) {
        Properties properties = new Properties();

        System.out.println("[XRAY] Buscando fichero de estados en: " + statusFile.toAbsolutePath());

        if (!Files.exists(statusFile)) {
            System.out.println("[XRAY] No existe xray-results.properties. Se usará estado por defecto.");
            return properties;
        }

        try (InputStream inputStream = Files.newInputStream(statusFile)) {
            properties.load(inputStream);

            System.out.println("[XRAY] Estados cargados:");
            properties.forEach((key, value) ->
                    System.out.println("[XRAY]   " + key + "=" + value)
            );

            return properties;

        } catch (IOException e) {
            throw new XrayIntegrationException("Error leyendo fichero de estados: " + statusFile, e);
        }
    }
}
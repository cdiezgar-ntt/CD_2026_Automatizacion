package com.nttdata.automation.jira_integration;

import java.io.InputStream;
import java.nio.file.Path;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class XrayConfigLoader {

    private static final Pattern ENV_PATTERN = Pattern.compile("\\$\\{([^}]+)}");

    private XrayConfigLoader() {
    }

    public static XrayConfig load() {
        Properties properties = new Properties();

        try (InputStream input = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("config/jira-xray.properties")) {

            if (input == null) {
                throw new Exception("No existe config/jira-xray.properties");
            }

            properties.load(input);

            return new XrayConfig(
                    resolveEnv(required(properties, "jira.host")),
                    optional(properties, "jira.deployment.type", "SERVER"),
                    optional(properties, "jira.api.base", "/rest/api/2"),
                    optional(properties, "jira.auth.type", "BEARER"),
                    resolveEnv(required(properties, "jira.api.key")),

                    resolveEnv(required(properties, "jira.project.key")),
                    optional(properties, "jira.issue.type.testExecution", "Test Execution"),
                    optional(properties, "jira.issue.type.testSet", "Test Set"),

                    optional(properties, "xray.edition", "SERVER_DC"),
                    optional(properties, "xray.api.base", "/rest/raven/1.0"),
                    resolveEnv(required(properties, "xray.testPlan.key")),
                    optional(properties, "xray.customfield.testPlan", ""),
                    optional(properties, "xray.customfield.environment", ""),

                    optional(properties, "execution.name.prefix", "Ejecución automatizada"),
                    optional(properties, "execution.environment", "LOCAL"),
                    Path.of(optional(properties, "execution.report.dir", "test-output/ExtentReport")),

                    optional(properties, "evidence.content.type", "text/html"),
                    optional(properties, "evidence.status.default", "PASS"),

                    Boolean.parseBoolean(optional(properties, "publish.enabled", "true")),
                    Boolean.parseBoolean(optional(properties, "publish.createTestSet", "false")),
                    Boolean.parseBoolean(optional(properties, "publish.failOnMissingEvidence", "false"))
                    );

        } catch (Exception e) {
            throw new XrayIntegrationException("Error leyendo jira-xray.properties", e);
        }
    }

    private static String required(Properties properties, String key) {
        String value = properties.getProperty(key);
        if (value == null || value.isBlank()) {
            throw new XrayIntegrationException("Propiedad obligatoria no informada: " + key);
        }
        return value.trim();
    }

    private static String optional(Properties properties, String key, String defaultValue) {
        String value = properties.getProperty(key);
        return value == null || value.isBlank() ? defaultValue : value.trim();
    }

    private static String resolveEnv(String rawValue) {
        Matcher matcher = ENV_PATTERN.matcher(rawValue);
        if (!matcher.matches()) {
            return rawValue;
        }

        String envName = matcher.group(1);
        String envValue = System.getenv(envName);

        if (envValue == null || envValue.isBlank()) {
            throw new XrayIntegrationException("Variable de entorno no informada: " + envName);
        }

        return envValue;
    }
}
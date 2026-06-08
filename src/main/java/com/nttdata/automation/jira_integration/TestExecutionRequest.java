package com.nttdata.automation.jira_integration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestExecutionRequest {

    private final String summary;
    private final String environment;
    private final String testPlanKey;

    public TestExecutionRequest(String summary, String environment, String testPlanKey) {
        this.summary = summary;
        this.environment = environment;
        this.testPlanKey = testPlanKey;
    }

    public static TestExecutionRequest fromConfig(XrayConfig config) {
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        String summary = config.executionNamePrefix()
                + " - "
                + config.environment()
                + " - "
                + timestamp;

        return new TestExecutionRequest(summary, config.environment(), config.testPlanKey());
    }

    public String summary() {
        return summary;
    }

    public String environment() {
        return environment;
    }

    public String testPlanKey() {
        return testPlanKey;
    }
}
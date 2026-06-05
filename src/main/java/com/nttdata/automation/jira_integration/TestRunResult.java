package com.nttdata.automation.jira_integration;

import java.nio.file.Path;

public class TestRunResult {

    private final String testKey;
    private final String status;
    private final Path evidencePath;

    public TestRunResult(String testKey, String status, Path evidencePath) {
        this.testKey = testKey;
        this.status = status;
        this.evidencePath = evidencePath;
    }

    public String testKey() {
        return testKey;
    }

    public String status() {
        return status;
    }

    public Path evidencePath() {
        return evidencePath;
    }
}
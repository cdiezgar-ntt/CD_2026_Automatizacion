package com.nttdata.automation.jira_integration;

import java.nio.file.Path;

import java.nio.file.Path;

public class XrayConfig {

    private final String jiraHost;
    private final String authType;
    private final String apiKey;

    private final String projectKey;
    private final String testExecutionIssueType;
    private final String testSetIssueType;

    private final String xrayApiBase;
    private final String testPlanKey;
    private final String testPlanCustomField;
    private final String environmentCustomField;

    private final String executionNamePrefix;
    private final String environment;
    private final Path reportDir;

    private final String evidenceContentType;
    private final String defaultStatus;

    private final boolean publishEnabled;
    private final boolean createTestSet;
    private final boolean failOnMissingEvidence;

    private final String jiraApiBase;
    private final String jiraDeploymentType;
    private final String xrayEdition;

    public XrayConfig(
            String jiraHost,
            String jiraDeploymentType,
            String jiraApiBase,
            String authType,
            String apiKey,
            String projectKey,
            String testExecutionIssueType,
            String testSetIssueType,
            String xrayEdition,
            String xrayApiBase,
            String testPlanKey,
            String testPlanCustomField,
            String environmentCustomField,
            String executionNamePrefix,
            String environment,
            Path reportDir,
            String evidenceContentType,
            String defaultStatus,
            boolean publishEnabled,
            boolean createTestSet,
            boolean failOnMissingEvidence
    ) {
        this.jiraHost = jiraHost;
        this.authType = authType;
        this.apiKey = apiKey;
        this.projectKey = projectKey;
        this.testExecutionIssueType = testExecutionIssueType;
        this.testSetIssueType = testSetIssueType;
        this.xrayApiBase = xrayApiBase;
        this.testPlanKey = testPlanKey;
        this.testPlanCustomField = testPlanCustomField;
        this.environmentCustomField = environmentCustomField;
        this.executionNamePrefix = executionNamePrefix;
        this.environment = environment;
        this.reportDir = reportDir;
        this.evidenceContentType = evidenceContentType;
        this.defaultStatus = defaultStatus;
        this.publishEnabled = publishEnabled;
        this.createTestSet = createTestSet;
        this.failOnMissingEvidence = failOnMissingEvidence;
        this.jiraApiBase = jiraApiBase;
        this.jiraDeploymentType = jiraDeploymentType;
        this.xrayEdition = xrayEdition;
    }

    public String jiraHost() { return jiraHost; }
    public String authType() { return authType; }
    public String apiKey() { return apiKey; }

    public String projectKey() { return projectKey; }
    public String testExecutionIssueType() { return testExecutionIssueType; }
    public String testSetIssueType() { return testSetIssueType; }

    public String xrayApiBase() { return xrayApiBase; }
    public String testPlanKey() { return testPlanKey; }
    public String testPlanCustomField() { return testPlanCustomField; }
    public String environmentCustomField() { return environmentCustomField; }

    public String executionNamePrefix() { return executionNamePrefix; }
    public String environment() { return environment; }
    public Path reportDir() { return reportDir; }

    public String evidenceContentType() { return evidenceContentType; }
    public String defaultStatus() { return defaultStatus; }

    public boolean publishEnabled() { return publishEnabled; }
    public boolean createTestSet() { return createTestSet; }
    public boolean failOnMissingEvidence() { return failOnMissingEvidence; }

    public String jiraApiBase() { return jiraApiBase; }
    public String jiraDeploymentType() { return jiraDeploymentType; }
    public String xrayEdition() { return xrayEdition; }
}
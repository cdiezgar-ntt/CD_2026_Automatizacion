package com.nttdata.automation.jira_integration;

public class XrayIntegrationException extends RuntimeException {

    public XrayIntegrationException(String message) {
        super(message);
    }

    public XrayIntegrationException(String message, Throwable cause) {
        super(message, cause);
    }
}
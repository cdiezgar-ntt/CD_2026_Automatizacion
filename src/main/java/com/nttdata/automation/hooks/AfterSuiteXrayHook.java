package com.nttdata.automation.hooks;

import com.nttdata.automation.jira_integration.*;
import com.nttdata.automation.utils.PropertiesReader;
import io.cucumber.java.AfterAll;

public class AfterSuiteXrayHook {

    @AfterAll
    public static void publishXrayEvidence() {

        if (Boolean.parseBoolean(System.getProperty("jira-integration", "false").toLowerCase())){
            XrayConfig config = XrayConfigLoader.load();

            XrayPublisher publisher = new XrayPublisher(
                    config,
                    new EvidenceFileScanner(),
                    new JiraXrayClient(config)
            );

            publisher.publish();
        }
    }
}
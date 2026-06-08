package com.nttdata.automation.hooks;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.nttdata.automation.jira_integration.XrayResultCollector;
import com.nttdata.automation.jira_integration.XrayStatus;
import com.nttdata.automation.jira_integration.XrayTestContext;
import com.nttdata.automation.reports.ExtentReportManagement;
import com.nttdata.automation.reports.ExtentTestReporter;
import com.nttdata.automation.reports.ScreenRecorder;
import com.nttdata.automation.reports.TestExecutionContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.util.Collection;

public class ExtentReportHook {

    private static final ThreadLocal<ExtentTest> globalTestTL = new ThreadLocal<>();
    private static final ThreadLocal<ExtentTest> featureTestTL = new ThreadLocal<>();

    private static final ThreadLocal<Scenario> scenarioTL = new ThreadLocal<>();
    private static final ThreadLocal<String> featureNameTL = new ThreadLocal<>();
    private static final ThreadLocal<String> scenarioNameTL = new ThreadLocal<>();
    private static final ThreadLocal<String> casePathTL = new ThreadLocal<>();

    @Before
    public void beforeScenario(Scenario scenario) {

        scenarioTL.set(scenario);

        String featureName = getFeatureNameFromScenario(scenario);
        String scenarioName = sanitize(scenario.getName());
        String casePath = sanitize(featureName);

        featureNameTL.set(featureName);
        scenarioNameTL.set(scenarioName);
        casePathTL.set(casePath);

        ExtentTest globalTest = ExtentReportManagement.createTest(scenario.getName());
        ExtentTest featureTest = ExtentReportManagement.createFeatureTest(featureName, scenario.getName());


        Collection<String> tags = scenario.getSourceTagNames();

        for (String tag : tags) {
            String category = tag.replace("@", "");
            globalTest.assignCategory(category);
            featureTest.assignCategory(category);
        }

        globalTestTL.set(globalTest);
        featureTestTL.set(featureTest);

        TestExecutionContext.setReporter(new ExtentTestReporter());
        XrayTestContext.setCurrentTestKey(featureName);

        System.out.println("Inicio escenario: " + scenario.getName());
        System.out.println("Feature: " + featureName);
        System.out.println("CasePath: " + casePath);
        System.out.println("Tags: " + tags);
    }

    @After
    public void afterScenario(Scenario scenario) {
        ExtentTest globalTest = getTest();
        ExtentTest featureTest = getFeatureTest();

        if (globalTest == null) {
            throw new IllegalStateException("ExtentTest global no inicializado para: " + scenario.getName());
        }

        if (featureTest == null) {
            throw new IllegalStateException("ExtentTest por feature no inicializado para: " + scenario.getName());
        }

        XrayStatus scenarioStatus = XrayTestContext.getCurrentScenarioStatus();

        if (scenarioStatus == XrayStatus.FAIL) {
            XrayResultCollector.markFail(getFeatureName());
        } else if (scenario.isFailed()) {
            XrayResultCollector.markBlocked(getFeatureName());
        }

        if (scenario.isFailed()) {

            String screenshotBase64 = ScreenRecorder.takeScreenShotBase64();

            if (screenshotBase64 != null && !screenshotBase64.isEmpty()) {
                globalTest.fail("Escenario fallido: " + scenario.getName())
                        .addScreenCaptureFromBase64String(screenshotBase64, "Captura fallo");

                featureTest.fail("Escenario fallido: " + scenario.getName())
                        .addScreenCaptureFromBase64String(screenshotBase64, "Captura fallo");
            } else {
                globalTest.log(Status.FAIL, "Escenario fallido: " + scenario.getName());
                featureTest.log(Status.FAIL, "Escenario fallido: " + scenario.getName());
            }

        } else {
            globalTest.log(Status.PASS, "Escenario pasado: " + scenario.getName());
            featureTest.log(Status.PASS, "Escenario pasado: " + scenario.getName());
        }

        ExtentReportManagement.flush();


        globalTestTL.remove();
        featureTestTL.remove();
        scenarioTL.remove();
        featureNameTL.remove();
        scenarioNameTL.remove();
        casePathTL.remove();

        TestExecutionContext.clear();
        XrayTestContext.clear();

    }

    public static ExtentTest getTest() {
        return globalTestTL.get();
    }

    public static ExtentTest getFeatureTest() {
        return featureTestTL.get();
    }

    public static Scenario getScenario() {
        return scenarioTL.get();
    }

    public static String getScenarioName() {
        return scenarioNameTL.get();
    }

    public static String getFeatureName() {
        return featureNameTL.get();
    }

    public static String getCasePath() {
        return casePathTL.get();
    }

    private static String getFeatureNameFromScenario(Scenario scenario) {
        String path = scenario.getUri().getPath().replace("\\", "/");
        String fileName = path.substring(path.lastIndexOf('/') + 1);
        return fileName.replace(".feature", "");
    }

    private static String sanitize(String value) {
        if (value == null || value.trim().isEmpty()) {
            return "sin_nombre";
        }

        return value.replaceAll("[^a-zA-Z0-9._-]", "_");
    }

    public static void logInfo(String message) {
        if (getTest() != null) {
            getTest().log(Status.INFO, message);
        }

        if (getFeatureTest() != null) {
            getFeatureTest().log(Status.INFO, message);
        }
    }

    public static void logPass(String message) {
        if (getTest() != null) {
            getTest().log(Status.PASS, message);
        }

        if (getFeatureTest() != null) {
            getFeatureTest().log(Status.PASS, message);
        }
    }

    public static void logFail(String message) {
        if (getTest() != null) {
            getTest().log(Status.FAIL, message);
        }

        if (getFeatureTest() != null) {
            getFeatureTest().log(Status.FAIL, message);
        }
    }

    public static void logWarn(String message) {
        if (getTest() != null) {
            getTest().log(Status.WARNING, message);
        }

        if (getFeatureTest() != null) {
            getFeatureTest().log(Status.WARNING, message);
        }
    }


}
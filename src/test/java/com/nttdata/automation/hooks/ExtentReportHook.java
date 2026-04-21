package com.nttdata.automation.hooks;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.nttdata.automation.reports.ExtentReportManagement;
import com.nttdata.automation.reports.ScreenRecorder;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ExtentReportHook {

    private static final ThreadLocal<ExtentTest> testTL = new ThreadLocal<>();
    private static final ThreadLocal<Scenario> scenarioTL = new ThreadLocal<>();
    private static final ThreadLocal<String> featureNameTL = new ThreadLocal<>();
    private static final ThreadLocal<String> scenarioNameTL = new ThreadLocal<>();
    private static final ThreadLocal<String> casePathTL = new ThreadLocal<>();

    @Before
    public void beforeScenario(Scenario scenario) {
        scenarioTL.set(scenario);

        String featureName = getFeatureNameFromScenario(scenario);
        String scenarioName = sanitize(scenario.getName());
        String casePath = sanitize(featureName) + "/" + scenarioName;

        featureNameTL.set(featureName);
        scenarioNameTL.set(scenarioName);
        casePathTL.set(casePath);

        ExtentTest currentTest = ExtentReportManagement.createTest(scenario.getName());
        currentTest.assignCategory(featureName);

        testTL.set(currentTest);

        System.out.println("Inicio escenario: " + scenario.getName());
        System.out.println("Feature: " + featureName);
        System.out.println("CasePath: " + casePath);
    }

    @After
    public void afterScenario(Scenario scenario) {
        ExtentTest currentTest = getTest();

        if (currentTest == null) {
            throw new IllegalStateException("ExtentTest no inicializado para: " + scenario.getName());
        }

        if (scenario.isFailed()) {
            String img = ScreenRecorder.takeScreenShot(getCasePath(), "Escenario_fallido");

            if (!img.isEmpty()) {
                currentTest.fail("Escenario fallido: " + scenario.getName())
                        .addScreenCaptureFromPath(img);
            } else {
                currentTest.log(Status.FAIL, "Escenario fallido: " + scenario.getName());
            }
        } else {
            currentTest.log(Status.PASS, "Escenario pasado: " + scenario.getName());
        }

        ExtentReportManagement.flush();

        testTL.remove();
        scenarioTL.remove();
        featureNameTL.remove();
        scenarioNameTL.remove();
        casePathTL.remove();
    }

    public static ExtentTest getTest() {
        return testTL.get();
    }

    public static String getCasePath() {
        return casePathTL.get();
    }

    public static Scenario getScenario() {
        return scenarioTL.get();
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
}
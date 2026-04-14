package com.nttdata.automation.hooks;

import com.nttdata.automation.driver.DriverManager;
import com.nttdata.automation.reports.extentReportManagement;
import com.nttdata.automation.reports.screenRecorder;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ExtentReportHook {

    private static ExtentTest test;

    @Before
    public void beforeScenario (Scenario scenario){
        test = extentReportManagement.getInstance().createTest(scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario){
        if (scenario.isFailed()){
            test.log(Status.FAIL, "Escenario fallido: " + scenario.getName());
            screenRecorder.takeScreenShot(scenario, DriverManager.getDriver(), test);
        }else {
            test.log(Status.PASS, "Escenario pasado: " + scenario.getName());
        }
        extentReportManagement.getInstance().flush();
    }

    public static ExtentTest getTest(){
        return test;
    }
}

package utils.reports;

import base.wp_controlPanel_base_stepsCucumber;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class extentReportHook {

    private static ExtentTest test;

    @Before
    public void beforeScenario (Scenario scenario){
        test = extentReportManagement.getInstance().createTest(scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario){
        if (scenario.isFailed()){
            test.log(Status.FAIL, "Escenario fallido: " + scenario.getName());
            utils.reports.screenRecorder.takeScreenShot(scenario, wp_controlPanel_base_stepsCucumber.driver, test);
        }else {
            test.log(Status.PASS, "Escenario pasado: " + scenario.getName());
        }
        extentReportManagement.getInstance().flush();
    }

    public static ExtentTest getTest(){
        return test;
    }
}

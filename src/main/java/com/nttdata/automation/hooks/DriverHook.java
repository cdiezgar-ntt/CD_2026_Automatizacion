package com.nttdata.automation.hooks;

import com.nttdata.automation.driver.DriverManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class DriverHook {

    @Before
    public void setup() {
        DriverManager.initDriver();
    }

    @After
    public void teardown(Scenario scenario) {
        if (scenario.isFailed()) {
            // ExtentReports tomará este attach y lo pondrá en el reporte HTML automáticamente
            byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Captura de error: " + scenario.getName());
        }
        DriverManager.quitDriver();
    }
}
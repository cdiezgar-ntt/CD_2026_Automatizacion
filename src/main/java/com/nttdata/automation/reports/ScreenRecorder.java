package com.nttdata.automation.reports;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.nttdata.automation.driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenRecorder {

    public static String takeScreenShotBase64() {
        try {
            WebDriver driver = DriverManager.getDriver();

            if (driver instanceof TakesScreenshot) {
                return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
            }

            return "";

        } catch (Exception e) {
            System.out.println("No se pudo tomar screenshot en Base64: " + e.getMessage());
            return "";
        }
    }

}

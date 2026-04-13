package utils.reports;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screenRecorder {

    public static void takeScreenShot(Scenario scenario, WebDriver driver, ExtentTest extentTest){
        if (scenario.isFailed()){
            try {
                TakesScreenshot ts = (TakesScreenshot) driver;
                File source = ts.getScreenshotAs(OutputType.FILE);
                String screenshotName = scenario.getName().replaceAll(" ", "_") + ".png";
                //String destination = System.getProperty("src/output/screenShotsReport") + screenshotName;
                String destination = "src/output/screenShotsReport/" + screenshotName;
                System.out.println("Ruta destino imagen: " + destination);
                File finalDestination = new File(destination);
                FileUtils.copyFile(source, finalDestination);
                System.out.println("Insertada la imagen en screenShotReport");
                extentTest.fail("Escenario fallido - Captura de pantalla").addScreenCaptureFromPath("screenShotsReport/" + screenshotName);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}

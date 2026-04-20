package com.nttdata.automation.reports;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.nttdata.automation.driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenRecorder {

    private static final String BASE_REPORT = "test-output/ExtentReport/";
    private static final String BASE_IMAGENES = BASE_REPORT + "screenshots/";

    public static String takeScreenShot(String path, String nombre){

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS");
            String fecha = LocalDateTime.now().format(formatter);

            try {

                String fileName = nombre + "_" + fecha + ".png";

                File folder = new File(BASE_IMAGENES + path);
                if (!folder.exists()) {
                    folder.mkdirs();
                }

                File destinationFile = new File(folder, fileName);

                TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
                File source = ts.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(source, destinationFile);

                return "screenshots/" + path + "/" + fileName;

            }catch (IOException e){
                System.out.println("Excepción en el proceso de captura de la imagen:" + e);
                e.printStackTrace();
                return "";
            }
    }

}

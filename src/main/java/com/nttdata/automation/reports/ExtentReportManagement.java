package com.nttdata.automation.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.nttdata.automation.driver.DriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;

public class ExtentReportManagement {

    private static ExtentReports extent;
    private static final String REPORT_FOLDER = "test-output/ExtentReport";
    private static final String REPORT_PATH = REPORT_FOLDER + "/report.html";

    public static ExtentReports getInstance() {
        if (extent == null) {

            deleteHtmlFiles();

            File dir = new File(REPORT_FOLDER);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            System.out.println("Inicializando ExtentReports");
            System.out.println("Ruta report: " + REPORT_PATH);

            ExtentSparkReporter spark = new ExtentSparkReporter(REPORT_PATH);
            try {
                spark.loadXMLConfig("src/test/resources/spark-config.xml");
            } catch (IOException e) {
                System.out.println("Error al leer el fichero de configuracion de spark");
                e.printStackTrace();
            }

            extent = new ExtentReports();
            extent.attachReporter(spark);

            addRuntimeInfo(extent);

        }
        return extent;

    }


    public static ExtentTest createTest(String testName) {
        return getInstance().createTest(testName);
    }

    public static void flush() {
        if (extent != null) {
            extent.flush();
        }
    }

    private static void deleteHtmlFiles() {
        File folder = new File(REPORT_FOLDER);
        if (!folder.exists()) {
            return;
        }

        File[] files = folder.listFiles();
        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".html")) {
                boolean deleted = file.delete();
                System.out.println("Eliminando " + file.getPath() + " -> " + deleted);
            }
        }
    }

    private static void addRuntimeInfo(ExtentReports extent) {
        try {
            WebDriver driver = DriverManager.getDriver();

            if (driver instanceof RemoteWebDriver) {
                Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();

                extent.setSystemInfo("Browser", caps.getBrowserName());
                extent.setSystemInfo("Browser Version", caps.getBrowserVersion());
                extent.setSystemInfo("Platform", caps.getPlatformName().toString());
            }

        } catch (Exception e) {
            System.out.println("No se pudo obtener info del driver: " + e.getMessage());
        }

        // Info de sistema
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("OS Version", System.getProperty("os.version"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        extent.setSystemInfo("User", System.getProperty("user.name"));
        extent.setSystemInfo("Machine", System.getenv("COMPUTERNAME")); // Windows
    }
}
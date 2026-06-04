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
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class ExtentReportManagement {

    private static ExtentReports globalExtent;

    private static final Map<String, ExtentReports> featureReports = new ConcurrentHashMap<>();

    private static final String REPORT_FOLDER = "test-output/ExtentReport";
    private static final String GLOBAL_REPORT_PATH = REPORT_FOLDER + "/report.html";
    private static final String FEATURE_REPORTS_FOLDER = REPORT_FOLDER;

    private static final AtomicBoolean cleaned = new AtomicBoolean(false);

    public static synchronized ExtentReports getInstance() {
        cleanReportsOnce();

        if (globalExtent == null) {
            File dir = new File(REPORT_FOLDER);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            System.out.println("Inicializando ExtentReports global");
            System.out.println("Ruta report global: " + GLOBAL_REPORT_PATH);

            ExtentSparkReporter spark = new ExtentSparkReporter(GLOBAL_REPORT_PATH);
            loadSparkConfig(spark);

            globalExtent = new ExtentReports();
            globalExtent.attachReporter(spark);

            addRuntimeInfo(globalExtent);
        }

        return globalExtent;
    }

    public static ExtentTest createTest(String testName) {
        return getInstance().createTest(testName);
    }

    public static ExtentTest createFeatureTest(String featureName, String testName) {
        ExtentReports featureExtent = getFeatureReport(featureName);
        return featureExtent.createTest(testName);
    }

    private static ExtentReports getFeatureReport(String featureName) {
        cleanReportsOnce();

        return featureReports.computeIfAbsent(featureName, name -> {
            String featureReportPath = FEATURE_REPORTS_FOLDER + "/" + sanitize(name) + "_report.html";

            System.out.println("Inicializando ExtentReports para feature: " + name);
            System.out.println("Ruta report feature: " + featureReportPath);

            ExtentSparkReporter spark = new ExtentSparkReporter(featureReportPath);
            loadSparkConfig(spark);

            ExtentReports extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Feature", name);
            addRuntimeInfo(extent);

            return extent;
        });
    }

    public static synchronized void flush() {
        if (globalExtent != null) {

            globalExtent.flush();
        }

        for (ExtentReports report : featureReports.values()) {
            report.flush();
        }
    }

    public static synchronized void flushFeature(String featureName) {
        ExtentReports report = featureReports.get(featureName);

        if (report != null) {
            report.flush();
        }
    }

    private static void loadSparkConfig(ExtentSparkReporter spark) {
        try {
            spark.loadXMLConfig("src/test/resources/spark-config.xml");
        } catch (IOException e) {
            System.out.println("Error al leer el fichero de configuracion de spark");
            e.printStackTrace();
        }
    }

    private static void cleanReportsOnce() {
        if (!cleaned.compareAndSet(false, true)) {
            return;
        }

        try {
            Path reportPath = Path.of(REPORT_FOLDER);

            if (!Files.exists(reportPath)) {
                return;
            }

            Files.walk(reportPath)
                    .filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".html"))
                    .forEach(path -> {
                        try {
                            Files.delete(path);
                            System.out.println("Eliminando " + path);
                        } catch (IOException e) {
                            System.out.println("No se pudo eliminar " + path + ": " + e.getMessage());
                        }
                    });

        } catch (IOException e) {
            System.out.println("No se pudieron limpiar reportes anteriores: " + e.getMessage());
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

        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("OS Version", System.getProperty("os.version"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        extent.setSystemInfo("User", System.getProperty("user.name"));

        String machine = System.getenv("COMPUTERNAME");
        if (machine == null || machine.isBlank()) {
            machine = System.getenv("HOSTNAME");
        }

        extent.setSystemInfo("Machine", machine);
    }

    private static String sanitize(String value) {
        if (value == null || value.trim().isEmpty()) {
            return "sin_nombre";
        }

        return value.replaceAll("[^a-zA-Z0-9._-]", "_");
    }


}
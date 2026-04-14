package com.nttdata.automation.driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver() {
        if (driver.get() == null) {

            ChromeOptions options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.NONE);

            // Selenium Manager descarga y configura Chrome automáticamente
            driver.set(new ChromeDriver(options));
            driver.get().manage().window().maximize();
            System.out.println("Chrome abierto y maximizado");

            // Una espera implícita de seguridad (opcional, ya que usaremos explícitas)
            driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}

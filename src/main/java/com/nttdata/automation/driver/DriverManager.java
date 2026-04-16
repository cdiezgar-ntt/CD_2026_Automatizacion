package com.nttdata.automation.driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver() {
        if (driver.get() == null) {

            ChromeOptions options = new ChromeOptions();

            // Necesario para que funcione la carga del certificado
            // options.setPageLoadStrategy(PageLoadStrategy.NONE);

            // Selección del certificado
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("profile.managed_auto_select_certificate_for_urls",
                    List.of("{\"pattern\":\"https://[*.]redsara.es\",\"filter\":{\"SUBJECT\":{\"CN\":\"EIDAS CERTIFICADO PRUEBAS - 99999999R\"}}}"));
            options.setExperimentalOption("prefs", prefs);

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

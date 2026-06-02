package com.nttdata.automation.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class appiumDriver {
    private static AndroidDriver driver;

    public static void initDriver() {
        if (driver == null) {
            try {
                UiAutomator2Options options = new UiAutomator2Options();
                options.setPlatformName("Android");
                options.setAutomationName("UiAutomator2");

                //CONFIGURACIÓN PARA ARRANCAR EL EMULADOR AUTOMÁTICAMENTE
                // Reemplaza "Pixel_7_API_34" por el nombre exacto de tu emulador en Android Studio
                String nombreEmulador = "Pixel_7_Auto_2";
                options.setAvd(nombreEmulador);
                options.setDeviceName(nombreEmulador);

                // Tiempo máximo de espera para que el emulador encienda (3 minutos)
                options.setAvdLaunchTimeout(Duration.ofMinutes(3));

                // Ruta de tu aplicación .apk
                options.setApp(System.getProperty("user.dir") + "/src/test/resources/apps/cd_2026021101_pre.apk");
                options.setNewCommandTimeout(Duration.ofSeconds(60));

                options.setNoReset(true);
                // Inicializa el driver conectándose al servidor local de Appium
                driver = new AndroidDriver(new URL("http://localhost:4723"), options);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            } catch (MalformedURLException e) {
                throw new RuntimeException("Error crítico en la URL del servidor de Appium", e);
            }
        }
    }

    public static AndroidDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

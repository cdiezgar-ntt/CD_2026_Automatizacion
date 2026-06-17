package com.nttdata.automation.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class appiumDriver {
    private static AndroidDriver driverAndroid;

    public static void initDriver() {
        try {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName("Android");
            options.setAutomationName("UiAutomator2");

            String nombreEmulador = "Pixel_7_Auto_2";
            options.setAvd(nombreEmulador);
            options.setDeviceName(nombreEmulador);
            options.setAvdLaunchTimeout(Duration.ofMinutes(3));
            options.setApp("C:/apks/cd_2026061201_se_DEV.apk");
            options.setNewCommandTimeout(Duration.ofSeconds(60));

            //false borra datos y caché antes de iniciar
            options.setNoReset(false);

            //Evita reinstalar la app
            options.setFullReset(false);

            driverAndroid = new AndroidDriver(new URL("http://localhost:4723"), options);
            driverAndroid.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        } catch (MalformedURLException e) {
            throw new RuntimeException("Error crítico en la URL del servidor de Appium", e);
        }

    }

    public static AndroidDriver getDriver() {
        if (driverAndroid == null) {
            initDriver();
        }
        return driverAndroid;
    }

    public static void quitDriver() {
        if (driverAndroid != null) {
            driverAndroid.quit();
            driverAndroid = null;
        }
    }

    public static void resetDriver() {
        driverAndroid = null;
    }
}

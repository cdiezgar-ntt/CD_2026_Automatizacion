package com.nttdata.automation.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class androidInfraestructura {

    private static final String EMULATOR_NAME = "Pixel_7_Auto_2";

    public static void prepareAndroidEnvironment() {
        try {
            String sdkPath = System.getenv("ANDROID_HOME");
            if (sdkPath == null || sdkPath.isEmpty()) {
                throw new RuntimeException("[ERROR] No se detectó ANDROID_HOME en las variables de entorno de Windows. Reinicia IntelliJ.");
            }

            if (!isEmulatorRunning(sdkPath)) {
                System.out.println("[INFRAESTRUCTURA] Emulador apagado. Iniciando " + EMULATOR_NAME + "...");
                String emulatorCmd = sdkPath + File.separator + "emulator" + File.separator + "emulator.exe";

                // Ejecuta el emulador en un proceso independiente de Windows
                new ProcessBuilder("cmd.exe", "/c", emulatorCmd, "-avd", EMULATOR_NAME).start();

                // Bucle de espera activa hasta que adb detecte el dispositivo listo
                int intentos = 0;
                while (!isEmulatorRunning(sdkPath) && intentos < 12) {
                    Thread.sleep(5000); // Espera 5 segundos por intento (60s máximo)
                    intentos++;
                    System.out.println("[INFRAESTRUCTURA] Esperando arranque del emulador... (Intento " + intentos + "/12)");
                }
                System.out.println("[INFRAESTRUCTURA] Emulador encendido y listo.");
            } else {
                System.out.println("[INFRAESTRUCTURA] El emulador ya estaba encendido. Saltando arranque.");
            }

            if (!isAppiumRunning()) {
                System.out.println("[INFRAESTRUCTURA] Servidor Appium apagado. Levantando servicio...");

                // Ejecución directa de Appium mediante Node de forma robusta en Windows
                String appiumJsPath = System.getenv("APPDATA") + "\\npm\\node_modules\\appium\\build\\lib\\main.js";
                new ProcessBuilder("cmd.exe", "/c", "node", appiumJsPath).start();

                // Espera activa a que el puerto de Appium responda con HTTP 200
                int intentos = 0;
                while (!isAppiumRunning() && intentos < 10) {
                    Thread.sleep(2000); // Espera 2 segundos por intento
                    intentos++;
                    System.out.println("[INFRAESTRUCTURA] Esperando que Appium responda... (Intento " + intentos + "/10)");
                }
                System.out.println("[INFRAESTRUCTURA] Servidor Appium levantado y respondiendo.");
            } else {
                System.out.println("[INFRAESTRUCTURA] Appium ya está escuchando en el puerto 4723. Saltando arranque.");
            }

        } catch (Exception e) {
            System.err.println("[ERROR CRÍTICO] Fallo al gestionar la infraestructura: " + e.getMessage());
        }
    }

    /**
     * Comprueba mediante ADB si el dispositivo virtual se encuentra activo en Windows
     */
    private static boolean isEmulatorRunning(String sdkPath) throws Exception {
        String adbCmd = sdkPath + File.separator + "platform-tools" + File.separator + "adb.exe";
        Process p = new ProcessBuilder("cmd.exe", "/c", adbCmd + " devices").start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while ((line = r.readLine()) != null) {
            if (line.contains("emulator-") && line.contains("device")) {
                return true;
            }
        }
        return false;
    }

    /**
     * Comprueba mediante una petición de red si el puerto 4723 de Appium está activo
     */
    private static boolean isAppiumRunning() {
        try {
            URL url = new URL("http://127.0.0");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(1500);
            return connection.getResponseCode() == 200;
        } catch (Exception e) {
            return false;
        }
    }

}

package com.nttdata.automation.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class qr_manager {

    public void cambiarQrEnEmulador(String nombreArchivoQR) {
        File qrProyecto = new File("src/test/resources/qrs/" + nombreArchivoQR);

        String usuario = System.getProperty("user.name");
        String sistemaOperativo = System.getProperty("os.name").toLowerCase();

        File paredEmulador;
        if (sistemaOperativo.contains("win")) {
            paredEmulador = new File("C:/Users/" + usuario + "/.android/Toren/Toren_wall.png");
        } else {
            paredEmulador = new File("/Users/" + usuario + "/.android/Toren/Toren_wall.png");
        }

        try {
            if (qrProyecto.exists()) {
                paredEmulador.getParentFile().mkdirs();
                Files.copy(qrProyecto.toPath(), paredEmulador.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("QR cambiado a: " + nombreArchivoQR);
            } else {
                throw new RuntimeException("Error: No se encontró el archivo QR en: " + qrProyecto.getAbsolutePath());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error crítico al copiar el QR al emulador", e);
        }
    }

}

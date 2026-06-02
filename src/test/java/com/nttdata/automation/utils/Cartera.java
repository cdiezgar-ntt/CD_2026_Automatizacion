package com.nttdata.automation.utils;

import com.nttdata.automation.hooks.ExtentReportHook;
import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.time.Instant;

public class Cartera {

    private String email;
    private boolean cartera_creada = false;

    public Cartera() {
        this.email = generarEmail();
    }

    private String generarEmail() {
        return "carlos_qa_" + Instant.now().toEpochMilli() + "@email.com";
    }

    public void actualizarEmail() {
        email = generarEmail();
    }

    public boolean estaCreada() {
        return cartera_creada;
    }

    public String getEmail() {
        return email;
    }

    // TODO actualmente solo está disponible en el entorno de SE porque solo tenemos ese entorno.
    // WARNING depende complemtamente de que estén habilitados los mocks de envío de los OTP móvil y mail
    public void nuevaCartera() {
        ProcessBuilder pb = new ProcessBuilder(
                "cmd.exe",
                "/c",
                "bru run --env AEAD_SE --env-var email=" + email
        );

        pb.directory(new File("src/test/resources/bruno_collection"));
        pb.redirectErrorStream(true);
        pb.inheritIO();

        try {
            Process proceso = pb.start();
            int exitCode = proceso.waitFor();

            if (exitCode != 0) {
                cartera_creada = false;
                System.out.println(exitCode);
            } else {
                cartera_creada = true;
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            cartera_creada = false;
        }
    }
}

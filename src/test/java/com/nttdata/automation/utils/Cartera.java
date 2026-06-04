package com.nttdata.automation.utils;

import com.nttdata.automation.reports.Report;

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
        return "auto_qa_" + Instant.now().toEpochMilli() + "@email.com";
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

        Report.info("Creando nueva cartera para la prueba con email: " + email);

        //Elegimos el entorno de bruno que ejecuta la coleccion
        String entorno_bruno = new EnvironmentConfig(new PropertiesReader()).environmentProperty("bruno_environment");

        Report.info("Ejecutando colección de Bruno para generar la cartera...");
        ProcessBuilder pb = new ProcessBuilder(
                "cmd.exe",
                "/c",
                "bru run --env "+entorno_bruno+" --env-var email=" + email
        );

        pb.directory(new File("src/test/resources/bruno_collection"));
        pb.redirectErrorStream(true);
        pb.inheritIO();

        try {
            Process proceso = pb.start();
            int exitCode = proceso.waitFor();

            if (exitCode != 0) {
                cartera_creada = false;
                Report.warn("Se ha ejecutado la colección pero ha devuelto el código de error " + exitCode);
            } else {
                cartera_creada = true;
                Report.pass("Cartera creada correctamente");
            }
        } catch (IOException | InterruptedException e) {
            Report.fail("Problema encontrado en la ejecución de la coleccion. Causa: " + e.getMessage());
            throw new RuntimeException("Error al generar la cartera", e);
        }
    }
}

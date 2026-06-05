package com.nttdata.automation.utils;

import com.nttdata.automation.base.BasePageObject;
import com.nttdata.automation.pages.EAA_ControlPanel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CSV_Manager {

    // Las variables de configuración del archivo definidas aquí adentro
    private static final String RUTA_CSV = "src/test/resources/csvRevocacion/wallet_id.csv";
    private static final String CABECERA = "wallet_id";


    public static void inicializarArchivo() {
        try (FileWriter fw = new FileWriter(RUTA_CSV, false); // false = sobrescribir
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {

            pw.println(CABECERA);

        } catch (IOException e) {
            System.err.println("Error al inicializar el CSV: " + e.getMessage());
        }
    }

    public static void anadirId(String dato) {
        try (FileWriter fw = new FileWriter(RUTA_CSV, true); // true = append
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {

            if (dato != null && !dato.isEmpty()) {
                pw.println(dato.trim());
            }

        } catch (IOException e) {
            System.err.println("Error al escribir en el CSV: " + e.getMessage());
        }
    }

    public static void guardarListaIds() {
        BasePageObject bpo = new BasePageObject();
        List<String> ids = bpo.obtenerIdsCarteras();
        // Validamos que la lista contenga elementos
        if (ids == null || ids.isEmpty()) {
            System.out.println("Advertencia: La lista de IDs está vacía. Nada que escribir.");
            return;
        }

        try (FileWriter fw = new FileWriter(RUTA_CSV, true); // Modo append activo
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {

            // Recorremos directamente la lista de cadenas de texto
            for (String id : ids) {
                // Validamos que el ID no sea nulo o esté en blanco
                if (id != null && !id.trim().isEmpty()) {
                    pw.println(id.trim());
                }
            }

        } catch (IOException e) {
            System.err.println("Error al escribir los IDs en el CSV: " + e.getMessage());
        }
    }

}

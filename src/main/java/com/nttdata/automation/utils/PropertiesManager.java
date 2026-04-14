package com.nttdata.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {

    //private static String propertiesPath;
    private static String pantallaInicioPath;

    public PropertiesManager(){
        pantallaInicioPath = "elements/pages.properties";
    }


    public String readPropertiesPantallaInicio(String clave) {
        // Implementación para leer el archivo de propiedades
        // Puedes usar java.util.Properties para cargar el archivo y acceder a las propiedades
        Properties propiedades = new Properties();

        // Usamos FileInputStream para acceder al disco directamente
        try (FileInputStream fis = new FileInputStream(pantallaInicioPath)) {
            propiedades.load(fis);
            return propiedades.getProperty(clave);
        } catch (IOException e) {
            System.err.println("No se pudo leer el archivo en: " + pantallaInicioPath);
            e.printStackTrace();
            return null;
        }
    }

    public String readPropertiesFile(String propertiesPath, String clave) {
        // Implementación para leer el archivo de propiedades
        // Puedes usar java.util.Properties para cargar el archivo y acceder a las propiedades
        Properties propiedades = new Properties();

        // Usamos FileInputStream para acceder al disco directamente
        try (FileInputStream fis = new FileInputStream(propertiesPath)) {
            propiedades.load(fis);
            return propiedades.getProperty(clave);
        } catch (IOException e) {
            System.err.println("No se pudo leer el archivo en: " + propertiesPath);
            e.printStackTrace();
            return null;
        }
    }


}

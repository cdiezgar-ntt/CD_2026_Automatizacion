package com.nttdata.automation.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesReader {

    private final Map<String, Properties> cache = new HashMap<>();

    public String get(String resourcePath, String key) {
        java.util.Properties properties = cache.computeIfAbsent(resourcePath, this::load);

        String value = properties.getProperty(key);

        if (value == null) {
            throw new IllegalArgumentException(
                    "No existe la clave '" + key + "' en el fichero '" + resourcePath + "'"
            );
        }

        return value;
    }

    private java.util.Properties load(String resourcePath) {
        java.util.Properties properties = new java.util.Properties();

        try (InputStream input = getClass()
                .getClassLoader()
                .getResourceAsStream(resourcePath)) {

            if (input == null) {
                throw new IllegalArgumentException("No se encontró el fichero: " + resourcePath);
            }

            properties.load(input);
            return properties;

        } catch (IOException e) {
            throw new RuntimeException("Error leyendo properties: " + resourcePath, e);
        }
    }
}

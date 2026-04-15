package com.nttdata.automation.utils;

import java.util.HashMap;
import java.util.Map;

public class Properties {

    public static PropertiesManager pm = new PropertiesManager();

    public Map <Elementos_web, String> read_v2() {
        Map <Elementos_web, String> identificadores_elementos = new HashMap<Elementos_web, String>();

        System.out.println("Leyendo valores de properties para pantalla principal...");

        for(Elementos_web key: Elementos_web.values()) {
            // Convierto el elemento web a string
            String clave = key.toString();
            // Obtengo su valor de la lectura de las propiedades
            String valor = pm.readPropertiesPantallaInicio(clave);
            // Almaceno el par en el mapa y trazo log de lectura
            identificadores_elementos.put(key, valor);
            if (valor != null)
                System.out.println("Valor leído para "+clave+": " + valor);
        }

        return identificadores_elementos;
    }

}

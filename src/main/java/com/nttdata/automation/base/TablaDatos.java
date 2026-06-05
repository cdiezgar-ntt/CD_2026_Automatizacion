package com.nttdata.automation.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TablaDatos {

    private final List<String> headers;
    private final List<Map<String, WebElement>> filas;

    public TablaDatos(List<String> headers, List<Map<String, WebElement>> filas) {
        this.headers = headers;
        this.filas = filas;
    }

    public List<String> getHeaders() {
        return headers;
    }

    public List<Map<String, WebElement>> getFilas() {
        return filas;
    }

    public int getNumeroFilas() {
        return filas.size();
    }

    public boolean tieneColumna(String columna) {
        return headers.contains(columna);
    }

    public Map<String, WebElement> getFila(int filaIndex) {
        validarIndiceFila(filaIndex);
        return filas.get(filaIndex);
    }

    public Map<String, WebElement> getFila(int filaIndex, String... columnas) {
        validarIndiceFila(filaIndex);

        Map<String, WebElement> filaCompleta = filas.get(filaIndex);
        Map<String, WebElement> resultado = new LinkedHashMap<>();

        for (String columna : columnas) {
            validarColumna(columna);
            resultado.put(columna, filaCompleta.get(columna));
        }

        return resultado;
    }

    public Map<String, String> getTextosFila(int filaIndex, String... columnas) {
        Map<String, WebElement> fila = getFila(filaIndex, columnas);
        Map<String, String> resultado = new LinkedHashMap<>();

        fila.forEach((columna, celda) -> resultado.put(columna, textoLimpio(celda)));

        return resultado;
    }

    public WebElement getCelda(int filaIndex, String columna) {
        validarIndiceFila(filaIndex);
        validarColumna(columna);

        WebElement celda = filas.get(filaIndex).get(columna);

        if (celda == null) {
            throw new IllegalArgumentException(
                    "La fila " + filaIndex + " no contiene celda para la columna '" + columna + "'"
            );
        }

        return celda;
    }

    public String getTextoCelda(int filaIndex, String columna) {
        return textoLimpio(getCelda(filaIndex, columna));
    }

    public List<WebElement> getColumna(String columna) {
        validarColumna(columna);

        return filas.stream()
                .map(fila -> fila.get(columna))
                .toList();
    }

    public List<String> getTextosColumna(String columna) {
        return getColumna(columna).stream()
                .map(TablaDatos::textoLimpio)
                .toList();
    }

    public WebElement getElementoCelda(int filaIndex, String columna, By childLocator) {
        return getCelda(filaIndex, columna).findElement(childLocator);
    }

    public List<WebElement> getElementosCelda(int filaIndex, String columna, By childLocator) {
        return getCelda(filaIndex, columna).findElements(childLocator);
    }

    public Optional<WebElement> getElementoCeldaOpcional(int filaIndex, String columna, By childLocator) {
        List<WebElement> elementos = getElementosCelda(filaIndex, columna, childLocator);

        if (elementos.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(elementos.get(0));
    }

    private void validarIndiceFila(int filaIndex) {
        if (filaIndex < 0 || filaIndex >= filas.size()) {
            throw new IllegalArgumentException(
                    "Indice de fila invalido: " + filaIndex + ". Total filas: " + filas.size()
            );
        }
    }

    private void validarColumna(String columna) {
        if (!headers.contains(columna)) {
            throw new IllegalArgumentException(
                    "La columna '" + columna + "' no existe. Columnas disponibles: " + headers
            );
        }
    }

    private static String textoLimpio(WebElement element) {
        return element.getText().trim();
    }
}
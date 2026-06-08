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

    /**
     * Instancia un objeto TablaDatos a partir de las cabeceras, y una lista de filas. Este objeto expone una serie de metodos para extrer
     * distintas propiedades, acceder a objetos interiores, extraer columnas y filas de datos...
     * @param headers Listado de cabceceras de la tabla para hacer las asociaciones
     * @param filas Listado de filas con un mapa "cabecera, elemento web" paria hacer las asociaciones.
     */
    public TablaDatos(List<String> headers, List<Map<String, WebElement>> filas) {
        this.headers = headers;
        this.filas = filas;
    }

    /**
     * Permite obtener las cabeceras de una tabla de datos
     * @return Listado de cabeceras en texto de una tabla
     */
    public List<String> getHeaders() {
        return headers;
    }

    /**
     * Permite obtener un listado de las filas de una tabla, y después son accesibles a traves de su cabecera
     * @return un listado de filas que permite acceder a cada columna de la fila especificando la cabecera
     */
    public List<Map<String, WebElement>> getFilas() {
        return filas;
    }

    /**
     * Devuelve el número de filas de la tabla
     * @return El número de filas de la tabla
     */
    public int getNumeroFilas() {
        return filas.size();
    }

    /**
     * Comprueba si existe una columna en la tabla
     * @param columna EL nombre de la columna que se quiere comprobar
     * @return True si existe la columna, false en caso contrario
     */
    public boolean tieneColumna(String columna) {
        return headers.contains(columna);
    }

    /**
     * Devuelve los datos asociados a la fila introducida, y los devuelve accesibles por su cabecera
     * <p>Ejemplo de uso:</p>
     * <pre>{@code
        //Primero se crea la tabla de datos desde el BasePageObject
        TablaDatos tabla_wp = obtenerTablaDeDatos(locator_tabla);
        //Se llama al metodo para alojar un mapa 'cabecera-dato'
        Map <String, WebElement> fila_3 = tabla_wp.getFila(3);
        //Ahora se podría acceder a los datos de la fila
        String id_cartera_fila_3 = fila_3.get("ID Cartera");
     * }
     * }</pre>
     * @param filaIndex El índice de la fila que se quiere obtener
     * @return Un mapa Cabecera-Valor para la fila especificada, con los WebElement accesibles
     */
    public Map<String, WebElement> getFila(int filaIndex) {
        validarIndiceFila(filaIndex);
        return filas.get(filaIndex);
    }

    /**
     * Devuelve los datos asociados a la fila introducida, pero solo para las columnas especificadas.
     * <p>Ejemplo de uso:</p>
     * <pre>{@code
        //Primero se crea la tabla de datos desde el BasePageObject
        TablaDatos tabla_wp = obtenerTablaDeDatos(locator_tabla);
        //Se llama al metodo para alojar un mapa 'cabecera-dato' solo con las columnas ID Cartera y Email
        Map <String, WebElement> fila_3_filtrado_por_columnas = tabla_wp.getFila(3, new String[] {"ID Cartera", "Email"});
        //Ahora se podría acceder a los datos de la fila
        String id_cartera_fila_3 = fila_3.get("ID Cartera");
     * }
     * @param columnas Array de columnas que se quieren obtener
     * @return Un mapa Cabecera-Valor para la fila especificada solo con las columnas solicitadas, con los WebElement accesibles
     */
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

    /**
     * Devuelve los textos de una fila para las columnas especificadas.
     * @param filaIndex El índice de la fila
     * @param columnas Las columnas que se quieren extraer
     * @return Un mapa Cabecera-Valor para la fila especificada conteniendo el texto del WebElement en el valor
     */
    public Map<String, String> getTextosFila(int filaIndex, String... columnas) {
        Map<String, WebElement> fila = getFila(filaIndex, columnas);
        Map<String, String> resultado = new LinkedHashMap<>();

        fila.forEach((columna, celda) -> resultado.put(columna, textoLimpio(celda)));

        return resultado;
    }

    /**
     * Consulta el elemento web indicando el índice de la fila y el texto de la columna.
     * @param filaIndex El indice de la fila a consultar
     * @param columna El texto de la columna a consultar
     * @return Un WebElement con el elemento web listo para ser consultado
     */
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

    /**
     * Consulta el texto en una celda de la tabla por fila-columna
     * @param filaIndex El indice de la fila a consultar
     * @param columna El texto de la columna a consultar
     * @return El texto de la celda (filaIndex,columna)
     */
    public String getTextoCelda(int filaIndex, String columna) {
        return textoLimpio(getCelda(filaIndex, columna));
    }

    /**
     * Devuelve una lista con todos los elementos web de una columna especificada
     * @param columna El literal de la columna a consultar
     * @return Listado de WebElements en esa columna
     */
    public List<WebElement> getColumna(String columna) {
        validarColumna(columna);

        return filas.stream()
                .map(fila -> fila.get(columna))
                .toList();
    }

    /**
     * Obtiene los textos asociados a una columna entera
     * @param columna La columna para la que se quieren obtener los textos
     * @return Los textos en cada celda de la columna
     */
    public List<String> getTextosColumna(String columna) {
        return getColumna(columna).stream()
                .map(TablaDatos::textoLimpio)
                .toList();
    }

    /**
     * Obtiene un subelemento de una celda especificando el localizador hijo. Es útil cuando hay enlaces en celdas, botones, u otros que no son accesibles
     * en un primer nivel.
     *
     * <pre>{@code
        //Primero se crea la tabla de datos desde el BasePageObject
        TablaDatos tabla_wp = obtenerTablaDeDatos(locator_tabla);
        //Se llama al metodo para obtener un enlace. Se asume que en los .properties hay definido este elemento
        By enlace = tag("wp_enlace_tabla") //En el properties habrá: wp_enlace_tabla = a. Puede ser generico ya que el metodo filtrará por celda, no en toda la pagina
        WebElement enlace_fila_columna = tabla_wp.getElementoCelda(3, "ID Cartera", enlace);
        //Despues se podría pulsar
        pulsar(enlace_fila_cartera);
     * }
     * @param filaIndex El índice de fila.
     * @param columna El literal de la columna
     * @param childLocator El localizador By que identifica unívocamente el elemento dentro de la celda.
     * @return Un elemento web listo para ser manipulado
     */
    public WebElement getElementoCelda(int filaIndex, String columna, By childLocator) {
        return getCelda(filaIndex, columna).findElement(childLocator);
    }

    /**
     * Igual que getElementoCelda, pero para devolver multiples elementos hijos cuando el identificador By localiza varios elementos
     * @param filaIndex Él índice de fila
     * @param columna El literal de la columna
     * @param childLocator El localizador By que identifica varios elementos dentro de la celda
     * @return Un listado con los elementos web localizados
     */
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
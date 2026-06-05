package com.nttdata.automation.base;

import com.nttdata.automation.driver.DriverManager;
import com.nttdata.automation.reports.Report;
import com.nttdata.automation.utils.Commons;
import com.nttdata.automation.utils.EnvironmentConfig;
import com.nttdata.automation.utils.PropertiesReader;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//import utils.reports.extentReportHook;

import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Clase base de todos los page objects, que implementa métodos con acciones transversales sobre las páginas web,
 * tales como escribir, pulsar, obtener textos. Esta clase hace tiene una instancia del Web Driver que levanta DriverManager,
 * y por tanto tendra acceso directo a las funcionalidades de selenium para la realización de acciones sobre las páginas web.
 * <p>
 * El BasePageObject es, en ultima instancia, la clase que realiza las acciones sobre las páginas web, y puede entenderse como
 * la capa capa directa que implementa las acciones. Tiene además, esperas implícitas al implementar mecanismos que hacen uso
 * de las ExpectedConditions a través del WebDriverWait, haciéndolo lo más robusto posible ante esperas derivadas de lentitud de
 * carga de elementos.
 * <p>
 * Todos los PageObject específicos del proyecto en cuestión obtentrán acceso a los métodos internos por herencia directa.
 *
 * @author QA_CD2026
 * @version 1.0.0
 *
 */

public class BasePageObject {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private static final PropertiesReader propertiesReader = new PropertiesReader();
    private final String elementsFile;

    /**
     * Utiliza {@link #BasePageObject(String)} en su lugar.
     *
     * @deprecated Desde la versión que implementa ficheros propios con los localizadores de los elementos para cada página.
     * Este constructor se crea para dar soporte a los métodos de Validación que se utilizan desde los ficheros '.feature', pero
     * estos se tendrán que ir adaptando para usar la clase Validator en lugar de mezclar responsabilidades y propiedades del page
     * en los '.feature'
     *
     */

    @Deprecated
    public BasePageObject() {
        this("elements/all_elements.properties");
    }

    /**
     * Otorga acceso al pageobject que lo herede para realizar las acciones primitivas sobre los elementos declarados en el fichero
     * '.properties' que se pase por parámetro.
     *
     * <p>Ejemplo de uso:</p>
     * <pre>{@code
     *     public CIT_PortalUsuario() {
     *         super("elements/web_login.properties");
     *     }
     * }</pre>
     *
     * @param elementsFile Ruta relativa del fichero '.properties' donde se encuentren los locators del page object específico.
     *                     Ejemplo: elements/web_login.properties
     */
    protected BasePageObject(String elementsFile) {
        this.driver = DriverManager.getDriver();

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        this.elementsFile = elementsFile;

    }

    /**
     * Expone la url actual del navegador para relizar validaciones sobre la misma.
     *
     * @return La url de la ventana/pestaña activa en el contexto actual del navegador levantado por el Driver.
     */
    public String currentUrl() {
        Report.info("Obteniendo la url actual...");
        String currentUrl = driver.getCurrentUrl();
        Report.info("Url: " + currentUrl);
        return (currentUrl == null) ? "" : currentUrl;
    }

    /**
     * Realiza una llamada a la clase configuración para encontrar la url proporcionada en el entorno donde se ejecute
     * la prueba. Llama a la clase EnvironmentConfig para encontrar el entorno y buscar en el fichero de propiedades
     * correcto.
     *
     * @param key Clave de la url a obtener. Ejemplo: web_usuario
     * @return La url asociada a esa clave.
     */
    public String url(String key) {
        return new EnvironmentConfig(propertiesReader).environmentProperty(key);
    }


    /**
     * Helper base que se encarga de exponer el valor asociado a una clave en el fichero de propiedades con los localizadores
     * asociados a la página. Es privado ya que se utiliza unicamente para leer y exponer la propiedad, sin asumir un tipo de
     * localizador (xpath, id, ...)
     *
     * @param key La clave que identifica al objeto en el fichero de propiedades. Ejemplo: pantallaLogin_BotonAcceder
     * @return El valor asociado a la clave. Ejemplo: access_button
     * @throws IllegalStateException Si no se ha llamado al PageObjectBase con un fichero de propiedades.
     */
    private String element(String key) {
        if (elementsFile == null) {
            throw new IllegalStateException(
                    "Este Page Object no tiene fichero de elementos asociado"
            );
        }

        return propertiesReader.get(elementsFile, key);
    }

    /**
     * Helper que permite a cada pageObject obtener un reflejo de un elemento web localizado por el atributo ID en la página web
     *
     * @param key La clave que identifica al objeto en el fichero de propiedades.
     * @return Una instancia By del objeto que permite localizarlo físicamente en la página web.
     */
    protected By id(String key) {
        return By.id(element(key));
    }

    /**
     * Helper que permite a cada pageObject obtener un reflejo de un elemento web localizado por el atributo NAME en la página web
     *
     * @param key La clave que identifica al objeto en el fichero de propiedades.
     * @return Una instancia By del objeto que permite localizarlo físicamente en la página web.
     */
    protected By name(String key) {
        return By.name(element(key));
    }

    /**
     * Helper que permite a cada pageObject obtener un reflejo de un elemento web localizado por el XPATH (absoluto o relativo)
     * en la página web. Se aconseja por mantenibilidad el uso de xpath relativos en la medida de lo posible
     *
     * @param key La clave que identifica al objeto en el fichero de propiedades.
     * @return Una instancia By del objeto que permite localizarlo físicamente en la página web.
     */
    protected By xpath(String key) {
        return By.xpath(element(key));
    }

    /**
     * Helper que permite a cada pageObject obtener un reflejo de un elemento por la etiqueta html del objeto en el DOM. Útil
     * en los casos de etiquetas específicas, o cuando solo hay un Select en la página, o cuando se quieren obtener todos los
     * options de un select si se sabe que solo hay uno.
     *
     * @param key La clave que identifica al objeto en el fichero de propiedades.
     * @return Una instancia By del objeto que permite localizarlo físicamente en la página web.
     */
    protected By tag(String key) {
        return By.tagName(element(key));
    }

    /**
     * Helper que permite a cada pageObject obtener un reflejo de un elemento web localizado por su selector css. Útil cuando
     * se utilizan clases bien definidas y no autogeneradas por frameworks.
     *
     * @param key La clave que identifica al objeto en el fichero de propiedades.
     * @return Una instancia By del objeto que permite localizarlo físicamente en la página web.
     */
    protected By css(String key) {
        return By.cssSelector(element(key));
    }

    /**
     * Helper que permite a cada pageObject obtener un reflejo de un elemento web localizado por el CLASSNAME. Útil cuando la clase
     * es única y el elemento solo tiene esa clase
     *
     * @param key La clave que identifica al objeto en el fichero de propiedades.
     * @return Una instancia By del objeto que permite localizarlo físicamente en la página web.
     */
    protected By classname(String key) {
        return By.className(element(key));
    }

    /**
     * Metodo privado que implementa una espera implicita hasta que el elemento que se quiere pulsar sea interactuable
     *
     * @param localizador El By que identifica el objeto en la página web y devuelve un objeto que lo localiza
     * @return El Elemento web listo para interactuar con el
     */
    private WebElement obtenerElementoClickable(By localizador) {
        Report.info("Esperando que el elemento " + localizador + " sea clickable...");
        return wait.until(ExpectedConditions.elementToBeClickable(localizador));
    }

    /**
     * Metodo que permite a cada PageObject ejecutar un click sobre el elemento, pero implementando una espera implícita con el
     * timeout definido
     *
     * @param localizador El By que identifica el objeto en la página web y devuelve un objeto que lo localiza únivocamente.
     *                    Es importante que el localizador que se pase devuelva un único elemento para que haga click en el
     */
    protected void pulsar(By localizador) {
        Report.info("Se va a pulsar en: " + localizador);
        pulsar(obtenerElementoClickable(localizador));
    }

    /**
     * Metodo que se encarga de ejecutar un clíck en el elemento web proporcionado. Ejecuta un scroll hasta el elemento
     * previamente.
     *
     * @param we El elemento web sobre el que se quiere pulsar
     * @throws Exception Si el elemento no es interactuable en el momento de ejecutar el click
     * @warning No realiza ninguna espera implicita, por lo que la pulsión es inmediata, sea o no interactuable
     * el elemento proporcionado. Se aconseja el uso de pulsar(By localizador) en su lugar, ya que este primero,
     * llama a pulsar(we) con el elemento que localiza con la espera implícita.
     */
    public void pulsar(WebElement we) {
        try {
            hacerScroll(we);
            we.click();
        } catch (Exception e) {
            Report.fail("No se ha podido pulsar en el elemento. Causa: " + e.getMessage());
            throw new RuntimeException("Error al clicar", e);
        }
    }

    public void aceptarAlertaNavegador() {
        Commons.waitNseconds(3);
        Alert alerta = wait.until(ExpectedConditions.alertIsPresent());
        alerta.accept();
    }

    public void rechazarAlertaNavegador() {
        Alert alerta = wait.until(ExpectedConditions.alertIsPresent());
        alerta.dismiss();
    }

    protected void escribir(By localizador, String contenido) {
        escribir(obtenerElementoVisible(localizador), contenido);
    }

    protected void escribir(WebElement we, String contenido) {

        try {
            hacerScroll(we);
            we.clear();
            we.sendKeys(contenido);

        } catch (Exception e) {
            Report.fail("No se ha podido escribir el contenido. Causa: " + e.getMessage());
            throw new RuntimeException(
                    "Error al escribir el contenido: " + contenido, e
            );
        }
    }

    protected WebElement obtenerElementoVisible(By localizador) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(localizador)
        );
    }

    /**
     * Utiliza {@link #seleccionarDeLista(By, String)} en su lugar.
     *
     * @param elmentoWebString La clave asociada al elemento web
     * @param opcion           El value asociado al option en el identificador
     * @deprecated Desde que se implementa el metodo {@link #seleccionarDeLista(By, String)}, que es válido para todos los tipos de localizador
     * ya que se pasa el By. Este metodo solo es valido para id y además presupone conocer values internos en lugar
     * de los textos visibles.
     */

    @Deprecated
    public void seleccionComboById(String elmentoWebString, String opcion) {
        WebElement we;
        By localizador;
        try {
            localizador = id(elmentoWebString);
            System.out.println("Esperando a que el elemento sea visible...");
            we = wait.until(ExpectedConditions.visibilityOfElementLocated(localizador));
            //Scrollear hasta el elemento
            new Actions(driver).scrollToElement(we).perform();
            System.out.println("Rellenando combobox");
            Select comboBox = new Select(we);
            comboBox.selectByValue(opcion);
            //comboBox.selectByVisibleText(opcion);
            System.out.println("Combobox seleccionado: " + opcion);

        } catch (Exception e) {
            System.out.println("Excepción al seleccionar combo: " + e);
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * Utiliza {@link #seleccionarDeLista(By, String)} en su lugar.
     *
     * @param elmentoWebString La clave asociada al elemento web
     * @param opcion           El value asociado al option en el identificador
     * @deprecated Desde que se implementa el seleccionar de lista, que es válido para todos los tipos de localizador
     * ya que se pasa el By. Este metodo solo es valido para xpath y además presupone conocer values internos en lugar
     * de los textos visibles.
     */
    public void seleccionComboByxpath(String elmentoWebString, String opcion) {
        WebElement we;
        By localizador;
        try {
            localizador = xpath(elmentoWebString);
            System.out.println("Esperando a que el elemento sea visible...");
            we = wait.until(ExpectedConditions.visibilityOfElementLocated(localizador));
            //Scrollear hasta el elemento
            new Actions(driver).scrollToElement(we).perform();
            System.out.println("Rellenando combobox");
            Select comboBox = new Select(we);
            comboBox.selectByValue(opcion);
            //comboBox.selectByVisibleText(opcion);
            System.out.println("Combobox seleccionado: " + opcion);

        } catch (Exception e) {
            System.out.println("Excepción al seleccionar combo: " + e);
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * Se encarga de comparar el texto obtenido contra un texto esperado. Únicamente valida igualdad de textos, por lo
     * que es muy limitado. Desaparecerá en futuras versiones.
     *
     * @param id1    La clave asociada al elemento web
     * @param tipo   El tipo del elemento web. Posibles valores {xpath, classname, id, tagname, name}
     * @param valor1 Valor esperado del elemento
     * @deprecated Desde que se implementa la clase Validator, que tiene metodos para validar expresiones agnósticas de
     * conocer ningún identificador interno de los elementos, ni el tipo de localizador, y que son válidos para todos los
     * tipos de validaciones, ya que se pasa por parametro una expresion booleana desde el test.
     */

    public void validarCampoDeTipo(String id1, String tipo, String valor1) {

        String tipoSwitch = tipo.toLowerCase().trim();
        String textoElemento = "";
        WebElement we;
        By localizador;
        switch (tipoSwitch) {
            case "xpath":
                localizador = xpath(id1);

                System.out.println("Esperando a que el elemento sea visible...");
                we = wait.until(ExpectedConditions.visibilityOfElementLocated(localizador));
                System.out.println("Obteniendo texto del elemento...");
                textoElemento = we.getText();
                break;
            case "classname":
                localizador = classname(id1);
                System.out.println("Esperando a que el elemento sea visible...");
                we = wait.until(ExpectedConditions.visibilityOfElementLocated(localizador));
                System.out.println("Obteniendo texto del elemento...");
                textoElemento = we.getText();
                break;
            case "id":
                localizador = id(id1);
                System.out.println("Esperando a que el elemento sea visible...");
                we = wait.until(ExpectedConditions.visibilityOfElementLocated(localizador));
                System.out.println("Obteniendo texto del elemento...");
                textoElemento = we.getText();
                break;
            case "tagname":
                localizador = tag(id1);

                System.out.println("Esperando a que el elemento sea visible...");
                we = wait.until(ExpectedConditions.visibilityOfElementLocated(localizador));
                System.out.println("Obteniendo texto del elemento...");
                textoElemento = we.getText();
                break;
            case "tag":
                localizador = tag(id1);

                System.out.println("Esperando a que el elemento sea visible...");
                we = wait.until(ExpectedConditions.visibilityOfElementLocated(localizador));
                System.out.println("Obteniendo texto del elemento...");
                textoElemento = we.getText();
                break;
            case "name":
                localizador = name(id1);

                System.out.println("Esperando a que el elemento sea visible...");
                we = wait.until(ExpectedConditions.visibilityOfElementLocated(localizador));
                System.out.println("Obteniendo texto del elemento...");
                textoElemento = we.getText();
                break;
            default:
                System.out.println("Tipo de localizador no reconocido: " + tipo);
                throw new IllegalArgumentException("Tipo de localizador no reconocido: " + tipo);
        }
        // Validar
        try {
            assertEquals("El campo no coincide", valor1, textoElemento);
        } catch (AssertionError e) {
            System.out.println("Error de validación: " + e.getMessage());
            throw e;
        }

    }

    /**
     * Se encarga de exponer un listado con los textos que hay contenidos dentro del conjunto de elementos web
     * representados por el localizador, a todos los niveles.
     * <p>
     * Si el localizador solo representase un elemento web, su texto seria accesible de forma inmediata con getFirst() de la
     * clase java.util.List.
     *
     * @param localizador El By que representa el listado de objetos web asociados, o el objeto web asociado.
     * @return La lista de textos contenidos en cada uno de los objetos web expuestos por el localizador
     *
     * <p>Ejemplo de uso con varios localizadores en el pageobject:</p>
     * <pre>{@code
     *     public List <String> obtenerListaErrores() {
     *          return obtenerTextosElementosWeb(by_errores);
     *     }
     * }</pre>
     * <p>Ejemplo de uso con un localizador:</p>
     * <pre>{@code
     *     public String obtenerNumeroPersonas() {
     *          return obtenerTextosElementosWeb(by_numero_personas).getFirst();
     *     }
     * }</pre>
     */
    protected List<String> obtenerTextosElementosWeb(By localizador) {
        try {
            List<WebElement> we = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(localizador));
            hacerScroll(we.getFirst());
            List<String> textos = we.stream().map(WebElement::getText).toList();
            return we.stream().map(WebElement::getText).collect(Collectors.toList());
        } catch (Exception e) {
            Report.fail("No se han encontrado textos asociados. Causa: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public String obtenerTextoElementoWeb(WebElement w) {
        try {
            return w.getText();
        } catch (Exception e) {
            Report.fail("No se ha podido obtener el texto. Causa: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * Se encarga de hacer click en un elemento de una lista en función del texto proporcionado. Para listas, tener en
     * cuenta que antes se debe hacer click en la lista para desplegarla, puesto que si no, se devolverá un timeout por
     * elemento no visible o no interactuable
     *
     * @param localizador El By del elemento proporcionado desde el PageObject particular
     * @param opcion      El texto de la opcion visible en el desplegable. Debe ser exacto.
     * @throws Exception si el elemento no es visible o interactuable
     */
    protected void seleccionarDeLista(By localizador, String opcion) {
        try {
            List<WebElement> we = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(localizador));
            List<WebElement> we_filtrados = we.stream().filter(e -> e.getText().contentEquals(opcion)).toList();

            if (we_filtrados.size() > 1) {
                Report.warn("La lista tiene más de un elemento. Por defecto se va a pulsar en el primero...");
            }

            WebElement we_a_pulsar = wait.until(ExpectedConditions.elementToBeClickable(we_filtrados.getFirst()));
            we_a_pulsar.click();

        } catch (Exception e) {
            Report.fail("No se ha podido pulsar en el elemento. Causa:" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public boolean esVisibleEnPantalla(By locator) {
        try {
            WebElement we = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return we.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean existeElAtributoEnElElemento(WebElement we, String atr) {
        try {
            String atr_str = we.getDomAttribute(atr);
            return atr_str != null;
        } catch (Exception e) {
            return false;
        }
    }


    private void hacerScroll(WebElement we) {
        new Actions(driver).scrollToElement(we).perform();
    }

    public String guardarTextoDeUnCampoXpath(By localizador) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(localizador));
        String dato = driver.findElement(localizador).getText();
        System.out.println("El dato guardado es: " + dato);
        return dato;
    }


    protected TablaDatos obtenerTablaDeDatos(By tableLocator) {

        WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(tableLocator));

        List<String> headers = table.findElements(By.cssSelector("thead th"))
                .stream()
                .map(WebElement::getText)
                .map(String::trim)
                .toList();

        List<WebElement> rows = table.findElements(By.cssSelector("tbody tr"));

        List<Map<String, WebElement>> filas = rows.stream()
                .map(row -> {
                    List<WebElement> cells = row.findElements(By.tagName("td"));

                    Map<String, WebElement> fila = new LinkedHashMap<>();

                    for (int i = 0; i < headers.size(); i++) {
                        if (cells.size() > i) {
                            fila.put(headers.get(i), cells.get(i));
                        }
                    }

                    return fila;
                })
                .toList();

        return new TablaDatos(headers, filas);
    }

    protected List<String> obtenerTextosColumnaTabla(By locator, String columna) {
        return obtenerTablaDeDatos(locator).getTextosColumna(columna);
    }

    protected List<WebElement> obtenerEnlacesColumnaTabla(By locator, String columna) {
        return obtenerTablaDeDatos(locator).getColumna(columna)
                .stream()
                .map(celda -> celda.findElement(By.tagName("a")))
                .toList();
    }

    protected String obtenerTextoCeldaTabla(By locator, int filaIndex, String columna) {
        return obtenerTablaDeDatos(locator).getTextoCelda(filaIndex, columna);
    }

    protected WebElement obtenerElementoCeldaTabla(By locator, int filaIndex, String columna, By childLocator) {
        return obtenerTablaDeDatos(locator).getElementoCelda(filaIndex, columna, childLocator);
    }

    public List<String> obtenerIdsCarteras() {
        By tabla_credenciales = tag("eaa_tabla_credenciales");
        return obtenerTextosColumnaTabla(tabla_credenciales, "ID Cartera");
    }

}

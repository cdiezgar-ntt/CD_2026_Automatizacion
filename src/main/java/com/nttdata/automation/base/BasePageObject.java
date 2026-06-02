package com.nttdata.automation.base;

import com.nttdata.automation.driver.DriverManager;
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
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class BasePageObject {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private static final PropertiesReader propertiesReader = new PropertiesReader();
    private final String elementsFile;

    public BasePageObject() {
        this("elements/all_elements.properties");
    }

    protected BasePageObject(String elementsFile) {
        this.driver = DriverManager.getDriver();

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        this.elementsFile = elementsFile;

    }

    public String currentUrl() {
        String currentUrl = driver.getCurrentUrl();
        return (currentUrl == null) ? "" : currentUrl;
    }

    public String url(String key) {
        return new EnvironmentConfig(propertiesReader).environmentProperty(key);
    }

    protected String element(String key) {
        if (elementsFile == null) {
            throw new IllegalStateException(
                    "Este Page Object no tiene fichero de elementos asociado"
            );
        }

        return propertiesReader.get(elementsFile, key);
    }

    protected By id(String key) {
        return By.id(element(key));
    }

    protected By name(String key) {
        return By.name(element(key));
    }

    protected By xpath(String key) {
        return By.xpath(element(key));
    }

    protected By tag(String key) {
        return By.tagName(element(key));
    }

    protected By css(String key) {
        return By.cssSelector(element(key));
    }

    protected By classname(String key) {
        return By.className(element(key));
    }

    private WebElement obtenerElementoClickable(By localizador) {
        return wait.until(ExpectedConditions.elementToBeClickable(localizador));
    }

    protected void pulsar(By localizador) {
        pulsar(obtenerElementoClickable(localizador));
    }

    public void pulsar(WebElement we) {
        try {
            new Actions(driver).scrollToElement(we).perform();
            we.click();
        } catch (Exception e) {
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

            new Actions(driver)
                    .scrollToElement(we)
                    .perform();

            we.clear();

            we.sendKeys(contenido);

        } catch (Exception e) {

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

    public void seleccionComboById(String elmentoWebString, String opcion) {
        WebElement we;
        By localizador;
        try{
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

        }catch (Exception e){
            System.out.println("Excepción al seleccionar combo: " + e);
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void seleccionComboByxpath(String elmentoWebString, String opcion) {
        WebElement we;
        By localizador;
        try{
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

        }catch (Exception e){
            System.out.println("Excepción al seleccionar combo: " + e);
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void webDriverWaitUntil(int time, String xpath ) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

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
        try{
            assertEquals("El campo no coincide", valor1, textoElemento);
        }
        catch (AssertionError e){
            System.out.println("Error de validación: " + e.getMessage());
            throw e;
        }


    }

    protected List<String> obtenerTextosElementosWeb(By localizador) {
        try {
            List <WebElement> we = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(localizador));
            hacerScroll(we.getFirst());
            return we.stream().map(WebElement::getText).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected void seleccionarDeLista(By localizador, String opcion) {
        try {
            System.out.println("Esperando a que los elementos sean visibles");

            List <WebElement> we = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(localizador));
            List <WebElement> we_filtrados = we.stream().filter(e -> e.getText().contentEquals(opcion)).toList();

            if (we_filtrados.size() > 1) {
                System.out.println("La lista tiene más de un elemento, se pulsará en el primero...");
            }

            WebElement we_a_pulsar = wait.until(ExpectedConditions.elementToBeClickable(we_filtrados.getFirst()));
            we_a_pulsar.click();

        } catch (Exception e) {
            System.out.println("Excepción al seleccionar de la lista la opción " +opcion+ ":" + e);
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public boolean esVisibleEnPantalla(By locator) {
        try {
            WebElement we = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return we.isDisplayed();
        } catch(Exception e) {
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

}

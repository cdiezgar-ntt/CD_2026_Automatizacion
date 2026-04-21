package com.nttdata.automation.base;

import com.nttdata.automation.driver.DriverManager;
import com.nttdata.automation.utils.Elementos_web;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.nttdata.automation.utils.Properties;

//import utils.reports.extentReportHook;

import java.lang.runtime.SwitchBootstraps;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class BasePageObject {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Map<Elementos_web, String> prop;

    public BasePageObject() {
        this.driver = DriverManager.getDriver();
        // Espera explícita genérica de 10 segundos
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Se cargan los identificadores de todos los objetos web y se preparan para ser utilizados
        this.prop = new Properties().read_v2();

    }

    public void abrirWebPortalUsuario(){
        driver.get(prop.get(Elementos_web.abrirWebUsuario));
    }

    public void abrirWebPortalAdministrador_WP(){
        driver.get(prop.get(Elementos_web.abrirWebWalletProvider));
    }

    public void abrirWebPortalAdministrador_EEAProvider(){
        driver.get(prop.get(Elementos_web.abrirWebEAAProvider));
    }

    public void abrirWebPortalAdministrador_PIDProvider(){
        driver.get(prop.get(Elementos_web.abrirWebPIDProvider));
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

    protected void escribir(By localizador, String contenido) {
        try {
            System.out.println("Esperando a que el elemento sea visible...");
            WebElement we = wait.until(ExpectedConditions.visibilityOfElementLocated(localizador));
            //Scrollear hasta el elemento
            System.out.println("Prueba borrar visibilidad de elemento");
            new Actions(driver).scrollToElement(we).perform();
            we.clear();
            we.sendKeys(contenido);

            System.out.println("Escrito: " + contenido);
        } catch (Exception e) {
            System.out.println("Excepción al escribir: " + e);
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void seleccionComboById(String elmentoWebString, String opcion) {
        WebElement we;
        By localizador;
        try{
            localizador = By.id(prop.get(Elementos_web.valueOf(elmentoWebString)));
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
                localizador = By.xpath(prop.get(Elementos_web.valueOf(id1)));

                System.out.println("Esperando a que el elemento sea visible...");
                we = wait.until(ExpectedConditions.visibilityOfElementLocated(localizador));
                System.out.println("Obteniendo texto del elemento...");
                textoElemento = we.getText();
                break;
            case "classname":
                localizador = By.className(prop.get(Elementos_web.valueOf(id1)));
                System.out.println("Esperando a que el elemento sea visible...");
                we = wait.until(ExpectedConditions.visibilityOfElementLocated(localizador));
                System.out.println("Obteniendo texto del elemento...");
                textoElemento = we.getText();
                break;
            case "id":
                localizador = By.id(prop.get(Elementos_web.valueOf(id1)));

                System.out.println("Esperando a que el elemento sea visible...");
                we = wait.until(ExpectedConditions.visibilityOfElementLocated(localizador));
                System.out.println("Obteniendo texto del elemento...");
                textoElemento = we.getText();
                break;
            case "tagname":
                localizador = By.tagName(prop.get(Elementos_web.valueOf(id1)));

                System.out.println("Esperando a que el elemento sea visible...");
                we = wait.until(ExpectedConditions.visibilityOfElementLocated(localizador));
                System.out.println("Obteniendo texto del elemento...");
                textoElemento = we.getText();
                break;
            case "name":
                localizador = By.name(prop.get(Elementos_web.valueOf(id1)));

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
            System.out.println("Esperando a que los elementos sean visibles");
            List <WebElement> we = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(localizador));
            hacerScroll(we.getFirst());
            return we.stream().map(WebElement::getText).collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Excepción al obtener textos: " + e);
            e.printStackTrace();
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
            System.out.println("El atributo " + atr + " tiene el valor " + atr_str);
            return atr_str != null;
        } catch (Exception e) {
            System.out.println("Excepción: el elemento es nulo");
            e.printStackTrace();
            return false;
        }
    }

    private void hacerScroll(WebElement we) {
        new Actions(driver).scrollToElement(we).perform();
    }

}

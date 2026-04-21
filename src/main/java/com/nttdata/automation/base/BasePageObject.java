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

    public void abrirWeb(){
        driver.get(prop.get(Elementos_web.abrirWeb));
    }

    protected void pulsar(By localizador) {
        try {
            System.out.println("1. Esperando a que el elemento sea clickable...");
            wait.until(ExpectedConditions.elementToBeClickable(localizador));

            System.out.println("2. Localizando elemento...");
            WebElement we = driver.findElement(localizador);

            //Scrollear hasta el elemento
            new Actions(driver).scrollToElement(we).perform();
            System.out.println("3. Haciendo click...");
            we.click();

        } catch (Exception e) {
            System.out.println("Excepción al clicar: " + e);
            e.printStackTrace();
            throw new RuntimeException(e);
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

    protected void seleccionCombo(By localizador, String opcion) {
        try{
            System.out.println("Esperando a que el elemento sea visible...");
            WebElement we = wait.until(ExpectedConditions.visibilityOfElementLocated(localizador));
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

}

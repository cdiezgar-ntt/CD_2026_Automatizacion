package com.nttdata.automation.base;

import com.nttdata.automation.driver.DriverManager;
import com.nttdata.automation.utils.Elementos_web;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.nttdata.automation.utils.Properties;

//import utils.reports.extentReportHook;

import java.time.Duration;
import java.util.Map;

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

    protected void pulsar(By localizador) {
        try {
            System.out.println("1. Esperando a que el elemento sea clickable...");
            wait.until(ExpectedConditions.elementToBeClickable(localizador));

            System.out.println("2. Localizando elemento...");
            WebElement we = driver.findElement(localizador);

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
            we.clear();
            we.sendKeys(contenido);
            System.out.println("Escrito: " + contenido);
        } catch (Exception e) {
            System.out.println("Excepción al escribir: " + e);
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void webDriverWaitUntil(int time, String xpath ) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public void validarCampo(String id1, String valor1) {

        By localizador = By.className(prop.get(Elementos_web.valueOf(id1)));

        System.out.println("Esperando a que el elemento sea visible...");
        WebElement we = wait.until(ExpectedConditions.visibilityOfElementLocated(localizador));
        System.out.println("Obteniendo texto del elemento...");
        String textoElemento = we.getText();

        // Validar
        try{
            assertEquals("El campo no coincide", valor1, textoElemento);
            System.out.println("Validación correcta: el campo coincide con el valor esperado.");
        }
        catch (AssertionError e){
            System.out.println("Error de validación: " + e.getMessage());
            throw e;
        }
    }




}

package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObject.wp_controlPanel;
import utils.properties;
import utils.propertiesManager;
import utils.webdriver_Utils;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        WebDriver driver;

        properties prop = new properties();
        prop.readPantallaPrincipalPaths();

        webdriver_Utils utils = new webdriver_Utils();
        base.basePageObject base = new base.basePageObject();

        System.setProperty("webdriver.chrome.driver", "elements/drivers/chromedriver.exe");

        // Opciones de Chrome
        ChromeOptions options = new ChromeOptions();
        // Iniciar ChromeDriver
        driver = new ChromeDriver(options);

        //wp_controlPanel controlPanel = new wp_controlPanel(driver);

        driver.manage().window().maximize();

        driver.get("https://pre-wp-cd.redsara.es/control-panel/");

        wp_controlPanel wp_cp = new wp_controlPanel(driver);

        //driver.findElement(by xpath "/html/body/app-root/div/div/app-home/div[1]/div[3]/div[1]/div[2]/a").click();
        //driver.findElement(By.xpath(prop.pantallaInicio_BotonBuscar)).click();
        wp_cp.clickBtnBuscar();
        System.out.println("Botón buscar clickeado");
        wp_cp.clickPrimerElementoLista();
        //utils.webDriverWaitUntil(5, driver, prop.pantallaInicio_PrimerElementoTabla );
        //driver.findElement(By.xpath(prop.pantallaInicio_PrimerElementoTabla)).isDisplayed();
        System.out.println("Primer elemento de la tabla encontrado");



        //driver.quit();
    }
}
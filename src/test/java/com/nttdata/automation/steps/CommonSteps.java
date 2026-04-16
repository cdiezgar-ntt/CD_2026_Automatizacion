package com.nttdata.automation.steps;

import com.nttdata.automation.base.BasePageObject;
import com.nttdata.automation.driver.DriverManager;
import com.nttdata.automation.pages.Login;
import com.nttdata.automation.utils.Commons;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import com.nttdata.automation.pages.WP_ControlPanel;
import com.nttdata.automation.hooks.ExtentReportHook;

import java.awt.*;
import java.awt.event.KeyEvent;

public class CommonSteps {

    Login login;

    public CommonSteps() {
        login = new Login();
    }

    WebDriver driver = DriverManager.getDriver();

    @Given("Abrir la web {string}")
    public void abrirElNavegadorChrome(String web) {

        // Abre la página: driver.get("https://pre-wp-cd.redsara.es/control-panel/");
        driver.get(web);
        ExtentReportHook.getTest().info("Conectados a la web" + web);

        //

    }

    @And("Esperar 5 segundos")
    public void esperarSegundos() {
        try {
            ExtentReportHook.getTest().info("Esperando 5 segundos");
            Commons.wait5seconds();
            //ExtentReportHook.getTest().info("Espera finalizada");
        } catch (InterruptedException e) {
            System.out.println("Excepción en la espera:" + e);
        }
    }

    @When("Click en el botón acceder")
    public void hacerClickEnElBotonAcceder() {
        System.out.println("Se va a clicar en acceder");

        login.clickBtnAcceder();

        // Espera de 5 segundos para que le de tiempo a elegir el certificado
        esperarSegundos();
        esperarSegundos();
        esperarSegundos();

    }

    @And("Intro en certificado")
    public void introCertificado() {
        try {
            // Robot para controlar modales nativas, no del código
            Robot robot = new Robot();
            String hola = "Hola";
            Thread.sleep(2000);
            System.out.println("Tiempo esperado pulsando botón");

            // Simular Enter para confirmar la selección del primer certificado
            // TODO investigar como se puede hacer para no seleccionar siempre el primero
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            System.out.println("Botón pulsado");

        } catch (Exception e) {
            System.out.println("Excepción al seleccionar certificado: " + e);
        }
    }

    @Then("Validar que el campo {string} tiene el valor {string}")
    public void validarQueElCampoTieneElValor(String id, String valor) {
        BasePageObject bpo = new BasePageObject();
        bpo.validarCampo(id, valor);
    }

    @And("Cerrar el navegador")
    public void cerrarElNavegador() {
        DriverManager.quitDriver();
        System.out.println("Navegador cerrado");
        ExtentReportHook.getTest().info("Navegador cerrado");
    }
}

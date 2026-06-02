package com.nttdata.automation.steps;

import com.nttdata.automation.base.BasePageObject;
import com.nttdata.automation.driver.DriverManager;
import com.nttdata.automation.hooks.ExtentReportHook;
import com.nttdata.automation.pages.Login;
import com.nttdata.automation.utils.Cartera;
import com.nttdata.automation.utils.Commons;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class CommonSteps {

    Login login;

    private final Cartera cartera;

    public CommonSteps(Cartera cartera) {
        login = new Login();
        this.cartera = cartera;
    }

    WebDriver driver = DriverManager.getDriver();

    /**
     * @description Método para abrir el navegador y navegar a la URL del portal de usuario, wallet provider, EAA provider o PID provider dependiendo del escenario
     */
    @Given("Abrir la web usuario")
    public void abrirElNavegadorChrome_PortalUsuario() {
        login.abrirWebPortalUsuario();
        ExtentReportHook.getTest().info("Conectados a la web");
    }

    /**
     * @description Método para abrir el navegador y navegar a la URL del portal de wallet provider
     */
    @Given("Abrir la web wallet provider")
    public void abrirElNavegadorChrome_PortalWalletProvider() {
        login.abrirWebPortalAdministrador_WP();
        ExtentReportHook.getTest().info("Conectados a la web");
    }

    /**
     * @description Método para abrir el navegador y navegar a la URL del portal de EAA provider
     */
    @Given("Abrir la web EAA provider")
    public void abrirElNavegadorChrome_PortalEAAProvider() {
        ExtentReportHook.getTest().info("Conectando...");
        login.abrirWebPortalAdministrador_EEAProvider();

        ExtentReportHook.getTest().info("Autenticando...");
        hacerClickEnElBotonAcceder();

        if (login.currentUrl().endsWith("/auth/callback")) {
            ExtentReportHook.getTest().info("Aparece acceso a pagina no segura. Aceptando acceso...");
            login.clickAccederTodosModos();
        }
    }

    /**
     * @description Método para abrir el navegador y navegar a la URL del portal de PID provider
     */
    @Given("Abrir la web PID provider")
    public void abrirElNavegadorChrome_PortalPIDProvider() {
        ExtentReportHook.getTest().info("Conectando...");
        login.abrirWebPortalAdministrador_PIDProvider();

        ExtentReportHook.getTest().info("Autenticando...");
        hacerClickEnElBotonAcceder();

        //Ahora mismo aparece pagina de información no segura
        if (login.currentUrl().endsWith("/auth/callback")) {
            ExtentReportHook.getTest().info("Aparece acceso a pagina no segura. Aceptando acceso...");
            login.clickAccederTodosModos();
        }
    }


    /**
     * @description Método para esperar 5 segundos, utilizado principalmente para dar tiempo a que se carguen elementos o para esperar a que se abra el modal de selección de certificado
     */
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

    /**
     * @description Método para hacer click en el botón "Acceder" de la pantalla de login, que abre el modal de selección de certificado
     */
    @When("Click en el botón acceder")
    public void hacerClickEnElBotonAcceder() {
        System.out.println("Se va a clicar en acceder");

        login.clickBtnAcceder();

    }

    /**
     * @description Método para simular la pulsación de la tecla "Enter" para confirmar la selección del certificado en el modal nativo de selección de certificado
     */
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

    /**
     * @description Método para validar que un campo de la pantalla tiene un valor concreto, se le pasa el id del campo, el tipo (input, select o textarea) y el valor a validar
     * @param id: String con el id del campo a validar
     * @param tipo: String con el tipo del campo a validar (input, select o textarea)
     * @param valor: String con el valor a validar en el campo
     */
    @Then("Validar que el campo {string} de tipo {string} tiene el valor {string}")
    public void validarQueElCampoTieneElValor(String id, String tipo, String valor) {
        BasePageObject bpo = new BasePageObject();
        System.out.println("El tipo es: " +tipo);
        bpo.validarCampoDeTipo(id, tipo, valor);
        ExtentReportHook.getTest().info("El campo `" + id + "` ha sido validado con el valor `" + valor + "`");
    }

    /**
     * @description Método para seleccionar una opción de un combo, se le pasa el id del combo y el valor a seleccionar
     * @param id: String con el id del combo
     * @param texto: String con el valor a seleccionar en el combo
     */
    @And("Seleccionar en el combo con id {string} la opcion con valor {string}")
    public void seleccionarElComboConElTexto(String id, String texto) {
        BasePageObject bpo = new BasePageObject();
        System.out.println("Seleccionando el combo Motivo Revocacion con el texto: " + texto);
        bpo.seleccionComboById(id,texto);
        System.out.println("Combo Motivo Revocacion seleccionado con el texto: " + texto);
    }

    /**
     * @description Método para seleccionar una opción de un combo, se le pasa el id del combo y el valor a seleccionar
     * @param xpath: String con el xpath del combo
     * @param texto: String con el valor a seleccionar en el combo
     */
    @And("Seleccionar en el combo con xpath {string} la opcion con valor {string}")
    public void seleccionarElComboXpathConElTexto(String xpath, String texto) {
//        BasePageObject bpo = new BasePageObject();
//        System.out.println("Seleccionando el combo Motivo Revocacion con el texto: " + texto);
//        bpo.seleccionComboByxpath(xpath,texto);
//        System.out.println("Combo Motivo Revocacion seleccionado con el texto: " + texto);

    }

    /**
     * @description Método para cerrar el navegador al finalizar el escenario
     */
    @And("Cerrar el navegador")
    public void cerrarElNavegador() {
        DriverManager.quitDriver();
        System.out.println("Navegador cerrado");
        ExtentReportHook.getTest().info("Navegador cerrado");
    }


    /*----------------------CONTROL DE AUTOFIRMA---------------------
    * TODO Actualmente lo hace con la Libreria Siculix que depende de interfaz grafica
    *  */

    @When("Acepta la alerta de autofirma")
    public void aceptarAlertaAutofirma() {
        ExtentReportHook.getTest().info("Aceptando alerta de navegador...");
        try {
            Match abrir_autofirma = new Screen().wait(Commons.getResourcePath("sikuli/Abrir_autofirma.png"));
            abrir_autofirma.click();
        } catch (FindFailed e) {
            ExtentReportHook.getTest().warning("No se ha podido aceptar la alerta del navegador...");
        }
    }

    @When("Selecciona su certificado en autofirma")
    public void seleccionar_y_firmar() {
        ExtentReportHook.getTest().info("Seleccionando certificado en autofirma...");

        Screen screen = new Screen();

        try {
            Match certificado =screen.wait(Commons.getResourcePath("sikuli/certificado_eidas.png"), 30);
            certificado.click();
            Match aceptar = screen.wait(Commons.getResourcePath("sikuli/boton_aceptar.png"), 30);
            aceptar.click();
        } catch (FindFailed e) {
            ExtentReportHook.getTest().warning("No ha sido posible seleccionar el certificado. Causa: " + e.getLocalizedMessage());
            throw new RuntimeException(e);
        }

    }

    /*------------------------------CREACIÓN DE CARTERA PARA PRUEBAS------------------------------*/
    @Given("El usuario dispone de una cartera valida")
    public void crearCartera() {
        String email = cartera.getEmail();
        ExtentReportHook.getTest().info("Creando nueva cartera con email: "+ email+"...");
        cartera.nuevaCartera();
        if (cartera.estaCreada()) {
            ExtentReportHook.getTest().info("La cartera se ha creado correctamente. Esperando 20 segundos...");
        } else {
            ExtentReportHook.getTest().warning("No se ha podido crear la cartera");
            throw new RuntimeException();
        }

    }
}

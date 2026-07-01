package com.nttdata.automation.steps;

import com.nttdata.automation.driver.DriverManager;
import com.nttdata.automation.hooks.ExtentReportHook;
import com.nttdata.automation.pages.Login;
import com.nttdata.automation.pages.WP_ControlPanel;
import com.nttdata.automation.reports.Report;
import com.nttdata.automation.utils.CSV_Manager;
import com.nttdata.automation.utils.Cartera;
import com.nttdata.automation.utils.Commons;
import com.nttdata.automation.validation.Validator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

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
        Report.info("Conectados a la web");
    }

    /**
     * @description Método para abrir el navegador y navegar a la URL del portal de wallet provider
     */
    @Given("Abrir la web wallet provider")
    public void abrirElNavegadorChrome_PortalWalletProvider() {
        login.abrirWebPortalAdministrador_WP();
        Report.info("Conectados a la web");
    }

    /**
     * @description Método para abrir el navegador y navegar a la URL del portal de EAA provider
     */
    @Given("Abrir la web EAA provider")
    public void abrirElNavegadorChrome_PortalEAAProvider() {
        Report.info("Conectando...");
        login.abrirWebPortalAdministrador_EEAProvider();

        Report.info("Autenticando...");
        hacerClickEnElBotonAcceder();

        if (login.apareceInicioNoSeguro()) {
            Report.info("Aparece acceso a pagina no segura. Aceptando acceso...");
            login.clickAccederTodosModos();
        }
    }

    /**
     * @description Método para abrir el navegador y navegar a la URL del portal de PID provider
     */
    @Given("Abrir la web PID provider")
    public void abrirElNavegadorChrome_PortalPIDProvider() {
        Report.info("Conectando...");
        login.abrirWebPortalAdministrador_PIDProvider();

        Report.info("Autenticando...");
        hacerClickEnElBotonAcceder();

        //Ahora mismo aparece pagina de información no segura
        if (login.apareceInicioNoSeguro()) {
            Report.info("Aparece acceso a pagina no segura. Aceptando acceso...");
            // login.clickAccederTodosModos();
            try {
                Robot robot = new Robot();

                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyRelease(KeyEvent.VK_TAB);
                robot.delay(300);

                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyRelease(KeyEvent.VK_TAB);
                robot.delay(300);

                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);

            } catch (AWTException e) {
                System.err.println("Error al inicializar la clase Robot: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }


    /**
     * @description Método para esperar 5 segundos, utilizado principalmente para dar tiempo a que se carguen elementos o para esperar a que se abra el modal de selección de certificado
     */
    @And("Esperar 5 segundos")
    public void esperarSegundos() {
        try {
            Report.info("Esperando 5 segundos");
            Commons.wait5seconds();
            //Report.info("Espera finalizada");
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
     * @param xpath: String con el xpath del combo
     * @param texto: String con el valor a seleccionar en el combo
     * @description Método para seleccionar una opción de un combo, se le pasa el id del combo y el valor a seleccionar
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
        Report.info("Navegador cerrado");
    }


    /*----------------------CONTROL DE AUTOFIRMA---------------------
     * TODO Actualmente lo hace con la Libreria Siculix que depende de interfaz grafica
     *  */

    @When("Acepta la alerta de autofirma")
    public void aceptarAlertaAutofirma() {
        Report.info("Aceptando alerta de navegador...");
        try {
            Pattern imagen = new Pattern(Commons.getResourcePath("sikuli/Abrir_autofirma.png")).similar(0.80);
            new Screen().click(imagen);
        } catch (FindFailed e) {
            ExtentReportHook.getTest().warning("No se ha podido aceptar la alerta del navegador...");
        }
    }

    @When("Selecciona su certificado en autofirma")
    public void seleccionar_y_firmar() {
        Report.info("Seleccionando certificado en autofirma...");

        Screen screen = new Screen();

        try {
            Match certificado = screen.wait(Commons.getResourcePath("sikuli/certificado_eidas.png"), 30);
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
        Report.info("Creando nueva cartera con email: " + email + "...");
        cartera.nuevaCartera();
        if (cartera.estaCreada()) {
            Report.info("La cartera se ha creado correctamente. Esperando 20 segundos...");
        } else {
            ExtentReportHook.getTest().warning("No se ha podido crear la cartera");
            throw new RuntimeException();
        }

    }

    @Then("Se muestra un listado de carteras")
    public void comprobarListadoCredenciales() {
        WP_ControlPanel wp = new WP_ControlPanel();
        List<String> credenciales = wp.obtenerIdsCarteras();
        Validator.validarVerdadero(!credenciales.isEmpty(), "El listado contiene credenciales: " + credenciales);
    }

    private String idExtraido = "12246356";

    @And("Actualizo variable idExtraido")
    public void actualizarVariableIdExtraido() {
        int numero = (int) (Math.random() * 100) + 1;
        idExtraido = String.valueOf(numero);
        System.out.println("La variable idExtraido se ha actualizado con el valor: " + idExtraido);
    }

    @Given("Inicializo el archivo CSV con la cabecera")
    public void inicializarCsv() {
        // Llama al método interno sin pasar parámetros externos
        CSV_Manager.inicializarArchivo();
    }

    @Then("guardo el id extraido en el archivo CSV revocacion")
    public void guardarIdEnCsv() {
        // Pasa el ID dinámico que extrajo Selenium al gestor del archivo
        CSV_Manager.anadirId(idExtraido);
    }

    @Then("guardo el listado extraido en el archivo CSV revocacion")
    public void guardarListadoEnCsv() {
        // Pasa el ID dinámico que extrajo Selenium al gestor del archivo
        CSV_Manager.guardarListaIds();
    }

}

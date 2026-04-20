package com.nttdata.automation.steps;

import com.aventstack.extentreports.ExtentTest;
import com.nttdata.automation.driver.DriverManager;
import com.nttdata.automation.hooks.ExtentReportHook;
import com.nttdata.automation.pages.CIT_PortalUsuario;
import com.nttdata.automation.validation.Validator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class PortalUsuario_ControlPanel_Steps {

    public CIT_PortalUsuario portal_usuario;

    public PortalUsuario_ControlPanel_Steps() {
        // Inicio la pantalla una sola vez
        portal_usuario = new CIT_PortalUsuario();
    }

    @When("Acceder a la pantalla Aviso Legal por el pie de pagina")
    public void hacerClickEnAvisoLegal() {
        System.out.println("Se pulsa en aviso legal");
        ExtentReportHook.getTest().info("Se pulsa en aviso legal");
        portal_usuario.clickEnAvisoLegal();
    }

    @Then("Visualizar el contenido del aviso legal")
    public void visualizarAvisoLegal() {
        System.out.println("Se comprueba el contenido del título de aviso legal");
        ExtentReportHook.getTest().info("Se comprueba el contenido del título aviso legal");
        String titulo = portal_usuario.getTituloPantallaEnlace();
        Assert.assertEquals("Aviso Legal", titulo);
    }

    @Then("El usuario visualiza 3 tipos de revocación")
    public void visualizarTiposRevocacion() {
        int numero_opciones_revocacion = portal_usuario.getTitulosTiposRevocacion().size();
        Validator.validarVerdadero(numero_opciones_revocacion == 3, "Existen 3 opciones de revocación", true);


    }

    @Then("El usuario visualiza la opción de revocación {string}")
    public void validarOpcionRevocacion(String opcion) {
        List <String> opcionesRevocacion = portal_usuario.getTitulosTiposRevocacion();
        Validator.validarVerdadero(opcionesRevocacion.contains(opcion), "Se encuentra la opción " + opcion);
    }

    @When("El usuario pulsa en consultar oficina")
    public void consultarOficina() {
        System.out.println("Pulsando en Comprobar oficina...");
        ExtentReportHook.getTest().info("Pulsando en Comprobar oficina...");
        portal_usuario.clickEnConsultarOficina();
    }

    @Then("El usuario accede a una pantalla con las oficinas")
    public void validarPantallaOficinas() {
        System.out.println("Obteniendo url...");
        ExtentReportHook.getTest().info("Obteniendo url...");
        String url = (DriverManager.getDriver().getCurrentUrl() == null) ? "" : DriverManager.getDriver().getCurrentUrl();
        Validator.validarVerdadero(url.endsWith("/revocacion-presencial"), "Se ha accedido a la url de revocación presencial: " + url, true);
    }

    @And("Existe un botón para cambiar a varios idiomas")
    public void validarBotonIdiomas() {
        System.out.println("Obteniendo texto de boton idiomas...");
        ExtentReportHook.getTest().info("Obteniendo texto de boton idiomas...");
        String textoBotonIdiomas = portal_usuario.getTextoBotonIdiomas();
        Validator.validarVerdadero(textoBotonIdiomas.contains("Español"), "Existe un texto para cambiar de idiomas con la opción Español por defecto");
    }

    @When("El usuario cambia al idioma {string}")
    public void cambiarAIdioma(String idioma) {
        System.out.println("Seleccionando idioma " + idioma);
        ExtentReportHook.getTest().info("Seleccionando idioma " + idioma );
        portal_usuario.pulsarBotonIdioma();
        portal_usuario.seleccionarIdioma(idioma);
    }

    @Then("El usuario ve las oficinas para revocar la cartera está en el {string} y es {string}")
    public void validarOficinasRevocacionCarteraEnIdioma(String idioma, String texto_revocar_Cartera) {
        List <String> textosRevocacionOficinas = portal_usuario.getTitulosRevocacionPantallaOficinas();
        Validator.validarVerdadero(textosRevocacionOficinas.contains(texto_revocar_Cartera), "El texto " + textosRevocacionOficinas + " está en el idioma " + idioma, true);
    }

    @Then("El usuario ve las oficinas para revocar la PID está en el {string} y es {string}")
    public void validarOficinasRevocacionPIDEnIdioma(String idioma, String texto_revocar_PID) {
        List <String> textosRevocacionOficinas = portal_usuario.getTitulosRevocacionPantallaOficinas();
        Validator.validarVerdadero(textosRevocacionOficinas.contains(texto_revocar_PID), "El texto " + textosRevocacionOficinas + " está en el idioma " + idioma, true);
    }


}

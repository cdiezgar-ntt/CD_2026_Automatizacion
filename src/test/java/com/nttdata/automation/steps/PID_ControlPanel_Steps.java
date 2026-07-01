package com.nttdata.automation.steps;

import com.aventstack.extentreports.ExtentTest;
import com.nttdata.automation.hooks.ExtentReportHook;
import com.nttdata.automation.pages.PID_ControlPanel;
import com.nttdata.automation.reports.Report;
import com.nttdata.automation.validation.Validator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PID_ControlPanel_Steps {

    public static ExtentTest test = ExtentReportHook.getTest();
    private PID_ControlPanel pid_cp;
    private final PID_ControlPanel portalPid;

    public PID_ControlPanel_Steps() {
        pid_cp = new PID_ControlPanel();
        portalPid = new PID_ControlPanel();
    }

    @Then("Se abre el portal PID Provider")
    public void comprobarAperturaPortalPid() {
        Validator.validarVerdadero(portalPid.getTituloPortal().contains("PID Provider"),
                "El titulo es el del portal PID Provider");
        Validator.validarVerdadero(portalPid.currentUrl().endsWith("/control-panel/home"),
                "La url es la del pid provider", true, true);
    }

    @Given("Rellenar el texto {string} en el campo de busqueda DNI")
    public void rellenarElTextoEnElCampoDeBusquedaEmail(String texto) {
        Report.info("Rellenando el campo de búsqueda dni con el texto: " + texto);
        pid_cp.rellenarCampoDni(texto);
        Report.info("Texto '" + texto + "' rellenado en el campo de búsqueda ");
    }

    @And("Seleccionar en el combo estado credencial la opcion con valor {string}")
    public void seleccionarElComboMotivoRevocacionElTexto(String texto) {
        System.out.println("Seleccionando el combo estado credencial con el texto: " + texto);
        pid_cp.rellenarBoxEstado(texto);
        System.out.println("Combo estado credencial seleccionado con el texto: " + texto);
    }

    //crear mañana un metodo para seleccionar el primer elemento de la tabla
    @And("Click en el primer elemento de la lista de credenciales")
    public void clickEnElPrimerElementoDeLaListaPID() {
        System.out.println("Clicando en el primer elemento de la lista de credenciales");
        Report.info("Clicando en el primer elemento de la lista");
        pid_cp.clickPrimerElementoListaPID();
        System.out.println("Primer elemento de la lista clicado");
        Report.info("Primer elemento de la lista clicado");
    }

    @When("Click en el botón buscar PID")
    public void clickBtnBuscarPID() {
        Report.info("Se va a pulsar en el boton buscar");
        pid_cp.clickBtnBuscarPID();

    }

    @Then("Validar que el campo informacion general estado credencial tiene el valor {string}")
    public void validarQueElCampoInformacionGeneralEstadoTieneElValor(String valor) {
        Validator.validarVerdadero(pid_cp.obtenerTextoDetalleEstado().equals(valor), "El campo estado tiene el valor: " + valor, false, false);
    }

    @Then("Validar que el campo dni del filtro tiene el valor {string}")
    public void validarQueElCampoDniFiltroTieneElValor(String valor) {
        Validator.validarVerdadero(pid_cp.obtenerTextoDetalleDni().equals(valor), "El campo dni tiene el valor: " + valor, true, false);
    }

    @When("Click en el botón revocar credencial")
    public void clickBtnRevocarPID() {
        Report.info("Se pulsa el boton de revocar PID");
        pid_cp.clickBtnRevocarPID();
    }

    @Then("Seleccionar en el combo motivo revocacion PID la opcion con valor {string}")
    public void seleccionarComboMotivoRevocacionPID(String texto) {
        Report.info("Se elige el motivo de la revocacion");
        pid_cp.rellenarBoxMotivoRevocacionPID(texto);
    }

    @When("Click en el botón confirmar revocación PID")
    public void clickConfirmacionRevocacion() {
        pid_cp.clickBtnConfirmarRevocacionPID();

    }

    @When("Click en el botón ver todas pid activas ultimo mes")
    public void clickVerTodasPIDActivasUltimoMes() {
        pid_cp.clickBtnVerTodasPIDActivasUltimoMes();
    }

    @When("Click en el botón ver todas pid revocadas ultimo mes")
    public void clickVerTodasPIDRevocadasUltimoMes() {
        pid_cp.clickBtnVerTodasPIDRevocadasUltimoMes();
    }

    @When("Click en el botón detalle PID emitidas ultimo mes")
    public void clickVerTodasPIDEmitidasUltimoMes() {
        pid_cp.clickBtnVerTodasPIDEmitidasUltimoMes();
    }

    @Then("Validar que el campo informacion general estado credencial tiene un valor valido")
    public void validarEstadoDetalleCredencialEmitida() {
        pid_cp.validarEstadosVarios("Validación estado credencial", true, true);
    }

    @Then("Seleccionar PID de la lista")
    public void seleccionarPIDCheckboxListado() {
        pid_cp.clickCheckboxPrimeroListaCredencial();
    }

    @Then("Pulsar el botón revocar seleccionadas")
    public void clickRevocarSeleccionadas() {
        pid_cp.clickRevocarSeleccionadasPID();
    }

    @When("Click en el botón revocacion por archivo")
    public void clickRevocacionArchivo() {
        pid_cp.clickRevocarArchivo();
    }

    @Then("Click en el boton elige tu archivo")
    public void clickElegirArchivo() {

    }

    @When("Click en el botón historico revocacion")
    public void clickHistoricoRevocacion() {
        pid_cp.clickHistoricoRevocacion();
    }

    @And("Click en el boton ver detalle de la credencial")
    public void clickVerDetalleHistorico() {
        pid_cp.clickDetalleHistoricoRevocacion();
    }

}

package com.nttdata.automation.pages;

import com.nttdata.automation.base.BasePageObject;
import com.nttdata.automation.validation.Validator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class PID_ControlPanel extends BasePageObject {
    // Localizadores de los elementos de la pantalla de inicio del Control Panel del Pid Provider
    private final By textBoxDniBy = xpath("pid_pantallaInicio_textBoxDni");
    private final By comboBoxEstado = xpath("pid_pantallaInicio_comboBoxEstado");
    private final By detalleEstadoCredencial = tag("pid_detalleCredencial_estado");
    private final By titulo_portal = tag("titulo_portal");
    private final By btnBuscarPid = xpath("pid_pantallaInicio_BotonBuscar");
    private final By primerElementoTabla = xpath("pid_pantallaInicio_PrimerElementoTabla");
    private final By detalleDniCredencial = xpath("pid_detalleCredencial_Dni");
    private final By btnRevocarPID = xpath("pid_detalleCredencial_BotonRevocar");
    private final By btnRevocarPIDConfirmacion = xpath("pid_detalleCredencial_Boton_SiRevocar");
    private final By tituloPortal = tag("titulo_portal");
    private final By desplegableMotivoPID = xpath("pid_desplegableMotivos");
    private final By listaMotivoDesplegable = xpath("pid_opcionesDesplegableMotivos");
    private final By vertodasPIDactivas = xpath("pid_verTodasPIDActivas");
    private final By vertodasPIDemitidas = xpath("pid_verTodasPIDEmitidas");
    private final By vertodasPIDRevocadas = xpath("pid_verTodasPIDRevocadas");
    private final By btnRevocarPIDListaCredendial = xpath("pid_listadoCredencialRevocar");
    private final By btnRevocarSeleccionados = xpath("pid_listadoCredencial_BotonRevocarSeleccionadas");
    private final By checkboxPrimerElementoPIDListado = xpath("pid_checkboxCredencialPrimeroLista");
    private final By btnRevocarArchivo = xpath("pid_pantallaInicio_BotonRevocarArchivo");
    private final By btnRevocarElegirArchivo = xpath("pid_pantallaInicio_BotonRevocarElegirArchivo");
    private final By btnHistoricoRevocacion = xpath("pid_pantallaInicio_BotonHistoricoRevocacion");
    private final By btnDetalleHistorico = xpath("pid_historico_Revocacion_Detalle");


    public PID_ControlPanel() {
        super("elements/web_pid.properties");
    }

    public String getTituloPortal() {
        return obtenerTextosElementosWeb(tituloPortal).getFirst();
    }

    public void rellenarCampoDni(String textoBusqueda) {
        escribir(textBoxDniBy, textoBusqueda);
    }

    public void rellenarBoxEstado(String opcion) {
        WebElement we;
        try {
            System.out.println("Esperando a que el elemento sea visible...");
            we = wait.until(ExpectedConditions.visibilityOfElementLocated(comboBoxEstado));
            //Scrollear hasta el elemento
            new Actions(driver).scrollToElement(we).perform();
            System.out.println("Rellenando combobox");
            Select comboBox = new Select(we);
            comboBox.selectByValue(opcion);
            //comboBox.selectByVisibleText(opcion);
            System.out.println("Combobox seleccionado: " + opcion);

        } catch (Exception e) {
            System.out.println("Excepción al seleccionar combo: " + e);
            e.printStackTrace();
            throw new RuntimeException(e);

        }

    }

    /**
     * @description Método para hacer click en el botón "Buscar" de la pantalla de inicio del portal PID Provider
     */
    public void clickBtnBuscarPID() {
        pulsar(btnBuscarPid);
    }

    public void clickBtnRevocarPID() {
        pulsar(btnRevocarPID);
    }

    public void clickBtnConfirmarRevocacionPID() {
        pulsar(btnRevocarPIDConfirmacion);
    }

    public void clickPrimerElementoListaPID() {
        pulsar(primerElementoTabla);
    }

    public String obtenerTextoDetalleEstado() {
        return obtenerTextosElementosWeb(detalleEstadoCredencial).getFirst();
    }

    public String obtenerTextoDetalleDni() {
        return obtenerTextosElementosWeb(detalleDniCredencial).getFirst();
    }

    public void rellenarBoxMotivoRevocacionPID(String opcion) {
        pulsar(desplegableMotivoPID);
        seleccionarDeLista(listaMotivoDesplegable, opcion);
    }

    public void clickBtnVerTodasPIDActivasUltimoMes() {
        pulsar(vertodasPIDactivas);
    }

    public void clickBtnVerTodasPIDEmitidasUltimoMes() {
        pulsar(vertodasPIDemitidas);
    }

    public void validarEstadosVarios(String msg, boolean conCaptura, boolean bloqueante) {
        String estado = obtenerTextoDetalleEstado();
        boolean esValido = "Válida".equals(estado) || "Revocada".equals(estado);
        Validator.validarVerdadero(esValido, msg, conCaptura, bloqueante);
    }

    public void clickBtnVerTodasPIDRevocadasUltimoMes() {
        pulsar(vertodasPIDRevocadas);
    }

    public void clickBtnRevocarPIDLista() {
        pulsar(btnRevocarPIDListaCredendial);
    }

    public void clickCheckboxPrimeroListaCredencial() {
        pulsar(checkboxPrimerElementoPIDListado);
    }

    public void clickRevocarSeleccionadasPID() {
        pulsar(btnRevocarSeleccionados);

    }

    public void clickRevocarArchivo() {
        pulsar(btnRevocarArchivo);
    }

    public void clickRevocarElegirArchivo() {
        pulsar(btnRevocarElegirArchivo);
    }

    public void clickHistoricoRevocacion() {
        pulsar(btnHistoricoRevocacion);
    }

    public void clickDetalleHistoricoRevocacion() {
        pulsar(btnDetalleHistorico);
    }
}



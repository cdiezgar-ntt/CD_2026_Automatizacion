package com.nttdata.automation.pages;

import com.nttdata.automation.base.BasePageObject;
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

    private final By tituloPortal = tag("titulo_portal");

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

    public void clickPrimerElementoListaPID() {
        pulsar(primerElementoTabla);
    }

    public String obtenerTextoDetalleEstado() {
        return obtenerTextosElementosWeb(detalleEstadoCredencial).getFirst();
    }

    public String obtenerTextoDetalleDni() {
        return obtenerTextosElementosWeb(detalleDniCredencial).getFirst();
    }
}



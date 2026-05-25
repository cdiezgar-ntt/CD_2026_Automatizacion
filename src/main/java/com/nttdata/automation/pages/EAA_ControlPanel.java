package com.nttdata.automation.pages;

import com.nttdata.automation.base.BasePageObject;
import com.nttdata.automation.utils.Elementos_web;
import org.openqa.selenium.By;


public class EAA_ControlPanel extends BasePageObject {
    private final By btnBuscarBy = xpath(Elementos_web.wp_pantallaInicio_BotonBuscar);
    private final By primerElementoListaEAABy = xpath(Elementos_web.eaa_pantallaInicio_PrimerElementoTabla);
    private final By textBoxEmailBy = xpath(Elementos_web.wp_pantallaInicio_textBoxEmail);
    private final By totalCarterasByy = xpath(Elementos_web.eaa_totalCarteras);
    private final By estadoDetalleCredencial = xpath(Elementos_web.eaa_estadoDetalleCredencial);

    public void clickBtnBuscar() {
        System.out.println(btnBuscarBy);
        pulsar(btnBuscarBy);
    }

    public void clickPrimerElementoLista() {
        pulsar(primerElementoListaEAABy);
    }

    public void rellenarCampoBusquedaEmail(String textoBusqueda) {
        escribir(textBoxEmailBy, textoBusqueda);
    }

    public int obtenerTotalCarteras() {
        String total_str = obtenerTextosElementosWeb(totalCarterasByy).getFirst();
        return Integer.parseInt(total_str.trim().split(" ")[0]);
    }

    public String obtenerTextoEstadoDetalleCredencial(){
        return obtenerTextosElementosWeb(estadoDetalleCredencial).getFirst();

    }



}

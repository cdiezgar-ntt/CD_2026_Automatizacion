package com.nttdata.automation.pages;

import com.nttdata.automation.base.BasePageObject;
import org.openqa.selenium.By;

import java.util.List;


public class EAA_ControlPanel extends BasePageObject {
    private final By btnBuscarBy = xpath("eaa_pantallaInicio_BotonBuscar");
    private final By primerElementoListaEAABy = xpath("eaa_pantallaInicio_PrimerElementoTabla");
    private final By filtroEmailBy = id("eaa_filtroEmail");
    private final By totalCarterasByy = xpath("eaa_totalCarteras");
    private final By estadoDetalleCredencial = tag("eaa_estadoDetalleCredencial");
    private final By tituloPortal = tag("eaa_tituloPortal");
    private final By tabla_credenciales = tag("eaa_tabla_credenciales");

    public EAA_ControlPanel() {
        super("elements/web_eaa.properties");
    }
    public void clickBtnBuscar() {
        System.out.println(btnBuscarBy);
        pulsar(btnBuscarBy);
    }

    public void clickPrimerElementoLista() {
        pulsar(primerElementoListaEAABy);
    }

    public void rellenarCampoBusquedaEmail(String textoBusqueda) {
        escribir(filtroEmailBy, textoBusqueda);
    }

    public int obtenerTotalCarteras() {
        String total_str = obtenerTextosElementosWeb(totalCarterasByy).getFirst();
        return Integer.parseInt(total_str.trim().split(" ")[0]);
    }

    public String obtenerTextoEstadoDetalleCredencial(){
        return obtenerTextosElementosWeb(estadoDetalleCredencial).getFirst();

    }

    public String obtenerTituloPortal() {
        return obtenerTextosElementosWeb(tituloPortal).getFirst();
    }

    public List<String> obtenerIdsCredenciales() {
        return obtenerTextosColumnaTabla(tabla_credenciales, "ID Credencial");
    }

    public void pulsarEnLaCredencialDeLaFila(int fila) {
        pulsar(obtenerTablaDeDatos(tabla_credenciales).getElementoCelda(fila,"ID Credencial", By.tagName("a")));
    }

    public String obtenerEstadoCredencialDeLaFila(int fila) {
        return obtenerTextoElementoWeb(obtenerTablaDeDatos(tabla_credenciales).getElementoCelda(fila, "Estado", estadoDetalleCredencial));
    }

    public void clickEnBuscar() {
        pulsar(btnBuscarBy);
    }



}

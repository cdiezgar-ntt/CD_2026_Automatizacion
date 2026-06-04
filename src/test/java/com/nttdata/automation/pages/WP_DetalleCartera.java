package com.nttdata.automation.pages;

import com.nttdata.automation.base.BasePageObject;
import org.openqa.selenium.By;

public class WP_DetalleCartera extends BasePageObject {

    private final By titulo = tag("wp_detalleCartera_titulo");
    private final By infoContacto_telefono = xpath("wp_detalleCartera_InformacionContacto_telefono");
    private final By infoContacto_email = xpath("wp_detalleCartera_InformacionContacto_email");
    private final By infoGeneral_estado = tag("wp_detalleCartera_InformacionGeneral_estado");
    private final By btnRevocarCarteraBy = xpath("wp_detalleCartera_RevocarCartera");
    private final By btnSiRevocarBy = xpath("wp_detalleCartera_Boton_SiRevocar");


    public WP_DetalleCartera() {
        super("elements/web_wp_detalle_cartera.properties");
    }

    public String obtenerEstadoCartera() {
        return obtenerTextosElementosWeb(infoGeneral_estado).getFirst();
    }

    /**
     * @description Método para hacer click en el botón "Revocar cartera" de la pantalla de detalle de cartera del Wallet Provider
     */
    public void clickBtnDetallesRevocarCartera() {
        System.out.println(btnRevocarCarteraBy);
        pulsar(btnRevocarCarteraBy);
    }

    public void clickBtnSiRevocar() {
        System.out.println(btnSiRevocarBy);
        pulsar(btnSiRevocarBy);
    }
}

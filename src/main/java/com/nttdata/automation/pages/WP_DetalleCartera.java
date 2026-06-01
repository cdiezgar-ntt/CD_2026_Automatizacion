package com.nttdata.automation.pages;

import com.nttdata.automation.base.BasePageObject;
import org.openqa.selenium.By;

public class WP_DetalleCartera extends BasePageObject {

    private final By titulo = tag("wp_detalleCartera_titulo");
    private final By infoContacto_telefono = xpath("wp_detalleCartera_InformacionContacto_telefono");
    private final By infoContacto_email = xpath("wp_detalleCartera_InformacionContacto_email");
    private final By infoGeneral_estado = tag("wp_detalleCartera_InformacionGeneral_estado");

    public WP_DetalleCartera() {
        super("elements/web_wp_detalle_cartera.properties");
    }

    public String obtenerEstadoCartera() {
        return obtenerTextosElementosWeb(infoGeneral_estado).getFirst();
    }
}

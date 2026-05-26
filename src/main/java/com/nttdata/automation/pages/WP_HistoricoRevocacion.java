package com.nttdata.automation.pages;

import com.nttdata.automation.base.BasePageObject;
import org.openqa.selenium.By;

public class WP_HistoricoRevocacion extends BasePageObject {

    private final By titulo = tag("wp_historicoRevocacion_titulo");
    private final By primer_id_bloque_revocacion = xpath("wp_historicoRevocacion_TablaId");
    private final By primer_estado_bloque_revocacion = xpath("wp_hitoricoRevocacion_TablaEstado");

    public WP_HistoricoRevocacion() {
        super("pages/web_wp_historico_revocacion.properties");
    }
}

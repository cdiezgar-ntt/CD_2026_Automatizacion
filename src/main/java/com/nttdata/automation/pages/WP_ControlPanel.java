package com.nttdata.automation.pages;

import com.nttdata.automation.base.BasePageObject;
import com.nttdata.automation.utils.Elementos_web;
import org.openqa.selenium.By;

public class WP_ControlPanel extends BasePageObject {

    private final By btnBuscarBy = By.xpath(prop.get(Elementos_web.wp_pantallaInicio_BotonBuscar));
    private final By primerElementoListaBy = By.xpath(prop.get(Elementos_web.wp_pantallaInicio_PrimerElementoTabla));
    private final By textBoxEmailBy = By.xpath(prop.get(Elementos_web.wp_pantallaInicio_textBoxEmail));
    private final By primerElementoListaBusquedaEmailBy = By.xpath(prop.get(Elementos_web.wp_pantallaInicio_primerElementoTablaBusquedaEmail));


    public void clickBtnBuscar() {
        pulsar(btnBuscarBy);
    }

    public void clickPrimerElementoLista() {
        pulsar(primerElementoListaBy);
    }

    public void rellenarCampoBusquedaEmail(String textoBusqueda) {
        escribir(textBoxEmailBy, textoBusqueda);
    }

    public void clickPrimerElementoListaBusquedaEmail() {
        pulsar(primerElementoListaBusquedaEmailBy);
    }

//    public void clickBtnBuscarEmail() {
//        pulsar(btnBuscarEmailBy);
//    }

}

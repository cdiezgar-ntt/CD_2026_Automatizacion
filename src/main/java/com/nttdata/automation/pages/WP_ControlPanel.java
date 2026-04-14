package com.nttdata.automation.pages;

import com.nttdata.automation.base.BasePageObject;
import org.openqa.selenium.By;

public class WP_ControlPanel extends BasePageObject {

    private final By btnBuscarBy = By.xpath(prop.getwp_pantallaInicio_BotonBuscar());
    private final By primerElementoListaBy = By.xpath(prop.getwp_pantallaInicio_PrimerElementoTabla());
    private final By textBoxEmailBy = By.xpath(prop.getwp_pantallaInicio_textBoxEmail());
    private final By primerElementoListaBusquedaEmailBy = By.xpath(prop.getwp_pantallaInicio_primerElementoTablaBusquedaEmail());


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

package com.nttdata.automation.pages;

import com.nttdata.automation.base.BasePageObject;
import com.nttdata.automation.utils.Elementos_web;
import org.openqa.selenium.By;

public class CIT_PortalUsuario extends BasePageObject {

    private final By enlaceAvisoLegal = By.xpath(prop.get(Elementos_web.cit_home_avisolegal));
    private final By tituloPantallaEnlace = By.xpath(prop.get(Elementos_web.cit_home_titulopantallaenlace));

    public void clickEnAvisoLegal () {
        pulsar(enlaceAvisoLegal);
    }

    public String getTituloPantallaEnlace() {
        return driver.findElement(tituloPantallaEnlace).getText();
    }

}

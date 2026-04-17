package com.nttdata.automation.pages;

import com.nttdata.automation.base.BasePageObject;
import com.nttdata.automation.utils.Elementos_web;
import org.openqa.selenium.By;

import java.util.List;

public class CIT_PortalUsuario extends BasePageObject {

    private final By botonIdiomas = By.xpath(prop.get(Elementos_web.cit_home_botonIdiomas));
    private final By listaDeIdiomas = By.xpath(prop.get(Elementos_web.cit_home_listaDeIdiomas));
    private final By enlaceAvisoLegal = By.xpath(prop.get(Elementos_web.cit_home_avisolegal));
    private final By tituloPantallaEnlace = By.xpath(prop.get(Elementos_web.cit_home_titulopantallaenlace));
    private final By titulosTiposRevocacion = By.tagName(prop.get(Elementos_web.cit_home_titulosTiposRevocacion));
    private final By botonConsultarOficina = By.xpath(prop.get(Elementos_web.cit_home_botonConsultarOficina));
    private final By textosRevocacionOficinas = By.xpath(prop.get(Elementos_web.cit_revocacionPresencial_oficinas_titulos));

    public void clickEnAvisoLegal () {
        pulsar(enlaceAvisoLegal);
    }

    public String getTituloPantallaEnlace() {
        return driver.findElement(tituloPantallaEnlace).getText();
    }

    public List<String> getTitulosTiposRevocacion (){
        return obtenerTextosElementosWeb(titulosTiposRevocacion);
    }

    public void clickEnConsultarOficina() {
        pulsar(botonConsultarOficina);
    }

    public List<String> getTitulosRevocacionPantallaOficinas() {
        return obtenerTextosElementosWeb(textosRevocacionOficinas);
    }

    public String getTextoBotonIdiomas() {
        return obtenerTextosElementosWeb(botonIdiomas).stream().findFirst().orElse("");
    }

    public void pulsarBotonIdioma() {
        pulsar(botonIdiomas);
    }

    public void seleccionarIdioma(String idioma){
        seleccionarDeLista(listaDeIdiomas, idioma);
    }
}

package com.nttdata.automation.pages;

import com.nttdata.automation.base.BasePageObject;
import com.nttdata.automation.driver.DriverManager;
import com.nttdata.automation.utils.Elementos_web;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CIT_PortalUsuario extends BasePageObject {

    private final By tituloHome = By.tagName(prop.get(Elementos_web.cit_home_titulo));
    private final By botonIdiomas = By.xpath(prop.get(Elementos_web.cit_home_botonIdiomas));
    private final By listaDeIdiomas = By.xpath(prop.get(Elementos_web.cit_home_listaDeIdiomas));
    private final By tituloPantallaEnlace = By.tagName(prop.get(Elementos_web.cit_home_titulopantallaenlace));
    private final By titulosTiposRevocacion = By.tagName(prop.get(Elementos_web.cit_home_titulosTiposRevocacion));
    private final By botonConsultarOficina = By.xpath(prop.get(Elementos_web.cit_home_botonConsultarOficina));
    private final By textosRevocacionOficinas = By.xpath(prop.get(Elementos_web.cit_revocacionPresencial_oficinas_titulos));
    private final By textoOficinas = By.tagName(prop.get(Elementos_web.cit_revocacionPresencial_oficinas_textos));
    private final By seccionPreguntasFrecuentes = By.xpath(prop.get(Elementos_web.cit_home_seccionPreguntasFrecuentes));
    private final By preguntasFrecuentes = By.tagName(prop.get(Elementos_web.cit_home_preguntasFrecuentes));
    private final By respuestasPreguntasFrecuentes = By.xpath(prop.get(Elementos_web.cit_home_preguntasFrecuentesRespuestas));
    private final By enlacesBarraInferior = By.xpath(prop.get(Elementos_web.cit_home_opcionesBarraNavegacion));
    private final By enlaceAccesibilidad = By.xpath(prop.get(Elementos_web.cit_home_accesibilidad));
    private final By enlaceMapaWeb = By.xpath(prop.get(Elementos_web.cit_home_mapaweb));
    private final By enlacePolicitaPrivacidad = By.xpath(prop.get(Elementos_web.cit_home_politicaprivacidad));
    private final By enlaceAvisoLegal = By.xpath(prop.get(Elementos_web.cit_home_avisolegal));
    private final By enlacePoliticaCookies = By.xpath(prop.get(Elementos_web.cit_home_politicadecookies));
    private final By botonVolverHome = By.xpath(prop.get(Elementos_web.cit_home_botonVolver));

    public String getTituloHome() {
        return obtenerTextosElementosWeb(tituloHome).getFirst();
    }

    public String getTituloPantallaEnlace() {
        return obtenerTextosElementosWeb(tituloPantallaEnlace).getFirst();
    }

    public List<String> getTitulosTiposRevocacion() {
        return obtenerTextosElementosWeb(titulosTiposRevocacion);
    }

    public void clickEnConsultarOficina() {
        pulsar(botonConsultarOficina);
    }

    public List<String> getTitulosRevocacionPantallaOficinas() {
        return obtenerTextosElementosWeb(textosRevocacionOficinas);
    }

    public String getTextoBotonIdiomas() {
        return obtenerTextosElementosWeb(botonIdiomas).getFirst();
    }

    public void pulsarBotonIdioma() {
        pulsar(botonIdiomas);
    }

    public void seleccionarIdioma(String idioma) {
        seleccionarDeLista(listaDeIdiomas, idioma);
    }

    public String getTextoOficinas() {
        return obtenerTextosElementosWeb(textoOficinas).getFirst();
    }

    public boolean existeSeccionPreguntasFrecuentes() {
        return esVisibleEnPantalla(seccionPreguntasFrecuentes);
    }

    public List<String> getPreguntasFrecuentes() {
        return obtenerTextosElementosWeb(preguntasFrecuentes);
    }

    public List<String> getRespuestasPreguntasFrecuentes() {
        return obtenerTextosElementosWeb(respuestasPreguntasFrecuentes);
    }

    public void clickPreguntasFrecuentes() {
        List<WebElement> preguntas_frecuentes = DriverManager.getDriver().findElements(preguntasFrecuentes);
        preguntas_frecuentes.forEach(this::pulsar);
    }

    public List<Boolean> sonLasRespuestasVisibles() {
        List<WebElement> preguntas_frecuentes = DriverManager.getDriver().findElements(preguntasFrecuentes);
        return preguntas_frecuentes.stream().map(p -> {
            boolean existe_open = existeElAtributoEnElElemento(p, "open");
            System.out.println(existe_open);
            return existe_open;
        }).toList();
    }

    public List<String> getOpcionesBarraNavegacionInferior() {
        return obtenerTextosElementosWeb(enlacesBarraInferior);
    }

    public void clickAccesibilidad() {
        pulsar(enlaceAccesibilidad);
    }

    public void clickMapaWeb() {
        pulsar(enlaceMapaWeb);
    }

    public void clickAvisoLegal() {
        pulsar(enlaceAvisoLegal);
    }

    public void clickPoliticaPrivacidad() {
        pulsar(enlacePolicitaPrivacidad);
    }

    public void clickPoliticaCookies() {
        pulsar(enlacePoliticaCookies);
    }

    public void clickVolver() {
        pulsar(botonVolverHome);
    }

}

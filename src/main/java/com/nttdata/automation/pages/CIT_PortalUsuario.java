package com.nttdata.automation.pages;

import com.nttdata.automation.base.BasePageObject;
import com.nttdata.automation.driver.DriverManager;
import com.nttdata.automation.utils.Elementos_web;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
    private final By revocarCarteraDigital = By.xpath(prop.get(Elementos_web.cit_btn_revocar_cartera_digital));
    private final By tituloRevocacionCartera = By.xpath(prop.get(Elementos_web.cit_titulo_revocacion_cartera));
    private final By inputEmail = By.id(prop.get(Elementos_web.cit_email));
    private final By botonContinuarRevocacion = By.xpath(prop.get(Elementos_web.cit_boton_continuar_revocacion));
    private final By codigosDigitos = By.xpath(prop.get(Elementos_web.cit_codigos_digitos));

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

    public void clickRevocarCarteraDigital() {
        pulsar(revocarCarteraDigital);
    }

    public String getTituloRevocacionCartera() {
        return obtenerTextosElementosWeb(tituloRevocacionCartera).getFirst();
    }

    public void introducirEmail(String email) {
        escribir(inputEmail, email);
    }

    public boolean estaHabilitadoDigitos() {
        List<WebElement> digitos = DriverManager.getDriver().findElements(codigosDigitos);
        return digitos.stream().noneMatch(w -> existeElAtributoEnElElemento(w,"disabled"));
    }

    public void escribirOtp(String otp) {
        List<WebElement> digitos = DriverManager.getDriver().findElements(codigosDigitos);

        if (otp.length() != digitos.size()) {
            throw new RuntimeException("El OTP tiene " + otp.length() + " dígitos pero se esperaban " + digitos.size());
        }

        for (int i = 0; i < digitos.size(); i++) {
            escribir(digitos.get(i), String.valueOf(otp.charAt(i)));
        }

    }

    public boolean estaHabilitadoRevocacion() {
        WebElement boton_continuar_revocacion = DriverManager.getDriver().findElement(botonContinuarRevocacion);
        return !existeElAtributoEnElElemento(boton_continuar_revocacion,"disabled");
    }

    public void clickContinuarRevocacion() {
        pulsar(botonContinuarRevocacion);
    }

}

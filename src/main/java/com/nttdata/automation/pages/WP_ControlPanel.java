package com.nttdata.automation.pages;

import com.nttdata.automation.base.BasePageObject;
import com.nttdata.automation.utils.Elementos_web;
import org.openqa.selenium.By;

public class WP_ControlPanel extends BasePageObject {

    private final By btnBuscarBy = By.xpath(prop.get(Elementos_web.wp_pantallaInicio_BotonBuscar));
    private final By primerElementoListaBy = By.xpath(prop.get(Elementos_web.wp_pantallaInicio_PrimerElementoTabla));
    private final By textBoxEmailBy = By.xpath(prop.get(Elementos_web.wp_pantallaInicio_textBoxEmail));
    private final By textBoxIdCarteraBy = By.xpath(prop.get(Elementos_web.wp_pantallaInicio_textBoxIdCartera));
    private final By textBoxTelefonoBy = By.xpath(prop.get(Elementos_web.wp_pantallaInicio_textBoxTelefono));
    private final By comboEstadoBy = By.xpath(prop.get(Elementos_web.wp_pantallaInicio_ComboEstado));
    private final By comboRangoFechasActivacionBy = By.xpath(prop.get(Elementos_web.wp_pantallaInicio_ComboFechaActivacion));
    private final By comboRangoFechasRevocacionBy = By.xpath(prop.get(Elementos_web.wp_pantallaInicio_ComboFechaRevocacion));
    private final By comboMotivoRevocacionBy = By.xpath(prop.get(Elementos_web.wp_pantallaInicio_ComboMotivoRevocacion));
    private final By comboMedioSolicitudRevocacionBy = By.xpath(prop.get(Elementos_web.wp_pantallaInicio_ComboMedioSolicitudRevocacion));
    private final By checkMostrarSoloMisRevocacionesBy = By.xpath(prop.get(Elementos_web.wp_pantallaInicio_CheckMostrarSoloMisRevocaciones));
    private final By linkMostrarBusquedaAvanzadaBy = By.xpath(prop.get(Elementos_web.wp_pantallaInicio_MostrarBusquedaAvanzada));
    private final By linkOcultarBusquedaAvanzadaBy = By.xpath(prop.get(Elementos_web.wp_pantallaInicio_OcultarBusquedaAvanzada));
    private final By comboSistemaOperativoBy = By.xpath(prop.get(Elementos_web.wp_pantallaInicio_SistemaOperativo));
    private final By comboVersionTCBy = By.xpath(prop.get(Elementos_web.wp_pantallaInicio_VersionTC));
    private final By linkHistoricoRevocacionesBy = By.xpath(prop.get(Elementos_web.wp_pantallaInicio_HistoricoRevocacion));
    private final By linkCarterasActivadasVerTodasBy = By.xpath(prop.get(Elementos_web.wp_pantallaInicio_informacionDestacada_carterasActivadas_verTodas));
    private final By linkCarterasRevocadasVerTodasBy = By.xpath(prop.get(Elementos_web.wp_pantallaInicio_informacionDestacada_carterasRevocadas_verTodas));
    private final By linkCarterasActivasVerTodasBy = By.xpath(prop.get(Elementos_web.wp_pantallaInicio_informacionDestacada_carterasActivas_verTodas));
    private final By linkOcultarUltimoMesBy = By.xpath(prop.get(Elementos_web.wp_pantallaInicio_OcultarUltimoMes));


    public void clickBtnBuscar() {
        pulsar(btnBuscarBy);
    }

    public void clickPrimerElementoLista() {
        pulsar(primerElementoListaBy);
    }

    public void rellenarCampoBusquedaEmail(String textoBusqueda) {
        escribir(textBoxEmailBy, textoBusqueda);
    }

    public void rellenarCampoBusquedaIdCartera(String textoBusqueda) {
        escribir(textBoxIdCarteraBy, textoBusqueda);
    }

    public void rellenarCampoBusquedaTelefono(String textoBusqueda) {
        escribir(textBoxTelefonoBy, textoBusqueda);
    }

    public void seleccionarComboEstado(String opcion) {
            escribir(comboEstadoBy, opcion);
    }

    public void seleccionarComboRangoFechasActivacion(String opcion) {
            escribir(comboRangoFechasActivacionBy, opcion);
    }

    public void seleccionarComboRangoFechasRevocacion(String opcion) {
            escribir(comboRangoFechasRevocacionBy, opcion);
    }

    public void seleccionarComboMotivoRevocacion(String opcion) {
            escribir(comboMotivoRevocacionBy, opcion);
    }

    public void seleccionarComboMedioSolicitudRevocacion(String opcion) {
            escribir(comboMedioSolicitudRevocacionBy, opcion);
    }

    public void clickCheckMostrarSoloMisRevocaciones() {
        pulsar(checkMostrarSoloMisRevocacionesBy);
    }

    public void clickLinkMostrarBusquedaAvanzada() {
        pulsar(linkMostrarBusquedaAvanzadaBy);
    }

    public void clickLinkOcultarBusquedaAvanzada() {
        pulsar(linkOcultarBusquedaAvanzadaBy);
    }

    public void seleccionarComboSistemaOperativo(String opcion) {
            escribir(comboSistemaOperativoBy, opcion);
    }

    public void seleccionarComboVersionTC(String opcion) {
            escribir(comboVersionTCBy, opcion);
    }

    public void clickLinkHistoricoRevocaciones() {
        pulsar(linkHistoricoRevocacionesBy);
    }

    public void clickLinkCarterasActivadasVerTodas() {
        pulsar(linkCarterasActivadasVerTodasBy);
    }

    public void clickLinkCarterasRevocadasVerTodas() {
        pulsar(linkCarterasRevocadasVerTodasBy);
    }

    public void clickLinkCarterasActivasVerTodas() {
        pulsar(linkCarterasActivasVerTodasBy);
    }

    public void clickLinkOcultarUltimoMes() {
        pulsar(linkOcultarUltimoMesBy);
    }






}

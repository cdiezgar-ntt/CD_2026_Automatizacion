package com.nttdata.automation.pages;

import com.nttdata.automation.base.BasePageObject;
import com.nttdata.automation.driver.DriverManager;
import com.nttdata.automation.utils.Elementos_web;
import org.openqa.selenium.By;

public class WP_ControlPanel extends BasePageObject {

    // Localizadores de los elementos de la pantalla de inicio del Control Panel del Wallet Provider
    private final By btnBuscarBy = xpath("wp_pantallaInicio_BotonBuscar");
    private final By primerElementoListaBy = xpath("wp_pantallaInicio_PrimerElementoTabla");
    private final By textBoxEmailBy = id("wp_pantallaInicio_textBoxEmail");
    private final By textBoxIdCarteraBy = xpath("wp_pantallaInicio_textBoxIdCartera");
    private final By textBoxTelefonoBy = xpath("wp_pantallaInicio_textBoxTelefono");
    private final By comboEstadoBy = xpath("wp_pantallaInicio_ComboEstado");
    private final By comboRangoFechasActivacionBy = xpath("wp_pantallaInicio_ComboFechaActivacion");
    private final By comboRangoFechasRevocacionBy = xpath("wp_pantallaInicio_ComboFechaRevocacion");
    private final By comboMotivoRevocacionBy = id("wp_pantallaInicio_ComboMotivoRevocacion");
    private final By comboMedioSolicitudRevocacionBy = xpath("wp_pantallaInicio_ComboMedioSolicitudRevocacion");
    private final By checkMostrarSoloMisRevocacionesBy = xpath("wp_pantallaInicio_CheckMostrarSoloMisRevocaciones");
    private final By linkMostrarBusquedaAvanzadaBy = xpath("wp_pantallaInicio_MostrarBusquedaAvanzada");
    private final By linkOcultarBusquedaAvanzadaBy = xpath("wp_pantallaInicio_OcultarBusquedaAvanzada");
    private final By comboSistemaOperativoBy = xpath("wp_pantallaInicio_SistemaOperativo");
    private final By comboVersionTCBy = xpath("wp_pantallaInicio_VersionTC");
    private final By linkHistoricoRevocacionesBy = xpath("wp_pantallaInicio_HistoricoRevocacion");
    private final By linkCarterasActivadasVerTodasBy = xpath("wp_pantallaInicio_informacionDestacada_carterasActivadas_verTodas");
    private final By linkCarterasRevocadasVerTodasBy = xpath("wp_pantallaInicio_informacionDestacada_carterasRevocadas_verTodas");
    private final By linkCarterasActivasVerTodasBy = xpath("wp_pantallaInicio_informacionDestacada_carterasActivas_verTodas");
    private final By linkOcultarUltimoMesBy = xpath("wp_pantallaInicio_OcultarUltimoMes");
    private final By primerCorreoDeLaListaBy = xpath("wp_primerCorreoDeLaListaBy");
    private final By tituloCarterasActivasBy = tag("wp_carterasActivas_titulo");

    public WP_ControlPanel() {
        super("pages/web_wp.properties");
    }

    public void cargarWeb() {
        driver.get(url("web_wp"));
    }

    /**
     * @description Método para hacer click en el botón "Buscar" de la pantalla de inicio del Control Panel del Wallet Provider
     */
    public void clickBtnBuscar() {
        System.out.println(btnBuscarBy);
        pulsar(btnBuscarBy);
    }

    /**
     * @description Método para hacer click en el primer elemento de la lista de resultados de búsqueda de la pantalla de inicio del Control Panel del Wallet Provider
     */
    public void clickPrimerElementoLista() {
        pulsar(primerElementoListaBy);
    }

    /**
     * @description Método para rellenar el campo de búsqueda por email de la pantalla de inicio del Control Panel del Wallet Provider
     * @param textoBusqueda: String con el texto a introducir en el campo de búsqueda por email
     */
    public void rellenarCampoBusquedaEmail(String textoBusqueda) {
        escribir(textBoxEmailBy, textoBusqueda);
    }

    /**
     * @description Método para rellenar el campo de búsqueda por ID de cartera de la pantalla de inicio del Control Panel del Wallet Provider
     * @param textoBusqueda: String con el texto a introducir en el campo de búsqueda por IdCartera
     */
    public void rellenarCampoBusquedaIdCartera(String textoBusqueda) {
        escribir(textBoxIdCarteraBy, textoBusqueda);
    }

    /**
     * @description Método para rellenar el campo de búsqueda por teléfono de la pantalla de inicio del Control Panel del Wallet Provider
     * @param textoBusqueda: String con el texto a introducir en el campo de búsqueda por telefono
     */
    public void rellenarCampoBusquedaTelefono(String textoBusqueda) {
        escribir(textBoxTelefonoBy, textoBusqueda);
    }

    /**
     * @description Método para seleccionar una opción del combo de estado de la pantalla de inicio del Control Panel del Wallet Provider
     * @param opcion: String con la opción a seleccionar del combo de estado
     */
    public void seleccionarComboEstado(String opcion) {
            escribir(comboEstadoBy, opcion);
    }

    /**
     * @description Método para seleccionar una opción del combo de rango de fechas de activación de la pantalla de inicio del Control Panel del Wallet Provider
     * @param opcion: String con la opción a seleccionar del combo de rango de fechas de activación
     */
    public void seleccionarComboRangoFechasActivacion(String opcion) {
            escribir(comboRangoFechasActivacionBy, opcion);
    }

    /**
     * @description Método para seleccionar una opción del combo de rango de fechas de revocación de la pantalla de inicio del Control Panel del Wallet Provider
     * @param opcion: String con la opción a seleccionar del combo de rango de fechas de revocación
     */
    public void seleccionarComboRangoFechasRevocacion(String opcion) {
            escribir(comboRangoFechasRevocacionBy, opcion);
    }

    /**
     * @description Método para seleccionar una opción del combo de motivo de revocación de la pantalla de inicio del Control Panel del Wallet Provider
     * @param opcion: String con la opción a seleccionar del combo de motivo de revocación
     */
    public void seleccionarComboMotivoRevocacion(String opcion) {
            //seleccionCombo(comboMotivoRevocacionBy, opcion);
            //escribir(comboMotivoRevocacionBy, opcion);
    }

    /**
     * @description Método para seleccionar una opción del combo de medio de solicitud de revocación de la pantalla de inicio del Control Panel del Wallet Provider
     * @param opcion: String con la opción a seleccionar del combo de medio de solicitud de revocación
     */
    public void seleccionarComboMedioSolicitudRevocacion(String opcion) {
            escribir(comboMedioSolicitudRevocacionBy, opcion);
    }

    /**
     * @description Método para hacer click en el checkbox de "Mostrar solo mis revocaciones" de la pantalla de inicio del Control Panel del Wallet Provider
     */
    public void clickCheckMostrarSoloMisRevocaciones() {
        pulsar(checkMostrarSoloMisRevocacionesBy);
    }

    /**
     * @description Método para hacer click en el link de "Mostrar búsqueda avanzada" de la pantalla de inicio del Control Panel del Wallet Provider
     */
    public void clickLinkMostrarBusquedaAvanzada() {
        pulsar(linkMostrarBusquedaAvanzadaBy);
    }

    /**
     * @description Método para hacer click en el link de "Ocultar búsqueda avanzada" de la pantalla de inicio del Control Panel del Wallet Provider
     */
    public void clickLinkOcultarBusquedaAvanzada() {
        pulsar(linkOcultarBusquedaAvanzadaBy);
    }

    /**
     * @description Método para seleccionar una opción del combo de sistema operativo de la pantalla de inicio del Control Panel del Wallet Provider
     * @param opcion: String con la opción a seleccionar del combo de sistema operativo
     */
    public void seleccionarComboSistemaOperativo(String opcion) {
            escribir(comboSistemaOperativoBy, opcion);
    }

    /**
     * @description Método para seleccionar una opción del combo de versión de tarjeta de la pantalla de inicio del Control Panel del Wallet Provider
     * @param opcion: String con la opción a seleccionar del combo de versión de tarjeta
     */
    public void seleccionarComboVersionTC(String opcion) {
            escribir(comboVersionTCBy, opcion);
    }

    /**
     * @description Método para hacer click en el link de "Histórico de revocaciones" de la pantalla de inicio del Control Panel del Wallet Provider
     */
    public void clickLinkHistoricoRevocaciones() {
        pulsar(linkHistoricoRevocacionesBy);
    }

    /**
     * @description Método para hacer click en el link de "Ver todas" de la sección de carteras activadas de la pantalla de inicio del Control Panel del Wallet Provider
     */
    public void clickLinkCarterasActivadasVerTodas() {
        pulsar(linkCarterasActivadasVerTodasBy);
    }

    /**
     * @description Método para hacer click en el link de "Ver todas" de la sección de carteras revocadas de la pantalla de inicio del Control Panel del Wallet Provider
     */
    public void clickLinkCarterasRevocadasVerTodas() {
        pulsar(linkCarterasRevocadasVerTodasBy);
    }

    /**
     * @description Método para hacer click en el link de "Ver todas" de la sección de carteras activas de la pantalla de inicio del Control Panel del Wallet Provider
     */
    public void clickLinkCarterasActivasVerTodas() {
        pulsar(linkCarterasActivasVerTodasBy);
    }

    /**
     * @description Método para hacer click en el link de "Ocultar último mes" de la pantalla de inicio del Control Panel del Wallet Provider
     */
    public void clickLinkOcultarUltimoMes() {
        pulsar(linkOcultarUltimoMesBy);
    }


    /**
     * @description Método para obtener el correo del primer resultado de la lista de resultados de búsqueda de la pantalla de inicio del Control Panel del Wallet Provider
     * @return String con el correo del primer resultado de la lista
     */
    public String obtenerPrimerCorreo() {
        return obtenerTextosElementosWeb(primerCorreoDeLaListaBy).getFirst();
    }




}

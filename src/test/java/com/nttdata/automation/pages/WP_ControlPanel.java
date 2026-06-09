package com.nttdata.automation.pages;

import com.nttdata.automation.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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
    private final By tituloSinResultadosBy = xpath("wp_pantallaInicio_SinResultados");
    private final By wp_pantallaInicio_SinResultados_descripcionBy = xpath("wp_pantallaInicio_SinResultados_descripcion");
    private final By wp_informacionGeneralEstadoBy = tag("wp_carterasActivas_titulo");

    private final By wp_detalleCartera_tituloBy = tag("wp_detalleCartera_titulo");
    private final By wp_detalleCartera_InformacionContacto_emailBy = tag("wp_detalleCartera_InformacionContacto_email");
    private final By wp_detalleCartera_InformacionContacto_telefonoBy = tag("wp_detalleCartera_InformacionContacto_telefono");
    private final By wp_detalleCartera_InformacionGeneral_estadoBy = tag("wp_detalleCartera_InformacionGeneral_estado");
    private final By wp_detalleCartera_RevocarCarteraBy = tag("wp_detalleCartera_RevocarCartera");
    private final By wp_detalleCartera_RevocacionComboMotivoRevocacionBy = xpath("wp_detalleCartera_RevocacionComboMotivoRevocacion");
    private final By wp_detalleCartera_Boton_SiRevocarBy = tag("wp_detalleCartera_Boton_SiRevocar");
    private final By wp_tabla_credencialesBy = tag("wp_tabla_credenciales");
    private final By wp_carterasActivas_tituloBy = xpath("wp_carterasActivas_titulo");
    private final By wp_carterasActivadas_tituloBy = xpath("wp_carterasActivadas_titulo");
    private final By wp_carterasRevocadas_tituloBy = xpath("wp_carterasRevocadas_titulo");
    private final By wp_historicoRevocacion_tituloBy = xpath("wp_historicoRevocacion_titulo");
    private final By wp_historicoRevocacion_TablaIdBy = tag("wp_historicoRevocacion_TablaId");
    private final By wp_hitoricoRevocacion_TablaEstadoBy = xpath("wp_hitoricoRevocacion_TablaEstado");
    private final By wp_detalleHistoricoRevocacion_tituloBy = xpath("wp_detalleHistoricoRevocacion_titulo");
    private final By wp_detalleHitoricoRevocacion_TablaEstadoBy = xpath("wp_detalleHitoricoRevocacion_TablaEstado");



    public WP_ControlPanel() {
        super("elements/web_wp.properties");
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


    public List<String> obtenerIdsCarteras() {
        By tabla_credenciales = tag("wp_tabla_credenciales");
        return obtenerTextosColumnaTabla(tabla_credenciales, "ID Cartera");
    }

    public String obtenerTextoTextboxEmail(){
        return obtenerTextosElementosWeb(textBoxEmailBy).getFirst();
    }

    public String obtenerTextoSinResultados(){
        return obtenerTextosElementosWeb(tituloSinResultadosBy).getFirst();
    }

    public String obtenerTextoSinResultadosDescripcion(){
        return obtenerTextosElementosWeb(wp_pantallaInicio_SinResultados_descripcionBy).getFirst();
    }

    public String obtenerTextoInformacionGeneralEstado(){
        return obtenerTextosElementosWeb(wp_detalleCartera_InformacionGeneral_estadoBy).getFirst();
    }

    public String obtenerTextoCarterasActivasTitulo(){
        return obtenerTextosElementosWeb(wp_carterasActivas_tituloBy).getFirst();
    }

    public String obtenerTextoDetalleCarteraTitulo(){
        return obtenerTextosElementosWeb(wp_detalleCartera_tituloBy).getFirst();
    }

    public String obtenerTextoDetalleCarteraEstado(){
        return obtenerTextosElementosWeb(wp_detalleCartera_InformacionGeneral_estadoBy).getFirst();
    }

    public String obtenerTextoCarterasActivadasTitulo(){
        return obtenerTextosElementosWeb(wp_carterasActivadas_tituloBy).getFirst();
    }

    public String obtenerTextoCarterasRevocadasTitulo(){
        return obtenerTextosElementosWeb(wp_carterasRevocadas_tituloBy).getFirst();
    }

    public String obtenerTextoHistoricoRevocacionTitulo(){
        return obtenerTextosElementosWeb(wp_historicoRevocacion_tituloBy).getFirst();
    }

    public String obtenerTextoHistoricoRevocacionEstado(){
        return obtenerTextosElementosWeb(wp_hitoricoRevocacion_TablaEstadoBy).getFirst();
    }

    public String obtenerTextoDetalleHistoricoRevocacionTitulo(){
        return obtenerTextosElementosWeb(wp_detalleHistoricoRevocacion_tituloBy).getFirst();
    }

    public String obtenerTextoDetalleHistoricoRevocacionEstado(){
        return obtenerTextosElementosWeb(wp_detalleCartera_InformacionGeneral_estadoBy).getFirst();
    }

    /**
     * Utiliza {@link #seleccionarDeLista(By, String)} en su lugar.
     * @param opcion           El value asociado al option en el identificador
     * @deprecated Desde que se implementa el metodo {@link #seleccionarDeLista(By, String)}, que es válido para todos los tipos de localizador
     * ya que se pasa el By. Este metodo solo es valido para id y además presupone conocer values internos en lugar
     * de los textos visibles.
     */
    public void seleccionComboEstado(String opcion) {
        WebElement we;
        try {
            System.out.println("Esperando a que el elemento sea visible...");
            we = wait.until(ExpectedConditions.visibilityOfElementLocated(comboEstadoBy));
            //Scrollear hasta el elemento
            new Actions(driver).scrollToElement(we).perform();
            System.out.println("Rellenando combobox");
            Select comboBox = new Select(we);
            comboBox.selectByValue(opcion);
            //comboBox.selectByVisibleText(opcion);
            System.out.println("Combobox seleccionado: " + opcion);

        } catch (Exception e) {
            System.out.println("Excepción al seleccionar combo: " + e);
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void seleccionMotivoRevocacion(String opcion) {
        WebElement we;
        try {
            System.out.println("Esperando a que el elemento sea visible...");
            we = wait.until(ExpectedConditions.visibilityOfElementLocated(wp_detalleCartera_RevocacionComboMotivoRevocacionBy));
            //Scrollear hasta el elemento
            new Actions(driver).scrollToElement(we).perform();
            System.out.println("Rellenando combobox");
            Select comboBox = new Select(we);
            comboBox.selectByValue(opcion);
            //comboBox.selectByVisibleText(opcion);
            System.out.println("Combobox seleccionado: " + opcion);

        } catch (Exception e) {
            System.out.println("Excepción al seleccionar combo: " + e);
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}

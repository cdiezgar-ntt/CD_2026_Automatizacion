package com.nttdata.automation.steps;

import com.nttdata.automation.pages.WP_DetalleCartera;
import com.nttdata.automation.reports.Report;
import com.nttdata.automation.utils.Cartera;
import com.nttdata.automation.validation.Validator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import com.nttdata.automation.pages.WP_ControlPanel;
import com.nttdata.automation.hooks.ExtentReportHook;

public class WP_ControlPanel_Steps {

    WP_ControlPanel wp_cp;
    WP_DetalleCartera wp_dc;
    private final Cartera cartera;

    public WP_ControlPanel_Steps(Cartera cartera) {
        this.cartera = cartera;
        // Inicio la pantalla una sola vez
        wp_cp = new WP_ControlPanel();
        wp_dc = new WP_DetalleCartera();
    }

    /**
     * Step Wallet Provider:
     * <p>Llama al método clickBtnBuscar() de la clase WP_ControlPanel para hacer click en el botón "Buscar" de la pantalla de inicio del Control Panel del Wallet Provider</p>
     */
    @When("Click en el botón buscar - portal wallet provider")
    public void hacerClickEnElBotonBuscar() {
        wp_cp.clickBtnBuscar();
        System.out.println("Botón buscar clickeado");
        Report.info("Botón buscar clickeado");
    }

    /**
     * Step Wallet Provider:
     * <p>Llama al método clickPrimerElementoLista() de la clase WP_ControlPanel para hacer click en el primer elemento de la lista de resultados de búsqueda de la pantalla de inicio del Control Panel del Wallet Provider</p>
     */
    @And("Click en el primer elemento de la lista - portal wallet provider")
    public void clickEnElPrimerElementoDeLaLista() {
        System.out.println("Clicando en el primer elemento de la lista");
        Report.info("Clicando en el primer elemento de la lista");
        wp_cp.clickPrimerElementoLista();
        System.out.println("Primer elemento de la lista clicado");
        Report.info("Primer elemento de la lista clicado");
    }

    /**
     * Step Wallet Provider:
     * <p>Llama al método rellenarCampoBusquedaEmail(String textoBusqueda) de la clase WP_ControlPanel para rellenar el campo de búsqueda por email de la pantalla de inicio del Control Panel del Wallet Provider con el texto pasado como parámetro</p>
     * @param texto: String con el texto a introducir en el campo de búsqueda por email
     */
    @Given("Rellenar el texto {string} en el campo de busqueda email - portal wallet provider")
    public void rellenarElTextoEnElCampoDeBusquedaEmail(String texto) {
        System.out.println("Rellenando el campo de búsqueda email con el texto: " + texto);
        Report.info("Rellenando el campo de búsqueda email con el texto: " + texto);
        wp_cp.rellenarCampoBusquedaEmail(texto);
        System.out.println("Texto '" + texto + "' rellenado en el campo de búsqueda ");
        Report.info("Texto '" + texto + "' rellenado en el campo de búsqueda ");
    }

    @Given("El usuario escribe un email existente")
    public void rellenarMailExistente() {
        String email = cartera.getEmail();
        ExtentReportHook.getTest().info("Buscando email " + email + "...");
        wp_cp.rellenarCampoBusquedaEmail(email);
    }


//

//    @And("Rellenar el texto {string} en el campo de busqueda IdCartera")
//    public void rellenarElTextoEnElCampoDeBusquedaIdCartera(String texto) {
//        System.out.println("Rellenando el campo de búsqueda IdCartera con el texto: " + texto);
//        Report.info("Rellenando el campo de búsqueda IdCartera con el texto: " + texto);
//        wp_cp.rellenarCampoBusquedaIdCartera(texto);
//        System.out.println("Texto '" + texto + "' rellenado en el campo de búsqueda ");
//        Report.info("Texto '" + texto + "' rellenado en el campo de búsqueda ");
//    }
//
//    @And("Rellenar el texto {string} en el campo de busqueda Telefono")
//    public void rellenarElTextoEnElCampoDeBusquedaTelefono(String texto) {
//        System.out.println("Rellenando el campo de búsqueda Telefono con el texto: " + texto);
//        Report.info("Rellenando el campo de búsqueda Telefono con el texto: " + texto);
//        wp_cp.rellenarCampoBusquedaTelefono(texto);
//        System.out.println("Texto '" + texto + "' rellenado en el campo de búsqueda ");
//        Report.info("Texto '" + texto + "' rellenado en el campo de búsqueda ");
//    }
//
//    @And("Seleccionar el combo Estado con el texto {string}")
//    public void seleccionarElComboEstadoConElTexto(String texto) {
//        System.out.println("Seleccionando el combo Estado con el texto: " + texto);
//        Report.info("Seleccionando el combo Estado con el texto: " + texto);
//        wp_cp.seleccionarComboEstado(texto);
//        System.out.println("Combo Estado seleccionado con el texto: " + texto);
//        Report.info("Combo Estado seleccionado con el texto: " + texto);
//    }
//
//    @And("Seleccionar el combo Rango Fechas Activacion con el texto {string}")
//    public void seleccionarElComboRangoFechasActivacionConElTexto(String texto) {
//        System.out.println("Seleccionando el combo Rango Fechas Activacion con el texto: " + texto);
//        Report.info("Seleccionando el combo Rango Fechas Activacion con el texto: " + texto);
//        wp_cp.seleccionarComboRangoFechasActivacion(texto);
//        System.out.println("Combo Rango Fechas Activacion seleccionado con el texto: " + texto);
//        Report.info("Combo Rango Fechas Activacion seleccionado con el texto: " + texto);
//    }
//
//    @And("Seleccionar el combo Rango Fechas Revocacion con el texto {string}")
//    public void seleccionarElComboRangoFechasRevocacionConElTexto(String texto) {
//        System.out.println("Seleccionando el combo Rango Fechas Revocacion con el texto: " + texto);
//        Report.info("Seleccionando el combo Rango Fechas Revocacion con el texto: " + texto);
//        wp_cp.seleccionarComboRangoFechasRevocacion(texto);
//        System.out.println("Combo Rango Fechas Revocacion seleccionado con el texto: " + texto);
//        Report.info("Combo Rango Fechas Revocacion seleccionado con el texto: " + texto);
//    }
//
//    @And("Seleccionar el combo Motivo Revocacion con el texto {string}")
//    public void seleccionarElComboMotivoRevocacionConElTexto(String texto) {
//        System.out.println("Seleccionando el combo Motivo Revocacion con el texto: " + texto);
//        Report.info("Seleccionando el combo Motivo Revocacion con el texto: " + texto);
//        wp_cp.seleccionarComboMotivoRevocacion(texto);
//        System.out.println("Combo Motivo Revocacion seleccionado con el texto: " + texto);
//        Report.info("Combo Motivo Revocacion seleccionado con el texto: " + texto);
//    }
//
//    @And("Seleccionar el combo Medio Solicitud Revocacion con el texto {string}")
//    public void seleccionarElComboMedioSolicitudRevocacionConElTexto(String texto) {
//        System.out.println("Seleccionando el combo Medio Solicitud Revocacion con el texto: " + texto);
//        Report.info("Seleccionando el combo Medio Solicitud Revocacion con el texto: " + texto);
//        wp_cp.seleccionarComboMedioSolicitudRevocacion(texto);
//        System.out.println("Combo Medio Solicitud Revocacion seleccionado con el texto: " + texto);
//        Report.info("Combo Medio Solicitud Revocacion seleccionado con el texto: " + texto);
//    }
//
//    @And("Click en el checkbox Mostrar Solo Mis Revocaciones")
//    public void clickEnElCheckboxMostrarSoloMisRevocaciones() {
//        System.out.println("Clicando en el checkbox Mostrar Solo Mis Revocaciones");
//        Report.info("Clicando en el checkbox Mostrar Solo Mis Revocaciones");
//        wp_cp.clickCheckMostrarSoloMisRevocaciones();
//        System.out.println("Checkbox Mostrar Solo Mis Revocaciones clicado");
//        Report.info("Checkbox Mostrar Solo Mis Revocaciones clicado");
//    }
//
//    @And("Click en el link Mostrar Busqueda Avanzada")
//    public void clickEnElLinkMostrarBusquedaAvanzada() {
//        System.out.println("Clicando en el link Mostrar Busqueda Avanzada");
//        Report.info("Clicando en el link Mostrar Busqueda Avanzada");
//        wp_cp.clickLinkMostrarBusquedaAvanzada();
//        System.out.println("Link Mostrar Busqueda Avanzada clicado");
//        Report.info("Link Mostrar Busqueda Avanzada clicado");
//    }
//
//    @And("Click en el link Ocultar Busqueda Avanzada")
//    public void clickEnElLinkOcultarBusquedaAvanzada() {
//        System.out.println("Clicando en el link Ocultar Busqueda Avanzada");
//        Report.info("Clicando en el link Ocultar Busqueda Avanzada");
//        wp_cp.clickLinkOcultarBusquedaAvanzada();
//        System.out.println("Link Ocultar Busqueda Avanzada clicado");
//        Report.info("Link Ocultar Busqueda Avanzada clicado");
//    }
//
//    @And("Seleccionar el combo Sistema Operativo con el texto {string}")
//    public void seleccionarElComboSistemaOperativoConElTexto(String texto) {
//        System.out.println("Seleccionando el combo Sistema Operativo con el texto: " + texto);
//        Report.info("Seleccionando el combo Sistema Operativo con el texto: " + texto);
//        wp_cp.seleccionarComboSistemaOperativo(texto);
//        System.out.println("Combo Sistema Operativo seleccionado con el texto: " + texto);
//        Report.info("Combo Sistema Operativo seleccionado con el texto: " + texto);
//    }
//
//    @And("Seleccionar el combo Version TC con el texto {string}")
//    public void seleccionarElComboVersionTCConElTexto(String texto) {
//        System.out.println("Seleccionando el combo Version TC con el texto: " + texto);
//        Report.info("Seleccionando el combo Version TC con el texto: " + texto);
//        wp_cp.seleccionarComboVersionTC(texto);
//        System.out.println("Combo Version TC seleccionado con el texto: " + texto);
//        Report.info("Combo Version TC seleccionado con el texto: " + texto);
//    }
//

    /**
     * Step Wallet Provider:
     * <p>Llama al método clickLinkHistoricoRevocaciones() de la clase WP_ControlPanel para hacer click en el link "Historico Revocaciones" de la pantalla de inicio del Control Panel del Wallet Provider</p>
     */
    @And("Click en el link Historico Revocaciones - portal wallet provider")
    public void clickEnElLinkHistoricoRevocaciones() {
        System.out.println("Clicando en el link Historico Revocaciones");
        Report.info("Clicando en el link Historico Revocaciones");
        wp_cp.clickLinkHistoricoRevocaciones();
        System.out.println("Link Historico Revocaciones clicado");
        Report.info("Link Historico Revocaciones clicado");
    }

    /**
     * Step Wallet Provider:
     * <p>Llama al método clickLinkCarterasActivadasVerTodas() de la clase WP_ControlPanel para hacer click en el link "Carteras Activadas Ver Todas" de la pantalla de inicio del Control Panel del Wallet Provider</p>
     */
    @And("Click en el botón ver todas carteras activadas ultimo mes - portal wallet provider")
    public void clickEnElLinkCarterasActivadasVerTodas() {
        System.out.println("Clicando en el link Carteras Activadas Ver Todas");
        Report.info("Clicando en el link Carteras Activadas Ver Todas");
        wp_cp.clickLinkCarterasActivadasVerTodas();
        System.out.println("Link Carteras Activadas Ver Todas clicado");
        Report.info("Link Carteras Activadas Ver Todas clicado");
    }

    /**
     * Step Wallet Provider:
     * <p>Llama al método clickLinkCarterasRevocadasVerTodas() de la clase WP_ControlPanel para hacer click en el link "Carteras Revocadas Ver Todas" de la pantalla de inicio del Control Panel del Wallet Provider</p>
     */
    @And("Click en el botón ver todas carteras revocadas ultimo mes - portal wallet provider")
    public void clickEnElLinkCarterasRevocadasVerTodas() {
        System.out.println("Clicando en el link Carteras Revocadas Ver Todas");
        Report.info("Clicando en el link Carteras Revocadas Ver Todas");
        wp_cp.clickLinkCarterasRevocadasVerTodas();
        System.out.println("Link Carteras Revocadas Ver Todas clicado");
        Report.info("Link Carteras Revocadas Ver Todas clicado");
    }

    /**
     * Step Wallet Provider:
     * <p>Llama al método clickLinkCarterasActivasVerTodas() de la clase WP_ControlPanel para hacer click en el link "Carteras Activas Ver Todas" de la pantalla de inicio del Control Panel del Wallet Provider</p>
     */
    @And("Click en el botón ver todas carteras activas ultimo mes - portal wallet provider")
    public void clickEnElLinkCarterasActivasVerTodas() {
        System.out.println("Clicando en el link Carteras Activas Ver Todas");
        Report.info("Clicando en el link Carteras Activas Ver Todas");
        wp_cp.clickLinkCarterasActivasVerTodas();
        System.out.println("Link Carteras Activas Ver Todas clicado");
        Report.info("Link Carteras Activas Ver Todas clicado");
    }

//    @And("Click en el link Ocultar Ultimo Mes")
//    public void clickEnElLinkOcultarUltimoMes() {
//        System.out.println("Clicando en el link Ocultar Ultimo Mes");
//        Report.info("Clicando en el link Ocultar Ultimo Mes");
//        wp_cp.clickLinkOcultarUltimoMes();
//        System.out.println("Link Ocultar Ultimo Mes clicado");
//        Report.info("Link Ocultar Ultimo Mes clicado");
//    }

    /**
     * Step Wallet Provider:
     * <p>Llama al método obtenerPrimerCorreo() de la clase WP_ControlPanel para obtener el texto del primer correo de la lista de resultados de búsqueda de la pantalla de inicio del Control Panel del Wallet Provider</p>
     * @return String con el texto del primer correo obtenido
     */
    @And("Obtener primer correo")
    public String obtenerPrimerCorreo() {
        String primerCorreo = wp_cp.obtenerPrimerCorreo();
        System.out.println("Primer correo obtenido: " + primerCorreo);
        Report.info("Primer correo obtenido: " + primerCorreo);
        return primerCorreo;
    }

    @When("El estado de la cartera es {string}")
    public void validarEstadoCartera(String estado_esperado) {
        Validator.validarVerdadero(wp_dc.obtenerEstadoCartera().contains(estado_esperado), "La cartera está en el estado: " + estado_esperado,true);
    }

    @And("Click en el botón revocar cartera - portal wallet provider")
    public void detalleCarteraRevocarCartera() {
        System.out.println("Clicando en el botón revocar cartera");
        Report.info("Clicando en el botón revocar cartera");
        wp_dc.clickBtnDetallesRevocarCartera();
        System.out.println("Botón revocar cartera clicado");
        Report.info("Botón revocar cartera clicado");
    }

    @And("Click en el botón confirmar revocación - portal wallet provider detalle de cartera")
    public void detalleCarteraConfirmarRevocacion() {
        System.out.println("Clicando en el botón confirmar revocación");
        Report.info("Clicando en el botón confirmar revocación");
        wp_dc.clickBtnSiRevocar();
        System.out.println("Botón confirmar revocación clicado");
        Report.info("Botón confirmar revocación clicado");
    }

}

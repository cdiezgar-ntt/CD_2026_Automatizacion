package com.nttdata.automation.steps;

import com.nttdata.automation.driver.DriverManager;
import com.nttdata.automation.pages.CIT_PortalUsuario;
import com.nttdata.automation.hooks.ExtentReportHook;
import com.nttdata.automation.pages.WP_Carteras;
import com.nttdata.automation.pages.WP_ControlPanel;
import com.nttdata.automation.utils.Elementos_web;
import com.nttdata.automation.utils.Properties;
import com.nttdata.automation.validation.Validator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WindowType;

import java.util.List;

public class PortalUsuario_ControlPanel_Steps {

    public CIT_PortalUsuario portal_usuario;

    public PortalUsuario_ControlPanel_Steps() {
        // Inicio la pantalla una sola vez
        portal_usuario = new CIT_PortalUsuario();
    }

    @Then("El titulo de la home es {string}")
    public void validarTituloHomeEnIdioma(String titulo_home) {
        Validator.validarVerdadero(portal_usuario.getTituloHome().contentEquals(titulo_home),
                "El titulo de la home es " + titulo_home, true);
    }

    @Then("El usuario visualiza 3 tipos de revocación")
    public void visualizarTiposRevocacion() {
        int numero_opciones_revocacion = portal_usuario.getTitulosTiposRevocacion().size();
        Validator.validarVerdadero(numero_opciones_revocacion == 3, "Existen 3 opciones de revocación", true);


    }

    @Then("El usuario visualiza la opción de revocación {string}")
    public void validarOpcionRevocacion(String opcion) {
        List<String> opcionesRevocacion = portal_usuario.getTitulosTiposRevocacion();
        Validator.validarVerdadero(opcionesRevocacion.contains(opcion), "Se encuentra la opción " + opcion);
    }

    @When("El usuario pulsa en consultar oficina")
    public void consultarOficina() {
        System.out.println("Pulsando en Comprobar oficina...");
        ExtentReportHook.getTest().info("Pulsando en Comprobar oficina...");
        portal_usuario.clickEnConsultarOficina();
    }

    @Then("El usuario accede a una pantalla con las oficinas")
    public void validarPantallaOficinas() {
        System.out.println("Obteniendo url...");
        ExtentReportHook.getTest().info("Obteniendo url...");
        String url = (DriverManager.getDriver().getCurrentUrl() == null) ? "" : DriverManager.getDriver().getCurrentUrl();
        Validator.validarVerdadero(url.endsWith("/revocacion-presencial"), "Se ha accedido a la url de revocación presencial: " + url, true);
    }

    @Then("El usuario visualiza oficinas")
    public void validarOficinas() {
        ExtentReportHook.getTest().info("Obteniendo información de oficinas...");
        String textoOficinas = portal_usuario.getTextoOficinas();
        Validator.validarVerdadero(textoOficinas.toLowerCase().contains("oficina"), "Se muestra al menos una oficina");
    }

    @Then("Existe un botón para cambiar a varios idiomas")
    public void validarBotonIdiomas() {
        System.out.println("Obteniendo texto de boton idiomas...");
        ExtentReportHook.getTest().info("Obteniendo texto de boton idiomas...");
        String textoBotonIdiomas = portal_usuario.getTextoBotonIdiomas();
        Validator.validarVerdadero(textoBotonIdiomas.contains("Español"), "Existe un texto para cambiar de idiomas con la opción Español por defecto");
    }

    @When("El usuario cambia al idioma {string}")
    public void cambiarAIdioma(String idioma) {
        System.out.println("Seleccionando idioma " + idioma);
        ExtentReportHook.getTest().info("Seleccionando idioma " + idioma);
        portal_usuario.pulsarBotonIdioma();
        portal_usuario.seleccionarIdioma(idioma);
    }

    @Then("El usuario ve las oficinas para revocar la cartera está en el {string} y es {string}")
    public void validarOficinasRevocacionCarteraEnIdioma(String idioma, String texto_revocar_Cartera) {
        List<String> textosRevocacionOficinas = portal_usuario.getTitulosRevocacionPantallaOficinas();
        Validator.validarVerdadero(textosRevocacionOficinas.contains(texto_revocar_Cartera), "El texto " + textosRevocacionOficinas + " está en el idioma " + idioma, true);
    }

    @Then("El usuario ve las oficinas para revocar la PID está en el {string} y es {string}")
    public void validarOficinasRevocacionPIDEnIdioma(String idioma, String texto_revocar_PID) {
        List<String> textosRevocacionOficinas = portal_usuario.getTitulosRevocacionPantallaOficinas();
        Validator.validarVerdadero(textosRevocacionOficinas.contains(texto_revocar_PID), "El texto " + textosRevocacionOficinas + " está en el idioma " + idioma, true);
    }

    @Then("El usuario ve una sección de preguntas frecuentes")
    public void revisarSeccionPreguntasFrecuentes() {
        boolean preguntas_frecuentes = portal_usuario.existeSeccionPreguntasFrecuentes();
        Validator.validarVerdadero(preguntas_frecuentes, "Preguntas_frecuentes", true);
    }

    @Then("Hay al menos una pregunta frecuente")
    public void revisarNumeroPreguntasFrecuentes() {
        int numero_preguntas_frecuentes = portal_usuario.getPreguntasFrecuentes().size();
        Validator.validarVerdadero(numero_preguntas_frecuentes > 0, "Hay al menos una pregunta frecuente");
    }

    @Then("Las preguntas frecuentes tienen respuesta")
    public void revisarRespuestasPreguntasFrecuentes() {
        List<String> respuestas = portal_usuario.getRespuestasPreguntasFrecuentes();
        int numero_preguntas_frecuentes = portal_usuario.getPreguntasFrecuentes().size();
        int numero_respuestas_frecuentes = respuestas.size();
        boolean todas_respuestas_no_vacias = respuestas.stream().noneMatch(r -> r.trim().isEmpty());
        Validator.validarVerdadero(numero_preguntas_frecuentes == numero_respuestas_frecuentes && todas_respuestas_no_vacias,
                "Existen tantas preguntas frecuentes como respuestas y todas tienen contenido no vacío", true);
    }

    @Then("Las respuestas están ocultas")
    public void preguntasFrecuentesOcultas() {
        List<Boolean> estado_preguntas = portal_usuario.sonLasRespuestasVisibles();
        Validator.validarVerdadero(!estado_preguntas.contains(true), "Todas las respuestas están ocultas", true);
    }

    @When("El usuario despliega las preguntas frecuentes")
    public void desplegarPreguntaFrecuente() {
        ExtentReportHook.getTest().info("Desplegando preguntas frecuentes...");
        portal_usuario.clickPreguntasFrecuentes();
    }

    @When("El usuario pliega las preguntas frecuentes")
    public void plegarPreguntaFrecuente() {
        ExtentReportHook.getTest().info("Plegando preguntas frecuentes...");
        portal_usuario.clickPreguntasFrecuentes();
    }

    @Then("El usuario visualiza una barra de navegación inferior con varias opciones")
    public void comprobarBarraNavegacion() {
        int numero_opciones_barra_navegacion = portal_usuario.getOpcionesBarraNavegacionInferior().size();
        Validator.validarVerdadero(numero_opciones_barra_navegacion > 0, "Hay opciones en la barra de navegación", true);
    }

    @Then("Existe la opción {string} en la barra de navegación")
    public void validarOpcionEnBarraNavegacion(String opcion) {
        List<String> opciones_barra_navegacion = portal_usuario.getOpcionesBarraNavegacionInferior();
        Validator.validarVerdadero(opciones_barra_navegacion.stream().anyMatch(o -> o.trim().contains(opcion)),
                "Existe la opción " + opcion + " en la barra inferior");
    }

    @Then("Los enlaces son {string}, {string}, {string}, {string}, {string}")
    public void validarEnlacesNavegacionEnIdioma(String enlace_accesibilidad, String enlace_mapaWeb, String enlaceAvisoLegal, String enlace_politicaPrivacidad, String enlace_politicaCookies) {
        List<String> enlaces_web = portal_usuario.getOpcionesBarraNavegacionInferior();
        Validator.validarVerdadero(enlaces_web.stream().anyMatch(e -> e.toLowerCase().contains(enlace_accesibilidad.toLowerCase())),
                "Se encuentra el enlace " + enlace_accesibilidad);
        Validator.validarVerdadero(enlaces_web.stream().anyMatch(e -> e.toLowerCase().contains(enlace_mapaWeb.toLowerCase())),
                "Se encuentra el enlace " + enlace_mapaWeb);
        Validator.validarVerdadero(enlaces_web.stream().anyMatch(e -> e.toLowerCase().contains(enlaceAvisoLegal.toLowerCase())),
                "Se encuentra el enlace " + enlaceAvisoLegal);
        Validator.validarVerdadero(enlaces_web.stream().anyMatch(e -> e.toLowerCase().contains(enlace_politicaPrivacidad.toLowerCase())),
                "Se encuentra el enlace " + enlace_politicaPrivacidad);
        Validator.validarVerdadero(enlaces_web.stream().anyMatch(e -> e.toLowerCase().contains(enlace_politicaCookies.toLowerCase())),
                "Se encuentra el enlace " + enlace_politicaCookies);
    }

    @When("El usuario pulsa en accesibilidad")
    public void pulsarAccesibilidad() {
        ExtentReportHook.getTest().info("Pulsando accesibilidad...");
        portal_usuario.clickAccesibilidad();
    }

    @When("El usuario pulsa en mapa web")
    public void pulsarMapaWeb() {
        ExtentReportHook.getTest().info("Pulsando Mapa Web...");
        portal_usuario.clickMapaWeb();
    }

    @When("El usuario pulsa en aviso legal")
    public void pulsarAvisoLegal() {
        ExtentReportHook.getTest().info("Pulsando Aviso Legal...");
        portal_usuario.clickAvisoLegal();
    }

    @When("El usuario pulsa en politica de privacidad")
    public void pulsarPoliticaPrivacidad() {
        ExtentReportHook.getTest().info("Pulsando Política de Privacidad");
        portal_usuario.clickPoliticaPrivacidad();
    }

    @When("El usuario pulsa en política de cookies")
    public void pulsarPoliticaCookies() {
        ExtentReportHook.getTest().info("Pulsando Política de cookies");
        portal_usuario.clickPoliticaCookies();
    }


    @Then("Se carga la pagina de {string}")
    public void validarCargaPantalla(String pantalla) {
        Validator.validarVerdadero(portal_usuario.getTituloPantallaEnlace().toLowerCase().contains(pantalla.toLowerCase()),
                "Se ha cargado la pantalla " + pantalla, true);
    }

    @When("El usuario vuelve a la home")
    public void volverHome() {
        ExtentReportHook.getTest().info("Volviendo a la home...");
        portal_usuario.clickVolver();
    }

    @When("El usuario pulsa en Revocar Cartera Digital")
    public void pulsarRevocarCarteraDigital() {
        ExtentReportHook.getTest().info("Pulsando en revocar cartera digital...");
        portal_usuario.clickRevocarCarteraDigital();
    }

    @Then("El usuario accede a la pantalla {string}")
    public void comprobarPantallaRevocacionCartera(String titulo_esperado) {
        String url = (DriverManager.getDriver().getCurrentUrl()) == null ? "" : DriverManager.getDriver().getCurrentUrl();
        Validator.validarVerdadero(url.endsWith("/revocacion-cartera"), "La url termina en /revocacion-cartera",
                true, true);
        String titulo = portal_usuario.getTituloRevocacionCartera();
        Validator.validarVerdadero(titulo.trim().contentEquals(titulo_esperado), "El titulo es " + titulo_esperado);
    }

    @Then("El botón continuar revocación está deshabilitado")
    public void validarBotonRevocarDeshabilitado() {
        Validator.validarFalso(portal_usuario.estaHabilitadoRevocacion(), "El botón revocación está deshabilitado");
    }

    @Then("Los digitos estan deshabilitados")
    public void validarDigitosDeshabilitados() {
        Validator.validarFalso(portal_usuario.estaHabilitadoDigitos(), "Los digitos estan deshabilitados");
    }

    @When("El usuario introduce el mail de una cartera válida")
    public void localizarCarteraValida_introducirMail() {

        // Se accede al WP a consultar un mail valido en una nueva pestaña
        ExtentReportHook.getTest().info("Obteniendo un email valido...");
        String mainWindow = DriverManager.getDriver().getWindowHandle();
        DriverManager.getDriver().switchTo().newWindow(WindowType.TAB);
        String url_wp = new Properties().read_v2().get(Elementos_web.abrirWebWalletProvider);
        WP_ControlPanel wallet_provider = new WP_ControlPanel();
        DriverManager.getDriver().get(url_wp);
        new CommonSteps().hacerClickEnElBotonAcceder();
        wallet_provider.clickLinkCarterasActivasVerTodas();

        String email = wallet_provider.obtenerPrimerCorreo();
        ExtentReportHook.getTest().info("Email obtenido: " + email);

        // Salimos del WP y volvemos a la pestaña
        DriverManager.getDriver().close();
        DriverManager.getDriver().switchTo().window(mainWindow);

        // Introducimos el mail encontrado
        ExtentReportHook.getTest().info("Introduciendo el mail...");
        portal_usuario.introducirEmail(email);

    }

    @Then("El usuario recibe un código de verificación")
    public void comprobarRecepcionVerificacion() {
        // Pendiente que funcione servicio de envío OTP, no se puede probar
    }

    @Then("Los digitos estan habilitados")
    public void validarDigitosHabilitados() {
        Validator.validarVerdadero(portal_usuario.estaHabilitadoDigitos(), "Los digitos estan habilitados", true, true);
    }

    @When("El usuario introduce el código de verificación recibido")
    public void introducirCodigoOtp() {
        // Pendiente que funcione servicio de envío OTP, no se puede probar
        portal_usuario.escribirOtp("000000");
    }

    @Then("Se desbloquea el botón continuar revocación")
    public void validarBotonContinuarRevocacion() {
        Validator.validarVerdadero(portal_usuario.estaHabilitadoRevocacion(), "El botón revocación está deshabilitado");
    }

    @When("El usuario pulsa en Enviar")
    public void confirmarRevocacion() {
        ExtentReportHook.getTest().info("Pulsando en 'Enviar'...");
        portal_usuario.clickEnviar();
    }

    @When("El usuario introduce el email invalido {string}")
    public void introducirEmailInvalido(String email_invalido) {
        ExtentReportHook.getTest().info("Escribiendo email invalido: " + email_invalido);
        portal_usuario.introducirEmail(email_invalido);
    }

    @Then("El portal devuelve un mensaje de error")
    public void validarMensajeError() {
        String mensajeError = portal_usuario.obtenerMensajeError();
        Validator.validarVerdadero(mensajeError.contains("El formato del mail introducido es incorrecto"), "Aparece mensaje de error", true);
    }


}


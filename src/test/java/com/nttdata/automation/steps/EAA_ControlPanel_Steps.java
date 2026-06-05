package com.nttdata.automation.steps;

import com.aventstack.extentreports.ExtentTest;
import com.nttdata.automation.driver.DriverManager;
import com.nttdata.automation.hooks.ExtentReportHook;
import com.nttdata.automation.pages.EAA_ControlPanel;
import com.nttdata.automation.reports.Report;
import com.nttdata.automation.validation.Validator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class EAA_ControlPanel_Steps {

    public static ExtentTest test = ExtentReportHook.getTest();
    EAA_ControlPanel eaa_cp;
    public EAA_ControlPanel_Steps() {
        // Inicio la pantalla una sola vez
        eaa_cp = new EAA_ControlPanel();
    }

  /*  @When("Click en el botón buscar")
    public void hacerClickBotonBuscar() {
        eaa_cp.clickBtnBuscar();
        System.out.println("Botón buscar clickeado");
        test.info("Botón buscar clickeado");
    }
  */

  /*  @And("Click en el primer elemento de la lista")
    public void clickEnElPrimerElementoDeLaLista() {
        System.out.println("Clicando en el primer elemento de la lista");
        test.info("Clicando en el primer elemento de la lista");
        eaa_cp.clickPrimerElementoLista();
        System.out.println("Primer elemento de la lista clicado");
        test.info("Primer elemento de la lista clicado");
    }
*/

/*    @Given("Rellenar el texto {string} en el campo de busqueda email")
    public void rellenarElTextoEnElCampoDeBusquedaEmail(String texto) {
        System.out.println("Rellenando el campo de búsqueda email con el texto: " + texto);
        test.info("Rellenando el campo de búsqueda email con el texto: " + texto);
        eaa_cp.rellenarCampoBusquedaEmail(texto);
        System.out.println("Texto '" + texto + "' rellenado en el campo de búsqueda ");
        test.info("Texto '" + texto + "' rellenado en el campo de búsqueda ");
    }
*/
    @Then("Validar que se accede al panel de control de EAA")
    //validar que se accede al control panel mediante la url
    public void validarPantallaControlPanel() {
        String url = eaa_cp.currentUrl();
        Validator.validarVerdadero(url.contains("eaa") && url.contains("control-panel"), "Se ha accedido al panel de eaa. La url contiene 'eaa' y 'control-panel'");
        String titulo_pagina = eaa_cp.obtenerTituloPortal();
        Validator.validarVerdadero(titulo_pagina.contains("Portal EAA Provider"), "El titulo del portal es 'Portal EAA Provider'");
 }


    @Then("Validar que el numero de credenciales tenga un numero mayor que 0")
    public void validarBusquedaCredencialesSinFiltro(){
        System.out.println("validando que hay coincidencias en la búsqueda");
        Report.info("validando que hay coincidencias en la búsqueda");
        int total = eaa_cp.obtenerTotalCarteras();
        Validator.validarVerdadero(total > 0,"Hay varias carteras", true);
    }

    @And("Click en el primer elemento de la lista EAA")
    public void clickPrimerElementoBusqueda(){
        System.out.println("Clicando en el primer elemento de la lista");
        test.info("Clicando en el primer elemento de la lista");
        eaa_cp.clickPrimerElementoLista();
        System.out.println("Primer elemento de la lista clicado");
        test.info("Primer elemento de la lista clicado");

    }

    @Then("Validar el estado de la credencial {string}")
    public void validarEstadoDetalleCredencial(String estado_esperado){
       String estado_web;
       estado_web =  eaa_cp.obtenerTextoEstadoDetalleCredencial();
       Validator.validarVerdadero(estado_web.contains(estado_esperado),"El estado de la credencial es: " + estado_esperado,true);
    }

    @Then("Se muestra un listado de credenciales")
    public void comprobarListadoCredenciales() {
        List<String> credenciales = eaa_cp.obtenerIdsCredenciales();
        Validator.validarVerdadero(!credenciales.isEmpty(), "El listado contiene credenciales: " + credenciales);
    }

    @When("El usuario pulsa en buscar")
    public void buscar() {
        Report.info("Pulsando en buscar...");
        eaa_cp.clickEnBuscar();
    }

}

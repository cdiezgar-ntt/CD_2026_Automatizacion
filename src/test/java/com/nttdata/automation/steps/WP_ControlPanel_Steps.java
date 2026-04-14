package com.nttdata.automation.steps;

import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import com.nttdata.automation.pages.WP_ControlPanel;
import com.nttdata.automation.hooks.ExtentReportHook;

public class WP_ControlPanel_Steps {

    WP_ControlPanel wp_cp;

    public WP_ControlPanel_Steps() {
        // Inicio la pantalla una sola vez
        wp_cp = new WP_ControlPanel();
    }

    public static ExtentTest test = ExtentReportHook.getTest();

    @When("Click en el botón buscar")
    public void hacerClickEnElBotonBuscar() {
        wp_cp.clickBtnBuscar();
        System.out.println("Botón buscar clickeado");
        test.info("Botón buscar clickeado");
    }

    @And("Click en el primer elemento de la lista")
    public void clickEnElPrimerElementoDeLaLista() {
        System.out.println("Clicando en el primer elemento de la lista");
        test.info("Clicando en el primer elemento de la lista");
        wp_cp.clickPrimerElementoLista();
        System.out.println("Primer elemento de la lista clicado");
        test.info("Primer elemento de la lista clicado");
    }



    @Given("Rellenar el texto {string} en el campo de búsqueda email")
    public void rellenarElTextoEnElCampoDeBusquedaEmail(String texto) {
        System.out.println("Rellenando el campo de búsqueda email con el texto: " + texto);
        test.info("Rellenando el campo de búsqueda email con el texto: " + texto);
        wp_cp.rellenarCampoBusquedaEmail(texto);
        System.out.println("Texto '" + texto + "' rellenado en el campo de búsqueda ");
        test.info("Texto '" + texto + "' rellenado en el campo de búsqueda ");
    }

//


    @And("Click en el primer elemento de la lista con busqueda")
    public void clickEnElPrimerElementoDeLaListaBusquedaEmail() {
        System.out.println("Clicando en el primer elemento de la lista");
        test.info("Clicando en el primer elemento de la lista");
        wp_cp.clickPrimerElementoListaBusquedaEmail();
        System.out.println("Primer elemento de la lista clicado");
        test.info("Primer elemento de la lista clicado");
    }
}

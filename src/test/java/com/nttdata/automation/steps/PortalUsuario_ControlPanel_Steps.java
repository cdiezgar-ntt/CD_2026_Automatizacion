package com.nttdata.automation.steps;

import com.aventstack.extentreports.ExtentTest;
import com.nttdata.automation.hooks.ExtentReportHook;
import com.nttdata.automation.pages.CIT_PortalUsuario;
import com.nttdata.automation.pages.WP_ControlPanel;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class PortalUsuario_ControlPanel_Steps {

    public static ExtentTest test = ExtentReportHook.getTest();

    public CIT_PortalUsuario portal_usuario;

    public PortalUsuario_ControlPanel_Steps() {
        // Inicio la pantalla una sola vez
        portal_usuario = new CIT_PortalUsuario();
    }

    @When("Acceder a la pantalla Aviso Legal por el pie de pagina")
    public void hacerClickEnAvisoLegal() {
        System.out.println("Se pulsa en aviso legal");
        test.info("Se pulsa en aviso legal");
        portal_usuario.clickEnAvisoLegal();
    }

    @Then("Visualizar el contenido del aviso legal")
    public void visualizarAvisoLegal() {
        System.out.println("Se comprueba el contenido del título de aviso legal");
        test.info("Se comprueba el contenido del título aviso legal");
        String titulo = portal_usuario.getTituloPantallaEnlace();
        Assert.assertEquals("Aviso Legal", titulo);
    }

}

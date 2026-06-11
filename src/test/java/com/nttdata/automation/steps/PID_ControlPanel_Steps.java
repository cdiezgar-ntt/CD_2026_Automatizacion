package com.nttdata.automation.steps;

import com.nttdata.automation.pages.PID_ControlPanel;
import com.nttdata.automation.validation.Validator;
import io.cucumber.java.en.Then;

public class PID_ControlPanel_Steps {

    private final PID_ControlPanel portalPid;

    public PID_ControlPanel_Steps() {
        portalPid = new PID_ControlPanel();
    }

    @Then("Se abre el portal PID Provider")
    public void comprobarAperturaPortalPid() {
        Validator.validarVerdadero(portalPid.getTituloPortal().contains("PID Provider"),
                "El titulo es el del portal PID Provider");
        Validator.validarVerdadero(portalPid.currentUrl().endsWith("/control-panel/home"),
                "La url es la del pid provider", true, true);
    }

}

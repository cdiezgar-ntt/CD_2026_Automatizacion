package com.nttdata.automation.steps;

import com.aventstack.extentreports.ExtentTest;
import com.nttdata.automation.driver.DriverManager;
import com.nttdata.automation.hooks.ExtentReportHook;
import com.nttdata.automation.pages.PID_ControlPanel;
import com.nttdata.automation.validation.Validator;
import io.cucumber.java.en.Then;

public class PID_ControlPanel_Steps {

    public static ExtentTest test = ExtentReportHook.getTest();

    private PID_ControlPanel portal_pid;

    public PID_ControlPanel_Steps() {
        portal_pid = new PID_ControlPanel();
    }

    @Then("Se abre el portal PID Provider")
    public void comprobarAperturaPortalPid() {
        Validator.validarVerdadero(portal_pid.getTituloPortal().contains("PID Provider"),
                "El titulo es el del portal PID Provider");
        Validator.validarVerdadero(portal_pid.currentUrl().endsWith("/control-panel/home"),
                "La url es la del pid provider", true, true);
    }

}

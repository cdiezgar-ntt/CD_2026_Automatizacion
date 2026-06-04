package com.nttdata.automation.pages;

import com.nttdata.automation.base.BasePageObject;
import org.openqa.selenium.By;

public class PID_ControlPanel extends BasePageObject {

    private final By titulo_portal = tag("titulo_portal");

    public PID_ControlPanel() {
        super("elements/web_pid.properties");
    }

    public String getTituloPortal() {
        return obtenerTextosElementosWeb(titulo_portal).getFirst();
    }

}

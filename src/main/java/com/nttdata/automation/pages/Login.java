package com.nttdata.automation.pages;

import com.nttdata.automation.base.BasePageObject;
import org.openqa.selenium.By;

public class Login extends BasePageObject {

    private final By btnAccederBy =classname("pantallaLogin_BotonAcceder");
    private final By btonAccederDeTodosModosBy = id("proceed-button");

    public Login() {
        super("elements/web_login.properties");
    }

    public void clickBtnAcceder(){
        pulsar(btnAccederBy);
    }

    public void clickAccederTodosModos() {
        pulsar(btonAccederDeTodosModosBy);
    }

    public void abrirWebPortalUsuario(){
        driver.get(url("web_usuario"));
    }

    public void abrirWebPortalAdministrador_WP(){
        driver.get(url("web_wp"));
    }

    public void abrirWebPortalAdministrador_EEAProvider(){
        driver.get(url("web_eaa"));
    }

    public void abrirWebPortalAdministrador_PIDProvider(){
        driver.get(url("web_pid"));
    }



}

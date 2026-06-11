package com.nttdata.automation.pages;

import com.nttdata.automation.base.BasePageObject;
import com.nttdata.automation.utils.EnvironmentConfig;
import org.openqa.selenium.By;

public class Login extends BasePageObject {

    private final By btnAccederBy =classname("pantallaLogin_BotonAcceder");
    private final By btonAccederDeTodosModosBy = id("pantallaLogin_EnviarDeTodosModos");

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
        driver.get(new EnvironmentConfig(propertiesReader).environmentProperty("web_usuario"));
    }

    public void abrirWebPortalAdministrador_WP(){
        driver.get(new EnvironmentConfig(propertiesReader).environmentProperty("web_wp"));
    }

    public void abrirWebPortalAdministrador_EEAProvider(){
        driver.get(new EnvironmentConfig(propertiesReader).environmentProperty("web_eaa"));
    }

    public void abrirWebPortalAdministrador_PIDProvider(){
        driver.get(new EnvironmentConfig(propertiesReader).environmentProperty("web_pid"));
    }

    public boolean apareceInicioNoSeguro() {
        return esVisibleEnPantalla(btonAccederDeTodosModosBy);
    }

}

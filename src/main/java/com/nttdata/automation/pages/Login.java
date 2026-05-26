package com.nttdata.automation.pages;

import com.nttdata.automation.base.BasePageObject;
import com.nttdata.automation.utils.Elementos_web;
import org.openqa.selenium.By;

public class Login extends BasePageObject {

    private final By btnAccederBy =classname("pantallaLogin_BotonAcceder");

    public Login() {
        super("elements/web_login.properties");
    }

    public void clickBtnAcceder(){
        pulsar(btnAccederBy);
    }

}

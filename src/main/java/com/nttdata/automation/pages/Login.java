package com.nttdata.automation.pages;

import com.nttdata.automation.base.BasePageObject;
import org.openqa.selenium.By;

public class Login extends BasePageObject {

    private final By btnAccederBy = By.className(prop.getPantallaLogin_BotonAcceder());

    public void clickBtnAcceder(){
        pulsar(btnAccederBy);
    }

}

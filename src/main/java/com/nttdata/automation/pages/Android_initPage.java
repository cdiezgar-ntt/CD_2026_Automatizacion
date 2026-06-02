package com.nttdata.automation.pages;

import com.nttdata.automation.driver.appiumDriver;
//import drivers.AppiumDriverFactory;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;

public class Android_initPage {

    // Identificadores de ejemplo (Cámbialos por los reales de tu App usando Appium Inspector)
    @AndroidFindBy(accessibility = "input-email")
    private WebElement txtEmail;

    @AndroidFindBy(id = "com.ejemplo.myapp:id/input_password")
    private WebElement txtPassword;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='INGRESAR']")
    private WebElement btnIngresar;

    public Android_initPage() {
        // Inicializa los elementos con el decorador móvil obligatorio de Appium
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver.getDriver(), Duration.ofSeconds(10)), this);
    }

    public void ingresarCredenciales(String email, String password) {
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
    }

    public void hacerClicEnIngresar() {
        btnIngresar.click();
    }
}

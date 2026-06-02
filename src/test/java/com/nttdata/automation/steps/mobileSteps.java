package com.nttdata.automation.steps;


import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;

import com.nttdata.automation.pages.Android_initPage;
import com.nttdata.automation.driver.appiumDriver;


public class mobileSteps {

    Android_initPage androidApp;
    appiumDriver driverapp;

    @Given("que el sistema enciende el emulador e instala la aplicación móvil")
    public void encenderEInstalarApp() {
        // Al invocar initDriver, Appium levanta el emulador e instala el APK automáticamente
        appiumDriver.initDriver();
    }

    @Given("que el usuario se encuentra en la pantalla de login de la App")
    public void usuarioEnPantallaLogin() {
        // Al instanciar la página por primera vez, se disparará initDriver()
        // y el emulador se encenderá en tu pantalla automáticamente.
        androidApp = new Android_initPage();
    }

    @When("ingresa su correo {string} y clave {string} en el dispositivo móvil")
    public void ingresaCredencialesMovil(String usuario, String password) {
        androidApp.ingresarCredenciales(usuario, password);
    }

    @When("presiona el botón de inicio de sesión de la App")
    public void presionaBotonIngresar() {
        androidApp.hacerClicEnIngresar();
    }
}

package com.nttdata.automation.steps;


import com.nttdata.automation.utils.androidInfraestructura;
import com.nttdata.automation.utils.qr_manager;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;

import com.nttdata.automation.pages.Android_initPage;
import com.nttdata.automation.driver.appiumDriver;


public class mobileSteps {

    Android_initPage androidApp;
    qr_manager qrManager = new qr_manager();

    @Given("levanta el emulador de Android")
    public void verificarYLevantarInfraestructuraAndroid() {
        // Ejecuta el control inteligente antes de que actúe tu driver actual
        androidInfraestructura.prepareAndroidEnvironment();
    }

    @Given("que el sistema enciende el emulador e instala la aplicación móvil")
    public void encenderEInstalarApp() {
        appiumDriver.initDriver();

        AndroidDriver driverActivo = appiumDriver.getDriver();
        androidApp = new Android_initPage(driverActivo);
    }

    @When("presiona el botón de siguiente")
    public void presionaBotonSiguiente() {
        androidApp.hacerClicEnSiguiente1();
    }

    @When("presiona el botón de empezar")
    public void presionaBotonEmpezar() {
        androidApp.hacerClicEnEmpezar();
    }

    @When("hago scroll hasta términos y condiciones")
    public void scrollHastaTyC() {
        androidApp.scrollPantallaTyC();
    }

    @When("presiona politicas de privacidad")
    public void presionaPoliticasPrivacidad() {
        androidApp.hacerClicEnTyC1();
    }

    @When("presiona aviso legal y términos y condiciones")
    public void presionaAvisoLegalTyC() {
        androidApp.hacerClicEnTyC2();
    }

    @When("presiona acepar términos y condiciones")
    public void presionaAceptarTyC() {
        androidApp.hacerClicEnAceptarTyC();
    }

    @Given("que el sistema prepara el código QR {string}")
    public void prepararCodigoQR(String nombreQR) {
        qrManager.cambiarQrEnEmulador(nombreQR);
    }

    @When("abre el escáner de QR")
    public void abrirEscaner() {
        //androidApp.hacerClicEnBotonEscanear();
    }


    @After ("Android")
    public void finalizarEscenario() {
        if (appiumDriver.getDriver() != null) {

            appiumDriver.getDriver().quit();
            appiumDriver.resetDriver();
        }
    }
}

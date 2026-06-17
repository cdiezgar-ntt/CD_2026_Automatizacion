package com.nttdata.automation.pages;

//import drivers.AppiumDriverFactory;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
        import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
        import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;


public class Android_initPage {

    private AndroidDriver driverMovil;

    @AndroidFindBy(xpath = "//android.widget.Button[@clickable='true']")
    private WebElement btnSiguientePantallaLogin1;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Empezar\"]")
    private WebElement btnEmpezarPantallaLogin;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"He leído y estoy de acuerdo con la Política de Privacidad. no seleccionado\"]")
    private WebElement tyc1;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"He leído y estoy de acuerdo con el Aviso Legal y los Términos y Condiciones de Uso. no seleccionado\"]")
    private WebElement tyc2;
    @AndroidFindBy(xpath = "(//android.widget.Button[@content-desc=\"Aceptar\"])[2]")
    private WebElement tycAceptar;

    public Android_initPage(AndroidDriver driverMov) {
        this.driverMovil = driverMov;
        PageFactory.initElements(new AppiumFieldDecorator(driverMov), this);
    }

    public void hacerClicEnSiguiente1() {
        WebDriverWait wait = new WebDriverWait(driverMovil, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(btnSiguientePantallaLogin1));
        int x = 530;
        int y = 2238;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);

        // Mover el dedo virtual a la coordenada
        tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
        // Presionar la pantalla
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driverMovil.perform(Collections.singletonList(tap));
    }

    public void hacerClicEnEmpezar() {
        WebDriverWait wait = new WebDriverWait(driverMovil, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(btnEmpezarPantallaLogin));
        btnEmpezarPantallaLogin.click();
    }

    public void scrollPantallaTyC(){
        String scrollAlFinalSelector = "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(60);";
       // String scrollAlFinalSelector = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Aceptar\"))";
                driverMovil.findElement(AppiumBy.androidUIAutomator(scrollAlFinalSelector));

        }

    public void hacerClicEnTyC1() {
        WebDriverWait wait = new WebDriverWait(driverMovil, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(tyc1));
        tyc1.click();
    }

    public void hacerClicEnTyC2() {
        WebDriverWait wait = new WebDriverWait(driverMovil, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(tyc2));
        tyc2.click();
    }

    public void hacerClicEnAceptarTyC() {
        WebDriverWait wait = new WebDriverWait(driverMovil, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(tycAceptar));
        tycAceptar.click();
    }


}

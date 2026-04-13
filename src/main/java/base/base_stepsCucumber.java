package base;

import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.properties;
import utils.reports.extentReportHook;

import java.awt.*;
import java.awt.event.KeyEvent;

public class base_stepsCucumber {

    public static ExtentTest test = extentReportHook.getTest();

    public static WebDriver driver;

    public static properties prop = new properties();

    @Given("Abrir la web {string}")
    public void abrirElNavegadorChrome(String web) {

        prop.readPantallaPrincipalPaths();

        // Establecer la ruta del ChromeDriver
        System.setProperty("webdriver.chrome.driver", "elements/drivers/chromedriver.exe");

        // Opciones de Chrome (opcional)
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        // Iniciar ChromeDriver
        //WebDriver
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        System.out.println("Chrome abierto y maximizado");

        // Abre la página
        //driver.get("https://pre-wp-cd.redsara.es/control-panel/");
        driver.get(web);
        System.out.println("Accediendo a web" + web);
        test.info("Accediendo a web" + web);


    }

    @And("Esperar 5 segundos")
    public void esperarSegundos() {
        try {
            basePageObject bpo = new basePageObject();
            bpo.wait5seconds();
            System.out.println("Esperando 5 segundos");
            test.info("Esperando 5 segundos");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("Click en el botón acceder")
    public void hacerClickEnElBotónAcceder() {
        System.out.println("Se va a clicar en acceder");
        pageObject.wp_controlPanel wp_cp = new pageObject.wp_controlPanel(driver);
        wp_cp.clickBtnAcceder();
        System.out.println("Botón acceder clickeado");
        test.info("Botón acceder clickeado");
    }

    @And("Intro en certificado")
    public void introCertificado() {
        try {
            System.out.println("Entrando en clase robot para esperar 2 segundos");
            Robot robot = new Robot();
            Thread.sleep(2000);

            System.out.println("Tiempo esperado pulsando botón");
            // Simular Enter para confirmar la selección
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            System.out.println("Botón pulsado");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("Cerrar el navegador")
    public void cerrarElNavegador() {
        if (driver != null) {
            driver.quit();
            System.out.println("Navegador cerrado");
            test.info("Navegador cerrado");
        }
    }

}

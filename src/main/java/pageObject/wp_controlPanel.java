package pageObject;

import base.basePageObject;
import base.base_stepsCucumber;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.*;

public class wp_controlPanel {

    static basePageObject base = new basePageObject();

    WebDriver driver;

    public WebElement btnAcceder;
    public WebElement btnBuscar;
    public WebElement primerElementoLista;
    public WebElement textBoxEmail;
    public WebElement btnBuscarEmail;
    public WebElement primerElementoListaBusquedaEmail;


    private By btnAccederBy = By.className(base_stepsCucumber.prop.getPantallaLogin_BotonAcceder());
    private By btnBuscarBy = By.xpath(base_stepsCucumber.prop.getPantallaInicio_BotonBuscar());
    private By primerElementoListaBy = By.xpath(base_stepsCucumber.prop.getPantallaInicio_PrimerElementoTabla());
    //private By textBoxEmailBy = By.id(base_stepsCucumber.prop.getPantallaInicio_textBoxEmail());
    private By textBoxEmailBy = By.xpath(base_stepsCucumber.prop.getPantallaInicio_textBoxEmail());
    private By primerElementoListaBusquedaEmailBy = By.xpath(base_stepsCucumber.prop.getPantallaInicio_primerElementoTablaBusquedaEmail());
    private By btnBuscarEmailBy = By.xpath(base_stepsCucumber.prop.getPantallaInicio_BotonBuscarEmail());

    public wp_controlPanel(WebDriver driver){
        this.driver = driver;
    }

    public void clickBtnAcceder(){
//        System.out.println("Dentro del metodo clicBtnAcceder");
//        btnAcceder = driver.findElement(btnAccederBy);
//        btnAcceder.click();
//        System.out.println("Botón acceder dentro de wp_controlPanel clicado");
        base.waitAndClick(base_stepsCucumber.driver, btnAccederBy, btnAcceder);
    }

    public void clickBtnBuscar(){
        base.waitAndClick(base_stepsCucumber.driver, btnBuscarBy, btnBuscar);
    }

     public void clickPrimerElementoLista(){
         base.waitAndClick(base_stepsCucumber.driver, primerElementoListaBy, primerElementoLista);
    }

    public void rellenarCampoBusquedaEmail(String textoBusqueda){
        base.waitAndFill(base_stepsCucumber.driver, textBoxEmailBy, textBoxEmail, textoBusqueda);
    }

    public void clickPrimerElementoListaBusquedaEmail(){
        base.waitAndClick(base_stepsCucumber.driver, primerElementoListaBusquedaEmailBy, primerElementoListaBusquedaEmail);
    }

    public void clickBtnBuscarEmail(){
        base.waitAndClick(base_stepsCucumber.driver, btnBuscarEmailBy, btnBuscarEmail);
    }
}

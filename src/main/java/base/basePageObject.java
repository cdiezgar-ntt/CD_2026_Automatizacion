package base;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import utils.reports.extentReportHook;

import java.time.Duration;

public class basePageObject {

//    public static ExtentTest test = extentReportHook.getTest();

    public void waitAndFill(WebDriver driver, By byelement, WebElement element, String content){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(byelement));
            element = driver.findElement(byelement);
            element.sendKeys(content);
        }catch(Exception e){
            System.out.println("Mensaje excepción" + e);
            throw e;
        }

    }

    public void waitAndClick(WebDriver driver, By byelement, WebElement element){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(byelement));
            element = driver.findElement(byelement);
            element.click();
        }catch (Exception e){
            System.out.println(e);
            throw e;
        }

    }

    public void wait5seconds() throws InterruptedException {
        Thread.sleep(5000);
    }

}

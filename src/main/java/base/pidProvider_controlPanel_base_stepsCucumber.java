package base;

import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.reports.extentReportHook;

//** Clase con la configuración cucumber de wallet provider y todos sus steps relacionados con el control panel */

public class pidProvider_controlPanel_base_stepsCucumber {


    public static ExtentTest test = extentReportHook.getTest();

    public static WebDriver driver;




}

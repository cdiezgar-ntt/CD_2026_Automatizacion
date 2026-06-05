package com.nttdata.automation.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(


        //features = "src/test/test_wp",
        features = "src/test/resources/features", // Dónde están los feature
        glue = {
                "com.nttdata.automation.steps",       // Dónde está el código Java de los pasos
                "com.nttdata.automation.hooks"        // Dónde están los Hooks (@Before, @After)
        },
        tags = "@TestSolucionErrores",
        //tags = "@wallet_provider and not @wp_descartado",
        plugin = {"pretty", "html:target/cucumber-report.html"},
        monochrome = true
)

public class
Runner {

}

package com.nttdata.automation.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(


        //features = "src/test/test_wp",
        features = "src/test/resources/features", // Dónde están los feature
        glue = {
                "com.nttdata.automation.steps",       // Dónde está el código Java de los pasos
                "com.nttdata.automation.hooks"        // Dónde están los Hooks (@Before, @After)
        },
        tags = "@WALLET-1760" +
                "",
        //tags = "@wallet_provider and not @wp_descartado",
        plugin = {"pretty", "html:target/cucumber-report.html"},
        monochrome = true
)

public class
Runner {

}

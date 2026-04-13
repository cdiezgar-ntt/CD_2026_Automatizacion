package org.example;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(


        //features = "src/test/test_wp",
        features = "src/test/test_launcher",
        glue = {"base", "utils/reports"},
        plugin = "html:src/output/report.html",
        monochrome = true
)

public class
runner {
}

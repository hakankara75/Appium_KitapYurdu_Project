package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {"pretty", "html:target/default-cucumber-report",
                "json:target/json-reports/cucumber.json",
                "io.qameta.allure.cucumber6jvm.AllureCucumber7Jvm",
                "junit:target/xml-report/cucumber.xml"},
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        tags = "@scroll",
        dryRun = false


)
public class Runner {
}

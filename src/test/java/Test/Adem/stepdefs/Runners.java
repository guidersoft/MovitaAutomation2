package Test.Adem.stepdefs;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/java/Test/Adem/features/LoginPageGorunum_Mvt.feature"},
        glue = {"Test/Adem/stepdefs"},
        tags = "",
        plugin = { "pretty",
                "json:test-output/cucumber-reports/cucumber.json",
                "html:test-output/cucumber-reports/cucumberreport.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

)
public class Runners extends AbstractTestNGCucumberTests {

}

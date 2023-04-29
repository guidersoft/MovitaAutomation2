package runners;

import Utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/resources/features/MVT-T86.feature"},
        glue = {"stepdefs"},
        plugin = {"pretty",
        "json:test-output/cucumber-reports/cucumber.json",
        "html:test-output/cucumber-reports/cucumberreport.html",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

)
public class MVT_T86_Runners extends AbstractTestNGCucumberTests {

}

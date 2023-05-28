package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/java/Test/Baris/Features/DetaylıArama.feature"},
        glue = {"Test/Baris/Steps"},
        tags = "",
        plugin = {"pretty",
                "json:test-output/cucumber-reports/cucumber.json",
                "html:test-output/cucumber-reports/cucumberreport.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)

public class Runner_Movita extends AbstractTestNGCucumberTests {


}

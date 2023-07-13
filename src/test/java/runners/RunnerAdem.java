package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/java/Test/Adem/features/"},
        glue = {"Test/Adem/stepdefs"},
        tags = "@AracBazliRapor",
        monochrome = false,// true olursa daha okunabilir konsol çıktısı sağlar
        dryRun = false,// true ise tüm step def ler tanımlı mı diye bakar, default false dur.
        plugin = {"pretty",
                "json:test-output/cucumber-reports/cucumber.json",
                "html:test-output/cucumber-reports/cucumberreport.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class RunnerAdem extends AbstractTestNGCucumberTests {

}

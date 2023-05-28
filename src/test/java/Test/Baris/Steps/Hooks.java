package Test.Baris.Steps;

import Readers.PropertyReader;
import Utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.Properties;

import static Utilities.Driver.*;


public class Hooks {


    @After
    public void after1(Scenario scenario) {
       if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }


    @After(order = 0)
    public void after() {
        quitDriver();
    }
}



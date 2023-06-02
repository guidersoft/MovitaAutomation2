package Test.Engin.stepdefs;

import Utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {


    @After(order = 1)
    public void after1(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshoot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshoot, "image/png", scenario.getName());
        }

    }


    /*@After(order = 0)
    public void after() {
        Driver.quitDriver();
    }*/
}

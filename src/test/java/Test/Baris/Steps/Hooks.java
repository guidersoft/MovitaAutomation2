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

    @AfterStep
    public void after1(Scenario scenario){

        boolean scrShot = PropertyReader.read().get("takescreenshot").equalsIgnoreCase("true");
        String takeScrOn = PropertyReader.read().get("takescreenshot.on");
        if (scrShot) {
            if (takeScrOn.equalsIgnoreCase("fail")){
                if (scenario.isFailed()) {
                    byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                    scenario.attach(screenshot, "image/png", scenario.getName());
                }
            }else{
                byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

            }
        }

    }
//    @After(order = -1)
//    public void after2(Scenario scenario) {
//      {
//            System.out.println("Senaryo " + scenario.getName() + " başarısız oldu.");
//            System.out.println("Kullanılan tarayıcı: " + getDriver().toString());
//            System.out.println("İşletim sistemi: " + System.getProperty("os.name") + " " + System.getProperty("os.version"));
//
//        }
//
//
//    }




    @After(order = 0)
    public void after(){
        quitDriver();
    }
}



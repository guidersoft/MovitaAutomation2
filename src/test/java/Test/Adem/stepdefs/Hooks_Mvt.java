package Test.Adem.stepdefs;

import Readers.property.PropertyReader;
import Utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks_Mvt {// Cucumber notasyonları, varsa TestNG notasyonlarından sonra çalışırlar.

    @After(order = 2)// Her senaryo sonrası çalışır.
    public void quit() {// Her senaryodan sonra çalışır.
        Driver.quitDriver();
    }


    @After()// After her senaryo sonrası çalışır. -> AfterStep dersek her step sonu çalışır.
    public void afterScreenShot(Scenario scenario) {
        boolean screenShot = PropertyReader.read().get("takescreenshot").equalsIgnoreCase("true");// true -> Bu senaryoda SS alınacak.
        boolean screenShotOn = PropertyReader.read().get("takescreenshot.on").equalsIgnoreCase("false");// false -> Ama her stepte SS alınmasın.
        if (screenShot) {// Feature daki  bir Senaryodaki herhangi bir step fail olursa senaryo biter ve devreye girer
            if (screenShotOn) {// step step SS alınacaksa bu bloğa girer -> tabi önce AfterStep diyerek bu metotu step step çalıştırmalıyız.
                if (scenario.isFailed()) {// Senaryo fail ise bu bloğa girer.
                    byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                    // ekran fotosunu file değilde byte olarak(0 ve 1 ler gibi sayısal olark) tutar.
                    scenario.attach(screenshot, "image/png", scenario.getName());
                    // senaryomuza attach(ek) yapıyoruz; screenshot, media tip ve senaryo adını giriyoruz.
                    // Bu ekran fotosunu raporda görebileceğiz.
                }
            } else {// step step çekilmeyecekse bu bloğa girer, senaryo bitimi hata varsa SS alır.
                byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            }

        }
    }

    @After(order = 1)
    public void softAssertAll(Scenario scenario){
        MyStepdefs_Mvt.softAssert.assertAll("Senaryo : " + scenario.getName());
    }

}

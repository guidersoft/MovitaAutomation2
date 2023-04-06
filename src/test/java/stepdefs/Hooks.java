package stepdefs;

import Utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import readers.property.PropertyReader;

public class Hooks {// Cucumber notasyonları, varsa TestNG notasyonlarından sonra çalışırlar.

    @After(order = 0)
    public void quit() {// Her senaryodan sonra çalışır.
        Driver.quitDriver();
    }

    @After()// After her senaryo sonrası çalışır. -> AfterStep dersek her step sonu çalışır.
    public void after1(Scenario scenario) {
        boolean screenShot = PropertyReader.read().get("takescreenshot").equalsIgnoreCase("true");
        boolean screenShotOn = PropertyReader.read().get("takescreenshot.on").equalsIgnoreCase("true");
        if (screenShot) {// Feature daki  bir Senaryodaki herhangi bir step fail olursa senaryo biter ve devreye girer
            if (screenShotOn) {// step step SS alınacaksa bu bloğa girer -> tabi önce AfterStep diyerek bu metotu step step çalıştırmalıyız.
                if (scenario.isFailed()) {// Senaryo fail ise bu bloğa girer.
                    byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                    // ekran fotosunu file değilde byte olarak(0 ve 1 ler gibi sayısal olark) tutar.
                    scenario.attach(screenshot, "image/png", scenario.getName());
                    // senaryomuza attach(ekleme) ediyoruz; screenshot, media tip ve senaryo adını giriyoruz.
                    // Bu ekran fotosunu raporda görebilieceğiz.
                }
            } else {// step step çekilmeyecekse bu bloğa girer, senaryo bitimi hata varsa SS alır.
                byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            }

        }
    }

}
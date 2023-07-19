package Test.Adem.stepdefs;

import Readers.property.PropertyReader;
import Utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static Test.Adem.stepdefs.Base_Mvt.softAssert;

public class Hooks_Mvt {// Cucumber notasyonları, varsa TestNG notasyonlarından sonra çalışırlar.

    @After(order = 2)// Her senaryo sonrası çalışır.
    public void quit(Scenario scenario) {
        if (!scenario.getSourceTagNames().contains("@Raporlar")) {// Bu tagli senaryo haricinde her senaryo bitimi quit eder.
            Driver.quitDriver();
        }
        //@After("not @Raporlar") şeklinde yazarak da Raporlar taglı senaryonun çalışması engellenebilir.
    }


    @After()// After her senaryo sonrası çalışır. -> AfterStep dersek her step sonu,
    // AfterAll dersek tüm senaryoların bitiminde çalışır.
    public void afterScreenShot(Scenario scenario) {
        boolean screenShot = PropertyReader.read().get("takescreenshot").equalsIgnoreCase("true");// true -> Bu senaryoda SS alınacak.
        boolean screenShotOn = PropertyReader.read().get("takescreenshot.on").equalsIgnoreCase("false");// false -> Ama her stepte SS alınmasın.
        if (screenShot) {// Feature daki  bir Senaryodaki herhangi bir step fail olursa senaryo biter ve devreye girer
            if (screenShotOn) {// step step SS alınacaksa bu bloğa girer -> tabi önce AfterStep diyerek bu metotu step step çalıştırmalıyız.
                if (scenario.isFailed()) {// Senaryo fail ise bu bloğa girer.
                    byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                    // ekran fotosunu file değilde byte olarak(0 ve 1 ler gibi sayısal olarak) tutar.
                    scenario.attach(screenshot, "image/png", scenario.getName());
                    // senaryomuza attach(ek) yapıyoruz; screenshot, media tip ve senaryo adını giriyoruz.
                    // Bu ekran fotosunu raporlarda görebileceğiz.
                }
            } else {// step step SS alınmayacaksa bu bloğa girer, senaryo bitimi hata varsa SS alır.
                byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
                // Cucumber ve Extent Report'a SS ve senaryo ismini ekler.
            }

        }
    }

    @After(value = "@LoginPageGorunum or @AracBazliRapor", order = 1)// Sadece bu tagli senaryoda(senaryo sonrası) çalışır.
    public void softAssertAll(Scenario scenario) {
        softAssert.assertAll("Senaryo : " + scenario.getName());
    }

}

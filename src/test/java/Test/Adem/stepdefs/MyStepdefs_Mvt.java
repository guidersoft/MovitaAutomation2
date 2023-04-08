package Test.Adem.stepdefs;

import Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import readers.property.PropertyReader;


// Tekrar içleri doldurulacak.
public class MyStepdefs_Mvt extends Base_Mvt {
    @Given("user is on homepage")
    public void userIsOnHomepage() {
        Driver.getDriver().get(PropertyReader.read().get("url"));
    }

    @When("user should clicks movita logo")
    public void userShouldClicksMovitaLogo() {
        click(lMovitaLogo);
    }

    @Then("user should see the text")
    public void userShouldSeeTheText() {
        visible(lMobilVasitaIzlemeTakipText);
    }

    @Given("Clickable olmali")
    public void clickableOlmali() {
        click(lLanguageButton);
    }

    @When("Kullanıcı {string} butonuna tıklar")
    public void kullanıcıButonunaTıklar(String text) {
        By locator = By.xpath("//a[@class='dropdown-item' and contains(.,'" + text + "')]");
        click(locator);
    }

    @And("English “Mobile Vehicle Tracking System” yazisi gözükmeli")
    public void englishMobileVehicleTrackingSystemYazisiGözükmeli() {
        visible(lMobilVehicleTrackingText);
        pause(2000);
        getScreenShot("English Text");
    }

    @Then("Türkce “Mobil Vasita izleme takip Sistemi” yazisi gözükmeli")
    public void türkceMobilVasitaIzlemeTakipSistemiYazisiGözükmeli() {
        visible(lMobilVasitaIzlemeTakipText);
        pause(2000);
        getScreenShot("Türkçe Text");
    }
}


package Test.Adem.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs_Mvt extends Base_Mvt {

    @Given("user is on homepage")
    public void userIsOnHomepage() {
        open();
    }

    @When("user should clicks movita logo")
    public void userShouldClicksMovitaLogo() {
        click(llogo);
    }

    @Then("user should see the text")
    public void userShouldSeeTheText() {
        visible(lMobilVasitaIzlemeTakipText);
        getScreenShot("Movita Arac Takip_");
    }

    @Given("Clickable olmali")
    public void clickableOlmali() {
        click(lLanguageButton);
    }

    @When("Iki secenegi click yapabilmeli:")
    public void ıkiSecenegiClickYapabilmeli() {
        click(lEnglishButton);
        click(lLanguageButton);
        click(lTurkishButton);

    }

    @And("English “Mobile Vehicle Tracking System” yazisi gözükmeli")
    public void englishMobileVehicleTrackingSystemYazisiGözükmeli() {
        click(lLanguageButton);
        click(lEnglishButton);
        visible(lMobilVehicleTrackingText);
        pause(2000);
        getScreenShot("Mobile Vehicle Tracking Text");

    }

    @Then("Türkce “Mobil Vasita izleme takip Sistemi” yazisi gözükmeli")
    public void türkceMobilVasitaIzlemeTakipSistemiYazisiGözükmeli() {
        click(lLanguageButton);
        click(lTurkishButton);
        visible(lMobilVasitaIzlemeText);
        pause(2000);
        getScreenShot("Mobil Vasıta İzleme Text 02_");
    }

}

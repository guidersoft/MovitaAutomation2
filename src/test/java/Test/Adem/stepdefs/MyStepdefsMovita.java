package Test.Adem.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefsMovita extends BaseMovita {

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

}

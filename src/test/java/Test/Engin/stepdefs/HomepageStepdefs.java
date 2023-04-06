package Test.Engin.stepdefs;

import Base.BaseMovita;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomepageStepdefs extends BaseMovita{


    @Given("user is homepage")
    public void userIsHomepage() {
        open();
    }

    @When("user clicks movitalogo")
    public void userClicksMovitalogo() {
        click(lMovitaLogo);
    }

    @Then("user should see the Text")
    public void userShouldSeeTheText() {
        visible(lMovitaLogoText);
        getScreenshot("movita text");
    }
}

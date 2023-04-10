package Test.Reyhan.StepDefs;

import Base.BaseMovita;
import Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class HomePageStepDefs extends BaseMovita{


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

    @When("user click flag logo")
    public void userClickFlagLogo() {
        click(lFlagButton);
    }

    @Then("user should see englich Text")
    public void userShouldSeeEnglichText() {
        visible(lMobilVehicleTrackingText);
        getScreenshot("Englich text");
    }
    @Then("user should see turkce Text")
    public void userShouldSeeTurkceText() {
        visible(lMobilVasitaIzlemeText);
        getScreenshot("Türkce text");
    }

    @And("user cliks {string} buttun")
    public void userCliksButtun(String text) {
        By locator=By.xpath("//a[@class='dropdown-item' and contains(.,'" + text + "')]");
        click(locator);
    }

    @When("User hover {string}")
    public void userHover(String text) {
        menuLocator(text);
        new Actions(Driver.getDriver())
                .moveToElement(menuLocator(text)).perform();

    }

    @And("user click {string}")
    public void userClick(String text) {
        click(menuLocator(text));
    }


    @Then("user should see the text Movita")
    public void userShouldSeeTheTextMovita() {
        waitForVisibility(driver.findElement(lMobilVasitaIzlemeText));
    }
}
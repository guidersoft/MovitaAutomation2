package Test.Reyhan.StepDefs;

import Base.BaseMovita;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ReyhanStepDefs extends BaseMovita {

    @Given("users navigate to {string}")
    public void usersNavigateTo(String url) {
        driver.get(url);
    }


    @When("user hover over {string}")
    public void userHoverOver(String MainLink) {
      hoverOverByAction(By.xpath(String.format(TOP_MENU,MainLink)));
    }

    @And("user assert change color {string}")
    public void userAssertChangeColor(String mainLink) {
        assertChangeColor(By.xpath(String.format(TOP_MENU, mainLink)),"#00adee");
    }


    @And("user click {string}")
    public void userClick(String mainLink) {
        click(By.xpath(String.format(TOP_MENU, mainLink)));
    }


    @Then("{string} should be visible")
    public void shouldBeVisible(String url) {
        Assert.assertTrue(driver.getPageSource().contains(url));
    }

    @Then("{string} should be visible in related page")
    public void shouldBeVisibleInRelatedPage(String text) {
        Assert.assertTrue(driver.getPageSource().contains(text));
    }


    @And("user assert change color of {string}")
    public void userAssertChangeColorOf(String mainLink) {
        assertChangeColor(By.xpath(String.format(TOP_MENU,mainLink)),"#00adee");
    }


    @When("user clicked the language option dropdown menu")
    public void userClickedTheLanguageOptionDropdownMenu() {click(lLanguageOptionButton);
    }

    @And("user select {string} option")
    public void userSelectOption(String language) {click(By.xpath(String.format(TOP_MENU, language)));
    }

    @Then("user sees {string} on Page")
    public void userSeesOnPage(String text) {
        visible(lTextOfMobilVasıtaİzlemeTakipSistemi);
        Assert.assertTrue(driver.findElement(lTextOfMobilVasıtaİzlemeTakipSistemi).getText().contains(text));
    }

    @When("users clicked the movita logo")
    public void usersClickedTheMovitaLogo() {
        usersClickedTheMovitaLogo();
    }

    @Then("Mobile Vehicle Tracking System shoould be visible")
    public void mobileVehicleTrackingSystemShoouldBeVisible() {
        mobileVehicleTrackingSystemShoouldBeVisible();
    }
}

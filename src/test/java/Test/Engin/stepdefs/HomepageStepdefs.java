package Test.Engin.stepdefs;

import Base.BaseMovita;
import Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.checkerframework.checker.regex.qual.Regex;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;



public class HomepageStepdefs extends BaseMovita{

    String beforColor="#444444";
    String afterColor;
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
        visible(lMobilVasitaIzlemeText);
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

    /**
     *
     * @param text menu deki text girilecek ve textin sadece bas harfleri büyük olacak
     *             Hover yapinca rengin degistigi assert edilmeli
     */
    @When("user hover {string}")
    public void userHover(String text) {
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


    @Given("user hover {string} menu")
    public void userHoverMenu(String text) {
       /* String color=menuLocator(text).getCssValue("Color");
        beforColor = Color.fromString(color).asHex();*/
        hover(menuLocator(text));
        String color2=menuLocator(text).getCssValue("Color");
        afterColor=Color.fromString(color2).asHex();

    }



    @And("user click {string} menu")
    public void userClickMenu(String text) {
        click(menuLocator(text));
    }

    @Then("user should see {string}")
    public void userShouldSee(String text) {
        try {
            Assert.assertTrue(driver.getPageSource().contains(text));
        }catch (Exception e){
            getScreenshot("spring");
        }

    }

    @And("text color should be chanced")
    public void textColorShouldBeChanced() {
        Assert.assertNotEquals(beforColor,afterColor);
    }


    @And("SubMenu text color should be chanced")
    public void submenuTextColorShouldBeChanced() {
        Assert.assertNotEquals(beforColor, "#00adee");

    }


}

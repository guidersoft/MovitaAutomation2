package Test.Baris.Steps;

import Test.Baris.Locators.HomePageLocator;
import ReuseableClass.BaseClass;
import Utilities.Driver;
import com.beust.ah.A;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.text.MessageFormat;
import java.util.List;

import static ReuseableClass._Conditions.*;
import static Utilities.Utils.getElementScreenshotsAs;
import static Utilities.Utils.threadSleep;


public class HomePagefunc extends BaseClass implements HomePageLocator {

    String color;
    String newcolor;

    @Given("user on homepage")
    public void userOnHomepage() {
      open(url).
              $(By.xpath(MessageFormat.format(ALL_A,"Ana Sayfa"))).
              waitFor(visibilty,null);
    }

    @When("user clicks on the movita logo")
    public void userClicksOnTheMovitaLogo() {
        $(llogo).click();
    }

    @Then("{string} text must be visible")
    public void textMustBeVisible(String text) {
        $(By.xpath(MessageFormat.format(lverify,text))).waitFor(visibilty,null);

    }

    @When("user clicks dropdown button")
    public void userClicksDropdownButton() {
        $(llanguageDropdown).click();
        getElementScreenshotsAs($(llanguageDropdown).getCurrentElement());

    }

    @And("user clicks english section")
    public void userClicksEnglishSection() {
       $(xpath(ALL_A, "English")).waitFor(visibilty,null).click();

    }

    @When("user clicks türkçe section")
    public void userClicksTürkçeSection() {
        $(xpath(ALL_A, "Türkçe")).waitFor(visibilty,null).click();
    }


    @When("user hower over to {string} link")
    public void userHowerOverToLink(String link) {
        WebElement ana_sayfa = $(xpath(ALL_A, link)).getCurrentElement();
        color = getElementCssProperty(ana_sayfa, "color");
        $(xpath(ALL_A,"Ana Sayfa")).hower();
    }

    @Then("Homepage text should change colour")
    public void homepageTextShouldChangeColour() {
        WebElement ana_sayfa = $(xpath(ALL_A, "Ana Sayfa")).getCurrentElement();
        newcolor = ana_sayfa.getCssValue("color");

        Assert.assertFalse( color.equals(newcolor));
    }


    @When("user clicks {string} link")
    public void userClicksLink(String link) {
        $(xpath(ALL_A,link)).click();
    }

    @When("user hower over the {string} link")
    public void userHowerOverTheLink(String link) {
        $(xpath(ALL_A,link)).hower();
    }

    @Then("links in the following data should be visible and text should change colour")
    public void linksInTheFollowingDataShouldBeVisibleAndTextShouldChangeColour(DataTable table) {

        List<String> drobdownTexs = table.asList();

        for (int i = drobdownTexs.size()-1; i >=0; i--) {

            WebElement currentElement = $(xpath(ALL_A, drobdownTexs.get(i))).getCurrentElement();
            color = getElementCssProperty(currentElement, "color");
            $(currentElement).hower();
            threadSleep(500);
            newcolor = getElementCssProperty(currentElement, "color");
            Assert.assertNotEquals(newcolor, color);
        }

    }


    @When("the {string} link is hovered and the links in the drop-down list are clicked, the following data must be verified")
    public void theLinkIsHoveredAndTheLinksInTheDropDownListAreClickedTheFollowingDataMustBeVerified(String links,DataTable table) {
        List<String> list = table.asList();
        $(xpath(ALL_A, links)).hower();
        List<WebElement> drobdownElements = $(xpath(ALL_A, links)).getCurrentElement().findElements(By.xpath(drobdownList));
        System.out.println("elememtlist="+drobdownElements.toString());

        for (int i = 0; i < list.size(); i++) {
            $(xpath(ALL_A,links)).hower();
            drobdownElements = $(xpath(ALL_A, links)).getCurrentElement().findElements(By.xpath(drobdownList));
            $(drobdownElements.get(i)).click().
            $(xpath(ALLVerifyText,list.get(i))).waitFor(visibilty,null);
        }
    }

}

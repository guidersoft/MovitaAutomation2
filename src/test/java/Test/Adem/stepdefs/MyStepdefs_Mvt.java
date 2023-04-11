package Test.Adem.stepdefs;

import Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import static Utilities.Driver.*;

import java.util.List;


public class MyStepdefs_Mvt extends Base_Mvt {
    @Given("user is on homepage")
    public void userIsOnHomepage() {
        //Driver.getDriver().get(PropertyReader.read().get("url"));
        getDriver().get("http://movita.com.tr/");
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

    @Then("{string} yazisi gözükmeli")
    public void yazisiGözükmeli(String text) {
        By locator = By.xpath("//div[@class='tp-mask-wrap']//div[contains(text(),'" + text + "')]");
        visible(locator);
        pause(2000);
        getScreenShot(text);
    }

    @When("user hover {string}")
    public void userHover(String text) {
        new Actions(Driver.getDriver()).moveToElement(topMenuElement(text)).perform();
    }

    @And("user click {string}")
    public void userClick(String text) {
        click(topMenuElement(text));
    }

    @And("user should see {string} text")
    public void userShouldSeeText(String text) {
        visible(lMobilVasitaIzlemeTakipText);
    }


    @Then("{string} menusu altında {int} seçenek çıkmalı")
    public void menusuAltındaSeçenekÇıkmalı(String text, int num) {
        List<WebElement> webElements = topSubMenuElements(text);
        Assert.assertEquals(num, webElements.size());
    }


    @Given("kullanici {string} deki {string} ye click yapar")
    public void kullaniciDekiYeClickYapar(String menu, String submenu) {
        clickTopSubMenuElements(menu, submenu);
    }


    @Then("kullanici {string} görmeli")
    public void kullaniciGörmeli(String text) {
        By xpath = By.xpath("//h1[contains(text(),'" + text + "')]");
        visible(xpath);
    }


    @And("{string} deki renk değişmeli")
    public void dekiRenkDeğişmeli(String menuText) {
        assertChangeColor(topMenuXpath(menuText), "#00adee");
    }


    @And("sayfa adresi {string} olmalı")
    public void sayfaAdresiOlmalı(String expUrl) {
        Assert.assertEquals(getDriver().getCurrentUrl(), expUrl);
    }


    @And("kullanici {string} altındaki Submenu lere hover over yapar")
    public void kullaniciAltındakiSubmenuLereHoverOverYapar(String menuText) {
        for (WebElement element : topSubMenuElements(menuText)) {
            new Actions(Driver.getDriver()).moveToElement(element).perform();
        }
    }

}


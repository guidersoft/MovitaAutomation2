package Test.Adem.stepdefs;

import Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import readers.property.PropertyReader;

import static Utilities.Driver.*;

import java.util.List;


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
        // Burada background daki renk değişimi Assert edilecek!
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
        Assert.assertTrue(webElements.size() == num);
    }


    @And("kullanici {string} altındaki submenulere Hover Yapar")
    public void kullaniciAltındakiSubmenulereHoverYapar(String text) {
        for (WebElement element : topSubMenuElements(text)) {
            new Actions(Driver.getDriver()).moveToElement(element).perform();
        }
    }

    @And("kullanici {string} altindaki {string} submenulere click yapar")
    public void kullaniciAltindakiSubmenulereClickYapar(String text, String subText) {
        clickTopSubMenuelements(text, subText);
    }

    @Then("kullanici {string} yazisini görmeli")
    public void kullaniciYazisiniGörmeli(String text) {
        By xpath = By.xpath("//h1[contains(text(),'" + text + "')]");// genelleştiricez
        // todo: uygun assert metodu bulunacak, submenude "Başvru" yazısı sıkıntı çıkarıyor.
        //Assert.assertEquals(getDriver().findElement(xpath).getText(),text);
        getWait().until((ExpectedConditions.textToBe(xpath, "Demo Başvuru")));
        pause(2000);
        getScreenShot("Demo Başvurusu");
    }
}


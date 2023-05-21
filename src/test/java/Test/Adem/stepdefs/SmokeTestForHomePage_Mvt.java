package Test.Adem.stepdefs;

import Test.Adem.locators.Locators_LoginPage;
import Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SmokeTestForHomePage_Mvt extends Base_Mvt implements Locators_LoginPage {

    @Given("user on movita homepage")
    public void userOnMovitaHomepage() {
        Driver.getDriver().get("https://movita.com.tr");
    }


    @When("user click on the {string} in main menu")
    public void userClickOnTheStringInMainMenu(String text) {
        click(topMenuElement(text));
    }

    @Then("kullanici {string} veya {string} görmeli")
    public void kullaniciVeyaGörmeli(String expText, String expURL) {
        By lh1 = By.xpath("//h1[contains(text(),'" + expText + "')]");
        if (!expText.equals("")) visible(lh1);
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), expURL);
    }


    @Then("kullanici ana sayfanin ortasinda mobil vasita takip yazilarini gormeli")
    public void kullaniciAnaSayfaninOrtasindaMobilVasitaTakipYazilariniGormeli() {
        visible(lMobilVasitaIzlemeTakipText);
        visible(lMovitaMNVRileTumAraclarText);
    }



}


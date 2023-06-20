package Test.Adem.stepdefs;

import Test.Adem.locators.Locators_Raporlar;
import Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Test.Adem.locators.Locators_LoginPage.*;

public class Raporlar_Stepdefs_Mvt extends Base_Mvt implements Locators_Raporlar {

    @Given("Kullanıcı siteye login olabilmeli")
    public void kullanıcıSiteyeLoginOlabilmeli() {
        driver.get("https://www.movita.com.tr/login");
        sendKeys(lKullaniciAdiInput, "demomovita");
        sendKeys(lSifreInput, "1192movita");
        click(lGirisYapButonu);
    }

    @When("Raporlar menüsüne tıklamalı")
    public void raporlarMenüsüneTıklamalı() {
        click(lRaporlarAnaMenu);
    }

    @Then("{string} leri görmelidir")
    public void altComponentLeriGörmelidir(String text) {
        By lRaporlarAltKomponentler = By.xpath("//a[contains(text(),'" + text + "')]");
        WebElement element = driver.findElement(lRaporlarAltKomponentler);
        hover(element);

    }

    @And("Kullanıcı {string} lere tıklar")
    public void kullanıcıAltComponentLereTıklar(String text) {
        By lRaporlarAltKomponentler = By.xpath("//a[contains(text(),'" + text + "')]");
        WebElement element = driver.findElement(lRaporlarAltKomponentler);
        System.out.println("element.getCssValue(\"background-color\") = " + element.getCssValue("background-color"));
        click$(element);

    }

    @Then("Tıklanan {string} in zemini beyaz iken text maviye dönüşmelidir")
    public void tıklananComponentinZeminiBeyazIkenTextMaviyeDönüşmelidir(String text) {
        By lRaporlarAltKomponentler = By.xpath("//a[contains(text(),'" + text + "')]");
        WebElement element = driver.findElement(lRaporlarAltKomponentler);
        assertChangeBackGroundColor$(element, "#000000");
        wait.until(ExpectedConditions.attributeToBe(element,"color","rgba(0, 173, 238, 1)"));

    }


    @Given("Çıkış")
    public void çıkış() {
        // Runner da @RaporlarÇıkış tagı eklenirse test bitimi quit eder.
    }
}

package Test.Engin.stepdefs;

import Base.BaseMovita;
import Test.Engin.Base.EnginBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


import java.util.List;
import java.util.Map;
import java.util.Objects;
import static Test.Engin.Locator.Locators.*;

public class LoginPageStepDefs extends BaseMovita {

    EnginBase eb = new EnginBase();


    @When("user clicks giris yap menu")
    public void userClicksGirisYapMenu() {
        click(lGirisYapButton);

    }

    @And("user type the text as a fallowing table")
    public void userTypeTheTextAsAFallowingTable(DataTable table) {
        List<Map<String, String>> maps = table.asMaps();
        for (Map<String, String> map : maps) {
            String userName = map.get("username") == null ? "" : map.get("username");
            String pass = map.get("password") == null ? "" : map.get("password");
            sendeys(lUserName, userName);
            sendeys(lPassword, pass);
            click(lLoginSubmitButton);

            if (Objects.equals(map.get("Status"), "true")) {
                waitForVisibility(lLoginSuccess);
                click(lDemoFiloButton);
                click(lLogOut);

            } else {
                if (userName.isEmpty()) {
                    waitForVisibility(lHataMessageKullanici);
                }

                if (pass.isEmpty()) {
                    waitForVisibility(lHataMessageSifre);
                }

                if (!userName.equalsIgnoreCase("demomovita") || !pass.equalsIgnoreCase("1192movita")) {
                    waitForVisibility(lHataMessageoneorTwoFalse);
                }


            }
        }

    }

    @And("user should see two input feld")
    public void userShouldSeeTwoInputFeld() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lUserName));
        wait.until(ExpectedConditions.visibilityOfElementLocated(lPassword));
    }

    @And("user should see Logo und the text{string}")
    public void userShouldSeeLogoUndTheText(String text) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(lLoginPageMovitaLogo));
        if (driver.getPageSource().contains(text)){

        }else {
            sleep(500);
            getScreenshot("LoginPageFeatures");
        }


    }

    @And("user should see Giris Yap button")
    public void userShouldSeeGirisYapButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lLoginPageGirisYapButton));
    }

    @And("user should see above the Giris Yap button the text{string}")
    public void userShouldSeeAboveTheGirisYapButtonTheText(String text) {
        Assert.assertTrue(driver.getPageSource().contains(text));
    }

    @And("the Buttons color should be chance and be clickable")
    public void theButtonsColorShouldBeChanceAndBeClickable() {

            String first = driver.findElement(lLoginPageSifrenizimiUnuttunuz).getCssValue("color");
            String firstColor = Color.fromString(first).asHex();
            hover(lLoginPageSifrenizimiUnuttunuz);
            String after = driver.findElement(lLoginPageSifrenizimiUnuttunuz).getCssValue("color");
            String afterColor = Color.fromString(after).asHex();

            if (!firstColor.equalsIgnoreCase(afterColor)) {
            }else
             getScreenshotElement(lLoginPageSifrenizimiUnuttunuz,"LoginPageColorassert");

    }

    @And("user clicks the button")
    public void userClicksTheButton() {
        click(lLoginPageAnaSayfayaDon);
        wait.until(ExpectedConditions.urlToBe("https://movita.com.tr/"));

    }

    @And("user Login whit a valid username and password")
    public void userLoginWhitAValidUsernameAndPassword() {
        sendeys(lUserName, "demomovita");
        sendeys(lPassword, "1192movita");
        click(lLoginSubmitButton);
        waitForVisibility(lLoginSuccess);
    }


    @And("user click Detayli Arama button")
    public void userClickDetayliAramaButton() {
        click(lDetayliAramaButton);

    }

    @Then("user shoul see {string}")
    public void userShoulSee(String text) {
        wait.until(ExpectedConditions.textToBe(eb.detayliAramaSubMenu(text),text));
    }

    @And("user click Alarm Ekle button")
    public void userClickAlarmEkleButton() {
        click(lAlarmEkleButton);
        String text = driver.findElement(lAlarmEkleNotifikation).getText();
        Assert.assertEquals(text,"Dikkat!");

    }

    @Then("user should see as {string}")
    public void userShouldSeeAs(String text) {
        String text1 = driver.findElement(eb.alarmEkleSubMenuDefault(text)).getText();
        Assert.assertTrue(text1.contains(text));
    }

    @Then("user should see on the page {string}")
    public void userShouldSeeOnThePage(String text) {
        String text1 = driver.findElement(lAlarmBilgisiText).getText();
        Assert.assertEquals(text1,text);
    }

    @Then("user should see fallowing")
    public void userShouldSeeFallowing(DataTable table) {
        Map<String,String> map =table.asMap();

        map.forEach((k,v)->{
            List<WebElement> elements = driver.findElements(lSelectMenus);
            for (WebElement element : elements) {
                String text1 = element.getText();
                if (text1.equalsIgnoreCase(map.get(v)))
                    Assert.assertEquals(text1,map.get(v));
                }
        });

    }

    @And("Alarm should be saved")
    public void alarmShouldBeSaved() {
        List<WebElement> elements = driver.findElements(lSelectMenus);
        sendeys(driver.findElement(By.id("aciklama")),"Engin");
        for (WebElement element : elements) {
           click(element);
        }
        WebElement Element = driver.findElement(By.xpath("//button[contains(.,'Kaydet')]"));
        eb.getScrollToElement(Element);
        click(By.xpath("//button[contains(.,'Kaydet')]"));
        wait.until(ExpectedConditions.urlToBe("https://movita.com.tr/alarm-listesi"));
        Assert.assertTrue(driver.getPageSource().contains("Engin"));
        getScreenshot("Alarm");

    }
}

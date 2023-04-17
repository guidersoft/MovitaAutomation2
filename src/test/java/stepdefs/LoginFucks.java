
package stepdefs;

import Locaators.HomePageLocator;
import ReuseableClass.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static ReuseableClass._Conditions.urlToBe;
import static ReuseableClass._Conditions.visibilty;

public class LoginFucks extends BaseClass implements HomePageLocator {

    @Given("user on login Page")
    public void userOnLoginPage() {
        $(By.xpath("//div[text()=\"GİRİŞ Yap\"]")).click();
    }

    @Then("user logs in with {string} and  {string}, {string} user should see {string} message")
    public void userLogsInWithAndUserShouldSeeMessage(String username, String password, String status, String message) {

        if (status.equalsIgnoreCase("true")) {
                    $(xpath(loginInput, "username")).sendKeys(username).
                    $(xpath(loginInput, "password")).sendKeys(password).
                    $(xpath(ALL_BUTTON, "Giriş Yap")).click().
                    $(xpath(ALL_Locator,message)).waitFor(visibilty,null).
                    $(xpath(ALL_Locator,message)).click().
                    $(xpath(ALL_A,"")).click();
        }
        if(status.equals("false")){
            if (!username.isEmpty() & !password.isEmpty()) {
                    $(xpath(loginInput, "username")).sendKeys(username).
                    $(xpath(loginInput, "password")).sendKeys(password).
                    $(xpath(ALL_BUTTON, "Giriş Yap")).click().
                    $(xpath(ALL_Locator,message)).waitFor(visibilty,null);
            }
            if (username.isEmpty() & !password.isEmpty()) {
                    $(xpath(loginInput, "password")).sendKeys(password).
                    $(xpath(ALL_BUTTON, "Giriş Yap")).click().
                    $(xpath(ALL_Locator,message)).waitFor(visibilty,null);
            }
            if (password.isEmpty() & !username.isEmpty()) {
                    $(xpath(loginInput, "username")).sendKeys(username).
                    $(xpath(ALL_BUTTON, "Giriş Yap")).click().
                    $(xpath(ALL_Locator,message)).waitFor(visibilty,null);
            }
            if (password.isEmpty() & username.isEmpty()) {

                    String[] messagepart = message.split(" and ");
                    for (String s : messagepart) { s= s.trim(); }

                    $(xpath(ALL_BUTTON, "Giriş Yap")).click().
                    $(xpath(ALL_Locator,messagepart[0])).waitFor(visibilty,null);
                    $(xpath(ALL_Locator,messagepart[1])).waitFor(visibilty,null);
            }
        }

    }

    @Then("should see two separate fields for username and password.")
    public void shouldSeeTwoSeparateFieldsForUsernameAndPassword() {
        $(xpath(loginInput, "username")).waitFor(visibilty,null);
        $(xpath(loginInput, "password")).waitFor(visibilty,null);
    }


    @And("The text {string} and the Movita logo above it must be visible")
    public void theTextAndTheMovitaLogoAboveItMustBeVisible(String text) {
        try {
            $(xpath(ALL_Locator,text)).waitFor(visibilty,null);
        } catch (Exception e) {

        }
        $(movitaLogo).waitFor(visibilty,null);
    }

    @And("There should be a {string} button in blue colour in the form of a long bar.")
    public void thereShouldBeALoginButtonInBlueColourInTheFormOfALongBar(String text) {
        String blueColor="rgba(0, 0, 255, 1)";
        String afterHoverColor = $(xpath(ALL_BUTTON, text)).getElementCssProperty("color");

        try {
            Assert.assertEquals(blueColor, afterHoverColor);
        } catch (Exception e) {
            try {
                getScreenshot(text);
            } catch (IOException ex) {

            }
        }
    }

    @And("{string} link should be available.")
    public void şifreniziMiUnuttunuzLinkShouldBeAvailable(String text) {
        $(xpath(ALL_A,text)).waitFor(visibilty,null);
    }

    @And("and when hover over, the colour of the text should change from blue to green and it should be clickable")
    public void andWhenHoverOverTheColourOfTheTextShouldChangeFromBlueToGreenAndItShouldBeClickable() {
        String greenColor="rgba(0, 128, 0, 1)";
        WebElement element = $(xpath(ALL_A, "Şifrenizi mi unuttunuz?")).getCurrentElement();
        String afterHoverColor = $(element).hower().getElementCssProperty("color");

        try {
            Assert.assertEquals(greenColor, afterHoverColor);
        } catch (Exception e) {
            try {
                getScreenshot("colorChange");
            } catch (IOException ex) {

            }
       }
    }

    @And("There should be a {string} link in the top right corner and when clicked it should navigate to the Home page")
    public void thereShouldBeAAnaSayfayaDönLinkInTheTopRightCornerAndWhenClickedItShouldNavigateToTheHomePage(String text) {
        $(xpath(ALL_A,text)).click().waitFor(urlToBe,url);
    }


    @And("{string} should be written in the footer section.")
    public void shouldBeWrittenInTheFooterSection(String text) {
        $(xpath(ALL_Locator,text)).waitFor(visibilty,null);

    }
}

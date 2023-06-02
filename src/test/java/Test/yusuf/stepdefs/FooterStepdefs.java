package Test.yusuf.stepdefs;

import Test.yusuf.BaseMovitaYusuf;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import static Test.yusuf.Locators.*;

public class FooterStepdefs extends BaseMovitaYusuf {

    @Given("users navigate to homepage")
    public void usersNavigateToHomepage() {
        driver.get("https://movita.com.tr/");
    }

    @When("user scrolled down footer section")
    public void userScrolledDownFooterSection() {
        new Actions(driver)
                .scrollToElement(driver.findElement(xpath(FOOTER_MENU, "Politikamız")))
                .perform();
    }

    @Then("user sees {string} in footer section")
    public void userSeesInFooterSection(String text) {
        visible(xpath(FOOTER_MENU, text));
    }

    @And("user click the {string} below Politikamiz")
    public void userClickTheBelowPolitikamiz(String link) {
        click(xpath(FOOTER_MENU, link));
    }

    @Then("user should see {string} on page")
    public void userShouldSeeOnPage(String text) {
        visible(xpath(TITLE, text));
    }


    @Then("user verify contakt infoormation\\(address, phone, e-mail)")
    public void userVerifyContaktInfoormationAddressPhoneEMail() {
        String contaktInfo = "Adres:\n" +
                "Macun Mahallesi Batı Bulvarı 177. Cadde\n" +
                "Batı İş Merkezi No:28/66 Yenimahalle/ANKARA\n" +
                "Telefon: + 90 (850) 557 7627\n" +
                "Email: bilgi@movita.com.tr";
        String text = driver.findElement(lFooterMenuContaktInfo).getText();
        Assert.assertEquals(contaktInfo, text);
    }
}

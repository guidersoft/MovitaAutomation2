package Test.yusuf.stepdefs;

import Test.yusuf.BaseMovitaYusuf;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static Test.yusuf.Locators.*;

import java.util.List;
import java.util.Map;

public class RaporlarStepdefs extends BaseMovitaYusuf {

    @When("user logs in form with the following data")
    public void userLogsInFormWithTheFollowingData(DataTable table) {
        driver.get("https://movita.com.tr//");
        click(By.xpath(String.format(TOP_MENU, "GİRİŞ Yap")));
        visible(lLoginFormUsername);
        Map<String, String> map = table.asMap();
        String username = map.get("username");
        String password = map.get("password");
        if (username == null) username = "";
        if (password == null) password = "";
        sendKeys(lLoginFormUsername, username);
        sendKeys(lLoginFormPassword, password);
        click(lLoginFormSubmitButton);
        visible(xpath(MAIN_MENU, "Anasayfa"));
    }


    @Given("user click on the {string} in main menu")
    public void userClickOnTheInMainMenu(String text) {
        click(xpath(MAIN_MENU, text));
    }


    @Then("user should see {int} submenu under the {string}")
    public void userShouldSeeSubmenuUnderThe(int sizeElement, String text) {
        hoverOverByAction(xpath(MAIN_MENU, "Araç Bazlı Rapor"));
        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(xpath(SUB_MENUS, text)));
        Assert.assertEquals(elements.size(), sizeElement);
    }

    @When("user click on the sub menu and assert changed color")
    public void userClickOnTheSubMenuAndAssertChangedColor(DataTable table) {
        List<String> menus = table.asList();
        for (int i = 0; i < menus.size(); i++) {
            hoverOverByAction(xpath(MAIN_MENU, menus.get(i)));
            click(xpath(MAIN_MENU, menus.get(i)));
            assertChangeColor(xpath(MAIN_MENU, menus.get(i)), "#00adee");

        }
    }
}

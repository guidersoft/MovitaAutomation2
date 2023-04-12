
package stepdefs;

import Locaators.HomePageLocator;
import ReuseableClass.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

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
}

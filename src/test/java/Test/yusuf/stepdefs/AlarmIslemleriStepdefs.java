package Test.yusuf.stepdefs;

import Test.yusuf.BaseMovitaYusuf;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

import static Test.yusuf.Locators.*;

public class AlarmIslemleriStepdefs extends BaseMovitaYusuf {

    int alarmSayisi;

    @And("User click {string} button in the top right corner of the page")
    public void userClickButtonInTheTopRightCornerOfThePage(String text) {
        alarmSayisi = driver.findElements(By.xpath(lAlarmIslemleriAlarmListesi)).size();
        click(xpath(ALARM_ISLEMLERI, text));
    }

    @Then("User should see following fields {string}, {string} and {string}")
    public void userShouldSeeFollowingFileldsAnd(String text1, String text2, String text3) {
        wait.until(ExpectedConditions.presenceOfElementLocated(xpath(ALARM_ISLEMLERI,text1)));
        wait.until(ExpectedConditions.presenceOfElementLocated(xpath(ALARM_ISLEMLERI,text2)));
        wait.until(ExpectedConditions.presenceOfElementLocated(xpath(ALARM_ISLEMLERI,text3)));
    }

    @When("User click on the {string} link in the top of the page")
    public void userClickOnTheLinkInTheTopOfThePage(String text) {
        click(xpath(ALARM_ISLEMLERI,text));
    }

    @Then("User should see {string} red text warning")
    public void userShouldSeeRedTextWarning(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath(ALARM_ISLEMLERI,text)));
    }

    @Then("User should see following fields")
    public void userShouldSeeFollowingFields(DataTable table) {
        List<String> list = table.asList();
        for (String s : list) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(xpath(ALARM_ISLEMLERI,s)));
        }
    }

    @And("User click on the {string} box")
    public void userClickOnTheBox(String text) {
        click(By.xpath(lAlarmIslemleriAlarmTipi));
    }

    @Then("User should see following fields in the Alarm Ekle dropdown menu.")
    public void userShouldSeeFollowingFieldsInTheAlarmEkleDropdownMenu(DataTable table) {
        List<String> tips = table.asList();
        Select select = new Select(driver.findElement(By.xpath(lAlarmIslemleriAlarmTipi)));
        List<WebElement> options = select.getAllSelectedOptions();
        for (int i = 0; i < options.size(); i++) {
            Assert.assertEquals(options.get(i).getText(), tips.get(i));
        }
    }

    @Then("User should see following fields in the SMS Bildirimi dropdown menu.")
    public void userShouldSeeFollowingFieldsInTheSMSBildirimiDropdownMenu(DataTable table) {
        List<String> tips = table.asList();
        Select select = new Select(driver.findElement(By.xpath(lAlarmIslemleriSmsBildirimi)));
        List<WebElement> options = select.getAllSelectedOptions();
        for (int i = 0; i < options.size(); i++) {
            Assert.assertEquals(options.get(i).getText(), tips.get(i));
        }
    }

    @Then("User should be able to select all days of the week.")
    public void userShouldBeAbleToSelectAllDaysOfTheWeek() {
        Select select = new Select(driver.findElement(By.xpath(lAlarmIslemleriAktifGunler)));
        select.selectByVisibleText("Pazartesi");
        select.selectByVisibleText("Salı");
        select.selectByVisibleText("Çarşamba");
        select.selectByVisibleText("Perşembe");
        select.selectByVisibleText("Cuma");
        select.selectByVisibleText("Cumartesi");
        select.selectByVisibleText("Pazar");
    }

    @And("User click on the  {string} button")
    public void userClickOnTheButton(String arg0) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(lAlarmIslemleriKaydetButton)));
        click(By.xpath(lAlarmIslemleriKaydetButton));
    }

    @When("User click on the {string} button in the top of the page")
    public void userClickOnTheButtonInTheTopOfThePage(String text) {
        click(xpath(ALARM_ISLEMLERI, text));
    }

    @Then("user should see that the created alarm has been registered")
    public void userShouldSeeThatTheCreatedAlarmHasBeenRegistered() {
        int yeniAlarmSayisi = driver.findElements(By.xpath(lAlarmIslemleriAlarmListesi)).size();
        Assert.assertEquals(alarmSayisi, yeniAlarmSayisi-1);
    }

    @Then("User should see all alarms and on the page right two button for {string} and {string}")
    public void userShouldSeeAllAlarmsAndOnThePageRightTwoButtonForAnd(String text1, String text2) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(lAlarmIslemleriAlarmSil)));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(lAlarmIslemleriAlarmEdit)));
    }

    @And("User clicks on the pencil icon")
    public void userClicksOnThePencilIcon() {
        click(By.xpath(lAlarmIslemleriAlarmEdit));
    }

    @And("User clicks on the garbage icon")
    public void userClicksOnTheGarbageIcon() {
        driver.navigate().back();
        click(By.xpath(lAlarmIslemleriAlarmSil));
    }

    @Then("The alarm must be deleted.")
    public void theAlarmMustBeDeleted() {
        int yeniAlarmSayisi = driver.findElements(By.xpath(lAlarmIslemleriAlarmListesi)).size();
        Assert.assertEquals(alarmSayisi, yeniAlarmSayisi);
    }

}

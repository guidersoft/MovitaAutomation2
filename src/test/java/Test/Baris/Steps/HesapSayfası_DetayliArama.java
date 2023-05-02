package Test.Baris.Steps;

import Locaators.AccountPageLocators;
import Locaators.HomePageLocator;
import ReuseableClass.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;

import static ReuseableClass._Conditions.urlContains;
import static ReuseableClass._Conditions.visibilty;
import static Test.Baris.Locators.HesapSayfasiLocators.detayliAramaInput;

public class HesapSayfası_DetayliArama extends BaseClass implements HomePageLocator, AccountPageLocators {

    @Then("user confirms that he is on the desired page")
    public void userConfirmsThatHeIsOnTheDesiredPage() {
       waitFor(urlContains,"arac_rapor");
    }

    @Then("The input field in the following table must be verified to be side by side")
    public void theInputFieldInTheFollowingTableMustBeVerifiedToBeSideBySide(DataTable table) {
        table.asList().forEach(s -> $(xpath(detayliAramaInput, s)).waitFor(visibilty, null));
    }

    @Then("The format of the data to be entered as {string}  should be shown to the user as {string}.")
    public void theFormatOfTheDataToBeEnteredAsShouldBeShownToTheUserAs(String inputName, String dateFormatText) {
        String actuelResult = $(xpath(detayliAramaInput,inputName)).getCurrentElement().getAttribute("placeholder");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate.parse(actuelResult, formatter);
        } catch (DateTimeParseException e) {
            Assert.fail();
        }

    }

    @When("the user selects start date and finish date from the following table")
    public void theUserSelectsStartDateAndFinishDateFromTheFollowingTable(DataTable table) {
        Map<String, String> dateText = table.asMap();

        //region SelectDate_1
        String startDateTex = dateText.get("Start Date");
        String[] selectDate_1 = startDateTex.split("-");
        if (selectDate_1[1].startsWith("0"))
            selectDate_1[1] = selectDate_1[1].replace("0", "");
        if (selectDate_1[2].startsWith("0"))
            selectDate_1[2] = selectDate_1[2].replace("0", "");
        $(startDate).click();
        new Select($(selectyearDate_1).waitFor(visibilty,null).getCurrentElement()).selectByValue(selectDate_1[0]);
        new Select($(selectmonthDate_1).waitFor(visibilty,null).getCurrentElement()).selectByValue(String.valueOf((Integer.parseInt(selectDate_1[1])-1)));
        $(xpath(dayselectDate_1, selectDate_1[2])).waitFor(visibilty,null).click();
        //endregion


        //region SelectDate_2
        String finishDateTex = dateText.get("Finish Date");
        String[] selectDate_2 = finishDateTex.split("-");
        if (selectDate_2[1].startsWith("0"))
            selectDate_2[1] = selectDate_2[1].replace("0", "");
        if (selectDate_2[2].startsWith("0"))
            selectDate_2[2] = selectDate_2[2].replace("0", "");
        $(fnishDate).click();
        new Select($(selectyearDate_2).waitFor(visibilty,null).getCurrentElement()).selectByValue(selectDate_2[0]);
        new Select($(selectmonthDate_2).waitFor(visibilty,null).getCurrentElement()).selectByValue(String.valueOf((Integer.parseInt(selectDate_2[1])-1)));
        $(xpath(dayselectDate_2, selectDate_2[2])).waitFor(visibilty,null).click();
        //endregion
    }

    @And("user clicks {string} links")
    public void userClicksLinks(String linkText) {
        $(xpath(ALL_DIV,linkText)).click();
    }


    @And("User sends Date value to the {string} section of the Detayli Arama section")
    public void userSendsDateValueToTheSectionOfTheDetayliAramaSection(String text,DataTable table) {
        List<String> date = table.asList();
        for (String date_ : date) {
            $(xpath(detayliAramaInput, text)).sendKeys(date_);
            List<WebElement> elements = $(araclistesi).getCurrentElement().findElements(xpath(aracListesi_Tarih, date_));
            for (WebElement element : elements) {
                wait.until(ExpectedConditions.visibilityOf(element));
            }
        }
    }

    @And("User sends starttime value to the {string} section of the Detayli Arama section")
    public void userSendsTimeValueToTheSectionOfTheDetayliAramaSection(String text, DataTable table) {
        List<String> time = table.asList();
        for (String time_ : time) {
            $(xpath(detayliAramaInput, text)).sendKeys(time_);
            List<WebElement> elements = $(araclistesi).getCurrentElement().findElements(xpath(aracListesi_IseBaslama, time_));
            for (WebElement element : elements) {
                wait.until(ExpectedConditions.visibilityOf(element));
            }
        }
    }

    @And("User sends finishtime value to the {string} section of the Detayli Arama section")
    public void userSendsFinishtimeValueToTheSectionOfTheDetayliAraamaSection(String text,DataTable table) {
        List<String> time = table.asList();
        for (String time_ : time) {
            $(xpath(detayliAramaInput, text)).sendKeys(time_);
            List<WebElement> elements = $(araclistesi).getCurrentElement().findElements(xpath(aracListesi_IseBitis, time_));
            for (WebElement element : elements) {
                wait.until(ExpectedConditions.visibilityOf(element));
            }
        }
    }
}

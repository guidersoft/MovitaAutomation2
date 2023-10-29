package Test.Baris.Steps;

import Test.Baris.Locators.AccountPageLocators;
import Test.Baris.Locators.HomePageLocator;
import ReuseableClass.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;

import static ReuseableClass._Conditions.urlContains;
import static ReuseableClass._Conditions.visibilty;
import static Test.Baris.Locators.HesapSayfasiLocators.detayliAramaInput;

public class HesapSayfası_DetayliArama extends BaseClass implements HomePageLocator, AccountPageLocators {
    public static void main(String[] args) {
        System.out.println("Jira-Githup bağlantısı için deneme pull request");
    }

    String text = "";
    private String tarihText;
    private String startWorkTime;
    private String finishWorkTime;


    @Then("The input field in the following table must be verified to be side by side")
    public void theInputFieldInTheFollowingTableMustBeVerifiedToBeSideBySide(DataTable table) {
        table.asList().forEach(s -> $(xpath(detayliAramaInput, s)).waitFor(visibilty, null));
    }

    @Then("The format of the data to be entered as {string}  should be shown to the user as {string}.")
    public void theFormatOfTheDataToBeEnteredAsShouldBeShownToTheUserAs(String inputName, String dateFormatText) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String actuelResult = $(xpath(detayliAramaInput, inputName))
                .waitFor(visibilty, null)
                .getCurrentElement().getAttribute("placeholder");
        try {
            LocalDate.parse(actuelResult, formatter);
        } catch (DateTimeParseException e) {
            Assert.fail();
        }
    }

    @When("the user selects start date and finish date from the following table")
    public void theUserSelectsStartDateAndFinishDateFromTheFollowingTable(DataTable table) {
        Map<String, String> dateText = table.asMap();
        selectDate(dateText.get("Start Date"), startDate, selectyearDate_1, selectmonthDate_1, dayselectDate_1);
        selectDate(dateText.get("Finish Date"), fnishDate, selectyearDate_2, selectmonthDate_2, dayselectDate_2);


    }

    private String removeLeadingZeros(String str) {
        if (str.startsWith("0")) {
            return str.replaceFirst("^0+(?!$)", "");
        }
        return str;
    }

    private void selectDate(String dateText, By dateElement, By yearElement, By monthElement, String dayElement) {
        String[] selectDate = dateText.split("-");
        selectDate[1] = removeLeadingZeros(selectDate[1]);
        selectDate[2] = removeLeadingZeros(selectDate[2]);
        $(dateElement).click();
        new Select($(yearElement).waitFor(visibilty, null).getCurrentElement()).selectByValue(selectDate[0]);
        new Select($(monthElement).waitFor(visibilty, null).getCurrentElement()).selectByValue(String.valueOf((Integer.parseInt(selectDate[1]) - 1)));
        $(xpath(dayElement, selectDate[2])).waitFor(visibilty, null).click();
    }

    @And("user clicks {string} links")
    public void userClicksLinks(String linkText) {
        $(xpath(raporlarLink, linkText)).click();
    }


    @And("User sends to the {string} value {string} section of the Detayli Arama section")
    public void userSendsToTheSectionOfTheDetayliAramaSection(String time, String link) throws InterruptedException {
        if (time.isEmpty()) {
            return;
        }
        $(xpath(detayliAramaInput, link)).click().sendKeys(time);
        switch (link) {
            case "Tarih": {
                this.tarihText = time;
                break;
            }
            case "İşe Başlama": {
                this.startWorkTime = time;
                break;
            }
            case "İş Bitiş": {
                this.finishWorkTime = time;
                break;
            }
        }
        System.setProperty("LinkType", link);
    }


    @Then("The ordered list with the text {string} or {string} or {string} should be visible")
    public void theOrderedListWithTheTextOrOrShouldBeVisible(String Datetext, String startTime, String finisTime) {
        for (WebElement element : $(araclistesi).getElementList()) {
            try {
                if ((tarihText == null || element.findElement(xpath(aracListesi_Tarih, tarihText)) != null) &&
                        (startWorkTime == null || element.findElement(xpath(aracListesi_IseBaslama, startWorkTime)) != null) &&
                        (finishWorkTime == null || element.findElement(xpath(aracListesi_IseBitis, finishWorkTime)) != null)) {
                }
            } catch (Exception e) {
                $(leftMenuIkon).click();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }

                Assert.fail();
            }
        }
    }
}

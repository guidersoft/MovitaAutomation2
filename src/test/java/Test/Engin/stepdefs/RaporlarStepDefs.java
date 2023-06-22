package Test.Engin.stepdefs;

import Base.BaseMovita;
import Test.Engin.Base.EnginBase;
import Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


import java.awt.*;

import static Test.Engin.Locator.Locators.*;


public class RaporlarStepDefs extends BaseMovita {
    EnginBase eb = new EnginBase();
    int beforeSizeDataileredTable;
    int afterSizeDataileredTable;


    @Given("user clicks {string} on the asideMenu")
    public void userClicksOnTheAsideMenu(String text) {
        click(eb.headerAsideMenu(text));
    }

    @When("user clicks {string} on the sunMenu")
    public void userClicksOnTheSunMenu(String text) {
        click(eb.subAsideMenu(text));
    }

    @And("user select {string} and {string}")
    public void userSelectAnd(String baslangic, String bitis) {
        sendeys(driver.findElement(By.id("tarih1")), baslangic);
        driver.findElement(By.id("tarih1")).sendKeys(Keys.ENTER);

        sendeys(driver.findElement(By.id("tarih2")), bitis);
        driver.findElement(By.id("tarih2")).sendKeys(Keys.ENTER);
        click(rapor);
        waitForVisibility(lAracBazliRaporTable);
    }

    @Then("user should see the Table")
    public void userShouldSeeTheTable() {
        waitForVisibility(lDetayliAramaTablo);
        beforeSizeDataileredTable = driver.findElements(lAracBazliRaporTable).size();
    }


    @Given("user enters the date in the {string} field as a {string}")
    public void userEntersTheDateInTheFieldAsA(String text, String datum) {
        click(rapor);
        click(eb.headerAsideMenu("Detaylı Filtre"));
        int beforeSizeDataileredTable = driver.findElements(lAracBazliRaporTable).size();
        sendeys(eb.datailedFilters(text), datum);
        int afterSizeDataileredTable = driver.findElements(lAracBazliRaporTable).size();
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(lEslesenKayitBulunamadi)));
        Assert.assertNotEquals(beforeSizeDataileredTable, afterSizeDataileredTable);

    }

    @Given("user enters the date in the {string} field as a {string} and {string} as a {string}")
    public void userEntersTheDateInTheFieldAsAAndAsA(String text, String datum, String text2, String datum2) {
        click(rapor);
        click(eb.headerAsideMenu("Detaylı Filtre"));
        beforeSizeDataileredTable = driver.findElements(lAracBazliRaporTable).size();
        sendeys(eb.datailedFilters(text), datum);
        sendeys(eb.datailedFilters(text2), datum2);
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(lEslesenKayitBulunamadi)));
        afterSizeDataileredTable = driver.findElements(lAracBazliRaporTable).size();
        Assert.assertNotEquals(beforeSizeDataileredTable, afterSizeDataileredTable);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(lAracBazliRaporTable, 0));

    }

    @Then("user enters the date in the {string} field as a {string} and {string} as a {string} and {string} field as a {string}")
    public void userEntersTheDateInTheFieldAsAAndAsAAndFieldAsA(String text, String datum, String text2, String datum2, String text3, String datum3) {
        click(rapor);
        click(eb.headerAsideMenu("Detaylı Filtre"));
        beforeSizeDataileredTable = driver.findElements(lAracBazliRaporTable).size();
        sendeys(eb.datailedFilters(text), datum);
        sendeys(eb.datailedFilters(text2), datum2);
        sendeys(eb.datailedFilters(text3), datum3);
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(lEslesenKayitBulunamadi)));
        afterSizeDataileredTable = driver.findElements(lAracBazliRaporTable).size();
        Assert.assertNotEquals(beforeSizeDataileredTable, afterSizeDataileredTable);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(lAracBazliRaporTable, 0));

    }

    @Then("user driver quit")
    public void userDriverQuit() {
        Driver.quitDriver();
    }

    @Then("user should see {string} on the Page")
    public void userShouldSeeOnThePage(String locator) {
        waitForVisibility(eb.aracBazliDefaultLocator(locator));

    }

    @Given("user should see Detayli Ara")
    public void userShouldSeeDetayliAra() {
        waitForVisibility(By.xpath("//div[@class='row']/div[@class='col-md-9']//span[text()='Detaylı Filtre']"));
    }

    @When("user should see Exel, PDF and printer button")
    public void userShouldSeeExelPDFAndPrinterButton() {
        waitForVisibility(By.xpath("(//div[@class='row']/div[@class='col-md-9']//div/a)[1]"));
        waitForVisibility(By.xpath("(//div[@class='row']/div[@class='col-md-9']//div/a)[2]"));
        waitForVisibility(By.xpath("(//div[@class='row']/div[@class='col-md-9']//div/a)[3]"));
    }

    @And("user should see Table Right")
    public void userShouldSeeTableRight() {
        waitForVisibility(By.xpath("//div[@class='row']//table"));
    }

    @And("user should see butun Kayitlarda Ara")
    public void userShouldSeeButunKayitlardaAra() {
        waitForVisibility(By.xpath("//div[@class='row']//label[text()='Bütün Kayıtlarda Ara:']"));
    }

    @And("user should see bellow the Table onceki and sonraki")
    public void userShouldSeeBellowTheTableOncekiAndSonraki() {
        String color="#fff";

        String previous = driver.findElement(By.xpath("//div[@class='row']//a[text()='Önceki']")).getAttribute("background-color");
        String next = driver.findElement(By.xpath("//div[@class='row']//a[text()='Sonraki']")).getAttribute("background-color");
        String previous1 = Color.fromString(previous).asHex();
        String next2 = Color.fromString(next).asHex();
        Assert.assertEquals(previous1,color);
        Assert.assertEquals(next2,color);


    }

    @Then("The default height and bottom values of the left blog and the blog with the report should be equal to each other.")
    public void theDefaultHeightAndBottomValuesOfTheLeftBlogAndTheBlogWithTheReportShouldBeEqualToEachOther() {
        int sizeLeft = driver.findElement(By.xpath("//div[@class='row']/div[@class='col-md-3']")).getSize().getHeight();
        int sizeRight = driver.findElement(By.xpath("//div[@class='row']/div[@class='col-md-9']")).getSize().getHeight();
        Assert.assertEquals(sizeRight,sizeLeft);
    }
}

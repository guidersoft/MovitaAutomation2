package Movita_Adem;

import Utilities.Browsers;
import Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyStepdefs_MovitaAdem {

    WebDriver driver;
    WebDriverWait wait;

    {
        driver = Driver.getDriver(Browsers.EDGE);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By lMovitaLogo = By.xpath("//a[@class='retina-logo']/img[@alt='Canvas Logo']");
    By lMobilVasitaIzlemeText = By.xpath("//div[@class='tp-mask-wrap']//div[contains(text(),'Mobil Vasıta İzleme Takip Sistemi')]");

    By lLanguageButton = By.xpath("//img[@alt='English']");
    By lEnglishButton = By.xpath("//a[@class='dropdown-item'][1]");
    By lTurkishButton = By.xpath("//a[@class='dropdown-item'][1]");
    By lMobilVehicleTrackingText = By.xpath("//div[@class='tp-mask-wrap']//div[contains(text(),'Mobile Vehicle')]");


    /*
    @Given("user on {string} page")
    public void userOnHttpsWwwMovitaComTrLoginPage(String url) {
        driver.get(url);
    }


    @Then("click yapinca {string} yazisi ekranda cikmali")
    public void clickYapincaMobilVasitaIzlemeTakipSistemiYazisiEkrandaCikmali(String text) {
        click(lMovitaLogo);
        visible(lMobilVasitaIzlemeText);
        pause(2000);
        getScreenshot("Mobil Vasita İzleme Text 01_");
    }


    @Given("Clickable olmali")
    public void clickableOlmali() {
        click(lLanguageButton);
    }

    @When("Iki secenegi click yapabilmeli:")
    public void ıkiSecenegiClickYapabilmeli() {
        click(lEnglishButton);
        click(lLanguageButton);
        click(lTurkishButton);

    }

    @And("English “Mobile Vehicle Tracking System” yazisi gözükmeli")
    public void englishMobileVehicleTrackingSystemYazisiGözükmeli() {
        click(lLanguageButton);
        click(lEnglishButton);
        visible(lMobilVehicleTrackingText);
        pause(2000);
        getScreenshot("Mobile Vehicle Tracking Text");

    }

    @Then("Türkce “Mobil Vasita izleme takip Sistemi” yazisi gözükmeli")
    public void türkceMobilVasitaIzlemeTakipSistemiYazisiGözükmeli() {
        click(lLanguageButton);
        click(lTurkishButton);
        visible(lMobilVasitaIzlemeText);
        pause(2000);
        getScreenshot("Mobil Vasıta İzleme Text 02_");
    }


    public void getScreenshot(String name) {

        String isim = "src/test/java/Movita_Adem/" + name + LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd_MM_yyyy")) + ".png";

        TakesScreenshot takesScreenshot = ((TakesScreenshot) driver);

        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File target = new File(isim);

        try {
            FileUtils.copyFile(source, target);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void pause(long millis) {
        new Actions(driver).pause(millis).perform();
    }

    public void click(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        click(element);

    }

    public void click(WebElement element) {
        element.click();

    }

    public void visible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void visible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

     */

}

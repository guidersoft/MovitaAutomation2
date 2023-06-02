package Test.Baris.Steps;

import ReuseableClass.BaseClass;
import ReuseableClass._Conditions;
import Test.Baris.Locators.AccountPageLocators;
import Test.Baris.Locators.HomePageLocator;
import com.beust.jcommander.internal.Console;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AracBazliRaporModul extends BaseClass implements AccountPageLocators, HomePageLocator {
    List<Boolean> list = new ArrayList();

    @When("the user clicks sequentially on the following data")
    public void theUserClicksSequentiallyOnTheFollowingData(DataTable table) throws InterruptedException {
        List<String> iconText = table.asList();
        String folderPath = "C:\\Users\\user\\Downloads";
        String targetText = "Tarihleri Arasındaki Seyahat Raporu";


        for (int i = 0; i < iconText.size(); i++) {
            switch (iconText.get(i)) {
                case "Excel Olarak İndir" -> checkAndDeleteFile(folderPath, targetText + ".xlsx");
                case "Pdf Olarak İndir" -> checkAndDeleteFile(folderPath, targetText + ".pdf");
            }
            Thread.sleep(2000);
            $(xpath(downloadReportIcon, iconText.get(i))).click();
            Thread.sleep(2000);
            if (iconText.get(i).equals("Yazıcıdan Çıkart"))
                new Actions(driver).sendKeys(Keys.TAB).pause(Duration.ofSeconds(2)).sendKeys(Keys.ENTER);
            boolean isDownloadFile = checkFileExists(targetText, folderPath);
            list.add(isDownloadFile);
            if (isDownloadFile) {
                logInfo("Yeni dosya başarıyla indirildi.");
            } else {
                logWarning("Yeni dosya indirilemedi.");
            }

        }
    }

    @Then("User verifies that the files have been downloaded")
    public void dosyalarinIndirildiğiniDoğrula() {
        for (Boolean aBoolean : list) {
            if (!aBoolean) {
                Assert.fail("Dosya İndirilemedi");
            }
        }

    }

    @Then("The left blog should contain the following links")
    public void theLeftBlogShouldContainTheFollowingLinks(DataTable table) {
        List<String> links = table.asList();

        for (String link : links) {
            switch (link) {
                case "Araç Dropdown Menu" -> $(selectCarDropdown).waitFor(_Conditions.visibilty, null);
                case "Başlangıç Tarihi" -> $(startDate).waitFor(_Conditions.visibilty, null);
                case "Bitiş Tarihi" -> $(fnishDate).waitFor(_Conditions.visibilty, null);
            }
        }

    }

    @Then("Aktive edilmemiş olarak {string} butonu")
    public void aktiveEdilmemişOlarakButonu(String linkText) {
        boolean enabled = $(xpath(raporlarLink, linkText)).getCurrentElement().isEnabled();
        if (enabled) {
            logInfo(linkText + " butonu active Durumdadır.");
            Assert.fail(linkText + " butonu active Durumdadır.");
        }
    }

    @Then("Sol blog ile raporun olduğu blogun default height ve bottom değerleri birbirine eşit olmalıdır.")
    public void solBlogIleRaporunOlduğuBlogunDefaultHeightVeBottomDeğerleriBirbirineEşitOlmalıdır() {
        By solBlog = By.xpath("//div[@class=\"card-body pt-1\"]");
        By sagBlog = By.xpath("//div[@class=\"card-block\"]");
        Dimension leftSize = driver.findElement(solBlog).getSize();
        Dimension rigthSize = driver.findElement(sagBlog).getSize();
        if (leftSize.getHeight() != rigthSize.getHeight() && leftSize.getWidth() != rigthSize.getHeight()) {
            Assert.fail("Sol blog ile raporun olduğu blogun default height ve bottom değerleri birbirine eşit değildir".toUpperCase());
        }


    }

    @Then("Tablonun altında tablonun sayfaları arasında geçiş yapmak için ‘Önceki’ ve ‘Sonraki’ butonları bulunmalıdır.")
    public void tablonunAltındaTablonunSayfalarıArasındaGeçişYapmakIçinÖncekiVeSonrakiButonlarıBulunmalıdır() {
        By locator = By.xpath("//td[contains(.,'Tabloda herhangi bir veri mevcut değil')]");
        By sonucSayfaSayisi = By.xpath("//li[@class=\"paginate_button page-item active\"]//a");
        WebElement oncekiElement = $(xpath(ALL_A, "Önceki")).getCurrentElement();
        WebElement sonrakiElement = $(xpath(ALL_A, "Sonraki")).getCurrentElement();

        if ($(locator).getCurrentElement().isDisplayed()) {
            if (!oncekiElement.isEnabled() && !sonrakiElement.isEnabled()) {
                Assert.fail("Tabloda herhangi bir veri mevcut olmadığı halde 'Önceki' ve 'Sonraki' linkleri active durumdadır".toUpperCase());
            }
        } else {
            List<WebElement> elements = driver.findElements(sonucSayfaSayisi);
            if (elements.size() > 0) {
                int sayfaSayisi = Integer.parseInt($(sonucSayfaSayisi).getText());
                if (sayfaSayisi > 1 & !oncekiElement.isEnabled() && !sonrakiElement.isEnabled()) {
                    Assert.fail("Tabloda  ez az 2 sayfa veri mevcut olduğu halde 'Önceki' ve 'Sonraki' linkleri active durumda değildir\".toUpperCase()");
                }
            }
        }


    } // TODO: 30.05.2023  
}

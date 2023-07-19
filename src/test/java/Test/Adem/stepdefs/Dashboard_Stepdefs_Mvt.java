package Test.Adem.stepdefs;

import Test.Adem.locators.Locators_Dashboard;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Dashboard_Stepdefs_Mvt extends Base_Mvt implements Locators_Dashboard {

    @io.cucumber.java.en.When("Kullanici {string} sekmesine tıklar")
    public void kullaniciSekmesineTıklar(String text) {
        click(dashboardAnaMenuXpathWithText(text));
    }

    @io.cucumber.java.en.Then("{string} ve {string} alt sekmeleri acilmalidir")
    public void veAltSekmeleriAcilmalidir(String text1, String text2) {
        visible$(dashboardSubMenuXpathWithText("Güzergah İşlemleri", text1))
                .visible$(dashboardSubMenuXpathWithText("Güzergah İşlemleri", text2));
    }

    @io.cucumber.java.en.When("{string} alt sekmesine tiklar")
    public void altSekmesineTiklar(String text) {
        click(dashboardSubMenuXpathWithText("Güzergah İşlemleri", text));
        bekleByActions(1000);
    }

    @io.cucumber.java.en.Then("Asagidaki filtre kriterlerini gormelidir")
    public void veFiltreKriterleriniGormelidir(DataTable dataTable) {
        List<String> list = dataTable.asList();
        for (String s : list) {
            String xpatStr = String.format(strAracBazliGuzergahTablosu, s);
            visible(By.xpath(xpatStr));
        }
    }

    @io.cucumber.java.en.When("{string} butonuna tiklar")
    public void butonunaTiklar(String text) {
        click(xpathWithText(text));
    }

    @io.cucumber.java.en.Then("Filtre kriterlerine uyan rotalari ekranda gormelidir")
    public void filtreKriterlerineUyanRotalariEkrandaGormelidir() {
        List<WebElement> elementsHarita = driver.findElements(lAracBazliGuzergahHaritaListesi);
        List<WebElement> elementsGuzergah = driver.findElements(lAracBazliGuzergahListesi);
        if (elementsGuzergah.size() > 0) {
            Assert.assertEquals(elementsHarita.size(), elementsGuzergah.size());
        }
    }

    @io.cucumber.java.en.Then("Onceden goruntulenen rotalari artik ekranda gormemelidir")
    public void oncedenGoruntulenenRotalariArtikEkrandaGormemelidir() {
        List<WebElement> elementsHarita = driver.findElements(lAracBazliGuzergahHaritaListesi);
        List<WebElement> elementsGuzergah = driver.findElements(lAracBazliGuzergahListesi);
        if (elementsGuzergah.size() > 0) {
            Assert.assertEquals(elementsHarita.size(), 0);
        }
    }

}

package Test.Baris.Steps;

import ReuseableClass.BaseClass;
import ReuseableClass._Conditions;
import Test.Baris.Locators.AlarmIslemleriLocators;
import Test.Baris.Pages.AlarmIslemleri;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Alarm extends BaseClass implements AlarmIslemleriLocators {


    @When("kulanici Alarm İşlemleri'e tıklar,")
    public void kulaniciAlarmİşlemleriETıklar() {
        $(xpath(ALL_SPAN,"Alarm İşlemleri")).click();
    }

    @Then("Alarm Listesi sayfasında olduğunu doğrular,")
    public void alarmListesiSayfasındaOlduğunuDoğrular() {
        wait.until(ExpectedConditions.urlContains("alarm-listesi"));
    }

    @And("{string}ye tıklar, {string}, {string} ve {string}nin görüntülendiğini doğrular,")
    public void yeTıklarVeNinGörüntülendiğiniDoğrular(String arg0, String arg1, String arg2, String arg3) {
        $(xpath(ALL_SPAN,arg0)).click();
        $(xpath(detayliAramaElemanlari,arg1)).waitFor(_Conditions.visibilty,null);
        $(xpath(detayliAramaElemanlari,arg2)).waitFor(_Conditions.visibilty,null);
        $(xpath(detayliAramaElemanlari,arg3)).waitFor(_Conditions.visibilty,null);

    }

    @When("{string} düğmesine tıklar,")
    public void düğmesineTıklar(String arg0) {
        $(xpath(ALL_A,arg0)).click();
    }

    @Then("{string}, {string}, {string}, {string}, {string}, {string} ve {string} alanlarının görüntülendiğini doğrular,")
    public void veAlanlarınınGörüntülendiğiniDoğrular(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6) {

        String [] alanlar={arg0,arg1, arg2,arg3,arg4,arg5,arg6};

        Arrays.stream(alanlar)  .forEach(alan -> $(xpath(alarmBilgisiElemanlari, alan))
                                .waitFor(_Conditions.visibilty, null));
    }

    @And("{string} filtresi için {string}, {string}, {string} ve {string} gibi seçeneklerin bulunduğunu doğrular,")
    public void filtresiIçinVeGibiSeçeneklerinBulunduğunuDoğrular(String arg0, String arg1, String arg2, String arg3, String arg4) {

        String [] alanlar={arg1, arg2,arg3,arg4};
        for (String alan : alanlar) {
            $(xpath(alarmTipleri,arg0,alan)).waitFor(_Conditions.visibilty,null);
        }

    }

    @And("{string} filtresi için {string} ve {string} gibi seçeneklerin bulunduğunu doğrular,")
    public void filtresiIçinVeGibiSeçeneklerinBulunduğunuDoğrular(String arg0, String arg1, String arg2) {

        String [] alanlar={arg1, arg2};
        for (String alan : alanlar) {
            $(xpath(alarmTipleri,arg0,alan)).waitFor(_Conditions.visibilty,null);
        }
    }

    @And("{string} filtresinde haftanın tüm günlerini, hafta sonları dahil olmak üzere seçebilir olduğunu doğrular,")
    public void filtresindeHaftanınTümGünleriniHaftaSonlarıDahilOlmakÜzereSeçebilirOlduğunuDoğrular(String arg0) throws InterruptedException {

        String [] alanlar={"Pazartesi","Salı","Çarşamba","Perşembe","Cuma","Cumartesi","Pazar"};
        for (String gun : alanlar) {
            $(xpath(aktifGunler,arg0,gun)).waitFor(_Conditions.visibilty,null);
        }
    }

    String alarmAciklama="";
    @And("Asağıdaki alarm bilgileri ile bir alarm kaydeder,")
    public void düğmesininAlarmıKaydettiğiniDoğrular(DataTable table) {

        Map<String, String> asMap = table.asMap();

        alarmAciklama = asMap.get("aciklama")+RandomStringUtils.randomAlphabetic(3);

        new AlarmIslemleri().alarmEkle(
                alarmAciklama,
                asMap.get("alarmTipi"),
                asMap.get("SMSBildirimTipi"),
                asMap.get("bolgedeKalmaSuresi_dakika"),
                asMap.get("birSonrakiBolgeyeMaxVarmaSuresi_dakika"),
                asMap.get("ihlalCezasi"),
                asMap.get("aktifgunler").split(","));

    }


    @And("Eklenen Alarm Alarm Listesinde olduğunu doğrular")
    public void eklenenAlarmAlarmListesindeOlduğunuDoğrular() {
        $(xpath(ALL_A,"Alarm Listesi")).click();
        $(xpath(alarmDuzenlemeIcon,alarmAciklama)).scrollByElement().waitFor(_Conditions.visibilty,null);


    }
    String yeniaciklama="";
    @And("Eklenen alarmın düzenlenebilir olduğunu doğrular")
    public void eklenenAlarmınDüzenlenebilirOlduğunuDoğrular() {

        String alarmKodu = $(xpath(getalarmkodu, alarmAciklama)).getText();
        $(xpath(alarmDuzenlemeIcon,alarmAciklama)).scrollByElement().waitFor(_Conditions.visibilty,null).click();
        wait.until(ExpectedConditions.urlContains(alarmKodu));
        AlarmIslemleri alarmIslemleri = new AlarmIslemleri();
        yeniaciklama = alarmAciklama + RandomStringUtils.randomAlphabetic(3);
        alarmIslemleri.aciklamaEkle(yeniaciklama);
        alarmIslemleri.clickKaydetButton();
        wait.until(ExpectedConditions.urlContains("alarm-listesi"));
        $(xpath(alarmDuzenlemeIcon,yeniaciklama)).scrollByElement().waitFor(_Conditions.visibilty,null);


    }

    @And("Eklenen alarmın silinebilir olduğunu doğrular")
    public void eklenenAlarmınSilinebilirOlduğunuDoğrular() {
        $(xpath(alarmSilmeIcon,yeniaciklama)).scrollByElement().click();
        Assert.fail();
        try {
            $(xpath(getalarmkodu, yeniaciklama)).getCurrentElement();
            Assert.fail();
        } catch (Exception e) {
            System.out.println("Alarm Silindi");
        }


    }
}

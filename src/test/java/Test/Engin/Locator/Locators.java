package Test.Engin.Locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface Locators {
    By lAracBazliRaporTable=By.xpath("//div[@id='raporsonuc']//table//tbody/tr");
    By lDetayliAramaTablo=By.xpath("//div[@id='accordion_filtre']//form/div/div/div/input");
    By rapor=By.xpath("//div[@class='btn border-info info tag-border']//ancestor::a");
    By lEslesenKayitBulunamadi = By.xpath("//table//tr[@class='odd']/td[text()='Eşleşen kayıt bulunamadı']");
    By lDetayliAramaButton = By.xpath("//div[@class='card']//li/a/span[text()='Detaylı Filtre']");
    By lAlarmEkleButton = By.xpath("//div[@class='card']//li/a[text()='Alarm Ekle']");
    By lAlarmEkleNotifikation = By.xpath("//strong[contains(.,'Dikkat!')]");
    By lAlarmBilgisiText= By.xpath("//div/h4");
    By lSelectMenus = By.xpath("//div//select//option");




}

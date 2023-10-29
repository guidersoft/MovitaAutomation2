package Test.Adem.locators;

import org.openqa.selenium.By;

public interface Locators_Dashboard {

    // Raporlar:
    By lRaporlarAnaMenu = By.xpath("//span[text()='Raporlar']");


    // Raporlar > Araç Bazlı Rapor:
    By lRaporlarSidebar = By.xpath("//a[contains(.,'Raporlar')]");
    By lAracBazliRaporAltMenu = By.xpath("//a[contains(.,'Araç Bazlı Rapor')]");
    By lSolBlokAracSelectMenu = By.xpath("//select[@id='aracSelect']");
    By lSolBlokBaslangicTarihiSekme = By.xpath("//div[./label[text()='Başlangıç Tarihi '] and .//input[@id='tarih1']]");
    By lSolBlokBitisTarihiSekme = By.xpath("//div[./label[text()='Bitiş Tarihi '] and .//input[@id='tarih2']]");
    By lSolBlokRaporAlButton = By.xpath("//div[@class='btn border-info info tag-border']");

    By lSagBlokDetayliFiltreButton = By.xpath("//a[contains(.,'Detaylı Filtre')]");
    By lSagBlokExcelOlarakIndirButton = By.xpath("//a[contains(@title,'Excel Olarak İndir')]");
    // Pdf Olarak İndir, Yazıcıdan Çıkart ve Excel Olarak İndir butonlari ayni locatorla stepdefs içinde seçildi.
    By lSagBlokButunKayitlardaAraSearch = By.xpath("//label[contains(text(),'Bütün Kayıtlarda Ara:') and ./input[@type='search']]");
    By lSagBlokSonucTablosuFull = By.id("raporsonuc");
    By lSagveSolBlokBody = By.xpath("//div[@class='card']");
    By lSagBlokOncekiButton = By.xpath("//li[@id='DataTables_Table_0_previous']");
    By lSagBlokSonrakiButton = By.xpath("//li[@id='DataTables_Table_0_next']");


    // Guzergah İşlemleri:
    String strAracBazliGuzergahTablosu = "//div[@class='table-responsive']//th[contains(.,'%s')]";
    By lAracBazliGuzergahListesi = By.xpath("//div[@id='map_plaka_list_panel']//a");
    By lAracBazliGuzergahHaritaListesi = By.xpath("//div[@class='table-responsive']//tbody/tr");


}

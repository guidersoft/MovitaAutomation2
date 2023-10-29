package Test.Adem.stepdefs;

import Test.Adem.locators.Locators_Dashboard;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AracBazliRapor_Mvt extends Base_Mvt implements Locators_Dashboard {

    @Then("Kullanici dashboard u görmeli")
    public void kullaniciDashboardUGörmeli() {
        visible(lRaporlarSidebar);
    }

    @When("Raporlar altındaki Arac Bazli Rapor alt menuye tıklar")
    public void raporlarAltındakiAracBazliRaporAltMenuyeTıklar() {
        click(lAracBazliRaporAltMenu);
    }

    @Then("Sol blokta Text, Araç, Başlangıç Tarihi, Bitiş Tarihi, Rapor Al bolumleri bulunmalıdır.")
    public void solBloktaAsagidakiButonlarBulunmalıdır() {
        visible$(lSolBlokAracSelectMenu).visible$(lSolBlokBaslangicTarihiSekme).visible$(lSolBlokBitisTarihiSekme).visible$(lSolBlokRaporAlButton);
    }

    @And("‘Rapor Al’ butonu aktive edilmemiş olmalidir.")
    public void raporAlButonuAktiveEdilmemişOlmalidir() {
        softAssert.assertFalse(getWebElement(lSolBlokRaporAlButton).isEnabled(), "'Rapor Al' butonu aktif durumdadır.");
    }

    @And("Sag blokta ‘Detaylı Arama' ve asagidaki butonlar,")
    public void sagBloktaDetaylıAramaButonuExcelPdfYazıcıdanÇıkartButonları(DataTable dataTable) {
        List<String> list = dataTable.asList();
        for (String text : list) {
            By xpathIndirButonlari = By.xpath("//a[contains(@title,'" + text + "')]");
            visible(xpathIndirButonlari);
        }
        visible(lSagBlokDetayliFiltreButton);// Text de "Detaylı Arama" yerine "Detaylı Filtre" yazıyor.
    }

    @And("‘Bütün Kayıtlarda Ara’ arama motoru ve bunlarin altinda arama sonucunu gösteren bir sonuc tablosu,")
    public void bütünKayıtlardaAraAramaMotoruVeBunlarinAltindaAramaSonucunuGösterenBirSonucTablosu() {
        visible(lSagBlokButunKayitlardaAraSearch);
        visible(lSagBlokSonucTablosuFull);
    }

    @And("Tablonun altında ‘Rapor almak için sol tarafda tarih aralığı seçerek 'Rapor Al’ butonuna tıklayınız.’ ifadesi bulunmalıdır.")
    public void tablonunAltındaRaporAlmakIçinSolTarafdaTarihAralığıSeçerekRaporAlButonunaTıklayınızIfadesiBulunmalıdır() {
        softAssert.assertTrue(getWebElement(lSagBlokSonucTablosuFull).getText()
                .contains("'Rapor Al’ butonuna tıklayınız"), "Tablonun altında 'Rapor Al' butonuna tıklayınız ifadesi bulunmamaktadır.");
    }

    @And("Sol blok ile raporun olduğu sag blokun default height ve bottom değerleri birbirine eşit olmalıdır.")
    public void solBlokIleRaporunOlduğuSagBlokunDefaultHeightVeBottomDeğerleriBirbirineEşitOlmalıdır() {
        // Bottom : Elementin alt kenarının; Top : Üst kenarının dikey koordinatıdır.
        List<WebElement> elements = driver.findElements(lSagveSolBlokBody);
        softAssert.assertEquals(elements.get(0).getLocation().y + elements.get(0).getSize().height,
                elements.get(1).getLocation().y + elements.get(1).getSize().height,
                "Elementlerin bottom değerleri eşit değildir.");
        softAssert.assertEquals(elements.get(0).getSize().height, elements.get(1).getSize().height,
                "Elementlerin yükseklikleri eşit değildir.");
    }

    @And("Tablonun altında ‘Önceki’ ve ‘Sonraki’ butonları bulunmalıdır.")
    public void tablonunAltındaÖncekiVeSonrakiButonlarıBulunmalıdır() {
        visible(lSagBlokOncekiButton);
        visible(lSagBlokSonrakiButton);
    }

    @And("Ancak bu butonlar tek sayfa veri olduğunda ve hiç veri olmadığında aktif olmamalidir.")
    public void ancakBuButonlarTekSayfaVeriOlduğundaVeHiçVeriOlmadığındaAktifOlmamalidir() {
        assertElementContainsText(lSagBlokSonucTablosuFull, "Tabloda herhangi bir veri mevcut değil");
        boolean isDisabledOncekiButon = getWebElement(lSagBlokOncekiButton).getAttribute("class").contains("disabled");
        softAssert.assertTrue(isDisabledOncekiButon);
        boolean isDisabledSonrakiButon = getWebElement(lSagBlokSonrakiButton).getAttribute("class").contains("disabled");
        softAssert.assertTrue(isDisabledSonrakiButon);
    }

    @And("Bütün butonlar mouse ile üzerine gelindiğinde kullanıcıya reaksiyon göstermelidir.")
    public void bütünButonlarMouseIleÜzerineGelindiğindeKullanıcıyaReaksiyonGöstermelidir(DataTable dataTable) {
        assertCursorIsPointer(lSolBlokRaporAlButton);
        assertCursorIsPointer(lSolBlokAracSelectMenu);
        assertCursorIsPointer(lSagBlokDetayliFiltreButton);

        List<String> list = dataTable.asList();
        for (String text : list) {
            By xpathIndirButonlari = By.xpath("//a[contains(@title,'" + text + "')]");
            assertCursorIsPointer(xpathIndirButonlari);
        }

    }


}

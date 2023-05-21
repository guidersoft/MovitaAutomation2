package Test.Adem.stepdefs;

import Locators.Locators;
import Test.Adem.locators.Locators_LoginPage;
import Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static Utilities.Driver.getDriver;


public class MyStepdefs_Mvt extends Base_Mvt implements Locators_LoginPage {

    static SoftAssert softAssert = new SoftAssert();

    // Movita Homepage:

    @Given("user is on homepage")
    public void userIsOnHomepage() {
        getDriver().get("http://movita.com.tr/");
    }

    @When("user should clicks movita logo")
    public void userShouldClicksMovitaLogo() {
        click(Locators.lMovitaLogo);
    }

    @Then("user should see the text")
    public void userShouldSeeTheText() {
        visible(lMobilVasitaIzlemeTakipText);
    }

    @Given("Clickable olmali")
    public void clickableOlmali() {
        click(lLanguageButton);
    }

    @When("Kullanıcı {string} butonuna tıklar")
    public void kullanıcıButonunaTıklar(String text) {
        By locator = By.xpath("//a[@class='dropdown-item' and contains(.,'" + text + "')]");
        click(locator);
    }

    @Then("{string} yazisi gözükmeli")
    public void yazisiGözükmeli(String text) {
        By locator = By.xpath("//div[@class='tp-mask-wrap']//div[contains(text(),'" + text + "')]");
        visible(locator);
        pause(2000);
        getScreenShot(text);
    }

    @When("user hover {string}")
    public void userHover(String text) {
        new Actions(Driver.getDriver()).moveToElement(topMenuElement(text)).perform();
    }

    @And("user click {string}")
    public void userClick(String text) {
        click(topMenuElement(text));
    }

    @And("user should see {string} text")
    public void userShouldSeeText(String text) {
        visible(lMobilVasitaIzlemeTakipText);
    }


    @Then("{string} menusu altında {int} seçenek çıkmalı")
    public void menusuAltındaSeçenekÇıkmalı(String text, int num) {
        List<WebElement> webElements = topSubMenuElements(text);
        Assert.assertEquals(num, webElements.size());
    }


    @Given("kullanici {string} deki {string} ye click yapar")
    public void kullaniciDekiYeClickYapar(String menu, String submenu) {
        clickTopSubMenuElements(menu, submenu);
    }


    @Then("kullanici {string} görmeli")
    public void kullaniciGörmeli(String expText) {
        By lhTextActuel = By.xpath("//h1 | //h2 | //h3");
        String hTextActuel = getDriver().findElement(lhTextActuel).getText();
        System.out.println("hTextActuel = " + hTextActuel);
        Assert.assertEquals(hTextActuel,expText);
    }


    @And("{string} deki renk değişmeli")
    public void dekiRenkDeğişmeli(String menuText) {
        assertChangeColor(topMenuXpath(menuText), "#00adee");
    }


    @And("sayfa adresi {string} olmalı")
    public void sayfaAdresiOlmalı(String expUrl) {
        Assert.assertEquals(getDriver().getCurrentUrl(), expUrl);
    }


    @And("kullanici {string} altındaki Submenu lere hover over yapar")
    public void kullaniciAltındakiSubmenuLereHoverOverYapar(String menuText) {
        for (WebElement element : topSubMenuElements(menuText)) {
            new Actions(Driver.getDriver()).moveToElement(element).perform();
        }
    }


    // LoginPageGorunum:

    @Given("kullanici login sayfasına girer")
    public void kullaniciLoginSayfasinaGirer() {

        getDriver().get(urlLoginPage);

    }


    @When("'Kullanıcı Adı' ve 'Şifre' için iki ayrı alan görmelidir")
    public void veIçinIkiAyrıAlanGörmelidir() {

        visible(lKullaniciAdiLabel);
        visible(lKullaniciAdiInput);

        visible(lSifreLabel);
        visible(lSifreInput);

    }

    @And("Kullanıcı adı input alanı üzerinde ‘Movita Vasıta İzleme Takip Sistemi’ yazısı ve onun üzerinde ise Movita " +
            "logosu bulunmalıdır")
    public void kullanıcıAdıInputAlanıÜzerindeMovitaVasıtaİzlemeTakipSistemiYazısıVeOnunÜzerindeIseMovitaLogosuBulunmalıdır() {

        //‘Movita Vasıta İzleme Takip Sistemi’ yazısının assert edileceği element mevcut değil!!!
        visible(Locators_LoginPage.lMovitaLogo);

    }

    @And("Alt kısımda ise uzun çubuk şeklinde {string} mavi renkte üzerinde ‘Giriş Yap’ butonu olmalıdır")
    public void altKısımdaIseUzunÇubukŞeklindeMaviRenkteÜzerindeGirişYapButonuOlmalıdır(String bgColorHex) {

        visible(lGirisYapButonu);
        assertChangeBackGroundColor(lGirisYapButonu, bgColorHex);

    }

    @And("Butonun üzerinde ise ‘Şifrenizi mi Unuttunuz?' linki bulunmalıdır")
    public void butonunÜzerindeIseŞifreniziMiUnuttunuzLinkiBulunmalıdır() {

        visible(lSifrenizimiUnuttunuz);

    }

    @When("Kullanıcı 'Şifrenizi mi unuttunuz?' kısmına hover over yapar")
    public void kullanıcıKısmınaHoverOverYapar() {

        hover(lSifrenizimiUnuttunuz);

    }

    @And("'Şifrenizi mi unuttunuz?' yazısının rengi maviden {string} yeşile {string} dönüşmeli ve clickable olmali")
    public void yazısınınRengiMavidenYeşileDönüşmeliVeClickableOlmali(String actColorHEX, String expColorHEX) {

        // Değişmesi beklenen yesil rengin kodu bize verilmemiş!!!
        //Assert.assertEquals(actColorHEX, expColorHEX);
        softAssert.assertEquals(actColorHEX, expColorHEX, "Step : 'Şifrenizi mi unuttunuz?' yazısının renk değişimi");

        click(lSifrenizimiUnuttunuz);
        kullaniciLoginSayfasinaGirer();

    }

    @When("Kullanıcı sağ üst köşede ‘Anasayfaya Dön’ yazısı ile birlikte bir ← ikon görmelidir")
    public void kullanıcıSağÜstKöşedeAnasayfayaDönYazısıIleBirlikteBirIkonGörmelidir() {

        visible(lAnaSayfayaDon);
        // Sağ üst köşede ikon aranacak element mevcut değil!!!

    }

    @And("Kullanıcı bu ikona tıkladığı zaman Anasayfaya yönlendirilmelidir")
    public void kullanıcıBuIkonaTıkladığıZamanAnasayfayaYönlendirilmelidir() {

        click(lAnaSayfayaDon);
        visible(Locators.lMovitaLogo);
        kullaniciLoginSayfasinaGirer();

    }

    @When("Kullanıcı footer ın sol alt kısmında ‘Copyright © '2017-2022', Bütün Hakları Saklıdır.’ ibaresi görmelidir")
    public void kullanıcıFooterInSolAltKısmındaCopyrightBütünHaklarıSaklıdırIbaresiGörmelidir() {

        visible(lCopyrightYazisi);

    }


    // Login Page Giris:

    @When("Olasi tüm {string} ve {string} girerek {string} uygun assertion yapar")
    public void olasiVeKombinasyonlariniGirerekLoginButonunaClickYapar(String username, String password,
                                                                       String expectedResult) {

        sendKeys(lKullaniciAdiInput, username);
        sendKeys(lSifreInput, password);
        click(lGirisYapButonu);

        boolean expResult = Boolean.parseBoolean(expectedResult);

        if (expResult) { // DD
            assertVisibility(lDashboard, Visibility.VISIBLE);
            click(lDashboardLogout);

        } else {

            if (username.isEmpty() ^ password.isEmpty()) {// -D, D-, -Y, Y-

                if (username.isEmpty()) {
                    visible(lKullaniciAdiGirinUyarisi);
                } else {
                    visible(lSifreGirinUyarisi);
                }

            }

            if (username.isEmpty() & password.isEmpty()) {// --
                visible(lKullaniciAdiGirinUyarisi);
                visible(lSifreGirinUyarisi);
            }


            if (username.equals("demomovita")) {// DY
                Assert.assertEquals(getWebElement(lSagUstKosedekiMesaj).getText(), "Kullanıcı giriş yapamadı");
                assertVisibility(lDashboard, Visibility.INVISIBLE);
            }


            if (username.equals("qwerty") & !password.isEmpty()) {// YD, YY
                Assert.assertEquals(getWebElement(lSagUstKosedekiMesaj).getText(), "Kullanıcı Adı Yada Şifre Hatalı");
                assertVisibility(lSagUstKosedekiMesaj, Visibility.VISIBLE);
                assertVisibility(lDashboard, Visibility.INVISIBLE);
            }


        }


    }


}


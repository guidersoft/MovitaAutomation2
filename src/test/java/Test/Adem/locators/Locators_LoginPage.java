package Test.Adem.locators;

import org.openqa.selenium.By;

public interface Locators_LoginPage {

    String urlLoginPage =  "https://www.movita.com.tr/login";

    // Login Page locators:
    By lKullaniciAdiLabel = By.xpath("//label[@for='username']");
    By lKullaniciAdiInput = By.xpath("//input[@id='username']");
    By lSifreInput = By.xpath("//input[@id='password']");
    By lSifreLabel = By.xpath("//label[@for='password']");
    By lGirisYapButonu = By.xpath("//button[@type='submit']");
    By lSifrenizimiUnuttunuz = By.xpath("//a[@class='btn btn-link btn-lg w-100']");
    By lMovitaLogo = By.xpath("//img[@alt='movita']");
    By lAnaSayfayaDon = By.xpath("//a[@class='btn btn-primary btn-sm fs-sm rounded d-none d-lg-inline-flex']");
    By lCopyrightYazisi = By.xpath("//p[@class='nav d-block fs-xs text-center text-xl-start pb-2 mb-0']");

    By lSagUstKosedekiMesaj = By.xpath("//div[@class='toast-message']");// Kullanıcı Adı Yada Şifre Hatalı / Kullanıcı giriş yapamadı /
    By lKullaniciAdiGirinUyarisi = By.xpath("//div[@class='position-relative mb-4']//div[1]");// Lütfen kullanıcı adı girin!
    By lSifreGirinUyarisi = By.xpath("//div[@class='password-toggle']//div[1]");// Lütfen şifre girin!
    By lDashboard = By.xpath("//li[@id='anasayfa']");// Kullanıcı hesabına girdiğinde görür
    By lDashboardLogout = By.xpath("//a[contains(text(),'Çıkış Yap')]");// Dashboard dan çıkış yapar

    By lMovitaMNVRileTumAraclarText = By.xpath("//div[@class='tp-mask-wrap']/div[contains(.,'movita MNVR ile tüm araçları" +
            " izleyip')]");








}

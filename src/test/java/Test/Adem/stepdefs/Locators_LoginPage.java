package Test.Adem.stepdefs;

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




}

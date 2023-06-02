package Locaators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface Locators {


    By llogo = By.xpath("//a[@class='standard-logo']");
    By lEnterButton = By.xpath("//button[@id='dropdownMenuButton']/parent::div");
    By lEnglishLang = By.xpath("(//button[@id='dropdownMenuButton']/parent::div//a)[1]");
    By lTurkishLang = By.xpath("(//button[@id='dropdownMenuButton']/parent::div//a)[2]");
    By lSubMenuKurumsal=By.xpath("(//ul[@class='sub-menu-container'])[1]//div");
    By lMovitaLogo=By.xpath("//a[@class='retina-logo']/img[@alt='Canvas Logo']");
    By lFlagButton=By.id("dropdownMenuButton");
    By lMobilVehicleTrackingText = By.xpath("//div[@class='tp-mask-wrap']//div[contains(text(),'Mobile Vehicle')]");
    By lMobilVasitaIzlemeText = By.xpath("//div[@class='tp-mask-wrap']//div[contains(text(),'Mobil Vasıta İzleme Takip Sistemi')]");
    By lGirisYapButton=By.xpath("//div[@class='header-row']/a");
    By lHataMessageoneorTwoFalse=By.xpath("//div[@class='toast-message']");
    By lHataMessageSifre=By.xpath("//div[contains(text(),'Lütfen şifre girin!')]");
    By lHataMessageKullanici=By.xpath("//div[contains(text(),'Lütfen kullanıcı adı')]");
    By lLoginSubmitButton=By.xpath("//button[@type='submit']");
    By lLoginSuccess=By.id("ic-logo");
    By lUserName=By.id("username");
    By lPassword=By.id("password");
    By lDemoFiloButton=By.cssSelector(".user-name");
    By lLogOut=By.xpath("(//a[@class='dropdown-item'])[4]");
    By lLoginPageMovitaLogo=By.xpath("(//div/a)[2]");
    By lLoginPageSifrenizimiUnuttunuz=By.xpath("(//div/a)[3]");
    By lLoginPageAnaSayfayaDon=By.xpath("(//div/a)[1]");
    By lLoginPageGirisYapButton=By.xpath("//button[text()='Giriş Yap']");


    WebElement homePageMenu(String text);
    String TOP_MENU = "//*[@id='header-wrap']//a[contains(.,'%s')]";
    By lLanguageOptionButton = By.xpath("//div[@class='dropdown dropdown-langs']//button");
    By lTextOfMobilVasıtaİzlemeTakipSistemi = By.xpath("//div[@class='tp-mask-wrap']//div[contains(text(),'Mobil')]");

    By lLanguageButton = By.xpath("//img[@alt='English']");


}

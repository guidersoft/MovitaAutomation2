package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface Locator {

    By llogo = By.xpath("//a[@class='standard-logo']");
    String str = "Mobil Vasıta İzleme Takip Sistemi";
    By lMobilVasitaIzlemeTakipText = By.xpath("//div[@class='tp-mask-wrap']//div[contains(text(),'Mobil Vasıta İzleme Takip Sistemi')]");

    By lEnterButton = By.xpath("//button[@id='dropdownMenuButton']/parent::div");
    By lEnglishLang = By.xpath("(//button[@id='dropdownMenuButton']/parent::div//a)[1]");
    By lTurkishLang = By.xpath("(//button[@id='dropdownMenuButton']/parent::div//a)[2]");

    By lMovitaLogo = By.xpath("//a[@class='retina-logo']/img[@alt='Canvas Logo']");
    By lMobilVasitaIzlemeText = By.xpath("//div[@class='tp-mask-wrap']//div[contains(text(),'Mobil Vasıta İzleme Takip Sistemi')]");

    By lLanguageButton = By.xpath("//img[@alt='English']");
    By lEnglishButton = By.xpath("//a[@class='dropdown-item'][1]");
    By lTurkishButton = By.xpath("//a[@class='dropdown-item'][1]");

    By lMobilVehicleTrackingText = By.xpath("//div[@class='tp-mask-wrap']//div[contains(text(),'Mobile Vehicle')]");

    By lHeaderMenuLink = By.xpath("//ul[@class='menu-container']//div");

    By lAnaSayfa = By.xpath("//ul[@class='menu-container']//div[text()='Ana Sayfa']");
    By lSubMenuKurumsal = By.xpath("(//ul[@class='sub-menu-container'])[1]//div");


    WebElement homePageMenu(String text);
}

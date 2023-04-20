package Locaators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.StringReader;

public interface Locator {


    By llogo = By.xpath("//a[@class='standard-logo']");

    By lMobilVasıta = By.xpath("//div[@class='tp-mask-wrap']//div[text()='Mobil Vasıta İzleme Takip Sistemi']");
    String str = "Mobil Vasıta İzleme Takip Sistemi";
    By lEnterButton = By.xpath("//button[@id='dropdownMenuButton']/parent::div");
    By lEnglishLang = By.xpath("(//button[@id='dropdownMenuButton']/parent::div//a)[1]");
    By lTurkishLang = By.xpath("(//button[@id='dropdownMenuButton']/parent::div//a)[2]");

    By lHeaderMenuLink = By.xpath("//ul[@class='menu-container']//div");

    By lAnaSayfa = By.xpath("//ul[@class='menu-container']//div[text()='Ana Sayfa']");
    By lSubMenuKurumsal=By.xpath("(//ul[@class='sub-menu-container'])[1]//div");

    By lMovitaLogo=By.xpath("//a[@class='retina-logo']/img[@alt='Canvas Logo']");


    By lFlagButton=By.id("dropdownMenuButton");
    By lMobilVehicleTrackingText = By.xpath("//div[@class='tp-mask-wrap']//div[contains(text(),'Mobile Vehicle')]");

    By lMobilVasitaIzlemeText = By.xpath("//div[@class='tp-mask-wrap']//div[contains(text(),'Mobil Vasıta İzleme Takip Sistemi')]");

    WebElement homePageMenu(String text);


}
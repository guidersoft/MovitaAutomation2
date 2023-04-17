package Locaators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.MessageFormat;

public interface HomePageLocator {
    String url = "https://movita.com.tr/";

    By llogo = By.xpath("//a[@class='standard-logo']");
    String ALL_A= "//a[contains(., \"{0}\")]";
    String ALL_BUTTON="//button[contains(.,\"{0}\")]";
    String lverify="//div[contains(text(),\"{0}\")]";
    By llanguageDropdown = By.xpath("//button[@id='dropdownMenuButton']");
    String ALLVerifyText="//h3[text()=\"{0}\"] | //h1[text()=\"{0}\"] | //h2[contains(.,\"{0}\")]";
    String drobdownList=".//following-sibling::ul//li";


    String loginInput="//form//input[@id=\"{0}\"]";
    String ALL_Locator="//*[contains(text(),\"{0}\")]";
    By movitaLogo= By.xpath("//img[@alt=\"movita\"]");




     default By xpath(String locator, String value){

        return By.xpath(MessageFormat.format(locator,value));
    }

}

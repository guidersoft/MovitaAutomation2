package Test.Engin.Base;

import Base.BaseMovita;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class EnginBase extends BaseMovita {
    public WebElement headerAsideMenu(String text){
        return driver.findElement(By.xpath("//li/a/span[contains(text(),'"+text+"')]"));
    }
    public WebElement subAsideMenu(String text){
        return driver.findElement(By.xpath("//ul[@id='main-menu-navigation']/li//ul/li/a[contains(.,'"+text+"')]"));
    }
    public WebElement datailedFilters(String text){
        return driver.findElement(By.xpath("//div[@id='accordion_filtre']//form/div/div/div/input[@id='"+text+"']"));
    }

    public WebElement aracBazliDefaultLocator(String locator){
        return driver.findElement(By.xpath("//div[@class='row']/div//div[contains(@class,'col-')]//div"+locator));
    }
    public By detayliAramaSubMenu(String text){
        return By.xpath("//div[@class='card']//div[@class='row']//div[contains(@class,'col')]//label[text()='"+text+"']");
    }

    public By alarmEkleSubMenuDefault(String text){
        return By.xpath("//div[@class='row']/div[@class='col-md-12']//label[contains(.,'"+text+"')]");
    }
    public void getScrollToElement (WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);

    }
}

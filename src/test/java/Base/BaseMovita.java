package Base;

import Locaators.Locator;
import Utilities.Browsers;
import Utilities.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import readers.property.PropertyReader;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

 public class BaseMovita  implements Locator {
    public  WebDriver driver;
    public  WebDriverWait wait;





    public BaseMovita() {
        driver=Driver.getDriver();
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    public void open() {

        driver.get(PropertyReader.propertyReader().get("url"));
    }


    public void visible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void visible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void assertElement(By locator, String str) {

        WebElement element = driver.findElement(locator);
        String text = element.getText();
        System.out.println(text);
        //bekle(1000);
        Assert.assertEquals(text, str);


    }

    public void bekle(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void getScreenshot(String name) {

        String isim = "screenShots/" + name + " " + LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd_MM_yyyy")) + ".png";

        TakesScreenshot takesScreenshot = ((TakesScreenshot) driver);

        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File target = new File(isim);

        try {
            FileUtils.copyFile(source, target);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void hoverOver(WebElement element,String text){
        new Actions(driver)
                .moveToElement(element)
                .click(homePageMenu(text))
                .build()
                .perform();
    }
    public void hoverAll(By locator){
        List<WebElement> list=driver.findElements(locator);

        for (WebElement element : list) {
            new Actions(driver)
                    .moveToElement(element)
                    .build()
                    .perform();
        }
    }


    @Override
    public WebElement homePageMenu(String text) {
        WebElement element = driver.findElement(By.xpath("//ul[@class='menu-container']//div[text()='" + text + "']"));

        return element;

    }

    public void click(By locator){
        WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        click(element);

    }

    public void click(WebElement element){
        wait.until(driver1-> {
            try {
                element.click();
                return true;
            } catch (Exception e1) {
                try {
                    new Actions(driver).moveToElement(element).click().perform();
                    return true;
                } catch (Exception e2) {
                    try {
                        ((JavascriptExecutor) driver).executeScript("arguments[0].click", element);
                        return true;
                    } catch (Exception e3) {
                        return false;
                    }
                }
            }
        });
    }

    public void sendkeys(WebElement element,String text){
        wait.until(driver1-> {
            try {
                element.clear();
                element.sendKeys(text);
                return true;
            } catch (Exception e1) {
                try {
                    element.clear();
                    new Actions(driver).moveToElement(element).sendKeys().perform();
                    return true;
                } catch (Exception e2) {
                    try {
                        element.clear();
                        ((JavascriptExecutor) driver).executeScript("arguments[0].value='"+ text + "'", element);
                        return true;
                    } catch (Exception e3) {
                        return false;
                    }
                }
            }
        });
    }

    public void waitForVisibility(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

     public WebElement menuLocator(String text){
         WebElement element = driver.findElement(By.xpath("//nav[@class='primary-menu']/ul//li/a/div[contains(text(),'" + text + "')]//ancestor::a"));
         return element;
     }






}



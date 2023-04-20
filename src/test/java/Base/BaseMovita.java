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

public class BaseMovita implements Locator {
    protected   WebDriver driver;
    protected   WebDriverWait wait;


    public BaseMovita(){
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }



   /*   public BaseMovita() {
          driver=Driver.getDriver();
          wait=new WebDriverWait(driver,Duration.ofSeconds(10));
      }*/
    /*{
        driver=Driver.getDriver();
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    }*/
    public void open() {
        driver.get(PropertyReader.read().get("url"));
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
    public void click(By locator) {
        WebElement until = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        click(until);
    }
    public void click(WebElement element) {
        // wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        wait.until(d1 -> {
            try {
                element.click();
                return true;
            } catch (Exception e) {
                try {
                    new Actions(d1)
                            .moveToElement(element).click().perform();
                    return true;
                } catch (Exception e2) {
                    try {
                        ((JavascriptExecutor) d1).executeScript("arguments[0].click()", element);
                        return true;
                    } catch (Exception e3) {
                        return false;
                    }
                }
            }
        });
    }

    public void sendeys(By locator, String text) {
        WebElement until = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        sendeys(until, text);
    }

    public void sendeys(WebElement element, String text) {
        // wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        wait.until(d1 -> {
            try {
                element.clear();
                element.sendKeys(text);
                return true;
            } catch (Exception e) {
                try {
                    element.clear();
                    new Actions(d1)
                            .moveToElement(element).sendKeys(text).perform();
                    return true;
                } catch (Exception e2) {
                    try {
                        element.clear();
                        ((JavascriptExecutor) d1).executeScript("arguments[0].value='" + text + "'", element);
                        return true;
                    } catch (Exception e3) {
                        return false;
                    }
                }
            }
        });
    }

    public void waitForVisibility(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
    public WebElement menuLocator(String text){
        WebElement element = driver.findElement(By.xpath("//nav[@class='primary-menu']/ul//li/a/div[contains(text(),'" + text + "')]//ancestor::a"));
        return element;
    }
    By ele=By.xpath("//nav[@class='primary-menu']/ul//li/a/div[contains(text(),'Produckt')]//ancestor::a");
    public void hover(WebElement element){
        new Actions(driver)
                .moveToElement(element).perform();
    }
}

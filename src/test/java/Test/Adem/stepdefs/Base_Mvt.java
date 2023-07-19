package Test.Adem.stepdefs;

import Locaators.Locators;
import Readers.property.PropertyReader;
import Utilities.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static Utilities.Driver.getWait;

public class Base_Mvt implements Locators {

    WebDriver driver = Driver.getDriver();

    WebDriverWait wait = Driver.getWait();

    static SoftAssert softAssert = new SoftAssert();


    public void open() {
        driver.get(PropertyReader.read().get("url"));
    }

    public void visible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public Base_Mvt visible$(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this;
    }

    public void visible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Bu metot girilen locator a ait elementin visible ya da invisible olma durumunu assert eder.
     *
     * @param locator    By
     * @param visibility ENUM
     */
    public void assertVisibility(By locator, Visibility visibility) {

        switch (visibility) {

            case VISIBLE -> getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
            case INVISIBLE -> getWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));

        }

    }

    public WebElement getWebElement(By locator) {
        WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return webElement;
    }

    /**
     * Bu metot elementin text inin beklenen text olduğunu assert eder.
     *
     * @param locator
     * @param str
     */
    public void assertElementText(By locator, String str) {

        WebElement element = driver.findElement(locator);
        String text = element.getText();
        System.out.println(text);
        //bekle(1000);
        Assert.assertEquals(text, str);

    }

    /**
     * Bu metot elementin text inin beklenen text i içerdiğini assert eder.
     *
     * @param locator
     * @param str
     */
    public void assertElementContainsText(By locator, String str) {

        WebElement element = driver.findElement(locator);
        String text = element.getText();
        System.out.println(text);
        //bekle(1000);
        Assert.assertTrue(text.contains(str));

    }

    /**
     * Bu metot Threat.sleep() kullanır.
     *
     * @param milis long
     */
    public void bekleThreat(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Bu metot Actions.pause() kullanır.
     *
     * @param milis long
     */
    public void bekleActions(long milis) {
        new Actions(driver).pause(milis).perform();
    }

    public void getScreenShot(String name) {

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

    public void hover(By locator) {
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        new Actions(driver)
                .moveToElement(webElement)
                .build()
                .perform();

    }

    public void hover(WebElement element) {
        new Actions(driver)
                .moveToElement(element)
                .build()
                .perform();

    }

    /**
     * Bu metot ana sayfada ismi girilen, header menuye ait elementlere hover over yapar
     *
     * @param element ana sayfada header menuye ait
     * @param text    menu elemntelerini ismidir. -> KURUMSAL gibi..
     */
    public void hoverOverAnaSayfa(WebElement element, String text) {
        new Actions(driver)
                .moveToElement(element)
                .click(homePageMenu(text))
                .build()
                .perform();
    }

    public void hoverAll(By locator) {
        List<WebElement> list = driver.findElements(locator);

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
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        click(element);
    }

    public Base_Mvt click$(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        click(element);
        return this;
    }

    /**
     * Bu metot element e sırasıyla Selenium, Actions ve JS ile click etmeyi dener.
     *
     * @param element WebElement
     */
    public void click(WebElement element) {// totalde 100 ms aralıklarla 10 sn tıklamayı dener, bu metot çalışır.
        wait.until(driver1 -> {// Aslında yukarıda wait e verilen driverla aynıdır, diğer driverla karışmasın diye driver1 dedik.
            // Lambda metodu kullandık. Istersek driver1 yerine "e" ya da istenen değişken adı yazılabilir.
            // list.forEach(e-> sout(e.getText)) kullanımı gibi.
            // Lambda da -> { } kullanılırsa bir değer return etmek zorundadır.
            try {
                element.click();// önce elemente selenium ile click etmeyi dener.
                return true;
            } catch (Exception e) {
                try {// selenium tıklayamazsa Actions Class tan actions la click deneyelim.
                    new Actions(driver1).moveToElement(element).click().perform();
                    return true;
                } catch (Exception e2) {
                    try {// actions da tıklayamazsa en son JS ile click deneyelim.
                        ((JavascriptExecutor) driver1).executeScript("arguments[0].click();", element);
                        return true;
                    } catch (Exception e3) {
                        return false;
                    }
                }

            }
        });

    }

    /**
     * Bu metot element e sırasıyla Selenium, Actions ve JS ile click etmeyi dener.
     *
     * @param element WebElement
     */
    public Base_Mvt click$(WebElement element) {// totalde 100 ms aralıklarla 10 sn tıklamayı dener, bu metot çalışır.
        wait.until(driver1 -> {// Aslında yukarıda wait e verilen driverla aynıdır. Lambda metodu kullandık. Istersek
            // driver1 yerine "e" ya da istenen değişken adı yazılabilir. list.forEach(e-> sout(e.getText)) kullanımı gibi.
            // Lambda da -> { } kullanılırsa bir değer return etmek zorundadır.
            try {
                element.click();// önce elemente selenium ile click etmeyi dener.
                return true;
            } catch (Exception e) {
                try {// selenium tıklayamazsa Actions Class tan actions la click deneyelim.
                    new Actions(driver1).moveToElement(element).click().perform();
                    return true;
                } catch (Exception e2) {
                    try {// actions da tıklayamazsa en son JS ile click deneyelim.
                        ((JavascriptExecutor) driver1).executeScript("arguments[0].click();", element);
                        return true;
                    } catch (Exception e3) {
                        return false;
                    }
                }

            }
        });
        return new Base_Mvt();

    }

    public void sendKeys(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        element.clear();
        sendKeys(element, text);
    }

    /**
     * Bu metot element e sırasıyla Selenium, Actions ve JS ile sendKeys etmeyi dener.
     *
     * @param element WebElement
     * @param text    String
     */
    public void sendKeys(WebElement element, String text) {
        wait.until(driver1 -> {// Aslında yukarıda wait e verilen driverla aynıdır. Lambda metodu kullandık.
            try {
                element.clear();
                element.sendKeys(text);
                return true;
            } catch (Exception e) {
                try {// selenium tıklayamazsa action la deneyelim.
                    element.clear();
                    new Actions(driver1).moveToElement(element).sendKeys(text).perform();
                    return true;
                } catch (Exception e2) {
                    try {// action da tıklayamazsa JS ile click deneyelim.
                        element.clear();
                        ((JavascriptExecutor) driver1).executeScript("arguments[0].value=" + text, element);
                        return true;
                    } catch (Exception e3) {
                        return false;
                    }
                }

            }
        });
    }

    public void pause(long millis) {
        new Actions(driver).pause(millis).perform();
    }

    /**
     * Bu metot topMenudeki elementlerin locator ını döndürür.
     * text teki kelimelerin ilk harfleri büyük olmalı.
     *
     * @param text String path
     * @return By
     */
    public WebElement topMenuElement(String text) {
        WebElement element = driver.findElement(By.xpath("//div[text()='" + text + "']"));
        return element;

    }

    /**
     * Bu metot top menu locator larını getirir.
     *
     * @param text String
     * @return By xpath
     */
    public By topMenuXpath(String text) {
        return By.xpath("//div[text()='" + text + "']");
    }

    /**
     * Bu metot top menu altındaki açılır menulerin listesini döndürür.
     *
     * @param text subMenu adi
     * @return List<WebElement>
     * Eğer subMenude element yoksa bile exc. fırlatmaz çünkü liste boş olabilir.
     */
    public List<WebElement> topSubMenuElements(String text) {
        // xpath -> Bağlısının text i "..." div olan "li" altındaki ul altındaki li leri arıyorum.
        List<WebElement> elements = driver.findElements(By.xpath("//li[.//div[text()='" + text + "']]/ul/li"));
        return elements;
    }

    /**
     * Bu metot topmenu altındaki submenulere click eder
     *
     * @param text    menu link adı
     * @param subText submenu link adı
     */
    public void clickTopSubMenuElements(String text, String subText) {
        WebElement element = driver.findElement(By.xpath("//li[.//div[text()='" + text + "']]//div[contains(.,'" + subText + "')]"));
        element.click();

    }

    /**
     * Bu metot elementin text rengini assert eder.
     *
     * @param locator  By
     * @param expColor String Hex Code ( #00adee gibi..)
     */
    public void assertChangeColor(By locator, String expColor) {
        WebElement element = driver.findElement(locator);
        String actColorRGB = element.getCssValue("color");
        String actColorHEX = Color.fromString(actColorRGB).asHex();
        Assert.assertEquals(actColorHEX, expColor);// mevcut renk istenen renkle aynı mı ?
        // #00adee -> hover edince oluşan renk kodu

    }

    /**
     * Bu metot elementin text rengini assert eder.
     *
     * @param locator  By
     * @param expColor String Hex Code ( #00adee gibi..)
     */
    public Base_Mvt assertChangeColor$(By locator, String expColor) {
        WebElement element = driver.findElement(locator);
        String actColorRGB = element.getCssValue("color");
        String actColorHEX = Color.fromString(actColorRGB).asHex();
        Assert.assertEquals(actColorHEX, expColor);// mevcut renk istenen renkle aynı mı ?
        // #00adee -> hover edince oluşan renk kodu
        return this;

    }

    /**
     * Bu metot elementin text rengini assert eder.
     *
     * @param element  WebElement
     * @param expColor String Hex Code ( #00adee gibi..)
     */
    public Base_Mvt assertChangeColor$(WebElement element, String expColor) {
        String actColorRGB = element.getCssValue("color");
        String actColorHEX = Color.fromString(actColorRGB).asHex();
        Assert.assertEquals(actColorHEX, expColor);// mevcut renk istenen renkle aynı mı ?
        // #00adee -> hover edince oluşan renk kodu
        return this;

    }

    /**
     * Bu metot elementin arka plan rengini assert eder.
     *
     * @param locator               By
     * @param expBackgroundColorHEX String Hex Code ( #00adee gibi..)
     */
    public void assertChangeBackGroundColor(By locator, String expBackgroundColorHEX) {
        WebElement element = driver.findElement(locator);
        String actColorRGBA = element.getCssValue("background-color");
        String actBackgroundColorHEX = Color.fromString(actColorRGBA).asHex();
        Assert.assertEquals(actBackgroundColorHEX, expBackgroundColorHEX);// mevcut renk istenen renkle aynı mı ?
        // #00adee -> Elementin arka plan hex renk kodu

    }

    /**
     * Bu metot elementin arka plan rengini assert eder.
     *
     * @param element               Webelement
     * @param expBackgroundColorHEX String Hex Code ( #00adee gibi..)
     */
    public Base_Mvt assertChangeBackGroundColor$(WebElement element, String expBackgroundColorHEX) {
        String actColorRGBA = element.getCssValue("background-color");
        String actBackgroundColorHEX = Color.fromString(actColorRGBA).asHex();
        Assert.assertEquals(actBackgroundColorHEX, expBackgroundColorHEX);// mevcut renk istenen renkle aynı mı ?
        // #00adee -> Elementin arka plan hex renk kodu
        return this;

    }

    /**
     * Bu metot girilen menu ye ait submenu locator ını getirir.
     *
     * @param textMenu    String
     * @param textSubMenu String
     * @return By
     */
    public By topSubMenuXpath(String textMenu, String textSubMenu) {
        return By.xpath("//li[.//div[text()='" + textMenu + "']]//div[contains(.,'" + textSubMenu + "')]");
    }

    /**
     * Locator u girilen elementin mouse ile üstüne gelince Cursor un pointer simgesine dönüştüğünü assert eder.
     *
     * @param locator By
     */
    public void assertCursorIsPointer(By locator) {
        hover(locator);
        boolean b = getWebElement(locator).getCssValue("cursor").equals("pointer");
        softAssert.assertTrue(b);
    }

    /**
     * Dashboard Ana Menu de text i girilen sekmenin locatorını döndürür.
     * @param text String
     * @return By
     */
    public By dashboardAnaMenuXpathWithText(String text) {
        return By.xpath(String.format("//ul[@id='main-menu-navigation']/li/a[contains(.,'%s')]", text));
    }

    /**
     * Dashboard Ana Menu text ve altındaki Submenu text i girilen sekmenin locatorını döndürür.
     * @param anamenutext String
     * @param submenutext String
     * @return By with xpath
     */
    public By dashboardSubMenuXpathWithText(String anamenutext, String submenutext) {
        return By.xpath("//a[contains(.,'" + anamenutext + "')]/following-sibling::ul//a[contains(.,'" + submenutext + "')]");
        // following-sibling:: -> current elementten sonraki kardeş childlardan seçer
        // preceding-sibling:: -> current elementten önceki kardeş childlardan seçer
    }



}

package Test.yusuf.stepdefs;

import Test.yusuf.BaseMovitaYusuf;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

import static Test.yusuf.Locators.*;

public class Test extends BaseMovitaYusuf {

    @org.testng.annotations.Test
    public  void  test(){
        driver.get("https://movita.com.tr//");
        click(By.xpath(String.format(TOP_MENU, "GİRİŞ Yap")));
        visible(lLoginFormUsername);
        sendKeys(lLoginFormUsername, "demomovita");
        sendKeys(lLoginFormPassword, "1192movita");
        click(lLoginFormSubmitButton);
        visible(xpath(MAIN_MENU, "Anasayfa"));

        click(xpath(MAIN_MENU, "Raporlar"));
        hoverOverByAction(xpath(MAIN_MENU, "Araç Bazlı Rapor"));
        click(xpath(MAIN_MENU, "Araç Bazlı Rapor"));


        click(By.xpath("//input[@id= 'tarih1']"));
        Select select = new Select(driver.findElement(By.xpath("//select[@class='monthselect']")));
        select.selectByValue("9");
        Select select1 = new Select(driver.findElement(By.xpath("//select[@class='yearselect']")));
        select1.selectByValue("2022");
        click(driver.findElement(By.xpath("//td[@class='available' and text()='26']")));


        click(By.xpath("//input[@id= 'tarih2']"));
        Select select2 = new Select(driver.findElement(By.xpath("//select[@class='monthselect']")));
        select2.selectByValue("9");
        Select select3 = new Select(driver.findElement(By.xpath("//select[@class='yearselect']")));
        select3.selectByValue("2022");
        click(driver.findElement(By.xpath("//td[@class='available' and text()='26']")));

        bekle(3000);
        driver.quit();
    }
}

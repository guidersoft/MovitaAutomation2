package Test;

import Base.BaseMovita;
import Locaators.Locator;
import Utilities.Browsers;
import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class Test1 extends BaseMovita {


    @Test(priority = 0)
    public void openMovita(){
        open();
    }

    @Test(priority = 1,dependsOnMethods = "openMovita")
    public void logo(){
        click(llogo);
        bekle(3000);
        visible(lMobilVasıta);

        //assertElement(lMobilVasıta,str);

        getScreenshot("MobilVasıta");
    }
    @Test(priority = 3)
    public void enterButton(){
        click(lEnterButton);
        click(lTurkishLang);
        bekle(500);
        getScreenshot("login");
        bekle(500);

    }
    @Test(priority = 2)
    public void enterButton2(){
        click(lEnterButton);
        click(lEnglishLang);
        bekle(500);
        getScreenshot("Giris");


    }
    @Test(priority = 4,dependsOnMethods = "openMovita")
    public void homePage(){
        hoverOver(homePageMenu("Ana Sayfa"),"Ana Sayfa");
        visible(lMobilVasıta);

    }
    @Test(priority = 5,dependsOnMethods = "openMovita")
    public void kurumsal(){
        hoverOver(homePageMenu("Kurumsal"),"Kurumsal");
        hoverAll(lSubMenuKurumsal);

    }


}

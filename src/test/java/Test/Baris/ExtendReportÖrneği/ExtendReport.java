package Test.Baris.ExtendReportÖrneği;

import ReuseableClass.ExtendBaseClass;
import Utilities.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static ReuseableClass.BaseClass.getScreenshot;
import static ReuseableClass.BaseClass.switchToWindow;

public class ExtendReport extends ExtendBaseClass {


    @Test
    public void test1(){
        extentTest= extentReports.createTest("window handle","title ile ikinci sayfaya gecis yapildigi test edildi");
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        extentTest.info("Herokuapp sayfasina gidildi");
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        extentTest.info("Yeni window linkine tiklandi");
        switchToWindow("New Window");
        extentTest.info("reusable method kullanarak acilan 2. sayfaya geçildi");
        String expectedTitle="New Window";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        extentTest.pass("Title in beklenen deger ile ayni oldugu test edildi");

        try {
            getScreenshot("WindowSwitch");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Driver.quitDriver();

    }
}

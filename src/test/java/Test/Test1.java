package Test;

import Test.Adem.stepdefs.Base_Mvt;
import org.testng.annotations.*;


public class Test1 extends Base_Mvt {


    @Test(priority = 0)
    public void openMovita() {
        open();
    }

    @Test(priority = 1, dependsOnMethods = "openMovita")
    public void logo() {
        click(llogo);
        bekleThreat(3000);
        visible(lMobilVasitaIzlemeTakipText);

        //assertElement(lMobilVasıta,str);

        getScreenShot("MobilVasıta");
    }


    @Test(priority = 3)
    public void enterButton() {
        click(lEnterButton);
        click(lTurkishLang);
        bekleThreat(500);
        getScreenShot("login");
        bekleThreat(500);

    }

    @Test(priority = 2)
    public void enterButton2() {
        click(lEnterButton);
        click(lEnglishLang);
        bekleThreat(500);
        getScreenShot("Giris");


    }

    @Test(priority = 4, dependsOnMethods = "openMovita")
    public void homePage() {

        visible(lMobilVasitaIzlemeTakipText);

    }

    @Test(priority = 5, dependsOnMethods = "openMovita")
    public void kurumsal() {

        hoverAll(lSubMenuKurumsal);

    }


}

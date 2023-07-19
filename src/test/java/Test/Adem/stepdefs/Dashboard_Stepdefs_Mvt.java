package Test.Adem.stepdefs;

public class Dashboard_Stepdefs_Mvt extends Base_Mvt{

    @io.cucumber.java.en.When("Kullanici {string} sekmesine tıklar")
    public void kullaniciSekmesineTıklar(String text) {
        click(dashboardAnaMenuXpathWithText(text));
    }

    @io.cucumber.java.en.Then("{string} ve {string} alt sekmeleri acilmalidir")
    public void veAltSekmeleriAcilmalidir(String text1, String text2) {
        visible$(dashboardSubMenuXpathWithText("Güzergah İşlemleri",text1))
                .visible$(dashboardSubMenuXpathWithText("Güzergah İşlemleri",text2));
    }

    @io.cucumber.java.en.When("{string} alt sekmesine tiklar")
    public void altSekmesineTiklar(String text) {
        click(dashboardSubMenuXpathWithText("Güzergah İşlemleri",text));
        bekleActions(1000);
    }

    @io.cucumber.java.en.Then("{string}, {string}, {string} ve {string} filtre kriterlerini gormelidir")
    public void veFiltreKriterleriniGormelidir(String arg0, String arg1, String arg2, String arg3) {
    }

    @io.cucumber.java.en.When("{string} butonuna tiklar")
    public void butonunaTiklar(String arg0) {
    }

    @io.cucumber.java.en.Then("Filtre kriterlerine uyan rotalari ekranda gormelidir")
    public void filtreKriterlerineUyanRotalariEkrandaGormelidir() {
    }

    @io.cucumber.java.en.Then("Onceden goruntulenen rotalari artik ekranda gormemelidir")
    public void oncedenGoruntulenenRotalariArtikEkrandaGormemelidir() {
    }

    @io.cucumber.java.en.Then("{string} ve {string} filtre kriterlerini gormelidir")
    public void veFiltreKriterleriniGormelidir(String arg0, String arg1) {
    }
}

package Test.Baris.Locators;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;

import java.text.MessageFormat;

public interface AccountPageLocators extends BaseLocator {

    By leftMenuIkon=By.xpath("//i[@class='ft-menu']");
    By startDate= By.id("tarih1");
    By fnishDate= By.id("tarih2");
    By selectCarDropdown= By.id("select2-aracSelect-container");
    By inputDate=By.xpath("//input[contains(@value,\"-\")]");
    By selectyearDate_1 =By.xpath("(//select[@class=\"yearselect\"])[1]");
    By selectyearDate_2 =By.xpath("(//select[@class=\"yearselect\"])[3]");
    By selectmonthDate_1 =By.xpath("(//select[@class=\"monthselect\"])[1]");
    By selectmonthDate_2 =By.xpath("(//select[@class=\"monthselect\"])[3]");
    String dayselectDate_1 ="((//div[@class=\"calendar left single\"])[1]//tbody//td[@class=\"available\" or @class=\"weekend available\" or @class=\"active start-date active end-date available\"])[{0}]";
    String dayselectDate_2="((//div[@class=\"calendar left single\"])[2]//tbody//td[@class=\"available\" or @class=\"weekend available\" or @class=\"active start-date active end-date available\" or @class=\"today available\"])[{0}]";

    By araclistesi =By.xpath("//table[@id='DataTables_Table_0']//tbody//tr");
    String aracListesi_Tarih=".//td[contains(.,\"{0}\")][1]";
    String aracListesi_IseBaslama=".//td[11][contains(.,\"{0}\")]";
    String aracListesi_IseBitis=".//td[12][contains(.,\"{0}\")]";
    String raporlarLink="(//div[contains(.,\"{0}\")])[11]";

    String downloadReportIcon="//a[@title=\"{0}\"]";

}

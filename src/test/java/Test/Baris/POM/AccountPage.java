package Test.Baris.POM;

import ReuseableClass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static ReuseableClass._Conditions.visibilty;

public class AccountPage extends BaseClass implements INavigatePage {

    private By leftMenuIkon=By.xpath("//i[@class='ft-menu']");
    private By startDate= By.id("tarih1");
    private By fnishDate= By.id("tarih2");
    private By selectCarDropdown= By.id("select2-aracSelect-container");
    private By inputDate=By.xpath("//input[contains(@value,\"-\")]");
    private By selectyearDate_1 =By.xpath("(//select[@class=\"yearselect\"])[1]");
    private By selectyearDate_2 =By.xpath("(//select[@class=\"yearselect\"])[3]");
    private By selectmonthDate_1 =By.xpath("(//select[@class=\"monthselect\"])[1]");
    private By selectmonthDate_2 =By.xpath("(//select[@class=\"monthselect\"])[3]");
    private String dayselectDate_1 ="((//div[@class=\"calendar left single\"])[1]//tbody//td[@class=\"available\" or @class=\"weekend available\" or @class=\"active start-date active end-date available\"])[{0}]";
    private String dayselectDate_2="((//div[@class=\"calendar left single\"])[2]//tbody//td[@class=\"available\" or @class=\"weekend available\" or @class=\"active start-date active end-date available\" or @class=\"today available\"])[{0}]";

   private By araclistesi =By.xpath("//table[@id='DataTables_Table_0']//tbody//tr");
   private String aracListesi_Tarih=".//td[contains(.,\"{0}\")][1]";
   private String aracListesi_IseBaslama=".//td[11][contains(.,\"{0}\")]";
   private String aracListesi_IseBitis=".//td[12][contains(.,\"{0}\")]";
   private String raporlarLink="(//div[contains(.,\"{0}\")])[11]";

   private String downloadReportIcon="//a[@title=\"{0}\"]";




    public AccountPage selectStartDate(String date) {
        String[] selectDate = date.split("-");
        selectDate[1] = removeLeadingZeros(selectDate[1]);
        selectDate[2] = removeLeadingZeros(selectDate[2]);
        $(startDate).click();
        new Select($(selectyearDate_1).waitFor(visibilty, null).getCurrentElement()).selectByValue(selectDate[0]);
        new Select($(selectmonthDate_1).waitFor(visibilty, null).getCurrentElement()).selectByValue(String.valueOf((Integer.parseInt(selectDate[1]) - 1)));
        $(xpath(dayselectDate_1, selectDate[2])).waitFor(visibilty, null).click();
        return this;
    }

    public AccountPage selectFinishDate(String date) {
        String[] selectDate = date.split("-");
        selectDate[1] = removeLeadingZeros(selectDate[1]);
        selectDate[2] = removeLeadingZeros(selectDate[2]);
        $(fnishDate).click();
        new Select($(selectyearDate_2).waitFor(visibilty, null).getCurrentElement()).selectByValue(selectDate[0]);
        new Select($(selectmonthDate_2).waitFor(visibilty, null).getCurrentElement()).selectByValue(String.valueOf((Integer.parseInt(selectDate[1]) - 1)));
        $(xpath(dayselectDate_2, selectDate[2])).waitFor(visibilty, null).click();
        return  this;
    }

    private String removeLeadingZeros(String str) {
        if (str.startsWith("0")) {
            return str.replaceFirst("^0+(?!$)", "");
        }
        return str;
    }


}

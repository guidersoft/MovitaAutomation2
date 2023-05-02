package Locaators;

import org.openqa.selenium.By;

public interface AccountPageLocators {

    By startDate= By.id("tarih1");
    By fnishDate= By.id("tarih2");
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




}

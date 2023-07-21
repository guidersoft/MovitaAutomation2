package Test.yusuf;

import org.openqa.selenium.By;

public class Locators {

    public static final String TOP_MENU = "//*[@id='header-wrap']//a[contains(.,'%s')]";
    public static final By lLanguageOptionButton = By.xpath("//div[@class='dropdown dropdown-langs']//button");
    public static final By lTextOfMobilVasitaIzlemeTakipSistemi = By.xpath("//div[@class='tp-mask-wrap']//div[contains(text(),'Mobil')]");
    public static final By lLoginFormUsername = By.id("username");
    public static final By lLoginFormPassword = By.id("password");
    public static final By lLoginFormSubmitButton = By.xpath("//form//button[@type='submit']");
    public static final By lLoginFormUsernameWarningMessage = By.xpath("//div[contains(text(),'Lütfen kullanıcı adı girin!')]");
    public static final By lLoginFormPasswordWarningMessage = By.xpath("//div[contains(text(),'Lütfen şifre girin!')]");
    public static final By lLoginFormInvalidUsernamePasswordWarningMessage = By.xpath("//div[@class='toast-message']");
    public static final By lDemoFileDropdownMenuLogout = By.xpath("//a[contains(.,' Çıkış Yap')]");
    public static final By lDemoFileDropdownMenu = By.xpath("//a[contains(.,'Demo Filo (129)')]");
    public static final By lLoginFormAnaSayfayaDon = By.xpath("//a[contains(.,'Ana sayfaya dön')]");
    public static final By lLoginFormBackToHomepage = By.xpath("//a[contains(.,'back to home page')]");
    public static final By lFooterMenuContaktInfo = By.xpath("//footer//div[@class = 'col-md-2']");


    public static final String MAIN_MENU = "//*[@id='main-menu-navigation']//a[contains(.,'%s')]";
    public static final String RAPORLAR_SUB_MENUS = "//*[@class='nav-item has-sub open' and contains(.,'Raporlar')]//li";
    public static final String FOOTER_MENU = "//footer//*[text()='%s']";
    public static final String TITLE = "//h1[text()='%s']";
    public static final String ALARM_ISLEMLERI = "//*[@id='basic-form-layouts']//*[contains(text(),'%s')]";
    public static final String lAlarmIslemleriAlarmTipi = "//div[@id='user-profile']//select[@id='kural_tipi']";
    public static final String lAlarmIslemleriSmsBildirimi = "//div[@id='user-profile']//select[@id='kural_sms']";
    public static final String lAlarmIslemleriAktifGunler = "//div[@id='user-profile']//select[@id='kural_gun']";
    public static final String lAlarmIslemleriKaydetButton = "//*[@id='basic-form-layouts']//button[contains(.,'Kaydet')]";
    public static final String lAlarmIslemleriAlarmListesi = "//div[@class='table-responsive']//tbody/tr";
    public static final String lAlarmIslemleriAlarmSil = "//div[@class='table-responsive']//tbody/tr/td//i[@class='icon-trash']";
    public static final String lAlarmIslemleriAlarmEdit = "//div[@class='table-responsive']//tbody/tr/td//i[@class='icon-pencil']";

}

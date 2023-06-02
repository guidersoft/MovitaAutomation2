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
    public static final String SUB_MENUS = "//*[@class='nav-item has-sub open' and contains(.,'Raporlar')]//li";
    public static final String FOOTER_MENU = "//footer//*[text()='%s']";
    public static final String TITLE = "//h1[text()='%s']";

}

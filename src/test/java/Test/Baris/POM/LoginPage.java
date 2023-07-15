package Test.Baris.POM;

import ReuseableClass.BaseClass;

import static ReuseableClass._Conditions.visibilty;

public class LoginPage extends BaseClass implements INavigatePage {

    private String loginInput="//form//input[@id=\"{0}\"]";
    String ALL_BUTTON="//button[contains(.,\"{0}\")]";
    String ALL_Locator="//*[contains(text(),\"{0}\")]";
    String ALL_A= "//a[contains(., \"{0}\")]";



    public void loginAndVerifyMessage(String username, String password, String status, String message) {

        if (!status.equalsIgnoreCase("true")) {
            if (!username.isEmpty()) {
                $(xpath(loginInput, "username")).sendKeys(username);
            }
            if (!password.isEmpty()) {
                $(xpath(loginInput, "password")).sendKeys(password);
            }
            $(xpath(ALL_BUTTON, "Giriş Yap")).click();

            if (!message.isEmpty()) {
                String[] messageParts = message.split(" and ");
                for (String part : messageParts) {
                    $(xpath(ALL_Locator, part.trim())).waitFor(visibilty, null);
                }
            }
        } else {
            $(xpath(loginInput, "username")).sendKeys(username);
            $(xpath(loginInput, "password")).sendKeys(password);
            $(xpath(ALL_BUTTON, "Giriş Yap")).click();
            $(xpath(ALL_Locator, message)).waitFor(visibilty, null);
            $(xpath(ALL_Locator, message)).click();
            $(xpath(ALL_A, "")).click();
        }

    }
    public LoginPage sendUsername(String username){
        $(xpath(loginInput, "username")).sendKeys(username);
        return this;
    }
    public LoginPage sendPassword(String password){
        $(xpath(loginInput, "password")).sendKeys(password);
        return this;
    }


    public  LoginPage clickToGirisYap(){
        $(xpath(ALL_BUTTON, "Giriş Yap")).click();
        return this;
    }

    public  LoginPage verifySuccessfulLogin(){
        $(xpath(ALL_Locator, "Demo Filo")).waitFor(visibilty, null);
        return  this;
    }

    /**
     * Başarılı login Olur;
     */
    public LoginPage successfulyLogin() {
        sendUsername("demomovita")
        .sendPassword("1192movita")
        .clickToGirisYap()
        .verifySuccessfulLogin();
        return this;
    }

    public static void main(String[] args) {
        new LoginPage()
                .successfulyLogin()
                .navigateTo(AccountPage.class)
                .selectStartDate("")
                .selectFinishDate("");
    }
}

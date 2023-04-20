package Test.Engin.stepdefs;

import Base.BaseMovita;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LoginPageStepDefs extends BaseMovita {
    @When("user clicks giris yap menu")
    public void userClicksGirisYapMenu() {
        click(lGirisYapButton);

    }


    @And("user type the text as a fallowing table")
    public void userTypeTheTextAsAFallowingTable(DataTable table) {
        List<Map<String, String>> maps = table.asMaps();
        for (Map<String, String> map : maps) {
            String userName = map.get("username")==null ? "" : map.get("username");
            String pass     = map.get("password")==null ? "" : map.get("password");
            sendeys(lUserName,userName);
            sendeys(lPassword, pass);
            click(lLoginSubmitButton);

            if (Objects.equals(map.get("Status"), "true")) {
                waitForVisibility(lLoginSuccess);
                click(lDemoFiloButton);
                click(lLogOut);

            } else {
                if (userName.isEmpty()) {
                    waitForVisibility(lHataMessageKullanici);
                }

                if (pass.isEmpty()) {
                    waitForVisibility(lHataMessageSifre);
                }

                if (!userName.equalsIgnoreCase("demomovita") |
                        !pass.equalsIgnoreCase("1192movita")

                ) {
                    waitForVisibility(lHataMessageoneorTwoFalse);
                }


            }
        }

    }
}

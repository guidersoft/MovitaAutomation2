package Base;

import Utilities.Driver;
import io.cucumber.java.After;

public class Hooks {

    @After(order = 0)
    public void after(){
        Driver.quitDriver();
    }

}

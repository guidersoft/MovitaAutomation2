package Test.Baris.Locators;

import org.openqa.selenium.By;

import java.text.MessageFormat;

public interface BaseLocator {

    default By xpath(String locator, String value){
        return By.xpath(MessageFormat.format(locator,value));
    }
}

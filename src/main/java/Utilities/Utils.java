package Utilities;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class Utils {

    public static String getCurrentDateTime() {

        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd_MM_yyyy"));
    }

    public static void getElementScreenshotsAs(WebElement currentElement) {
        File screenshotAs = currentElement.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotAs, new File("screenShots/"+ getCurrentDateTime() +"-screenshot.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void threadSleep(int milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void readSystem(String[] args) {
        // Sistem özelliklerini al
        Properties props = System.getProperties();

        // Tüm anahtar-değer çiftlerini yazdır
        for (String key : props.stringPropertyNames()) {
            String value = props.getProperty(key);
            System.out.println(key + ": " + value);
        }
    }
}

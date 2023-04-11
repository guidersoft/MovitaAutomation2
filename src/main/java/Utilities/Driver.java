package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Driver {

    //private static WebDriver driver;
    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
    private static ThreadLocal<WebDriverWait> waits = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return getDriver(Browsers.CHROME);
    }

    public static WebDriver getDriver(Browsers browsers) {
        if (drivers.get() == null) {
            switch (browsers) {
                case EDGE:
                    WebDriverManager.edgedriver().setup();
                    drivers.set(new EdgeDriver());
                    break;
                case SAFARI:
                    WebDriverManager.safaridriver().setup();
                    drivers.set(new SafariDriver());
                    break;
                case FİREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    drivers.set(new FirefoxDriver());
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    //options.addArguments("--headles");
                    drivers.set(new ChromeDriver(options));
                    break;

            }

        }
        waits.set(new WebDriverWait(drivers.get(), Duration.ofSeconds(10)));// waits i set ettik.
        return drivers.get();

    }

    public static WebDriverWait getWait() {
        return waits.get();// listenin tek elemanı vardır ve onu getirir. index yazmaya gerek yoktur.
    }

    public static void quitDriver() {
        if (drivers.get() != null) {
            drivers.get().quit();
            drivers.set(null);

        }
    }
}

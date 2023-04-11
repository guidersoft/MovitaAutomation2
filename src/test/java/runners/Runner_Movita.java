package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/java/Test/Adem/features/HomePage_Mvt.feature"},// feature dosyasının source path ini yazıyoruz.
        glue = {"Test.Adem.stepdefs"},// sadece çalışması istenen stepdefs in olduğu package ın path ini yazıyoruz.
       // tags = "@login2", // Sadece @login2 taglı feature dosyasını çalıştırır, ya da ayrı bir runner class oluşturabiliriz.
        tags = "@aktifTag", // istenen feature ya da senaryoya bu tag değeri verilirse Runner dan da sadece onu çalıştırır.
        plugin = { "pretty",
        "json:test-output/cucumber-reports/cucumber.json", // cucumber.json reports için
        "html:test-output/cucumber-reports/cucumberreport.html", // cucumber.html reports için
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"} // gerekli ayarlamalar
        // runner dan senaryoyu çalıştırırsak plugin deki reportlar oluşturulur.
)

public class Runner_Movita extends AbstractTestNGCucumberTests {
// TestNg class ıdır, bu class ta yazılan TestNG annotation lu metotlar
// Cucumber metotlarından önce çalışır.

}

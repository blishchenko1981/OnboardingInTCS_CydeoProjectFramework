package com.cydeo.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private Driver() {
    }

    ;
    private static WebDriver object;

    public static WebDriver getDriver() {

        String browserName = ConfigReader.read("browser");
        if (object == null) {

            switch (browserName) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    object = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    object = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    object = new EdgeDriver();
                    break;
            }

            return object;

        } else {
            return object;
        }
    }

    public static void closeBrowser() {

        if (object != null) {
            object.quit();
            object = null;
        }
    }


}

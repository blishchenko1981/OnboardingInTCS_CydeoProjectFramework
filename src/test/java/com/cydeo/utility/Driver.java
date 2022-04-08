package com.cydeo.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class Driver {

    private Driver() {
    }

    ;
    private static WebDriver object;

    public static WebDriver getDriver() {

        String browserName = ConfigReader.read("browser");
        if (object == null) {

            switch (browserName) {

//                case "remote-chrome":
//                    try {
//                        // assign your grid server address
//                        String gridAddress = "54.90.169.134";
//                        URL url = new URL("http://"+ gridAddress + ":4444/wd/hub");
//                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//                        desiredCapabilities.setBrowserName("chrome");
//                        driverPool.set(new RemoteWebDriver(url, desiredCapabilities));
//                        //driverPool.set(new RemoteWebDriver(new URL("http://0.0.0.0:4444/wd/hub"),desiredCapabilities));
//
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    break;


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

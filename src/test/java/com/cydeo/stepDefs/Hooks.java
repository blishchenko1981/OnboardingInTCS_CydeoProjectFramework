package com.cydeo.stepDefs;

import com.cydeo.utility.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before("@ui")
    public void setupDriver(){
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofMillis(2000));

    }

    @After("@ui")
    public void tearDown() {Driver.closeBrowser();}


}

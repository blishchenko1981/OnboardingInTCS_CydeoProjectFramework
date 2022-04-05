package com.cydeo.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = "src/test/resources",
            glue = "com/cydeo/stepDefs",
            plugin = {
                    "json:target/cucumber.json",
                    "html:target/cucumber.html",
                    "rerun:target/rerun.txt",

            },
            dryRun = false,
            tags = "@ui"


    )

    public class TestRunner{}


package com.cydeo.stepDefs;

import com.cydeo.pages.HomePage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class HomePageStepDefs {

    HomePage homePage = new HomePage();


    @Then("User should be able to see all modules in right order")
    public void user_should_be_able_to_see_all_modules_in_right_order(List<String> list){
        System.out.println("list = " + list);
        System.out.println("homePage.getMainModulesNames() = " + homePage.getMainModulesNames());

        Assert.assertTrue(homePage.checkNamesOfModules(list));


    }





}

package com.cydeo.pages;

import com.cydeo.utility.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy(xpath = "//li[@tabindex = '-1']/a")
    private List<WebElement> mainModules;

    public boolean checkNamesOfModules(List<String> expectedList){
        List<String> moduleNames = new ArrayList<>();
        for (WebElement module : mainModules) {
        moduleNames.add(module.getAttribute("aria-label"));
        }
        return moduleNames.equals(expectedList);
    }

    public ArrayList<String> getMainModulesNames() {
        ArrayList<String> namesList = new ArrayList<>() ;

        for (WebElement module : mainModules) {
            namesList.add(module.getAttribute("aria-label"));
        }
        return namesList;
    }


    public void checkIfDriverOnTheHomePage() {
        String expectedHomePageUrl = "Dashboard - Trycloud QA";
        Assert.assertEquals(expectedHomePageUrl, Driver.getDriver().getTitle());
    }


}

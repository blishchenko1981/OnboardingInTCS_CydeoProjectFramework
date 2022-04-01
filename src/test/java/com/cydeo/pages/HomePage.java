package com.cydeo.pages;

import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//li[@data-id = 'files']")
    private WebElement module_Files;

    @FindBy(xpath = "//li[@data-id ='photos']")
    private WebElement module_Photos;
    @FindBy(xpath = "//li[@data-id = 'activity']")
    private WebElement module_Activity;
    @FindBy(xpath = "//li[@data-id = 'talk']")
    private WebElement module_Talk;
    @FindBy(xpath = "//li[@data-id = 'mail']")
    private WebElement module_Mail;
    @FindBy(xpath = "//li[@data-id = 'contacts']")
    private WebElement module_Contacts;
    @FindBy(xpath = "//li[@data-id = 'circles']")
    private WebElement module_Circles;
    @FindBy(xpath = "//li[@data-id = 'calendar']")
    private WebElement module_Calendar;
    @FindBy(xpath = "//li[@data-id = 'deck']")
    private WebElement module_Deck;



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


    public void clickOnModule(String nameOfModule) {

        BrowserUtil.waitAlittle(2);
        switch (nameOfModule){

            case "Files":
                module_Files.click();
                break;
            case "Photos":
                module_Photos.click();
                break;
            case "Activity":
                module_Activity.click();
                break;
            case "Talk":
                module_Talk.click();
                break;
            case "Mail":
                module_Mail.click();
                break;
            case "Contacts":
                module_Contacts.click();
                break;
            case "Circles":
                module_Circles.click();
                break;
            case "Calendar":
                module_Calendar.click();
                break;
            case "Deck":
                module_Deck.click();
                break;

        }

    }
}

package com.cydeo.pages;

import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.Driver;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.text.JTextComponent;
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
    @FindBy(xpath = "//li[@data-id = 'spreed']")
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


    @FindBy(xpath = "//input[@type = 'text']")
    private WebElement userSearchBox;

    @FindBy(xpath = "//ul[@class = 'app-navigation__list']//li[2]")
    private WebElement secondUserOnTalk;

    @FindBy(xpath = "//div[starts-with (@placeholder,'Write message')]")
    private WebElement textBox;

    @FindBy(xpath = "//div[@class = 'message']")
    private List<WebElement> listOfWrittenMessages;

    @FindBy(xpath = "//button[@aria-label='Send message']")
    private WebElement submitMessage;

    @FindBy(xpath = "//span[@aria-label='Magnify icon']")
    private WebElement magnifyIcon;

    @FindBy(xpath = "//div[@id='recommendations']//li")
    private List<WebElement> recommendedFiles;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchInput;

    @FindBy(xpath = "//h3[@class='unified-search__result-line-one']")
    private WebElement searchResult;

    public boolean checkNamesOfModules(List<String> expectedList) {
        List<String> moduleNames = new ArrayList<>();
        for (WebElement module : mainModules) {
            moduleNames.add(module.getAttribute("aria-label"));
        }
        return moduleNames.equals(expectedList);
    }

    public ArrayList<String> getMainModulesNames() {
        ArrayList<String> namesList = new ArrayList<>();

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
        switch (nameOfModule) {

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

    public void clickOnButton(WebElement button) {
        button.click();
    }

    public boolean isTitle_Talk() {
        System.out.println("getTitle() = " + Driver.getDriver().getTitle());
        return Driver.getDriver().getTitle().startsWith("Talk");
    }
    // -------------   userSearch Box in Taks --------------------------

    public void clickOnSecondUser() {
        secondUserOnTalk.click();
    }


    public void writeMessage(String text) {
        textBox.sendKeys(text);
        BrowserUtil.waitAlittle(3);
        submitMessage.click();
    }

    public boolean checkIfMessageDisplayed(String messageText) {
        BrowserUtil.waitAlittle(2);
        boolean isMessageDisplayed = false;
        for (WebElement message : listOfWrittenMessages) {
            System.out.println("message.getText() = " + message.getText());
            if (message.getText().contains(messageText)) {
                isMessageDisplayed = true;
                break;
            }
        }
        return isMessageDisplayed;
    }


    public void clickOnMagnifyIcon() {
        clickOnButton(magnifyIcon);
    }

    public void searchExistingFile() {

        System.out.println("recommendedFiles.get(1).getText() = " + recommendedFiles.get(1).getText());

        searchInput.sendKeys(recommendedFiles.get(1).getText());
        BrowserUtil.waitAlittle(2);

    }

    public boolean fileAppearsOnSearchResults() {
        boolean isAppears = false;
        BrowserUtil.waitAlittle(2);
        if(searchResult.getText().equals(recommendedFiles.get(1).getText())){
            isAppears = true;

        }
        return isAppears;
    }
}

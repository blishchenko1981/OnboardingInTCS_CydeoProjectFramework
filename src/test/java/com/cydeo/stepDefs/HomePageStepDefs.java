package com.cydeo.stepDefs;

import com.cydeo.pages.HomePage;
import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePageStepDefs {

    HomePage homePage = new HomePage();


    @Then("User should be able to see all modules in right order")
    public void user_should_be_able_to_see_all_modules_in_right_order(List<String> list){
        System.out.println("list = " + list);
        System.out.println("homePage.getMainModulesNames() = " + homePage.getMainModulesNames());

        Assert.assertTrue(homePage.checkNamesOfModules(list));


    }


    @When("User click on {string}")
    public void userClickOn(String nameOfModule) {
        homePage.clickOnModule( nameOfModule);
        BrowserUtil.waitAlittle(3);
        System.out.println("nameOfModule = " + nameOfModule);
    }

    @Then("User should be directed on the {string} page")
    public void userShouldBeDirectedOnThePage(String expectedTitle) {

        String actualtitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualtitle.contains(expectedTitle));
    }

    @Then("Tab name should start with Talk")
    public void tabNameShouldStartWithTalk() {

        Assert.assertTrue(homePage.isTitle_Talk());
    }

    @And("Search  a user from search box on the left")
    public void searchAUserFromSearchBoxOnTheLeft() {
        homePage.clickOnSecondUser();
    }

    @And("Write a message {string} and submit it")
    public void writeAMessageAndSubmitIt(String text) {
        homePage.writeMessage(text);
    }

    @Then("Message {string} should be displayed on the conversation log")
    public void messageShouldBeDisplayedOnTheConversationLog(String text) {
        System.out.println("Write assertions here");
        Assert.assertTrue(homePage.checkIfMessageDisplayed(text));
    }

    @When("User click on magnifier icon")
    public void userClickOnMagnifierIcon() {

        homePage.clickOnMagnifyIcon();

    }

    @And("User begin to search for one of the files")
    public void userBeginToSearchForOneOfTheFiles() {

        homePage.searchExistingFile();

    }

    @Then("File name should appear on the search box")
    public void fileNameShouldAppearOnTheSearchBox() {

        Assert.assertTrue(homePage.fileAppearsOnSearchResults());
    }
}

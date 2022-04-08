package com.cydeo.stepDefs;

import com.cydeo.pages.FilesPage;
import com.cydeo.utility.BrowserUtil;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FielsPageStepDefs {

    FilesPage filesPage = new FilesPage();
    Faker faker = new Faker();

    @When("Click on Plus button")
    public void click_on_plus_button() {
        filesPage.clickOnPlusButton();
    }


    @When("Click on New Folder")
    public void click_on_new_folder() {
        filesPage.clickOnCreateNewFolderButton();
    }

    public String folderName = faker.name().username();

    @When("give a name to new folder")
    public void give_a_name_to_new_folder() {
        System.out.println("folderName = " + folderName);
        filesPage.createNewFolder(folderName);
    }

    @Then("should be able to create new empty folder")
    public void should_be_able_to_create_new_empty_folder() {

        Assert.assertTrue(filesPage.isListContainFolder(folderName));

        System.out.println("Do assertions here");



    }


    @And("click on checkbox for selecting all folders")
    public void clickOnCheckboxForSelectingAllFolders() {
        //BrowserUtil.waitAlittle(2);
filesPage.clickToselectAllFolders();

    }

    @Then("all folders should be selected")
    public void allFoldersShouldBeSelected() {

        System.out.println("check if all folders had beeing selected");

        Assert.assertTrue(filesPage.checkIfAllFoldersSelected());

    }

    /*
    next scope of methods is related to "Add to favorites"
     */

    @And("User click on Action icon")
    public void userClickOnActionIcon() {
        filesPage.clickOnActionIcon();
    }

    @And("User choose Add to favorites")
    public void userChooseAddToFavorites() {
    }

    @And("User click on favorites module on left side")
    public void userClickOnFavoritesModuleOnLeftSide() {
    }

    @Then("User should be able to see chosen file in favorites")
    public void userShouldBeAbleToSeeChosenFileInFavorites() {
    }
}

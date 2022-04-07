package com.cydeo.stepDefs;

import com.cydeo.pages.FilesPage;
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


    }
}

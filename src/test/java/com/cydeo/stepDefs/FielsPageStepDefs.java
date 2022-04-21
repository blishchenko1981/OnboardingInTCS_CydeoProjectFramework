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
    String folder;

    @And("User click on Action icon on {string} folder")
    public void userClickOnActionIconOnFolder(String folderName) {
        filesPage.clickOnActionOnspecificFolder(folderName);
        BrowserUtil.waitAlittle(2);
        folder = folderName;
        System.out.println("folder = " + folder);
    }

    @And("User choose Add to favorites")
    public void userChooseAddToFavorites() {
        BrowserUtil.waitAlittle(2);
        filesPage.clickAddToFavorites();
    }

    @And("User click on favorites module on left side")
    public void userClickOnFavoritesModuleOnLeftSide() {
        filesPage.clickOnFavoritesModule();

    }

    @Then("User should be able to see chosen file in favorites")
    public void userShouldBeAbleToSeeChosenFileInFavorites() {
        Assert.assertTrue(filesPage.checkIfFavoritesListContainAddedFolder(folder));
    }


    // test remove folder from favorites

    @And("User remove first file from Favorites")
    public void userRemoveFirstFileFromFavorites() {

        filesPage.removeFirstFolderFromFavorites();
    }

    @Then("After reloading page files should be removed")
    public void afterReloadingPageFilesShouldBeRemoved() {

        System.out.println("filesPage.checkIfFileRemoved() = " + filesPage.checkIfFileRemoved());
        Assert.assertTrue(filesPage.checkIfFileRemoved());

    }


    @And("Click on Upload file {string}")
    public void clickOnUploadFile(String pathToFile) {

        filesPage.uploadFile(pathToFile);
    }

    @Then("user should be able to see file {string} displayed on the page")
    public void userShouldBeAbleToSeeFileDisplayedOnThePage(String fileName) {


        System.out.println("filesPage.isDisplayed(fileName) = " + filesPage.isDisplayed(fileName));
        Assert.assertTrue(filesPage.isDisplayed(fileName));

        // delete file to be able upload it next time:
        filesPage.deleteFile(fileName);

    }

    //------------------ upload file to the new folder --------
    @And("click on new folder")
    public void clickOnNewFolder() {
        filesPage.cickOnFolder(folderName);
        BrowserUtil.waitAlittle(2);
    }


    @Then("Should be able to upload file in new folder {string}")
    public void shouldBeAbleToUploadFileInNewFolder(String path) {

        filesPage.uploadFile(path);
        BrowserUtil.waitAlittle(2);
    }

    @And("Click the action icon from any file")
    public void clickTheActionIconFromAnyFile() {
        filesPage.deleteSecondFolder();

    }

    @And("Click deleted files on left buttom corner")
    public void clickDeletedFilesOnLeftButtomCorner() {
        filesPage.clickOnDeletedFilesLink();
    }

    @Then("Verify the deleted file is displayed on the page")
    public void verifyTheDeletedFileIsDisplayedOnThePage() {

        Assert.assertTrue(filesPage.deletedFileIsDisplayed());
    }
}

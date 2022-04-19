package com.cydeo.pages;

import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.text.Utilities;
import java.util.Collections;
import java.util.List;

public class FilesPage {

    public FilesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@class='button new']")
    private WebElement plusButton;
    @FindBy(xpath = "//span[text() = 'New folder']")
    private WebElement createNewFolderButton;
    @FindBy(id = "view13-input-folder")
    private WebElement nameForNewFolder;
    @FindBy(xpath = "//form[@class='filenameform']/input[@type='submit']")
    private WebElement submitNewFolderCreation;

    @FindBy(xpath = "//span[@class='nametext']")
    private List<WebElement> listOfFolders;

    @FindBy(xpath = "//label[@for='select_all_files']")
    private WebElement selectAllFoldersCheckBox;

    @FindBy(xpath = "//tr//input[@type = 'checkbox'][@class='selectCheckBox checkbox']")
    private List<WebElement> allFoldersCheckboxes;

    @FindBy(xpath = "//*[@id=\"fileList\"]/tr[2]//a[2]")
    private WebElement actionIcon;

    @FindBy(xpath = "//span[text() = 'Add to favorites']")
    private WebElement addToFavorites;

    @FindBy(xpath = "//span[text() = 'Remove from favorites']")
    private WebElement removeFromFavorites;

    @FindBy(xpath = "//a[text() = 'Favorites']")
    private WebElement favoritesModule;

    @FindBy(xpath = "//div[@id='app-content-favorites']//tbody[@id='fileList']/tr//span[@class = 'nametext']")
    private List<WebElement> listOfNames_FavoriteFolders;

    public void clickOnPlusButton() {
        plusButton.click();
    }

    public void clickOnCreateNewFolderButton() {
        createNewFolderButton.click();
    }

    public void createNewFolder(String nameFolder) {
        nameForNewFolder.sendKeys(nameFolder);
        submitNewFolderCreation.click();
        BrowserUtil.waitAlittle(2);
    }

    public boolean isListContainFolder(String name) {
        boolean isContains = false;
        for (WebElement folder : listOfFolders) {
            System.out.println("folder.getText() = " + folder.getText());
            if (folder.getText().equals(name)) {
                isContains = true;
                break;
            }
        }

        return isContains;
    }

    public void clickToselectAllFolders() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        selectAllFoldersCheckBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='select_all_files']")));
        selectAllFoldersCheckBox.click();
        BrowserUtil.waitAlittle(2);
    }

    public boolean checkIfAllFoldersSelected() {
        boolean allSelected = true;
        for (WebElement checkbox : allFoldersCheckboxes) {
            if (!checkbox.isSelected()) {
                allSelected = false;
                break;
            }
        }

        return allSelected;
    }

    // ---------------------   Add to Favorites feature methods -------------------------------

    public void clickOnActionOnspecificFolder(String nameOfFolder) {

        WebElement actionOnaddedFolder = Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + nameOfFolder + "']//a[2]"));
        actionOnaddedFolder.click();
    }


    public void clickAddToFavorites() {
        addToFavorites.click();
    }


    public void clickOnFavoritesModule() {
        favoritesModule.click();
    }

    public boolean checkIfFavoritesListContainAddedFolder(String folderName) {

        boolean isContain = false;
        for (WebElement eachName : listOfNames_FavoriteFolders) {

            if (eachName.getText().equals(folderName)) {
                System.out.println("eachName = " + eachName.getText());

                isContain = true;
                WebElement actionOnaddedFolder = Driver.getDriver().findElement(By.xpath("//*[@id=\"fileList\"]/tr[@data-file = '" + folderName + "']/td[1]/a/span[3]/a[2]"));
                actionOnaddedFolder.click();

                removeFromFavorites.click();
                break;
            }

        }

        return isContain;
    }

    // -----------  remove folder from Favorites  -------------------------


    @FindBy(xpath = "//*[@id='fileList']/tr[1]/td[1]/a/span[3]/a[2]")
    private WebElement firstFolderOnFavoritesPage;
    @FindBy(xpath = "//*[@id=\"fileList\"]/tr[1]/td[1]/a/span[1]/span")
    private WebElement firstNameOfFolder;

    public String name;

    public void removeFirstFolderFromFavorites() {
        // before remove get name of the first folder
        name = firstNameOfFolder.getText();

        System.out.println("nameOfFirstFolder = " + name);

        firstFolderOnFavoritesPage.click();

        removeFromFavorites.click();
        BrowserUtil.waitAlittle(1);
    }


    public boolean checkIfFileRemoved() {
        Driver.getDriver().navigate().refresh();
        BrowserUtil.waitAlittle(1);
        boolean doesNotContain = true;

        for (WebElement each : listOfNames_FavoriteFolders) {

            if (each.getText().equals(name)) {
                doesNotContain = false;
                break;
            }

        }

        return doesNotContain;
    }


    // --------------- Upload file function ------------------------------

    //span[contains(@class, 'add')]

    @FindBy(xpath = "//span[contains(@class, 'add')]")
    private WebElement uploadFileButton;

    @FindBy(xpath = "//div[@class='hiddenuploadfield']")
    private WebElement hiddenUploadField;

    public void uploadFile(String pathToFile){
        uploadFileButton.click();
        hiddenUploadField.sendKeys(pathToFile);
    }








}

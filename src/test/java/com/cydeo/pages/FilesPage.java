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
// --------------- Action Module -----------------------------------------

    @FindBy(xpath = "//*[@id=\"fileList\"]/tr[2]//a[2]")
    private WebElement actionIcon; // Second folder in the list

    @FindBy(xpath = "//span[text() = 'Add to favorites']")
    private WebElement addToFavorites;

    @FindBy(xpath = "//li[@class = ' action-delete-container']")
    private WebElement deleteFileAction;

    @FindBy(xpath = "//li/div[@class='message']")
    private List<WebElement> listOfComments;
    // -----------
    @FindBy(xpath = "//span[text() = 'Details']")
    private WebElement details;

    @FindBy(xpath = "//a[@id='commentsTabView']")
    private WebElement commentsToFolder;

    @FindBy(xpath = "//div[@class='message']")
    private WebElement commentsBox;

    @FindBy(xpath = "//form[@class='newCommentForm']//input[@type = 'submit']")
    private WebElement submitCommentButton;

// -----------
    // --------------------------------------------------------------------

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

    @FindBy(xpath = "//input[@id='file_upload_start']")
    private WebElement hiddenUploadField;

    public void uploadFile(String pathToFile) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='file_upload_start']")));
        hiddenUploadField.sendKeys(pathToFile);
    }


    public boolean isDisplayed(String nameOfFile) {

        boolean isDisplayed = false;
        BrowserUtil.waitAlittle(3);
        for (WebElement each : listOfFolders) {
            System.out.println("each.getText() = " + each.getText());
            if (each.getText().startsWith(nameOfFile)) {
                isDisplayed = true;

            }
        }
        return isDisplayed;
    }

    // ________________________ delete File from page by the name __________________

    @FindBy(xpath = "//a[text() = 'Deleted files']")
    private WebElement deletedFilesLink;

    @FindBy(xpath = "//a[@id = 'modified']/span[text() = 'Deleted']")
    private WebElement sortDeletedFilesByTime;

    @FindBy(xpath = "//tbody[@id='fileList']/tr[1]")
    private WebElement firstDeletedFolder;

    public void deleteFile(String name) {

        WebElement actionOnFile = Driver.getDriver().findElement(By.xpath("//tr[starts-with(@data-file, 'Session')]//a[2]"));
        actionOnFile.click();
        deleteFileAction.click();


    }

    public void cickOnFolder(String folderName) {

        WebElement folder = Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + folderName + "']"));
        folder.click();
        BrowserUtil.waitAlittle(3);


    }

    // check if deleted file appears on "Deleted files" folder
    //1. Delete first folder:
    String nameOfFirstFolder;

    public void deleteSecondFolder() {
        // get name of the first folder that will be deleted

        WebElement nameFirstFolder = Driver.getDriver().findElement(By.xpath("//tr[2]//span[@class='nametext']"));
        nameOfFirstFolder = nameFirstFolder.getText();
        actionIcon.click();
        BrowserUtil.waitAlittle(2);

        deleteFileAction.click();
    }

    public void clickOnDeletedFilesLink() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text() = 'Deleted files']")));
        deletedFilesLink.click();
        BrowserUtil.waitAlittle(3);
        sortDeletedFilesByTime.click();
        sortDeletedFilesByTime.click();
        BrowserUtil.waitAlittle(3);
    }


    public boolean deletedFileIsDisplayed() {
        System.out.println("nameOfFirstFolder = " + nameOfFirstFolder);

        WebElement lastDeletedFolder = Driver.getDriver().findElement(By.xpath("//*[@id='fileList']/tr[starts-with (@data-path,'" + nameOfFirstFolder + "')]"));
        System.out.println("lastDeletedFolder.getAttribute(\"data-path\") = " + lastDeletedFolder.getAttribute("data-path"));
        return lastDeletedFolder.getAttribute("data-path").equals(nameOfFirstFolder);
//*[@id="fileList"]/tr[1]
    }

    public void clickOnSecondFolderActionIcon() {
        actionIcon.click();
    }

    public void clickOnDetails() {
        details.click();
    }

    public String newComment;

    public void createComment(String comment) {
        newComment = comment;
        commentsToFolder.click();
        commentsBox.sendKeys(comment);
        submitCommentButton.click();
    }


    public boolean verifyNewCommentWasCreated() {

        boolean isCommentPresented = false;

        if (listOfComments.get(0).getText().equals(newComment)) {
            isCommentPresented = true;
        }
        System.out.println("listOfComments.get(0).getText() = " + listOfComments.get(0).getText());
        return isCommentPresented;
    }


    // ---------------------  test Settings function --------------------------------------
    @FindBy(xpath = "//button[normalize-space(.) = 'Settings']")
    private WebElement settingsBtn;

    // ----- Settings functions ------
    @FindBy(xpath = "//div[@id='app-settings-content']//div//label")
    //div[@id = 'app-settings-content']//input[@type = 'checkbox']
    private List<WebElement> listOfcheckboxesInSettings;

    @FindBy(xpath = "//div[@id='files-setting-richworkspace']//label")
    private WebElement showRichWorkspaces;

    @FindBy(xpath = "//div[@id='recommendations-setting-enabled']//label")
    private WebElement showRecommendeations;

    @FindBy(xpath = "//div[@id='files-setting-showhidden']//label")
    private WebElement showHiddenFiles;


    @FindBy(xpath = "//div[@id='rich-workspace']")
    private List<WebElement> richWorkspace;
    @FindBy(xpath = "//div[@id='recommendations']")
    private List<WebElement> recommendations;
    @FindBy(xpath = "//div[@class='viewcontainer has-comments has-selection']")
    private List<WebElement> hiddenFiles;

    public void clickOnSettings() {
        settingsBtn.click();
        BrowserUtil.waitAlittle(1);
    }

    public void clickOneachBox() {
        for (WebElement each : listOfcheckboxesInSettings) {
            each.click();
            BrowserUtil.waitAlittle(1);
            System.out.println("each.getText() = " + each.getText());
            System.out.println("richWorkspace.isDisplayed() = " + richWorkspace.isEmpty());
        }
    }

    public boolean isUserAbleToChangeSettings() {
        // ----------------------- Check RichWorkspace checkbox ----------------------------------
        boolean isSelectedrichWorkspace = false;

        if (richWorkspace.isEmpty()) {
            showRichWorkspaces.click();
            isSelectedrichWorkspace = richWorkspace.get(0).isDisplayed();
        } else {
            showRichWorkspaces.click();
            isSelectedrichWorkspace = richWorkspace.isEmpty();

        }
        System.out.println("isSelectedrichWorkspace = " + isSelectedrichWorkspace);
        //------------------------  Check recommendations   ----------------------------------
        boolean isSelectedRecomendations = false;
        if (recommendations.isEmpty()) {
            showRecommendeations.click();
            isSelectedRecomendations = recommendations.get(0).isDisplayed();
        } else {
            showRecommendeations.click();
            isSelectedRecomendations = recommendations.isEmpty();

        }
        System.out.println("isSelectedRecomendations = " + isSelectedRecomendations);
        //---------------------- Check HiddenFiles --------------------------------
        boolean isSelectedHiddenFiles = false;
        if (hiddenFiles.isEmpty()) {
            showHiddenFiles.click();
            isSelectedHiddenFiles = hiddenFiles.get(0).isDisplayed();
        } else {
            showHiddenFiles.click();
            isSelectedHiddenFiles = hiddenFiles.isEmpty();

        }
        System.out.println("isSelectedHiddenFiles = " + isSelectedHiddenFiles);
        return isSelectedrichWorkspace && isSelectedRecomendations && isSelectedHiddenFiles;

    }


}


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

    public boolean isListContainFolder(String name){
        boolean isContains = false;
        for (WebElement folder : listOfFolders) {
            System.out.println("folder.getText() = " + folder.getText());
            if(folder.getText().equals(name)){
                isContains = true;
                break;
            }
        }

        return isContains;
    }

    public void clickToselectAllFolders(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        selectAllFoldersCheckBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='select_all_files']")));
        selectAllFoldersCheckBox.click();
        BrowserUtil.waitAlittle(2);
    }

    public boolean checkIfAllFoldersSelected(){
        boolean allSelected = true;
        for (WebElement checkbox : allFoldersCheckboxes) {
            if(!checkbox.isSelected()){
                allSelected = false;
                break;
            }
        }

        return allSelected;
    }



}

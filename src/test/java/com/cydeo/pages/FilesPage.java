package com.cydeo.pages;

import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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



}

package com.cydeo.pages;

import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.ConfigReader;
import com.cydeo.utility.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//input[@id = 'user']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@id = 'password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id = 'submit-form']")
    private WebElement logInBtn;

    @FindBy(xpath = "//p[@class='warning wrongPasswordMsg']")
    private WebElement wrongPasswordMsg;

    @FindBy(xpath = "//a[@id='lost-password']")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//input[@id='user']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id='reset-password-submit']")
    private WebElement ResetButton;

    public void goTologinPage() {
        Driver.getDriver().get(ConfigReader.read("tryCloud-url"));
    }

    public void checkSizeLoginBtn(){
        String fontSize = logInBtn.getCssValue("font-size");
        System.out.println("fontSize = " + fontSize);
        String backGroundColor = logInBtn.getCssValue("background-color");
        System.out.println("backGroundColor = " + backGroundColor);
    }




    public void loginToWebsite() {
        usernameInput.sendKeys(ConfigReader.read("user"));
        passwordInput.sendKeys(ConfigReader.read("password"));
        logInBtn.click();

    }

    public void loginWithWrongCredentials() {
        usernameInput.sendKeys("user");
        passwordInput.sendKeys("11111");
        logInBtn.click();

    }


    public void messageWrongCredentialsAppears() {
        String actualMessage = wrongPasswordMsg.getText();
        String expectedMessage = "Wrong username or password.";
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    public void clickOnLoginButton() {

        logInBtn.click();
    }

    public String getTitleName() {
        return Driver.getDriver().getTitle();
    }

    public void clickForgetPassword() {
        forgotPasswordLink.click();
        BrowserUtil.waitAlittle(1);
    }

    public void checkEmailBoxInput() {
        boolean isEmailInputExist = emailInput.isDisplayed();
        Assert.assertTrue(isEmailInputExist);
        BrowserUtil.waitAlittle(2);
    }

    public void checkResetBTN (){
        Assert.assertTrue(ResetButton.isEnabled());
    }


}

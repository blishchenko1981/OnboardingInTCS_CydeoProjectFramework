package com.cydeo.stepDefs;

import com.cydeo.pages.HomePage;
import com.cydeo.pages.LoginPage;
import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;

public class LoginPageStepDefinition {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    String originalTagName;

    @Given("User  on the login page")
    public void user_on_the_login_page() {

        loginPage.goTologinPage();
        originalTagName = loginPage.getTitleName();


    }

    @When("User provide correct credentials")
    public void user_provide_correct_credentials() {
        loginPage.loginToWebsite();

    }

    @When("Click submit button")
    public void click_submit_button() {
        System.out.println("was clicked in previous method");
        BrowserUtil.waitAlittle(2);
    }

    @Then("User on Home page")
    public void user_on_home_page() {

        homePage.checkIfDriverOnTheHomePage();
    }


    @When("User provide wrong credentials")
    public void userProvideWrongCredentials() {
        loginPage.loginWithWrongCredentials();
    }

    @Then("Message should appear")
    public void messageShouldAppear() {
        loginPage.messageWrongCredentialsAppears();
    }

    @When("user click login button without providing any credentials")
    public void user_click_login_button_without_providing_any_credentials() throws InterruptedException {
        loginPage.clickOnLoginButton();
        BrowserUtil.waitAlittle(2);

    }


    @Then("TagName should not change")
    public void tagnameShouldNotChange() {

        Assert.assertEquals(originalTagName, Driver.getDriver().getTitle());

    }

    @When("User click on Forget Password")
    public void userClickOnForgetPassword() {

        loginPage.clickForgetPassword();
    }


    @Then("User should be able to put his email")
    public void userShouldBeAbleToPutHisEmail() {
        loginPage.checkEmailBoxInput();

    }

    @And("able to click button Reset")
    public void ableToClickButtonReset() {


    }

    @Then("Check font color")
    public void checkFontColor() {

        loginPage.checkSizeLoginBtn();
    }
}

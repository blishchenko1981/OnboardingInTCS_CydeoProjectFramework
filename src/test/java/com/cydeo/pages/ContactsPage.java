package com.cydeo.pages;

import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ContactsPage {

    public ContactsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@id='new-contact-button']")
    private WebElement createNewContactBTN;

    @FindBy(xpath = "//input[@id='contact-org']")
    private WebElement companyNameInput;

    @FindBy(xpath = "//input[@id='contact-title']")
    private WebElement titleInput;

    @FindBy(xpath = "//input[@inputmode='tel']")
    private WebElement phoneNumberInput;

    @FindBy(xpath = "//input[@inputmode='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//div[normalize-space(.) = 'Address']//.. /input[@type='text']")
    private WebElement streetInput;

    @FindBy(xpath = "//div[normalize-space(.) = 'City']//.. /input[@type='text']")
    private WebElement cityInput;

    @FindBy(xpath = "//div[@class='vue-recycle-scroller__item-view']")
    private List<WebElement> contactsList;


    Faker faker = new Faker();
    String newContactName;


    public void clickOnCreateNewContact() {
        createNewContactBTN.click();
    }


    public void fillNewContactForm() {

        newContactName = faker.company().name();
        System.out.println("newContactName = " + newContactName);
        companyNameInput.sendKeys(newContactName);
        titleInput.sendKeys(faker.company().profession());
        phoneNumberInput.sendKeys(faker.phoneNumber().cellPhone());
        emailInput.sendKeys(faker.name().username() + "gmail.com");
        streetInput.sendKeys(faker.address().streetAddress());
        cityInput.sendKeys(faker.address().cityName());
        BrowserUtil.waitAlittle(2);
    }


    public boolean contactsListContainNewContact() {
        boolean isContain = false;
        for (WebElement element : contactsList) {
            if (element.getText().contains(newContactName)) {
                isContain = true;
                break;
            }

            System.out.println("element.getText() = " + element.getText());
        }


        return isContain;
    }

    public boolean listOfContactsDisplayed() {
        boolean isDisplayed = true;
        for (WebElement contact : contactsList) {
            System.out.println("contact.isDisplayed() = " + contact.isDisplayed());
            System.out.println("contact.getText() = " + contact.getText());
            if(!contact.isDisplayed()){
                  isDisplayed = false;
                  break;
              }
        }

        return  isDisplayed;
    }
}

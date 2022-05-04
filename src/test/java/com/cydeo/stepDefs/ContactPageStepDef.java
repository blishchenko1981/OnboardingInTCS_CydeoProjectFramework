package com.cydeo.stepDefs;

import com.cydeo.pages.ContactsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ContactPageStepDef {


        ContactsPage contactPage = new ContactsPage();

        @When("Click on New Contact button")
        public void click_on_new_contact_button() {
            contactPage.clickOnCreateNewContact();
        }
        @When("Fill out the contact info")
        public void fill_out_the_contact_info() {
            contactPage.fillNewContactForm();

        }
        @Then("User should be able to see contact name is added to the contact list")
        public void user_should_be_able_to_see_contact_name_is_added_to_the_contact_list() {
            Assert.assertTrue(contactPage.contactsListContainNewContact());
        }


    @Then("List of contacts should be displayed on the screen")
    public void listOfContactsShouldBeDisplayedOnTheScreen() {
            Assert.assertTrue(contactPage.listOfContactsDisplayed());
    }
}


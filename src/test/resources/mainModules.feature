Feature: All main modules should work properly


  Dashboard, Files, Photos, Activity, Talk, Mail, Contacts, Circles, Calendar, Deck

  Background:
    Given User  on the login page
    When User provide correct credentials
    And Click submit button

  @ui @smoke
  Scenario: user should be able to see all required modules
    Then User should be able to see all modules in right order
      | Dashboard |
      | Files     |
      | Photos    |
      | Activity  |
      | Talk      |
      | Mail      |
      | Contacts  |
      | Circles   |
      | Calendar  |
      | Deck      |

  @ui @smoke
  Scenario: User should be able to see talk page after clicking on Talk module
    When User click on "Talk"
    Then Tab name should start with Talk

  @ui @smoke
  Scenario: User should be able to send message on talk module
    When User click on "Talk"
    And  Search  a user from search box on the left
    And  Write a message "Hi everyone!!!" and submit it
    Then Message "Hi everyone!!!" should be displayed on the conversation log

  @ui @smoke
  Scenario: User should be able get use Contacts function
    When User click on "Contacts"
    Then User should be directed on the "Contacts" page

  @ui @smoke
  Scenario: User should be able to create new contact
    When User click on "Contacts"
    And Click on New Contact button
    And Fill out the contact info
    Then User should be able to see contact name is added to the contact list

  @ui @smoke
  Scenario: User should be able to see all contacts names on the screen
    When User click on "Contacts"
    Then List of contacts should be displayed on the screen

@ui @smoke
    Scenario: User should be able to search item/users from homepage
      When User click on magnifier icon
      And User begin to search for one of the files
      Then File name should appear on the search box






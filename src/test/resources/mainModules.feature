Feature: All main modules should be placed correctly in right order

  Dashboard, Files, Photos, Activity, Talk, Mail, Contacts, Circles, Calendar, Deck

  Background:
    Given User  on the login page
    When User provide correct credentials
    And Click submit button

  @ui
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

  @ui @us11
  Scenario: User should be able to see talk page after clicking on Talk module
    When User click on "Talk"
    Then Tab name should start with Talk

  @ui
  Scenario: User should be able to send message on talk module
    When User click on "Talk"
    And  Search  a user from search box on the left
    And  Write a message "Hi everyone!!!" and submit it
    Then Message "Hi everyone!!!" should be displayed on the conversation log






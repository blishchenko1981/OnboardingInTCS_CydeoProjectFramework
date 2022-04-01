Feature: All main modules should be placed correctly in right order

  Dashboard, Files, Photos, Activity, Talk, Mail, Contacts, Circles, Calendar, Deck

  @ui
  Scenario: user should be able to see all required modules
    Given User  on the login page
    When User provide correct credentials
    And Click submit button
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



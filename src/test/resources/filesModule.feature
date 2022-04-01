Feature: As a user, I should be able to access to Files module

  Background:
    Given User  on the login page
    When User provide correct credentials

  @ui
  Scenario: user should get access to Files module
    When User click on "Files"
    Then User should be directed on the "Files - Trycloud QA" page

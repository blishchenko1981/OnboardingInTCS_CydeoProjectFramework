Feature: User should be able to use all main page

  Background:
    Given User  on the login page
    When User provide correct credentials

  @ui
  Scenario: User should be able to change settings
    When User click on "Files"
    And User click on settings link
    Then User should be able to select all three options
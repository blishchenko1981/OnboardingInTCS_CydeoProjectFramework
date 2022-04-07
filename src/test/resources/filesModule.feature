Feature: As a user, I should be able to access to Files module

  Background:
    Given User  on the login page
    When User provide correct credentials

  @ui
  Scenario: user should get access to Files module
    When User click on "Files"
    Then User should be directed on the "Files - Trycloud QA" page

  @ui
  Scenario: user should get access to Photos module
    When User click on "Photos"
    Then User should be directed on the "Photos - Trycloud QA" page

  @ui
  Scenario: user should be able create new folder
    When User click on "Files"
    And Click on Plus button
    And Click on New Folder
    And give a name to new folder
    Then should be able to create new empty folder

  @ui
  Scenario: user should be able to check all uploaded files from the page
    When User click on "Files"
    And click on checkbox for selecting all folders
    Then all folders should be selected

  @ui
  Scenario: user should be able create new folder
    When User click on "Files"
    And Click on Plus button
    And Click on New Folder
    And give a name to new folder
    Then should be able to create new empty folder

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

  @ui
  Scenario: user should be able to add file to Favorites
    When User click on "Files"
    And User click on Action icon on "larry.labadie" folder
    And User choose Add to favorites
    And User click on favorites module on left side
    Then User should be able to see chosen file in favorites

  @ui
  Scenario: user should be able to remove File From favorites
    When User click on "Files"
    And User click on favorites module on left side
    And User remove first file from Favorites
    Then After reloading page files should be removed

  @ui
  Scenario: user should be able to upload file directly to the home page
    When User click on "Files"
    And Click on Upload file "C:\Users\Vitalii\Desktop\IntelliJProjects\OnboardingInTCS_CydeoProjectFramework\src\test\resources\testData\Session1_ FolderStructure,Scanner.pdf"
    Then user should be able to see file "Session1_" displayed on the page

  @ui
  Scenario: User should be able to upload file in a new folder
    When User click on "Files"
    And Click on Plus button
    And Click on New Folder
    And give a name to new folder
    And click on new folder
    Then Should be able to upload file in new folder "C:\Users\Vitalii\Desktop\IntelliJProjects\OnboardingInTCS_CydeoProjectFramework\src\test\resources\testData\Session1_ FolderStructure,Scanner.pdf"
    And user should be able to see file "Session1_" displayed on the page

@ui
    Scenario: User should be able to delete the folder/file
      When User click on "Files"
      And Click the action icon from any file
      And Click deleted files on left buttom corner
      Then Verify the deleted file is displayed on the page





Feature: User should be able to use all main page

  Background:
    Given User  on the login page
    When User provide correct credentials

  @ui
  Scenario: User should be able to change settings
    When User click on "Files"
    And User click on settings link
    Then User should be able to select all three options
    
    @ui
    Scenario: User should be able to see the app storage usage
      When User click on "Files"
      And Click on Upload file "C:\Users\Vitalii\Desktop\IntelliJProjects\OnboardingInTCS_CydeoProjectFramework\src\test\resources\testData\Session1_ FolderStructure,Scanner.pdf"
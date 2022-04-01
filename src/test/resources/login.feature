Feature: as a user I should be able to log in

  @ui
  Scenario: User should be able to login by providing correct credentials
    Given User  on the login page
    When User provide correct credentials
    And Click submit button
    Then User on Home page

    @ui
    Scenario: If user provide wrong Username and Password the message "Wrong username or password" should appear
      Given User  on the login page
      When User provide wrong credentials
      Then Message should appear

      @ui
      Scenario: If user click login button without any credentials pup up window with
                notice should appear
        Given User  on the login page
        When user click login button without providing any credentials
        Then TagName should not change

        @ui
        Scenario: User should be able to use forget password function
          Given User  on the login page
          When User click on Forget Password
          Then User should be able to put his email
          And able to click button Reset


          @ui
          Scenario:
            Given User  on the login page
            Then Check font color




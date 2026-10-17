Feature: SauceDemo Login Funcationality

  Background:
    Given user is on the SauceDemo Login page

  @login @dataprovider
  Scenario: Login with valid credentials
    When user enters username "<username>"
    And user enters password "<password>"
    And User clicks on the login_button
    Then User should be navigate to the home page
    Then Actual result equals"<expectedResult>"
    And close the browser

    Examples:
      | username                | password       | expectedResult      |
      | standard_user           | secret_sauce   | success             |
      | problem_user            | secret_sauce   | success             |
      | performance_glitch_user | secret_sauce   | success             |
    #  | locked_out_user         | secret_sauce   | locked_out          |
      | error_user              | secret_sauce   | success             |
      | visual_user             | secret_sauce   | success             |
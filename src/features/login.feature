Feature: Login Functionality

  Scenario: Successful login
    Given I open the login page
    When I enter valid credentials
    Then I should be redirected to the account page
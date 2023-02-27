Feature: register feature test suite

  Scenario: myAccount button is accessible from home Page
    Given "https://demo-opencart.com/" is accessed

  Scenario: Register page URL is accessible from home page
    Given "https://demo-opencart.com/" is accessed
    When my Account button is clicked
    Then register account button is displayed
    And register account button is clicked
    Then the new URL contain the following "register"
    And  the "https://demo-opencart.com/" is close



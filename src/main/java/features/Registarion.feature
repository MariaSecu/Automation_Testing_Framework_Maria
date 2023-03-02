@run
Feature: register feature test suite

  Background:
    Given "https://demo-opencart.com/" is accessed


  Scenario: myAccount button is accessible from home Page
    When my Account button is clicked
    And register account button is clicked
    Then "register" is present within the current url

  Scenario Outline: Register page url contains the following word <keyword>
    When my Account button is clicked
    And register account button is clicked
    Then "<keyword>" is present within the current url

    Examples:
      | keyword          |
      | index            |
      | account/register |

  @run
  Scenario Outline: Error message is displayed when using invalid <password> password value
    Given my Account button is clicked
    And register account button is clicked
    When The registration form is populated with below data
      | firstName       | George            |
      | lastName        | Musat             |
      | email           | exemple@gmail.com |
      | telephone       | 078987677         |
      | password        | <password>        |
      | confirmPassword | <confirmPassword> |
    And privacyButton is clicked
    And continueButton is clicked
    Then The following errors are displayed on the screen:
      | <error> |
    Examples:
      | password               | confirmPassword        | error                                          |
      | 123                    | 123                    | Password must be between 4 and 20 characters!  |
      | 1234567890987654324567 | 1234567890987654324567 | Password must be between 4 and 20 characters!  |
      | Password               | Password1              | Password confirmation does not match password! |
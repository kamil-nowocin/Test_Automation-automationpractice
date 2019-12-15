Feature: As a user I would like to log in automationpractice.com

  Background: Navigate to Login page
    Given I open home page
    And I click on Sign in button
    Then I can see login form

#--------------------------------------------------------------------------------
  Scenario: As a user I can log into automationpractice.com website
    Given I can see login form
    When I enter login "thor.odinson@example.com"
    And I enter password "12345"
    And I click on Submit button
    Then I can see welcome message

#--------------------------------------------------------------------------------
  Scenario Outline: As a user I can't log into automationpractice.com
    Given I can see login form
    When I enter login "<email>"
    And I enter password "<password>"
    And I click on Submit button
    Then I can see warning message with include "<warningMessage>"
    Examples:
      | email                    | password | warningMessage            |
      | thanos.ALars@example.com | 12345    | Authentication failed     |
      | thor.odinson@example.com |          | Password is required      |
      |                          | 12345    | An email address required |
      |                          |          | An email address required |
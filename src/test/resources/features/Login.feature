Feature: As a user I would like to log in automationpractice.com

  Background: Navigate to Login page
    Given I open home page
    And I click on Sign in button
    Then I can see login form

#--------------------------------------------------------------------------------
  Scenario: As a user I can log into automationpractice.com website - user is registered in database (positive flow)
    Given I can see login form
    When I enter login "thor.odinson@example.com"
    And I enter password "12345"
    And I click on Submit button
    Then I can see welcome message

#--------------------------------------------------------------------------------
  Scenario: As a user I can't log into automationpractice.com website - user isn't registered in database (negative flow)
    Given I can see login form
    When I enter login "thanos.ALars@example.com"
    And I enter password "12345"
    And I click on Submit button
    Then I can see warning message with include "Authentication failed"

#--------------------------------------------------------------------------------
  Scenario: As a user I can't log into automationpractice.com website - password is missing (negative flow)
    Given I can see login form
    When I enter login "thor.odinson@example.com"
    And I click on Submit button
    Then I can see warning message with include "Password is required"

#--------------------------------------------------------------------------------
  Scenario: As a user I can't log into automationpractice.com website - login is missing (negative flow)
    Given I can see login form
    When I enter password "12345"
    And I click on Submit button
    Then I can see warning message with include "An email address required"

#--------------------------------------------------------------------------------
  Scenario: As a user I can't log into automationpractice.com website - login and password are missing (negative flow)
    Given I can see login form
    When I click on Submit button
    Then I can see warning message with include "An email address required"
#/**
#* Test_Automation-automationpractice
#*
#* @author kamil.nowocin
#**/

Feature: As a user I would like to register into automationpractice.com

  Background: Navigate to Sign Up page
    Given I open home page
    When I click on Sign in button
    Then I can see create an account page

#--------------------------------------------------------------------------------
  Scenario: Checking availability of registration page form
    Given I can see create an account page
    When I write an email address
    And I click on Create An Account button
    Then I can see registration page form

#--------------------------------------------------------------------------------
  Scenario: As a user I can create an account by filling up all fields
    Given I can see registration page form
    When I write an email address
    And I click on Create An Account button
    And I choose gender
    And I write my first name
    And I write my last name
    And I check if email is already written and valid
    And I write password
    And I choose date of birth
    And I sign in to receive newsletter and special offers
    And I check if my first & last name are already written and are correct
    And I write company name
    And I write my addresses
    And I choose country "United States"
    And I write city name
    And I choose state
    And I write postal code
    And I write additional information
    And I write home phone
    And I write mobile phone
    And I write my address alias
    And I click on Register button
    Then I can see welcome message

#--------------------------------------------------------------------------------
  Scenario: As a user I can create an account by filling up only required fields
    Given I can see registration page form
    When I write an email address
    And I click on Create An Account button
    And I write my first name
    And I write my last name
    And I check if email is already written and valid
    And I write password
    And I check if my first & last name are already written and are correct
    And I write my address
    And I choose country "United States"
    And I write city name
    And I choose state
    And I write postal code
    And I write mobile phone
    And I write my address alias
    And I click on Register button
    Then I can see welcome message

#--------------------------------------------------------------------------------
  Scenario: As a user I can't create an account without filling up fields
    Given I can see registration page form
    When I write an email address
    And I click on Create An Account button
    And I click on Register button
    Then I can see registration error

#--------------------------------------------------------------------------------
  #This scenario is created as "smart one", you can choose any of required field to be missing.
  #Simply, just leave one and only one of data section as blank one.
  Scenario: As a user I can't create an account when one of required fields is missing
    Given I can see registration page form
    When I write an email address
    And I click on Create An Account button
    And I write following data to registration form
      | First Name | Last Name | Password   | Address | City      | State  | Postal Code | Country       | Mobile Phone |
      | Thor       | Odinson   | #passwd123 |         | Anchorage | Alaska | 99503       | United States | 907-748-2005 |
    And I check if email is already written and valid
    And I check if my first & last name are already written and are correct
    And I write my address alias
    And I click on Register button
    Then I can see warning message about missing "one element" input

#--------------------------------------------------------------------------------
  Scenario: As a user I can't create an account when email is already in database
    Given I can see registration page form
    When I write an email address which is already in database
    And I click on Create An Account button
    Then I can see registration error

#--------------------------------------------------------------------------------
  Scenario: As a user I can't create an account when email has wrong format
    Given I can see registration page form
    When I write an invalid email address
    And I click on Create An Account button
    Then I can see create an account error
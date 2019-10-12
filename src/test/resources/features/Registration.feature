#Feature: As a user I would like to register into automationpractice.com by registration page form
#
#  Background: Navigate to Sign Up page
#    Given I open home page
#    When I click on Sign in button
#    Then I can see create an account page
#
##--------------------------------------------------------------------------------
#  Scenario: Checking availability of registration page form
#    Given I can see create an account page
#    When I write an email address
#    And I click on create an account button
#    Then I can see registration page form
#
##--------------------------------------------------------------------------------
#  Scenario: As a user I can create an account - all fields are filled up correctly (positive flow)
#    Given I can see registration page form
#    When I write an email address
#    And I click on create an account button
#    And I choose gender
#    And I write my first name
#    And I write my last name
#    And I check if email is already written and valid
#    And I write password
#    And I choose date of birth
#    And I sign in to receive newsletter and special offers
#    And I check if my first & last name are already written and are correct
#    And I write company name
#    And I write my addresses
#    And I choose country
#    And I write city name
#    And I choose state
#    And I write postal code
#    And I write additional information
#    And I write home phone
#    And I write mobile phone
#    And I write my address alias
#    And I click on register button
#    Then I can see welcome message
#
##--------------------------------------------------------------------------------
#  Scenario: As a user I can create an account - all required fields are filled up correctly (positive flow)
#    Given I can see registration page form
#    When I write an email address
#    And I click on create an account button
#    And I write my first name
#    And I write my last name
#    And I check if email is already written and valid
#    And I write password
#    And I check if my first & last name are already written and are correct
#    And I write my address
#    And I choose country
#    And I write city name
#    And I choose state
#    And I write postal code
#    And I write mobile phone
#    And I write my address alias
#    And I click on register button
#    Then I can see welcome message
#
##--------------------------------------------------------------------------------
#  Scenario: As a user I can't create an account - none of fields in registration form are filled up (negative flow)
#    Given I can see registration page form
#    When I write an email address
#    And I click on create an account button
#    And I click on register button
#    Then I can see registration error
#
##--------------------------------------------------------------------------------
#  #This scenario is created as "smart one", you can choose any of required field to be missing.
#  #Simply, just leave one and only one of data section as blank one.
#  Scenario: As a user I can't create an account - one of required fields is missing (negative flow)
#    Given I can see registration page form
#    When I write an email address
#    And I click on create an account button
#    And I write following data to registration form
#      | First Name | Last Name | Password   | Address | City      | State  | Postal Code | Country       | Mobile Phone |
#      | Thor       | Odinson   | #passwd123 |         | Anchorage | Alaska | 99503       | United States | 907-748-2005 |
#    And I check if email is already written and valid
#    And I check if my first & last name are already written and are correct
#    And I write my address alias
#    And I click on register button
#    Then I can see registration error which include one missing element
#
##--------------------------------------------------------------------------------
#  Scenario: As a user I can't create an account - email is already in database (negative flow)
#    Given I can see registration page form
#    When I write an email address which is already in database
#    And I click on create an account button
#    Then I can see registration error
#
##--------------------------------------------------------------------------------
#  Scenario: As a user I can't create an account - email has wrong format (negative flow)
#    Given I can see registration page form
#    When I write an invalid email address
#    And I click on create an account button
#    Then I can see create an account error
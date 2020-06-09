#/**
#* Test_Automation-automationpractice
#*
#* @author kamil.nowocin
#**/

@registrationValidators
Feature: As a user I would like to see the error message where I made a mistake in the registration page form
#--------------------------------------------------------------------------------#
# [UserStory] https://tracker.FAKE.com/jira/browse/AUTOMATION_PRACTICE-444       #
#--------------------------------------------------------------------------------#

  Background: Navigate to registration page
    Given I open home page
    And I can see automationpractice.com website
    When I click on Sign in button
    And I write an email address
    And I click on Create An Account button
    Then I can see registration page form

#--------------------------------------------------------------------------------#
# [ZEPHYR] https://tracker.FAKE.com/jira/browse/AUTOMATION_PRACTICE-0020
  @non-smoke @normal @regression
  Scenario:[US-444]/[1] As a user I would like to see registration error, when I don't fill first name input
    Given I can see registration page form
    When I choose gender
    And I write my last name
    And I write password
    And I choose date of birth
    And I write my address
    And I choose country "United States"
    And I write city name
    And I choose state
    And I write postal code
    And I write mobile phone
    And I write my address alias
    And I click on Register button
    Then I can see warning message about missing "first name" input

#--------------------------------------------------------------------------------#
# [ZEPHYR] https://tracker.FAKE.com/jira/browse/AUTOMATION_PRACTICE-0021
  @non-smoke @normal @regression
  Scenario:[US-444]/[2] As a user I would like to see registration error, when I don't fill last name input
    Given I can see registration page form
    When I choose gender
    And I write my first name
    And I write password
    And I choose date of birth
    And I write my address
    And I choose country "United States"
    And I write city name
    And I choose state
    And I write postal code
    And I write mobile phone
    And I write my address alias
    And I click on Register button
    Then I can see warning message about missing "last name" input

#--------------------------------------------------------------------------------#
# [ZEPHYR] https://tracker.FAKE.com/jira/browse/AUTOMATION_PRACTICE-0022
  @non-smoke @normal @regression
  Scenario:[US-444]/[3] As a user I would like to see registration error, when I don't fill email input
    Given I can see registration page form
    When I choose gender
    And I write my first name
    And I write my last name
    And I clear my email address
    And I write password
    And I choose date of birth
    And I write my address
    And I choose country "United States"
    And I write city name
    And I choose state
    And I write postal code
    And I write mobile phone
    And I write my address alias
    And I click on Register button
    Then I can see warning message about missing "email address" input

#--------------------------------------------------------------------------------#
# [ZEPHYR] https://tracker.FAKE.com/jira/browse/AUTOMATION_PRACTICE-0023
  @non-smoke @normal @regression
  Scenario:[US-444]/[4] As a user I would like to see registration error, when I don't fill password input
    Given I can see registration page form
    When I choose gender
    And I write my first name
    And I write my last name
    And I choose date of birth
    And I write my address
    And I choose country "United States"
    And I write city name
    And I choose state
    And I write postal code
    And I write mobile phone
    And I write my address alias
    And I click on Register button
    Then I can see warning message about missing "password" input

#--------------------------------------------------------------------------------#
# [ZEPHYR] https://tracker.FAKE.com/jira/browse/AUTOMATION_PRACTICE-0024
  @non-smoke @normal @regression
  Scenario:[US-444]/[5] As a user I would like to see registration error, when I don't fill address input
    Given I can see registration page form
    When I choose gender
    And I write my first name
    And I write my last name
    And I write password
    And I choose date of birth
    And I choose country "United States"
    And I write city name
    And I choose state
    And I write postal code
    And I write mobile phone
    And I write my address alias
    And I click on Register button
    Then I can see warning message about missing "address" input

#--------------------------------------------------------------------------------#
# [ZEPHYR] https://tracker.FAKE.com/jira/browse/AUTOMATION_PRACTICE-0025
  @non-smoke @normal @regression
  Scenario:[US-444]/[6] As a user I would like to see registration error, when I don't fill city input
    Given I can see registration page form
    When I choose gender
    And I write my first name
    And I write my last name
    And I write password
    And I choose date of birth
    And I write my address
    And I choose country "United States"
    And I choose state
    And I write postal code
    And I write mobile phone
    And I write my address alias
    And I click on Register button
    Then I can see warning message about missing "city" input

#--------------------------------------------------------------------------------#
# [ZEPHYR] https://tracker.FAKE.com/jira/browse/AUTOMATION_PRACTICE-0026
  @non-smoke @normal @regression
  Scenario:[US-444]/[7] As a user I would like to see registration error, when I don't fill state input
    Given I can see registration page form
    When I choose gender
    And I write my first name
    And I write my last name
    And I write password
    And I choose date of birth
    And I write my address
    And I choose country "United States"
    And I write city name
    And I write postal code
    And I write mobile phone
    And I write my address alias
    And I click on Register button
    Then I can see warning message about missing "state" input

#--------------------------------------------------------------------------------#
# [ZEPHYR] https://tracker.FAKE.com/jira/browse/AUTOMATION_PRACTICE-0027
  @non-smoke @normal @regression
  Scenario:[US-444]/[8] As a user I would like to see registration error, when I don't fill postal code input
    Given I can see registration page form
    When I choose gender
    And I write my first name
    And I write my last name
    And I write password
    And I choose date of birth
    And I write my address
    And I choose country "United States"
    And I write city name
    And I choose state
    And I write mobile phone
    And I write my address alias
    And I click on Register button
    Then I can see warning message about missing "postal code" input

#--------------------------------------------------------------------------------#
# [ZEPHYR] https://tracker.FAKE.com/jira/browse/AUTOMATION_PRACTICE-0028
  @non-smoke @normal @regression
  Scenario:[US-444]/[9] As a user I would like to see registration error, when I don't fill country input
    Given I can see registration page form
    When I choose gender
    And I write my first name
    And I write my last name
    And I write password
    And I choose date of birth
    And I write my address
    And I write city name
    And I choose country "-"
    And I write mobile phone
    And I write my address alias
    And I click on Register button
    Then I can see warning message about missing "country" input

#--------------------------------------------------------------------------------#
# [ZEPHYR] https://tracker.FAKE.com/jira/browse/AUTOMATION_PRACTICE-0029
  @non-smoke @normal @regression
  Scenario:[US-444]/[10] As a user I would like to see registration error, when I don't fill mobile phone input
    Given I can see registration page form
    When I choose gender
    And I write my first name
    And I write my last name
    And I write password
    And I choose date of birth
    And I write my address
    And I choose country "United States"
    And I write city name
    And I choose state
    And I write postal code
    And I write my address alias
    And I click on Register button
    Then I can see warning message about missing "mobile phone" input

#--------------------------------------------------------------------------------#
# [ZEPHYR] https://tracker.FAKE.com/jira/browse/AUTOMATION_PRACTICE-0030
  @non-smoke @normal @regression
  Scenario:[US-444]/[11] As a user I would like to see registration error, when I don't fill email alias input
    Given I can see registration page form
    When I choose gender
    And I write my first name
    And I write my last name
    And I write password
    And I choose date of birth
    And I write my address
    And I choose country "United States"
    And I write city name
    And I choose state
    And I write postal code
    And I write mobile phone
    And I clear my email address alias
    And I click on Register button
    Then I can see warning message about missing "email address alias" input
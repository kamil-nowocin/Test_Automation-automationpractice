Feature: As a user I would like to see the error message where I made a mistake in the registration page form

  Background: Navigate to registration page
    Given I open home page
    When I click on Sign in button
    And I write an email address
    And I click on Create An Account button
    Then I can see registration page form

#--------------------------------------------------------------------------------
  Scenario: As a user I would like to see registration error when I don't fill first name input
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

#--------------------------------------------------------------------------------
  Scenario: As a user I would like to see registration error when I don't fill last name input
    Given I can see registration page form
    When I choose gender
    And I write my first name
    And I write password
    And I write my address
    And I choose country "United States"
    And I write city name
    And I choose state
    And I write postal code
    And I write mobile phone
    And I write my address alias
    And I click on Register button
    Then I can see warning message about missing "last name" input

#--------------------------------------------------------------------------------
  Scenario: As a user I would like to see registration error when I don't fill email input
    Given I can see registration page form
    When I choose gender
    And I write my first name
    And I write my last name
    And I clear my email address
    And I write password
    And I write my address
    And I choose country "United States"
    And I write city name
    And I choose state
    And I write postal code
    And I write mobile phone
    And I write my address alias
    And I click on Register button
    Then I can see warning message about missing "email address" input

#--------------------------------------------------------------------------------
  Scenario: As a user I would like to see registration error when I don't fill password input
    Given I can see registration page form
    When I choose gender
    And I write my first name
    And I write my last name
    And I write my address
    And I choose country "United States"
    And I write city name
    And I choose state
    And I write postal code
    And I write mobile phone
    And I write my address alias
    And I click on Register button
    Then I can see warning message about missing "password" input

#--------------------------------------------------------------------------------
  Scenario: As a user I would like to see registration error when I don't fill input
    Given I can see registration page form
    When I choose gender
    And I write my first name
    And I write my last name
    And I write password
    And I choose country "United States"
    And I write city name
    And I choose state
    And I write postal code
    And I write mobile phone
    And I write my address alias
    And I click on Register button
    Then I can see warning message about missing "address" input

#--------------------------------------------------------------------------------
  Scenario: As a user I would like to see registration error when I don't fill city input
    Given I can see registration page form
    When I choose gender
    And I write my first name
    And I write my last name
    And I write password
    And I write my address
    And I choose country "United States"
    And I choose state
    And I write postal code
    And I write mobile phone
    And I write my address alias
    And I click on Register button
    Then I can see warning message about missing "city" input

#--------------------------------------------------------------------------------
  Scenario: As a user I would like to see registration error when I don't fill state input
    Given I can see registration page form
    When I choose gender
    And I write my first name
    And I write my last name
    And I write password
    And I write my address
    And I choose country "United States"
    And I write city name
    And I write postal code
    And I write mobile phone
    And I write my address alias
    And I click on Register button
    Then I can see warning message about missing "state" input

#--------------------------------------------------------------------------------
  Scenario: As a user I would like to see registration error when I don't fill postal code input
    Given I can see registration page form
    When I choose gender
    And I write my first name
    And I write my last name
    And I write password
    And I write my address
    And I choose country "United States"
    And I write city name
    And I choose state
    And I write mobile phone
    And I write my address alias
    And I click on Register button
    Then I can see warning message about missing "postal code" input

#--------------------------------------------------------------------------------
  Scenario: As a user I would like to see registration error when I don't fill country input
    Given I can see registration page form
    When I choose gender
    And I write my first name
    And I write my last name
    And I write password
    And I write my address
    And I write city name
    And I choose country "-"
    And I write mobile phone
    And I write my address alias
    And I click on Register button
    Then I can see warning message about missing "country" input

#--------------------------------------------------------------------------------
  Scenario: As a user I would like to see registration error when I don't fill mobile phone input
    Given I can see registration page form
    When I choose gender
    And I write my first name
    And I write my last name
    And I write password
    And I write my address
    And I choose country "United States"
    And I write city name
    And I choose state
    And I write postal code
    And I write my address alias
    And I click on Register button
    Then I can see warning message about missing "mobile phone" input

#--------------------------------------------------------------------------------
  Scenario: As a user I would like to see registration error when I don't fill email alias input
    Given I can see registration page form
    When I choose gender
    And I write my first name
    And I write my last name
    And I write password
    And I write my address
    And I choose country "United States"
    And I write city name
    And I choose state
    And I write postal code
    And I write mobile phone
    And I clear my email address alias
    And I click on Register button
    Then I can see warning message about missing "email address alias" input
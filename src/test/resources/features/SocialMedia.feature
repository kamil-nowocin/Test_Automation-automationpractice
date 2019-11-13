Feature: As a user I would like to check if I'll be redirected to social media pages from automationpractice.com

  Background: Navigate to Automationpractice.com website
    Given I open home page

#--------------------------------------------------------------------------------
  Scenario: As a user I click on Facebook logo
    Given I can see Automationpractice.com website
    When I scroll the website until I can see "Facebook" logo
    And I click on "Facebook" logo button
    Then I am redirected to Selenium "Facebook" profile

#--------------------------------------------------------------------------------
  Scenario: As a user I click on Twitter logo
    Given I can see Automationpractice.com website
    When I scroll the website until I can see "Twitter" logo
    And I click on "Twitter" logo button
    Then I am redirected to Selenium "Twitter" profile

#--------------------------------------------------------------------------------
  Scenario: As a user I click on YouTube logo
    Given I can see Automationpractice.com website
    When I scroll the website until I can see "YouTube" logo
    And I click on "YouTube" logo button
    Then I am redirected to Selenium "YouTube" profile

#--------------------------------------------------------------------------------
  Scenario: As a user I click on Google+ logo
    Given I can see Automationpractice.com website
    When I scroll the website until I can see "Google+" logo
    And I click on "Google+" logo button
    Then I am redirected to Selenium "Google+" profile
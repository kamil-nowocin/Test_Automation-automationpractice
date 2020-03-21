#/**
#* Test_Automation-automationpractice
#*
#* @author kamil.nowocin
#**/

@socialMedia
Feature: As a user I would like to be redirected to social media pages from automationpractice.com

  Background: Navigate to automationpractice.com website
    Given I open home page

#--------------------------------------------------------------------------------
  @non-smoke @medium @regression
  Scenario Outline:[1] I click on social media "<logo name>" logo
    Given I can see automationpractice.com website
    When I scroll the website until I can see "<logo name>" logo
    And I click on "<logo name>" logo button
    Then I am redirected to Selenium "<logo name>" profile

    Examples:
      | logo name |
      | Facebook  |
      | Twitter   |
      | YouTube   |
      | Google    |
#/**
#* Test_Automation-automationpractice
#*
#* @author kamil.nowocin
#**/

Feature: As a user I would like to check if I'll be redirected to social media pages from automationpractice.com

  Background: Navigate to Automationpractice.com website
    Given I open home page

#--------------------------------------------------------------------------------
  Scenario Outline: As a user I click on social media company logo
    Given I can see Automationpractice.com website
    When I scroll the website until I can see "<logoName>" logo
    And I click on "<logoName>" logo button
    Then I am redirected to Selenium "<logoName>" profile

    Examples:
      | logoName |
      | Facebook |
      | Twitter  |
      | YouTube  |
      | Google   |
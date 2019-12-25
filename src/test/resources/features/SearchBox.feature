#/**
#* Test_Automation-automationpractice
#*
#* @author kamil.nowocin
#**/

Feature: A a user I would like to see results of searching phrase

  Background: Navigate to Automationpractice.com website
    When I open home page

#--------------------------------------------------------------------------------
  Scenario Outline: As a user I would like to use search box and be able to see results of: <search phrase>
    Given I can see Automationpractice.com website
    When I search for phrase "<search phrase>"
    And I click on search icon
    Then I can see numbers of results equals to "<results>"
    And I can see that every results which have been found contains phrase "<search phrase>"

    Examples:
      | search phrase | results |
      | T-shirts      | 1       |
      | Blouse        | 1       |
      | Printed Dress | 5       |
      | !@#$%^        | 0       |

#--------------------------------------------------------------------------------
  Scenario Outline: As a user I would like to use search box and be able to see sorted results by <sortBy>
    Given I can see Automationpractice.com website
    When I search for phrase "<searchPhrase>"
    And I click on search icon
    And I can see numbers of results equals to "<expectedResults>"
    And I can see that every results which have been found contains phrase "<searchPhrase>"
    Then I select from Dropdown Sort by "<sortBy>"
    And I can see that results are correctly sorted by "<sortedBy>"

    Examples:
      | searchPhrase  | expectedResults | sortBy               | sortedBy             |
      | Printed Dress | 5               | Product Name: Z to A | Product Name: Z to A |
      | Printed Dress | 5               | Product Name: A to Z | Product Name: A to Z |
      | Printed Dress | 5               | Price: Highest first | Price: Highest first |
      | Printed Dress | 5               | Price: Lowest first  | Price: Lowest first  |
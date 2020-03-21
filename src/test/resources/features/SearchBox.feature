#/**
#* Test_Automation-automationpractice
#*
#* @author kamil.nowocin
#**/

@searchBox
Feature: A a user I would like to see results of searching phrase

  Background: Navigate to automationpractice.com website
    When I open home page

#--------------------------------------------------------------------------------
  @non-smoke @major @regression
  Scenario Outline:[1] As a user I would like to use search box and be able to see results of: <search phrase>
    Given I can see automationpractice.com website
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
  @non-smoke @major @regression
  Scenario Outline:[2] As a user I would like to use search box and be able to see sorted results by: <sort by>
    Given I can see automationpractice.com website
    When I search for phrase "<search phrase>"
    And I click on search icon
    And I can see numbers of results equals to "<expected results>"
    And I can see that every results which have been found contains phrase "<search phrase>"
    Then I select from Dropdown Sort by "<sort by>"
    And I can see that results are correctly sorted by "<sorted by>"

    Examples:
      | search phrase | expected results | sort by              | sorted by            |
      | Printed Dress | 5                | Product Name: Z to A | Product Name: Z to A |
      | Printed Dress | 5                | Product Name: A to Z | Product Name: A to Z |
      | Printed Dress | 5                | Price: Highest first | Price: Highest first |
      | Printed Dress | 5                | Price: Lowest first  | Price: Lowest first  |
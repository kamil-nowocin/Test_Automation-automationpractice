Feature: A a user I would like to see results of searching phrase

  Background: Navigate to Automationpractice.com website
    When I open home page

#--------------------------------------------------------------------------------
  Scenario Outline: As a user I would like to use search box and be able to see results
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
  Scenario: As a user I would like to use search box and be able to see results ordered by Product Name: Z to A
    Given I can see Automationpractice.com website
    When I search for phrase "Printed Dress"
    And I click on search icon
    And I can see numbers of results equals to "5"
    And I can see that every results which have been found contains phrase "Printed Dress"
    Then I select from Dropdown Sort by "Product Name: Z to A"
    And I can see that results are correctly sorted by "Product Name: Z to A"

#--------------------------------------------------------------------------------
  Scenario: As a user I would like to use search box and be able to see results ordered by Product Name: A to Z
    Given I can see Automationpractice.com website
    When I search for phrase "Printed Dress"
    And I click on search icon
    And I can see numbers of results equals to "5"
    And I can see that every results which have been found contains phrase "Printed Dress"
    Then I select from Dropdown Sort by "Product Name: A to Z"
    And I can see that results are correctly sorted by "Product Name: A to Z"

#--------------------------------------------------------------------------------
  Scenario: As a user I would like to use search box and be able to see results ordered by Price: Highest first
    Given I can see Automationpractice.com website
    When I search for phrase "Printed Dress"
    And I click on search icon
    And I can see numbers of results equals to "5"
    Then I select from Dropdown Sort by "Price: Highest first"
    And I can see that every results which have been found contains phrase "Printed Dress"
    And I can see that results are correctly sorted by "Price: Highest first"

#--------------------------------------------------------------------------------
  Scenario: As a user I would like to use search box and be able to see results ordered by Price: Lowest first
    Given I can see Automationpractice.com website
    When I search for phrase "Printed Dress"
    And I click on search icon
    And I can see numbers of results equals to "5"
    Then I select from Dropdown Sort by "Price: Lowest first"
    And I can see that every results which have been found contains phrase "Printed Dress"
    And I can see that results are correctly sorted by "Price: Lowest first"
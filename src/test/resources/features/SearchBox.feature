Feature: A a user I would like to see results of searching phrase

  Background: Navigate to Automationpractice.com website
    When I open home page

#--------------------------------------------------------------------------------
  Scenario Outline: As a user I would like to use search box and be able to see results
    Given I can see Automationpractice.com website
    When I search for phrase "<search phrase>"
    And I click on search icon
    Then I can see numbers of results equals to "<results>"
    Examples:
      | search phrase | results |
      | T-shirts      | 1       |
      | Blouses       | 1       |
      | Printed Dress | 5       |
      | !@#$%^        | 0       |

  @ignore
  Scenario: As a user I would like to use search box and be able to see results ordered by Product Name: Z to A
    Given I can see Automationpractice.com website
    When I search for phrase "Printed Dress"
    And I click on search icon
    And I can see numbers of results equals to "5"
    Then I select from Dropdown Sort by "Product Name: Z to A"
    And I can see that results are correctly sorted by "Product Name: Z to A"

  @ignore
  Scenario: As a user I would like to use search box and be able to see results ordered by Price: Lowest first
    Given I can see Automationpractice.com website
    When I search for phrase "Printed Dress"
    And I click on search icon
    And I can see numbers of results equals to "5"
    Then I select from Dropdown Sort by "Price: Lowest first"
    And I can see that results are correctly sorted by "Price: Lowest first"
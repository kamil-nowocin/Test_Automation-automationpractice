#/**
#* Test_Automation-automationpractice
#*
#* @author kamil.nowocin
#**/

@ignore
Feature: As a user I would like to buy new clothes from automationpractice.com - User is already successfully logged

  Background: Navigate to automationpractice.com website
    Given I open home page
    And I can see automationpractice.com website
    When I am logged as customer "thor.odinson@example.com" using "12345" password
    Then I can see welcome message

#--------------------------------------------------------------------------------
  Scenario: As a user I would like to buy new dress
    Given I am on MyAccount details page
    And I click on "Woman" button from content menu
    And I click on following product "Printed Dress"
    And I choose following details of my order
      | Quantity | Size | Colour |
      | 3        | M    | Blue   |
    When I click on Add To Cart button
    And I can see modal where I am able to see detailed data about my purchase
    And I click on Proceed To Checkout button
    And I can see Shopping-Cart "Summary" form with valid information
    And I click on Proceed To Checkout button
    And I can see Shopping-Cart "Address" form with valid information
    And I write comment about my order
    And I click on Proceed To Checkout button
    And I can see Shopping-Cart "Shipping" form with valid information
    And I choose a shipping option
    And I click on Terms of service checkbox
    And I click on Proceed To Checkout button
    And I can see Shopping-Cart Payment Method form
# Set "True" next to chosen payment method, rest have to be set as "False"
    Then I choose payment method
      | Status | Payment Method   |
      | True   | Pay by check     |
      | False  | Pay by bank wire |
    And I can see Shopping-Cart "Order Summary" form with valid information
    And I click on I Confirm My Order button
    And I can see Shopping-Cart "Order Confirmation" form with valid information
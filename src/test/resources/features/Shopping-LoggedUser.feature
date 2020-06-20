#/**
#* Test_Automation-automationpractice
#*
#* @author kamil.nowocin
#**/

@shopping
Feature: As a user I would like to buy new clothes from automationpractice.com - User is already successfully logged
#--------------------------------------------------------------------------------#
# [UserStory] https://tracker.FAKE.com/jira/browse/AUTOMATION_PRACTICE-666       #
#--------------------------------------------------------------------------------#

  Background: Navigate to automationpractice.com website
    Given I open home page
    And I can see automationpractice.com website
    When I am logged as customer "thor.odinson@example.com" using "12345" password
    Then I can see welcome message

#--------------------------------------------------------------------------------#
# [ZEPHYR] https://tracker.FAKE.com/jira/browse/AUTOMATION_PRACTICE-0039
# [ZEPHYR] https://tracker.FAKE.com/jira/browse/AUTOMATION_PRACTICE-0040
  @smoke @critical @regression
  Scenario Outline:[US-666]/[1] As a user I would like to buy new "<dress name>"
    Given I am on MyAccount details page
    And I click on "Women" button from sub menu
    And I click on following product "<dress name>"
    And I choose following details of my order
      | Quantity   | Size   | Colour   |
      | <quantity> | <size> | <colour> |
    When I click on Add To Cart button
    And I can see modal where I am able to see detailed data about my purchase
    And I click on Proceed To Checkout button (from modal)
    And I can see Shopping-Cart "Your shopping cart" form with valid information
    And I click on Proceed To Checkout button (from shopping-cart)
    And I can see Shopping-Cart "Addresses" form with valid information
    And I write comment about my order
    And I click on Proceed To Checkout button (from shopping-cart)
    And I can see Shopping-Cart "Shipping" form with valid information
    And I choose shipping option "My carrier"
    And I click on Terms of Service checkbox
    And I click on Proceed To Checkout button (from shopping-cart)
    And I can see Shopping-Cart "Your payment method" form with valid information
    Then I choose payment method
      | Payment Method   |
      | <payment method> |
    And I click on I Confirm My Order button
    And I can see Shopping-Cart "Order confirmation" form with valid information

    Examples: SCENARIO OUTLINE DATA
      | dress name                  | quantity | size | colour | payment method   |
      | Faded Short Sleeve T-shirts | 5        | M    | Blue   | Pay by check     |
      | Blouse                      | 2        | S    | Black  | Pay by bank wire |
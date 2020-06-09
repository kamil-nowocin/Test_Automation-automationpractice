#/**
#* Test_Automation-automationpractice
#*
#* @author kamil.nowocin
#**/

@customerService
Feature: As a user I would like to contact with customer service support
#--------------------------------------------------------------------------------#
# [UserStory] https://tracker.FAKE.com/jira/browse/AUTOMATION_PRACTICE-222       #
#--------------------------------------------------------------------------------#

  Background: Navigate to Contact Us page
    Given I open home page
    And I can see automationpractice.com website
    When I click on Contact Us button
    Then I can see Contact Us form

#--------------------------------------------------------------------------------#
# [ZEPHYR] https://tracker.FAKE.com/jira/browse/AUTOMATION_PRACTICE-0005
  @non-smoke @normal @regression
  Scenario:[US-222]/[1] As a user I am able to send request via contact us form, all inputs are filled up
    Given I am on Customer Service Contact Us page form
    When I choose Subject Heading "Customer service"
    And I write an email address in contact us page
    And I write order reference
    And I write message
    Then I click Send button
    And I can see success message "Your message has been successfully sent to our team."

#--------------------------------------------------------------------------------#
# [ZEPHYR] https://tracker.FAKE.com/jira/browse/AUTOMATION_PRACTICE-0006
  @non-smoke @normal @regression
  Scenario:[US-222]/[2] As a user I am able to send request via contact us form, all required inputs are filled up
    Given I am on Customer Service Contact Us page form
    When I choose Subject Heading "Customer service"
    And I write an email address in contact us page
    And I write message
    Then I click Send button
    And I can see success message "Your message has been successfully sent to our team."

#--------------------------------------------------------------------------------#
# [ZEPHYR] https://tracker.FAKE.com/jira/browse/AUTOMATION_PRACTICE-0007
  @smoke @critical @regression
  Scenario:[US-222]/[3] As a user I am able to send request via contact us form witch attached file
    Given I am on Customer Service Contact Us page form
    When I choose Subject Heading "Customer service"
    And I write an email address in contact us page
    And I write order reference
    And I choose file to attach
    And I write message
    Then I click Send button
    And I can see success message "Your message has been successfully sent to our team."

#--------------------------------------------------------------------------------#
# [ZEPHYR] https://tracker.FAKE.com/jira/browse/AUTOMATION_PRACTICE-0008
  @non-smoke @normal @regression
  Scenario:[US-222]/[4] As a user I am not able to send request via contact us form, email input is invalid
    Given I am on Customer Service Contact Us page form
    When I choose Subject Heading "Customer service"
    And I write an invalid email address in contact us page
    And I write order reference
    And I choose file to attach
    And I write message
    Then I click Send button
    And I can see error message "Invalid email address."

#--------------------------------------------------------------------------------#
# [ZEPHYR] https://tracker.FAKE.com/jira/browse/AUTOMATION_PRACTICE-0009
  @non-smoke @normal @regression
  Scenario:[US-222]/[5] As a user I am not able to send request via contact us form, subject is missing
    Given I am on Customer Service Contact Us page form
    When I don't choose Subject Heading
    And I write an email address in contact us page
    And I write order reference
    And I choose file to attach
    And I write message
    Then I click Send button
    And I can see error message "Please select a subject from the list provided."

#--------------------------------------------------------------------------------#
# [ZEPHYR] https://tracker.FAKE.com/jira/browse/AUTOMATION_PRACTICE-0010
  @non-smoke @normal @regression
  Scenario:[US-222]/[6] As a user I am not able to send request via contact us form, email address is missing
    Given I am on Customer Service Contact Us page form
    When I choose Subject Heading "Customer service"
    And I don't write an email address
    And I write order reference
    And I choose file to attach
    And I write message
    Then I click Send button
    And I can see error message "Invalid email address."

#--------------------------------------------------------------------------------#
# [ZEPHYR] https://tracker.FAKE.com/jira/browse/AUTOMATION_PRACTICE-0011
  @non-smoke @normal @regression
  Scenario:[US-222]/[7] As a user I am not able to send request via contact us form, message input is missing
    Given I am on Customer Service Contact Us page form
    When I choose Subject Heading "Customer service"
    And I write an email address in contact us page
    And I write order reference
    And I choose file to attach
    And I don't write message
    Then I click Send button
    And I can see error message "The message cannot be blank."

#--------------------------------------------------------------------------------#
# [ZEPHYR] https://tracker.FAKE.com/jira/browse/AUTOMATION_PRACTICE-0012
  @non-smoke @normal @regression
  Scenario:[US-222]/[8] As a user I am not able to send request via contact us form, all inputs are missing
    Given I am on Customer Service Contact Us page form
    When I click Send button
    Then I can see error message "Invalid email address."
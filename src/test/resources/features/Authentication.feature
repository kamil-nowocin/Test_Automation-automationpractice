#/**
#* Test_Automation-automationpractice
#*
#* @author kamil.nowocin
#**/

@authentication
Feature: As a user I would like to log in automationpractice.com
#--------------------------------------------------------------------------------#
# [UserStory] https://tracker.FAKE.com/jira/browse/AUTOMATION_PRACTICE-111       #
#--------------------------------------------------------------------------------#

  Background: Navigate to Login page
    Given I open home page
    And I can see automationpractice.com website
    And I click on Sign in button

#--------------------------------------------------------------------------------#
# [ZEPHYR] https://tracker.FAKE.com/jira/browse/AUTOMATION_PRACTICE-0001
  @smoke @critical @regression
  Scenario Outline:[US-111]/[1] As a user I can log into automationpractice.com using registered email "<email>" & password "<password>"
    Given I can see login form
    When I enter login "<email>"
    And I enter password "<password>"
    And I click on Submit button
    Then I can see welcome message

    Examples: SCENARIO OUTLINE DATA
      | email                    | password |
      | thor.odinson@example.com | 12345    |

#--------------------------------------------------------------------------------#
# [ZEPHYR] https://tracker.FAKE.com/jira/browse/AUTOMATION_PRACTICE-0002
# [ZEPHYR] https://tracker.FAKE.com/jira/browse/AUTOMATION_PRACTICE-0003
# [ZEPHYR] https://tracker.FAKE.com/jira/browse/AUTOMATION_PRACTICE-0004
  @non-smoke @normal @regression
  Scenario Outline:[US-111]/[2] As a user I can't log into automationpractice.com using email "<email>" & password "<password>"
    Given I can see login form
    When I enter login "<email>"
    And I enter password "<password>"
    And I click on Submit button
    Then I can see warning message with include "<warning message>"

    Examples: SCENARIO OUTLINE DATA
      | email                    | password | warning message           |
      | thanos.ALars@example.com | 12345    | Authentication failed     |
      | thor.odinson@example.com |          | Password is required      |
      |                          | 12345    | An email address required |
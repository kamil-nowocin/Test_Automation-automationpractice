#/**
#* Test_Automation-automationpractice
#*
#* @author kamil.nowocin
#**/

@socialMedia
Feature: As a user I would like to be redirected to social media pages from automationpractice.com
#--------------------------------------------------------------------------------#
# [UserStory] https://tracker.FAKE.com/jira/browse/AUTOMATION_PRACTICE-777       #
#--------------------------------------------------------------------------------#

  Background: Navigate to automationpractice.com website
    Given I open home page

#--------------------------------------------------------------------------------#
# [ZEPHYR] https://tracker.FAKE.com/jira/browse/AUTOMATION_PRACTICE-0041
# [ZEPHYR] https://tracker.FAKE.com/jira/browse/AUTOMATION_PRACTICE-0042
# [ZEPHYR] https://tracker.FAKE.com/jira/browse/AUTOMATION_PRACTICE-0043
# [ZEPHYR] https://tracker.FAKE.com/jira/browse/AUTOMATION_PRACTICE-0044
  @non-smoke @minor @regression
  Scenario Outline:[US-777]/[1] I click on social media "<platform>" logo
    Given I can see automationpractice.com website
    When I scroll the website until I can see "<platform>" logo
    And I click on "<platform>" logo button
    Then I am redirected to Selenium "<platform>" profile

    Examples: SCENARIO OUTLINE DATA
      | platform |
      | Facebook |
      | Twitter  |
      | YouTube  |
      | Google   |
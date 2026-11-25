
Feature:Login Test
Background:
Given User launch WebSite

@test1
Scenario:Login Validation
When user should reach to "https://practicetestautomation.com/practice-test-login/"
And User enter student and Password123 and Click on loginButton
Then user should reach to "https://practicetestautomation.com/logged-in-successfully/"

@test1
Scenario:Login Validation
When user should reach to "https://practicetestautomation.com/practice-test-login/"
And User enter student1 and Password123 and Click on loginButton
Then user should reach to "https://practicetestautomation.com/logged-in-successfully/"


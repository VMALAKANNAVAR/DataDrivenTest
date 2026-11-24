@test2
Feature:Tester

Background:
Given User launch WebSite

Scenario Outline:Login Test
When user should reach to "https://practicetestautomation.com/practice-test-login/"
And User enter <USN> and <PSW> and Click on loginButton
Then user should reach to "https://practicetestautomation.com/logged-in-successfully/"
Examples:
    |USN|PSW|
    |student|Password123 |
    |Student|Password123 |
    |student|Password1234|
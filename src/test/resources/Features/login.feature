Feature: Validate login functionality

  @test
  Scenario Outline: Test Login functionality of the application
    Given User is on the home page of the application
    When   user click on login button
    When  user enter the "<username>" and "<password>"
    And   user click on submit button
    Then verify user is logged in
    Then Close the Browser
    Examples:
    |username                  |password           |
    |    rahul269406@gmail.com |     Sakshi@1988   |
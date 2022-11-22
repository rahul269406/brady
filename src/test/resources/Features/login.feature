Feature: Validate login functionality and given scenarios

  @test
  Scenario Outline: Test Login functionality of the application
    Given User is on the home page of the application
    When   user click on login Icon
    When  user enter the "<username>" and "<password>"
    And   user click on login button
    Then verify user is logged in
    When  user click on asia tab
    When  user search for "<Exchange Name>" exchange and Find the last exchange rate
    When  User find the last three exchange rates for "<Exchange Name>"  for a period of one minute
    Then  Sign Out from application
    Then Close the Browser
    Examples:
    |username                  |password  |Exchange Name|
    |    rahul269406 |     Nimisha@1988   |       GBPJPY|
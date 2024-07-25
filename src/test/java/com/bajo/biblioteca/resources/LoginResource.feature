#encoding: UTF-8
#language: pt-br

Feature: Login

  @successfulLogin
  Scenario: Successful Login
    Given a registered user with email "valid@email.com" and password "secret"
    When the user enters their credentials
    Then the system should return a valid JWT token
    And the token should have a valid expiration date

  @unsuccessfulLogin
  Scenario: Invalid Credentials
    Given a registered user with email "valid@email.com" and password "secret"
    When the user enters invalid credentials
    Then the system should return a 401 Unauthorized status code
    And the response should contain an error message

  @unsuccessfulLogin
  Scenario: User Not Found
    Given no user exists with email "invalid@email.com"
    When the user enters the email "invalid@email.com" and any password
    Then the system should return a 401 Unauthorized status code
    And the response should contain an error message

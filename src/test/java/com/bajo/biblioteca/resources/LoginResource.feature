Feature: Login

  Scenario: Successful login
    Given a registered user
    When the user enters valid credentials
    Then the system should return a valid JWT token

  Scenario: Failed login with invalid credentials
    Given a registered user
    When the user enters invalid credentials
    Then the system should return an unauthorized error message

  Scenario: Internal server error during token generation
    Given a registered user
    When the user enters valid credentials
    Then the system should return an internal server error message


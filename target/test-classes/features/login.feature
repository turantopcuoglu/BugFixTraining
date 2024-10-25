Feature: Login Scenarios

  Scenario: Successfully Login
    Given fill user "email"
    And fill "user" password
    And click login button
    Then verify successfully login
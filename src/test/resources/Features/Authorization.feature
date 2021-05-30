Feature: Authorization

  @automated @smoke
  Scenario: Authorization with valid data
    Given User sign in with login 'maksan' and password 'Qwerty$123'
    Then I see main page

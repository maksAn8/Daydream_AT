Feature: Change language

  Background:
    Given User sign in with login 'maksan' and password 'Qwerty$123'

  Scenario Outline: Change language
    When I select '<language>' language in dropdown
    Then Language became '<language>'
    And I log out
    Then Language became '<language>'

    Examples:
      | language |
      | ru       |
      | en       |
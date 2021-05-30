Feature: Change theme

  Background:
    Given User sign in with login 'maksan' and password 'Qwerty$123'

  @automated @smoke
  Scenario Outline: Change theme
    When I select '<theme>' theme in dropdown
    And I log out
    Then Theme became '<theme>'

    Examples:
      | theme |
      | Dark  |

Feature: Delete Person in table

  Background:
    Given User sign in with login 'maksan' and password 'Qwerty$123'

  @automated @smoke
  Scenario: Delete Person in table
    When I see table with data from 'MongoDB'
    And I delete Person
    Then I check Person was deleted in data base 'MongoDB'

  @automated @smoke
  Scenario: Delete Person in table
    When I see table with data from 'SQLite'
    And I delete Person
    Then I check Person was deleted in data base 'SQLite'
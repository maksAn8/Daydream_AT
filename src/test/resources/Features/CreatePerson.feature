Feature: Create Person in table

  Background:
    Given User sign in with login 'maksan' and password 'Qwerty$123'

  @automated @smoke
  Scenario: Create Person in table
    When I see table with data from 'MongoDB'
    And I create Person
    Then I check Person was added to data base 'MongoDB'

  @automated @smoke
  Scenario: Create Person in table
    When I see table with data from 'SQLite'
    And I create Person
    Then I check Person was added to data base 'SQLite'

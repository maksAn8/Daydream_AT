Feature: Update Person in table

  @automated @smoke
  Scenario Outline: Update Person in table
    When I see table with data from 'MongoDB'
    And I change '<column_name>' to '<value>'
    Then I refresh page and check '<column_name>' = '<value>'

    Examples:
      | column_name  | value             |
      | Fname        | atFname           |
      | Lname        | atLname           |
      | Age          | 25                |
      | City         | atCity            |
      | Phone number | +3801234567       |
      | Email        | at.Email@test.com |
      | Company name | atCompany         |

  @automated @smoke @last
  Scenario Outline: Update Person in table
    When I see table with data from 'SQLite'
    And I change '<column_name>' to '<value>'
    Then I refresh page and check '<column_name>' = '<value>'

    Examples:
      | column_name  | value             |
      | Fname        | atFname           |
      | Lname        | atLname           |
      | Age          | 25                |
      | City         | atCity            |
      | Phone number | +3801234567       |
      | Email        | at.Email@test.com |
      | Company name | atCompany         |
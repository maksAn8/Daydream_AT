Feature: User registration

  Background:
    Given Registration page is opened

  Scenario Outline: User registration with valid login and password
    When I enter login '<login>' and password '<password>'
    And I confirm password
    Then I see authorization page

    Examples:
      | login                | password       |
      | test                 | qwertyui123    |
      | TEST                 | qwertyui123    |
      | Qwerty123            | qwertyui123    |
      | 12345678901234567890 | qwertyui123    |
      | test1                | qwertyui       |
      | test2                | 12345671234567 |
      | test3                | QWERTYUI       |
      | test4                | Qwerty123      |
      | test5                | Qwerty$123     |


  Scenario Outline: User registration with invalid login
    When I enter login '<login>' and password '<password>'
    And I confirm password
    Then I see error message

    Examples:
      | login                 | password    |
      | tes                   | qwertyui123 |
      | 123456789012345678901 | qwertyui123 |
      |                       | qwertyui123 |
      | test 123              | qwertyui123 |
      | test_1                | qwertyui123 |
      | test2.                | qwertyui123 |
      | test$3                | qwertyui123 |

  Scenario Outline: User registration with invalid password
    When I enter login '<login>' and password '<password>'
    And I confirm password
    Then I see error message

    Examples:
      | login | password     |
      | User1 | 123456       |
      | User2 |              |
      | User3 | пароль       |
      | User4 | qwertyui 123 |
      | User4 | qwertyГы123  |

  Scenario: User registration without password confirmation
    When I enter login 'testlogin' and password 'testpassword'
    Then I see error message

  Scenario: User registration with empty fields
    Then I see error message

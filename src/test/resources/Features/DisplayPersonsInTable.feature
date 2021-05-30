Feature: Display Persons in table

  @automated @smoke
  Scenario Outline: Display Persons in table
    Then I see table with data from '<data_base>'

    Examples:
      | data_base |
      | MongoDB   |
      | SQLite    |

Feature: Feature to test delete
  @Tugas #Delete user with valid id
  Scenario Outline: Delete user with valid id
    Given Delete user with valid <id>
    When Send request delete user
    Then Should return 204 no content
    Examples:
    |id|
    |1 |
    |2 |


  @Tugas #Delete user with invalid id
  Scenario Outline: Delete user with invalid id
    Given Delete user with invalid <id>
    When Send request delete user
    Then Should return 204 no content
    Examples:
      |id|
      |600 |
      |100 |
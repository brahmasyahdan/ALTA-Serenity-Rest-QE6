Feature: Feature to test put
  @Tugas #Put update user with valid id
  Scenario Outline: Put update user with valid id
    Given Put update user with id <id>
    When Send request put update user
    Then Should return 200 ok
    And Response body should contain name "<name>" and job "<job>"
    And Put json schema validator
    Examples:
      |id|     name  |  job  |
      |1 |Bhasri Edit|QA Edit|

  @Tugas #Put update user with invalid id
  Scenario Outline: Put update user with invalid id
    Given Put update user with id <id>
    When Send request put update user
    Then Should return 200 ok
    And Response body should contain name "<name>" and job "<job>"
    And Put json schema validator
    Examples:
      |id  |     name  |  job  |
      |167 |Bhasri Edit|QA Edit|

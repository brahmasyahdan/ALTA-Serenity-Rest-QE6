Feature: Feature to test patch
  @Tugas #Patc user with valid id
  Scenario Outline: Patch update user with valid id
    Given Patch update user with id <id>
    When Send request patch update user
    Then Should return 200 ok
    And Response body should contain name "<name>" and job "<job>"
    And Patch json schema validator
    Examples:
    |id|     name  |  job  |
    |2 |morpheus|zion resident|
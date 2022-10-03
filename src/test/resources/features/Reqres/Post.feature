Feature: Feature to test post
  @Tugas #Post create new user with valid login
  Scenario Outline:Post create new user with valid login
    Given Post create new user
    When Send request post create new user
    Then Should return 201 created
    And Response body should contain name "<name>" and job "<job>"
    And Post json schema validator
    Examples:
    |name|job|
    |Bhasri|QA Enginer|


  @Tugas #Post new user create without name
  Scenario Outline:Post create new user without name
    Given Post create new user without name
    When Send request post create new user
    Then Should return 201 created
    And Response body should contain name "<name>" and job "<job>"
    And Post json schema validator
    Examples:
      |name|job|
      ||QA Enginer|



  @Tugas #Post new user create without job
  Scenario Outline:Post create new user without job
    Given Post create new user without job
    When Send request post create new user
    Then Should return 201 created
    And Response body should contain name "<name>" and job "<job>"
    And Post json schema validator
    Examples:
      |name|job|
      |Bhasri||


  @Tugas #Post new user create without name job
  Scenario Outline:Post create new user without name job
    Given Post create new user without name job
    When Send request post create new user
    Then Should return 201 created
    And Response body should contain name "<name>" and job "<job>"
    And Post json schema validator
    Examples:
      |name|job|
      |||


  @Tugas #Post register user successful
  Scenario Outline: Post register user successful
    Given Post register user
    When Send Request post register user
    Then Should return 200 ok
    And Response body should contain id <id> and token "<token>"
    And Post register json schema validator
    Examples:
    |id |        token         |
    | 4 |  QpwL5tke4Pnpja7X4   |



  @Tugas #Post register user unsuccessful
  Scenario Outline: Post register user unsuccessful
    Given Post register user unsuccessful
    When Send Request post register user
    Then Should return 400 bad request
    And Response body should contain error "<error>"
    And Post register unsuccessful json schema validator
    Examples:
      |error |
      | Missing password|



  @Tugas #Post login successful
  Scenario Outline: Post login successful
    Given Post login successful
    When Send Request post login successful
    Then Should return 200 ok
    And Response body should contain token "<token>"
    And Post login successful json schema validator
    Examples:
    |      token      |
    |QpwL5tke4Pnpja7X4|


  @Tugas #Post login unsuccessful
  Scenario Outline: Post login unsuccessful
    Given Post login unsuccessful
    When Send Request post login unsuccessful
    Then Should return 400 bad request
    And Response body should contain error "<error>"
    And Post login unsuccessful json schema validator
    Examples:
      |      error     |
      |Missing password|

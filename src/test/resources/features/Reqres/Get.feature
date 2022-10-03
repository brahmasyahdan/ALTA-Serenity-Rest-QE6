Feature: Feature to test get

  @Tugas #Get list user with valid parameter
  Scenario Outline: Get list user with valid parameter page
    Given Get list user with valid parameter page <page>
    When Send request get list user
    Then Should return 200 ok
    And Response body page should be page <page>
    And Get list user json schema validator
    Examples:
      |page|
      | 1  |
      | 2  |


  @Tugas #Get single user
  Scenario Outline: Get single user
    Given Get single user with id <id>
    When Send request get single user
    Then Should return 200 ok
    And Response body id should be id <id>
    Examples:
      | id |
      |  2 |
      |  3 |

  @Tugas # Get single user not found
  Scenario Outline: Get single user not found
    Given Get single user with not found id <id>
    When Send request get single user
    Then Should return 404 not found
    Examples:
      |id|
      |23|

  @Tugas # Get list single resource
  Scenario Outline: Get list single resource with valid page
    Given Get list single resource with id <id>
    When Send request get list single resource
    Then Should return 200 ok
    And Response body should contain id <id> , name "<name>"
    And Get list resource json schema validator
    Examples:
    |id|  name      |
    |1 |cerulean    |
    |2 |fuchsia rose|

  @Tugas
  Scenario Outline: Get list resource not found
    Given Get list single resource not found id <id>
    When Send request get list single resource
    Then Should return 404 not found
    Examples:
    |id|
    | 23|
    | 42|
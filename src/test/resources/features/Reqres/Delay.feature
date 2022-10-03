Feature: Feature to test delay
  @Tugas #Test Delay
  Scenario: Get list user delay
    Given Get list user with delay 3
    When Send request get user
    Then Should return 200 ok

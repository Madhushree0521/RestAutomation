Feature: Validate the booking get and post api

  @API
  Scenario: Verify if user could complete the booking
    When user hits the booking api with the expected response code as "200"
    Then user hits the booking get api to confirm on the booking with the expected response code as "200"
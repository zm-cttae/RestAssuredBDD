Feature: Summary
  Scenario: Can get a summary response
    Given I set content type to Json
    When I send a GET request to summary method
    Then status code should be 200

  Scenario: Required component keys are present
    Given I set content type to Json
    When I send a GET request to summary method
    Then component keys should be present

  Scenario: Component values are the expected format
    Given I set content type to Json
    When I send a GET request to summary method
    Then component values are the correct format

  Scenario: Can get a specific component status
    Given I set content type to Json
    When I send a GET request to summary method
    Then component statuses should be operational

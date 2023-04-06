Feature: homepage

  Scenario: movita logo
    Given user is homepage
    When  user clicks movitalogo
    Then  user should see the Text

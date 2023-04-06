Feature: login functionality

  Scenario: login with true credentials
    Given user on homepage
    When user clicks My Account Link
    And user clicks Login Link
    Then Login page should be visible

    When user fill the login form with the following data
      | username | deneme@deneme.com |
      | password | deneme            |
    And user clicks Login button
    Then login should be succesfull


  Scenario: login with false credentials
    Given user on homepage
    When user clicks My Account Link
    And user clicks Login Link
    Then login should be succesfull

    When user fill the login form with the following data
      | username | xyzabc123@gmail.com |
      | password | 12345               |
    And user clicks Login button
    Then Warning message with the text 'Warning: No match for E-Mail Address and/or Password.' should be displayed


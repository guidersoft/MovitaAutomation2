# @login2 diyerek Runner classta tagname = "@login2", şeklinde sadece bu Feature dosyasını run edebilriz.
Feature: login functionality 2

  Scenario Outline: login 2
    Given user on homepage
    When user clicks the following links with the text
      | My Account |
      | Login      |
    Then Login page should be visible


    When user fill the login form with the following data
      | username | <username> |
      | password | <password> |
    And user clicks Login button
    Then login should be "<succes>"

    Examples:
      | username           | password | succes |
      | deneme@deneme.com  | deneme   | true   |
      |                    |          | false  |
      | deneme@deneme.com  |          | false  |
      |                    | deneme   | false  |
      | deneme@deneme.com  | deneme   | true   |
      | deneme@deneme.com  | deneme1  | false  |
      | deneme1@deneme.com | deneme   | false  |
      | a                  | a        | false  |

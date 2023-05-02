@TestCaseKey=MVT-T86
Feature: Default view of the Login page

  Background: : Default view of the Login page
    Given user on homepage
    Given user on login Page

  Scenario: username and password
    Then should see two separate fields for username and password.

  Scenario: text it must be visible
    Then The text "Movita Vehicle Tracking and Tracing System" it must be visible

  Scenario: Movita logo visible
    Then Movita logo above it must be visible

  Scenario: button color asserting
    Then There should be a "Giriş Yap" button in blue colour in the form of a long bar.

  Scenario: link should be available.
    Then "Şifrenizi mi unuttunuz?" link should be available.
    And and when hover over, the colour of the text should change from blue to green and it should be clickable

  Scenario:footer section.
    Then "Bütün Hakları Saklıdır." should be written in the footer section.

  Scenario: link should navigate to the Home page
    Then There should be a "Ana sayfaya dön" link in the top right corner and when clicked it should navigate to the Home page
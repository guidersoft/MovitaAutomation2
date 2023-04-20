Feature: Login Page

  @LoginPage
  Scenario: login
    Given user is homepage
    When  user clicks giris yap menu
    And   user type the text as a fallowing table

      | username    | password    | Status |
      | demomovita1 | 1192movita  | false  |
      | demomovita  | 1192movita1 | false  |
      | demomovita1 | 1192movita1 | false  |
      | demomovita  |             | false  |
      |             | 1192movita  | false  |
      |             |             | false  |
      | demomovita  | 1192movita  | true   |

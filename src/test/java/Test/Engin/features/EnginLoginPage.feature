Feature: Login Page

  @LoginPage
  Scenario: login
    Given user is homepage
    When  user clicks giris yap menu
    And   user type the text as a fallowing table

      | username    | password    | Status |
      | demomovita1 | 1192movita  | false  |
      | demomovita  | 1192movita1 | false  |
      | demomovita  | 1192movita  | true   |
      | demomovita1 | 1192movita1 | false  |
      | demomovita  |             | false  |
      |             | 1192movita  | false  |
      |             |             | false  |
    @LoginPageFeatures
    Scenario: Login Page features
      Given user is homepage
      When  user clicks giris yap menu
      And   user should see two input feld
      And   user should see Logo und the text"Movita Vasıta İzleme Takip Sistemi"
      And   user should see Giris Yap button
      And   user should see above the Giris Yap button the text"Şifrenizi mi unuttunuz?"
      And   the Buttons color should be chance and be clickable
      And   user should see "Ana sayfaya dön"
      Then  user should see "Copyright © 2017 - 2022"
      And   user clicks the button






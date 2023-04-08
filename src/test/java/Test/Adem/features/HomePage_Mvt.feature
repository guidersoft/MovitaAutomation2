Feature: Movita Homepage

  Background: Homepage
    When user is on homepage

  Scenario: Movita logo
    When user should clicks movita logo
    Then user should see the text


  Scenario: Language option on Homepage
    Given Clickable olmali
    When Kullanıcı "English" butonuna tıklar
    And "Mobile Vehicle" yazisi gözükmeli
    When Kullanıcı "Türkçe" butonuna tıklar
    Then "Mobil Vasıta" yazisi gözükmeli
    








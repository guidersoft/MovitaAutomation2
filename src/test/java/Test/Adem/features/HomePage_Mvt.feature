Feature: Movita Homepage

  Background: Homepage
    When user is on homepage

  Scenario: Movita logo
    When user should clicks movita logo
    Then user should see the text


  Scenario: Anasayfadaki dil seçenegi butonu
    Given Clickable olmali
    When Kullanıcı "English" butonuna tıklar
    And English “Mobile Vehicle Tracking System” yazisi gözükmeli
    When Kullanıcı "Türkçe" butonuna tıklar
    Then Türkce “Mobil Vasita izleme takip Sistemi” yazisi gözükmeli





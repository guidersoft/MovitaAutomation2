Feature: Movita Homepage

    Background: user on homepage
    Given user is on homepage
    When user should clicks movita logo
    Then user should see the text


  Scenario: Anasayfadaki dil seçenegi butonu clickable olmali
    Given Clickable olmali
    When Iki secenegi click yapabilmeli:
    And English “Mobile Vehicle Tracking System” yazisi gözükmeli
    Then Türkce “Mobil Vasita izleme takip Sistemi” yazisi gözükmeli


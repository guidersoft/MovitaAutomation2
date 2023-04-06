Feature: Movita Test

  Scenario: movita logosu clickable olmali

    Given user on "https://www.movita.com.tr" page
    Then click yapinca "Mobil Vasita izleme takip Sistemi" yazisi ekranda cikmali


  Scenario: Anasayfadaki dil seçenegi butonu clickable olmali
    Given Clickable olmali
    When Iki secenegi click yapabilmeli:
    And English “Mobile Vehicle Tracking System” yazisi gözükmeli
    Then Türkce “Mobil Vasita izleme takip Sistemi” yazisi gözükmeli


  Scenario: ANA SAYFA

    Given Ana sayfa linkine hover over olunca yazisi renk degistirmeli
    When Clickable olmalidir
    Then Click yapınca “Mobil Vasita izleme takip Sistemi” yazisi ekranda cikmali




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


  Scenario: Ana Sayfa
    When user hover "Ana Sayfa"
    And user click "Ana Sayfa"
    And user should see "Mobil Vasita izleme takip Sistemi" text


  @aktifTag
  Scenario: Kurumsal
    When user hover "Kurumsal"
    Then "Kurumsal" menusu altında 6 seçenek çıkmalı
    When user click "Kurumsal"
    And kullanici "Kurumsal" altındaki submenulere Hover Yapar
    #Then user should see the text "Hakkımızda"
    # submenudeki "demo başvru" yanlış yazılmış
    And kullanici "Kurumsal" altindaki "Demo Başv" submenulere click yapar
    Then kullanici "Demo Başv" yazisini görmeli



















    








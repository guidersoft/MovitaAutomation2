Feature: Alar Islemleri
  @Alarm_Islemleri
  Scenario: Alarm Islemi Functional and Nonfunctional

    When  user is homepage
    When  user clicks giris yap menu
    And   user Login whit a valid username and password
    And   user clicks "Alarm İşlemleri" on the asideMenu
    And   user should have logged in Alarm
    And   user click Detayli Arama button
    Then  user shoul see "Alarm Kodu"
    Then  user shoul see "Açıklama"
    Then  user shoul see "Alarm Tipi"
    And   user click Alarm Ekle button
    Then  user should see as "Alarm Tipi"
    Then  user should see as "Sms Bildirim"
    Then  user should see as "Bölgede Kalma Süresi"
    Then  user should see as "Bir Sonraki Bölgeye Max Varma"





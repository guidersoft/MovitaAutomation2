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
    And  user should see as "Alarm Tipi"
    And  user should see as "Sms Bildirim"
    And  user should see as "Bölgede Kalma Süresi"
    And  user should see as "Bir Sonraki Bölgeye Max Varma"
    And  user should see on the page "Alarm Bilgisi"
    And  user should see fallowing
      | Alarm Tipi 1   | Bölge İhlali      |
      | Alarm Tipi 2   | Bölge Giriş/Çıkış |
      | Alarm Tipi 3   | Hız Limiti        |
      | Alarm Tipi 4   | Mesai             |
      | SMS Bildirim 1 | Gönderilsin       |
      | SMS Bildirim 2 | Gönderilmesin     |
      | Günler 1       | Pazartesi         |
      | Günler 2       | Salı              |
      | Günler 3       | Çarşamba          |
      | Günler 4       | Perşembe          |
      | Günler 5       | Cuma              |
      | Günler 6       | Cumartesi         |
      | Günler 7       | Pazar             |
    And Alarm should be saved


    Then user driver quit






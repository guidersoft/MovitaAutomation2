
Feature: Alarm İşlemleri

  Background: User on HomePage
    Given user on homepage
    And user on login Page

  @TestCaseKey=MVT-T128
  Scenario: Alarm İşlemleri Genel Alanlar
    Given user on accaunt Page
    When kulanici Alarm İşlemleri'e tıklar,
    Then Alarm Listesi sayfasında olduğunu doğrular,
    And "Detaylı Filtre"ye tıklar, "Alarm Kodu", "Açıklama" ve "Alarm Tipi"nin görüntülendiğini doğrular,
    When "Alarm Ekle" düğmesine tıklar,
    Then "Açıklama", "Alarm Tipi", "Sms Bildirim", "Aktif Günler", "Bölgede Kalma Süresi", "Bir Sonraki Bölgeye Max Varma Süresi(Dk)" ve "Bölgeye Varış/Kalma Süre İhlali Cezası(Tutar/Puan)" alanlarının görüntülendiğini doğrular,
    And "Alarm Tipi" filtresi için "Bölge İhlali", "Bölge Giriş/Çıkış", "Hız Limiti" ve "Mesai" gibi seçeneklerin bulunduğunu doğrular,
    And "Sms Bildirim" filtresi için "Gönderilsin" ve "Gönderilmesin" gibi seçeneklerin bulunduğunu doğrular,
    And "Aktif Günler" filtresinde haftanın tüm günlerini, hafta sonları dahil olmak üzere seçebilir olduğunu doğrular,
    Then Asağıdaki alarm bilgileri ile bir alarm kaydeder,
      | aciklama                               | Baris          |
      | alarmTipi                              | Mesai          |
      | SMSBildirimTipi                        | Gönderilmesin  |
      | bolgedeKalmaSuresi_dakika              | 5              |
      | birSonrakiBolgeyeMaxVarmaSuresi_dakika | 5              |
      | ihlalCezasi                            | 30             |
      | aktifgunler                            | Pazartesi,Salı |
    And Eklenen Alarm Alarm Listesinde olduğunu doğrular
    And Eklenen alarmın düzenlenebilir olduğunu doğrular
    And Eklenen alarmın silinebilir olduğunu doğrular
Feature:Alarm Islemleri

  Background: login
    Given  user logs in form with the following data
      | username | demomovita |
      | password | 1192movita |

  Scenario: Functionality of the Alarm Islemleri

    When User click on the "Alarm Islemleri"
    And  User click "Detayli Filtre" button in the top right corner of the page
    Then User should see following fields "Alarm Kodu", "Açıklama" and "Alarm Tipi"
    When User click on the "Alarm Ekle" link in the top of the page
    Then User should see "Dikkat" red text warning
    Then User should see following fields
      | Açıklama                                           |
      | Alarm Tipi                                         |
      | Sms Bildirim                                       |
      | Aktif Günler                                       |
      | Bölgede Kalma Süresi (Dk)                          |
      | Bir Sonraki Bölgeye Max Varma Süresi(Dk)           |
      | Bölgeye Varış/Kalma Süre İhlali Cezası(Tutar/Puan) |
    And  User click on the "Alarm Tipi" box
    Then User should see following fields in the dropdown menu.
      | Bölge ihlali      |
      | Bölge Giriş/Çıkış |
      | Hız Limiti        |
      | Mesai             |
    And  User click on the "SMS Bildirimi" box
    Then User should see following fields in the dropdown menu.
      | Gönderilsin   |
      | Gönderilmesin |
    And  User click on the "Aktif Günler" box
    Then User should be able to select all days of the week.
    And  User click on the  "Kaydet" button
    Then user should see that the created alarm has been registered
    When User click on the "Alarm Listesi" button in the top of the page
    Then User should see all alarms and on the page right two button for "edit" and "delete"
    And  User clicks on the pencil icon
    Then User should see "Dikkat" red text warning
    And  User clicks on the garbage icon
    Then The alarm must be deleted.

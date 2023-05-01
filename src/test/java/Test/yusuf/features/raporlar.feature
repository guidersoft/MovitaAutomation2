Feature: User page main menu

  Background: login
    Given  user logs in form with the following data
      | username | demomovita |
      | password | 1192movita |


  @rapor
  Scenario: verify raporlar menu
    Given user click on the "Raporlar" in main menu
    Then  user should see 11 submenu under the "Raporlar"
    When  user click on the sub menu and assert changed color
      | Araç Bazlı Rapor         |
      | Yakıt Entegrasyon Raporu |
      | Günlük Seyahat Raporu    |
      | Aktivite Detay Raporu    |
      | Araç Karne               |
      | Filo Bazlı Rapor         |
      | Grup Bazlı Rapor         |
      | Alarm Log Raporu         |
      | Şoför Log Raporu         |
      | Sensör Log Raporu        |
      | Arıza Log Raporu         |
    Then  user should see 11 submenu under the "Raporlar"




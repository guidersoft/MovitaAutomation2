Feature: Arac Bazli Rapor

  Scenario:Raporlar
    Given user is homepage
    When  user clicks giris yap menu
    And  user Login whit a valid username and password
    Given user clicks "Raporlar" on the asideMenu
    When  user clicks "Araç Bazlı Rapo" on the sunMenu
    And  user select "2020.01.01" and "2023.04.01"
    And  user clicks "Detaylı Filtre" on the asideMenu
    Then  user should see the Table


  Scenario: Detayli Arama Tarih
    Given user enters the date in the "tarih_filter" field as a "2021"
    When  user enters the date in the "tarih_filter" field as a "2022-10"
    And   user enters the date in the "tarih_filter" field as a "2022-10-12"

  Scenario: Detayli Arama Ise Baslama
    Given user enters the date in the "is_baslama_filter" field as a "09"
    When  user enters the date in the "is_baslama_filter" field as a "09-06"
    And   user enters the date in the "is_baslama_filter" field as a "09-07-31"

  Scenario: Detayli Arama Is Bitis
    Given user enters the date in the "is_bitis_filter" field as a "09"
    When  user enters the date in the "is_bitis_filter" field as a "09-07"
    And   user enters the date in the "is_bitis_filter" field as a "09-07-49"

  Scenario: Detayli Arama Kombination
    Given user enters the date in the "tarih_filter" field as a "2021" and "is_baslama_filter" as a "09-06-31"
    When  user enters the date in the "tarih_filter" field as a "2021" and "is_bitis_filter" as a "04-36-24"
    Then  user enters the date in the "tarih_filter" field as a "2021" and "is_baslama_filter" as a "12-30-52" and "is_bitis_filter" field as a "23-59-13"

  Scenario: quit driver
    Then  user driver quit





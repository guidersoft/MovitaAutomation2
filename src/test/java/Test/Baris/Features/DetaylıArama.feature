Feature: Detayli Arama func

  Background: Detayli Arama Background Scenario
    Given user on homepage
    And user on login Page
    And user successfully logs in with followind data
      | username          | demomovita |
      | password          | 1192movita |
      | verification text | Demo Filo  |
    And user clicks "Raporlar" link
    And user clicks "Araç Bazlı Rapor" link
    Then user confirms that he is on the desired page
    When the user selects start date and finish date from the following table
      | Start Date  | 2021-01-01 |
      | Finish Date | 2022-12-31 |
    And user clicks "Rapor Al" links

  Scenario:Control of Detaylı Filtre inputs
    Given user clicks "Detaylı Filtre" link
    Then The input field in the following table must be verified to be side by side
      | Tarih       |
      | İşe Başlama |
      | İş Bitiş    |


  Scenario:Placeholder control of the Tarih entry
    Then The format of the data to be entered as "Tarih"  should be shown to the user as "yyyy-MM-dd".


  Scenario: Data entry control to Tarih Section
    When the user selects start date and finish date from the following table
      | Start Date  | 2021-01-01 |
      | Finish Date | 2022-12-31 |
    And user clicks "Rapor Al" links

  @Detayli
  Scenario: Functionality of the inputs of the Detayli Arama section
    When user clicks "Detaylı Filtre" link
    And User sends Date value to the "Tarih" section of the Detayli Arama section
      | 2021       |
      | 2021-11    |
      | 2021-11-05 |
    And User sends starttime value to the "İşe Başlama" section of the Detayli Arama section
      | 12         |
      | 00:00      |
      | 2021-11-05 |

    And User sends finishtime value to the "İş Bitiş" section of the Detayli Arama section
      | 23       |
      | 23:59    |
      | 23:59:18 |



Feature: Testing of the 'Detaylı Arama' function in 'Araç Bazlı Raporlar'

  Background: Clicks Until 'Araç Bazlı Rapor' link
    Given user on homepage
    And user on login Page
    And user on accaunt Page
    And user clicks "Raporlar" link
    And user clicks "Araç Bazlı Rapor" link


  Scenario: : Control of 'Detaylı Filtre' inputs
    Given user clicks "Detaylı Filtre" link
    Then The input field in the following table must be verified to be side by side
      | Tarih       |
      | İşe Başlama |
      | İş Bitiş    |

  Scenario:Placeholder control of the 'Tarih' entry
    Given user clicks "Detaylı Filtre" link
    Then The format of the data to be entered as "Tarih"  should be shown to the user as "yyyy-MM-dd".

  Scenario Outline: Functionality of the inputs of the 'Detayli Arama' section
    When the user selects start date and finish date from the following table
      | Start Date  | 2021-01-01 |
      | Finish Date | 2022-12-31 |
    And user clicks "Rapor Al" links
    And user clicks "Detaylı Filtre" link
    And User sends to the "<Tarih text>" value "<Tarih>" section of the Detayli Arama section
    And User sends to the "<İşe Başlama text>" value "<İşe Başlama>" section of the Detayli Arama section
    And User sends to the "<İş Bitiş text>" value "<İş Bitiş>" section of the Detayli Arama section
    Then The ordered list with the text "<Tarih text>" or "<İşe Başlama text>" or "<İş Bitiş text>" should be visible
    Examples:
      | Tarih text | Tarih | İşe Başlama text | İşe Başlama | İş Bitiş text | İş Bitiş |
      | 2022       | Tarih |                  | İşe Başlama |               | İş Bitiş |
      | 2022-10    | Tarih |                  | İşe Başlama |               | İş Bitiş |
      | 2022-10-12 | Tarih |                  | İşe Başlama |               | İş Bitiş |
      |            | Tarih | 09               | İşe Başlama |               | İş Bitiş |
      |            | Tarih | 09:06            | İşe Başlama |               | İş Bitiş |
      |            | Tarih | 09:06:31         | İşe Başlama |               | İş Bitiş |
      |            | Tarih |                  | İşe Başlama | 09            | İş Bitiş |
      |            | Tarih |                  | İşe Başlama | 09:07         | İş Bitiş |
      |            | Tarih |                  | İşe Başlama | 09:07:49      | İş Bitiş |
      | 2022-10-12 | Tarih | 09:06:31         | İşe Başlama |               | İş Bitiş |
      | 2022-10-12 | Tarih |                  | İşe Başlama | 09:07:49      | İş Bitiş |
      |            | Tarih | 09:06:31         | İşe Başlama | 09:07:49      | İş Bitiş |
      | 2022-10-12 | Tarih | 09:06:31         | İşe Başlama | 09:07:49      | İş Bitiş |







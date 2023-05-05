Feature: Detayli Arama func

  Scenario: : Control of Detaylı Filtre inputs
    Given user on homepage
    And user on login Page
    And user on accaunt Page
    And user clicks "Raporlar" link
    And user clicks "Araç Bazlı Rapor" link
    Then user confirms that he is on the desired page
    Given user clicks "Detaylı Filtre" link
    Then The input field in the following table must be verified to be side by side
      | Tarih       |
      | İşe Başlama |
      | İş Bitiş    |


  Scenario:Placeholder control of the Tarih entry
    Then The format of the data to be entered as "Tarih"  should be shown to the user as "yyyy-MM-dd".

  @detY
  Scenario Outline: Functionality of the inputs of the Detayli Arama section
    Given user on homepage
    And user on login Page
    And user on accaunt Page
    And user clicks "Raporlar" link
    And user clicks "Araç Bazlı Rapor" link
    When the user selects start date and finish date from the following table
      | Start Date  | 2021-01-01 |
      | Finish Date | 2022-12-31 |
    And user clicks "Rapor Al" links
    When user clicks "Detaylı Filtre" link
    And User sends to the "<text>" value "<section>" section of the Detayli Arama section
    Then the ordered list containing the searched text should be visible
    Examples:
      | text       | section     |
      | 2022       | Tarih       |
      | 2022-10    | Tarih       |
      | 2022-10-12 | Tarih       |
      | 09         | İşe Başlama |
      | 09:06      | İşe Başlama |
      | 09:06:31   | İşe Başlama |
      | 09         | İş Bitiş    |
      | 09:07      | İş Bitiş    |
      | 09:07:49   | İş Bitiş    |







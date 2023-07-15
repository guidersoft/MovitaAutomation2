Feature: Arac Bazli Rapor Menüsünün Default görünümü


  Scenario: senario1
    Given user is homepage
    When  user clicks giris yap menu
    And  user Login whit a valid username and password
    Given user clicks "Raporlar" on the asideMenu
    When  user clicks "Araç Bazlı Rapo" on the sunMenu


  Scenario Outline: senerio2
    Then  user should see "<Locator>" on the Page
    Examples:
      | Locator                                      |
      | [contains(text(),'Araç')]                    |
      | /label[contains(text(),'Başlangıç Tarihi ')] |
      | /label[contains(text(),'Bitiş Tarihi ')]     |
      | [contains(.,'Rapor Al')]                     |

    Scenario: Table Right
      Given user should see Detayli Ara
      When  user should see Exel, PDF and printer button
      And   user should see Table Right
      And   user should see butun Kayitlarda Ara
      And   user should see bellow the Table onceki and sonraki
      Then  The default height and bottom values of the left blog and the blog with the report should be equal to each other.


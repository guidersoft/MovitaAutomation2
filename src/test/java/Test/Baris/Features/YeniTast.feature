Feature: Testing of the 'Detaylı Arama' function in 'Araç Bazlı Raporlar'

  Background: Clicks Until 'Araç Bazlı Rapor' link
    Given user on homepage
    And user on login Page
    And user on accaunt Page
    And user clicks "Raporlar" link
    And user clicks "Araç Bazlı Rapor" link

    Scenario: Bazı Linklerin varlığı
      Then The left blog should contain the following links
        |Araç Dropdown Menu|
        |Başlangıç Tarihi|
        |Bitiş Tarihi|
      Then Aktive edilmemiş olarak "Rapor Al" butonu


  Scenario: DownloadIcon Func
    When the user clicks sequentially on the following data
    |Excel Olarak İndir|
    |Pdf Olarak İndir|
    |Yazıcıdan Çıkart|
    Then User verifies that the files have been downloaded


  Scenario: Test1
    Then Sol blog ile raporun olduğu blogun default height ve bottom değerleri birbirine eşit olmalıdır.

  @Link
  Scenario: Tes2
    Then Tablonun altında tablonun sayfaları arasında geçiş yapmak için ‘Önceki’ ve ‘Sonraki’ butonları bulunmalıdır.
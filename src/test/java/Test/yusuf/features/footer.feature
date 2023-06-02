Feature: footer menu

  @politik
  Scenario Outline: Verify Politikamiz_Menu in Footer_Section
    Given users navigate to homepage
    When user scrolled down footer section
    Then user sees "Politikamız" in footer section
    And user click the "<link>" below Politikamiz
    Then user should see "<text>" on page


    Examples:
      | link                      | text                      |
      | Mesafeli Satış Sözleşmesi | Mesafeli Satış Sözleşmesi |
      | Gizlilik Politikası       | GİZLİLİK POLİTİKASI       |
      | Ödeme ve Teslimat         | ÖDEME VE TESLİMAT         |
      | Garanti Şartları          | ÖDEME VE TESLİMAT          |
      | İade Şartları             | İADE ŞARTLARI             |


  @kurum
  Scenario Outline: Verify Kurumsal_Menu in Footer_Section
    Given users navigate to homepage
    When user scrolled down footer section
    Then user sees "Kurumsal" in footer section
    And user click the "<link>" below Politikamiz
    Then user should see "<text>" on page


    Examples:
      | link               | text               |
      | Hakkımızda         | Hakkımızda         |
      | Belgelerimiz       | Belgelerimiz       |
      | Bayilik Başvurusu  | Bayilik Başvuru    |
      | Demo Başvurusu     | Demo Başvuru       |
      | Ürünler            | Ürünler            |
      | Rota Optimizasyonu | Rota Optimizasyonu |
      | İletişim           | İletişim           |


    @contakt
    Scenario: Verify Contact Information in Footer_Section
      Given users navigate to homepage
      When user scrolled down footer section
      Then user verify contakt infoormation(address, phone, e-mail)
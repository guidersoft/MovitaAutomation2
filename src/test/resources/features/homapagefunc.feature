Feature: functionality of links on the homepage

  Scenario: is the movita logo clickable
    Given user on homepage
    When user clicks on the movita logo
    Then "Mobil Vasıta İzleme Takip Sistemi" text must be visible

  Scenario: dropdown menu language option
    Given user on homepage
    When user clicks dropdown button
    And user clicks english section
    Then "Mobile Vehicle" text must be visible
    When user clicks dropdown button
    When  user clicks türkçe section
    Then "Mobil Vasıta " text must be visible


  Scenario: hover and click functionality of KURUMSAL in the header menu

    Given user on homepage
    When user hower over to "Ana Sayfa" link
    Then Homepage text should change colour
    When user clicks "Ana Sayfa" link
    Then "Mobil Vasıta" text must be visible

    When user hower over the "Kurumsal" link
    Then links in the following data should be visible and text should change colour
      | Hakkımızda        |
      | Belgelerimiz      |
      | Bayilik Başvurusu |
      | Demo Başvrusu     |
      | Çerez Politikası  |
      | KVKK              |

    When user hower over the "Kurumsal" link
    When the "Kurumsal" link is hovered and the links in the drop-down list are clicked, the following data must be verified

      | Hakkımızda                           |
      | BELGELERİMİZ                         |
      | Bayilik Başvuru                      |
      | Demo Başvuru                         |
      | Çerez Politikası                     |
      | KİŞİSEL VERİLERİN İŞLENME POLİTİKASI |


    Scenario: hover and click functionality of ÜRÜNLER in the header menu
    Given user on homepage
    When user hower over the "Ürünler" link
    When the "Ürünler" link is hovered and the links in the drop-down list are clicked, the following data must be verified
      | MNVR                 |
      | MNVR Pro             |
      | MNVR AI              |
      | Araç Takip Cihazı    |
      | Ürünler              |
      | Akıllı Direk Sistemi |


  Scenario: hover and click functionality of ÇÖZÜMLER in the header menu
    Given user on homepage
    When user hower over the "Çözümler" link
    Then links in the following data should be visible and text should change colour
      | Taksi ve Özel Araçlar        |
      | Minibüsler ve Midibüsler     |
      | Şehirler Arası Otobüsler     |
      | Zırhlı Taşıma Araçları       |
      | Okul Servisleri              |
      | Güvenlik Kuvvetleri Araçları |
      | Yük ve Eşya Taşıyan Araçlar  |
      | Belediye ve Halk Otobüsleri  |

  When the "Çözümler" link is hovered and the links in the drop-down list are clicked, the following data must be verified

      | Taksi ve Özel Araçlar        |
      | Minibüsler ve Midibüsler     |
      | Şehirler Arası Otobüsler     |
      | Zırhlı Taşıma Araçları       |
      | Okul Servisleri              |
      | Güvenlik Kuvvetleri Araçları |
      | Yük ve Eşya Taşıyan Araçlar  |
      | Belediye ve Halk Otobüsleri  |

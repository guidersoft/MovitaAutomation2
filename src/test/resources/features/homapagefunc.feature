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
    When user clicks Homepage link
    Then "Mobil Vasıta" text must be visible

    When user hower over the "Kurumsal" link
    Then links in the following data should be visible and text should change colour
      | Hakkımızda        |
      | Belgelerimiz      |
      | Bayilik Başvurusu |
      | Demo Başvrusu     |
      | Çerez Politikası  |
      | KVKK              |

  Scenario Outline: repeat
    Given user on homepage
    When user hower over the "Kurumsal" link
    When Clicking on the "<links>" will visiable the following "<text>"

    Examples:
      | links             | text                                 |
      | Hakkımızda        | Hakkımızda                           |
      | Belgelerimiz      | BELGELERİMİZ                         |
      | Bayilik Başvurusu | Bayilik Başvuru                    |
      | Demo Başvrusu     | Demo Başvuru                         |
      | Çerez Politikası  | Çerez Politikası                     |
      | KVKK              | KİŞİSEL VERİLERİN İŞLENME POLİTİKASI |


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

  Scenario Outline: repeat
    Given user on homepage
    When user hower over the "Çözümler" link
    When Clicking on the "<links>" will visiable the following "<text>"

    Examples:
      | links                        | text                         |
      | Taksi ve Özel Araçlar        | Taksi ve Özel Araçlar        |
      | Minibüsler ve Midibüsler     | Minibüsler ve Midibüsler     |
      | Şehirler Arası Otobüsler     | Şehirler Arası Otobüsler     |
      | Zırhlı Taşıma Araçları       | Zırhlı Taşıma Araçları       |
      | Okul Servisleri              | Okul Servisleri              |
      | Güvenlik Kuvvetleri Araçları | Güvenlik Kuvvetleri Araçları |
      | Yük ve Eşya Taşıyan Araçlar  | Yük ve Eşya Taşıyan Araçlar  |
      | Belediye ve Halk Otobüsleri  | Belediye ve Halk Otobüsleri  |

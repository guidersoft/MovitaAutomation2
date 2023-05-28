Feature: Movita

  @TopMenu
  Scenario Outline: Verify TopMenu "<MainLink>" functionality
    Given users navigate to "https://movita.com.tr//"
    When user hover over "<MainLink>"
    And user assert change color "<MainLink>"


    Examples:

      | MainLink           | relatedPage            |
      | Ana Sayfa          | https://movita.com.tr/ |
      | Rota Optimizasyonu | https://movita.com.tr/ |
      | Uygulamalar        | https://movita.com.tr/ |
      | Kılavuz             | https://movita.com.tr/ |
      | İLETİŞİM           | https://movita.com.tr/ |



      @SubMenu
    Scenario Outline: Verify topMenu_subMenu "<mainLink>"_"<subLink>" functionality
      Given users navigate to "https://movita.com.tr//"
      When  user hover over "<mainLink>"
      And   user assert change color of "<mainLink>"
      And   user hover over "<subLink>"
      And   user assert change color of "<subLink>"
      And   user click "<subLink>"
      Then  "<text>" should be visible

      Examples:
        | mainLink | subLink                     | text                                 |
        | Kurumsal | Hakkımızda                   | Hakkımızda                           |
        | Kurumsal | Belgelerimiz                 | BELGELERİMİZ                         |
        | Kurumsal | Bayilik Başvurusu            | Bayilik Başvuru                      |
        | Kurumsal | Demo Başvrusu                | Demo Başvuru                         |
        | Kurumsal | Çerez Politikası             | Çerez Politikası                     |
        | Kurumsal | KVKK                         | KİŞİSEL VERİLERİN İŞLENME POLİTİKASI |
        | Ürünler  | MNVR                         | MNVR                                 |
        | Ürünler  | MNVR Pro                     | MNVR Pro                             |
        | Ürünler  | MNVR AI                      | MNVR AI                              |
        | Ürünler  | Araç Takip Cihazı            | Araç Takip Cihazı                    |
        | Ürünler  | Cam Tracker                  | Ürünler                              |
        | Ürünler  | Akıllı Direk Sistemi         | Akıllı Direk Sistemi                 |
        | Çözümler | Taksi ve Özel Araçlar        | Taksi ve Özel Araçlar                |
        | Çözümler | Minibüsler ve Midibüsler     | Minibüsler ve Midibüsler             |
        | Çözümler | Şehirler Arası Otobüsler     | Şehirler Arası Otobüsler             |
        | Çözümler | Zırhlı Taşıma Araçları       | Zırhlı Taşıma Araçları               |
        | Çözümler | Okul Servisleri              | Okul Servisleri                      |
        | Çözümler | Güvenlik Kuvvetleri Araçları | Güvenlik Kuvvetleri Araçları         |
        | Çözümler | Yük ve Eşya Taşıyan Araçlar  | Yük ve Eşya Taşıyan Araçlar          |
        | Çözümler | Belediye ve Halk Otobüsleri  | Belediye ve Halk Otobüsleri          |


  @Logo
  Scenario: Verify movita logo functionality
    Given users navigate to "https://movita.com.tr//"
    When  users clicked the movita logo
    Then  Mobile Vehicle Tracking System shoould be visible

  @Language
  Scenario Outline: Verify language option functionality
    Given users navigate to "https://movita.com.tr//"
    When  user clicked the language option dropdown menu
    And   user select "<Language>" option
    Then  user sees "<Text>" on Page

    Examples:
      | Language | Text                              |
      | Türkçe   | Mobil Vasıta İzleme Takip Sistemi |
      | English  | Mobile Vehicle Tracking System    |






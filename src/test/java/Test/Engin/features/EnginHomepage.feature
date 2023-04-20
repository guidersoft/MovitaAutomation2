Feature: homepage

  Background: user on Homepage
    Given user is homepage
@MovitaLogo
  Scenario: movita logo
    When  user clicks movitalogo
    Then  user should see the Text
@MovitaLanguage
  Scenario: Dil secenegi
    When  user click flag logo
    And   user cliks "Engli" buttun
    Then  user should see englich Text

    When  user click flag logo
    And  user cliks "Türk" buttun
    Then  user should see turkce Text
@MovitaFullMenu
  Scenario Outline: movita first spring <HeaderMenu> and <SubMenu>
    When   user hover "<HeaderMenu>" menu
    And    text color should be chanced
    And    user hover "<SubMenu>" menu
    And    SubMenu text color should be chanced
    And    user click "<SubMenu>" menu
    And    user should see "<The Text>"


    Examples: menu
      | HeaderMenu | SubMenu                      | The Text                                   |
      | Ana Sayfa  | Ana Sayfa                    | Mobil Vasıta İzleme Takip Sistemi          |
      | Kurumsal   | Hakkımızda                   | Hakkımızda                                 |
      | Kurumsal   | Belgelerimiz                 | BELGELERİMİZ                               |
      | Kurumsal   | Bayilik Başvurusu            | Bayilik Başvuru                            |
      | Kurumsal   | Demo Başvrusu                | Demo Başvuru                               |
      | Kurumsal   | Çerez Politikası             | Çerez Politikası                           |
      | Kurumsal   | KVKK                         | Kişisel Verilerin İşlenme Politikası       |
      | Ürünler    | MNVR                         | Kullanıcıya ekonomik bir çözüm sunmaktadır |
      | Ürünler    | MNVR Pro                     | MNVR Pro                                   |
      | Ürünler    | MNVR AI                      | MNVR AI                                    |
      | Ürünler    | Araç Takip Cihazı            | Araç Takip Cihazı                          |
      | Ürünler    | Cam Tracker                  | Cam Tracker                                |
      | Ürünler    | Akıllı Direk Sistemi         | Akıllı Direk Sistemi                       |
      | Çözümler   | Taksi ve Özel Araçlar        | Taksi ve Özel Araçlar                      |
      | Çözümler   | Minibüsler ve Midibüsler     | Minibüsler ve Midibüsler                   |
      | Çözümler   | Şehirler Arası Otobüsler     | Şehirler Arası Otobüsler                   |
      | Çözümler   | Zırhlı Taşıma Araçları       | Zırhlı Taşıma Araçları                     |
      | Çözümler   | Okul Servisleri              | Okul Servisleri                            |
      | Çözümler   | Güvenlik Kuvvetleri Araçları | Güvenlik Kuvvetleri Araçları               |
      | Çözümler   | Yük ve Eşya Taşıyan Araçlar  | Yük ve Eşya Taşıyan Araçlar                |
      | Çözümler   | Belediye ve Halk Otobüsleri  | Belediye ve Halk Otobüsleri                |






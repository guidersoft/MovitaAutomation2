@SmokeTestForMovita2
Feature: Smoke test case steps for the movita homepage

  @TopMenuClick1
  Scenario Outline: The user hovers and clicks on the header menu elements on the movita homepage
    Given user on movita homepage
    Then kullanici ana sayfanin ortasinda mobil vasita takip yazilarini gormeli
    When user hover "<Menu>"
    And kullanici "<Menu>" deki "<Submenu>" ye click yapar
    Then kullanici "<expText>" görmeli


    Examples:
      | Menu     | Submenu                      | expText                              |
      | Kurumsal | Hakkımızda                   | HAKKIMIZDA                           |
      | Kurumsal | Belgelerimiz                 | BELGELERİMİZ                         |
      | Kurumsal | Bayilik Başvurusu            | BAYILIK BAŞVURU                      |
      | Kurumsal | Demo Başvrusu                | DEMO BAŞVURU                         |
      | Kurumsal | Çerez Politikası             | ÇEREZ POLITIKASI                     |
      | Kurumsal | KVKK                         | KİŞİSEL VERİLERİN İŞLENME POLİTİKASI |
      | Ürünler  | MNVR                         | MNVR                                 |
      | Ürünler  | MNVR Pro                     | MNVR Pro                             |
      | Ürünler  | MNVR AI                      | MNVR AI                              |
      | Ürünler  | Araç Takip Cihazı            | ARAÇ TAKIP CIHAZI                    |
      | Ürünler  | Cam Tracker                  | ÜRÜNLER                              |
      | Ürünler  | Akıllı Direk Sistemi         | AKILLI DIREK SISTEMI                 |
      | Çözümler | Taksi ve Özel Araçlar        | Taksi ve Özel Araçlar                |
      | Çözümler | Minibüsler ve Midibüsler     | Minibüsler ve Midibüsler             |
      | Çözümler | Şehirler Arası Otobüsler     | Şehirler Arası Otobüsler             |
      | Çözümler | Zırhlı Taşıma Araçları       | Zırhlı Taşıma Araçları               |
      | Çözümler | Okul Servisleri              | Okul Servisleri                      |
      | Çözümler | Güvenlik Kuvvetleri Araçları | Güvenlik Kuvvetleri Araçları         |
      | Çözümler | Yük ve Eşya Taşıyan Araçlar  | Yük ve Eşya Taşıyan Araçlar          |
      | Çözümler | Belediye ve Halk Otobüsleri  | Belediye ve Halk Otobüsleri          |


  @TopMenuClick2
  Scenario Outline: The user clicks on the header menu elements on the movita homepage
    Given user on movita homepage
    When user click on the "<Button>" in main menu
    Then kullanici "<expText>" veya "<expURL>" görmeli

    Examples:
      | Button      | expText     | expURL                            |
      | Uygulamalar | Uygulamalar | https://movita.com.tr/uygulamalar |
      | Kılavuz     |             | https://movita.com.tr/guide       |
      | İLETİŞİM    | İLETİŞİM    | https://movita.com.tr/iletisim    |
      | GİRİŞ Yap   |             | https://movita.com.tr/login       |











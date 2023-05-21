Feature: Movita Homepage

  # Her senaryo öncesi çalışacak.
  Background: Homepage
    When user is on homepage

  @MovitaLogo
  Scenario: Movita logo
    When user should clicks movita logo
    Then user should see the text

  @LanguageOptions
  Scenario: Language option on Homepage
    Given Clickable olmali
    When Kullanıcı "English" butonuna tıklar
    And "Mobile Vehicle" yazisi gözükmeli
    When Kullanıcı "Türkçe" butonuna tıklar
    Then "Mobil Vasıta" yazisi gözükmeli

  @AnaSayfa
  Scenario: Ana Sayfa
    When user hover "Ana Sayfa"
    And user click "Ana Sayfa"
    And user should see "Mobil Vasita izleme takip Sistemi" text


  @TopMenuHover
  Scenario Outline: Top menu deki "<Menu>" hover over olmalidir.
    When user hover "<Menu>"
    And "<Menu>" deki renk değişmeli
    And kullanici "<Menu>" altındaki Submenu lere hover over yapar

    Examples:
      | Menu      |
      | Ana Sayfa |
      | Kurumsal  |
      | Ürünler   |
      | Çözümler  |



  @TopMenuClick
  Scenario Outline: Header Menudeki "<Menu>" ve "<Submenu>" clickable olmalıdır
    #Given user is on homepage "<url>"
    When user hover "<Menu>"
    And "<Menu>" deki renk değişmeli
    Given kullanici "<Menu>" deki "<Submenu>" ye click yapar
    Then kullanici "<expText>" görmeli


    #list of maps
    Examples:
      | Menu     | Submenu                      | expUrl                                      | expText                              |
      | Kurumsal | Hakkımızda                   | https://www.movita.com.tr/about             | HAKKIMIZDA                           |
      | Kurumsal | Belgelerimiz                 | https://www.movita.com.tr/belgelerimiz      | BELGELERİMİZ                         |
      | Kurumsal | Bayilik Başvurusu            | https://www.movita.com.tr/bayi_basvuru      | BAYILIK BAŞVURU                      |
      | Kurumsal | Demo Başvrusu                | https://www.movita.com.tr/demo_basvuru      | DEMO BAŞVURU                         |
      | Kurumsal | Çerez Politikası             | https://www.movita.com.tr/cerez             | ÇEREZ POLITIKASI                     |
      | Kurumsal | KVKK                         | https://www.movita.com.tr/kvkk              | KİŞİSEL VERİLERİN İŞLENME POLİTİKASI |
      | Ürünler  | MNVR                         | https://movita.com.tr/mnvr                  | MNVR                                 |
      | Ürünler  | MNVR Pro                     | https://movita.com.tr/mnvr_pro              | MNVR Pro                             |
      | Ürünler  | MNVR AI                      | https://movita.com.tr/mnvr_ai               | MNVR AI                              |
      | Ürünler  | Araç Takip Cihazı            | https://movita.com.tr/arac_takip_cihazi     | ARAÇ TAKIP CIHAZI                    |
      | Ürünler  | Cam Tracker                  | https://movita.com.tr/urunler               | ÜRÜNLER                              |
      | Ürünler  | Akıllı Direk Sistemi         | https://movita.com.tr/akilli_direk          | AKILLI DIREK SISTEMI                 |
      | Çözümler | Taksi ve Özel Araçlar        | https://movita.com.tr/taksi-ozel-arac       | Taksi ve Özel Araçlar                |
      | Çözümler | Minibüsler ve Midibüsler     | https://movita.com.tr/minibus-midibus       | Minibüsler ve Midibüsler             |
      | Çözümler | Şehirler Arası Otobüsler     | https://movita.com.tr/sehirler-arasi-otobus | Şehirler Arası Otobüsler             |
      | Çözümler | Zırhlı Taşıma Araçları       | https://movita.com.tr/zirhli-tasima-arac    | Zırhlı Taşıma Araçları               |
      | Çözümler | Okul Servisleri              | https://movita.com.tr/okul-servisleri       | Okul Servisleri                      |
      | Çözümler | Güvenlik Kuvvetleri Araçları | https://movita.com.tr/guvenlik-kuvvet-arac  | Güvenlik Kuvvetleri Araçları         |
      | Çözümler | Yük ve Eşya Taşıyan Araçlar  | https://movita.com.tr/yuk-tasiyan-araclar   | Yük ve Eşya Taşıyan Araçlar          |
      | Çözümler | Belediye ve Halk Otobüsleri  | https://movita.com.tr/belediye-halk-otobus  | Belediye ve Halk Otobüsleri          |
















    








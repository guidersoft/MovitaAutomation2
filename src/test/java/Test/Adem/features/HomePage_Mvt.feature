Feature: Movita Homepage

  Background: Homepage
    When user is on homepage

  @MovitaLogo
  Scenario: Movita logo
    When user should clicks movita logo
    Then user should see the text

  @Language
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

# Silinebilir..
  @KurumsalMenu
  Scenario: Kurumsal
    When user hover "Kurumsal"
    Then "Kurumsal" menusu altında 6 seçenek çıkmalı
    When user click "Kurumsal"
    And kullanici "Kurumsal" altındaki submenulere Hover Yapar
    #Then user should see the text "Hakkımızda"
    # submenudeki "demo başvru" yanlış yazılmış
    And kullanici "Kurumsal" altindaki "Demo Başv" submenulere click yapar
    Then kullanici "Demo Başv" yazisini görmeli


    # topMenudeki submenulere click ederek url ve text leri assert edeceğiz.
  @TopMenu
  Scenario Outline: Header Menudeki "<Menu>" ve "<Submenu>" clickable olmalıdır
    Given user is on homepage "<url>"
    When user hover "<Menu>"
    And "<Menu>" deki renk değişmeli
    Given kullanici "<Menu>" deki "<Submenu>" ye click yapar
    And kullanici "<actUrl>" sayfasina girmeli
    Then kullanici "<expText>" görmeli



    #list of maps
    Examples:
      | url                   | Menu     | Submenu                      | actUrl                                      | expText                              |
      | http://movita.com.tr/ | Kurumsal | Hakkımızda                   | https://www.movita.com.tr/about             | Hakkımızda                           |
      | http://movita.com.tr/ | Kurumsal | Belgelerimiz                 | https://www.movita.com.tr/belgelerimiz      | BELGELERİMİZ                         |
      | http://movita.com.tr/ | Kurumsal | Bayilik Başvurusu            | https://www.movita.com.tr/bayi_basvuru      | Bayilik Başvuru                      |
      | http://movita.com.tr/ | Kurumsal | Demo Başvrusu                | https://www.movita.com.tr/demo_basvuru      | Demo Başvuru                         |
      | http://movita.com.tr/ | Kurumsal | Çerez Politikası             | https://www.movita.com.tr/cerez             | Çerez Politikası                     |
      | http://movita.com.tr/ | Kurumsal | KVKK                         | https://www.movita.com.tr/kvkk              | KİŞİSEL VERİLERİN İŞLENME POLİTİKASI |
      | http://movita.com.tr/ | Ürünler  | MNVR                         | https://movita.com.tr/mnvr                  | MNVR                                 |
      | http://movita.com.tr/ | Ürünler  | MNVR Pro                     | https://movita.com.tr/mnvr_pro              | MNVR Pro                             |
      | http://movita.com.tr/ | Ürünler  | MNVR AI                      | https://movita.com.tr/mnvr_ai               | MNVR AI                              |
      | http://movita.com.tr/ | Ürünler  | Araç Takip Cihazı            | https://movita.com.tr/arac_takip_cihazi     | Araç Takip Cihazı                    |
      | http://movita.com.tr/ | Ürünler  | Cam Tracker                  | https://movita.com.tr/urunler               | Ürünler                              |
      | http://movita.com.tr/ | Ürünler  | Akıllı Direk Sistemi         | https://movita.com.tr/akilli_direk          | Akıllı Direk Sistemi                 |
      | http://movita.com.tr/ | Çözümler | Taksi ve Özel Araçlar        | https://movita.com.tr/taksi-ozel-arac       | Taksi ve Özel Araçlar                |
      | http://movita.com.tr/ | Çözümler | Minibüsler ve Midibüsler     | https://movita.com.tr/minibus-midibus       | Minibüsler ve Midibüsler             |
      | http://movita.com.tr/ | Çözümler | Şehirler Arası Otobüsler     | https://movita.com.tr/sehirler-arasi-otobus | Şehirler Arası Otobüsler             |
      | http://movita.com.tr/ | Çözümler | Zırhlı Taşıma Araçları       | https://movita.com.tr/zirhli-tasima-arac    | Zırhlı Taşıma Araçları               |
      | http://movita.com.tr/ | Çözümler | Okul Servisleri              | https://movita.com.tr/okul-servisleri       | Okul Servisleri                      |
      | http://movita.com.tr/ | Çözümler | Güvenlik Kuvvetleri Araçları | https://movita.com.tr/guvenlik-kuvvet-arac  | Güvenlik Kuvvetleri Araçları         |
      | http://movita.com.tr/ | Çözümler | Yük ve Eşya Taşıyan Araçlar  | https://movita.com.tr/yuk-tasiyan-araclar   | Yük ve Eşya Taşıyan Araçlar          |
      | http://movita.com.tr/ | Çözümler | Belediye ve Halk Otobüsleri  | https://movita.com.tr/belediye-halk-otobus  | Belediye ve Halk Otobüsleri          |
















    








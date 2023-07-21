@GuzergahIslemleri
Feature: Dasboard da Guzergah Islemleri sekmesine eriserek,
  arac turune gore rotalari filtrelemek ve belirli kriterlere gore
  rotaların gorunurlugunun dogrulanmasi.

  @TestCaseKey=MVT-T125
  Scenario: Guzergah Islemlerine eriserek asagidaki adımlari uyguluyorum:
    Given Kullanıcı siteye login olabilmeli
    Then Kullanici dashboard u görmeli
    When Kullanici "Güzergah İşlemleri" sekmesine tıklar
    Then "Araç Bazlı" ve "Sefer Bazlı" alt sekmeleri acilmalidir
    When "Araç Bazlı" alt sekmesine tiklar
    Then Asagidaki filtre kriterlerini gormelidir
      | Plaka |
      | Gün   |
      | Seans |
      | Sms   |
    When "Hepsini Göster" butonuna tiklar
    Then Filtre kriterlerine uyan rotalari ekranda gormelidir
    When "Temizle" butonuna tiklar
    Then Onceden goruntulenen rotalari artik ekranda gormemelidir
    When "Sefer Bazlı" alt sekmesine tiklar
    Then Asagidaki filtre kriterlerini gormelidir
      | Gün   |
      | Sefer |
    When "Hepsini Göster" butonuna tiklar
    Then Filtre kriterlerine uyan rotalari ekranda gormelidir
    When "Temizle" butonuna tiklar
    Then Onceden goruntulenen rotalari artik ekranda gormemelidir



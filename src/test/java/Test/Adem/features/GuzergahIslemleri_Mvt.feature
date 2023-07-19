@GuzergahIslemleri
Feature: Dasboard da Guzergah Islemleri sekmesine eriserek,
  arac turune gore rotalari filtrelemek ve belirli kriterlere gore
  rotaların gorunurlugunun dogrulanmasi

  Scenario: Guzergah Islemlerine eriserek asagidaki islemlerin yapilmasi:
    Given Kullanıcı siteye login olabilmeli
    Then Kullanici dashboard u görmeli
    When Kullanici "Güzergah İşlemleri" sekmesine tıklar
    Then "Araç Bazlı" ve "Sefer Bazlı" alt sekmeleri acilmalidir
    When "Araç Bazlı" alt sekmesine tiklar
    Then "Plaka", "Gün", "Seans" ve "Sms" filtre kriterlerini gormelidir
    When "Hepsini Göster" butonuna tiklar
    Then Filtre kriterlerine uyan rotalari ekranda gormelidir
    When "Temizle" butonuna tiklar
    Then Onceden goruntulenen rotalari artik ekranda gormemelidir
    When "Sefer Bazlı" alt sekmesine tiklar
    Then "Gün" ve "Sefer" filtre kriterlerini gormelidir
    When "Hepsini Göster" butonuna tiklar
    Then Filtre kriterlerine uyan rotalari ekranda gormelidir
    When "Temizle" butonuna tiklar
    Then Onceden goruntulenen rotalari artik ekranda gormemelidir



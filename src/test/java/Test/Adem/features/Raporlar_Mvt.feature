Feature: Raporlar Ana Componenti

  Background:
    Given Kullanıcı siteye login olabilmeli
    When Raporlar menüsüne tıklamalı

  @Raporlar
  Scenario Outline: Raporlar Ana Componenti altındaki alt componentlerin default görünümleri.

    Then '<Alt Component>' leri görmelidir
    And Kullanıcı '<Alt Component>' lere tıklar
    Then Tıklanan '<Alt Component>' in zemini beyaz iken text maviye dönüşmelidir

    Examples:
      | Alt Component            |
      | Araç Bazlı Rapor         |
      | Yakıt Entegrasyon Raporu |
      | Günlük Seyahat Raporu    |
      | Aktivite Detay Raporu    |
      | Araç Karne               |
      | Filo Bazlı Rapor         |
      | Grup Bazlı Rapor         |
      | Alarm Log Raporu         |
      | Şoför Log Raporu         |
      | Sensör Log Raporu        |




@AracBazliRapor
Feature: Arac bazli rapor alt modulunun default gorunumu.

  Scenario: Arac bazli rapor alt menusune ait sol ve sag blok default gorunumleri test edilir.

    Given Kullanıcı siteye login olabilmeli
    Then Kullanici dashboard u görmeli
    When Raporlar altındaki Arac Bazli Rapor alt menuye tıklar
    Then Sol blokta Text, Araç, Başlangıç Tarihi, Bitiş Tarihi, Rapor Al bolumleri bulunmalıdır.
    And ‘Rapor Al’ butonu aktive edilmemiş olmalidir.
    And Sag blokta ‘Detaylı Arama' ve asagidaki butonlar,
      | Yazıcıdan Çıkart   |
      | Pdf Olarak İndir   |
      | Excel Olarak İndir |
    And ‘Bütün Kayıtlarda Ara’ arama motoru ve bunlarin altinda arama sonucunu gösteren bir sonuc tablosu,
    And Tablonun altında ‘Rapor almak için sol tarafda tarih aralığı seçerek 'Rapor Al’ butonuna tıklayınız.’ ifadesi bulunmalıdır.
    And Sol blok ile raporun olduğu sag blokun default height ve bottom değerleri birbirine eşit olmalıdır.
    And Tablonun altında ‘Önceki’ ve ‘Sonraki’ butonları bulunmalıdır.
    And Ancak bu butonlar tek sayfa veri olduğunda ve hiç veri olmadığında aktif olmamalidir.
    And Bütün butonlar mouse ile üzerine gelindiğinde kullanıcıya reaksiyon göstermelidir.
      | Yazıcıdan Çıkart   |
      | Pdf Olarak İndir   |
      | Excel Olarak İndir |


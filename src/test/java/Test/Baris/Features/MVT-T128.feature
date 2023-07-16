Feature: Alarm İşlemleri

    @TestCaseKey=MVT-T128
    Scenario: Alarm İşlemleri
        
        Given user on accaunt Page
        When kulanici Alarm İşlemleri'e tıklar, 
        Then Alarm Listesi sayfasında olduğunu doğrular, 
        And "Detaylı Filtre"ye tıklar, "Alarm Kodu", "Açıklama" ve "Alarm Tipi"nin görüntülendiğini doğrular,
        When "Alarm Ekle" düğmesine tıklar, 
        Then "Alarm Bilgisi", "Alarm Tipi", "SMS Bildirim", "Aktif Günler", "Bölgede Kalma Süresi", "Bir Sonraki Bölgeye Max Varma Süresi" ve "Bölgeye Varış/Kalma Süre İhlali Cezası" alanlarının görüntülendiğini doğrular,
        * "Alarm Tipi" filtresi için "Bölge ihlali", "Bölge Giriş/Çıkış", "Hız Limiti" ve "Mesai" gibi seçeneklerin bulunduğunu doğrular, 
        * "SMS Bildirim" filtresi için "Gönderilsin" ve "Gönderilmesin" gibi seçeneklerin bulunduğunu doğrular,
        * "Aktif Günler" filtresinde haftanın tüm günlerini, hafta sonları dahil olmak üzere seçebilir olduğunu doğrular, 
        * "Kaydet" düğmesinin alarmı kaydettiğini doğrular, 
        * Alarm düzenlenebilir ve silinebilir olmalıdır.
@LoginPageGorunum
Feature:  Login sayfasının default görünümü ve sayfadaki özelliklerin kullanılabilirliği

  Scenario: Login sayfasına girildiğinde görülmesi gerekenler ve özelliklerin aktifliği

    Given kullanici login sayfasına girer

    When 'Kullanıcı Adı' ve 'Şifre' için iki ayrı alan görmelidir

    And Kullanıcı adı input alanı üzerinde ‘Movita Vasıta İzleme Takip Sistemi’ yazısı ve onun üzerinde ise Movita logosu bulunmalıdır

    And Alt kısımda ise uzun çubuk şeklinde "#00adee" mavi renkte üzerinde ‘Giriş Yap’ butonu olmalıdır

    And Butonun üzerinde ise ‘Şifrenizi mi Unuttunuz?' linki bulunmalıdır

    When Kullanıcı 'Şifrenizi mi unuttunuz?' kısmına hover over yapar

    And 'Şifrenizi mi unuttunuz?' yazısının rengi maviden "#00adee" yeşile "#03fc0f" dönüşmeli ve clickable olmali

    When Kullanıcı sağ üst köşede ‘Anasayfaya Dön’ yazısı ile birlikte bir ← ikon görmelidir

    And Kullanıcı bu ikona tıkladığı zaman Anasayfaya yönlendirilmelidir

    And Kullanıcı footer ın sol alt kısmında ‘Copyright © '2017-2022', Bütün Hakları Saklıdır.’ ibaresi görmelidir


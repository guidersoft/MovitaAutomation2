Açıklama

Login sayfasının işlevselliği ve kullanıcı tarafından girilen geçerli ve geçersiz verilere
sistemin tepkisi ve sayfadaki kullanıcı adı ve şifre alanlarının özelliği şu şekilde olmalıdır:

Acceptance Criterias:
Kullanıcı adı ve Şifre Kısmı: Girilen kullanıcı adı veya şifrenin herhangi biri veya her ikisi
geçersiz ise ‘Lütfen kullanıcı adınızı veya şifrenizi doğru girdinizden emin olunuz.’ uyarısı
ekranın sağ üst kısmında belirmelidir.

Sadece kullanıcı adı ve şifrenin birlikte geçerli olması durumunda kullanıcı hesabına giriş
yapabilmelidir.

Her iki kısmın herhangi birisi veya her ikisi boş iken ‘Giriş Yap’ butonuna tıklandığında
boş bırakılan alanin altında ‘Lütfen kullanıcı adınızı girdiğinizden emin olun!’ ve/veya
‘Lütfen şifrenizi girdiğinizden emin olun!’ uyarıları belirmelidir. Ve ‘Giriş Yap’ butonu
çalışmamalıdır.


Username: demomovita
Password: 1192movita



MANUEL TEST CASE:

1. Kullanıcı https://www.movita.com.tr sayfasındaki "GİRİŞ YAP" butonuna tıklar.
ER: "Kullanıcı Adı" ve "Şifre" giriş ekranını görmeli.

2. Kullanıcı yanlış bir kullanıcı adı ve yanlış bir şifre girer ve giriş yap butonuna tıklar.
   Kullanıcı Adı: admin123
   Şifre: admin123
ER: Giriş yapamamalı ve ‘Lütfen kullanıcı adınızı veya şifrenizi doğru girdinizden emin olunuz.’
yazısı ekranın sağ üst kısmında belirmeli.

3. Kullanıcı doğru bir kullanıcı adı ve yanlış bir şifre girer ve giriş yap butonuna tıklar.
   Username: demomovita
   Password: admin123
ER: Giriş yapamamalı ve ‘Lütfen kullanıcı adınızı veya şifrenizi doğru girdinizden emin olunuz.’
yazısı ekranın sağ üst kısmında belirmeli.

4. Kullanıcı yanlış bir kullanıcı adı ve doğru bir şifre girer ve giriş yap butonuna tıklar.
ER: Giriş yapamamalı ve ‘Lütfen kullanıcı adınızı veya şifrenizi doğru girdinizden emin olunuz.’
yazısı ekranın sağ üst kısmında belirmeli.

5. Kullanıcı doğru bir kullanıcı adı ve doğru bir şifre girer ve giriş yap butonuna tıklar.
   Username: demomovita
   Password: 1192movita
ER: Hesabına giriş yapabilmeli.

6. Kullanıcı sağ üst köşedeki "Demo Filo" menüsünden "Çıkış Yap" butonuna tıklar.
ER: 
   1. Hesabından logout yapabilmeli,
   2. Tekrar "Kullanıcı Adı" ve "Şifre" giriş ekranını görmeli.

7. Kullanıcı, kullanıcı adını boş bırakır ve doğru şifreyi girerek giriş yap butonuna tıklar.
ER: ‘Lütfen kullanıcı adınızı girdiğinizden emin olun!’ yazısı kullanıcı adı input' unun hemen
altında belirmeli ve ‘Giriş Yap’ butonu çalışmamalıdır.

8. Kullanıcı, doğru kullanıcı adı girer ve şifreyi boş bırakarak giriş yap butonuna tıklar.
ER: ‘Lütfen şifrenizi girdiğinizden emin olun!’ yazısı şifre input' unun hemen altında belirmeli
ve ‘Giriş Yap’ butonu çalışmamalıdır.

9. Kullanıcı, kullanıcı adını ve şifreyi boş bırakarak giriş yap butonuna tıklar.
ER: 
    1.‘Lütfen kullanıcı adınızı girdiğinizden emin olun!’ yazısı kullanıcı adı input' unun hemen altında belirmeli,
    2. ‘Lütfen şifrenizi girdiğinizden emin olun!’ yazısı şifre input' unun hemen altında belirmeli ve ‘Giriş Yap’
    butonu çalışmamalıdır.

10. Kullanıcı, kullanıcı adını boş bırakır ve yanlış şifreyi girerek giriş yap butonuna tıklar.
ER: ‘Lütfen kullanıcı adınızı girdiğinizden emin olun!’ yazısı kullanıcı adı input' unun hemen altında belirmeli
ve ‘Giriş Yap’ butonu çalışmamalıdır.

11. Kullanıcı, yanlış kullanıcı adı girer ve şifreyi boş bırakarak giriş yap butonuna tıklar.
ER: ‘Lütfen şifrenizi girdiğinizden emin olun!’ yazısı şifre input' unun hemen altında belirmeli ve ‘Giriş Yap’
butonu çalışmamalıdır.




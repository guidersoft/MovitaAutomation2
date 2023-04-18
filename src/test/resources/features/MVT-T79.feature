Feature: Login with different username and password combinations

  @TestCaseKey=MVT-T79
  Scenario Outline: Login with different username and password combinations
    Given  user on homepage
    And  user on login Page
    Then user logs in with "<username>" and  "<password>", "<valid_credentials>" user should see "<message>" message

    Examples:
      | username    | password    | valid_credentials | message                                                                |
      | demomovita  | 1192movita  | true              | Demo Filo                                                              |
      | demomovitam | 1192movita  | false             | Lütfen kullanıcı adınızı veya şifrenizi doğru girdinizden emin olunuz. |
      | demomovita  | 1192movitam | false             | Lütfen kullanıcı adınızı veya şifrenizi doğru girdinizden emin olunuz. |
      | demomovitam | 1192movitam | false             | Lütfen kullanıcı adınızı veya şifrenizi doğru girdinizden emin olunuz. |
      |             | 1192movita  | false             | Lütfen kullanıcı adı girin!                                            |
      | demomovita  |             | false             | Lütfen şifre girin!                                                    |
      |             |             | false             | Lütfen kullanıcı adı girin! and Lütfen şifre girin!                    |
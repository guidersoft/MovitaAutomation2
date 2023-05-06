@LoginPage
Feature: Login
  Kayıtlı bir kullanıcı olarak,
  Hesabıma erişebilmek için,
  Web sitesine giriş yapmak istiyorum

  Scenario Outline: Kullanıcı adı ve şifreye göre basarili login yapabilme

    Given kullanici login sayfasına girer

    When Olasi tüm "<username>" ve "<password>" girerek "<expectedResult>" uygun assertion yapar

    Examples:
      | username   | password   | expectedResult |
      | qwerty     | 12345      | false          |
      | demomovita | 12345      | false          |
      | qwerty     | 1192movita | false          |
      | demomovita | 1192movita | true           |
      | qwerty     |            | false          |
      |            | 1192movita | false          |
      |            | 12345      | false          |
      |            |            | false          |



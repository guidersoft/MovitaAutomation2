Feature: Default view of the Login page

    @TestCaseKey=MVT-T86
    Scenario: Default view of the Login page
        Given user on homepage
        Given user on login Page
        Then should see two separate fields for username and password.
        And The text "Movita Vehicle Tracking and Tracing System" and the Movita logo above it must be visible
        And There should be a "Giriş Yap" button in blue colour in the form of a long bar.
        And "Şifrenizi mi unuttunuz?" link should be available.
        And and when hover over, the colour of the text should change from blue to green and it should be clickable
        And "Bütün Hakları Saklıdır." should be written in the footer section.
        And There should be a "Ana sayfaya dön" link in the top right corner and when clicked it should navigate to the Home page

Feature:Movita
Background: user on Homepage
Given user is homepage

Scenario: movita logo
When  user clicks movitalogo
Then  user should see the Text

Scenario: Dil secenegi
When  user click flag logo
And   user cliks "Engli" buttun
Then  user should see englich Text

When  user click flag logo
And  user cliks "Türk" buttun
Then  user should see turkce Text

  Scenario: Ana sayfa
    When User hover "Ana Sayfa"
    And user click "Ana Sayfa"
    Then user should see the text Movita




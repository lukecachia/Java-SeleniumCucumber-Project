Feature: Test this feature

  @browser
  Scenario Outline: Scenario 1234
    Given I navigate to the desired URL
    And   I input "<keyword>"
    Then  I verify that I landed on the correct page
    And   I compare with "<compareKeyword>"
    Then  I select "<countryOrState>"
    Then  I set the "<timeframe>"
    When  I scroll down to the metro section

    Examples:
      |keyword            | compareKeyword         | countryOrState | timeframe    |
      |Selenium WebDriver | Javascript WebDriverIO | New York       | Past 90 days |



Feature: Google Trends Test
  Asserting that Selenium WebDriver gets a 100% result when compared with Javascript WebDriverIO

  @browser
  Scenario Outline: Selenium WebDriver VS Javascript WebDriverIO
    Given I navigate to the desired URL
    And   I input "<keyword>"
    Then  I verify that I landed on the correct page
    And   I compare with "<compareKeyword>"
    Then  I select "<countryOrState>"
    Then  I set the "<timeframe>"
    When  I scroll down to the metro section
    And   I verify that the percentual value is "<value>"

    Examples:
      |keyword            | compareKeyword         | countryOrState | timeframe    | value |
      |Selenium WebDriver | Javascript WebDriverIO | New York       | Past 90 days | 100%  |



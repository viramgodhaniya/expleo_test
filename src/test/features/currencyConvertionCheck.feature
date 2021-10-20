Feature: Currency conversion Check

  @currencyConvCheck
  Scenario Outline: Currency Conversion check
    Given user is on Xe currency convertor Landing Page
    When user selects the from currency as '<fromCurrency>', to currency as '<toCurrency>' and amount as '<amount>'
    Then user clicks on convert button
    And user verifies the converted currency on the proceeding page
    Then user closes the web browser

    Examples: 
      | fromCurrency | toCurrency | amount |
      | EUR          | GBP        |     10 |
      | EUR          | GBP        |     20 |
      | EUR          | GBP        |     15 |
      | EUR          | GBP        |     30 |
      | EUR          | GBP        |     25 |

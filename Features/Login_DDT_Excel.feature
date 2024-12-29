Feature: Login with valid credentials

  Scenario Outline: Successful Login with valid credentials
    Given User launch the browser
    And Open the Url "https://magento.softwaretestingboard.com/"
    When User click on sign-in
    Then Check user navigates to the MyAccount page by passing Email and Password with Excel ros "<row_index>"

    Examples: 
      | row_index |
      |         1 |
      |         2 |
      |         3 |

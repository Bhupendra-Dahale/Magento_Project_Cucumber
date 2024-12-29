Feature: Registration to the Application

  @Registration
  Scenario: User enter the personal details in Registration form
    Given User launch the browser
    And Open the Url "https://magento.softwaretestingboard.com/"
    When User click on Create an Account
    Then Fill the following personal details
      | FirstName | Shivali            |
      | LastName  | Rane               |
      | Email     | shiv.123@gmail.com |
      | Password  | SRane@123          |
    Then User click on Create Account

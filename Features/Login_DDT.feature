Feature: Login with valid credentials

Scenario Outline: Successful Login with valid credentials
	Given User launch the browser
	And Open the Url "https://magento.softwaretestingboard.com/"
	When User click on sign-in
	And User provide Email as "<Email>" and Password as "<Password>"
	And click on Login button
	Then MyAccount page should display
	And User should logout successfully
	
	
	Examples:
		|Email								 |Password				|
		|harrypotter@gmail.com |Potter@Asgard		|
		|jacksparow@gmail.com  |Pirate@carebian |
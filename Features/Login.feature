Feature: Login with valid credentials

@sanity
	Scenario: Successful Login with valid credentials
		Given User launch the browser
		And Open the Url "https://magento.softwaretestingboard.com/"
		When User click on sign-in
		And User provide Email as "jacksparow@gmail.com" and Password as "Pirate@carebian"
		And click on Login button
		Then MyAccount page should display
		And User should logout successfully
		
		
		
#Tagging Examples

#@sanity
#	Scenario: Successful Login with valid credentials
	
#@sanity @regression
#	Scenario: Successful Login with valid credentials
	
#@regression
#	Scenario: Successful Login with valid credentials
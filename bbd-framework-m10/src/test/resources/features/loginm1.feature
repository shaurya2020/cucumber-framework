Feature: SauceDemo Login Funcationality
 
Scenario: Login with valid credentials
 	Given user is on the SauceDemo Login page
 	When user enters username and password 
 	And User clicks on the  login_button
 	Then User should be navigate to the home page 
	And close the browser

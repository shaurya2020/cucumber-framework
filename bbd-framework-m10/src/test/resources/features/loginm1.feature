Feature: SauceDemo Login Funcationality
 Background:
 	Given user is on the SauceDemo Login page
Scenario: Login with valid credentials
 	When user enters username "standard_user"
 	And user enters password "secret_sauce"
 	And User clicks on the  login_button
 	Then User should be navigate to the home page 
	And close the browser

Scenario: Login with invalid credentials
 	When user enters username "ulocked_out_user"
 	And user enters password "secret_sauce"
 	And User clicks on the  login_button
 	Then User should be navigate to the home page 
	And close the browser

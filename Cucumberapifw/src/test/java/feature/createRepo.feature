Feature: Fetching list of users
Scenario: Verify list of users
	Given baseUI is provided
	When resource provided for users
	Then api should fetch status code 200
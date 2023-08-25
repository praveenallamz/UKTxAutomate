Feature: feature to login functionality

	@Servicing
  Scenario: Check login is successful with valid credentials  
    Given user is on servicing login page
    When user enter username
    And click on next
    Then user is navigate to passcode page

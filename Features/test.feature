Feature: feature to test the login functionality
  Scenario: Validate the login page is working fine
    Given Browser is open
    And user is on log in page
    And hits enter
    Then user should navigate to the home page
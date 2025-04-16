@tag
Feature: feature to test the login functionality

  @tag1
  Scenario Outline: Validate the login page is working fine
    Given Browser is open
    And user is on log in page
    When user enters "<username>" and "<password>"
    And hits enter
    Then user should navigate to the home page

    Examples: 
      | username          | password |
      | autemp@gmail.com  | talent   |
      | autSkip@gmail.com | talent   |

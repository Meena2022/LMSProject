Feature: LoginPage functionality 

  Scenario: Check the LMS website url and login functionality
    Given User is on the browser
    When User opens the LMS website
    Then User should see the Login page
    When User clicks the Login button after entering invalid credentails
      | Username | Password | ErrorMessage                                   |
      |          |      456 | Invalid username and password Please try again |
      | $lms     |          | Invalid username and password Please try again |
    Then User should not land on the LMS Home page.
    When User clicks the Login button after entering valid credentails
      | Username | Password |
      | lms      | lms      |
    Then User should see the LMS Home page
		
		
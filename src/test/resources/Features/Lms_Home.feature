Feature: Homepage functionality

  Scenario: This scenario check the Homepage heading and  Menubar buttons of Program,Batch,User,Assignment,Attendance and logout.
    Given User is logged on to LMS website
    When User landed on the Home page
    Then User should see a heading on the Home page
      | LMS - Learning Management System |
    And User should see the following menu buttons on the Home page
      | Program    |
      | Batch      |
      | User       |
      | Assignment |
      | Attendance |
      | Logout     |
  

  #Scenario: Validate program,batch,user,assignment an attendance menu button functionality
    #Given User logged on and landed on Home page
    When User click on program button
    Then Landed on Program page
    When User click on Batch button
    Then Landed on Batch page
    When User click on User button
    Then Landed on User page
    When User click on Assignment button
    Then Landed on Assignment page
    When User click on Logout button
    Then Landed on Login page

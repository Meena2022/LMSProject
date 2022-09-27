Feature: Add/Edit/Update/Delete/Multiple Delete/search functionality of Assignment Page

  Scenario: Create a new Assignment
  
    Given User is on Assignment page
    When User clicks on A New Assignment button
    Then User lands on Assignment Details form
    And User enter Assignment details with "Seleium","Cucumber Automation" and " 90"
    When User clicks on assignment "Save" button
    Then User gets assignment confirmation "Successful"
    And User lands on Manage Assignment


 Scenario: Edit a Assignment
    Given User is on Assignment page
    When User clicks on a assignment edit button
    Then User lands on Assignment Details form
    And user update Assignment details with "Seleium","Cucumber" and "100"
    When User clicks on assignment "Save" button
    Then User gets assignment confirmation "Successful"
    And User lands on Manage Assignment

   

  Scenario: Delete Single Assignment
    Given User is on Assignment page
    When User select the single Assignment
    And Click on single Assignment delete button
    Then User lands on assignment delete confirmation page
    When User clicks on assignment delete dialog "Yes" button
    Then User gets confirmation for assignment deletion "Successful"
    And User lands on Manage Assignment

   
 Scenario: Delete Multiple Assignment
    Given User is on Assignment page
    When User select the multiple Assignment
    And Click on multiple Assignment delete button
    Then User lands on assignment delete confirmation page
    When User clicks on assignment delete dialog "Yes" button
    Then User gets confirmation for assignment deletion " Successful"
    And User lands on Manage Assignment

    

 Scenario: Search box
    Given User is on Assignment page
    When User enters assignment search content into search box "sql"
    Then User see the assignmet search result will be displayed

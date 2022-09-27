Feature: Assignment Functionality

Scenario: Check the Program page functionality of Header,Sort order,Footer and Pagination of Assignment page
    Given User is on Assignment page
    When Assignment page display all the details
    Then User should see the title of the Assignment page as "Manage Assignment"
    And User should see the disabled Icon of multiple Assignment deletion
    And User should see the search box for Assignment page
    And User should see the add new button as "A New Assignment" on Assignment page
    And User should see the entries label format as "Showing 1 to 5 of 25 entries" on Assignment page
    And User should see the total program count format as "In total there are 25 assignments." on Assignment page
    When User clicks on the Ascending or Descending arrow button on Assignment page
      | Assignment Name        |
      | Assignment Description |
    Then User can see the results in Ascending or Descending order on Assignment page
    When Table displays the page 1 content on Assignment page
    Then pagination previous link is disabled on Assignment page
    When User clicks navigate next page button on Assignment page
    Then User navigated to next page number 2 on Assignment page
    When User clicks navigate previous page button on Assignment page
    Then User navigated to previous page number 1 on Assignment page
    When User is on last page of Assignment page
    Then pagination next link is disabled on Assignment page
    
    	
  Scenario Outline: Create a new Assignment
    Given User is on Assignment page
    When User clicks on A New Assignment button
    Then User lands on Assignment Details form
    And User enter Assignment details with "<Name>","<Description>" "<DueDate>" and "<Grade>"
    When User clicks on Assignment "<Confirmation>" button
    Then User gets Assignment save confirmation "<Message>"
    And User lands on Manage Program

    Examples: 
      | Name           | Description | DueDate     | Grade | Confirmation | Message            |
      | Sql Assignment | pl sql      | Jan052022 | A     | Save         | Assignment Created |

  Scenario Outline: Edit a Assignment
    Given User is on Assignment page
    When User clicks on a Edit button of Assignment
    Then User lands on Assignment Details form
    And user updates Assignment details with "<Name>","<Description>","<DueDate>" and "<Grade>"
    When User clicks on Assignment "<Confirmation>" button
    Then User gets Assignment save confirmation "<Message>"
    And User lands on Manage Assignment

    Examples: 
      | Name           | Description | DueDate     | Grade | Confirmation | Message            |  
      | Sql Assignment | demo        | Jan052022 | B     | Save         | Assignment Updated |  

  Scenario Outline: Delete Single Assignment
    Given User is on Assignment page
    When User select the single Assignment checkbox
    And Click on relavent Assignment delete button
    Then User lands on Assignment delete confirmation page
    When User clicks on Assignment delete dialog "<Confirmation>" button
    Then User gets confirmation for Assignment delete "<Message>"
    And User lands on Manage Assignment

    Examples: 
      | Confirmation | Message            |
      | Yes          | Assignment Deleted |

  Scenario Outline: Delete Multiple Assignment
    Given User is on Assignment page
    When User select the multiple Assignment delete checkbox
    And Click on multiple Assignment delete button
    Then User lands on Assignment delete confirmation page
    When User clicks on Assignment delete dialog "<Confirmation>" button
    Then User gets confirmation for Assignment delete "<Message>"
    And User lands on Manage Assignment

    Examples: 
      | Confirmation | Message          |
      | Yes          | Programs Deleted |

  Scenario: Search box
    Given User is on Assignment page
    When User enters Assignment search content into search box "sql"
    Then User see the Assignment search result

 
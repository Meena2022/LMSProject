Feature: User Functionality

 Scenario: Check the Program page functionality of Header,Sort order,Footer and Pagination of User Page
    #Header ,Footer of Program Page
    Given User is on User page
    When User page display all the details
    Then User should see the title of the User page as "Manage User"
    And User should see the disabled Icon of multiple User deletion
    And User should see the search box for User page
    And User should see the add new button as "Add New User" on User page
    And User should see the entries label format as "Showing 1 to 5 of 25 entries" on User page
    And User should see the total program count format as "In total there are 25 users." on User page
    When User clicks on the Ascending or Descending arrow button on User page
      | ID             |
      | Name           |
      | Email Address  |
      | Contatc Number |
      | Batch          |
      | Skill          |
    Then User can see the results in Ascending or Descending order on User page
    When Table displays the page 1 content on User page
    Then pagination previous link is disabled on User page
    When User clicks navigate next page button on User page
    Then User navigated to next page number 2 on User page
    When User clicks navigate previous page button on User page
    Then User navigated to previous page number 1 on User page
    When User is on last page of User page
    Then pagination next link is disabled on User page

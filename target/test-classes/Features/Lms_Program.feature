Feature: Program Functionality

  Scenario Outline: Create a new Program
    Given User is on Program page
    When User clicks on A New Program button
    Then User lands on Program Details form
    And User enter program details with "<Name>","<Description>" and "<Status>"
    When User clicks on "<Confirmation>" button
    Then User gets "<Message>"
    And User lands on Manage Program

    Examples: 
      | Name   | Description | Status | Confirmation | Message                      |
      | java56 | Java Batch  | Active | Save         | Program Created |
      | java56 | Java Batch  | Active | Cancel       | NA                           |

  Scenario Outline: Edit a Program
    Given User is on Program page
    When User clicks on a Edit button
    Then User lands on Program Details form
    And user update program details with "<Name>","<Description>" and "<Status>"
    When User clicks on "<Confirmation>" button
    Then User gets "<Message>"
    And User lands on Manage Program

    Examples: 
      | Name    | Description | Status | Confirmation | Message         |
      | SDET    | Java        | Active | Save         | Program Updated |
      | JavaSel | JSelenium   | Active | Cancel       | NA              |
  Scenario Outline: Delete Single Program
    Given User is on Program page
    When User select the single program
    And Click on single program delete button
    Then User lands on delete confirmation page
    When User clicks on delete dialog "<Confirmation>" button
    Then User gets confirmation for deletion "<Message>"
    And User lands on Manage Program

    Examples: 
      | Confirmation | Message         |
      | Yes          | Program Deleted |
      | No           | NA              |
  Scenario Outline: Delete Multiple Program
    Given User is on Program page
    When User select the multiple program
    And Click on multiple program delete button
    Then User lands on delete confirmation page
    When User clicks on delete dialog "<Confirmation>" button
    Then User gets confirmation for deletion "<Message>"
    And User lands on Manage Program

    Examples: 
      | Confirmation | Message         |
      | Yes          | Programs Deleted |
      | No           | NA              |

  Scenario Outline: Search box
    Given User is on Program page
    When User enters search content into search box "<Content>"
    Then User see the search result will be displayed

    Examples: 
      | Content |
      | SDET    |
      
  Scenario: Check the Program page functionality of Header,Sort order,Footer and Pagination
    #Header ,Footer of Program Page
    Given User is on Program page
    When Program page display all the details
    Then User should see the title of the Program page as "Manage Program"
    And User should see the disabled Icon of multiple program deletion
    And User should see the search box
    And User should see the add new button as "A New Program"
    And User should see the entries label format as "Showing 1 to 5 of 25 entries"
    And User should see the total program count format as "In total there are 25 programs."
    When User clicks on the Ascending or Descending arrow button
      | Program Name        |
      | Program Description |
      | Program Status      |
    Then User can see the results in Ascending or Descending order
    When Table displays the page 1 content
    Then pagination previous link is disabled
    When User clicks navigate next page button
    Then User navigated to next page number 2
    When User clicks navigate previous page button
    Then User navigated to previous page number 1
    When User is on last page
    Then pagination next link is disabled

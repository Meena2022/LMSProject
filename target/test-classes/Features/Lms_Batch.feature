Feature: Add/Edit/Update/Delete/Multiple Delete/search functionality of Batch Page

  Scenario Outline: Check user can add batch to the batches list
    Given User is on Batch Details page by clicking on A New Batch button in Manage Batch Page
    When User enters "<BatchName>", "<BatchDescription>",select "<ProgramName>" , "<BatchStatus>", and <NoofClasses> of Batch
    And  click save button
    Then User gets alert message "<Message>"
    And User lands on Manage Batch page

    Examples: 
      | BatchName | BatchDescription | ProgramName | BatchStatus | NoofClasses | Message    |
      | SDET42    | sdet-test        | SDET        | Active      |           5 | Batch Created |

  Scenario Outline: Check user can update a batch from the batches list
    Given User is on Batch Details page by clicking on edit icon in Manage Batch Page
    When User enters "<BatchName>", "<BatchDescription>",select "<ProgramName>" , "<BatchStatus>", and <NoofClasses> of Batch
    And  click save button
    Then User gets alert message "<Message>"
    And User lands on Manage Batch page

    Examples: 
      | BatchName | BatchDescription | ProgramName | BatchStatus | NoofClasses | Message    |
      | SDET100   | sdet             | TestProgram | Active      |          15 | batch Updated |

  Scenario Outline: Check user can delete a batch from the batches list
    Given User is on Batch Details page  by clicking on delete icon in Manage Batch Page
    When User clicks on particular batch delete icon and click Yes button in alert message
    Then User gets alert message "<Message>"
 		 And User lands on Manage Batch page
    Examples: 
      | Message |
      | batch Deleted|

  Scenario Outline: Check user able to search batch name from the batches list
    Given User is on Manage Batch Page
    When User enters the text "<batch name>"  and click search icon in the text box
    Then User see the search result will be displayed

    Examples: 
      | BatchName |
      | SDET666   |

  Scenario Outline: Check user can delete multiple batches from the batches list
    Given User is on Manage Batch Page
    When User selects multiple batches check box 
    Then Click on multiple batch delete button
    And User gets alert message "<Message>"
    And User lands on Manage Batch page

    Examples: 
      | Message    |
      | Batches Deleted |

Scenario: Check the Program page functionality of Header,Sort order,Footer and Pagination of Batch page
    #Header ,Footer of Program Page
    Given User is on Batch page
    When Batch page display all the details
    Then User should see the title of the Batch page as "Manage Batch"
    And User should see the disabled Icon of multiple Batch deletion
    And User should see the search box for Batch page
   	And User should see the add new button as "A New Batch" on Batch page
    And User should see the entries label format as "Showing 1 to 5 of 25 entries" on Batch page
    And User should see the total program count format as "In total there are 25 batches." on Batch page
    When User clicks on the Ascending or Descending arrow button on Batch page
      | Batch Name        |
      | Batch Description |
      | Batch Status      |
      | No Of Classes     |
      | Program Name      |
    Then User can see the results in Ascending or Descending order on Batch page
    When Table displays the page 1 content on Batch page
    Then pagination previous link is disabled on Batch page
    When User clicks navigate next page button on Batch page
    Then User navigated to next page number 2 on Batch page
    When User clicks navigate previous page button on Batch page
    Then User navigated to previous page number 1 on Batch page
    When User is on last page of program page
    Then pagination next link is disabled on Batch page

  
package com.nn.stepDefs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


import com.nn.base.Base;
import com.nn.commonPack.AssignmentSaveEditPage;
import com.nn.commonPack.DeleteConfirmDialogBox;
import com.nn.pageObjects.AssignmentPage;
import com.nn.pageObjects.HomePage;
import com.nn.pageObjects.LoginPage;

import io.cucumber.java.en.*;

public class Lms_assignmentStepDefs extends Base{

	
		
	
	LoginPage loginPage;
	HomePage homePage;
	AssignmentPage assignPage;
	AssignmentSaveEditPage saveContentBox;
	DeleteConfirmDialogBox deleteDialogBox;
	int CheckBoxIdx;
	String actualMsg;

	
	@Given("User is on Assignment page")
	public void user_is_on_assignment_page() {
		loginPage = new LoginPage();
		homePage=loginPage.ClkLoginButtonWithValidDet(userName, userPwd);
		assignPage=homePage.ClickAssignmentMenu();
		assertTrue("Program page ", assignPage.IsPageLoaded("Assignment"));
		assertEquals("Not landed on Assignment page","Manage Assignment" , assignPage.GetPageHeaderTitle());
	
	}
	
	@When("User clicks on A New Assignment button")
	public void user_clicks_on_a_new_assignment_button() {
		assignPage.ClickNewButton();
	
	}
	
	@Then("User lands on Assignment Details form")
	public void user_lands_on_assignment_details_form() {
		saveContentBox = new AssignmentSaveEditPage();
		assertTrue("Not landed on Assignment dialog box",saveContentBox.IsDialogVisible());
		
		//assertEquals("Assignment detail form title is incorrect","Assignment Details" , saveContentBox.getDetailFormTitle());
	}
	
	
	@Then("User enter Assignment details with {string},{string} {string} and {string}")
	public void user_enter_assignment_details_with_and_a(String Name, String Desc, String Duedate, String Grade) {
		saveContentBox.EnterAssignmentDetails(Name, Desc, Duedate,Grade);
	
	}
	
	@When("User clicks on Assignment {string} button")
	public void user_clicks_on_assignment_button(String Confirm) {
		actualMsg=saveContentBox.ClickConfirmation(Confirm);
	
	}
	
	@Then("User gets Assignment save confirmation {string}")
	public void user_gets_assignment_save_confirmation(String Message) throws InterruptedException {
		if (!Message.equals("NA")){
			if (!actualMsg.contains(Message))  
					assertEquals("Success message is not per requirement",Message, actualMsg); 
			
		}
		//assertEquals("Not landed on Assignment page","Manage Assignment" , homePage.getPageHeaderTitle());

	}
	
	@When("User clicks on a Edit button of Assignment")
	public void user_clicks_on_a_edit_button_of_assignment() {
		int GetRecordCount=assignPage.GetRecordCount();
		if (GetRecordCount >0 ) {
			int idx=getRandomIndex(GetRecordCount);
			assignPage.ClickSingleEditButton(idx); 
		}
		
	}
	

	@Then("user updates Assignment details with {string},{string},{string} and {string}")
	public void user_updates_assignment_details_with_and(String Name, String Desc, String Duedate, String Grade) {
		saveContentBox.EnterAssignmentDetails(Name, Desc, Duedate,Grade);
	
	}
	
	@Then("User lands on Manage Assignment")
	public void user_lands_on_manage_assignment() {
		assertEquals("Not landed on Assignment page","Manage Assignment" , homePage.getPageHeaderTitle());
	
	}
	
	@When("User select the single Assignment checkbox")
	public void user_select_the_single_assignment_checkbox() {
		int GetRecordCount=assignPage.GetRecordCount();
		if (GetRecordCount >0 ) {
			CheckBoxIdx=getRandomIndex(GetRecordCount);
			assignPage.ClickSingleSelectCheckbox(CheckBoxIdx);
		}
	}
	
	@When("Click on relavent Assignment delete button")
	public void click_on_relavent_assignment_delete_button() {
		assignPage.ClickSingleDeleteIcon(CheckBoxIdx);

	}
	
	@Then("User lands on Assignment delete confirmation page")
	public void user_lands_on_assignment_delete_confirmation_page() {
		deleteDialogBox = new DeleteConfirmDialogBox();
		assertEquals("Not showing delete confirmation dialogu box","Confirm" , deleteDialogBox.GetDeleteDialogBoxTitle());
	}
	
	@When("User clicks on Assignment delete dialog {string} button")
	public void user_clicks_on_assignment_delete_dialog_button(String Confirmation) {
		actualMsg=deleteDialogBox.ClickDeleteConfirmation(Confirmation);
	
	}
	
	@Then("User gets confirmation for Assignment delete {string}")
	public void user_gets_confirmation_for_assignment_delete(String Message) throws InterruptedException {
		if (!Message.equals("NA")){
			if (!actualMsg.contains(Message))  
				assertEquals("Sucess message is not per requirement",Message, actualMsg); 
		}
		assertEquals("Not landed on Assignment page","Manage Assignment" , homePage.getPageHeaderTitle());

	}
	
	@When("User select the multiple Assignment delete checkbox")
	public void user_select_the_multiple_assignment_delete_checkbox() {
		assignPage.ClickMutiSelectCheckBox();
	
	}
	
	@When("Click on multiple Assignment delete button")
	public void click_on_multiple_assignment_delete_button() {
		assertTrue("Multiple delete button is disabled", assignPage.IsMultiDeleteIconEnabled());
		assignPage.ClickMultiDeleteIcon();
	
	}
	
	@When("User enters Assignment search content into search box {string}")
	public void user_enters_assignment_search_content_into_search_box(String content) {
		assignPage.EnterSearchContent(content);
	
	}
	
	@Then("User see the Assignment search result")
	public void user_see_the_assignment_search_result() {
		assertTrue("Assignment page ", assignPage.IsPageLoaded("Assignment"));
	
	}
	
	@When("Assignment page display all the details")
	public void assignment_page_display_all_the_details() {
		assertTrue("Assignment page ", assignPage.IsPageLoaded("Assignment"));
	}
	
	@Then("User should see the title of the Assignment page as {string}")
	public void user_should_see_the_title_of_the_assignment_page_as(String string) {
		 assertEquals("Page title is not pre requirement","Manage Assignment" ,assignPage.GetPageHeaderTitle() );
	
	}
	
	@Then("User should see the disabled Icon of multiple Assignment deletion")
	public void user_should_see_the_disabled_icon_of_multiple_assignment_deletion() {
		assertFalse("Multiple delete button is enabled", assignPage.IsMultiDeleteIconEnabled());
	
	}
	
	@Then("User should see the search box for Assignment page")
	public void user_should_see_the_search_box_for_assignment_page() {
		assertTrue("Search option not visible", assignPage.IsSearchBoxDisplayed());
	
	}
	
	@Then("User should see the add new button as {string} on Assignment page")
	public void user_should_see_the_add_new_button_as_on_assignment_page(String ButtonText) {
		assertTrue("Add new button is not visible", assignPage.IsAddButtonDisplayed());
		assertEquals("Page title is not pre requirement", ButtonText,assignPage.GetAddButtonText() );
	}
	
	@Then("User should see the entries label format as {string} on Assignment page")
	public void user_should_see_the_entries_label_format_as_on_assignment_page(String string) {
		String actualLabel = assignPage.GetPaginationShowEntries();
		boolean patternMatch=Pattern.matches("(?:Showing\\s\\d+\\sto\\s\\d+\\sof\\s\\d+\\sentries)", actualLabel);
		assertTrue("Showing entries format not match the requirement format", patternMatch);
	}
	
	@Then("User should see the total program count format as {string} on Assignment page")
	public void user_should_see_the_total_program_count_format_as_on_assignment_page(String string) {
		String actualLabel = assignPage.getFooterTotalRecord();
		boolean patternMatch=Pattern.matches("(?:In\\stotal\\sthere\\sare\\s\\d+\\sassignments.)", actualLabel);
		assertTrue("Showing entries format not match the requirement format", patternMatch);
	}
	
	@When("User clicks on the Ascending or Descending arrow button on Assignment page")
	public void user_clicks_on_the_ascending_or_descending_arrow_button_on_assignment_page(io.cucumber.datatable.DataTable dataTable) {
		List<String> ascendingButton = dataTable.asList(String.class);
		List<String> resultList = new ArrayList<String>();
		for (String fieldName : ascendingButton ) {
			resultList=assignPage.GetSortedOrder(fieldName);
			assertThat(resultList).isSorted();
	
		}
	}
	
	@Then("User can see the results in Ascending or Descending order on Assignment page")
	public void user_can_see_the_results_in_ascending_or_descending_order_on_assignment_page() {
	}
	
	@When("Table displays the page {int} content on Assignment page")
	public void table_displays_the_page_content_on_assignment_page(Integer int1) {
		assertTrue("First page not loaded",assignPage.IsFirstpageLoaded());
	
	}
	
	@Then("pagination previous link is disabled on Assignment page")
	public void pagination_previous_link_is_disabled_on_assignment_page() {
		assertFalse("Previous page navigation button is enabled",assignPage.IsPreviouNavigationDisabled());
	
	}
	
	@When("User clicks navigate next page button on Assignment page")
	public void user_clicks_navigate_next_page_button_on_assignment_page() {
		assignPage.ClickNextNavigationButton();
	}
	
	@Then("User navigated to next page number {int} on Assignment page")
	public void user_navigated_to_next_page_number_on_assignment_page(Integer int1) {
		assertTrue("Second page not loaded",assignPage.IsSecondpageLoaded());
	
	}
	
	@When("User clicks navigate previous page button on Assignment page")
	public void user_clicks_navigate_previous_page_button_on_assignment_page() {
		assignPage.ClickPreviousNavigationButton();
	
	}
	
	@Then("User navigated to previous page number {int} on Assignment page")
	public void user_navigated_to_previous_page_number_on_assignment_page(Integer int1) {
		assertTrue("Second page not loaded",assignPage.IsFirstpageButtonEnabled());
	
	}
	
	@When("User is on last page of Assignment page")
	public void user_is_on_last_page_of_assignment_page() {
		assignPage.ClickLastNavigationButton();
	
	}
	
	@Then("pagination next link is disabled on Assignment page")
	public void pagination_next_link_is_disabled_on_assignment_page() {
		assertTrue("Previous navigation button enabled",assignPage.IsPreviouNavigationDisabled());
	
	}
	

}

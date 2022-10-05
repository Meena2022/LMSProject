package com.nn.stepDefs;


import static org.assertj.core.api.Assertions.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.nn.base.Base;
import com.nn.commonPack.*;
import com.nn.pageObjects.BatchPage;
import com.nn.pageObjects.HomePage;
import com.nn.pageObjects.LoginPage;

import io.cucumber.java.en.*;

public class Lms_batchStepDefs extends Base{

	LoginPage loginPage;
	HomePage homePage;
	BatchPage batchPage;
	BatchSaveEditPage saveContentBox;
	DeleteConfirmDialogBox deleteDialogBox;
	int CheckBoxIdx;
	String actualMsg;
	

	@Given("User is on Batch Details page by clicking on A New Batch button in Manage Batch Page")
	public void user_is_on_batch_details_page_by_clicking_on_a_new_batch_button_in_manage_batch_page() {
		loginPage = new LoginPage();
		homePage=loginPage.ClkLoginButtonWithValidDet(userName, userPwd);
		batchPage=homePage.ClickBatchMenu();
		assertEquals("Not landed on Batch page","Manage Batch" , batchPage.GetPageHeaderTitle());
		assertTrue("Batch page ", batchPage.IsPageLoaded("Batch"));
		batchPage.ClickNewButton();
	}

	@When("User enters {string}, {string},select {string} , {string}, and {int} of Batch")
	public void user_enters_select_and_of_batch(String BatchName, String BatchDescription, String ProgramName, String BatchStatus, Integer NoofClasses)   {
		saveContentBox = new BatchSaveEditPage();
		assertTrue("Batch detail form not loaded",saveContentBox.IsPageDialogVisible());
		assertEquals("Batch detail form not loaded","Batch Details" , saveContentBox.getDetailFormTitle());
		saveContentBox.addBatch(BatchName, BatchDescription, ProgramName, BatchStatus, NoofClasses);
	}

	@When("click save button")
	public void click_save_button() {
		actualMsg=saveContentBox.clickSave(); 

	}

	@Then("User gets alert message {string}")
	public void user_gets_alert_message(String Message) throws InterruptedException {
		if (!actualMsg.contains(Message))  
				assertEquals("Success message is not per requirement",Message, actualMsg);
	}

	@Then("User lands on Manage Batch page")
	public void user_lands_on_manage_batch_page() {
		assertEquals("Batch detail form heading is incorrect","Manage Batch" , batchPage.GetPageHeaderTitle());
	}

	@Given("User is on Batch Details page by clicking on edit icon in Manage Batch Page")
	public void user_is_on_batch_details_page_by_clicking_on_edit_icon_in_manage_batch_page() {
		loginPage = new LoginPage();
		homePage=loginPage.ClkLoginButtonWithValidDet(userName, userPwd);
		batchPage=homePage.ClickBatchMenu();
		assertTrue("Batch page loaded ", batchPage.IsPageLoaded("Batch"));

		int GetRecordCount=batchPage.GetRecordCount();
		if (GetRecordCount>0) {
			int idx=getRandomIndex(GetRecordCount);
			batchPage.ClickSingleEditButton(idx);
		} 
	}




	@Given("User is on Batch Details page  by clicking on delete icon in Manage Batch Page")
	public void user_is_on_batch_details_page_by_clicking_on_delete_icon_in_manage_batch_page() {
		loginPage = new LoginPage();
		homePage=loginPage.ClkLoginButtonWithValidDet(userName, userPwd);
		batchPage=homePage.ClickBatchMenu();
		assertTrue("Batch page loaded", batchPage.IsPageLoaded("Batch"));

		int GetRecordCount=batchPage.GetRecordCount();
		if (GetRecordCount>0) {
			CheckBoxIdx=getRandomIndex(GetRecordCount);
			batchPage.ClickSingleDeleteIcon(CheckBoxIdx);
		}
		
	}

	@When("User clicks on particular batch delete icon and click Yes button in alert message")
	public void user_clicks_on_particular_batch_delete_icon_and_click_yes_button_in_alert_message() {
		deleteDialogBox = new DeleteConfirmDialogBox();

		assertEquals("Not showing delete confirmation dialog box","Confirm" , deleteDialogBox.GetDeleteDialogBoxTitle());
		actualMsg=deleteDialogBox.ClickDeleteConfirmation("Yes");
	}

	@Then("User gets an alert message {string}")
	public void user_gets_an_alert_message(String Message) throws InterruptedException {
		if (!actualMsg.contains(Message))  
				assertEquals("Success message is not per requirement",Message, actualMsg); 
	}

	@Given("User is on Manage Batch Page")
	public void user_is_on_manage_batch_page() {
		loginPage = new LoginPage();
		homePage=loginPage.ClkLoginButtonWithValidDet(userName, userPwd);
		batchPage=homePage.ClickBatchMenu();
		assertEquals("Not landed on Batch page","Manage Batch" , batchPage.GetPageHeaderTitle());
		assertTrue("Batch page ", batchPage.IsPageLoaded("Batch"));

	}

	@When("User enters the text {string}  and click search icon in the text box")
	public void user_enters_the_text_and_click_search_icon_in_the_text_box(String BatchName) {
		batchPage.EnterSearchContent(BatchName);

	}
 
	@When("User selects multiple batches check box")
	public void user_selects_multiple_batches_check_box() {
		batchPage.ClickMutiSelectCheckBox();
		
	}
	
	@Then("Click on multiple batch delete button")
	public void click_on_multiple_batch_delete_button() {
		assertTrue("Multiple delete button is disabled", batchPage.IsMultiDeleteIconEnabled());

		batchPage.ClickMultiDeleteIcon();
		deleteDialogBox = new DeleteConfirmDialogBox();
		assertEquals("Not showing delete confirmation dialog box","Confirm" , deleteDialogBox.GetDeleteDialogBoxTitle());

		actualMsg=deleteDialogBox.ClickDeleteConfirmation("Yes");
   
	}

	@When("Batch page display all the details")
	public void batch_page_display_all_the_details() {
		assertTrue("Batch page ", batchPage.IsPageLoaded("Batch"));

	}

	@Then("User should see the title of the Batch page as {string}")
	public void user_should_see_the_title_of_the_batch_page_as(String PageTitle) {
		 assertEquals("Page title is not pre requirement", PageTitle,batchPage.GetPageHeaderTitle());
	}

	@Then("User should see the disabled Icon of multiple Batch deletion")
	public void user_should_see_the_disabled_icon_of_multiple_batch_deletion() {
		assertFalse("Multiple delete button is enabled", batchPage.IsMultiDeleteIconEnabled());
	}
   
	
	@Then("User see the search result will be displayed")
	public void user_see_the_search_result_will_be_displayed() {
		assertTrue("Batch page ", batchPage.IsPageLoaded("Batch"));
	
	}
	
	@Then("User should see the search box for Batch page")
	public void user_should_see_the_search_box_for_batch_page() {
		assertTrue("Search option not visible", batchPage.IsSearchBoxDisplayed());
	
	}
	
	@Then("User should see the add new button as {string} on Batch page")
	public void user_should_see_the_add_new_button_as_on_batch_page(String ButtonText) {
		assertTrue("Add new button is not visible", batchPage.IsAddButtonDisplayed());
		assertEquals("Page title is not pre requirement", ButtonText,batchPage.GetAddButtonText() );
	}
	
	@Then("User should see the entries label format as {string} on Batch page")
	public void user_should_see_the_entries_label_format_as_on_batch_page(String string) {
		String actualLabel = batchPage.GetPaginationShowEntries();
		boolean patternMatch=Pattern.matches("(?:Showing\\s\\d+\\sto\\s\\d+\\sof\\s\\d+\\sentries)", actualLabel);
		assertTrue("Showing entries format not match the requirement format", patternMatch);
	}
	
	@Then("User should see the total program count format as {string} on Batch page")
	public void user_should_see_the_total_program_count_format_as_on_batch_page(String string) {
		String actualLabel = batchPage.getFooterTotalRecord();
		boolean patternMatch=Pattern.matches("(?:In\\stotal\\sthere\\sare\\s\\d+\\sbatches.)", actualLabel);
		assertTrue("Showing entries format not match the requirement format", patternMatch);
	}
	
	@When("User clicks on the Ascending or Descending arrow button on Batch page")
	public void user_clicks_on_the_ascending_or_descending_arrow_button_on_batch_page(io.cucumber.datatable.DataTable dataTable) {
		List<String> ascendingButton = dataTable.asList(String.class);
		List<String> resultList = new ArrayList<String>();
		for (String fieldName : ascendingButton ) {
			resultList=batchPage.GetSortedOrder(fieldName);
			assertThat(resultList).isSorted();
	
		}
	}
	
	@Then("User can see the results in Ascending or Descending order on Batch page")
	public void user_can_see_the_results_in_ascending_or_descending_order_on_batch_page() {
	   
	}
	
	@When("Table displays the page {int} content on Batch page")
	public void table_displays_the_page_content_on_batch_page(Integer int1) {
		assertTrue("First page not loaded",batchPage.IsFirstpageLoaded());
	
	}
	
	@Then("pagination previous link is disabled on Batch page")
	public void pagination_previous_link_is_disabled_on_batch_page() {
		assertFalse("Previous page navigation button is enabled",batchPage.IsPreviouNavigationDisabled());
	
	}
	
	@When("User clicks navigate next page button on Batch page")
	public void user_clicks_navigate_next_page_button_on_batch_page() {
		batchPage.ClickNextNavigationButton();
	
	}
	
	@Then("User navigated to next page number {int} on Batch page")
	public void user_navigated_to_next_page_number_on_batch_page(Integer int1) {
		assertTrue("Second page not loaded",batchPage.IsSecondpageLoaded());
	
	}
	
	@When("User clicks navigate previous page button on Batch page")
	public void user_clicks_navigate_previous_page_button_on_batch_page() {
		batchPage.ClickPreviousNavigationButton();
	
	}
	
	@Then("User navigated to previous page number {int} on Batch page")
	public void user_navigated_to_previous_page_number_on_batch_page(Integer int1) {
		assertTrue("Second page not loaded",batchPage.IsFirstpageButtonEnabled());
	
	}
	
	@When("User is on last page of Batch page")
	public void user_is_on_last_page_of_batch_page() {
		batchPage.ClickLastNavigationButton();
	
	}
	@Then("pagination next link is disabled on Batch page")
	public void pagination_next_link_is_disabled_on_batch_page() {
		assertTrue("Previous navigation button enabled",batchPage.IsPreviouNavigationDisabled());
	
	}


}

package com.nn.stepDefs;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.nn.base.Base;
import com.nn.commonPack.*;
import com.nn.pageObjects.HomePage;
import com.nn.pageObjects.LoginPage;
import com.nn.pageObjects.ProgramPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import static org.assertj.core.api.Assertions.*;


public class Lms_programStepDefs extends Base {

	LoginPage loginPage;
	HomePage homePage;
	ProgramPage programPage;
	ProgramSaveEditPage saveContentBox;
	DeleteConfirmDialogBox deleteDialogBox;
	int CheckBoxIdx;
	String successMsg;
	
	
	@Given("User is on Program page")
	public void user_is_on_program_page() {
		loginPage = new LoginPage();
		homePage=loginPage.ClkLoginButtonWithValidDet(userName, userPwd);
		programPage=homePage.ClickProgramMenu();
		assertTrue("Not landed on Program page", programPage.IsPageLoaded("Program"));
		assertEquals("Program page title is incorrect","Manage Program" , programPage.GetPageHeaderTitle());

	}
	
	@When("User clicks on A New Program button")
	public void user_clicks_on_a_new_program_button() {
		programPage.ClickNewButton();
	}
	
	@Then("User lands on Program Details form")
	public void user_lands_on_program_details_form() {
		saveContentBox = new ProgramSaveEditPage(driver);
		assertTrue("Program detail form not loaded",saveContentBox.IsProgramDialogVisible());
		assertEquals("Not landed on Program dialog box","Program Details" , saveContentBox.getDetailFormTitle());
	}

	@Then("User enter program details with {string},{string} and {string}")
	public void user_enter_program_details_with_and(String Name, String Desc, String Status) {
		saveContentBox.EnterProgramDetails(Name, Desc, Status);
	}
	

	
	@When("User clicks on Program {string} button")
	public void user_clicks_on_program_save_button(String Confirm) {
		successMsg=saveContentBox.ClickConfirmation(Confirm);
	}

	


	@Then("User gets Program save confirmation {string}")
	public void user_gets_program_save_confirmation(String Message) {
		if (!Message.equals("NA")){
			if (!successMsg.contains(Message))  
				assertEquals("Success message is not per requirement",Message, successMsg); 
			
		}
		
	}


	@Then("User lands on Manage Program")
	public void user_lands_on_manage_program()  {
		assertEquals("Not landed on Program page","Manage Program" , programPage.GetPageHeaderTitle());
	}
	
	
	@When("User clicks on a Edit button of program")
	public void user_clicks_on_a_edit_button_of_program() {
		int GetProgramRecordCount=programPage.GetRecordCount();
		int idx=getRandomIndex(GetProgramRecordCount);
		if (idx>=0)programPage.ClickSingleEditButton(idx); 
	}
	
	@Then("user updates program details with {string},{string} and {string}")
	public void user_updates_program_details_with_and(String Name, String Desc, String Status) throws InterruptedException {
		saveContentBox = new ProgramSaveEditPage(driver);
		saveContentBox.EnterProgramDetails(Name, Desc, Status);
	}

	@When("User select the single program checkbox")
	public void user_select_the_single_program_checkbox()  {
		int GetProgramRecordCount=programPage.GetRecordCount();
		CheckBoxIdx=getRandomIndex(GetProgramRecordCount);
		if (CheckBoxIdx>=0) programPage.ClickSingleSelectCheckbox(CheckBoxIdx);
	}

	@When("Click on relavent program delete button")
	public void click_on_relavent_program_delete_button() {
		programPage.ClickSingleDeleteIcon(CheckBoxIdx);
	 
	}

	@Then("User lands on program delete confirmation page")
	public void user_lands_on_program_delete_confirmation_page()  {
		deleteDialogBox = new DeleteConfirmDialogBox();
		
		assertEquals("Not showing delete confirmation dialog box","Confirm" , deleteDialogBox.GetDeleteDialogBoxTitle());
	}
	
	
	@When("User clicks on Program delete dialog {string} button")
	public void user_clicks_on_program_delete_dialog_button(String Confirmation) {
		successMsg=deleteDialogBox.ClickDeleteConfirmation(Confirmation);

	}
	
	@Then("User gets confirmation for Program delete {string}")
	public void user_gets_confirmation_for_program_delete(String Message) throws InterruptedException {
		if (!Message.equals("NA")){
			if (!successMsg.contains(Message))  
				assertEquals("Sucess message is not per requirement",Message, successMsg); 
			assertEquals("Not landed on Program page","Manage Program" , homePage.getPageHeaderTitle());
		}
	}

	@When("User select the multiple program delete checkbox")
	public void user_select_the_multiple_program_delete_checkbox() {
		programPage.ClickMutiSelectCheckBox();
	}

	@When("Click on multiple program delete button")
	public void click_on_multiple_program_delete_button() {
		assertTrue("Multiple delete button is disabled", programPage.IsMultiDeleteIconEnabled());

		programPage.ClickMultiDeleteIcon();
	}
	
	@When("User enters Program search content into search box {string}")
	public void user_enters_Program_search_content_into_search_box(String content) {
		programPage.EnterSearchContent(content);
	}
	
	@Then("User see the Program search result")
	public void user_see_the_search_result() {
		assertTrue("Program page ", programPage.IsPageLoaded("Program"));

	}

	@When("Program page display all the details")
	public void program_page_display_all_the_details() {
		assertTrue("Program page ", programPage.IsPageLoaded("Program"));

	}

	
	@Then("User should see the title of the Program page as {string}")
	public void user_should_see_the_title_of_the_program_page_as(String PageTitle) {
		 assertEquals("Page title is not pre requirement", PageTitle,homePage.getPageHeaderTitle() );
	}

	@Then("User should see the disabled Icon of multiple program deletion")
	public void user_should_see_the_disabled_icon_of_multiple_program_deletion() {
		assertFalse("Multiple delete button is enabled", programPage.IsMultiDeleteIconEnabled());
	}
    
	@Then("User should see the search box for program page")
	public void user_should_see_the_search_box_for_program_page() {
		assertTrue("Search option not visible", programPage.IsSearchBoxDisplayed());

	}
	
	@Then("User should see the add new button as {string} on program page")
	public void user_should_see_the_add_new_button_as_on_program_page(String ButtonText) {
		assertTrue("Add new button is not visible", programPage.IsAddButtonDisplayed());
		assertEquals("Page title is not pre requirement", ButtonText,programPage.GetAddButtonText() );
	}
	
	
	@Then("User should see the entries label format as {string} on program page")
	public void user_should_see_the_entries_label_format_as_on_program_page(String string) {
		String actualLabel = programPage.GetPaginationShowEntries();
		boolean patternMatch=Pattern.matches("(?:Showing\\s\\d+\\sto\\s\\d+\\sof\\s\\d+\\sentries)", actualLabel);
		assertTrue("Showing entries format not match the requirement format", patternMatch);
	}

	@Then("User should see the total program count format as {string} on program page")
	public void user_should_see_the_total_program_count_format_as_on_program_page(String FooterLabel) {
		String actualLabel = programPage.getFooterTotalRecord();
		boolean patternMatch=Pattern.matches("(?:In\\stotal\\sthere\\sare\\s\\d+\\sprograms.)", actualLabel);
		assertTrue("Showing entries format not match the requirement format", patternMatch);
	}

	
	@When("User clicks on the Ascending or Descending arrow button on program page")
	public void user_clicks_on_the_ascending_or_descending_arrow_button_on_program_page(DataTable dataTable) {
		List<String> ascendingButton = dataTable.asList(String.class);
		List<String> resultList = new ArrayList<String>();
		for (String fieldName : ascendingButton ) {
			resultList=programPage.GetSortedOrder(fieldName);
			assertThat(resultList).isSorted();
	
		}
	}
	

	@Then("User can see the results in Ascending or Descending order on program page")
	public void user_can_see_the_results_in_ascending_or_descending_order_on_program_page() {
	   
	}

	@When("Table displays the page {int} content on program page")
	public void table_displays_the_page_content_on_program_page(Integer int1) {
		assertTrue("First page not loaded",programPage.IsFirstpageLoaded());
	
	}

	@Then("pagination previous link is disabled on program page")
	public void pagination_previous_link_is_disabled_on_program_page() {
		assertFalse("Previous page navigation button is enabled",programPage.IsPreviouNavigationDisabled());
	
	}
	
	@When("User clicks navigate next page button on program page")
	public void user_clicks_navigate_next_page_button_on_program_page() {
		programPage.ClickNextNavigationButton();
	
	}

	@Then("User navigated to next page number {int} on program page")
	public void user_navigated_to_next_page_number_on_program_page(Integer int1) {
		assertTrue("Second page not loaded",programPage.IsSecondpageLoaded());
	
	}

	@When("User clicks navigate previous page button on program page")
	public void user_clicks_navigate_previous_page_button_on_program_page() {
		programPage.ClickPreviousNavigationButton();
	
	}

	@Then("User navigated to previous page number {int} on program page")
	public void user_navigated_to_previous_page_number_on_program_page(Integer int1) {
		assertTrue("Second page not loaded",programPage.IsFirstpageButtonEnabled());
	
	}

	@When("User is on last page of program page")
	public void user_is_on_last_page_of_program_page() {
		programPage.ClickLastNavigationButton();
	
	}

	@Then("pagination next link is disabled on program page")
	public void pagination_next_link_is_disabled_on_program_page() {
		assertTrue("Previous navigation button enabled",programPage.IsPreviouNavigationDisabled());
	
	}



}

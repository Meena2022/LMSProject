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
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;


public class Lms_programStepDefs extends Base {

	LoginPage loginPage;
	HomePage homePage;
	ProgramPage programPage;
	ProgramSaveEditPage saveContentBox;
	DeleteConfirmDialogBox deleteDialogBox;
	int CheckBoxIdx;
	/*
	@Before
	public void setupBrowser() {
		SetupBrowser();
		loginPage = new LoginPage(driver);
		//homePage=loginPage.ClkLoginButtonWithValidDet(userName, userPwd);
		//programPage=homePage.ClickProgramMenu();
		loginPage.ClkLoginButtonWithValidDet(userName, userPwd);
		homePage.ClickProgramMenu();
	}
	
	@After
	public void closeBrowser() {
		BrowserTearDown();
	}
		*/
	
	@Given("User is on Program page")
	public void user_is_on_program_page() {
		//System.out.print( programPage.IsPageRecordLoaded("Program"));
		SetupBrowser();
		loginPage = new LoginPage(driver);
		homePage=loginPage.ClkLoginButtonWithValidDet(userName, userPwd);
		programPage=homePage.ClickProgramMenu();

		assertEquals("Not landed on Program page","Manage Program" , programPage.GetPageHeaderTitle());
		assertTrue("Program page ", programPage.IsPageLoaded("Program"));

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
	
	@When("User clicks on {string} button")
	public void user_clicks_on_button(String Confirm) throws InterruptedException {
		saveContentBox.ClickConfirmation(Confirm);
		//Thread.sleep(500);

	}
	
	@Then("User gets {string}")
	public void user_gets(String Message) {
		if (!Message.equals("NA")){
			String actualMsg=programPage.GetSuccessMessage();
			System.out.print(actualMsg);
			if (!actualMsg.contains(Message))  
					assertEquals("Success message is not per requirement",Message, actualMsg); 
			
		}
		


	}
	
	@Then("User lands on Manage Program")
	public void user_lands_on_manage_program()  {
		System.out.print(programPage.GetPageHeaderTitle());
		assertEquals("Not landed on Program page","Manage Program" , programPage.GetPageHeaderTitle());
		//Thread.sleep(1500);
	}
	
	
	@When("User clicks on a Edit button")
	public void user_clicks_on_a_edit_button() {
		int GetProgramRecordCount=programPage.GetRecordCount();
		int idx=getRandomIndex(GetProgramRecordCount);
		programPage.ClickSingleEditButton(idx); 
	}
	
	@Then("user update program details with {string},{string} and {string}")
	public void user_update_program_details_with_and(String Name, String Desc, String Status) throws InterruptedException {
		//saveContentBox = new ProgramSaveEditPage(driver);
		saveContentBox.EnterProgramDetails(Name, Desc, Status);
	}

	@When("User select the single program")
	public void user_select_the_single_program()  {
		int GetProgramRecordCount=programPage.GetRecordCount();
		CheckBoxIdx=getRandomIndex(GetProgramRecordCount);
		programPage.ClickSingleSelectCheckbox(CheckBoxIdx);
	}

	@When("Click on single program delete button")
	public void click_on_single_program_delete_button() {
		programPage.ClickSingleDeleteIcon(CheckBoxIdx);
	 
	}

	@Then("User lands on delete confirmation page")
	public void user_lands_on_delete_confirmation_page()  {
		//deleteDialogBox = new DeleteConfirmDialogBox(driver);
		
		System.out.print(deleteDialogBox.GetDeleteDialogBoxTitle());
		assertEquals("Not showing delete confirmation dialogu box","Confirm" , deleteDialogBox.GetDeleteDialogBoxTitle());
	}
	
	@When("User clicks on delete dialog {string} button")
	public void user_clicks_on_delete_dialog_button(String Confirmation) {
		deleteDialogBox.ClickDeleteConfirmation(Confirmation);
	}
	
	@Then("User gets confirmation for deletion {string}")
	public void user_gets_confirmation_for_deletion(String Message) {
		if (!Message.equals("NA")){
			String actualMsg=programPage.GetSuccessMessage();
			if (!actualMsg.contains(Message))  
				assertEquals("Sucess message is not per requirement",Message, actualMsg); 
		
			assertEquals("Not landed on Program page","Manage Program" , homePage.getPageHeaderTitle());
		}
	}

	@When("User select the multiple program")
	public void user_select_the_multiple_program() {
		programPage.ClickMutiSelectCheckBox();
	}

	@When("Click on multiple program delete button")
	public void click_on_multiple_program_delete_button() {
		programPage.ClickMultiDeleteIcon();
	}
	
	@When("User enters search content into search box {string}")
	public void user_enters_search_content_into_search_box(String content) {
		programPage.EnterSearchContent(content);
	}
	
	@Then("User see the search result will be displayed")
	public void user_see_the_search_result_will_be_displayed() {

	}
	@When("Program page display all the details")
	public void program_page_display_all_the_details() {
	    
	}

	@Then("User should see the title of the Program page as {string}")
	public void user_should_see_the_title_of_the_program_page_as(String PageTitle) {
		 assertEquals("Page title is not pre requirement", PageTitle,homePage.getPageHeaderTitle() );
	}

	@Then("User should see the disabled Icon of multiple program deletion")
	public void user_should_see_the_disabled_icon_of_multiple_program_deletion() {
		assertFalse("Multiple delete button is enabled", programPage.IsMultiDeleteIconEnabled());
	}

	@Then("User should see the search box")
	public void user_should_see_the_search_box() {
		assertTrue("Search option not visible", programPage.IsSearchBoxDisplayed());
	}

	@Then("User should see the add new button as {string}")
	public void user_should_see_the_add_new_button_as(String ButtonText) {
		assertTrue("Add new button is not visible", programPage.IsAddButtonDisplayed());
		assertEquals("Page title is not pre requirement", ButtonText,programPage.GetAddButtonText() );
	}
	
	@Then("User should see the entries label format as {string}")
	public void user_should_see_the_entries_label_format_as(String FooterLabel) {
		String actualLabel = programPage.GetPaginationShowEntries();
		boolean patternMatch=Pattern.matches("(?:Showing\\s\\d+\\sto\\s\\d+\\sof\\s\\d+\\sentries)", actualLabel);
		assertTrue("Showing entries format not match the requirement format", patternMatch);
	}

	@Then("User should see the total program count format as {string}")
	public void user_should_see_the_total_program_count_format_as(String FooterLabel) {
		String actualLabel = programPage.getFooterTotalRecord();
		boolean patternMatch=Pattern.matches("(?:In\\stotal\\sthere\\sare\\s\\d+\\sprograms.)", actualLabel);
		assertTrue("Showing entries format not match the requirement format", patternMatch);
	}

	
	@When("User clicks on the Ascending or Descending arrow button")
	public void user_clicks_on_the_ascending_or_descending_arrow_button(DataTable dataTable) {
		List<String> ascendingButton = dataTable.asList(String.class);
		List<String> resultList = new ArrayList<String>();
		for (String fieldName : ascendingButton ) {
			System.out.println(fieldName);
			resultList=programPage.GetSortedOrder(fieldName);
			System.out.println(resultList);
			//assertThat(resultList).isSorted();
	
		}
	}
	

	@Then("User can see the results in Ascending or Descending order")
	public void user_can_see_the_results_in_ascending_or_descending_order() {
	   
	}
	
	
	@When("Table displays the page {int} content")
	public void table_displays_the_page_content(Integer int1) {
		assertTrue("First page not loaded",programPage.IsFirstpageLoaded());
   
	}
	
	@Then("pagination previous link is disabled")
	public void pagination_previous_link_is_disabled() {
		assertFalse("Previous page navigation button is enabled",programPage.IsPreviouNavigationDisabled());
	}
	
	@When("User clicks navigate next page button")
	public void user_clicks_navigate_next_page_button() {
		programPage.ClickNextNavigationButton();
	}
	
	@Then("User navigated to next page number {int}")
	public void user_navigated_to_next_page_number(Integer int1) {
		assertTrue("Second page not loaded",programPage.IsSecondpageLoaded());
	}
	
	@When("User clicks navigate previous page button")
	public void user_clicks_navigate_previous_page_button() {
		programPage.ClickPreviousNavigationButton();
	 
	}
	
	@Then("User navigated to previous page number {int}")
	public void user_navigated_to_previous_page_number(Integer int1) {
		assertTrue("Second page not loaded",programPage.IsFirstpageButtonEnabled());
	}
	
	@When("User is on last page")
	public void user_is_on_last_page() {
		programPage.ClickLastNavigationButton();
  
	}
	
	@Then("pagination next link is disabled")
	public void pagination_next_link_is_disabled() {
		assertTrue("Previous navigation button enabled",programPage.IsPreviouNavigationDisabled());

	}
		
}

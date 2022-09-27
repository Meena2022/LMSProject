package com.nn.stepDefs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.nn.base.Base;
import com.nn.pageObjects.HomePage;
import com.nn.pageObjects.LoginPage;
import com.nn.pageObjects.UserPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class Lms_userStepDefs extends Base{

	LoginPage loginPage;
	HomePage homePage;
	UserPage userPage;
	
	@Before
	public void setupBrowser() {
		SetupBrowser();
		loginPage = new LoginPage(driver);
		homePage=loginPage.ClkLoginButtonWithValidDet(userName, userPwd);
		userPage=homePage.ClickUserMenu();
	}
	
	@After
	public void closeBrowser() {
		BrowserTearDown();
	}
		
	@Given("User is on User page")
	public void user_is_on_user_page() throws InterruptedException {
		assertEquals("Not landed on User page","Manage User" , userPage.GetPageHeaderTitle());
	
	
	}
	
	@When("User page display all the details")
	public void user_page_display_all_the_details() {
	
	}
	
	@Then("User should see the title of the User page as {string}")
	public void user_should_see_the_title_of_the_user_page_as(String string) {
		 assertEquals("Page title is not pre requirement","Manage User",homePage.getPageHeaderTitle() );
	
	}
	
	@Then("User should see the disabled Icon of multiple User deletion")
	public void user_should_see_the_disabled_icon_of_multiple_user_deletion() {
		assertFalse("Multiple delete button is enabled", userPage.IsMultiDeleteIconEnabled());
	
	}
	
	@Then("User should see the search box for User page")
	public void user_should_see_the_search_box_for_user_page() {
		assertTrue("Search option not visible", userPage.IsSearchBoxDisplayed());
	
	}
	
	@Then("User should see the add new button as {string} on User page")
	public void user_should_see_the_add_new_button_as_on_user_page(String ButtonText) {
		assertTrue("Add new button is not visible", userPage.IsAddButtonDisplayed());
		assertEquals("Page title is not pre requirement", ButtonText,userPage.GetAddButtonText() );
	}
	
	@Then("User should see the entries label format as {string} on User page")
	public void user_should_see_the_entries_label_format_as_on_user_page(String string) {
		String actualLabel = userPage.GetPaginationShowEntries();
		boolean patternMatch=Pattern.matches("(?:Showing\\s\\d+\\sto\\s\\d+\\sof\\s\\d+\\sentries)", actualLabel);
		assertTrue("Showing entries format not match the requirement format", patternMatch);
	
	}
	
	@Then("User should see the total program count format as {string} on User page")
	public void user_should_see_the_total_program_count_format_as_on_user_page(String string) {
		String actualLabel = userPage.getFooterTotalRecord();
		boolean patternMatch=Pattern.matches("(?:In\\stotal\\sthere\\sare\\s\\d+\\susers.)", actualLabel);
		assertTrue("Showing entries format not match the requirement format", patternMatch);
	}
	
	@When("User clicks on the Ascending or Descending arrow button on User page")
	public void user_clicks_on_the_ascending_or_descending_arrow_button_on_user_page(io.cucumber.datatable.DataTable dataTable) {
		List<String> ascendingButton = dataTable.asList(String.class);
		List<String> resultList = new ArrayList<String>();
		for (String fieldName : ascendingButton ) {
			resultList=userPage.GetSortedOrder(fieldName);
			assertThat(resultList).isSorted();
	
		}
	}
	
	@Then("User can see the results in Ascending or Descending order on User page")
	public void user_can_see_the_results_in_ascending_or_descending_order_on_user_page() {
	  
	}
	
	@When("Table displays the page {int} content on User page")
	public void table_displays_the_page_content_on_user_page(Integer int1) {
		assertTrue("First page not loaded",userPage.IsFirstpageLoaded());
	
	}
	
	@Then("pagination previous link is disabled on User page")
	public void pagination_previous_link_is_disabled_on_user_page() {
		assertFalse("Previous page navigation button is enabled",userPage.IsPreviouNavigationDisabled());
	
	}
	
	@When("User clicks navigate next page button on User page")
	public void user_clicks_navigate_next_page_button_on_user_page() {
		userPage.ClickNextNavigationButton();
	
	}
	
	@Then("User navigated to next page number {int} on User page")
	public void user_navigated_to_next_page_number_on_user_page(Integer int1) {
		assertTrue("Second page not loaded",userPage.IsSecondpageLoaded());
	
	}
	
	@When("User clicks navigate previous page button on User page")
	public void user_clicks_navigate_previous_page_button_on_user_page() {
		userPage.ClickPreviousNavigationButton();
	
	}
	
	@Then("User navigated to previous page number {int} on User page")
	public void user_navigated_to_previous_page_number_on_user_page(Integer int1) {
		assertTrue("Second page not loaded",userPage.IsFirstpageButtonEnabled());
	
	}
	
	@When("User is on last page of User page")
	public void user_is_on_last_page_of_user_page() {
		userPage.ClickLastNavigationButton();
	
	}
	
	@Then("pagination next link is disabled on User page")
	public void pagination_next_link_is_disabled_on_user_page() {
		assertTrue("Previous navigation button enabled",userPage.IsPreviouNavigationDisabled());
	
	}


}

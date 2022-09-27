package com.nn.stepDefs;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import com.nn.base.Base;

import com.nn.pageObjects.HomePage;
import com.nn.pageObjects.LoginPage;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;


public class Lms_homeStepDefs extends Base {
	
	LoginPage loginPage;
	HomePage homePage;
	/*
	@Before
	public  void openBrowser() {
		System.out.println("Login Before ");
		
	}
	
	@After
	public void closeBrowser() {
		System.out.println("Home page After)");
		BrowserClose();
	}*/
	
	@Given("User is logged on to LMS website")
	public void user_is_logged_on_to_lms_website()  {
		SetupBrowser();
		loginPage = new LoginPage(driver);
		homePage= new HomePage(driver);

		loginPage.ClkLoginButtonWithValidDet(userName, userPwd);
	}
	
	@When("User landed on the Home page")
	public void user_landed_on_the_home_page() {
		String actualUrl=homePage.getHomepageUrl();
		assertEquals("Home page is not loaded", homeUrl, actualUrl);
	}

	@Then("User should see a heading on the Home page")
	public void user_should_see_a_heading_on_the_home_page(DataTable dataTable) {
		List<String> dataHeading = dataTable.asList(String.class);
		String  expectedHeading = dataHeading.get(0);
		String actualHeading = homePage.getHomepageHeadding();
		assertEquals("Homepage displays the wrong heading", expectedHeading, actualHeading);
	}

	@Then("User should see the following menu buttons on the Home page")
	public void user_should_see_the_following_menu_buttons_on_the_home_page(DataTable dataTable) {
		List<String> expectedMenuButton = dataTable.asList(String.class);
		List<String> actualMenuButton = homePage.getHomepageMenuButtons();
		boolean menuButtonMatch = expectedMenuButton.equals(actualMenuButton);
		assertTrue("Homepage not displays all the require menu button", menuButtonMatch);
 	}

	@Then("User Should on Login Page")
	public void user_should_on_login_page() {
	   //BrowserClose();
	}

	
	//Menu button function 
	/*
	@Given("User logged on and landed on Home page")
	public void user_logged_on_and_landed_on_home_page() {
		
		loginPage = new LoginPage(driver);
		homePage=loginPage.ClkLoginButtonWithValidDet(userName, userPwd);
	}*/
	
	@When("User click on program button")
	public void user_click_on_program_button() {
		//loginPage = new LoginPage(driver);
		//homePage=loginPage.ClkLoginButtonWithValidDet(userName, userPwd);
		homePage= new HomePage(driver);
		homePage.ClickProgramMenu();
	}
	
	@Then("Landed on Program page")
	public void landed_on_program_page() {
		assertEquals("Not landed on Program page","Manage Program" , homePage.getPageHeaderTitle());
	}
	
	@When("User click on Batch button")
	public void user_click_on_batch_button() {
		homePage.ClickBatchMenu();
	}
	
	@Then("Landed on Batch page")
	public void landed_on_batch_page() {
		assertEquals("Not landed on Batch page","Manage Batch" , homePage.getPageHeaderTitle());
	}
	
	@When("User click on User button")
	public void user_click_on_user_button() {
		homePage.ClickUserMenu();
	}
	
	@Then("Landed on User page")
	public void landed_on_user_page() {
		assertEquals("Not landed on User page","Manage User" , homePage.getPageHeaderTitle());
	}
	
	@When("User click on Assignment button")
	public void user_click_on_assignment_button() {
		homePage.ClickAssignmentMenu();
	}
	
	@Then("Landed on Assignment page")
	public void landed_on_assignment_page() {
		assertEquals("Not landed on Assignment page","Manage Assignment" , homePage.getPageHeaderTitle());
	}
	
	@When("User click on Logout button")
	public void user_click_on_logout_button() {
		homePage.ClickLogoutButton();
	}
	
	@Then("Landed on Login page")
	public void landed_on_login_page() {
		assertEquals("Not landed on Login page",appUrl , loginPage.getUrl());
		BrowserClose();
	
	}
}

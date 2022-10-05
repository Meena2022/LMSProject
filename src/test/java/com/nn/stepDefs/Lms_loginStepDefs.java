package com.nn.stepDefs;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;
import java.util.Map;


import com.nn.base.Base;
import com.nn.pageObjects.HomePage;
import com.nn.pageObjects.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class Lms_loginStepDefs extends Base {
	
	LoginPage loginPage;
	HomePage homePage;
	
	
	
	@Given("User is on the browser")
	public void user_is_on_the_browser() {
		loginPage=new LoginPage();
		assertEquals("WebPage failed to load",appUrl, loginPage.getUrl() );
	}

	@When("User opens the LMS website")
	public void user_opens_the_lms_website()  {
		assertEquals("Failed to open LMS website","LMS", loginPage.geApplicationTitle() );
	}

	@Then("User should see the Login page")
	public void user_should_see_the_login_page()  {
		assertTrue("Login page is not loaded", loginPage.isLoginPageVisible());
	}

	

	@When("User clicks the Login button after entering invalid credentails")
	public void user_clicks_the_login_button_after_entering_invalid_credentails(DataTable dataTable) throws InterruptedException {
		List<Map<String, String>> invalidData = dataTable.asMaps(String.class,String.class);
		for (Map<String, String> data : invalidData) {	
			String user = data.get("Username");
			String pwd = data.get("Password");
			String expectError = data.get("ErrorMessage");
			if( (user == null)) {user= "";}
			if( (pwd == null)) {pwd= "";}
			String actualError=loginPage.ClkLoginButtonWithInValidDet(user, pwd);
			assertEquals("",expectError , actualError);
			loginPage.ReloadLoginPage();
		}
	}

	@Then("User should not land on the LMS Home page.")
	public void user_should_not_land_on_the_lms_home_page()  {
		assertEquals("Sucessfuly login with invalid credentails",appUrl , loginPage.getUrl());
	}

	@When("User clicks the Login button after entering valid credentails")
	public void user_clicks_the_login_button_after_entering_valid_credentails(DataTable dataTable) throws InterruptedException {
		List<Map<String, String>> loginData = dataTable.asMaps(String.class,String.class);
			String user = loginData.get(0).get("Username");
			String pwd = loginData.get(0).get("Password");
			homePage=loginPage.ClkLoginButtonWithValidDet(user, pwd);
	}

	@Then("User should see the LMS Home page")
	public void user_should_see_the_lms_home_page()  {
		assertEquals("Failed to login with valid credentails",homeUrl , loginPage.getUrl());
	}
}
	
	
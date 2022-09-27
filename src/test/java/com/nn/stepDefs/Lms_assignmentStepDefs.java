package com.nn.stepDefs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.nn.base.Base;
import com.nn.commonPack.AssignmentSaveEditPage;
import com.nn.commonPack.DeleteConfirmDialogBox;
import com.nn.commonPack.ProgramSaveEditPage;
import com.nn.pageObjects.AssignmentPage;
import com.nn.pageObjects.HomePage;
import com.nn.pageObjects.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class Lms_assignmentStepDefs extends Base{

	LoginPage loginPage;
	HomePage homePage;
	AssignmentPage assignPage;
	AssignmentSaveEditPage saveContentBox;
	DeleteConfirmDialogBox deleteDialogBox;
	int CheckBoxIdx;
	/*
	@Before
	public void setupBrowser() {
		SetupBrowser();
		
	}
	
	@After
	public void closeBrowser() {
		BrowserTearDown();
	}
	*/
	
	
	@Given("User is on Assignment page")
	public void user_is_on_assignment_page() throws InterruptedException  {
		//loginPage = new LoginPage(driver);
		//homePage=loginPage.ClkLoginButtonWithValidDet(userName, userPwd);
		//assignPage=homePage.ClickAssignmentMenu();
		//loginPage = new LoginPage(driver);
		loginPage.ClkLoginButtonWithValidDet(userName, userPwd);
		homePage.ClickProgramMenu();
		assertEquals("Not landed on Assignment page","Manage Assignment" , assignPage.GetPageHeaderTitle());
		assertTrue("Assignment page ", assignPage.IsPageLoaded("Assignment"));
		Thread.sleep(1000);
	}
	
	@When("User clicks on A New Assignment button")
	public void user_clicks_on_a_new_assignment_button() {
		assignPage.ClickNewButton();
	}
	
	@Then("User lands on Assignment Details form")
	public void user_lands_on_assignment_details_form() {
		//saveContentBox = new AssignmentSaveEditPage(driver);
		assertTrue("Assignment detail form not loaded",saveContentBox.IsProgramDialogVisible());
		assertEquals("Not landed on Assignment dialog box","Assigment Details" , saveContentBox.getDetailFormTitle());
	}
	
	@Then("User enter Assignment details with {string},{string} and {string}")
	public void user_enter_assignment_details_with_and(String Name, String Desc, String Grade) {
		saveContentBox.EnterAssignmentDetails(Name, Desc, Grade);
	
	}
	
	@When("User clicks on assignment {string} button")
	public void user_clicks_on_assignment_button(String Confirm) {
		saveContentBox.ClickConfirmation(Confirm);
	
	}
	
	@Then("User gets assignment confirmation {string}")
	public void user_gets_assignment_confirmation(String Message) {
			String actualMsg=assignPage.GetSuccessMessage();
			//assertEquals("Success message is not per requirement",Message.strip(), actualMsg.strip());
			assertTrue("Success message is not per requirement",actualMsg.contains(Message));

			assertEquals("Not landed on Assignment page","Manage Assignment" , assignPage.GetPageHeaderTitle());

	}
	
	@Then("User lands on Manage Assignment")
	public void user_lands_on_manage_assignment() {
		assertEquals("Not landed on Assignment page","Manage Assignment" , assignPage.GetPageHeaderTitle());
	
	}
	
	@When("User clicks on a assignment edit button")
	public void user_clicks_on_a_assignment_edit_button() {
		int GetProgramRecordCount=assignPage.GetRecordCount();
		int idx=getRandomIndex(GetProgramRecordCount);
		assignPage.ClickSingleEditButton(idx); 
	}
	
	@Then("user update Assignment details with {string},{string} and {string}")
	public void user_update_assignment_details_with_and(String Name, String Desc, String Grade) {
		//saveContentBox = new AssignmentSaveEditPage(driver);
		saveContentBox.EnterAssignmentDetails(Name, Desc, Grade);
	}
	
	@When("User select the single Assignment")
	public void user_select_the_single_assignment() {
		int GetProgramRecordCount=assignPage.GetRecordCount();
		CheckBoxIdx=getRandomIndex(GetProgramRecordCount);
		assignPage.ClickSingleSelectCheckbox(CheckBoxIdx);
	}
	
	@When("Click on single Assignment delete button")
	public void click_on_single_assignment_delete_button() {
		assignPage.ClickSingleDeleteIcon(CheckBoxIdx);
	
	}
	@Then("User lands on assignment delete confirmation page")
	public void user_lands_on_assignment_delete_confirmation_page() {
		//deleteDialogBox = new DeleteConfirmDialogBox(driver);
		
		System.out.print(deleteDialogBox.GetDeleteDialogBoxTitle());
		assertEquals("Not showing delete confirmation dialog box","Confirm" , deleteDialogBox.GetDeleteDialogBoxTitle());
	
	}
	
	@When("User clicks on assignment delete dialog {string} button")
	public void user_clicks_on_assignment_delete_dialog_button(String Confirmation) {
		deleteDialogBox.ClickDeleteConfirmation(Confirmation);
	
	}
	@Then("User gets confirmation for assignment deletion {string}")
	public void user_gets_confirmation_for_assignment_deletion(String Message) {
		String actualMsg=assignPage.GetSuccessMessage();
		if (!actualMsg.contains(Message))  
			assertEquals("Sucess message is not per requirement",Message.strip(), actualMsg.strip()); 
	
		assertEquals("Not landed on Assignment page","Manage Assignment" , assignPage.GetPageHeaderTitle());
	}
	
	@When("User select the multiple Assignment")
	public void user_select_the_multiple_assignment() {
		assignPage.ClickMutiSelectCheckBox();
	
	}
	
	@When("Click on multiple Assignment delete button")
	public void click_on_multiple_assignment_delete_button() {
		assignPage.ClickMultiDeleteIcon();
	
	}
	
	@When("User enters assignment search content into search box {string}")
	public void user_enters_assignment_search_content_into_search_box(String content) {
		assignPage.EnterSearchContent(content);
	
	}
	
	@Then("User see the assignmet search result will be displayed")
	public void user_see_the_assignmet_search_result_will_be_displayed() {
	   
	}

}

package com.nn.stepDefs;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;



import com.nn.base.Base;
import com.nn.commonPack.*;
import com.nn.pageObjects.BatchPage;
import com.nn.pageObjects.HomePage;
import com.nn.pageObjects.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class Lms_batchStepDefs extends Base{

	LoginPage loginPage;
	HomePage homePage;
	BatchPage batchPage;
	BatchSaveEditPage saveContentBox;
	DeleteConfirmDialogBox deleteDialogBox;
	int CheckBoxIdx;
	/*
	@Before
	public void setupBrowser() {
		SetupBrowser();
		
		//homePage=loginPage.ClkLoginButtonWithValidDet(userName, userPwd);
		//batchPage=homePage.ClickBatchMenu();
	}
	
	@After
	public void closeBrowser() {
		BrowserTearDown();
	}
		
	*/

	@Given("User is on Batch Details page by clicking on A New Batch button in Manage Batch Page")
	public void user_is_on_batch_details_page_by_clicking_on_a_new_batch_button_in_manage_batch_page() {
		//loginPage = new LoginPage(driver);
		loginPage.ClkLoginButtonWithValidDet(userName, userPwd);
		homePage.ClickProgramMenu();
		assertEquals("Not landed on Batch page","Manage Batch" , batchPage.GetPageHeaderTitle());
		assertTrue("Batch page ", batchPage.IsPageLoaded("Batch"));
		batchPage.ClickNewButton();
		//Thread.sleep(500);
	}

	@When("User enters {string}, {string},select {string} , {string}, and {int} of Batch")
	public void user_enters_select_and_of_batch(String BatchName, String BatchDescription, String ProgramName, String BatchStatus, Integer NoofClasses)   {
	    
		//saveContentBox = new BatchSaveEditPage(driver);
		assertTrue("Batch detail form not loaded",saveContentBox.IsPrageeDialogVisible());
		assertEquals("Batch detail form not loaded","Batch Details" , saveContentBox.getDetailFormTitle());
		saveContentBox.setBatchName(BatchName);
		saveContentBox.setBatchDesc(BatchDescription);
		saveContentBox.selectBatchProgram(ProgramName);
		// aebp.selectBatchStatus();
		saveContentBox.clickRadActive();
		;
		saveContentBox.selectBatchStatus();
		saveContentBox.setBatchNoClasses(NoofClasses);
		
		//Thread.sleep(500);
	}

	@When("click save button")
	public void click_save_button() {
		
		saveContentBox.clickSave(); 
	}

	@Then("User gets alert message {string}")
	public void user_gets_alert_message(String Message) {
		String actualMsg=batchPage.GetSuccessMessage();
		System.out.print(actualMsg);
		if (!actualMsg.contains(Message))  
				assertEquals("Success message is not per requirement",Message, actualMsg);
	}

	@Then("User lands on Manage Batch page")
	public void user_lands_on_manage_batch_page() {
		assertEquals("Not landed on Program page","Manage Batch" , batchPage.GetPageHeaderTitle());
	}

	@Given("User is on Batch Details page by clicking on edit icon in Manage Batch Page")
	public void user_is_on_batch_details_page_by_clicking_on_edit_icon_in_manage_batch_page() {
		int GetProgramRecordCount=batchPage.GetRecordCount();
		int idx=getRandomIndex(GetProgramRecordCount);
		batchPage.ClickSingleEditButton(idx); 
	}




	@Given("User is on Batch Details page  by clicking on delete icon in Manage Batch Page")
	public void user_is_on_batch_details_page_by_clicking_on_delete_icon_in_manage_batch_page() {
		int GetProgramRecordCount=batchPage.GetRecordCount();
		CheckBoxIdx=getRandomIndex(GetProgramRecordCount);
		batchPage.ClickSingleSelectCheckbox(CheckBoxIdx);
	}

	@When("User clicks on particular batch delete icon and click Yes button in alert message")
	public void user_clicks_on_particular_batch_delete_icon_and_click_yes_button_in_alert_message() {
		batchPage.ClickSingleDeleteIcon(CheckBoxIdx);
		//deleteDialogBox = new DeleteConfirmDialogBox(driver);
		assertEquals("Not showing delete confirmation dialog box","Confirm" , deleteDialogBox.GetDeleteDialogBoxTitle());
		deleteDialogBox.ClickDeleteConfirmation("Yes");

	}

	@Then("User gets an alert message {string}")
	public void user_gets_an_alert_message(String Message) {
		String actualMsg=batchPage.GetSuccessMessage();
		System.out.print(actualMsg);
		if (!actualMsg.contains(Message))  
				assertEquals("Success message is not per requirement",Message, actualMsg); 
	}

	@Given("User is on Manage Batch Page")
	public void user_is_on_manage_batch_page() {
		assertEquals("Not landed on Batch page","Manage Batch" , batchPage.GetPageHeaderTitle());
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
		batchPage.ClickMultiDeleteIcon();
		//deleteDialogBox = new DeleteConfirmDialogBox(driver);
		deleteDialogBox.ClickDeleteConfirmation("Yes");

	   
	}

	@Given("User is on Batch page")
	public void user_is_on_batch_page() {
		assertEquals("Not landed on Batch page","Manage Batch" , batchPage.GetPageHeaderTitle());
		assertTrue("Batch page ", batchPage.IsPageLoaded("Program"));
	}
	
	@When("Batch page display all the details")
	public void batch_page_display_all_the_details() {
	    
	}

	@Then("User should see the title of the Batch page as {string}")
	public void user_should_see_the_title_of_the_batch_page_as(String PageTitle) {
		 assertEquals("Page title is not pre requirement", PageTitle,batchPage.GetPageHeaderTitle());
	}

	@Then("User should see the disabled Icon of multiple Batch deletion")
	public void user_should_see_the_disabled_icon_of_multiple_batch_deletion() {
		assertFalse("Multiple delete button is enabled", batchPage.IsMultiDeleteIconEnabled());
	}


	/*
	//@Test
	//@Epic("01")
	//@Description("Add new batch")
	@Given("User is on Batch Details page by clicking on A New Batch button in Manage Batch Page")
	public void user_is_on_batch_details_page_by_clicking_on_a_new_batch_button_in_manage_batch_page()
			throws InterruptedException {
/*
		mbp = new ManageBatchPage(driver);
		mbp.clickBatch();
		Thread.sleep(2000);
		// Assertion for Title of Manage Batch page
		// boolean output = driver.getPageSource().contains("Manage Batch");
		// Assert.assertEquals(output,true);
		mbp.clickAddBatches();
		aebp = new Add_Edit_BatchesPage(driver);

		Thread.sleep(2000);
		boolean output = driver.getPageSource().contains("Batch Details");
		Assert.assertEquals(output, true);
	}
	@When("User enters {string}, {string},select {string} , {string},  and enters {int} and click save button")
	public void user_enters_select_and_enters_and_click_save_button(String BatchName, String BatchDescription,
			String ProgramName, String NoofClasses, Integer Message) throws InterruptedException {

		aebp = new Add_Edit_BatchesPage(driver);

		// user enters Batch name, Batch Description, Status, program name,
		// no.of.classes
		aebp.setBatchName(BatchName);
		aebp.setBatchDesc(BatchDescription);
		aebp.selectBatchProgram(ProgramName);
		// aebp.selectBatchStatus();
		aebp.clickRadActive();
		;
		aebp.selectBatchStatus();
		aebp.setBatchNoClasses(NoofClasses);
		// aebp.getMessage("Message");
		aebp.clickSave(); // click save

	}

	@Then("User gets alert message {string}")
	public void user_gets_alert_message(String Message) {

		// aebp.getMessage(Message);
		boolean output = driver.getPageSource().contains(Message);
		assertEquals(output, true);

	}

	@Then("User lands on Manage Batch page")
	public void user_lands_on_manage_batch_page() {

		boolean output = driver.getPageSource().contains("Manage Batch");
		assertEquals(output, true);
	}

	/*-------------Edit Batches Steps---------------------*/
/*
	//@Test
	//@Epic("02")
	//@Description("Edit a batch")
	@Given("User is on Batch Details page  by clicking on edit icon in Manage Batch Page")
	public void user_is_on_batch_details_page_by_clicking_on_edit_icon_in_manage_batch_page()
			throws InterruptedException {

		mbp = new ManageBatchPage(driver);
		mbp.clickBatch();
		Thread.sleep(2000);
		mbp.clickEditButton();

	}

	@When("User updates {string}, {string},select {string} , {string},  and enters {int} and click save button")
	public void user_updates_select_and_enters_and_click_save_button(String BatchName, String BatchDescription,
			String ProgramName, String NoofClasses, Integer int1) throws InterruptedException {
		{

			aebp = new Add_Edit_BatchesPage(driver);
			Thread.sleep(2000);
			// user enters Batch name, Batch Description, Status, program name,
			// no.of.classes
			aebp.setBatchName(BatchName);
			aebp.setBatchDesc(BatchDescription);
			aebp.selectBatchProgram(ProgramName);
			aebp.clickRadActive();
			aebp.setBatchNoClasses(NoofClasses);
			Thread.sleep(2000);
			aebp.clickSave(); // click save
			
		}

	}

	
	/*-------------Delete Batches Steps---------------------*/
/*	
	//@Test
	//@Epic("03")
	//@Description("Delete a batch")
	@Given("User is on Batch Details page  by clicking on delete icon in Manage Batch Page")
	public void user_is_on_batch_details_page_by_clicking_on_delete_icon_in_manage_batch_page() throws InterruptedException {

		//mbp = new ManageBatchPage(driver);
		Thread.sleep(2000);
		//mbp.clickDelButton();

	}

	@When("User clicks on particular batch delete icon and click Yes button in alert message")
	public void user_clicks_on_particular_batch_delete_icon_and_click_yes_button_in_alert_message() throws InterruptedException {
		
		Thread.sleep(2000);
		mbp.clickYes();
		Thread.sleep(2000);
	}
	
	@Then("User gets an alert message {string}")
	public void user_gets_an_alert_message(String Message) throws InterruptedException {

		// aebp.getMessage(Message);
		boolean output = driver.getPageSource().contains(Message);
		assertEquals(output, true);
		Thread.sleep(2000);

	}



	/*-------------Search---------------------*/
	
	//@Test
	//@Epic("04")
	//@Description("Search a batch")
	/*	
	@Given("User is on Manage Batch Page")
	public void user_is_on_manage_batch_page() throws InterruptedException {

		//mbp = new ManageBatchPage(driver);
		//mbp.clickBatch();
		// System.out.println(driver);
		Thread.sleep(2000);
		boolean output = driver.getPageSource().contains("Manage Batch");
		assertEquals(output, true);

	}

	@When("User enters the text {string}  and click search icon in the text box")
	public void user_enters_the_text_and_click_search_icon_in_the_text_box(String BatchName) {

		//mbp.clickSearchbox(BatchName);
	}

	@Then("User see the search result will be displayed")
	public void User_see_the_search_result_will_be_displayed() {

		boolean output = driver.getPageSource().contains("SDET666");
		assertEquals(output, true);

	}
	
	/*-------------Multiple Delete---------------------*/
	
	//@Test
	//@Epic("05")
	//@Description("Delete multiple batches")
	/*
	@When("User selects multiple batches on check box {string}")
	public void user_selects_multiple_batches_on_check_box(String BatchName) {

		mbp.clickSearchbox(BatchName);
		mbp.clickMulCheckbox();
		mbp.clickMultiDelButton();
		mbp.clickYes();

	}
*/

}

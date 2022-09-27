package com.nn.pageObjects;

import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {

	WebDriver driver;
	Actions action;
	
	WebDriverWait Wdwait;
	
	@FindBy(xpath="//mat-toolbar/span[1]") WebElement homepageHeading;
	@FindBys({
	    	@FindBy(xpath="//app-header//button/span[1]")
	   }) List<WebElement> menuButtons;
	
	@FindBy(xpath="//app-header//button[1]") WebElement btnProgram;

	@FindBy(xpath="//app-header//button[2]") WebElement btnBatch;

	@FindBy(xpath="//app-header//button[3]") WebElement btnUser;

	@FindBy(xpath="//app-header//button[4]") WebElement btnAssignment;

	@FindBy(xpath="//app-header//button[5]") WebElement btnAttendance;

	@FindBy(xpath="//app-header//button[6]") WebElement btnLogout;

	
	// addition - Common function Element
	@FindBy(xpath="//mat-card-title/div") WebElement lblHeaderTitle;
	
	@FindBy(xpath="//mat-card-title/div[2]//button[@icon=\"pi pi-trash\"]") WebElement btnDeleteAll;
	@FindBy(xpath = "//mat-card-title/div[2]/div[2]//input") WebElement txtSearch;
	@FindBy(id="new") WebElement btnAddnew;
	@FindBy(xpath="//button[@id='new']/span[2]") WebElement lblAddnew;
	
	@FindBy(xpath = "//p-paginator//div/span") WebElement lblPaginationEntries;
	@FindBy(xpath = "//p-table/div/div[2]/div") WebElement lblToalCount;

	@FindBy(xpath = "//p-paginator//span/button[1]") WebElement btnFirstpage;
	@FindBy(xpath = "//p-paginator//span/button[2]") WebElement btnSecondpage;
	@FindBy(xpath = "//p-paginator//div/button[2]") WebElement btnPreviouspage;
	@FindBy(xpath = "//p-paginator//div/button[3]") WebElement btnNextpage;
	@FindBy(xpath = "//p-paginator//div/button[4]") WebElement btnLastspage;
	
	@FindBys({
			@FindBy(xpath = "//p-paginator/div/button") 
	})List<WebElement> btnPagination;
	@FindBys({
		@FindBy(xpath = "//table//p-sorticon") 
	})List<WebElement> btnSort;

	@FindBys({
		@FindBy(xpath = "//tbody//td[2]") 
	})List<WebElement> sortedProgramNameList;
	@FindBys({
		@FindBy(xpath = "//tbody//td[3]") 
	})List<WebElement> sortedProgramDescList;
	@FindBys({
		@FindBy(xpath = "//tbody//td[4]") 
	})List<WebElement> sortedProgramStatusList;
	

	
	// Menu button click
	
	public HomePage(WebDriver wdriver) {
		driver=wdriver;
		action =new Actions(driver);
		PageFactory.initElements(driver,this);
	}

	public String getHomepageUrl() {
		return driver.getCurrentUrl();
	}

	public String getPageHeaderTitle() {
		return lblHeaderTitle.getText();
	}
	
	public List<String> getHomepageMenuButtons(){
		List<String> menuButtonList = new ArrayList<String>();
		for(WebElement item:menuButtons){
			menuButtonList.add(item.getText());
		}
		return menuButtonList;
	}
	
	public String getHomepageHeadding() {
		return homepageHeading.getText();
	}
	
	public void ClickLogoutButton(){
		action.moveToElement(btnLogout).click().build().perform();
	}
	

	public ProgramPage ClickProgramMenu(){
		action.moveToElement(btnProgram).click().build().perform();
		return new ProgramPage(driver);
	}

	public BatchPage ClickBatchMenu(){
		action.moveToElement(btnBatch).click().build().perform();
		return new BatchPage(driver);

	}

	public UserPage ClickUserMenu(){
		action.moveToElement(btnUser).click().build().perform();
		return new UserPage(driver);
	}

	public AssignmentPage ClickAssignmentMenu(){
		action.moveToElement(btnAssignment).click().build().perform();
		return new AssignmentPage(driver);
	}
	
	public void ClickAttendanceMenu(){
		action.moveToElement(btnAttendance).click().build().perform();
	}
}

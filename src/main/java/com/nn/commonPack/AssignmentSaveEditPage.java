package com.nn.commonPack;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssignmentSaveEditPage {
	WebDriver driver;
	Actions action;
	
	@FindBy(id="assignment") WebElement txtAssignment;

	@FindBy(id="assignmentDescription") WebElement txtAssignDesc;

	@FindBy(id="assignmentGraderId") WebElement txtGrade;
	
	@FindBy(xpath= "//div/div/div[3]/button[2]")
	WebElement btnSave;
	
	@FindBy(xpath= "//div/div/div[3]/button[1]")
	WebElement btnCancel;

	@FindBy(xpath="//div[@role='dialog']") WebElement PageDialog;
	@FindBy(xpath="//p-dialog//div[@role='dialog']/div/span") WebElement lblDialogTitle;

	public AssignmentSaveEditPage(WebDriver wdriver) {
		System.out.println("Home page constructor");
		driver=wdriver;
		action =new Actions(driver);

		PageFactory.initElements(driver,this);
	}
	
	
						
	public boolean IsProgramDialogVisible() {

		return PageDialog.isDisplayed();
	}

	public String getDetailFormTitle() {
		return lblDialogTitle.getText();
	}
	
	public void EnterAssignmentDetails(String name,String desc,String due,String grade) {
		txtAssignment.clear();
		txtAssignment.sendKeys(name);
		txtAssignDesc.clear();
		txtAssignDesc.sendKeys(desc);
		txtGrade.clear();
		txtGrade.sendKeys(desc);
		
	}
	
	public void ClickConfirmation(String status)  {

		if (status.equalsIgnoreCase("Save")) {
			action.moveToElement(btnSave).click().build().perform();
		}
		if (status.equalsIgnoreCase("Cancel")){
			action.moveToElement(btnCancel).click().build().perform();
		}
	}
}

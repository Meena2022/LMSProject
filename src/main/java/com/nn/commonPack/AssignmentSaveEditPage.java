package com.nn.commonPack;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.nn.base.Base;

public class AssignmentSaveEditPage extends Base{
	//WebDriver driver;
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

	public AssignmentSaveEditPage( ) {
		action =new Actions(driver);

		PageFactory.initElements(driver,this);
	}
	
	
						
	public boolean IsDialogVisible() {
		Wdwait.until(ExpectedConditions.visibilityOf(PageDialog));
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
	
	
	public String ClickConfirmation(String status)  {
		
		if (status.equalsIgnoreCase("Save")) {
			action.moveToElement(btnSave).click().build().perform();
			Wdwait.until(ExpectedConditions.invisibilityOf(btnSave));
			WebElement MsgElement = driver.findElement(By.xpath("//p-toast//p-toastitem"));
			return MsgElement.getText();
		}
		if (status.equalsIgnoreCase("Cancel")){
			action.moveToElement(btnCancel).click().build().perform();
		}
		
		return "NA";

		
	}
}

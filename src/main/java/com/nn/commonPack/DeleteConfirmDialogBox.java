package com.nn.commonPack;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.nn.base.Base;

public class DeleteConfirmDialogBox extends Base{

	Actions action;
	
	
	public DeleteConfirmDialogBox( ) {
		action =new Actions(driver);
		PageFactory.initElements(driver,this);

	}

	@FindBy(xpath="//p-confirmdialog//div[1]/div[1]/span") WebElement DeleteDialogTitle;
	@FindBy(xpath="//p-confirmdialog//div[3]/button[2]") WebElement DeleteDialogYes;

	@FindBy(xpath="//p-confirmdialog//div[3]/button[1]") WebElement DeleteDialogNo;

	

	public String GetDeleteDialogBoxTitle() {

		try {
			return DeleteDialogTitle.getText();
			
		}
		catch(Exception NoSuchElementException) {
			return "Delete confirmation dialog not displayed";
		
		}
		
		
		
	}
	
	public String ClickDeleteConfirmation(String Confirmation) {

		if (Confirmation.equalsIgnoreCase("Yes")) {
			action.moveToElement(DeleteDialogYes).click().build().perform();
			Wdwait.until(ExpectedConditions.invisibilityOf(DeleteDialogYes));
			WebElement MsgElement = driver.findElement(By.xpath("//p-toast//p-toastitem"));
			return MsgElement.getText();
		}
		else if  (Confirmation.equalsIgnoreCase("No")) {
			action.moveToElement(DeleteDialogNo).click().build().perform();;

		}
		return"NA";
	}
}

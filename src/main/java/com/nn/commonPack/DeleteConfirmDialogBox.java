package com.nn.commonPack;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteConfirmDialogBox {

	WebDriver driver;
	Actions action;

	
	public DeleteConfirmDialogBox(WebDriver wdriver) {
		driver=wdriver;
		action =new Actions(driver);
		PageFactory.initElements(driver,this);

	}

	@FindBy(xpath="//p-confirmdialog//div[1]/div[1]/span") WebElement DeleteDialogTitle;
	@FindBy(xpath="//p-confirmdialog//div[3]/button[2]") WebElement DeleteDialogYes;

	@FindBy(xpath="//p-confirmdialog//div[3]/button[1]") WebElement DeleteDialogNo;


	public String GetDeleteDialogBoxTitle() {

		return DeleteDialogTitle.getText();
	}
	
	public void ClickDeleteConfirmation(String Confirmation) {

		if (Confirmation.equalsIgnoreCase("Yes")) {
			action.moveToElement(DeleteDialogYes).click().build().perform();;
		}
		else if  (Confirmation.equalsIgnoreCase("No")) {
			action.moveToElement(DeleteDialogNo).click().build().perform();;

		}
	}
}

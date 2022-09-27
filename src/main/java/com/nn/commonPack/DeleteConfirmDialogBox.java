package com.nn.commonPack;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteConfirmDialogBox {

	WebDriver driver;
	Actions action;
	WebDriverWait Wdwait;

	
	public DeleteConfirmDialogBox(WebDriver wdriver) {
		System.out.println("Home page constructor");
		driver=wdriver;
		action =new Actions(driver);
		PageFactory.initElements(driver,this);
		Wdwait = new WebDriverWait(driver,Duration.ofSeconds(30));

	}

	@FindBy(xpath="//p-confirmdialog//div[1]/div[1]/span") WebElement DeleteDialogTitle;
	@FindBy(xpath="//p-confirmdialog//div[3]/button[2]") WebElement DeleteDialogYes;

	@FindBy(xpath="//p-confirmdialog//div[3]/button[1]") WebElement DeleteDialogNo;


	public String GetDeleteDialogBoxTitle() {
		Wdwait.until(ExpectedConditions.visibilityOf(DeleteDialogTitle));

		return DeleteDialogTitle.getText();
	}
	
	public void ClickDeleteConfirmation(String Confirmation) {
		Wdwait.until(ExpectedConditions.visibilityOf(DeleteDialogYes));

		if (Confirmation.equalsIgnoreCase("Yes")) {
			action.moveToElement(DeleteDialogYes).click().build().perform();;
		}
		else if  (Confirmation.equalsIgnoreCase("No")) {
			action.moveToElement(DeleteDialogNo).click().build().perform();;

		}
	}
}

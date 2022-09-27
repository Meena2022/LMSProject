package com.nn.commonPack;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProgramSaveEditPage {

	WebDriver driver;
	Actions action;
	
	public ProgramSaveEditPage(WebDriver wdriver) {
		System.out.println("Home page constructor");
		driver=wdriver;
		action =new Actions(driver);
		PageFactory.initElements(driver,this);

	}
	
	@FindBy(xpath="//div[@role='dialog']") WebElement ProgramDialog;
	//@FindBy(id="pr_id_2-label") WebElement EditDialogTitle;
	@FindBy(xpath="//p-dialog//div[@role='dialog']/div/span") WebElement lblDialogTitle;

	//@FindBy(id="") WebElement DeleteConfirmationPopup;


	@FindBy(id = "programName") WebElement txtProgName;
	@FindBy(id = "programDescription") WebElement txtProgDescription;
	@FindBy(xpath="//p-radiobutton[@ng-reflect-input-id='Active']") WebElement statusActive;
	@FindBy(xpath="//p-radiobutton[@ng-reflect-input-id='Inactive']") WebElement statusInActive;
	@FindBy(xpath = "//button[@label='Cancel']") WebElement btnCancel;
	@FindBy(xpath = "//button[@label='Save']") WebElement btnSave;
	//@FindBy(xpath = "//p-dialog//div[@role='dialog']/div[3]/button[2]") WebElement btnSave;

	

	

	public boolean IsProgramDialogVisible() {
		return ProgramDialog.isDisplayed();
	}

	public String getDetailFormTitle() {
		return lblDialogTitle.getText();
	}
	
	public void EnterProgramDetails(String name,String desc,String active) {
		txtProgName.clear();
		txtProgName.sendKeys(name);
		txtProgDescription.clear();
		txtProgDescription.sendKeys(desc);
		if(active.equals("Active")) {
			action.moveToElement(statusActive).click().build().perform();;}
		else {
			action.moveToElement(statusInActive).click().build().perform();;}
	}
	
	public void ClickConfirmation(String status) throws InterruptedException {
		if (status.equalsIgnoreCase("Save")) {
			action.moveToElement(btnSave).click().build().perform();
		}
		if (status.equalsIgnoreCase("Cancel")){
			action.moveToElement(btnCancel).click().build().perform();
		}
	}
}

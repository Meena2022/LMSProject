package com.nn.commonPack;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProgramSaveEditPage {

	WebDriver driver;
	Actions action;
	
	public ProgramSaveEditPage(WebDriver wdriver) {
		driver=wdriver;
		action =new Actions(driver);
		PageFactory.initElements(driver,this);

	}
	
	@FindBy(xpath="//div[@role='dialog']") WebElement ProgramDialog;
	@FindBy(xpath="//p-dialog//div[@role='dialog']/div/span") WebElement lblDialogTitle;



	@FindBy(id = "programName") WebElement txtProgName;
	@FindBy(id = "programDescription") WebElement txtProgDescription;
	@FindBy(xpath="//p-radiobutton[@ng-reflect-input-id='Active']") WebElement statusActive;
	@FindBy(xpath="//p-radiobutton[@ng-reflect-input-id='Inactive']") WebElement statusInActive;
	@FindBy(xpath = "//button[@label='Cancel']") WebElement btnCancel;
	@FindBy(xpath = "//button[@label='Save']") WebElement btnSave;

	

	

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
	
	public void ClickConfirmation(String status)   {
		if (status.equalsIgnoreCase("Save")) {
			action.moveToElement(btnSave).click().build().perform();
		}
		if (status.equalsIgnoreCase("Cancel")){
			action.moveToElement(btnCancel).click().build().perform();
		}
	}
}

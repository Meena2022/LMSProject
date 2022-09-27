package com.nn.commonPack;




import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BatchSaveEditPage {

	WebDriver driver;
	Actions action;
	
	@FindBy(xpath= "//input[@id='batchName']")
	WebElement txtBatchName;

	@FindBy(xpath= "//input[@id='batchDescription']")
	WebElement txtBatchDescription;
	
	@FindBy(xpath= "//div[3]/p-dropdown/div/div[2]")
	WebElement dropdownBatchProgram;

	@FindBy(xpath= "//div[2]/p-radiobutton")
	WebElement radBatchActiveStatus;

	@FindBy(xpath= "//div[3]/p-radiobutton")
	WebElement  radBatchInActiveStatus;

	@FindBy(xpath= "//input[@id='batchNoOfClasses']")
	WebElement txtBatchNoClasses;

	@FindBy(xpath= "//div/div/div[3]/button[2]")
	WebElement btnSave;
	
	@FindBy(xpath= "//div/div/div[3]/button[1]")
	WebElement btnCancel;
	
	@FindBy(xpath= "//*[@id='fbConsole']/div[10]/span")
	WebElement txtMessage;
	
	@FindBy(xpath= "//p-dropdown//p-dropdownitem[1]//li[1]")
	WebElement firstdrpdownElement;
	
	@FindBys({
		@FindBy(xpath = "//p-dropdown//p-dropdownitem//li/span") 
	})List<WebElement> programList;
	 //
	@FindBy(xpath="//div[@role='dialog']") WebElement PageDialog;
	@FindBy(xpath="//p-dialog//div[@role='dialog']/div/span") WebElement lblDialogTitle;

	public boolean IsPrageeDialogVisible() {
		return PageDialog.isDisplayed();
	}
	
	public String getDetailFormTitle() {
		return lblDialogTitle.getText();
	}
	
	//
	public BatchSaveEditPage(WebDriver wdriver) {
		System.out.println("Home page constructor");
		driver=wdriver;
		action =new Actions(driver);
		PageFactory.initElements(driver,this);
		//Wdwait = new WebDriverWait(driver,Duration.ofSeconds(30));

	}
	
	public void clickSave()
	{
		//btnSave.click();
		action.moveToElement(btnSave).click().build().perform();
	}

	public void clickCancel()
	{
		//btnCancel.click();
		action.moveToElement(btnCancel).click().build().perform();

	}
	
	public void setBatchName(String batchname)
	{
		System.out.println("batchname");
		txtBatchName.clear();
		txtBatchName.sendKeys(batchname);
		
	}

	public void setBatchDesc(String batchdesc)
	{
		txtBatchDescription.clear();
		txtBatchDescription.sendKeys(batchdesc);
	}
	
	public void selectBatchProgram(String ProgramName)
	{
		dropdownBatchProgram.click();
		action.moveToElement(firstdrpdownElement).click().build().perform();
		/*List<String> dropDownList = new ArrayList<String>();
		for(WebElement item:programList){
		if ( item.getText() == ProgramName) 
		{
			System.out.println(item.getText());
			action.moveToElement(item).click().build().perform();
		}
			
			
		}*/
	
	}
	
	public void clickRadActive()
	{
		radBatchActiveStatus.click();
	}
	public void clickRadInactive()
	{
		radBatchInActiveStatus.click();
	}

	public void setBatchNoClasses(int batchclasses)
	{
		txtBatchNoClasses.clear();
		txtBatchNoClasses.sendKeys(Integer.toString(batchclasses));
	}
	
	public String getMessage(String Message)
	{
		return txtMessage.getText();
	}
	
	public void verifyFieldsDisplay()
	{
		
		
		
	}
	public void selectBatchStatus()
	{
		// Admin selects Batch status
				boolean status = radBatchActiveStatus.isSelected();

				if (status == true) {
					radBatchActiveStatus.click();
				} else {
					radBatchInActiveStatus.click();
				}
	}
	
public void addBatch(String batchName, String batchDesc, String batchStatus, String batchNoOfClasses) {
		
		txtBatchName.sendKeys(batchName);
		txtBatchDescription.sendKeys(batchDesc);
		
		if(batchStatus.equalsIgnoreCase("Active")) {
			
			if(!radBatchActiveStatus.isSelected())
				radBatchActiveStatus.click();
		}
		
		else if(batchStatus.equalsIgnoreCase("InActive")) {
			
			if(!radBatchInActiveStatus.isSelected())
				radBatchInActiveStatus.click();
		}
		
}
}
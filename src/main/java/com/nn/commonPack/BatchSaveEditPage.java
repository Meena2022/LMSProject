package com.nn.commonPack;




import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.nn.base.Base;

public class BatchSaveEditPage extends Base{

	//WebDriver driver;
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
		@FindBy(xpath = "//p-dropdownitem//li']") 
	})List<WebElement> programList;
	 
	
	@FindBy(xpath="//div[@role='dialog']") WebElement PageDialog;
	@FindBy(xpath="//p-dialog//div[@role='dialog']/div/span") WebElement lblDialogTitle;
	

	public BatchSaveEditPage( ) {
		action =new Actions(driver);
		PageFactory.initElements(driver,this);
	}
	
	public boolean IsPageDialogVisible() {
		Wdwait.until(ExpectedConditions.visibilityOf(PageDialog));
		return PageDialog.isDisplayed();
	}
	public String getDetailFormTitle() {
		return lblDialogTitle.getText();
	}
	
	
	public String clickSave(){
		action.moveToElement(btnSave).click().build().perform();
		Wdwait.until(ExpectedConditions.invisibilityOf(btnSave));

		WebElement MsgElement = driver.findElement(By.xpath("//p-toast//p-toastitem"));
		return MsgElement.getText();
	}

	public String clickCancel(){
		action.moveToElement(btnCancel).click().build().perform();
		return "NA";
	}

	
	public void selectBatchProgram(String ProgramName){
		dropdownBatchProgram.click();
		List<WebElement> programList = driver.findElements(By.xpath("//p-dropdownitem//li"));
		for(WebElement item:programList){
			if (item.getText().equalsIgnoreCase(ProgramName)) {
					action.moveToElement(item).click().build().perform();
					break;}
		}
	}
	

	public String getMessage(String Message){
		return txtMessage.getText();
	}
	
	
	public void selectBatchStatus(String BatchStatus){
		if (BatchStatus.equalsIgnoreCase("Active")) {
			action.moveToElement(radBatchActiveStatus).click().build().perform();
		}else {
			action.moveToElement(radBatchInActiveStatus).click().build().perform();
		}

	}
	
	
	public void addBatch(String batchName, String batchDesc,String ProgramName,String batchStatus, int batchNoOfClasses) {
		txtBatchName.clear();
		txtBatchName.sendKeys(batchName);
		txtBatchDescription.clear();
		txtBatchDescription.sendKeys(batchDesc);
		selectBatchProgram(ProgramName);
		selectBatchStatus(batchStatus);
		txtBatchNoClasses.clear();
		txtBatchNoClasses.sendKeys(Integer.toString(batchNoOfClasses));
	}
}
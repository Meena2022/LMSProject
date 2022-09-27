package com.nn.commonPack;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class CommonElement {

	WebDriver driver;
	Actions action;
	
	public CommonElement(WebDriver wdriver) {
		System.out.println("Home page constructor");
		driver=wdriver;
		action =new Actions(driver);
		PageFactory.initElements(driver,this);
		System.out.println("Common Element constructor");
	}
	
	//Page Common Header Element
	@FindBy(xpath="//mat-card-title/div") WebElement lblPageHeaderTitle;
	@FindBy(xpath = "//mat-card-title/div[2]/div[2]//input") WebElement txtSearch;
	@FindBy(id="new") WebElement btnAddnew;
	@FindBy(xpath="//button[@id='new']/span[2]") WebElement lblAddnew;


	//Table Header Element
	@FindBy(xpath="//thead/tr[1]/th[1]") WebElement checkBoxMultipleSelect;
	@FindBy(xpath="//mat-card-title//button[@icon='pi pi-trash']") WebElement iconMultipleDelete;
	
	//@FindBy(xpath="//mat-card-title/div[2]//button[@icon=\"pi pi-trash\"]") WebElement btnDeleteAll;
	@FindBys({
		@FindBy(xpath = "//table//p-sorticon") 
	}) List<WebElement> btnSort;
	
	@FindBys({
		@FindBy(xpath = "//tbody//td[2]") 
	})List<WebElement> sortedProgramNameList;
	@FindBys({
		@FindBy(xpath = "//tbody//td[3]") 
	})List<WebElement> sortedProgramDescList;
	@FindBys({
		@FindBy(xpath = "//tbody//td[4]") 
	})List<WebElement> sortedProgramStatusList;
	
	@FindBys({
		@FindBy(xpath = "//table//th") 
	})List<WebElement> PageGridTable;
	
	//Table Body Element
	@FindBys({
		@FindBy(xpath = "//table//tbody//tr") 
	})List<WebElement> PageGridDetail;
	
	@FindBys({
		@FindBy(xpath = "//tbody//td[1]") 
	})List<WebElement> checkboxSingleSelect; 
	
	@FindBys({
		@FindBy(xpath = "//button[@icon='pi pi-pencil']") 
	})List<WebElement> iconEdit;
		
	@FindBys({
		@FindBy(xpath = "//button[@icon='pi pi-trash']") 
	})List<WebElement> iconDelete;
	
	//Footer Element
	
	@FindBy(xpath = "//p-paginator//div/span") WebElement lblPaginationEntries;
	@FindBy(xpath = "//p-paginator//span/button[1]") WebElement btnFirstpage;
	@FindBy(xpath = "//p-paginator//span/button[2]") WebElement btnSecondpage;
	@FindBy(xpath = "//p-paginator//div/button[2]") WebElement btnPreviouspage;
	@FindBy(xpath = "//p-paginator//div/button[3]") WebElement btnNextpage;
	@FindBy(xpath = "//p-paginator//div/button[4]") WebElement btnLastspage;
	@FindBy(xpath = "//p-table/div/div[2]/div") WebElement lblToalCount;
	
	@FindBys({
			@FindBy(xpath = "//p-paginator/div/button") 
	})List<WebElement> btnPagination;
	
	// Page Header Content Methods
	
	public boolean IsPageLoaded(String Page) {
		List<String> tblHeading = new ArrayList<String>();
		tblHeading=prepareList(PageGridTable);
		System.out.println(tblHeading +"   "+Page);
		if (Page.equalsIgnoreCase("Program")) {
			if (tblHeading.contains("Program Name") && tblHeading.contains("Program Status")){
				return true;}
		}
		if (Page.equalsIgnoreCase("Batch")) {
			if (tblHeading.contains("Batch Name") && tblHeading.contains("Batch Status")){
				return true;}
		}
		if (Page.equalsIgnoreCase("Assignment")) {
			if (tblHeading.contains("Assignment Name") && tblHeading.contains("Assignment Grade")){
				return true;}
		}
		return false;
	}
	
	public String GetPageHeaderTitle() {
		return lblPageHeaderTitle.getText();
	}
	
	public String GetAddButtonText() {
		return lblAddnew.getText();
	}
	public void ClickMultiDeleteIcon() {
		action.moveToElement(iconMultipleDelete).click().build().perform();
	}
	
	public void EnterSearchContent(String content) {
		txtSearch.clear();
		txtSearch.sendKeys(content);
	}
	
	public void ClickNewButton() {
		action.moveToElement(lblAddnew).click().build().perform();
	}
		
	public boolean IsAddButtonDisplayed() {
		return btnAddnew.isDisplayed();
	}
	public boolean IsSearchBoxDisplayed() {
		return txtSearch.isDisplayed();
	}
	
	public boolean IsMultiDeleteIconEnabled() {
		return iconMultipleDelete.isEnabled();
	}
		
	//Table Header Content Methods
	
	public void ClickMutiSelectCheckBox() {
		action.moveToElement(checkBoxMultipleSelect).click().build().perform();
	}
	
	public List<String> GetSortedOrder(String fieldClicked)  {
		List<String> sortedtList = new ArrayList<String>();
		for(WebElement item:btnSort){
			String fields= item.getDomAttribute("field");
			System.out.println(item.getDomAttribute("field")+fieldClicked);
			action.moveToElement(item).click().build().perform();
				if (fieldClicked.contains("Name")&& fields.contains("Name") ){
					fields= item.getDomAttribute("field");
					sortedtList= prepareList(sortedProgramNameList);
					return sortedtList;
				}
				if(fieldClicked.contains("Description") && fields.contains("description")) {
					fields= item.getDomAttribute("field");
					sortedtList= prepareList(sortedProgramDescList);
					return sortedtList;
				}
				if(fieldClicked.contains("Status")&& fields.contains("status") ) {
					fields= item.getDomAttribute("field");
					sortedtList= prepareList(sortedProgramStatusList);
					return sortedtList;
				}
		} 
		return sortedtList;
	}

	

	
	//Table Body Content Methods
	
	
	
	public int GetRecordCount() {
		return PageGridDetail.size();
	}
	
	public int ClickSingleSelectCheckbox(int index) {
		action.moveToElement(checkboxSingleSelect.get(index)).click().build().perform();
		return index;
	}
	public void ClickSingleEditButton(int index) {
		action.moveToElement(iconEdit.get(index)).click().build().perform();
	}
	
	public void ClickSingleDeleteIcon(int index) {
		action.moveToElement(iconDelete.get(index)).click().build().perform();
	}
	
	
	
	//Page Footer content Methods
	
	public String GetPaginationShowEntries() {
		return lblPaginationEntries.getText();
	}
	
	public String getFooterTotalRecord() {
		return lblToalCount.getText();
	}
	
	
	public boolean IsFirstpageLoaded() {
		action.moveToElement(btnFirstpage).click().build().perform();
		return btnFirstpage.isEnabled();
	}
	public boolean IsFirstpageButtonEnabled() {
		return btnFirstpage.isEnabled();
	}
	public boolean IsSecondpageLoaded() {
		return btnSecondpage.isEnabled();
	}
	
	public boolean IsSecondPageButtonEnabled() {
		return btnSecondpage.isEnabled();
	}
	
	public void ClickPreviousNavigationButton() {
		action.moveToElement(btnPreviouspage).click().build().perform();
	}
	public boolean IsPreviouNavigationDisabled() {
		return btnPreviouspage.isEnabled();
	}
	
	public boolean IsNextNavigationDisabled() {
		return btnNextpage.isEnabled();
	}
	public void ClickNextNavigationButton() {
		action.moveToElement(btnNextpage).click().build().perform();
	}

	public void ClickLastNavigationButton() {
		action.moveToElement(btnLastspage).click().build().perform();
	}
	
	//Sucess Message Popup
	
	public String GetSuccessMessage() {
		WebElement MsgElement = driver.findElement(By.xpath("//p-toast//p-toastitem"));
		String Msg = MsgElement.getText();
		return Msg;
	}
	//Method
	private List<String> prepareList(List<WebElement> we){
		List<String> sortList = new ArrayList<String>();
		for(WebElement item:we){
			sortList.add(item.getText());
		}
		return sortList;
	} 
	
	
}

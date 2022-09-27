package com.nn.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.nn.commonPack.CommonElement;

public class UserPage extends CommonElement{
	WebDriver driver;
	Actions action;
	
	public UserPage(WebDriver wdriver) {
		super(wdriver);
		driver=wdriver;
		action =new Actions(driver);
		PageFactory.initElements(driver,this);
	}
	
}

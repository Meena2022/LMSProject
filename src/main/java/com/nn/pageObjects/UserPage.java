package com.nn.pageObjects;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.nn.commonPack.CommonElement;

public class UserPage extends CommonElement{
	Actions action;
	
	public UserPage( ) {
		action =new Actions(driver);
		PageFactory.initElements(driver,this);
	}
	
}

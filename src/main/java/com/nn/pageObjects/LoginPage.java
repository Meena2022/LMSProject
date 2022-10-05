package com.nn.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nn.base.Base;



public class LoginPage extends Base {
	Actions action;

	@FindBy(id="username")  WebElement txtUser;
	@FindBy(id="password")  WebElement txtPwd;
	@FindBy(xpath ="//button[@id='login']") WebElement btnLogin;

	
	public LoginPage() {
		action=new Actions(driver);
		PageFactory.initElements(driver,this);
	}
	
	


	public void SetLoginData(String user,String password) {
		txtUser.sendKeys(user);
		txtPwd.sendKeys(password);
	}
		
	public String getUrl()  {
		return driver.getCurrentUrl();
	}
	
	public String geApplicationTitle()  {
		return driver.getTitle();
	} 
	
	public boolean isLoginPageVisible()  {
		if (txtUser.isDisplayed() && txtPwd.isDisplayed() && btnLogin.isDisplayed()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public HomePage ClkLoginButtonWithValidDet(String user,String password) {
		SetLoginData(user,password);
		action.moveToElement(btnLogin).click().build().perform();
		return new HomePage();
	}
	
	public String ClkLoginButtonWithInValidDet(String user,String password) {
		SetLoginData(user,password);
		action.moveToElement(btnLogin).click().build().perform();
		By msgError = By.id("errormessage");
		
		String error = driver.findElement(msgError).getText();
		return error;
		
	}	
	public void ReloadLoginPage() {
		driver.navigate().refresh();
	}
	

}

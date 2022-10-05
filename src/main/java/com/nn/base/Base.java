package com.nn.base;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nn.pageObjects.AssignmentPage;
import com.nn.pageObjects.BatchPage;
import com.nn.pageObjects.HomePage;
import com.nn.pageObjects.LoginPage;
import com.nn.pageObjects.UserPage;
import com.nn.utility.ReadConfigFile;


public class Base {
	ReadConfigFile rConfig = new ReadConfigFile();
	public static WebDriver driver;		
	public static WebDriverWait Wdwait;
	

	public String appUrl=rConfig.getLMSUrl();
	public String browserName=rConfig.getBrowser();
	public String userName=rConfig.getUserName();
	public String userPwd=rConfig.getPassword();
	
	public String homeUrl=rConfig.getHomePageUrl();
	
	public Base() {
		}
	
	public int getRandomIndex(int limit) {
		Random random =new Random();
		return random.nextInt(limit);
	}
	
}

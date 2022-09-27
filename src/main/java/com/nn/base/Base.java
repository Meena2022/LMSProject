package com.nn.base;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.nn.utility.ReadConfigFile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	ReadConfigFile rConfig = new ReadConfigFile();
	public WebDriver driver;		
	public String appUrl=rConfig.getLMSUrl();
	public String browserName=rConfig.getBrowser();
	public String userName=rConfig.getUserName();
	public String userPwd=rConfig.getPassword();
	
	public String homeUrl=rConfig.getHomePageUrl();
	
		
	
	public  void SetupBrowser() {
		System.out.println("Base SetupBrowser "+driver);

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(appUrl);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

	}
	
	public  void BrowserClose() {
		driver.close();

	}

	public  void BrowserTearDown() {
		driver.close();
		driver.quit();

	}
	
	public int getRandomIndex(int limit) {
		Random random =new Random();
		return random.nextInt(limit-1);
	}
	
}

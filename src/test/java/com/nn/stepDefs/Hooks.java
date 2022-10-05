package com.nn.stepDefs;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nn.base.Base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Hooks extends Base {
	
	@Before
	public void OpenBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(appUrl);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		Wdwait = new WebDriverWait(driver,Duration.ofSeconds(15));
		driver.manage().window().maximize();
	}
	
	
	
	@After 
	public void CloseBrowser() {
		driver.close();
		driver.quit();
	}
	
}

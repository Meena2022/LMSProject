package com.nn.stepDefs;

import org.openqa.selenium.chrome.ChromeDriver;

import com.nn.base.Base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks extends Base{
	/*
	private Base b;
	
	public Hooks(Base b) {
		this.b = b;
	}

	@Before
	public void initDriver() {
		//System.out.println("Open browser");
		//System.setProperty("webdriver.chrome.driver", "lib/chromedriver 3");
		WebDriverManager.chromedriver().setup();
		b.driver.get(appUrl);
		b.driver = new ChromeDriver();
		b.driver.manage().window().maximize();
		//b.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void teardown() {
		System.out.println("Close browser");
		b.driver.quit();
	}*/
}

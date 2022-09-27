package com.nn.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadConfigFile {

	Properties prop;
	public ReadConfigFile() {
		File srcConfigFile = new File("Configuration/config.properties");
		try {
			FileInputStream readConfigFile = new FileInputStream(srcConfigFile);
			prop = new Properties();
			try {
				prop.load(readConfigFile);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public String getLMSUrl() {
		return prop.getProperty("baseUrl");
	}
	public String getUserName() {
		return prop.getProperty("userName");

	}
	public String getPassword() {
		return prop.getProperty("userPwd");

	}
	public String getBrowser() {
		return prop.getProperty("browser");

	}
	public String getHomePageUrl() {
		return prop.getProperty("homePageUrl");

	}
	
}

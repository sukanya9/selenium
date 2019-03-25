package com.sspart.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverUtils extends ResourcesUtils {
	public static WebDriver driver =null;
	
	public void initiateDriver() {
		if(driver!= null) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\welcome\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		
	}
	}
	public void quitDriver() {
		driver.quit();
	}
}

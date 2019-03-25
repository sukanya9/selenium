package com.sspart.mar_class;

import java.util.Set;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;

//import org.openqa.selenium.chrome.ChromeDriver;

import com.sspart.utils.DriverUtils;

//import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;

public class SeleniumStepDefs extends DriverUtils
{
	@Given("^I am in background step for guru$")
	public void i_am_in_background_step_for_guru() throws Throwable {
			System.out.println("I am in background");
       		initiateDriver();
	}
	
	@Given("^guru home page$")
	public void guru_home_page() throws Throwable {
		System.out.println("I am in given step");
		driver.get(props.getProperty("guru99.url"));
		Thread.sleep(3000);
	}

	@Then("^guru clickhere$")
	public void guru_clickhere() throws Throwable {
		System.out.println("I am in Then step");
		String currentWindowHandle= driver.getWindowHandle();
		driver.findElement(By.linkText(props.getProperty("guru99.clickhere"))).click();
		
		System.out.println("Selected button");
		try{
		Thread.sleep(4000);
		}catch(InterruptedException e)
		{
		e.printStackTrace();
		}
		
		Set<String> windowHandles=driver.getWindowHandles();
		
		for(String eachHandle : windowHandles) {
			driver.switchTo().window(eachHandle);
			Thread.sleep(4000);
			boolean bool = false;
			try {
				bool =driver.findElement(By.xpath(props.getProperty("guru99.emailid"))).isDisplayed();	
			}catch(Exception ignore){}
				
			if(bool) {
				driver.close();
			}
	}
		driver.switchTo().window(currentWindowHandle);
		System.out.println("Window handled");
		driver.quit();
	}
}

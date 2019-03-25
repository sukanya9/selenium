package com.sspart.mar_class;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.sspart.utils.DriverUtils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
//import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Selenium1StepDefs extends DriverUtils{
	static WebDriver driver = null;
	@Given("^I am in background step$")
	public void i_am_in_background_step() throws Throwable {
			System.out.println("I am in background");
       		initiateDriver();
	}
	
	@Given("^I am in given step$")
	public void i_am_in_given_step() throws Throwable {
		System.out.println("I am in given step");
		driver.get(props.getProperty("guru99.url"));
		Thread.sleep(3000);
	}

	@Then("^I am in then step$")
	public void i_am_in_then_step() throws Throwable {
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
				bool =driver.findElement(By.xpath(props.getProperty("guru99.emailid1"))).isDisplayed();	
			}catch(Exception ignore){}
				
			if(bool) {
				driver.close();
			}
	}
		driver.switchTo().window(currentWindowHandle);
		System.out.println("Window handled");
		driver.quit();
	}
	
	@When("^I am in when Step$")
	public void i_am_in_when_Step() throws Throwable {
	    System.out.println("I am in when step");
	}
	
	@But("^I am in but step$")
	public void i_am_in_but_step() throws Throwable {
	    System.out.println("I am in but step");
	}
}
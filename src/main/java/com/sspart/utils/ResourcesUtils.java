package com.sspart.utils;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ResourcesUtils {
	public static Properties props= null;
	
	public void initiateLocators() throws FileNotFoundException, IOException {
	
		props = new Properties();
		File file = new File("cucumber_implementation/src/main/resources/locators/MyLocators.loc");
		props.load(new FileInputStream(file));
		
	}
}

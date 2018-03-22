package com.snaptrude.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.snaptrude.common.Common;
import com.snaptrude.common.ConfigFileReader;
import com.snaptrude.common.PageObject;

public class SubscriptionPage extends PageObject {
	
	Common c = new Common();
	ConfigFileReader read=new ConfigFileReader();

	public SubscriptionPage(WebDriver driver) {
		super(driver);

	}

	

	public void subScribe() throws Exception {

		c.waitForElement(driver, By.id("email"));

		
		c.safeType(driver, By.id("email"),read.readFile("userName"));
		c.safeClick(driver, By.id("login"));

	}

}

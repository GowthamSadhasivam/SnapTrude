package com.snaptrude.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.snaptrude.common.Common;
import com.snaptrude.common.ConfigFileReader;
import com.snaptrude.common.PageObject;

public class LoginPage extends PageObject {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	Common c = new Common();
	ConfigFileReader read=new ConfigFileReader();
	public void loginPage() throws Exception {

		c.safeClick(driver, By.xpath("//div//h2/strong"));
		c.waitForElement(driver, By.id("login_username"));
		c.safeType(driver, By.id("login_username"),read.readFile("userName"));
		c.safeType(driver, By.id("login_password"), read.readFile("password"));
		c.safeClick(driver, By.id("loginForm"));

	}

}

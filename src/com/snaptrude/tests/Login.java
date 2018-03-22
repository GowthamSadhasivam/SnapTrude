package com.snaptrude.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.snaptrude.common.Common;
import com.snaptrude.pages.LoginPage;

public class Login extends Common {

	@Test
	public void loginTest() throws Exception {

		LoginPage l = new LoginPage(driver);
		l.loginPage();
		Common c = new Common();
		c.waitForElement(driver, By.xpath("//*[@id=\"sketch\"]//div[1]/h2"));
		String text = driver.findElement(By.xpath("//*[@id=\"sketch\"]//div[1]/h2")).getText();
		System.out.println(text);
		Assert.assertTrue(text.contains(""), "LoginFailed");

	}

}

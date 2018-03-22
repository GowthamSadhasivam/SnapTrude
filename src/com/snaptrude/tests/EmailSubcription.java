package com.snaptrude.tests;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.snaptrude.common.Common;
import com.snaptrude.pages.SubscriptionPage;

public class EmailSubcription extends Common {
	Common c = new Common();

	@Test
	public void emailSubScribe() throws Exception {

		SubscriptionPage sp = new SubscriptionPage(driver);
		sp.subScribe();

		c.waitForElement(driver, By.xpath("//div[2]/center/h2/b"));
		String text = driver.findElement(By.xpath("//div[2]/center/h2/b")).getText();
		System.out.println(text);
		Assert.assertTrue(text.contains("Thank you very much for Subscribing. We will email you the invite soon."),
				"SubscriptionFailed");
	}
}

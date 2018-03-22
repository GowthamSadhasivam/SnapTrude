package com.snaptrude.common;

import static org.testng.Assert.assertTrue;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Common {
	public WebDriver driver;
ConfigFileReader conf=new ConfigFileReader();
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(conf.readFile("URL"));
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		Assert.assertTrue(pageTitle.equals("Snaptrude"), "Page Title doesn't match");
	}

	public boolean waitForElement(WebDriver driver, By by) {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		boolean isElementVisible = false;
		if (isElementVisible == false) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			isElementVisible = true;
		}
		return isElementVisible;
	}

	public boolean elementPresent(WebDriver driver, By by, int time) {

		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		boolean elementPresentFlag = false;
		try {

			driver.findElement(by);

			elementPresentFlag = true;

		} catch (NoSuchElementException e) {
			System.out.println("not found");

		}

		return elementPresentFlag;
	}

	public void safeType(WebDriver driver, By by, String text) throws InterruptedException {
		boolean elementPresentFlag = false;
		if (elementPresent(driver, by, 8)) {
			driver.findElement(by).sendKeys(text);
		} else {
			assertTrue(elementPresentFlag, "Element : " + String.valueOf(by) + " not present ");
		}
	}

	public void safeClick(WebDriver driver, By by) throws Exception {
		boolean elementPresentFlag = false;
		if (elementPresentFlag = elementVisible(driver, by, 8)) {
			driver.findElement(by).click();
		} else {
			assertTrue(elementPresentFlag, "Elements : " + String.valueOf(by) + " not present ");
		}
	}

	public boolean elementVisible(WebDriver driver, By by, int time) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		boolean elementNotVisibleFlag = false;
		for (int i = 0; i < time; i++) {
			try {
				if (driver.findElement(by).isDisplayed()) {
					System.out.println("Element displayed" + by);
					elementNotVisibleFlag = true;
					break;
				}

			} catch (Exception e) {
				System.out.println("Element : " + by + " not Visible");
			}
			Thread.sleep(1000);
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return elementNotVisibleFlag;
	}

	@AfterClass
	public void tearDown() {

		driver.quit();
	}

}

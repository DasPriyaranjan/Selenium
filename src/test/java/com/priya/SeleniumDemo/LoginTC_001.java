package com.priya.SeleniumDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.TestBase;

public class LoginTC_001 extends TestBase {

	@Test(priority = 1)
	public void verifyTitile() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "OrangeHRM";
		System.out.println("Actual Title: " + actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle, " Title is mismatched ");
	}

	@Test(priority = 2)
	public void verifyLogin() {

		login();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement welcomeNote = driver.findElement(By.xpath("//a[@id='welcome']"));
		wait.until(ExpectedConditions.visibilityOf(welcomeNote));
		String expectedURL = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL, "Login failed ");

	}

}

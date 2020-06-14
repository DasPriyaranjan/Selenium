package com.priya.SeleniumDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.TestBase;

public class UserManagementTC_002 extends TestBase {

	String name = "Hello world";
	String username = name + "abc";

	@Test(priority = 1)
	public void verifyAddUser() {
		login();

		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.id("menu_admin_viewAdminModule")));
		actions.build().perform();
		actions.moveToElement(driver.findElement(By.id("menu_admin_UserManagement")));
		actions.build().perform();
		driver.findElement(By.id("menu_admin_viewSystemUsers")).click();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys(name);
		driver.findElement(By.id("systemUser_userName")).sendKeys(username);
		driver.findElement(By.id("systemUser_password")).sendKeys("Hannah Flores");
		driver.findElement(By.id("systemUser_confirmPassword")).sendKeys("Hannah Flores");
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys(username);
		driver.findElement(By.id("searchBtn")).click();
		WebElement userSearchresult = driver
				.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/form/div[4]/table/tbody/tr/td[2]/a"));
		if (userSearchresult.isDisplayed()) {

			System.out.println("User added successfully");
			Assert.assertTrue(true);
		} else {
			System.out.println("User not added ");
			Assert.assertFalse(true);
		}
	}

	@Test(priority = 2)
	public void verifyDeleteUser() {

	}
}

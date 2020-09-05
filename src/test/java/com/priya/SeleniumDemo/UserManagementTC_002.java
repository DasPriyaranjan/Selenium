package com.priya.SeleniumDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.TestBase;

public class UserManagementTC_002 extends TestBase {

	String name = "Hello world";
	String username = name + System.currentTimeMillis();

	@Test(priority = 1)
	public void verifyAddUser() throws InterruptedException {
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
		driver.findElement(By.id("systemUser_password")).sendKeys("Testgma123");
		driver.findElement(By.id("systemUser_confirmPassword")).sendKeys("Testgma123");
		WebElement element = driver.findElement(By.xpath("//input[@id='btnSave']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		if (element.isDisplayed()) {
			element.click();
		}
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
	public void verifyDeleteUser() throws InterruptedException {
		login();
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.id("menu_admin_viewAdminModule")));
		actions.build().perform();
		actions.moveToElement(driver.findElement(By.id("menu_admin_UserManagement")));
		actions.build().perform();
		driver.findElement(By.id("menu_admin_viewSystemUsers")).click();
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys(username);
		driver.findElement(By.id("searchBtn")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/form/div[4]/table/tbody/tr/td[1]/input"))
				.click();
		driver.findElement(By.id("btnDelete")).click();
		driver.findElement(By.id("dialogDeleteBtn")).click();
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys(username);
		driver.findElement(By.id("searchBtn")).click();

		WebElement userSearchresult1 = driver.findElement(By.xpath("//td[contains(text(),'No Records Found')]"));
		Thread.sleep(3000);
		if (userSearchresult1.isDisplayed()) {

			System.out.println("User deleted successfully");
			Assert.assertTrue(true);
		} else {
			System.out.println("User not deleted ");
			Assert.assertFalse(true);

		}

	}
}

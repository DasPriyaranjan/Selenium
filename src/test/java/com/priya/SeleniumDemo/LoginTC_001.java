package com.priya.SeleniumDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTC_001 {

	private static ChromeDriver driver;
	private String url = "https://opensource-demo.orangehrmlive.com/";

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(url);
	}

	@Test(priority = 1)
	public void verifyTitile() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "OrangeHRM";
		System.out.println("Actual Title: " + actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle, " Title is mismatched ");
	}

	@Test(priority = 2)
	public void verifyLogin() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement welcomeNote = driver.findElementByXPath("//a[@id='welcome']");
		wait.until(ExpectedConditions.visibilityOf(welcomeNote));
		String expectedURL = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL, "Login failed ");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

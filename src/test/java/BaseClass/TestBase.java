package BaseClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

	public String url = "https://opensource-demo.orangehrmlive.com/";
	public String userdir = System.getProperty("user.dir");
	public static WebDriver driver;

	public TestBase() {
		// TODO Auto-generated constructor stub

	}

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", userdir + "/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(url);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	public static void login() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
	}

}

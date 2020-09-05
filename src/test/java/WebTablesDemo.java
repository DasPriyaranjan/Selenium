import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTablesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// driver.get("https://www.w3schools.com/html/html_tables.asp");
		//
		// List<WebElement> elements =
		// driver.findElementsByCssSelector("[id='customers'] tr");
		// for (int i = 0; i < elements.size(); i++) {
		// System.out.println(elements.get(i).getText());
		//
		// }
		// driver.get("https://www.icicibank.com/Personal-Banking/insta-banking/internet-banking/index.page");
		// WebElement el = driver.findElementByCssSelector("[class='closeVisit']");
		// WebDriverWait wait = new WebDriverWait(driver, 10);
		// wait.until(ExpectedConditions.elementToBeClickable(el));
		// el.click();

		driver.get("file:///C:/Users/priya/OneDrive/Desktop/test1.html");
		driver.findElementById("cars").click();
		driver.findElementByXPath("//*[@id=\"cars\"]/option[4]").click();
		driver.findElementByCssSelector("html").click();
		PoonameLover
	

}
}

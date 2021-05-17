import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaScriptExeScroll {

	public static void main(String[] args) throws InterruptedException {

		String key = "webdriver.chrome.driver";
		String value = "./drivers/chromedriver.exe";
		System.setProperty(key, value);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,600)");

		Thread.sleep(3000);

		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");

		List<WebElement> amount = driver.findElements(By.xpath("//div[@class='tableFixHead']//td[4]"));
		int sum = 0;
		for (WebElement getEachAmount : amount) {
			String amt = getEachAmount.getText();
			int a = Integer.parseInt(amt);
			sum = sum + a;
		}

		String expected = driver.findElement(By.xpath("//div[contains(text(),'Total Amount')]")).getText().split(":")[1]
				.trim();
		int exp = Integer.parseInt(expected);

		Assert.assertEquals(sum, exp);

		List<WebElement> values = driver.findElements(By.xpath("//table[@name='courses']//td[3]"));
		int sum1 = 0;
		for (WebElement eachPrice : values) {
			String text = eachPrice.getText();
			int price = Integer.parseInt(text);
			sum1 = sum1 + price;
		}
		System.out.println(sum1);

	}

}

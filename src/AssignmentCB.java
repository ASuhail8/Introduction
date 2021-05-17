import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AssignmentCB {

	public static void main(String[] args) throws InterruptedException {

		String key = "webdriver.chrome.driver";
		String value = "./drivers/chromedriver.exe";
		System.setProperty(key, value);

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Check the first Checkbox and verify if it is successfully checked and Uncheck
		// it again to verify if it is successfully Unchecked

		driver.findElement(By.id("checkBoxOption1")).click();
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
		Thread.sleep(2000);
		driver.findElement(By.id("checkBoxOption1")).click();
		Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());

		// How to get the Count of number of check boxes present in the page
		List<WebElement> allCB = driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println(allCB.size());
		//driver.close();

	}

}

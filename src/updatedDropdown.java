import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class updatedDropdown {

	public static void main(String[] args) throws InterruptedException {

		String key = "webdriver.chrome.driver";
		String value = "./drivers/chromedriver.exe";
		System.setProperty(key, value);

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");

		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());

		List<WebElement> allCB = driver.findElements(By.cssSelector("[type='checkbox']"));
		System.out.println(allCB.size());
		
		Assert.assertEquals(allCB.size(), 6);
		driver.close();
		/*
		 * 
		 * driver.findElement(By.id("divpaxinfo")).click(); Thread.sleep(2000); /* int i
		 * = 1; while (i < 5) {
		 * 
		 * driver.findElement(By.id("hrefIncAdt")).click(); i++; }
		 * 
		 * 
		 * for (int i = 1; i < 5; i++) {
		 * driver.findElement(By.id("hrefIncAdt")).click(); }
		 * 
		 * driver.findElement(By.id("btnclosepaxoption")).click();
		 * System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		 * 
		 */
		// driver.close();
	}

}

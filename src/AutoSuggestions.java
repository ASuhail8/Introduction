import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestions {

	public static void main(String[] args) throws InterruptedException {

		String key = "webdriver.chrome.driver";
		String value = "./drivers/chromedriver.exe";
		System.setProperty(key, value);

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");

		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(2000);

		List<WebElement> autoSuggAddress = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		int count = autoSuggAddress.size();
		System.out.println(count);

		for (WebElement autoSugg : autoSuggAddress) {
			System.out.println(autoSugg.getText());
			if (autoSugg.getText().equalsIgnoreCase("British Indian Ocean Territory")) {
				autoSugg.click();
				break;
			}
		}

		/*
		 * for (int i = 0; i < count; i++) { WebElement autoSug =
		 * autoSuggAddress.get(i); System.out.println(autoSug.getText()); if
		 * (autoSug.getText().equalsIgnoreCase("Australia")) { autoSug.click(); } }
		 */
		// driver.close();
	}

}

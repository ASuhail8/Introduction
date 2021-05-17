import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestion2 {

	public static void main(String[] args) throws InterruptedException {

		String key = "webdriver.chrome.driver";
		String value = "./drivers/chromedriver.exe";
		System.setProperty(key, value);

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/");

		driver.findElement(By.name("q")).sendKeys("Rahul");
		Thread.sleep(2000);

		List<WebElement> options = driver.findElements(By.xpath("//ul[@class='erkvQe']"));
		
		for(WebElement option:options) {
			
			if(option.getText().equalsIgnoreCase("")) {
				
			}
			
		}
	}

}

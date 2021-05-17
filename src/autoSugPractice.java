import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class autoSugPractice {

	public static void main(String[] args) {

		String key = "webdriver.chrome.driver";
		String value = "./drivers/chromedriver.exe";
		System.setProperty(key, value);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.id("autocomplete")).sendKeys("ind");

		List<WebElement> autoSugg = driver
				.findElements(By.cssSelector(".ui-menu.ui-widget.ui-widget-content.ui-autocomplete.ui-front li"));

		for (int i = 0; i < autoSugg.size(); i++) {
			String text = autoSugg.get(i).getText();
			if (text.equals("India")) {
				autoSugg.get(i).click();
				break;
			}
		}
		System.out.println("Text :" + driver.findElement(By.id("autocomplete")).getAttribute("value"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String values = "return document.getElementById(\"hiddentext\").value;";
		String val = (String) js.executeScript(values);
		System.out.println("v "+val);
	}

}

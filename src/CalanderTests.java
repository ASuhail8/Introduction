import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalanderTests {

	public static void main(String[] args) {

		String key = "webdriver.chrome.driver";
		String value = "./drivers/chromedriver.exe";
		System.setProperty(key, value);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.path2usa.com/travel-companions");

		driver.findElement(By.id("travel_date")).click();

		while (!driver.findElement(By.cssSelector("div.datepicker-days th.datepicker-switch")).getText()
				.contains("June")) {
			driver.findElement(By.cssSelector("div.datepicker-days th.next")).click();
		}

		List<WebElement> days = driver.findElements(By.className("day"));

		for (int i = 0; i < days.size(); i++) {
			WebElement day = days.get(i);
			if (day.getText().contains("23")) {
				day.click();
				break;
			}
		}

	}

}

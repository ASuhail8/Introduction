import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class getAllLinks {

	public static void main(String[] args) {

		String key = "webdriver.chrome.driver";
		String value = "./drivers/chromedriver.exe";
		System.setProperty(key, value);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		// all links

		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		System.out.println(allLinks.size());

		// links in footer section
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));

		// System.out.println(driver.findElements(By.xpath("//div[@id='gf-BIG']//a")).size());
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		WebElement columnDriver = footerDriver.findElement(By.xpath("//div[@id='gf-BIG']//td[1]"));
		List<WebElement> column = columnDriver.findElements(By.tagName("a"));
		System.out.println(column.size());
		Actions act = new Actions(driver);
		for (int i = 1; i < column.size(); i++) {
			WebElement col = column.get(i);
			act.keyDown(Keys.LEFT_CONTROL).click(col).perform();
		}
		/*
		 * Set<String> window = driver.getWindowHandles(); for(String wh : window){
		 * driver.switchTo().window(wh).getTitle(); }
		 */
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while (it.hasNext()) {
			String currentWindow = it.next();
			String title = driver.switchTo().window(currentWindow).getTitle();
			System.out.println(title);
		}
	}

}
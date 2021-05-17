import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Childwindow {

	public static void main(String[] args) {

		String key = "webdriver.chrome.driver";
		String value = "./drivers/chromedriver.exe";
		System.setProperty(key, value);

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise");
		driver.findElement(By.cssSelector("a.blinkingText")).click();

		Set<String> wh = driver.getWindowHandles();

		Iterator<String> it = wh.iterator();
		String parent = it.next();
		String child = it.next();

		driver.switchTo().window(child);

		String emailID = driver.findElement(By.cssSelector("p.im-para.red")).getText().split("at")[1].trim()
				.split(" ")[0];

		driver.switchTo().window(parent);

		driver.findElement(By.id("username")).sendKeys(emailID);

	}
}

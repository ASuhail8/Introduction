import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChildAssignment {

	public static void main(String[] args) {

		String key = "webdriver.chrome.driver";
		String value = "./drivers/chromedriver.exe";
		System.setProperty(key, value);

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");

		driver.findElement(By.cssSelector("a[href*='windows']")).click();

		driver.findElement(By.linkText("Click Here")).click();

		Set<String> windows = driver.getWindowHandles();

		Iterator<String> it = windows.iterator();

		String parentWindow = it.next();
		String childWindow = it.next();

		driver.switchTo().window(childWindow);

		System.out.println(driver.findElement(By.cssSelector("div.example")).getText());

		driver.switchTo().window(parentWindow);

		System.out.println(driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText());

	}

}

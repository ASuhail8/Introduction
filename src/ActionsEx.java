import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsEx {

	public static void main(String[] args) {

		String key = "webdriver.chrome.driver";
		String value = "./drivers/chromedriver.exe";
		System.setProperty(key, value);

		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://www.amazon.in/");
		
		
		
		Actions act = new Actions(driver);
		
		act.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().perform();
		
		act.moveToElement(driver.findElement(By.cssSelector("a#nav-link-accountList"))).contextClick().perform();
		
		
		
	}

}

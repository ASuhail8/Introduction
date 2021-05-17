import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo {

	public static void main(String[] args) throws InterruptedException {

		String key = "webdriver.chrome.driver";
		String value = "./drivers/chromedriver.exe";
		System.setProperty(key, value);

		WebDriver driver = new ChromeDriver();

		driver.get("https://login.salesforce.com/?locale=in");

		driver.findElement(By.cssSelector("#username")).sendKeys("username");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("password");
		driver.findElement(By.cssSelector("input[class*='button']")).click();
		Thread.sleep(3000);
		String text = driver.findElement(By.cssSelector("div[role='alert']")).getText();
		
		System.out.println(text);
		
		
		
		driver.close();
		

	}

}

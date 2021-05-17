import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert {

	public static void main(String[] args) throws InterruptedException {

		String key = "webdriver.chrome.driver";
		String value = "./drivers/chromedriver.exe";
		System.setProperty(key, value);

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.id("name")).sendKeys("Suhail");

		driver.findElement(By.cssSelector("#alertbtn")).click();
		Thread.sleep(2000);

		
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

		driver.findElement(By.id("name")).sendKeys("Suhail");

		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(2000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();

	}

}

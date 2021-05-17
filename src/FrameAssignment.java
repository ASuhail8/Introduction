import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameAssignment {

	public static void main(String[] args) {

		String key = "webdriver.chrome.driver";
		String value = "./drivers/chromedriver.exe";
		System.setProperty(key, value);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/");

		driver.findElement(By.linkText("Nested Frames")).click();
		
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");

		System.out.println(driver.findElement(By.cssSelector("div#content")).getText());

	}

}

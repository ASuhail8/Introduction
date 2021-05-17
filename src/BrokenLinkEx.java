import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkEx {

	public static void main(String[] args) throws IOException {

		String key = "webdriver.chrome.driver";
		String value = "./drivers/chromedriver.exe";
		System.setProperty(key, value);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");

		URL u = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) u.openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		System.out.println(conn.getResponseCode());

	}

}

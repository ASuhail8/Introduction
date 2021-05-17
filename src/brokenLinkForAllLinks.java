import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class brokenLinkForAllLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {

		String key = "webdriver.chrome.driver";
		String value = "./drivers/chromedriver.exe";
		System.setProperty(key, value);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		List<WebElement> allLinks = driver.findElements(By.xpath("//div[@id='gf-BIG']//a"));
		SoftAssert sa = new SoftAssert();
		for (int i = 0; i < allLinks.size(); i++) {
			String url = allLinks.get(i).getAttribute("href");
			URL u = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) u.openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			System.out.println(allLinks.get(i).getText());
			if (conn.getResponseCode() > 400) {
				System.out.println("Link with text " + allLinks.get(i).getText() + " broken with status code "
						+ conn.getResponseCode() + " and URL :" + url);
				sa.fail();
			}

		}
		sa.assertAll();

	}

}

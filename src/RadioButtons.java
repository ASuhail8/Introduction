import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class RadioButtons {

	public static void main(String[] args) {

		String key = "webdriver.chrome.driver";
		String value = "./drivers/chromedriver.exe";
		System.setProperty(key, value);

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		/*
		 * if (driver.findElement(By.xpath("//input[@value='OneWay']")).isSelected()) {
		 * Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_view_date2")).
		 * is); }
		 */

		driver.findElement(By.xpath("//input[@value='RoundTrip']")).click();
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			System.out.println("its enabled");
			Assert.assertTrue(true);

		} else {
			Assert.fail();
		}

	}

}

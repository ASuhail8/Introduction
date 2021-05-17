import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class e2e {

	public static void main(String[] args) throws InterruptedException {

		String key = "webdriver.chrome.driver";
		String value = "./drivers/chromedriver.exe";
		System.setProperty(key, value);

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.spicejet.com/");

		driver.findElement(By.cssSelector("input#ctl00_mainContent_ddl_originStation1_CTXT")).click();

		driver.findElement(By.cssSelector("a[value='DEL']")).click();

		Thread.sleep(2000);

		driver.findElement(By.cssSelector("div#glsctl00_mainContent_ddl_destinationStation1_CTNR a[value='BLR']"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight.ui-state-active")).click();

		driver.findElement(By.cssSelector("input[name*='friendsandfamily']")).click();

		driver.findElement(By.cssSelector("div#divpaxinfo")).click();

		Thread.sleep(2000);

		WebElement options = driver.findElement(By.cssSelector("select#ctl00_mainContent_ddl_Adult"));

		Select sel = new Select(options);

		sel.selectByValue("5");

		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
			Assert.fail();

		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']")).click();
		Thread.sleep(2000);

	}

}

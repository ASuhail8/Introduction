import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDown {

	public static void main(String[] args) throws InterruptedException {

		String key = "webdriver.chrome.driver";
		String value = "./drivers/chromedriver.exe";
		System.setProperty(key, value);

		WebDriver driver = new ChromeDriver();

		//driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
		driver.get("https://www.spicejet.com/");
		
		
		
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		
		driver.findElement(By.xpath("//a[@value='AMD']")).click();
		Thread.sleep(2000);
		//parent child relation xpath
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='BLR']")).click();
		
		driver.findElement(By.cssSelector("a[class='ui-state-default ui-state-highlight ui-state-active ui-state-hover']")).click();
		
		
		
	}

}

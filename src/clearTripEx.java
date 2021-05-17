import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class clearTripEx {

	public static void main(String[] args) throws InterruptedException {

		String key = "webdriver.chrome.driver";
		String value = "./drivers/chromedriver.exe";
		System.setProperty(key, value);

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("https://www.cleartrip.com/");

		Thread.sleep(3000);

		driver.findElement(By.id("DepartDate")).click();

		driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight.ui-state-active")).click();

		WebElement adults = driver.findElement(By.name("adults"));

		Select selectAdult = new Select(adults);
		selectAdult.selectByVisibleText("5"); // 5 Adults

		WebElement child = driver.findElement(By.id("Childrens"));

		Select selectChild = new Select(child);
		selectChild.selectByIndex(3); // 3 children

		WebElement infants = driver.findElement(By.id("Infants"));

		Select selInfant = new Select(infants);
		selInfant.selectByValue("1"); // 1 infant

		driver.findElement(By.id("MoreOptionsLink")).click();

		driver.findElement(By.id("AirlineAutocomplete")).sendKeys("Indigo");

		driver.findElement(By.id("SearchBtn")).click();

		System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());
	}
}

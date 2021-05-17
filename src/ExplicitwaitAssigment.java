import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitwaitAssigment {

	public static void main(String[] args) {

		String key = "webdriver.chrome.driver";
		String value = "./drivers/chromedriver.exe";
		System.setProperty(key, value);

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.itgeared.com/demo/1506-ajax-loading.html");

		WebDriverWait wait = new WebDriverWait(driver, 5);
		//driver.findElement(By.linkText("Click to load get data via Ajax!")).click();
		driver.findElement(By.cssSelector("a[href*='loadAjax']")).click();
		WebElement results = driver.findElement(By.id("results"));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#results")));
		wait.until(ExpectedConditions.visibilityOf(results));

		System.out.println(driver.findElement(By.cssSelector("div#results")).getText());

	}

}

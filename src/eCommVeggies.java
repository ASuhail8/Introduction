import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class eCommVeggies {

	public static void main(String[] args) throws InterruptedException {

		String key = "webdriver.chrome.driver";
		String value = "./drivers/chromedriver.exe";
		System.setProperty(key, value);
		// int j = 0;

		String[] names = { "Cucumber", "Brocolli", "Beans", "Potato", "Pumpkin" };

		WebDriver driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		addVeggiesToCart(driver, names);
		driver.findElement(By.cssSelector("a.cart-icon img")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		Assert.assertEquals(driver.findElement(By.cssSelector("span.promoInfo")).getText(), "Code applied ..!");
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();

	}

	public static void addVeggiesToCart(WebDriver driver, String[] names) {

		List<WebElement> allProducts = driver.findElements(By.cssSelector("h4.product-name"));
		// List<String> veggies = Arrays.asList(names);
		for (int i = 0; i < allProducts.size(); i++) {
			String eachProduct = allProducts.get(i).getText();
			// String name = eachProduct.getText().split("-")[0].trim();
			for (int j = 0; j < names.length; j++) {
				if (eachProduct.contains(names[j])) {
					driver.findElement(
							By.xpath("//h4[contains(text(),'" + names[j] + "')]/..//button[text()='ADD TO CART']"))
							.click();
				}
			}
		}
	}

}

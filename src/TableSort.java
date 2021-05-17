import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TableSort {

	public static void main(String[] args) {

		String key = "webdriver.chrome.driver";
		String value = "./drivers/chromedriver.exe";
		System.setProperty(key, value);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();

		driver.findElement(By.cssSelector("th[aria-label='Veg/fruit name: activate to sort column ascending']"))
				.click();

		List<WebElement> list = driver.findElements(By.xpath("//tr/td[1]"));

		List<String> originalList = list.stream().map(s -> s.getText()).collect(Collectors.toList());
		System.out.println(originalList);
		System.out.println("--------------");
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedList);
		System.out.println("--------------");
		Assert.assertTrue(originalList.equals(sortedList));

		// get the price of vegetables using for loop
		/*
		 * for (int i = 0; i < list.size(); i++) { String text = list.get(i).getText();
		 * if (text.equals("Beans")) { System.out
		 * .println(driver.findElements(By.xpath("//tr/td[1]/following-sibling::td[1]"))
		 * .get(i).getText()); } }
		 */

		// get the price of vegetables using streams
		List<String> price;
		do {
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			price = rows.stream().filter(s -> s.getText().contains("Guava")).map(s -> getVeggiesPrice(s))
					.collect(Collectors.toList());
			price.forEach(a -> System.out.println(a));
			if (price.isEmpty()) {
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}

		} while (price.isEmpty());

		List<String> discountPrice;
		do {
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			discountPrice = rows.stream().filter(s -> s.getText().contains("Guava")).map(s -> getDiscountedPrice(s))
					.collect(Collectors.toList());
			discountPrice.forEach(a -> System.out.println(a));
			if (discountPrice.isEmpty()) {
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
		} while (discountPrice.isEmpty());

		driver.findElement(By.id("search-field")).sendKeys("Rice");

		List<WebElement> allRows = driver.findElements(By.xpath("//tr/td[1]"));

		List<WebElement> veggies = allRows.stream().filter(s -> s.getText().contains("Rice"))
				.collect(Collectors.toList());
		Assert.assertEquals(allRows.size(), veggies.size());
	}

	private static String getVeggiesPrice(WebElement s) {
		return s.findElement(By.xpath("following-sibling::td[1]")).getText();
	}

	private static String getDiscountedPrice(WebElement s) {
		return s.findElement(By.xpath("following-sibling::td[2]")).getText();

	}

}

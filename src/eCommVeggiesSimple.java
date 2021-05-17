import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class eCommVeggiesSimple {

	public static void main(String[] args) {

		String key = "webdriver.chrome.driver";
		String value = "./drivers/chromedriver.exe";
		System.setProperty(key, value);

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("https://rahulshettyacademy.com/seleniumPractise");

		for (int i = 0; i < getVeggiesData().size(); i++) {
			getVeggies(driver, getVeggiesData().get(i));
		}

	}

	public static void getVeggies(WebDriver driver, String vegName) {

		driver.findElement(By.xpath("//h4[contains(text(),'" + vegName + "')]/../div[@class='product-action']/button"))
				.click();

	}

	public static List<String> getVeggiesData() {
		String[] veggies = { "Cucumber", "Brocolli", "Beetroot", "Brinjal", "Tomato", "Potato" };
		List<String> listofVeg = Arrays.asList(veggies);
		return listofVeg;

	}

}

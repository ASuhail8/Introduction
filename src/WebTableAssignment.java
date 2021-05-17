import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableAssignment {

	public static void main(String[] args) {

		String key = "webdriver.chrome.driver";
		String value = "./drivers/chromedriver.exe";
		System.setProperty(key, value);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		int noOfRows = driver.findElements(By.xpath("//table[@name='courses']//tr")).size();

		System.out.println(noOfRows);

		int noOfColumns = driver.findElements(By.xpath("//table[@name='courses']//th")).size();
		System.out.println(noOfColumns);

		List<WebElement> sRow = driver.findElements(By.xpath("//table[@name='courses']//tr[3]/td"));

		for (int i = 0; i < sRow.size(); i++) {
			String row = sRow.get(i).getText();
			System.out.println(row);

		}
		
		//Apprach 2
		
		WebElement table = driver.findElement(By.xpath("(//table[@id='product'])[1]"));
		int rows = table.findElements(By.tagName("tr")).size();
		System.out.println(rows);

		int column = table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size();
		System.out.println(column);

		List<WebElement> secondRow = table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
		for (int i = 0; i < secondRow.size(); i++) {

			System.out.println(secondRow.get(i).getText());
		}
	}

}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectClass {

	public static void main(String[] args) {

		String key = "webdriver.chrome.driver";
		String value = "./drivers/chromedriver.exe";
		System.setProperty(key, value);

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");

		WebElement dropdownAddress = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

		Select sel = new Select(dropdownAddress);
		sel.selectByIndex(1);
		System.out.println(sel.getFirstSelectedOption().getText());

		sel.selectByValue("AED");
		System.out.println(sel.getFirstSelectedOption().getText());

		sel.selectByVisibleText("USD");
		System.out.println(sel.getFirstSelectedOption().getText());
		
		
		
		driver.close();
	}

}

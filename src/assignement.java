import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class assignement {

	public static void main(String[] args) {

		String key = "webdriver.chrome.driver";
		String value = "./drivers/chromedriver.exe";
		System.setProperty(key, value);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.id("checkBoxOption2")).click();
		String selectedCheckBox = driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]//label[2]")).getText();
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		Select sel = new Select(dropdown);
		sel.selectByVisibleText(selectedCheckBox);

		driver.findElement(By.id("name")).sendKeys(selectedCheckBox);

		driver.findElement(By.id("alertbtn")).click();

		String alertText = driver.switchTo().alert().getText();

		if (alertText.contains(selectedCheckBox)) {
			System.out.println("Message contains the text");
		} else {
			System.out.println("message doenst containt the text");
		}

	}

}

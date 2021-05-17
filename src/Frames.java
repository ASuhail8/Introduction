import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {

	public static void main(String[] args) {

		String key = "webdriver.chrome.driver";
		String value = "./drivers/chromedriver.exe";
		System.setProperty(key, value);

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		
		Actions act = new Actions(driver);
		//act.dragAndDrop(drag, drop).perform();
		act.clickAndHold(drag).moveToElement(drop).click().perform();
		
		driver.switchTo().defaultContent();
	}

}

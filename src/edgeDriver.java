import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;

public class edgeDriver {

	public static void main(String[] args) {

		System.setProperty("webdriver.edge.verboseLogging", "true");
		EdgeDriverService service = EdgeDriverService.createDefaultService();
		EdgeOptions options = new EdgeOptions();
		EdgeDriver driver = new EdgeDriver(service, options);
		driver.get("http://www.google.com");
		
		
	}

}

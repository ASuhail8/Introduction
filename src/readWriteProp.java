import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class readWriteProp {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Abdulla Suhail\\work\\Introduction\\data.properties");
		Properties prop = new Properties();

		prop.load(fis);

		System.out.println(prop.getProperty("browser"));

		prop.setProperty("browser", "chrome");
		FileOutputStream fos = new FileOutputStream("C:\\Abdulla Suhail\\work\\Introduction\\data.properties");
		prop.store(fos, null);

	}

}

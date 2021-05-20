package frameworkPracticeTestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Class1 {

	@Test
	public void deleteData() {
		System.out.println("Data deleted");
	}

	@Test(groups = { "Smoke" })
	public void firstTest() {
		System.out.println("first test executed");
	}

	@Test(dataProvider = "getData")
	public void secondTest(String username, String password) {
		System.out.println(username);
		System.out.println(password);
	}

	@DataProvider
	public String[][] getData() {

		String[][] arr = { { "sana", "minni" }, { "suhail", "tiddu", }, { "sufiyan", "gingu" } };
		return arr;

	}

}

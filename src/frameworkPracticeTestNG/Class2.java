package frameworkPracticeTestNG;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Class2 {

	@BeforeMethod()
	public void beforeMethod() {
		System.out.println("executing before method");
	}

	@AfterMethod()
	public void afterMethod() {
		System.out.println("executing after method");
	}

	@Test(dataProvider = "getData")
	public void thirdTest(Object value) {
		System.out.println("third test executed");
		System.out.println(value);
	}

	@AfterTest(groups = "Smoke")
	public void closeDb() {
		System.out.println("db closed");
	}

	@DataProvider
	public Iterator<Object> getData() {
		ArrayList<Object> al = new ArrayList<Object>();
		al.add("mohammed");
		al.add("abdulla");
		al.add("suhail");
		al.add(3);
		return al.iterator();

	}

}

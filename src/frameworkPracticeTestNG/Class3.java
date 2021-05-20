package frameworkPracticeTestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Class3 {
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("executing before class");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Running before test");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("running after test");
	}
	
	@Test(groups="Smoke")
	@Parameters("key")
	public void webLogin(String key) {
		System.out.println("web login");
		System.out.println(key);
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("executing After class");
	}
	
	@Test(enabled=false)
	public void mobileLogin() {
		
		System.out.println("mobile login");
	}
	
	@Test(dependsOnMethods = {"webLogin"})
	public void apiwebLogin() {
		System.out.println("api login");
	}
	
	
 
}

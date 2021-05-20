package frameworkPracticeTestNG;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Class4 {
	
	
	@Test(groups="Smoke")
	public void webLogout() {
		
		System.out.println("web logout");
	}
	
	@Test(priority=2)
	public void mobileLogout() {
		
		System.out.println("mobile logout");
	}
	
	@Test(priority=1)
	public void apiwebLogout() {
		System.out.println("api logout");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before suite executed");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After suite executed");
	}
	
	
	
	
	@Test(priority=3)
	public void mobileLogoutSignout() {
		
		System.out.println("mobile logout sign out");
	}
 
}

package salesforce.tests;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import salesforce.base.Base;
import salesforce.pages.LoginPage;

public class Opportunities_TC000_LoginPage extends Base {
	
	@BeforeTest
	public void Pre_Information() {
		Testname="LoginPage Test";
		TestDescription="LoginPage is working or not";
		TestAuthor="Amal";
		TestCategory="Smoke";
	}
	
	@Test
	public void loginpage_test() throws IOException, Exception {
		new LoginPage(driver,node)
		.typeusername()
		.typepassword()
		.clicksubmit()
		.homepage_visible();
	}
	

}

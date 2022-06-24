package salesforce.tests;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import salesforce.base.Base;
import salesforce.pages.LoginPage;

public class Opportunities_TC004 extends Base{
	
	@BeforeTest
	public void Pre_information() {
		SheetName="TC004";
		Testname="TC004-Create Opportunity negative test	";
		TestDescription="Create Opportunity without mandatory fields";
		TestAuthor="Amal";
		TestCategory="sanity";

	}

	@Test(dataProvider="setfile")
		public void TC004_CreateOpp(String Appname,String ModuleName,String Date) throws IOException, Exception {
		
		new LoginPage(driver, Test)
		.typeusername()
		.typepassword()
		.clicksubmit()
		.homepage_visible()
		.click_applauncher()
		.type_app(Appname)
		.select_sales()
		.Salesforce_visible()
		.select_Module(ModuleName)
		.Click_Opportunties_new()
		.selectclosedate(Date)
		.verifyErrorMessage();
		

	}
	
}

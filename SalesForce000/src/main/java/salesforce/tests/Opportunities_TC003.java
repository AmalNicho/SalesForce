package salesforce.tests;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import salesforce.base.Base;
import salesforce.pages.LoginPage;

public class Opportunities_TC003 extends Base{
	
	@BeforeTest
	public void Pre_Information() {
		SheetName="TC003";
		Testname="TC003-Delete Opportunity";
		TestDescription="Delete Opportunity testing";
		TestAuthor="Amal";
		TestCategory="sanity";
	}
	
	@Test(dataProvider="setfile")
	public void Delete_Opportunity(String Appname,String ModuleName,String Opportunityname,String Action) throws IOException, Exception {
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
		.search_opportunity(Opportunityname)
		.Click_SearchOP(Opportunityname)
		.click_dropdown(Action)
		.ClickDeletebox(Action);

	}

}

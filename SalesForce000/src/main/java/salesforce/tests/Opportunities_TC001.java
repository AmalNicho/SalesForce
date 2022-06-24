package salesforce.tests;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import salesforce.base.Base;
import salesforce.pages.LoginPage;

public class Opportunities_TC001 extends Base {
	
	@BeforeTest
	public void Pre_Information() {
		SheetName="TC001";
		Testname="TC001-Create New Opportunity Test";
		TestDescription="Create New Opportunity is working or not";
		TestAuthor="Amal";
		TestCategory="sanity";
	}

	@Test(dataProvider="setfile")
	public void Createnewopportunity(String Appname,String ModuleName,String Opportunityname,String Date,String Stage) throws IOException, Exception {
	new LoginPage(driver, node)
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
	.typeopportunityname(Opportunityname)
	.selectclosedate(Date)
	.selectstage(Stage)
	.selectsave()
	.NewOpportunityPage_visible()
	.verifynewopportunity(Opportunityname);
	}
	
}

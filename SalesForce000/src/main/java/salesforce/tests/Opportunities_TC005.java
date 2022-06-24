package salesforce.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import salesforce.base.Base;

public class Opportunities_TC005 extends Base {
	
	@BeforeTest
	public void Pre_information() {
		SheetName="TC005";
		Testname="TC005-Verify Opportunity by closedate";
		TestDescription="Verify Opportunity by closedate";
		TestAuthor="Amal";
		TestCategory="sanity";

	}
	
	@Test(dataProvider="setfile")
	private void TC005() {
		// TODO Auto-generated method stub

	}

}

package salesforce.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import salesforce.base.Base;

public class NewOpportunityPage extends Base {
	
	public NewOpportunityPage(ChromeDriver driver,ExtentTest node) {
		this.driver=driver;
		this.node=node;
	}
	
	public NewOpportunityPage NewOpportunityPage_visible() throws Exception {
		
		try {
			if (driver.getTitle().equalsIgnoreCase("New Opportunity | Salesforce")) 
			{
				steps("Opportunity Page is opened sucessfully","pass");
			}
			else 
			{
				throw new Exception();
			}
		
		} catch (Exception e) {
			steps("Opportunity page is not opened sucessfully"+e,"fail");
		}
		return this;
	}
	
	public NewOpportunityPage verifynewopportunity(String Opportunityname) throws IOException {

		try {
			String newopportunityname = driver.findElement(By.xpath("//slot[@class='slds-page-header__title slds-m-right--small slds-align-middle clip-text slds-line-clamp']/lightning-formatted-text")).getText();
			
			if (Opportunityname.equals(newopportunityname)) {
				steps(Opportunityname+" Opportunityname is created sucessfully","pass");
			}

			else {
				throw new RuntimeException();
			}
		} catch (IOException e) {
			steps(Opportunityname+" Opportunityname is not created sucessfully","fail");
		}
			return this;
	}

	
}

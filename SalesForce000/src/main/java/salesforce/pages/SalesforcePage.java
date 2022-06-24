package salesforce.pages;


import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import salesforce.base.Base;

public class SalesforcePage extends Base {
	
	public SalesforcePage(ChromeDriver driver,ExtentTest node) {
		this.driver=driver;
		this.node=node;
	}
	public String Opportunity;
	
	public SalesforcePage Salesforce_visible() throws Exception {
		
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(30));
		w.until(ExpectedConditions.titleContains("Home | Salesforce"));
		
		try {
			if (driver.getTitle().equals("Home | Salesforce"))
					{
				steps("Salesforce page is opened sucessfully","pass");
					}
			else {
				throw new Exception();
			}
		} catch (Exception e) {
			steps("Salesforce page is not opened sucessfully"+e,"fail");
		}
		return this;

	}
	
	public SalesforcePage select_Module(String ModuleName) throws IOException {
		try {
			Actions actions = new Actions(driver);
			WebElement ModuleNames = driver.findElement(By.xpath("(//span[text()='"+ModuleName+"'])[1]"));
			actions.moveToElement(ModuleNames).click().perform();
			steps(ModuleName+" ModuleName has been selected scucessfully","pass");
		} catch (Exception e) {
			steps(ModuleName+" ModuleName has not selected scucessfully"+e,"fail");
		}
		return this;
	}
	
	public SalesforcePage Click_Opportunties_new() throws IOException {
		try {
			driver.findElement(By.xpath("//div[text()='New']")).click();
			steps("New Opportunities has been selected sucessfully","pass");
		} catch (Exception e) {
			steps("New Opportunities has not selected sucessfully"+e,"fail");
		}
return this;
	}
	

public SalesforcePage typeopportunityname(String Opportunityname) throws IOException {
	try {
		driver.findElement(By.xpath("(//input[@class='slds-input'])[4]")).sendKeys(Opportunityname);
		Opportunity=Opportunityname;
		steps (Opportunityname+" Opportunityname has been provided sucessfully","pass");
		
	} catch (Exception e) {
		steps (Opportunityname+" Opportunityname has not provided sucessfully"+e,"fail");
	}
return this;	
}	
	
public SalesforcePage selectclosedate(String Date) throws IOException {
	try {
		driver.findElement(By.xpath("//input[@name='CloseDate']")).clear();
		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys(Date);
		steps(Date+" CloseDate has been selected sucessfully","pass");
	} catch (Exception e) {
		steps(Date+" CloseDate has been selected sucessfully"+e,"fail");
	}
return this;
}

public SalesforcePage selectstage(String Stage) throws IOException {
	try {
		driver.findElement(
				By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[1]"))
				.click();
		driver.findElement(By.xpath("//span[text()='"+Stage+"']/ancestor::lightning-base-combobox-item")).click();
		steps(Stage+" Stage has been selected sucessfully","pass");
	} catch (Exception e) {
		steps(Stage+" Stage has not selected sucessfully"+e,"fail");
	}
return this;
	}


public SalesforcePage search_opportunity(String Opportunityname) throws IOException {
	
	try {
		driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-grow slds-input-has-icon slds-input-has-icon_left-right']/input")).sendKeys(Opportunityname);
	steps(Opportunityname+" Opportunityname has been search sucessfully","pass");
	} catch (Exception e) {
		steps(Opportunityname+" Opportunityname has not been search sucessfully"+e,"fail");
		}

	return this;

}

public SalesforcePage Click_SearchOP(String Opportunityname) throws IOException {

	try {
		driver.findElement(By.xpath("//a[@title='"+Opportunityname+"']")).click();
		steps(Opportunityname+" Opportunityname has selected sucessfully","pass");
	} catch (Exception e) {
		steps(Opportunityname+" Opportunityname has not selected sucessfully"+e,"fail");
	}
return this;
}

public SalesforcePage click_dropdown(String Action) throws IOException {
	try {
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_icon-border-filled']")).click();
		driver.findElement(By.xpath("//span[text()='"+Action+"']/ancestor::runtime_platform_actions-action-renderer")).click();
	steps(Action+" Action has been selected sucessfully","pass");
	} catch (Exception e) {
		steps(Action+" Action has been selected sucessfully"+e,"fail");
	}
return this;
}

public SalesforcePage changestage(String ChangeStagename) throws IOException {

	try {
		driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='"+ChangeStagename+"']/ancestor::lightning-base-combobox-item")).click();
	steps(ChangeStagename+ "Stage has been changed sucessfully","pass");
	} catch (Exception e) {
		steps(ChangeStagename+ "Stage has not been changed sucessfully"+e,"fail");
		}
return this;	

}

public SalesforcePage typedescription(String description) throws IOException {
	try {
		driver.findElement(By.xpath("//textarea[@class='slds-textarea']")).sendKeys(description);
		steps(description+" description has been provided sucessfully","pass");
	} catch (Exception e) {
		steps(description+" description has been provided sucessfully"+e,"fail");
	}
return this;
}

public SalesforcePage select_status(String status) throws IOException {
try {
	WebElement installstatus = driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[4]"));
	Actions actions = new Actions(driver);
	actions.moveToElement(installstatus).click().perform();
	driver.findElement(By.xpath("//span[text()='"+status+"']/ancestor::lightning-base-combobox-item")).click();
	steps(status+" Status has been selected sucessfully","pass");
} catch (Exception e) {
	steps(status+" Status has not  selected sucessfully"+e,"fail");
}
return this;	

}

public SalesforcePage ClickDeletebox(String Action) throws IOException {
	try {
		driver.findElement(By.xpath("//span[text()='"+Action+"']/ancestor::button")).click();
		steps("Opportunity has been deleted sucessfully","pass");
	} catch (Exception e) {
		steps("Opportunity has been deleted sucessfully"+e,"fail");
	}
return this;
}

public SalesforcePage verifyErrorMessage() throws Exception {
	
	try {
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		List<WebElement> findElements = driver.findElements(By.xpath("//ul[@class='errorsList slds-list_dotted slds-m-left_medium']//a"));
		int size = findElements.size();
		List<String> x=new ArrayList<String>();
		List<String> y=new ArrayList<String>();
		y.add("Opportunity Name");
		y.add("Stage");
			 for (int i = 0; i < size; i++) {
			String text = findElements.get(i).getText();
			x.add(text);
				}
		 for (int i = 0; i < size; i++) {
			 
			 if (x.get(i).equals(y.get(i))) {
				steps("Both Mandatory information has shown","pass");
			}
			 else
			 {
				 throw new Exception();
			 }
			
		 }
	} catch (Exception e) {
		steps("Both Mandatory information has not shown"+e,"fail");
	}
return this;
}




public NewOpportunityPage selectsave() throws IOException {
	try {
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		steps("Save has been selected sucessfully","pass");
	} catch (Exception e) {
		steps("Save has been selected sucessfully","pass");
	}
return new NewOpportunityPage(driver,node);
}


}

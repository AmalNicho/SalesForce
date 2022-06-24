package salesforce.pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;

import salesforce.base.Base;

public class HomePage extends Base {

	public HomePage(ChromeDriver driver, ExtentTest node) {
		this.driver = driver;
		this.node = node;
	}

	public HomePage homepage_visible() throws Exception {

		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(30));
	w.until(ExpectedConditions.titleContains("Lightning Experience"));
		
	//Thread.sleep(30);	
		
		try {
			
			if (driver.getTitle().equals("Lightning Experience")) {
			steps("Login is  done sucessfully", "pass");
			}
			else {
				 throw new Exception();
			}
			
		} catch (Exception e) {
			steps("Login is not done sucessfully"+e, "fail");
		}
		return this;

	}

	
	public HomePage click_applauncher() throws IOException {
		
		try {
			Actions actions = new Actions(driver);
			WebElement AppLauncher = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
			actions.moveToElement(AppLauncher).click().perform();
			steps("AppLauncher has selected sucessfully","pass");
		} catch (Exception e) {
			steps("AppLauncher has selected sucessfully"+e,"fail");
		
		}
		return this;

	}
	
	public HomePage type_app(String Appname) throws IOException {
		
		try {
			driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys(Appname);
			steps("Appname has provided sucessfully","pass");
		} catch (Exception e) {
			steps("Appname has not provided sucessfully"+e,"fail");
		}
return this;
	}
	
	public HomePage Appviewall() throws IOException {
		try {
			driver.findElement(By.xpath("//button[text()='View All']")).click();
			steps("Viewall has been clicked sucessfully","pass");
		} catch (Exception e) {
			steps("Viewall has not been clicked sucessfully"+e,"fail");
		}
		return this;
	}
	
	public void typeandselectmodule(String Appinformation) throws IOException {
		try {
			driver.findElement(By.xpath("(//div[@class='slds-form-element__control slds-grow slds-input-has-icon slds-input-has-icon_left-right']/input)")).sendKeys(Appinformation);
			driver.findElement(By.xpath("//lightning-formatted-rich-text[@class='slds-rich-text-editor__output']//mark[text()='"+Appinformation+"'")).click();
			steps("Module  has been selected sucessfully","pass");
		} catch (Exception e) {
			steps("Module  has not been selected sucessfully"+e,"fail");
		}

	}
	
	
	public SalesforcePage select_sales() throws IOException {
		try {
			
			
			driver.findElement(By.xpath("//img[@src='https://quadrantresource3-dev-ed.my.salesforce.com/logos/Salesforce/SalesCloud/logo.png']")).click();
			steps("Sales has selected sucessfully","pass");
		} catch (Exception e) {
			steps("Sales has not selected sucessfully"+e,"fail");		
		}
		
		return new SalesforcePage(driver, node);

	}
}

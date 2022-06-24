package salesforce.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import salesforce.base.Base;

public class LoginPage extends Base {
	
	public LoginPage(ChromeDriver driver, ExtentTest node) {
	this.driver=driver;	
	this.node=node;
	}

	public LoginPage typeusername() throws IOException {
		try {
			
			driver.findElement(By.id("username")).sendKeys(prop.getProperty("Username"));
			steps(prop.getProperty("Username")+"Username is provided Sucessfully","pass");
		} catch (Exception e) {
			steps(prop.getProperty("Username")+"Username is not provided Sucessfully"+e,"fail");	
			
		}
		return this;
	}
	
	public LoginPage typepassword() throws IOException {
		try {
			driver.findElement(By.id("password")).sendKeys(prop.getProperty("Password"));
			steps(prop.getProperty("Password")+"Password is provided Sucessfully","pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			steps(prop.getProperty("Password")+"Password is not provided Sucessfully"+e,"fail");
		}
		return this;

	}
	
	public HomePage clicksubmit() throws IOException {
		try {
			driver.findElement(By.id("Login")).click();
		
			steps("Login is clicked Sucessfully","pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			steps("Login is not clicked Sucessfully"+e,"fail");
		}
		return new HomePage(driver, node);
	}
}

package rough;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Accounts_TC001_Rough {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password@123");
		driver.findElement(By.id("Login")).click();
		Actions actions = new Actions(driver);
		Thread.sleep(30);
		WebElement AppLauncher = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		actions.moveToElement(AppLauncher).click().perform();
		
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		driver.findElement(By.xpath("(//div[@class='slds-form-element__control slds-grow slds-input-has-icon slds-input-has-icon_left-right']/input)")).sendKeys("Accounts");
		driver.findElement(By.xpath("//lightning-formatted-rich-text[@class='slds-rich-text-editor__output']//mark[text()='Accounts']")).click();
		Thread.sleep(30);
		driver.findElement(By.xpath("//div[text()='New']")).click();
		
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("XX");
		//Thread.sleep(10);
//		
//		WebElement a = driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[2]"));
//		
//		driver.executeScript("arguments[0].click();", a);
//		
//		WebElement b = driver.findElement(By.xpath("(//lightning-base-combobox-item[@class='slds-media slds-listbox__option slds-media_center slds-media_small slds-listbox__option_plain'])[2]//span[text()='Prospect']"));
//		
//		driver.executeScript("arguments[0].click();", b);
//		
//WebDriverWait W = new WebDriverWait(driver,Duration.ofSeconds(30));
////		
//		W.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[3]"))));
//				
			//	visibilityOf(driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[3]/span"))));
//		
	 WebElement c = driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[3]"));
	driver.executeScript("arguments[0].click();",c);
	 
	 //		//WebElement Cli = driver.findElement(By.xpath("(//div[@class='slds-listbox slds-listbox_vertical slds-dropdown slds-dropdown_fluid slds-dropdown_left'])[5]"));
//	//Actions A = new Actions(driver);
////		
//		//A.moveToElement(Cli).click().perform();
////		
//	//Thread.sleep(10);
	 
	// W.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[@class='slds-media__body']/span[text()='Public']"))));
	
	WebElement d = driver.findElement(By.xpath("//span[@class='slds-media__body']/span[text()='Public']"));
	driver.executeScript("arguments[0].click();",d);
	
	
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(20);
		String text = driver.findElement(By.xpath("//lightning-formatted-text[@class='custom-truncate']")).getText();
		
		System.out.println(text);
		
		
		
	}

}

package rough;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Opportunities_TC002_Edit_Rough {
	
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
	
	//driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	
	WebElement AppLauncher = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
	actions.moveToElement(AppLauncher).click().perform();
	
	driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Sales");
	
	driver.findElement(By.xpath(
			"//img[@src='https://quadrantresource3-dev-ed.my.salesforce.com/logos/Salesforce/SalesCloud/logo.png']"))
			.click();
	Thread.sleep(20);
	WebElement Opportunities = driver.findElement(By.xpath("(//span[text()='Opportunities'])[1]"));

	//driver.executeScript("arguments[0].click();", Opportunities);
	
	actions.moveToElement(Opportunities).click().perform();
	
	driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-grow slds-input-has-icon slds-input-has-icon_left-right']/input")).sendKeys("X");
	driver.findElement(By.xpath("//a[@title='AmalTest']")).click();
	
	driver.findElement(By.xpath("//button[@class='slds-button slds-button_icon-border-filled']")).click();
	
	//driver.findElement(By.xpath("(//lightning-button-menu[@class='menu-button-item slds-dropdown-trigger slds-dropdown-trigger_click'])[2]")).click();
	
	driver.findElement(By.xpath("//span[text()='Edit']/ancestor::runtime_platform_actions-action-renderer")).click();
	
	driver.findElement(By.xpath("//input[@name='CloseDate']")).clear();
	driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("6/20/2022");
	
	driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[2]")).click();

	driver.findElement(By.xpath("//span[text()='Perception Analysis']/ancestor::lightning-base-combobox-item")).click();
	

	
	
	driver.findElement(By.xpath("//textarea[@class='slds-textarea']")).sendKeys("Salesforce");
	
	WebElement installstatus = driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[4]"));
	
	actions.moveToElement(installstatus).click().perform();
	
	driver.findElement(By.xpath("//span[text()='In progress']/ancestor::lightning-base-combobox-item")).click();
	
	driver.findElement(By.xpath("//button[text()='Save']")).click();
	
	driver.getTitle();
}
}

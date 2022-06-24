package rough;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Opportunities_Tc001_Roughwork {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password@123");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(30);

		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Sales");

		driver.findElement(By.xpath(
				"//img[@src='https://quadrantresource3-dev-ed.my.salesforce.com/logos/Salesforce/SalesCloud/logo.png']"))
				.click();
		Thread.sleep(20);

		WebElement Opportunities = driver.findElement(By.xpath("(//span[text()='Opportunities'])[1]"));

		driver.executeScript("arguments[0].click();", Opportunities);

		driver.findElement(By.xpath("//div[text()='New']")).click();

		driver.findElement(By.xpath("(//input[@class='slds-input'])[4]")).sendKeys("X");

		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("6/19/2022");

		driver.findElement(
				By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[1]"))
				.click();

		driver.findElement(By.xpath("//span[text()='Qualification']/ancestor::lightning-base-combobox-item")).click();

		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		System.out.println(driver.getTitle());
	}

	
}

package rough;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Opportunities_TC004_rough {

	public static void main(String[] args) throws Exception {
		
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
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Sales");
		driver.findElement(By.xpath(
				"//img[@src='https://quadrantresource3-dev-ed.my.salesforce.com/logos/Salesforce/SalesCloud/logo.png']"))
				.click();
		Thread.sleep(20);
		WebElement Opportunities = driver.findElement(By.xpath("(//span[text()='Opportunities'])[1]"));
		actions.moveToElement(Opportunities).click().perform();
		driver.findElement(By.xpath("//div[text()='New']")).click();
		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("6/19/2022");

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
				System.out.println("Both Mandatory information has shown");
			}
			 else
			 {
				 throw new Exception();
			 }
			
		}
		
			
	}
	}


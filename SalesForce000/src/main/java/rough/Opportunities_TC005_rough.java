package rough;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Opportunities_TC005_rough {
public static void main(String[] args) throws InterruptedException, ParseException {
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
	
	
	WebElement Opptable = driver.findElement(By.xpath("//table[@class='slds-table forceRecordLayout slds-table--header-fixed slds-table--edit slds-table--bordered resizable-cols slds-table--resizable-cols uiVirtualDataTable']"));
	List<WebElement> row = Opptable.findElements(By.tagName("tr"));
	List<WebElement> header = row.get(0).findElements(By.tagName("th"));
	List<String> xx = new ArrayList<String>();
	List<String> yy = new ArrayList<String>();
	row.get(0).findElement(By.xpath("(//a[@class='toggle slds-th__action slds-text-link--reset '])[5]")).click();
	row.get(0).findElement(By.xpath("(//a[@class='toggle slds-th__action slds-text-link--reset '])[5]")).click();

	System.out.println("till here");
	
	WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(30));
	
	w.until(ExpectedConditions.visibilityOfAllElements(row.get(1).findElements(By.xpath("//td[@class='slds-cell-edit cellContainer']//span[@class='uiOutputDate']"))));
	
	for (int i = 1; i < row.size(); i++) {
		
		List<WebElement> findElements = row.get(i).findElements(By.xpath("//td[@class='slds-cell-edit cellContainer']//span[@class='uiOutputDate']"));
	for (WebElement x : findElements) {
		xx.add(x.getText());
		}
	
	for (String y : xx) {
		yy.add(y);
		}
	
	Collections.sort(yy);
	if (xx.equals(yy)) {
		System.out.println("Matched");
		}
	else {
		System.out.println(" Not Matched");	
	}

	
	
	
	
	
//	int size = row.size();
//	List<Date> Date=new ArrayList<Date>();
//	for (int i = 1; i < size; i++) {
//		//String text = row.get(i).findElements(By.xpath("//td[@class='slds-cell-edit cellContainer']//span[@class='uiOutputDate']")).get(i).getText();
//		
//		List<WebElement> text = row.get(i).findElements(By.xpath("//td[@class='slds-cell-edit cellContainer']//span[@class='uiOutputDate']"));
//		
//		for (int j = 0; j < text.size(); j++) {
//			System.out.println(text.get(j));
//		}
		
//		Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(text);  
//		  Date.add(date1);
//		  List<Date> Date1 = new ArrayList<Date>(Date);  
//		  Collections.sort(Date1);
//		  boolean Sort = Date.equals(Date1);
//		  System.out.println(Sort);
//		  if(Sort) {
//			  System.out.println("Date is sorted");
//		  }
//		  else {
//			  System.out.println("Date is not sorted");
//		  }
//
		  
		
}
}
}
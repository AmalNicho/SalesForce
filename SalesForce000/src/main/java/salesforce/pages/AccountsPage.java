package salesforce.pages;

import java.io.IOException;

import org.openqa.selenium.By;

import salesforce.base.Base;

public class AccountsPage extends Base {
	
public void click_new() throws IOException {
	try {
		driver.findElement(By.xpath("//div[text()='New']")).click();
		steps("New has been selected sucessfully","pass");
	} catch (Exception e) {
		steps("New has not selected sucessfully","fail");
	}

}

}

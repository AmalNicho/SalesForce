package salesforce.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import salesforce.utility.ExcelReadFile;

public class Base {
	
	public ChromeDriver driver;
	public static Properties prop;
	public static ExtentReports Report;
	public  ExtentTest Test,node;
	public String SheetName;
	
	public String Testname, TestDescription,TestAuthor,TestCategory;
	
	
	@BeforeSuite
	public void Start_report() {
		ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter("./Reports/Output.html");
		//extentHtmlReporter.setAppendExisting(true);
		Report = new ExtentReports();
		Report.attachReporter(extentHtmlReporter);
		
	}
	
	@BeforeClass
	public void testcase() {
		Test = Report.createTest(Testname, TestDescription);
		Test.assignAuthor(TestAuthor);
		Test.assignCategory(TestCategory);
	}
	
	@DataProvider
	public String[][] setfile() throws IOException {
		String[][] eReadfile = ExcelReadFile.ereadfile(SheetName);
		return eReadfile;
	}
	
	
	@BeforeMethod
public void Start_Browser() throws IOException {
	
		FileInputStream file = new FileInputStream("./Properties/Property.file");
		prop = new Properties();
		prop.load(file);
		WebDriverManager.chromedriver().setup();
		driver  = new ChromeDriver();
		driver.get(prop.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		node = Test.createNode(Testname);
		
}

	@AfterMethod
	public void End_Browser() {
		driver.close();

	}
	
	@AfterSuite
		public void End_report() {
		Report.flush();

	}
	
	
	public int takesnap() throws IOException {
		int x=(int)(Math.random()*9999+10000);
	File source = driver.getScreenshotAs(OutputType.FILE);
	File destination = new File("./snaps/img"+x+".png");
FileUtils.copyFile(source, destination);	
	
		return x;
	}
	
	public void steps(String StepDescription, String StepStatus) throws IOException {
		if (StepStatus.equalsIgnoreCase("pass"))
		{
			node.pass(StepDescription, MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/IMG"+takesnap()+".png").build()); 
		}
		
		if (StepStatus.equalsIgnoreCase("fail"))
		{
			node.fail(StepDescription, MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/IMG"+takesnap()+".png").build());
			throw new RuntimeException();
		}

	}
}



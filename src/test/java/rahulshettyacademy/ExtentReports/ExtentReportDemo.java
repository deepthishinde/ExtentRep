package rahulshettyacademy.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {
	ExtentReports extent;
	
	@BeforeTest
	public void config() {
		//ExtentReports & ExtentSparkReporter are 2 classes to generate extent report
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);//path where report shud be created
	   reporter.config().setReportName("WebAutomationResults");
	   reporter.config().setDocumentTitle("Test Results");
	   
	    extent=new ExtentReports();
	   extent.attachReporter(reporter);
	   extent.setSystemInfo("Tester", "Deepthi Shinde");
	}
	
	@Test
	public void initialDemo() {
		ExtentTest test=extent.createTest("Initial Demo");
		System.setProperty("webdriver.chrome.driver", "C:\\driver_Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		driver.close();
		//test.fail("Results do not match");
		extent.flush();
	}

}

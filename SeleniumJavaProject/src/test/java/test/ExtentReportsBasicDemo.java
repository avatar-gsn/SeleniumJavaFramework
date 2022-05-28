package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsBasicDemo {
	
	private static WebDriver driver = null;

	public static void main(String[] args) {
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReport.html");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		ExtentTest test = extent.createTest("GoogleSearch Test One");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		test.log(Status.INFO, "Starting Test Case");
		driver.get("http://google.com");
		test.pass("Navigated to Google.com");
		
		//enter text in search text box
		driver.findElement(By.name("q")).sendKeys("Automation step by step");
		test.pass("Entered text in Search box");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//click on search button
		// driver.findElement(By.name("btnK")).click();
		driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);
		test.pass("Pressed the Enter key from keyboard");
		
		driver.close();
		driver.quit();
		test.pass("Browser is closed");
		
		test.info("Test Completed");
		
		ExtentTest test1 = extent.createTest("GoogleSearch Test two");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		test1.log(Status.INFO, "Starting Test Case");
		driver.get("http://google.com");
		test1.pass("Navigated to Google.com");
		
		//enter text in search text box
		driver.findElement(By.name("q")).sendKeys("Automation step by step");
		test1.pass("Entered text in Search box");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//click on search button
		// driver.findElement(By.name("btnK")).click();
		driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);
		test1.fail("Pressed the Enter key from keyboard");
		
		driver.close();
		driver.quit();
		test1.pass("Browser is closed");
		
		test1.info("Test Completed");
		
		extent.flush();
	}

}

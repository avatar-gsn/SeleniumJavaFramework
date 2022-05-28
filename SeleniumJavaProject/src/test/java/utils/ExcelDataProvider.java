package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelDataProvider {
	
	WebDriver driver = null;
	
	@BeforeTest
	public void setupBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test(dataProvider = "test1Data")
	public void test1(String username, String password) throws Exception {
		System.out.println(username+" | "+password);
		
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		Thread.sleep(2000);
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	@DataProvider(name = "test1Data")
	public Object[][] getData() {
		String excelPath = "C:\\JavaProjects\\Automation\\SeleniumJavaProject\\excel\\data.xlsx";
		
		Object data[][] = testData(excelPath, "Sheet1");
		return data;
	}
	
	public Object[][] testData(String excelPath, String sheetName) {
		
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		
		int rowCount = excel.getRowCount();
		int columnCount = excel.getColumnCount();
		
		Object data[][] = new Object[rowCount-1][columnCount];
		
		for(int i = 1;  i < rowCount; i++) {
			for(int j=0; j<columnCount; j++) {
				
				String cellData = ExcelUtils.getCellDataString(i, j);
//				System.out.print(cellData+ " | ");
				data[i-1][j] = cellData;
			}
//			System.out.println();
		}
		return data;
	} 
	
	

}

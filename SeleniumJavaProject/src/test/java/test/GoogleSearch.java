package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearch {
	
	WebDriver driver = null;
	
	@BeforeTest
	public void setUpTest() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}
	
	@Test
	public void googleSearch() {		
		
		// goto google.com
		driver.get("http://google.com");
		
		//enter text in search text box
		driver.findElement(By.name("q")).sendKeys("Automation step by step");
		
		//click on search button
		// driver.findElement(By.name("btnK")).click();
		driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);
		
	}
	
	@AfterTest
	public void tearDownTest() {
		
		//close browser
		driver.close();
		driver.quit();		
		System.out.println("Test completed successfully");
		
	}

}

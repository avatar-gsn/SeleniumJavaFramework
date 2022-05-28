import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserTest {

	public static void main(String[] args) {
		
//		String projectPath = System.getProperty("user.dir");
//		System.out.println("ProjectPath:" +projectPath);
		
//		System.setProperty("webdriver.gecko.driver", projectPath+"/drivers/geckodriver/geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		
//		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://google.com");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("hello");
		
		List<WebElement> listofInputElements =  driver.findElements(By.xpath("//input"));
		
		int count = listofInputElements.size();
		
		System.out.println("Count of input elements: "+count);
		
		driver.close();
	}
}

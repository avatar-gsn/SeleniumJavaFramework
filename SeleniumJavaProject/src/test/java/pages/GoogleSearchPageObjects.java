package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageObjects {
	
	WebDriver driver = null;
	
	By search_textbox = By.name("q");
	
	By search_button = By.name("btnK");
	
	public GoogleSearchPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setTextInSearchbox(String text) {
		driver.findElement(search_textbox).sendKeys(text);
	}
	
	public void clickSearchButton() {
		driver.findElement(search_button).sendKeys(Keys.ENTER);
	}

}

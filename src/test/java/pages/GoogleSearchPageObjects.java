package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageObjects {

	WebDriver driver = null;
	By searchTextbox = By.name("q");
	By searchButton = By.name("btnK");
	
	public GoogleSearchPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setValueInSearchTextbox(String text) {
		driver.findElement(searchTextbox).sendKeys(text);
	}
	
	public void clickSearchButton() {
		driver.findElement(searchButton).sendKeys(Keys.RETURN);
	}
}

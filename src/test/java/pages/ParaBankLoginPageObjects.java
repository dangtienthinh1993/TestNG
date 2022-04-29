package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParaBankLoginPageObjects {

	static WebDriver driver = null;
	static WebDriverWait wait = null;
	public By usernameTextbox = By.name("username");
	public By passwordTextbox = By.name("password");
	public By loginButton = By.xpath(".//input[@value='Log In']");
	public By errorMessage = By.xpath(".//div[@id='rightPanel']//p[contains(text(),"
			+ "'The username and password could not be verified.')]");
	
	public ParaBankLoginPageObjects(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public void setValueInTextbox(By control, String value) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(control));
			driver.findElement(control).sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickLoginButton() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(loginButton));
			driver.findElement(loginButton).click();
		} catch (Exception e) {
			// TODO: handle exception
		}
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
//	public void waitForControlAppear(By control) {
//		wait.until(ExpectedConditions.elementToBeClickable(control));
//	}
	
	public boolean verifyLoginErrorPageDisplayed() {
		WebElement element = null;
		wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
		element = driver.findElement(errorMessage);
		if (element != null) {
			return true;
		} else {
			return false;
		}
	}
	
}

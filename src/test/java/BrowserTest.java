import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPage;

public class BrowserTest {
	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\naugh\\Downloads\\drivers\\chromedriver.exe");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.seleniumhq.org/");
		GoogleSearchPage.textbox_Search(driver).sendKeys("Automation Step by Step");
		GoogleSearchPage.button_Search(driver).sendKeys(Keys.RETURN);
	}

}

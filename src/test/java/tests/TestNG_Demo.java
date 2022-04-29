package tests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.ParaBankLoginPageObjects;
import utils.ExcelDataProvider;

public class TestNG_Demo {

	private static WebDriver driver = null;
	private static WebDriverWait wait = null;
	String projectPath = System.getProperty("user.dir");
	ExcelDataProvider provider = new ExcelDataProvider();
			
	@BeforeTest
	public static void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	@DataProvider(name = "test01")
	public Object [][] getData() {
		String excelPath = projectPath+"/excel/data.xlsx";
		Object data[][] = provider.testData(excelPath, "Sheet1");
		return data;
	}
	
	@Test(dataProvider = "test01")
	public static void parabankLoginFailTest(String username, String password) {
		ParaBankLoginPageObjects parabankLoginPage = new ParaBankLoginPageObjects(driver, wait);
		driver.get("https://parabank.parasoft.com/parabank");
		parabankLoginPage.setValueInTextbox(parabankLoginPage.usernameTextbox, username);
		parabankLoginPage.setValueInTextbox(parabankLoginPage.passwordTextbox, password);
		parabankLoginPage.clickLoginButton();
		assertEquals(parabankLoginPage.verifyLoginErrorPageDisplayed(), true);
	}
	
	@AfterTest
	public static void tearDown() {
		driver.close();
		driver.quit();
	}
}

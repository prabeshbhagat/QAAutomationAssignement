package assign.qa.bookcart.base;

import assign.qa.bookcart.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest {
	public WebDriver driver;
	protected LoginPage lp;
	
	public WebDriver initDriver() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://bookcart.azurewebsites.net/login");
		return driver;
	}
	
	@BeforeClass
	public void setup() {
		driver=initDriver();
		lp= new LoginPage(driver);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
	

}

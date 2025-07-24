package assign.qa.bookcart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import assign.qa.bookcart.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleutil;

	// By Locators
	private By username = By.xpath("//input[contains(@id,'mat-input') and @formcontrolname='username']");
	private By password = By.xpath("//input[contains(@id,'mat-input') and @formcontrolname='password']");
	private By loginBtn = By.xpath(
			"//button/descendant::*[@class='mdc-button__label' and text()='Login']");
	private By usernameLabel = By.xpath("//*[text()=' jsmith']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleutil=new ElementUtil(driver);
	}

	public String loginAndGetUsernameLabel(String un, String pwd)  {
		WebElement username_Txt=eleutil.waitForElementVisible(username, 3000);
		username_Txt.sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginBtn).click();
		
		return eleutil.waitForElementVisible(usernameLabel, 5000).getText();
	}

}

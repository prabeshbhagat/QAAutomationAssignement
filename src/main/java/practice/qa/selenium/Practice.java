package practice.qa.selenium;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.pojo.User;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Practice {

	public static void main(String args[]) {
		
		WebDriver driver = new ChromeDriver();
		
//		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
//		driver.findElement(By.id("input-email")).sendKeys("test data");
//		String domAttribute=driver.findElement(By.id("input-email")).getDomAttribute("value");
//		String domProperty=driver.findElement(By.id("input-email")).getDomProperty("value");
//		System.out.println(domAttribute);
//		System.out.println(domProperty);
//		
//		
//		String domAttribute1=driver.findElement(By.id("input-email")).getDomAttribute("placeholder");
//		String domProperty1=driver.findElement(By.id("input-email")).getDomProperty("placeholder");
//		System.out.println(domAttribute1);
//		System.out.println(domProperty1);
//		
//		Wait<WebDriver> wait1 = new FluentWait<>(driver)
//				.withTimeout(Duration.ofSeconds(20))
//				.pollingEvery(Duration.ofSeconds(5))
//				.ignoring(NoSuchElementException.class)
//				.withMessage("element");
//		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id(""))).sendKeys("fafaf0");
		
		


		// WebDriverWait--->FluentWait-->Wait

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		By locator = By.linkText("Forgotten Password1");
//
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//				.withTimeout(Duration.ofSeconds(10))
//				.pollingEvery(Duration.ofSeconds(2))
//				.ignoring(ElementNotInteractableException.class)
//				.ignoring(NoSuchElementException.class)
//				.ignoring(StaleElementReferenceException.class)
//				.withMessage("Element Not found on the page...");
//		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	
		WebDriverWait wait2=new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(1));
		WebElement ele=wait2.until(ExpectedConditions.elementToBeClickable(locator));
		ele.click();
		
		
		RestAssured.baseURI="https://gorest.co.in";
		
		
	}
	
	public void addUserTest() {
		User user= new User(null, null, null, null);
		RestAssured.baseURI="https://gorest.co.in";
		given()
		.contentType(ContentType.JSON)
		.body(user)
		.when()
		.post("/users")
		.then()
		.assertThat()
		.statusCode(201);

	}

}

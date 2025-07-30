package practice.qa.selenium;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {
	public static void main(String[] args) throws InterruptedException {

		removeDigitsProgram_1();
		// 2.find any xpath using preceding sibling
		// 3.find any xpath webelement in flipakrt page
		numberOfBrokerLinks();

	}

	public static void removeDigitsProgram_1() {
		String s = "pra12esh3";
		String temp = "";

		for (char ch : s.toCharArray()) {
			if (!Character.isDigit(ch)) {
				temp = temp + ch;
			}
		}
		System.out.println(temp);

	}

	public static void numberOfBrokerLinks() throws InterruptedException {
		System.out.println("Inside numberOfBrokerLinks method ");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		By continueShopping=By.xpath("//button[@type='submit']");
		Thread.sleep(2000);
		driver.findElement(continueShopping).click();
		Thread.sleep(5000);
		
		List<WebElement>  linkEle = driver.findElements(By.tagName("a"));
		System.out.println("=============");
		System.out.println("No. of links are "+linkEle.size());
		
		
		List<String> urlList=new ArrayList<String>();

		for (WebElement e : linkEle) {
			String url=e.getDomAttribute("href");
			System.out.println("url="+url);
			urlList.add(url);
			checkBrokenLinks(url);
		}
		//urlList.parallelStream().forEach(e -> checkBrokenLinks(e));
	}
	
	public static void checkBrokenLinks(String linkUrl) {
		
		try {
					
			URI uri = new URI(linkUrl);
			URL url = uri.toURL();

			HttpURLConnection httpUrlConnection= (HttpURLConnection) url.openConnection();
			httpUrlConnection.setConnectTimeout(5000);
			httpUrlConnection.connect();
			
			if(httpUrlConnection.getResponseCode()>=400) {
				System.out.println(linkUrl+"----->"+httpUrlConnection.getResponseMessage()+"is a broken link");
			}else {
				System.out.println(linkUrl+"----->"+httpUrlConnection.getResponseMessage());
			}
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

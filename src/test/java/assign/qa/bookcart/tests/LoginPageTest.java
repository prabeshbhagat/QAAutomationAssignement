package assign.qa.bookcart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import assign.qa.bookcart.base.BaseTest;

public class LoginPageTest extends BaseTest {
	
	
	@Test
	public void loginTest() {
		String actualUserName=lp.loginAndGetUsernameLabel("jsmith", "Pmap@123");
		System.out.println("The actual username is:"+actualUserName);
		Assert.assertEquals(actualUserName, "jsmith","Username is not Matching");
	}

}

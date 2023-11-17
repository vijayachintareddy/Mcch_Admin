package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;


import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_001_LoginPageTest extends BaseClass {

	@Test(groups= {"Regression","Master"})
	void test_login()
	{
		logger.info("*** Starting Tc_001_LoginPage****");
		try {
			
		
		LoginPage lp=new LoginPage(driver);
		
		lp.setEmail(rb.getString("email"));
		//lp.setEmail(randomeString()+"@gamil.com");   //randomly generated email purpose only
		logger.info("Email Entered");
		lp.setPassword(rb.getString("password"));
		logger.info("password Entered");
		
	/*	String password=randomAlphaNumeric();  //for creating password and confirm password purpose use
		lp.setPassword(password);
		lp.setConfirmPassword(password);
		*/
		
		lp.ClickLogin();
		logger.info("Clicked on login button");
		
		String confmsg=lp.getConfirmationMsg();
		Assert.assertEquals(confmsg,"Dashboard","Test failed");
	}
		catch(Exception e) {
			
		logger.error("Test failed");
		Assert.fail();
		
		}
		logger.info("*** Finished Tc_001_LoginPage  ****");
		}
		
	
	
	
	
}

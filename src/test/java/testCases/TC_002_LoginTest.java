package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {

	
	@Test(groups= {"Sanity","Master"})
	public void test_login()
	{
		try {
	
		logger.info("**** Starting Tc_002_Login Test*****");
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(rb.getString("email"));
		lp.setPassword(rb.getString("password"));
		lp.ClickLogin();
		
		MyAccountPage macc= new MyAccountPage(driver);
		macc.isMyDashboardPageExists();
		boolean targetPage=macc.isMyDashboardPageExists();
		Assert.assertEquals(targetPage, true);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("****Finished Tc_002_Login Test*****");
	}
}

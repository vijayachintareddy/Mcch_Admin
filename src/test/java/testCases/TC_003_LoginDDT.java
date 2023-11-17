package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT  extends BaseClass{

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void test_loginDDT(String email,String password,String exp) {
		
		logger.info("***** Starting TC_003_LoginDDT*******");
		
		try {
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(password);
		lp.ClickLogin();
		
		MyAccountPage macc= new MyAccountPage(driver);
		
		boolean targetpage=macc.isMyDashboardPageExists();
		
	
		if(exp.equals("Valid"))
			if(targetpage==true) {
				
				lp.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				
				Assert.assertTrue(false);
			}
	
	
	
	if(exp.equals("Invalid")) {
		if(targetpage==true)
		{
			
			lp.clickLogout();
			Assert.assertTrue(false);
		}
		else
		{
			
			Assert.assertTrue(true);
		}

	
	}
	}catch(Exception e)
	{
		Assert.fail();
	
	}
	 logger.info("******* Finished TC_003_LoginDDT*******");
	 }
	
	
	
	}


	
	


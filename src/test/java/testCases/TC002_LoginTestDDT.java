package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviderss;

public class TC002_LoginTestDDT extends BaseClass{

	@Test(dataProvider = "LoginData",dataProviderClass = DataProviderss.class)
	public void verifyLoginTest(String email,String pwd,String exp) throws InterruptedException
	{
		logger.info("*** TC002_LoginTest started....***");
		try {
		HomePage hm=new HomePage(driver);
		hm.clickMyaccount();
		hm.ClickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		MyAccountPage map=new MyAccountPage(driver);
		boolean macc=map.isMyAccountExist();
		if(exp.equalsIgnoreCase("valid"))
		{
			if(macc==true)
			{
				map.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(macc==true)
			{
				map.clickLogout();
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
		Thread.sleep(1000);
		
		logger.info("*** TC002_LoginTest finish....***");
	}
}

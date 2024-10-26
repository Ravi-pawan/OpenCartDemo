package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{

	@Test
	public void verifyLoginTest()
	{
		logger.info("*** TC002_LoginTest started....***");
		HomePage hm=new HomePage(driver);
		hm.clickMyaccount();
		hm.ClickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(proobj.getProperty("email"));
		lp.setPassword(proobj.getProperty("password"));
		lp.clickLogin();
		
		MyAccountPage map=new MyAccountPage(driver);
		boolean macc=map.isMyAccountExist();
		try {
		Assert.assertEquals(macc, true,"testfailed");
		}catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*** TC002_LoginTest finish....***");
		
	}
}

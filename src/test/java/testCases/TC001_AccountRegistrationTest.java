package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	
    @Test
	public void verify_account_registration( )
	{
        logger.info("***TC001_AccountRegistrationTest Started.... *** ");
        try {
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		logger.info("clicked on Myaccount link");
		hp.clickRegister();
		logger.info("clicked on Register link");
		
		logger.info("Providing Customer Details");
		AccountRegistrationPage regPage=new AccountRegistrationPage(driver);
		regPage.setFirstName(randomeString().toUpperCase());
		regPage.setLastName(randomeString().toUpperCase());
		String email=randomeString()+"@gmail.com";
		regPage.setEmail(email);
		System.out.println(email);
		regPage.setTelephone(randomeNumber());
		String password=randomAlphaNumeric();
		System.out.println(password);
		regPage.setPassword(password);
		regPage.setConfirmPassword(password);
		regPage.setPrivacyPolicy();
		regPage.clickContinue();
		logger.info("validating Expected massage");
		String confmsg=regPage.getConfirmationMsg();
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed");
			logger.debug("Debug logs");
			Assert.assertTrue(false);
		}
        }catch(Exception e)
        {
        	Assert.fail();
        }
        logger.info("*** Finished TC001_AccountRegistrationTest .... *** ");
	}
    
 
	
	
}

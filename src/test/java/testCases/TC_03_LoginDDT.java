package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_03_LoginDDT extends BaseClass {

	@Test(dataProvider="LoginData",dataProviderClass= DataProviders.class)

	public void verifyLoginDDT(String email,String password, String expRes) throws InterruptedException 
	{
		try
		{

			logger.info("Started Execution");

			HomePage hp=new HomePage(driver);
			logger.info("Clicked on My Account Link");
			hp.clickMyAccount();

			hp.clickLoginMain();

			LoginPage lp= new LoginPage(driver);		
			lp.emailField(email);
			lp.passwordField(password);
			lp.clickLogin();
			logger.info("Logged in successfully");
			MyAccountPage map = new MyAccountPage(driver);
			boolean targetPage= map.myAccountText();
			if(expRes.equalsIgnoreCase("Valid"))
			{
				if(targetPage==true)

				{
					map.clickLogout();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);

				}
			}
			if(expRes.equalsIgnoreCase("invalid"))
			{
				if(targetPage==true)

				{
					map.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);

				}
			}
		}	
		catch (Exception e)
		{
			e.printStackTrace();

			Assert.fail("An exception occurred: " + e.getMessage());

		}
		logger.info("Test Completed");

	}	

}
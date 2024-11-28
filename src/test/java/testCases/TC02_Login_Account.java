package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;


import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC02_Login_Account extends BaseClass {
	@Test(groups={"Sanity","Master"})
	public void verifyLogin() {
		logger.info("Started Execution");
		try
		{
		
		HomePage hp=new HomePage(driver);
		//logger.info("Clicked on My Account Link");
		hp.clickMyAccount();
		
		hp.clickLoginMain();
		
		LoginPage lp= new LoginPage(driver);		
		lp.emailField(p.getProperty("email"));
		lp.passwordField(p.getProperty("password"));
		lp.clickLogin();
		logger.info("Logged in successfully");
		MyAccountPage map = new MyAccountPage(driver);
		boolean targetPage= map.myAccountText();
		Assert.assertTrue(targetPage);
		map.viewOrderHistory();
		
		
		}
		catch (Exception e)
		{
			e.printStackTrace();
			
			Assert.fail();
		}
		logger.info("Test Completed");
		
		
	}
	

}

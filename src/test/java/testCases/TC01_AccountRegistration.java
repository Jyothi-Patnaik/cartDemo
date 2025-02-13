package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;



import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC01_AccountRegistration extends BaseClass{
	
	@Test(groups={"Regression","Master"})
	public void verify_accountRegistration() throws InterruptedException 
	{
	   logger.info("***Execution Started***");
	try 
	{
	HomePage hp= new HomePage(driver);
	
	hp.clickMyAccount();
	logger.info("***Click on My account***");
	logger.info("***Click on Register***");
    hp.clickRegister();

	RegistrationPage rp= new RegistrationPage(driver);
	rp.setFirstName(randomString().toUpperCase());
	rp.setLastName(randomString().toLowerCase());
	rp.setemail(randomString()+"@yopmail.com");
	//rp.setNumber(randomNumeric());
	
	String cpassword = p.getProperty("password");
	rp.setpassword(cpassword);
	//rp.setconfirmpassword(cpassword);
	logger.info("***Click on agree***");

	rp.clickAgreeBtn();
	rp.clickConfirmBtn();
	Thread.sleep(5000);
	String msg= rp.getConfirmationMsg();
	if (msg.equals("Your Account Has Been Created!"))
	{
		Assert.assertTrue(true);
		
	}
	else {
		logger.error("xxx Wrong Title xxx");
		logger.debug("Debug tests");
		Assert.assertTrue(false);
	}
	    //Assert.assertEquals(msg,"Your Account Has Been Created!");
	}
	catch(Exception e) {
		e.printStackTrace();
		
		//System.out.println(e.toString());
		//System.out.println(e.getMessage());
		logger.debug("Exception error");
		Assert.fail();
		
		
	}
	logger.info("*******EXECUTION COMPLETED*******");
}

}
	
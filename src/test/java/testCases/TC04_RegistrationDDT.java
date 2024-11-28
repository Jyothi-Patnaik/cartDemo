package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC04_RegistrationDDT extends BaseClass{
	
	@Test(dataProvider="RegistrationData",dataProviderClass= DataProviders.class)
	public void verify_accountRegistration(String fn, String ln, String email, String telNo, String pwd, String conPwd) throws InterruptedException {
	logger.info("***Execution Started***");
	try {
	HomePage hp= new HomePage(driver);
	
	hp.clickMyAccount();
	logger.info("***Click on My account***");
	logger.info("***Click on Register***");
    hp.clickRegister();

	RegistrationPage rp= new RegistrationPage(driver);
	rp.setFirstName(fn);
	rp.setLastName(ln);
	rp.setemail(email);
	rp.setNumber(telNo);
	
	//String cpassword = randomAlphaNumeric();
	rp.setpassword(pwd);
	rp.setconfirmpassword(conPwd);
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
		
	}
	   
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

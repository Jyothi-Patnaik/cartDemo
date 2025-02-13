package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ViewCart;
import pageObjects.checkOut_Page;
import testBase.BaseClass;

public class TC_07_CheckOutPage extends BaseClass {

	@Test
	public void checkOut() throws InterruptedException {
	HomePage hp=new HomePage(driver);
	//logger.info("Clicked on My Account Link");
	hp.clickMyAccount();
	
	hp.clickLoginMain();
	
	 LoginPage lp = new LoginPage(driver);
	 lp.emailField(p.getProperty("email"));
	 lp.passwordField(p.getProperty("password"));
	 lp.clickLogin();
	 Thread.sleep(3000);
	 
	 ViewCart vc = new ViewCart(driver);
     vc.viewCartPage();
	 vc.checkOutPage();
	 
	 checkOut_Page cp = new checkOut_Page(driver);
	 cp.selectAdress();
	 cp.details(randomString().toUpperCase(), randomString().toUpperCase(), randomString().toUpperCase(),randomString().toUpperCase(), randomString().toUpperCase(), randomString().toUpperCase(), randomNumeric());
	 cp.country();
	 cp.state();
	 cp.confirmationBtns("Hello");
	 
	}
	

}

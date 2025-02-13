package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;
import pageObjects.ViewCart;
import testBase.BaseClass;

public class TC_06_ViewCartPage extends BaseClass {
	
	@Test
	public void ViewCartPage() throws InterruptedException {
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

}
}

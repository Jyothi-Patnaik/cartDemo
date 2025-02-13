package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_05_Search_and_add_Product extends BaseClass {
	@Test
	
	public void searchAndAdd() throws InterruptedException {
		HomePage hp=new HomePage(driver);
		//logger.info("Clicked on My Account Link");
		hp.clickMyAccount();
		
		hp.clickLoginMain();
		
		 LoginPage lp = new LoginPage(driver);
		 lp.emailField(p.getProperty("email"));
		 lp.passwordField(p.getProperty("password"));
		 lp.clickLogin();
		 Thread.sleep(3000);
		 SearchPage sp = new SearchPage(driver);
		 sp.searchBoxText(p.getProperty("item"));
		 System.out.println("Searching for item: " + p.getProperty("item"));
		 sp.addItem();
		 
	}

}

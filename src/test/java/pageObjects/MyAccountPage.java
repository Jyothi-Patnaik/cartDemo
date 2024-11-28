package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}


	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement MyAccountText;


	@FindBy(xpath="//a[normalize-space()='View your order history']")
	WebElement viewOrderHistoryPage;


	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement logOutBtn;

	public boolean myAccountText() {
		try {
			System.out.println(MyAccountText.getText());
			return (MyAccountText.isDisplayed());
		}

		catch (Exception e)
		{
			return false;
		}

	}
	public void viewOrderHistory()
	{
		viewOrderHistoryPage.click();
	}

	public void clickLogout()
	{
		logOutBtn.click();
	}

}

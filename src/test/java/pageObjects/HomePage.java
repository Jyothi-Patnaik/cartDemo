package pageObjects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage{

	public HomePage(WebDriver driver) 
	{

		super(driver);

	}


	//@FindBy(xpath="//span[normalize-space()='My Account']")


	@FindBy(xpath="//i[@class='fa fa-user']")
	WebElement btnMyAccount;


	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement btnRegister;


	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement btnLogin;


	public void clickMyAccount() throws InterruptedException
	{

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", btnMyAccount);

	}
	public void clickRegister() 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", btnRegister);


	}
	public void clickLoginMain() 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", btnLogin);


	}
}
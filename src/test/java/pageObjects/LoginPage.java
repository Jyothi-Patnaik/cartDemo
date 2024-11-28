package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	

	public LoginPage(WebDriver driver) 
	{
		super(driver);
	}
	

@FindBy(xpath="//input[@id='input-email']")
WebElement emailTextBox;
@FindBy(xpath="//input[@id='input-password']")
WebElement passwordTextBox;
@FindBy(xpath="//input[@value='Login']")
WebElement loginBtn;

public void emailField(String email)
{
	emailTextBox.sendKeys(email);
}

public void passwordField(String password)
{
	passwordTextBox.sendKeys(password);
}

public void clickLogin()
{
	loginBtn.click();
}

}

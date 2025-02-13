package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
	

		
		public RegistrationPage(WebDriver driver) 
		{
			
			super(driver);
			
		}
		
@FindBy(xpath="//input[@id='input-firstname']")
WebElement firstName;
@FindBy(xpath="//input[@id='input-lastname']")
WebElement LastName;

@FindBy(xpath="//input[@id='input-email']")
WebElement email;

//@FindBy(xpath="//input[@id='input-telephone']")
//WebElement mobNumbr;

@FindBy(xpath="//input[@id='input-password']") 
WebElement password;

//@FindBy(xpath="//input[@id='input-confirm']")
//WebElement confirmpassword;
@FindBy(xpath="//input[@name='agree']")
WebElement agreeBtn;


@FindBy(xpath="//button[normalize-space()='Continue']")
WebElement continueBtn;


@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
WebElement confirmantionMsg;



public void setFirstName(String fName)
{
	firstName.sendKeys(fName);
}

public void setLastName(String lName)
{
	LastName.sendKeys(lName);
}

public void setemail(String mail)
{
	email.sendKeys(mail);
	System.out.println(mail);
}

//public void setNumber(String phNo)
//{
//	mobNumbr.sendKeys(phNo);
//}

public void setpassword(String pswd)
{
	password.sendKeys(pswd);
	System.out.println(pswd);
}

//public void setconfirmpassword(String cpswd)
//{
//	confirmpassword.sendKeys(cpswd);
//}


public void clickAgreeBtn()
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView", agreeBtn);
	js.executeScript("arguments[0].click();", agreeBtn);
	
}

public void clickConfirmBtn()
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView", continueBtn);
	js.executeScript("arguments[0].click();", continueBtn);
}


public String getConfirmationMsg()
{
	try {
		System.out.println(confirmantionMsg.getText());
		return(confirmantionMsg.getText());
		
	}catch(Exception e) {
	return e.getMessage();
}
		
}
}

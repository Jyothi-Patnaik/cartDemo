package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class checkOut_Page extends BasePage
{
       public checkOut_Page(WebDriver driver) 
       {
    	   super(driver);
       }
       

@FindBy(xpath="//label[normalize-space()='I want to use a new address']")
WebElement newAddressRadioBtn;
@FindBy(xpath="//input[@id='input-shipping-firstname']")
WebElement firstName;
@FindBy(xpath="//input[@id='input-shipping-lastname']")
WebElement lastName;
@FindBy(xpath="//input[@id='input-shipping-company']")
WebElement company;
@FindBy(xpath="//input[@id='input-shipping-address-1']")
WebElement address1;
@FindBy(xpath="//input[@id='input-shipping-address-2']")
WebElement address2;
@FindBy(xpath="//input[@id='input-shipping-city']")
WebElement city;
@FindBy(xpath="//input[@id='input-shipping-postcode']")
WebElement zipCode;

@FindBy(name="country_id")
WebElement country;

@FindBy(xpath="//select[@id='input-shipping-zone']")
WebElement state;

@FindBy(xpath="(//button[@type='submit'])[3]")
WebElement continueBtn;


@FindBy(xpath="//button[@id='button-shipping-methods']")
WebElement shipping_chooseBtn;


@FindBy(xpath="//button[@id='button-shipping-method']")
WebElement shipping_chooseContinueBtn;


@FindBy(xpath="//button[@id='button-payment-methods']")
WebElement payment_choose;
@FindBy(xpath="//button[@id='button-payment-method']")
WebElement payment_chooseContinue;
@FindBy(xpath="//textarea[@id='input-comment']")
WebElement commentsBox;
@FindBy(xpath="//button[@id='button-confirm']")
WebElement confirmOrderBtn;



public void selectAdress() 
{
	newAddressRadioBtn.click();
}

public void details(String fN,String lN, String comp,String cityName, String add1, String add2, String zip) throws InterruptedException 
{
	firstName.sendKeys(fN);
	lastName.sendKeys(lN);
	company.sendKeys(comp);
	address1.sendKeys(add1);
	address2.sendKeys(add2);
	city.sendKeys(cityName);
	zipCode.sendKeys(zip);
	
	
}

public void country() throws InterruptedException {
	Thread.sleep(1000);
    //((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)", ""); // ✅ Scroll
    country.click(); // ✅ Scroll
	Select s = new Select(country);
	s.selectByValue("99");
}

public void state() throws InterruptedException {
	
	 // ✅ Wait until visible
	Thread.sleep(3000);
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",state);
	wait.until(ExpectedConditions.visibilityOf(state));
	//((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1700)", "");
	state.click();
	Select ss = new Select(state);
	ss.selectByValue("4231");
}

public void confirmationBtns(String comments) throws InterruptedException {
	continueBtn.click();
	Thread.sleep(2000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollTo(0, 0);"); // Scroll to top
	Thread.sleep(1000);
	shipping_chooseBtn.click();
	shipping_chooseContinueBtn.click();
	payment_choose.click();
	payment_chooseContinue.click();
	Thread.sleep(2000);
	 // ✅ Wait until visible
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",confirmOrderBtn);
    //((JavascriptExecutor) driver).executeScript("window.scrollBy(0,850)", ""); // ✅ Scroll
	commentsBox.sendKeys(comments);
	wait.until(ExpectedConditions.visibilityOf(confirmOrderBtn));
	confirmOrderBtn.click();
}
	





}
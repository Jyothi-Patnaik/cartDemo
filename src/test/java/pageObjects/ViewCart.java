package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ViewCart extends BasePage {
	
	public ViewCart(WebDriver driver)
	{
		super(driver);
	}
	

@FindBy(xpath="(//button[@type='button'])[1]")

//@FindBy(xpath="//button[normalize-space()='1 item(s) - $122.00']")
WebElement viewCartBtn;
@FindBy(xpath="//strong[normalize-space()='View Cart']")
WebElement viewCartPageBtn;
@FindBy(xpath="//a[@class='btn btn-primary']")
WebElement checkOutBtn;
//@FindBy(xpath="//button[normalize-space()='1 item(s) - $122.00']")

public void viewCartPage() {
	//JavascriptExecutor js = (JavascriptExecutor) driver;
	//js.executeScript("window.scrollTo(0, 0);"); // Scroll to top

	viewCartBtn.click();
	viewCartPageBtn.click();
}

public void checkOutPage() throws InterruptedException {
	
	
    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,850)", ""); // ✅ Scroll
    wait.until(ExpectedConditions.visibilityOf(checkOutBtn)); // ✅ Wait until visible
    Thread.sleep(1000);
    checkOutBtn.click();
	
	
}
}

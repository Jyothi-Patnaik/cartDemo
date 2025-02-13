package pageObjects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends BasePage {
	
	public SearchPage(WebDriver driver) 
	{
		super(driver);
	}
	

@FindBy(xpath="//input[@placeholder='Search']")
WebElement searchBox;



@FindBy(xpath="//i[@class='fa-solid fa-magnifying-glass']")
WebElement searchFindBtn;


@FindBy(xpath="//button[@title='Add to Cart']")
WebElement addToCartBtn;



@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
WebElement successMsg;



public void searchBoxText(String item) throws InterruptedException
{
	searchBox.sendKeys(item);
	//Thread.sleep(2000);
	searchFindBtn.click();
	
}

//public void searchClick() throws InterruptedException
//{
//	Thread.sleep(3000);
//	
//}

public void addItem() throws InterruptedException
{
//		    JavascriptExecutor js = (JavascriptExecutor) driver;
//		    //js.executeScript("arguments[0].scrollIntoView();", addToCartBtn);
//		    js.executeScript("window.scrollBy(0,550)", "");
//		    //wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
//		    addToCartBtn.click();
		    
		    wait.until(ExpectedConditions.visibilityOf(addToCartBtn)); // ✅ Wait until visible
	        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,850)", ""); // ✅ Scroll
	        Thread.sleep(1000);
	        addToCartBtn.click(); // ✅ Click only when clickable
	    
		}
	
	
}




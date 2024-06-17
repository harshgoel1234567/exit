package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	WebDriver driver;
	private WebDriverWait wait;
	public CartPage(WebDriver driver,WebDriverWait wait) {
		this.wait=wait;
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//button[@class='QqFHMw zA2EfJ _7Pd1Fp']")
	WebElement OrderButton;
	@FindBy(xpath = "//div[@class='s2gOFd']")
    private WebElement cartContent;
	
	
	public WebElement OrderButton() {
		return OrderButton;
	}
	
	@FindBy(xpath="//div[normalize-space()='Remove']")
	WebElement RemoveButton;
	
	
	
	public WebElement RemoveButton() {
		return RemoveButton;
	}
	
	@FindBy(css=".sBxzFz.fF30ZI.A0MXnh")
	WebElement Remove;
	
	
	
	public WebElement Remove() {
		return Remove;
	}
	
	@FindBy(xpath="//div[@class='krHvwW htEYUF']")
	WebElement RemoveFlyer;
	
	
	
	public WebElement RemoveFlyer() {
		return RemoveFlyer;
	}
	
	@FindBy(xpath="//div[normalize-space()='Save for later']")
	WebElement SaveForLater;
	
	
	
	public WebElement SaveForLater() {
		return SaveForLater;
	}
	  public boolean isCartContentDisplayed() {
	        return wait.until(ExpectedConditions.visibilityOf(cartContent)).isDisplayed();
	    }
	
	
	
	

}
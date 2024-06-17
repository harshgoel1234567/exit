package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;
	
	public SearchPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/a[1]/div[2]/div[1]")
	WebElement ProductCard;
	
	
	
	public WebElement ProductCard() {
		return ProductCard;
	}
	
	@FindBy(xpath="//button[normalize-space()='Buy Now']")
	WebElement Details;
	
	
	
	public WebElement Details() {
		return Details ;
	}
	
	@FindBy(xpath="//span[@class='BUOuZu']")
	WebElement searchRes ;
	
	
	
	public WebElement searchRes() {
		return searchRes ;
	}
	
	@FindBy(xpath="//button[normalize-space()='Add to cart']")
	WebElement CartButton;
	
	
	
	public WebElement CartButton() {
		return CartButton ;
	}
	
	@FindBy(xpath="//input[@id='pincodeInputId']")
	WebElement pincode;
	
	
	
	public WebElement pincode() {
		return pincode ;
	}
	
	@FindBy(css=".i40dM4")
	WebElement check;
	
	
	
	public WebElement check() {
		return check ;
	}
	
	@FindBy(css=".nyRpc8")
	WebElement invalid;
	
	
	
	public WebElement invalid() {
		return invalid ;
	}
	
	

}
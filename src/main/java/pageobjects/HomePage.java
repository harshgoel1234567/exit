package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	private WebDriverWait wait;

	public HomePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;

		PageFactory.initElements(driver, this);

	}
	@FindBy(css="img[title='Flipkart']")
	private WebElement logo;
	 @FindBy(xpath = "//a[@aria-label='Go Home']")
	    private WebElement shopsyElement;
	 @FindBy(xpath = "//a[normalize-space()='Shopsy']")
	    private WebElement shopsyLink;
	   @FindBy(xpath = "//a[normalize-space()='Terms Of Use']")
	    private WebElement termsOfUseLink;
	 @FindBy(xpath = "//img[@alt='Grocery']")
	    private WebElement groceryIcon;
	 @FindBy(xpath = "//img[@alt='Cart']")
	    private WebElement cartIcon;
	@FindBy(xpath = "//a[@title='Become a Seller']//img[@alt='Become a Seller']")
	private WebElement becomeSellerLink;
	@FindBy(xpath = "//a[normalize-space()='Contact Us']")
	private WebElement contactUsLink;
	@FindBy(xpath = "//span[normalize-space()='Login']")
	WebElement Login;
	@FindBy(xpath = "//input[@placeholder='Search for Products, Brands and More']")
	WebElement Searchbar;
	@FindBy(xpath = "//button[@title='Search for Products, Brands and More']//*[name()='svg']")
	WebElement Search;
	@FindBy(xpath = "//a[normalize-space()='Careers']")
	private WebElement careersLink;
	@FindBy(xpath = "//a[normalize-space()='About Us']")
	private WebElement aboutUsLink;
	 @FindBy(xpath = "//a[normalize-space()='Flipkart Stories']")
	  private WebElement flipkartStoriesLink;
	 @FindBy(xpath = "//a[@aria-label='Security']")
	  private WebElement SecurityPageLink;
	 @FindBy(xpath = "//a[@aria-label='Privacy']")
	  private WebElement PolicyPageLink;
	 

	 public boolean logoisdisplayed()
	 {
		 return logo.isDisplayed();
	 }
	 public void clickSecurityLink()
	 {
		 wait.until(ExpectedConditions.elementToBeClickable(SecurityPageLink)).click();
	 }
	 public void clickPolicyLink()
	 {
		 wait.until(ExpectedConditions.elementToBeClickable(PolicyPageLink)).click();
	 }

	public void clickBecomeSeller() {
		becomeSellerLink.click();
	}
	public void clickShopsyLink() {
        wait.until(ExpectedConditions.elementToBeClickable(shopsyLink)).click();
    }
	  public void clickCartIcon() {
	        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
	    }
	public void clickContactUs() {
		contactUsLink.click();
	}

	public void clickCareersLink() {
		wait.until(ExpectedConditions.elementToBeClickable(careersLink)).click();
	}
	 public void clickTermsOfUseLink() {
	        wait.until(ExpectedConditions.elementToBeClickable(termsOfUseLink)).click();
	    }

	public WebElement Login() {
		return Login;
	}

	public WebElement Searchbar() {
		return Searchbar;
	}

	public WebElement Search() {
		return Search;
	}

	public void clickAboutUs() {
		wait.until(ExpectedConditions.elementToBeClickable(aboutUsLink)).click();
	}
	 public void clickGroceryIcon() {
	        wait.until(ExpectedConditions.elementToBeClickable(groceryIcon)).click();
	    }
	 public void clickFlipkartStories() {
	        wait.until(ExpectedConditions.elementToBeClickable(flipkartStoriesLink)).click();
	    }
	 public WebElement getShopsyElement() {
	        return wait.until(ExpectedConditions.visibilityOf(shopsyElement));
	    }

	    public boolean isShopsyElementDisplayed() {
	        return getShopsyElement().isDisplayed();
	    }
}

package pageobjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecurityPage {
	
	 private WebDriver driver;
	    private WebDriverWait wait;

	

	    public SecurityPage(WebDriver driver, WebDriverWait wait) {
	        this.driver = driver;
	        this.wait = wait;
	        PageFactory.initElements(driver, this);
	    }

	  
  
	

    @FindBy(xpath = "//h2[@id='safe-and-secure-shopping']")
    private WebElement startSellingButton;
    
    public boolean isAboutLinkDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(startSellingButton)).isDisplayed();
    }

   

   
}

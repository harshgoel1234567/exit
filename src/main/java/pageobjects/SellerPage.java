package pageobjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SellerPage {
    private WebDriver driver;
    public SellerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
	

    @FindBy(xpath = "//button[normalize-space()='Start Selling']")
    private WebElement startSellingButton;

   

    public boolean isStartSellingButtonDisplayed() {
        return startSellingButton.isDisplayed();
    }
}

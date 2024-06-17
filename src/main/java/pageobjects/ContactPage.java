package pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
    private WebDriver driver;

    @FindBy(xpath = "//h1[normalize-space()='Flipkart Help Center | 24x7 Customer Care Support']")
    private WebElement contactHeader;

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isContactHeaderDisplayed() {
        return contactHeader.isDisplayed();
        
    }
}

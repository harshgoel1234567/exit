package pageobjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GroceeryPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//img[@class='W5mR4e']")
    private WebElement groceryPageImage;

    public GroceeryPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public boolean isGroceryPageImageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(groceryPageImage)).isDisplayed();
    }
}

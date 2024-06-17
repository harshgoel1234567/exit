package pageobjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StoriesPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//li[@id='menu-item-66351']")
    private WebElement menuItem;

    public StoriesPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public boolean isMenuItemDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(menuItem)).isDisplayed();
    }
}


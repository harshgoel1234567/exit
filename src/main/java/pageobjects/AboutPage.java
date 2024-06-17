package pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AboutPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//a[normalize-space()='About']")
    private WebElement aboutLink;

    public AboutPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public boolean isAboutLinkDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(aboutLink)).isDisplayed();
    }
}

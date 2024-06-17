package pageobjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CareersPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//span[@class='logo_career_text']")
    private WebElement careerLogo;

    public CareersPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public boolean isCareerLogoDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(careerLogo)).isDisplayed();
    }
}

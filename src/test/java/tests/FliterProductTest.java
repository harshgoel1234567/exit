package tests;



import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

public class FliterProductTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Use WebDriverManager to setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        
        // Initialize the ChromeDriver
        driver = new ChromeDriver();
        
        // Navigate to the home page
        driver.get("https://www.flipkart.com/");
    }

    @Test
    public void FilterProduct() throws InterruptedException {
   
    	Thread.sleep(3);
        WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']"));
        search.sendKeys("watches");
        search.sendKeys(Keys.ENTER);
        Thread.sleep(3);
        assert driver.findElement(By.cssSelector("span[class='BUOuZu'] span")).isDisplayed();
        WebElement dropdownElement = driver.findElement(By.className("Gn+jFg"));
        
        // Create an instance of the Select class
        Select dropdown = new Select(dropdownElement);
        
        // Select the option with the value "50000"
        dropdown.selectByValue("20000");
        
        // Optional: Verify the selected value
        String selectedValue = dropdown.getFirstSelectedOption().getAttribute("value");
        assert "20000".equals(selectedValue) : "The selected value is not as expected.";
       
   }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}

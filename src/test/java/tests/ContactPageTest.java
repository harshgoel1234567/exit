package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import resources.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.ContactPage;
import pageobjects.HomePage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactPageTest extends Base{
    private WebDriver driver;
    private WebDriverWait wait;
    private Logger logger = LoggerFactory.getLogger(ContactPageTest.class);

    @BeforeMethod
    public void setUp() throws FileNotFoundException, IOException {
        logger.info("Setting up the WebDriver and WebDriverWait");

        // Use WebDriverManager to setup ChromeDriver
      
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver=initializedriver();
        
        // Navigate to the home page
        logger.info("Navigating to Flipkart home page");
        
        driver.get("https://www.flipkart.com/");
      
    }

    @Test
    public void ContactPage() throws InterruptedException {
        logger.info("Starting the ContactPage test");

        HomePage homePage = new HomePage(driver, wait);
        ContactPage contactPage = new ContactPage(driver);

        logger.info("Clicking on Contact Us link");
        homePage.clickContactUs();

        // Wait for the contact page to load if needed
        // Thread.sleep(8000); // Wait for page to load

        logger.info("Verifying if the contact header is displayed");
        Assert.assertTrue(contactPage.isContactHeaderDisplayed(), "Contact header is not displayed");
    }

    @AfterMethod
    public void tearDown() {
        logger.info("Tearing down the WebDriver");

        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}

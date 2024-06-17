package tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageobjects.*;
import resources.*;

public class AboutPageTest extends Base{
    private WebDriver driver;
    WebDriverWait wait;
    Logger logger = LoggerFactory.getLogger(AboutPageTest.class);

    @BeforeMethod
    public void setUp() throws FileNotFoundException, IOException {
        

        logger.info("Setting up the test");

        
      
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

       
        driver=initializedriver();
		
        logger.info("Navigating to Flipkart home page");
        driver.get("https://www.flipkart.com/");
        
    }

    @Test
    public void AboutPage() throws InterruptedException {
        logger.info("Starting AboutPage test");
        HomePage homePage = new HomePage(driver, wait);
        AboutPage aboutPage = new AboutPage(driver, wait);

        logger.info("Clicking on About Us link");
        homePage.clickAboutUs();
        //Thread.sleep(8000); // Wait for page to load

        logger.info("Verifying if About link is displayed");
        Assert.assertTrue(aboutPage.isAboutLinkDisplayed(), "About link is not displayed");
        logger.info("AboutPage test completed successfully");
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
        logger.info("Browser closed");
    }
}

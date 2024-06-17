package tests;

import resources.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobjects.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class CareersPageTest extends Base{
    WebDriver driver;
    WebDriverWait wait;
    Logger logger = LoggerFactory.getLogger(CareersPageTest.class);

    @BeforeClass
    public void setUp() throws FileNotFoundException, IOException {
        logger.info("Setting up the WebDriver and WebDriverWait");
        
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver = initializedriver();
        
        logger.info("Navigating to Flipkart home page");
        driver.get("https://www.flipkart.com");
    }

    @Test
    public void testCareersPage() {
        logger.info("Starting the testCareersPage test");

        HomePage homePage = new HomePage(driver, wait);
        CareersPage careersPage = new CareersPage(driver, wait);

        logger.info("Clicking on Careers link");
        homePage.clickCareersLink();

        logger.info("Verifying if the career logo is displayed");
        Assert.assertTrue(careersPage.isCareerLogoDisplayed(), "Career logo is not displayed");
    }

    @AfterClass
    public void tearDown() {
        logger.info("Tearing down the WebDriver");
        
        if (driver != null) {
            driver.quit();
        }
    }
}

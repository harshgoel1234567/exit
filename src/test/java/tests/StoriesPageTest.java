package tests;

import resources.Base;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageobjects.HomePage;
import pageobjects.StoriesPage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StoriesPageTest extends Base {
    private WebDriver driver;
    private WebDriverWait wait;
    private Logger logger = LoggerFactory.getLogger(StoriesPageTest.class);

    @BeforeMethod
    public void openApplication() throws FileNotFoundException, IOException {
        logger.info("Setting up the WebDriver and WebDriverWait");

        driver = initializedriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        logger.info("Navigating to Flipkart home page");
        driver.get("https://www.flipkart.com");
    }

    @Test
    public void StoriesPage() throws InterruptedException {
        logger.info("Starting the StoriesPage test");

        HomePage homePage = new HomePage(driver, wait);
        StoriesPage storiesPage = new StoriesPage(driver, wait);

        logger.info("Clicking on Flipkart Stories link");
        homePage.clickFlipkartStories();

        logger.info("Verifying if the Stories menu item is displayed");
        Assert.assertTrue(storiesPage.isMenuItemDisplayed(), "Menu item is not displayed");
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

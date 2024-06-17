package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pageobjects.HomePage;
import pageobjects.SellerPage;
import resources.Base;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SellerPageTest extends Base {
    private WebDriver driver;
    private WebDriverWait wait;
    private Logger logger = LoggerFactory.getLogger(SellerPageTest.class);

    @BeforeMethod
    public void openApplication() throws FileNotFoundException, IOException {
        logger.info("Setting up the WebDriver and WebDriverWait");

        driver = initializedriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        logger.info("Navigating to Flipkart home page");
        driver.get("https://www.flipkart.com");
    }

    @Test
    public void SearchProduct() throws InterruptedException {
        logger.info("Starting the SearchProduct test");

        HomePage homePage = new HomePage(driver, wait);
        SellerPage sellerPage = new SellerPage(driver);

        logger.info("Clicking on Become a Seller link");
        homePage.clickBecomeSeller();

        logger.info("Waiting for the page to load");
        Thread.sleep(3000); // Wait for page to load

        logger.info("Verifying if the Start Selling button is displayed");
        Assert.assertTrue(sellerPage.isStartSellingButtonDisplayed(), "Start Selling button is not displayed");
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

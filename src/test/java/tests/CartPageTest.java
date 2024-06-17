package tests;
import resources.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CartPageTest extends Base{
    WebDriver driver;
    WebDriverWait wait;
    Logger logger = LoggerFactory.getLogger(CartPageTest.class);

    @BeforeClass
    public void setUp() throws FileNotFoundException, IOException {
        logger.info("Setting up the WebDriver and WebDriverWait");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver = initializedriver();

        logger.info("Navigating to Flipkart home page");
        driver.get("https://www.flipkart.com");
    }

    @Test
    public void CartPage() throws InterruptedException {
        logger.info("Starting the CartPage test");

        HomePage homePage = new HomePage(driver, wait);
        CartPage cartPage = new CartPage(driver, wait);

        logger.info("Clicking on Cart icon");
        homePage.clickCartIcon();

        logger.info("Waiting for the cart page to load");
         // Wait for page to load

        logger.info("Verifying if the cart content is displayed");
        Assert.assertTrue(cartPage.isCartContentDisplayed(), "Cart content is not displayed");
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

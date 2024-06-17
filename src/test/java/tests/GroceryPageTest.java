package tests;

import resources.Base;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.GroceeryPage;
import pageobjects.HomePage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GroceryPageTest extends Base {

    private WebDriver driver;
    private WebDriverWait wait;
    private Logger logger = LoggerFactory.getLogger(GroceryPageTest.class);

    @BeforeMethod
    public void openApplication() throws FileNotFoundException, IOException {
        logger.info("Setting up the WebDriver and WebDriverWait");

        driver = initializedriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        logger.info("Navigating to Flipkart home page");
        driver.get("https://www.flipkart.com");
    }

    @Test
    public void GroceryPage() throws InterruptedException {
        logger.info("Starting the GroceryPage test");

        HomePage homePage = new HomePage(driver, wait);
        GroceeryPage groceryPage = new GroceeryPage(driver, wait);

        logger.info("Clicking on Grocery icon");
        homePage.clickGroceryIcon();

        logger.info("Waiting for the grocery page to load");
        //Thread.sleep(8000); // Wait for page to load

        logger.info("Verifying if the grocery page image is displayed");
        Assert.assertTrue(groceryPage.isGroceryPageImageDisplayed(), "Grocery page image is not displayed");
    }

    @AfterMethod
    public void closure() {
        logger.info("Tearing down the WebDriver");

        if (driver != null) {
            driver.close();
        }
    }

    @DataProvider
    public Object[][] getLoginData() {
        logger.info("Providing login data");
        return new Object[][] { {"Iphone"} };
    }
}

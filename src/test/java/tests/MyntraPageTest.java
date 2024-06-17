package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageobjects.HomePage;
import resources.Base;

public class MyntraPageTest extends Base {

    public WebDriver driver;
    public WebDriverWait wait;
    private Logger logger = LoggerFactory.getLogger(MyntraPageTest.class);

    @BeforeClass
    public void setUp() throws FileNotFoundException, IOException {
        logger.info("Setting up the WebDriver and WebDriverWait");

        driver = initializedriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        logger.info("Navigating to Flipkart home page");
        driver.get("https://www.flipkart.com");
    }

    @Test
    public void ShopsyPage() {
        logger.info("Starting the ShopsyPage test");

        HomePage homePage = new HomePage(driver, wait);

        logger.info("Clicking on Shopsy link");
        homePage.clickShopsyLink();

        String originalWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                logger.info("Switching to the new window");
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        logger.info("Verifying if the Shopsy element is displayed");
        Assert.assertTrue(homePage.isShopsyElementDisplayed(), "Shopsy element is not displayed");
    }

    @AfterClass
    public void tearDown() {
        logger.info("Tearing down the WebDriver");

        // Quit the WebDriver
        if (driver != null) {
            driver.quit();
        }
    }
}

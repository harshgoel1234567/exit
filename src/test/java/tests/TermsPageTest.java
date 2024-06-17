package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageobjects.HomePage;
import pageobjects.TermsPage;
import resources.Base;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TermsPageTest extends Base {
    private WebDriver driver;
    private WebDriverWait wait;
    private Logger logger = LoggerFactory.getLogger(TermsPageTest.class);

    @BeforeMethod
    public void openApplication() throws FileNotFoundException, IOException {
        logger.info("Setting up the WebDriver and WebDriverWait");

        driver = initializedriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        logger.info("Navigating to Flipkart home page");
        driver.get("https://www.flipkart.com");
    }

    @Test
    public void TermsTest() throws InterruptedException {
        logger.info("Starting the TermsTest");

        HomePage homePage = new HomePage(driver, wait);
        TermsPage termsPage = new TermsPage(driver, wait);

        logger.info("Clicking on Terms of Use link");
        homePage.clickTermsOfUseLink();

        logger.info("Verifying if the Terms of Use header is displayed");
        Assert.assertTrue(termsPage.isTermsHeaderDisplayed(), "Terms of Use header is not displayed");
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
        logger.info("Providing data for tests");
        return new Object[][] { { "Iphone" } };
    }
}

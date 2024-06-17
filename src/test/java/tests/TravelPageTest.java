package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import resources.Base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class TravelPageTest extends Base {

    private WebDriver driver;
    private WebDriverWait wait;
    private Logger logger = LoggerFactory.getLogger(TravelPageTest.class);

    @BeforeMethod
    public void openApplication() throws FileNotFoundException, IOException {
        logger.info("Setting up the WebDriver and WebDriverWait");
        
        driver = initializedriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        logger.info("Navigating to Flipkart home page");
        driver.get("https://www.flipkart.com");
    }

    @Test
    public void TravelPage() {
        logger.info("Starting the TravelPage test");

        logger.info("Clicking on the Travel link");
        driver.findElement(By.xpath("//a[@aria-label='Travel']")).click();

        logger.info("Verifying if the Travel page element is displayed");
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='NmD+EK']")).isDisplayed(), "Travel page element is not displayed");
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
        return new Object[][] { { "Iphone" } };
    }
}

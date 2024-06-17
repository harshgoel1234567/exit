
package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.ProductPage;
import resources.Base;
import utilities.ExcelReader;

public class ProductDetailsTest extends Base {
   public WebDriver driver;
    private static final Logger logger = LogManager.getLogger(ProductDetailsTest.class);


    private WebDriverWait wait;


    @BeforeMethod
    public void openApplication() throws FileNotFoundException, IOException {
        logger.info("Setting up the WebDriver and WebDriverWait");

        driver = initializedriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        logger.info("Navigating to Flipkart home page");
        driver.get("https://www.flipkart.com");
    }

    @Test
    public void ProductDetails() throws IOException {
   	 String excelFilePath ="C:\\Users\\harshgoel\\eclipse-workspace\\Exit-Assignment\\src\\main\\java\\utilities\\Exit-Assignement.xlsx";
     String sheetName = "Search"; 
     
        
        List<Map<String, String>> testCases = ExcelReader.getTestCases(excelFilePath, sheetName);
        
        for (Map<String, String> testCase : testCases) {
            String testCaseName = testCase.get("TestCaseName");
            String executionRequired = testCase.get("ExecutionRequired");
            String searchTerm = testCase.get("SearchTerm");
            
            if (executionRequired.equalsIgnoreCase("Yes")) {
                logger.info("Executing test case: " + testCaseName);
                logger.info("Search Term: " + searchTerm);
                
                try {
              

                    HomePage homepage = new HomePage(driver,wait);
                    ProductPage product = new ProductPage(driver);

                    homepage.Searchbar().sendKeys(searchTerm);
                    logger.debug("Entered search term: " + searchTerm);
                    homepage.Search().click();
                    product.ProductCard().click();

                    // Handle window switching
                    String originalWindow = driver.getWindowHandle();
                    Set<String> allWindows = driver.getWindowHandles();

                    for (String windowHandle : allWindows) {
                        if (!windowHandle.equals(originalWindow)) {
                            driver.switchTo().window(windowHandle);
                            break;
                        }
                    }

                    // Verify product details are displayed in the new window
                    Assert.assertTrue(product.Details().isDisplayed());
                    logger.info("Product details are displayed.");

                    driver.switchTo().window(originalWindow);
                } catch (Exception e) {
                    logger.error("Error occurred during the test case execution: " + testCaseName, e);
                } finally {
                    if (driver != null) {
                        driver.quit();
                        logger.debug("Browser closed for test case: " + testCaseName);
                    }
                }
            }
        }
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
            logger.debug("Browser closed in teardown method.");
        }
    }
}

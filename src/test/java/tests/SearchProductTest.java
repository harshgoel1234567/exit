package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.CartPage;
import pageobjects.HomePage;
import pageobjects.ProductPage;
import resources.Base;
import utilities.ExcelReader;



import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SearchProductTest extends Base {
	
	public WebDriver driver;
    private WebDriverWait wait;
    private Logger logger = LogManager.getLogger(SellerPageTest.class);

    @BeforeMethod
    public void openApplication() throws FileNotFoundException, IOException {
        logger.info("Setting up the WebDriver and WebDriverWait");

        driver = initializedriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        logger.info("Navigating to Flipkart home page");
        driver.get("https://www.flipkart.com");
    }

	
	@Test
	public void Search() throws IOException {
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

                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                    wait.until(ExpectedConditions.visibilityOf(product.searchRes()));
                    logger.info("Search results displayed successfully for: " + searchTerm);
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
		        }
			  
		  }

}
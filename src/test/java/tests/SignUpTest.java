
package tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.SignupPage;
import resources.Base;
import utilities.ExcelReader;
//import utilities.FilePaths;

public class SignUpTest extends Base {
    public WebDriver driver;
    public WebDriverWait wait;
    private static final Logger logger = LogManager.getLogger(SignUpTest.class);

  
//       
    	@BeforeClass
        public void setUp() {
            // Set the path to the WebDriver executable if it is not in the system's PATH
//            System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

            // Initialize the WebDriver (for Chrome in this case)
            driver = new ChromeDriver();

            // Initialize WebDriverWait with a timeout of 10 seconds
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Maximize the browser window
            driver.manage().window().maximize();

            // Open the base URL
            driver.get("https://www.flipkart.com");
        }

    	  @Test
    	    public void signup() throws IOException, InterruptedException {
    		  String excelFilePath = "C:\\Users\\harshgoel\\eclipse-workspace\\Exit-Assignment\\src\\main\\java\\utilities\\Exit-Assignement.xlsx";
           String sheetName = "SignUpTest";
    
          List<Map<String, String>> testCases = ExcelReader.getTestCases(excelFilePath, sheetName);
    
            for (Map<String, String> testCase : testCases) {
                String testCaseName = testCase.get("TestCaseName");
                String executionRequired = testCase.get("ExecutionRequired");
                String phone = testCase.get("Mobiles");
    
                if (executionRequired.equalsIgnoreCase("Yes")) {
                    logger.info("Executing test case: " + testCaseName);
                    logger.info("Phone: " + phone);  
    		  try {


                    HomePage homepage = new HomePage(driver,wait);
                    homepage.Login().click();
                    //logger.debug("Clicked on Login button");

                    Thread.sleep(3000);

                    SignupPage signin = new SignupPage(driver);
                    signin.signup().click();
                    //logger.debug("Clicked on Sign Up button");

                    signin.emailField().sendKeys(phone);
                    //logger.debug("Entered phone number: " + phone);

                    signin.continueButton().click();
                    //logger.debug("Clicked on Continue button");

                    Assert.assertTrue(signin.signUpButton().isDisplayed());
                    //logger.info("Sign Up button is displayed");
                } catch (Exception e) {
                    logger.error("Error occurred during the test case execution: " + testCaseName, e);
                } 
                }
            }
                
           }
            
        
    

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
            //logger.debug("Browser closed in teardown method.");
        }
    }
}
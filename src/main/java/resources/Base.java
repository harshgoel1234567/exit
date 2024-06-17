package resources;
import java.io.*;
import java.time.Duration;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;
public class Base {
	WebDriver d;
	public Properties prop;
	
	public WebDriver initializedriver() throws FileNotFoundException,IOException
	{
		 prop =new Properties();
		
		String browserName="chrome";
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();

			String userProfilePath = "C:\\Users\\harshgoel\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1";

	      
	         d = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			 d= new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			WebDriverManager.edgedriver().setup();
		    
		}
		
		
		
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return d;
	}
	
	public  String takeScreenShot(String Name,WebDriver driver) throws IOException
	{
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		String destinationpath=System.getProperty("user.dir")+"\\screenshots\\"+Name+".png";
        FileUtils.copyFile(screenshotFile, new File(destinationpath));
        
        return destinationpath;
	}

}

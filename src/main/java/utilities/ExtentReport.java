package utilities;

import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	static ExtentReports extent;

	
	 public static ExtentReports getExtentReport()
	 {
		 
	String reportPath=System.getProperty("user.dir")+"\\reports\\index.html";
		 ExtentSparkReporter reporter=new ExtentSparkReporter(reportPath);
		 
		 reporter.config().setReportName("Flipkart test Report");
		 reporter.config().setDocumentTitle("Flipkart Test Report Title");
		 
         extent = new ExtentReports();
		 
		 extent.attachReporter(reporter);
		 extent.setSystemInfo("Tested by", "Harsh Goel");
		 
		 return extent;
	 }
}

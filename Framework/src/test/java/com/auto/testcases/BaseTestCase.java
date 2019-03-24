package com.auto.testcases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.auto.data.CommonData;
import com.auto.utility.BrowserFactory;
import com.auto.utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseTestCase {
	
	public WebDriver driver;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupSuite() {
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(CommonData.REPORTS_FOLDER + "/Report_"+ Helper.getCurrentDateTime() +".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
	}
	
	@BeforeClass
	public void setup() 
	{
		Reporter.log("Application is starting....", true);
		driver = BrowserFactory.startApplication(driver, CommonData.BROWSER, CommonData.APP_URL);
	}
	
	@AfterClass
	public void tearDown()
	{
		Reporter.log("Application is quitting....", true);
		BrowserFactory.quitApplication(driver);
		report.flush();
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{
		
		if(result.getStatus()==ITestResult.FAILURE){
			{
				logger.fail("Test failed: ", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			}
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test passed: ", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		
	}
	

}

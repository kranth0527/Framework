package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.Helper;

public class BaseClass {
	
	public WebDriver driver;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite()
	{
		config = new ConfigDataProvider();
		ExtentSparkReporter extent = new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/Demo+"+Helper.getCurrentDateTime()+".html");
		report = new ExtentReports();
		report.attachReporter(extent);
		
	}

	@BeforeClass
	public void startBrowser ()
	
	{
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getURL());
		//System.out.println(driver.getTitle());
	}
	
	@AfterClass
	public void closeBrowser()
	
	{
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void teardownMethod ()
	{
		report.flush();
	}
}

package com.learnautomation.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;

public class LoginTest extends BaseClass {

	//ExcelDataProvider excel = new ExcelDataProvider();

	@Test
	public void loginApp()

	{

		logger = report.createTest("LoginTest");
		LoginPage loginPage = new LoginPage(driver);
		logger.info("Starting test");
		//loginPage.loginToSaucedemo(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		loginPage.loginToSaucedemo("standard_user", "secret_sauce");
		logger.pass("Success");
		String expectedTitle = "Swag Labs";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Title mismatched");
		driver.quit();
	}
	
	@Test
    public void validateTabs() {
		
		logger = report.createTest("Validate HYRTabs");
		LoginPage loginPage = new LoginPage(driver);
		logger.info("Validating tabs");
		loginPage.accessHYRTutorials();
		logger.pass("Success");
       
    }
	
}

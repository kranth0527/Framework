package com.learnautomation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="user-name") WebElement uname;
	@FindBy(id="password") WebElement pass;
	@FindBy(id="login-button") WebElement loginButton;

	public void loginToSaucedemo (String usernameApp, String passwordApp)
	
	{

		uname.sendKeys(usernameApp);
		pass.sendKeys(passwordApp);
		loginButton.click();
	}
	
	public void accessHYRTutorials()
	
	{
		System.setProperty("webdriver.chrome.driver", "/Users/goutham/Downloads/chromedriver-mac-x64/chromedriver");
        driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/");
		driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		// Validate Home tab
        WebElement homeTab = driver.findElement(By.linkText("Home"));
        Assert.assertTrue(homeTab.isDisplayed(), "Home tab is not visible");

        // Validate Tech News tab
        WebElement techNewsTab = driver.findElement(By.linkText("Tech News"));
        Assert.assertTrue(techNewsTab.isDisplayed(), "Tech News tab is not visible");

        // Validate Tutorials tab
        WebElement tutorialsTab = driver.findElement(By.linkText("Tutorials"));
        Assert.assertTrue(tutorialsTab.isDisplayed(), "Tutorials tab is not visible");
        driver.quit();
        
	}

}

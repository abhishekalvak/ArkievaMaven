package com.actitime.generic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


public class BaseClass {

	public static WebDriver driver;
	
	@BeforeTest(groups="smoketesting")
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		Reporter.log("open browser message",true);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@AfterTest(groups="smoketesting")
	public void closeBrowser()
	{
		Reporter.log("close browser message",true);
		driver.close();
	}
	@BeforeMethod
	public void login()
	{
		Reporter.log("login message",true);
		driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
	}
	@AfterMethod
	public void logout()
	{
		Reporter.log("logout message",true);
		driver.findElement(By.id("logoutLink")).click();;
	}
}

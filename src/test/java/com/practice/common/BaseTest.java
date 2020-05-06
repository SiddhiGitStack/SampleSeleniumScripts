package com.practice.common;

import com.practice.commonutills.ReadConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	public static WebDriver driver;
	
	ReadConfig obj=new ReadConfig();
	
	public String url=obj.getURL();
	
	@BeforeMethod
	public void setup()
	{
		if(obj.getBrowser().equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", obj.getChromeDriver());
			driver=new ChromeDriver();
		}
		
		if(obj.getBrowser().equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", obj.getFirefoxDriver());
			driver=new FirefoxDriver();
		}
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	

}

package com.practice.test;
//@Author Siddhi
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.practice.common.BasePO;
import com.practice.common.BaseTest;

public class DesktopGoogleSearch extends BaseTest {
	
	@Test(testName="googleSearchDT")
	public void googleSearchDT() throws InterruptedException
	{
		
		BasePO po=new BasePO(driver);
				
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		po.googleSearch.sendKeys("selenium");
		
		List<WebElement> ls=driver.findElements(By.xpath("//ul[@role='listbox']//li//descendant::div[@class='sbtc']"));
		
		System.out.println("Number of item shown in list "+ ls.size());
		
		for (int i=0;i<ls.size();i++)
		{
			if (ls.get(i).getText().equals("selenium tutorial"))
			{
				ls.get(i).click();
				break;
				
			}
		}
		driver.findElement(By.xpath("//h3[contains(text(),'Selenium Tutorial')]")).click();
		
		Thread.sleep(7000);
		
		String currenturl=driver.getCurrentUrl();
		if (currenturl.contentEquals("www.guru99.com/selenium-tutorial.html"))
		{
			System.out.println("Search passed");
		}
		String str=driver.getTitle();
		System.out.println(str);
		
	}

}

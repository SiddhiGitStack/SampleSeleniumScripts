package com.practice.commonutills;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties po=new Properties();
	public ReadConfig() {
		
		File src=new File("./src/main/resource/Properties/config.properties");
		try
		{
			FileInputStream fis=new FileInputStream(src);
			po.load(fis);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	public String getURL()
	{
		
		String url=po.getProperty("url");
		return url;
		
	}
	
	public String getBrowser()
	{
		
		String browser=po.getProperty("browser");
		return browser;
		
	}
	
	public String getChromeDriver()
	{
		
		String chromeDriver=po.getProperty("chromeDriver");
		return chromeDriver;
		
	}
	
	public String getFirefoxDriver()
	{
		
		String fireFoxDriver=po.getProperty("fireFoxDriver");
		return fireFoxDriver;
		
	}

}

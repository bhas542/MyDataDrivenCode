
package com.DataDrivenProject.OpenSourceOHRMS;
 
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class LaunchBrowser {
	
		WebDriver driver=null;
		
		@BeforeTest
		public void launchBrowser() throws FileNotFoundException
		{
	
			System.setProperty("webdriver.chrome.driver","./BrowserDep/chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(12,TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
		}

	
	}


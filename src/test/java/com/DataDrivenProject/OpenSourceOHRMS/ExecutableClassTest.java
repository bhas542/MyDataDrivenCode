package com.DataDrivenProject.OpenSourceOHRMS;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 


public class ExecutableClassTest extends LaunchBrowser {
	
	WebDriver driver=null;
	
	@BeforeTest
	public void launchBrowser()
	{

		System.setProperty("webdriver.chrome.driver","./BrowserDep/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(12,TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
	}
	@Test
	public void readData() throws IOException, InterruptedException
	{
		 
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		 
		
		
		
		//Identfy excel in the system
		FileInputStream file = new FileInputStream("C:\\Users\\bhaskar\\Desktop\\Excel Data.xlsx");
		//identify workbook in the file
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		//identify sheet in the workbook
		XSSFSheet sheet= workbook.getSheet("Sheet1");
		int num= sheet.getLastRowNum();
		System.out.println(num);
		
		for( int i=1; i<=num; i++)
		{
			WebElement E1=driver.findElement(By.xpath("//input[@id='email']"));
			WebElement E2=driver.findElement(By.xpath("//input[@id='pass']")); 
		Row row =sheet.getRow(i);
		int cellcount= row.getLastCellNum();
		System.out.println(cellcount);
		 
		Cell cell= row.getCell(0);
		Cell cell2=row.getCell(1);
		String data=cell.getStringCellValue();
		String data2=cell2.getStringCellValue();
		 E1.sendKeys(data);
		 E2.sendKeys(data2);
		 driver.findElement(By.xpath("//*[@type='submit']")).click();
		 driver.navigate().back();
		 driver.navigate().refresh();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		}
		
		
		 
		
		}
		
	}
	
	


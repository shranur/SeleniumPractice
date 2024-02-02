package com.selenium.practice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RedBus {
	
		static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\anurag.shrivastava1\\New folder\\chromedriver-win64\\chromedriver.exe");
		
		driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		
		driver.get("https://www.redbus.in/");
		RedBus.fromCity();
		RedBus.toCity();
		//RedBus.calendarDate();
	}
	
	public static void fromCity() throws InterruptedException {
		
		
		WebElement from =driver.findElement(By.xpath("//label[contains(text(),'From')]//preceding-sibling::input"));
		
		from.sendKeys("hyderabad");
		
		List<WebElement> fromcityOptions = driver.findElements(By.xpath("//div[@tabindex='1']//ul//li//text[@class='placeHolderMainText']"));
		//System.out.println(fromcityOptions.size());
		//System.out.println("******************");
		
		
		 for(WebElement cityNames:fromcityOptions) 
		 {
		  
		  String names=cityNames.getText();
		  //System.out.println(names);
		 if(names.equalsIgnoreCase("Hyderabad")) {
			cityNames.click();
			}
		 break;
		  
		  }
		 }
		 
		
		 public static void toCity() throws InterruptedException {
		 
			 System.out.println("testing tocity is running");
			 WebElement to =driver.findElement(By.xpath("//label[contains(text(),'To')]//preceding-sibling::input[@tabindex='-1' and @id='dest']"));
			 to.sendKeys("banglore");
			Thread.sleep(2000);
			 
		List<WebElement> tocityOptions = driver.findElements(By.xpath("//div[@tabindex='2']//ul//li//text[@class='placeHolderMainText']"));
		//System.out.println("********************");
		//System.out.println(tocityOptions.size());
		
		for(WebElement toNames:tocityOptions) {
			
			String name=toNames.getText();
			//System.out.println(name);
			Thread.sleep(500);
				if(name.equalsIgnoreCase("bangalore")) {
					
					toNames.click();}
				break;
			  }
		
		 
		// String date= "18";
		String month ="Jan";
		String year ="2025";
		
		while(true)
		{
			
			String calendarDate = driver.findElement(By.xpath("//div[@class='DayNavigator__CalendarHeader-qj8jdz-1 fxvMrr']//div[2]")).getText();
			System.out.println(calendarDate);
			String [] cdt = calendarDate.split(" ");
			String mon = cdt[0];
			String yr = cdt[1];
			String d= cdt[2];
			//String txt = cdt[3];
			System.out.print("month:" +mon +" "+ "Year:" +" "+yr );
			
			if(mon.equalsIgnoreCase(month) && yr.equals(year))
				//System.out.println("in if loop");
				break;
//			else 
//				System.out.println("in else loop");
//			driver.findElement(By.xpath("//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD']//..//child::div[3]")).click();
//			break;
		
		}
		
		//date picker
//		List<WebElement> dateCl= driver.findElements(By.xpath("//span[@class='DayTiles__CalendarDaysSpan-a6izzv-1 gvUhhT']//.."));
//		System.out.println(dateCl);
//		for(WebElement ele:dateCl)
//		{
//			String e = ele.getText();
//			System.out.println(e);
//			
//		}
		}
			 
		//driver.quit();
	
	
	public static void calendarDate() {
		

		 
		 driver.findElement(By.id("onwardCal")).click();
		 
		 
		
		 
		
	}

}

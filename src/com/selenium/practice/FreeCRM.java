package com.selenium.practice;

import java.awt.event.ActionEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FreeCRM {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\anurag.shrivastava1\\New folder\\chromedriver-win64\\chromedriver.exe");
		
		driver= new ChromeDriver();
		driver.get("https://freecrm.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//span[text()='Log In']")).click();
		//Thread.sleep(5000);
		driver.findElement(By.name("email")).sendKeys("anuragshrivastava007@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Password");
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		
		FreeCRM.calendar();
		
		
		driver.quit();

	}
	
	public static void calendar() throws InterruptedException {
		
		Actions action = new Actions(driver);
		
		Thread.sleep(2000);
		WebElement hoverCalendar =driver.findElement(By.xpath("//div/a/i[@class='calendar icon']"));
		WebElement plusButton = driver.findElement(By.xpath("//div/a/i[@class ='calendar icon']//parent::a//following-sibling::button//i"));
		
		if(hoverCalendar.isDisplayed())
		{
		
			
		 action.moveToElement(hoverCalendar).build().perform();
		 
		 Thread.sleep(500);
		 action.moveToElement(plusButton).click().build().perform();
		 
		}
		
		//driver.findElement(By.xpath("//i[@class ='calendar icon']//parent::a//following-sibling::button//i")).click();
		//driver.findElement(By.xpath("//div[@class='item ']//a[@href='/calendar/new']")).click();
		driver.findElement(By.xpath("//input[@name='title']")).sendKeys("Test 4");
		 Thread.sleep(500);
		driver.findElement(By.xpath("//div[@name='category']/i[@class='dropdown icon']")).click();
		 Thread.sleep(500);
		List<WebElement> drpdwnValues =driver.findElements(By.xpath("//div[@class='visible menu transition']//div/span"));
		List<String> list = new ArrayList<>();
		
		//WebElement drpDownContainer = driver.findElement(By.xpath("//div[@class='visible menu transition']"));
		
		for(WebElement val:drpdwnValues)
		{
			 Thread.sleep(500);
			String drpName= val.getText();
			System.out.println(drpName);
			
			if(drpName.equals("Social")) {
				
				//JavascriptExecutor js = (JavascriptExecutor) driver;
				//js.executeScript("arguments[0].scrollIntoView();",drpDownContainer);
				 Thread.sleep(500);

				WebElement drpdwnValueName = driver.findElement(By.xpath("//div[@class='visible menu transition']//div/span[text()='"+drpName+"']"));
				 Thread.sleep(500);

				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView();",drpdwnValueName);
				drpdwnValueName.click();
				
				
			}
			list.add(drpName);
			
		}
		System.out.println(list);
		Thread.sleep(500);
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("This is for testing purpose");
		Thread.sleep(500);
		driver.findElement(By.xpath("//textarea[@name='location']")).sendKeys("Mumbai");
		driver.findElement(By.xpath("//div[@class='item']//button//i[@class='save icon']")).click();
		Thread.sleep(500);
		
		

		
	}

}

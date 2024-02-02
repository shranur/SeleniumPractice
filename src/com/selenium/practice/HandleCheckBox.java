package com.selenium.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandleCheckBox {

		static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\anurag.shrivastava1\\New folder\\chromedriver-win64\\chromedriver.exe");

		driver = new ChromeDriver();
		// driver.get("https://freecrm.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://amazon.in/");
		
		HandleCheckBox.label();
	}
	
	public static void label() throws InterruptedException {

		Actions action = new Actions(driver);
		Thread.sleep(2000);
		
		
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Account & Lists')]"));
		
		WebElement myAccount = driver.findElement(By.xpath("//span[contains(text(),'Your Account')]"));
		

		
		  if(element.isDisplayed()) 
		  { 
			  System.out.println("First element found");
			  action.moveToElement(element).build().perform();
			  Thread.sleep(1000);
			  action.moveToElement(myAccount).click().build().perform();
			  System.out.println("Second element found");
			  
		  }
		  
		  driver.quit();
		 

	}

}

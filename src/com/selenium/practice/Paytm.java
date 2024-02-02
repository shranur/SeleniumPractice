package com.selenium.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Paytm {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\anurag.shrivastava1\\New folder\\chromedriver-win64\\chromedriver.exe");

		driver = new ChromeDriver();
		// driver.get("https://freecrm.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://paytm.com/");
		Paytm.label();

	}

	public static void label() throws InterruptedException {

		Actions action = new Actions(driver);
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//ul[@id='topNavData']//a[text()='Paytm for Consumer']"));
		WebElement payments = driver.findElement(By.xpath("//ul//li//ul[@class='BjkLs']//div//a[text()='Payments']"));
		WebElement inStore = driver.findElement(By.xpath("//ul[@class='_1VXMb']//li//div//a[text()='In-Store Payments']"));
		//element.click();

		
		  if(element.isDisplayed()) 
		  { 
			  System.out.println("First element found");
			  action.moveToElement(element);//.build().perform();
			  Thread.sleep(1000);
			  action.moveToElement(payments);//.build().perform();
			  System.out.println("Second element found");
			  Thread.sleep(1000);
			  action.moveToElement(inStore);//.click().build().perform(); 
			  action.click().build().perform();
		  }
		 

	}

}

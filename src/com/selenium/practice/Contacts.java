package com.selenium.practice;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Contacts {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
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
		
		Contacts.contacts();
				
		driver.quit();
	}
	
	public static void contacts() throws InterruptedException {
		
		
		Actions action = new Actions(driver);
		
		Thread.sleep(2000);
		WebElement hoverContacts =driver.findElement(By.xpath("//div/a/i[@class='users icon']"));
		WebElement plusButton = driver.findElement(By.xpath("//div/a/i[@class='users icon']//parent::a//following-sibling::button//i"));
		
		if(hoverContacts.isDisplayed())
		{
		
			
		 action.moveToElement(hoverContacts).build().perform();
		 
		 Thread.sleep(500);
		 action.moveToElement(plusButton).click().build().perform();
		 
		}
		
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[@class='ui button']//following-sibling::button//i[@class='save icon']")).click();
		WebElement ele = driver.findElement(By.xpath("//div[@class='field']//descendant::span"));
		String errorMessage = ele.getText();
		System.out.println(errorMessage);
	}

}

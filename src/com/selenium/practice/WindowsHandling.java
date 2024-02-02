package com.selenium.practice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandling {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\anurag.shrivastava1\\New folder\\chromedriver-win64\\chromedriver.exe");
		
		driver= new ChromeDriver();
		driver.get("https://www.hdfcbank.com/");
		driver.manage().window().maximize();
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement ele = driver.findElement(By.xpath("//a[contains(text(),'Your Account')]"));
		ele.sendKeys(Keys.chord(Keys.CONTROL , Keys.RETURN));
		
		Set<String> win =driver.getWindowHandles();
		
//		Iterator<String> itr= win.iterator();
//		
//		String pId = itr.next();
		
		List<String> lst = new ArrayList<String>(win);
		
		for(String windowId:lst)
		{
			System.out.println(windowId);
			String title =driver.switchTo().window(windowId).getTitle();
			System.out.println(title);
			
		}
		driver.switchTo().window("89AE7E88C26645436CC0A88977319611");

	}

}

package com.selenium.practice;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
	
	static WebDriver driver;

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\anurag.shrivastava1\\New folder\\chromedriver-win64\\chromedriver.exe");

		driver = new ChromeDriver();
		// driver.get("https://freecrm.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.deadlinkcity.com/");
		BrokenLinks.brokenLinks();
		driver.quit();

	}
	
	public static void brokenLinks() throws MalformedURLException {
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		//System.out.println(allLinks.size());
		int noOfBrokenLinks=0;
		
		for(WebElement links :allLinks)
		{
			String linkName = links.getAttribute("href");
			//System.out.println(urlLinks);
			
			
			if(linkName==null || linkName.isEmpty())
			{
				System.out.println(linkName +" is Empty link");
				continue;
			}
			
			URL url = new URL(linkName);
			
			try {
				
				HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
				httpConnection.connect();
				
				if(httpConnection.getResponseCode()>=400)
				{
					System.out.println(url +" Is Broken Link" +"and response code is:" +httpConnection.getResponseCode());
					noOfBrokenLinks++;
				}
				
				else {
					System.out.println(url + " Is VALID Link" +"and response code is:" +httpConnection.getResponseCode());
				}
				
				
				
			} catch (Exception e) {
							}
			
		}
		System.out.println(noOfBrokenLinks);
		
		
		
	}

}

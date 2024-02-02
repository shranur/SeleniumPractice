package com.selenium.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownHandling {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\anurag.shrivastava1\\New folder\\chromedriver-win64\\chromedriver.exe");
		
		driver= new ChromeDriver();
		driver.get("https://geodatasource.com/software/country-region-dropdown-menu-demo");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//button[text()='Accept']")).click();
		
		
		
		WebElement ele = driver.findElement(By.xpath("//form[@class='form-horizontal']//select[@country-data-region-id='gds-cr-one']"));
		WebElement example = driver.findElement(By.xpath("//div[@class='col-sm-10']//select[@id='gds-cr-one']"));
		
		WebElement ele1 = driver.findElement(By.xpath("//form[@class='form-horizontal']//select[@country-data-region-id='gds-cr-two']"));
		WebElement example1 = driver.findElement(By.xpath("//div[@class='col-sm-10']//select[@id='gds-cr-two']"));
		
		WebElement ele2 = driver.findElement(By.xpath("//form[@class='form-horizontal']//select[@country-data-region-id='gds-cr-three']"));
		WebElement example2 = driver.findElement(By.xpath("//div[@class='col-sm-10']//select[@id='gds-cr-three']"));
		
		WebElement ele3 = driver.findElement(By.xpath("//form[@class='form-horizontal']//select[@country-data-region-id='gds-cr-four']"));
		WebElement example3 = driver.findElement(By.xpath("//div[@class='col-sm-10']//select[@id='gds-cr-four']"));
		
		DropDownHandling.drpDownHandling(ele, "India");
		DropDownHandling.drpDownHandling(example, "Delhi");
		
		DropDownHandling.drpDownHandling(ele1, "Cuba");
		DropDownHandling.drpDownHandling(example1, "Guantanamo");
		
		DropDownHandling.drpDownHandling(ele2, "Spain");
		DropDownHandling.drpDownHandling(example2, "Cantabria");
		
		DropDownHandling.drpDownHandling(ele3, "united states of America");
		DropDownHandling.drpDownHandling(example3, "montana");
		
//		Select sc = new Select(ele);
//		sc.selectByValue("India");
//		List<WebElement> drpList= sc.getOptions();
		
		

	}
	
	public static void drpDownHandling(WebElement element, String str)
	{
		Select select = new Select(element);
		List<WebElement> drpDownList =select.getOptions();
		
		for(WebElement e: drpDownList)
		{
			if(e.getText().equalsIgnoreCase(str))
			{
				e.click();
				break;
			}
		}
	}

}

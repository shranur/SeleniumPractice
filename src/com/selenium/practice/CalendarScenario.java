package com.selenium.practice;

import java.time.Duration;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarScenario {
	
	public static void main(String[] args) {
		
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getTime());
		//System.out.println(calendar.get(calendar.DAY_OF_MONTH);
		
		 // Demonstrate Calendar's get()method 
        System.out.println("Current Calendar's Year: " + calendar.get(Calendar.YEAR)); 
        System.out.println("Current Calendar's Day: " + calendar.get(Calendar.DATE)); 
        System.out.println("Current MINUTE: " + calendar.get(Calendar.MINUTE)); 
        System.out.println("Current SECOND: " + calendar.get(Calendar.SECOND)); 
	}
	
	public void explicitWait(WebDriver driver, By locator, int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		ele.click();
	}

}

package com.selenium.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;



public class Browser {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\anurag.shrivastava1\\New folder\\chromedriver-win64\\chromedriver.exe");
		
		driver= new ChromeDriver();
		
		
//		driver.get("https://paytm.com/");
//		String title=driver.getTitle();
//		System.out.println("Title of page is:" +" "+  title);
		//String pageSource = driver.getPageSource();
		
		//Open a new tab in same browser
		
		//driver.switchTo().newWindow(WindowType.TAB);
		// Opens LambdaTest home page in the newly opened tab
		
		driver.navigate().to("https://ui.cogmento.com/calls");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//String title2=driver.getTitle();
		//System.out.println("Title of page is:" +" "+  title2);
		
//		// Opens a new window and switches to new window
//		driver.switchTo().newWindow(WindowType.WINDOW);
//		// Opens LambdaTest  in the newly opened window
//		driver.navigate().to("https://www.lambdatest.com/");
//		driver.close();
		
		//.out.println("Title of page source is:" +" "+  pageSource);
		Browser.login();
		driver.quit();

	}
	
	public static void login() throws InterruptedException {
		
		WebElement email = driver.findElement(By.name("email"));
		WebElement pass = driver.findElement(By.name("password"));
		WebElement loginButton= driver.findElement(By.xpath("//div[text()='Login']"));
		
		loginButton.click();
		Thread.sleep(1000);
		
		
		
//			WebElement errorMessage1 = driver.findElement(By.xpath("//div[@class='ui negative message']//p"));
//			System.out.println(errorMessage1.getText());
			
			email.sendKeys("anuragshrivastava007@gmail.com");
			pass.sendKeys("Password");
			loginButton.click();
			System.out.println(driver.getTitle());
			
		
		
		
		
	}

}

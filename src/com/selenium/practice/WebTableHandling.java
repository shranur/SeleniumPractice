package com.selenium.practice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableHandling {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\anurag.shrivastava1\\New folder\\chromedriver-win64\\chromedriver.exe");
		
		driver= new ChromeDriver();
		driver.get("https://testuserautomation.github.io/WebTable/");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://cosmocode.io/automation-practice-webtable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//WebTableHandling.webTable();
		WebTableHandling.listOfCountriesTable();
		driver.quit();

	}
	
	public static void webTable() {
		
		
		List<WebElement>tableHeader=driver.findElements(By.xpath("//table//tr/th"));
		
		for(WebElement ele:tableHeader)
		{
			String headerName =ele.getText();
			System.out.println(headerName);
			
		}
		
		List<WebElement>tableRow=driver.findElements(By.xpath("//table//tr/td"));
		System.out.println(tableRow.size());
		for(WebElement e:tableRow)
		{
			String headerRow =e.getText();
			
			if(!headerRow.isBlank())
			    System.out.println(headerRow);
			
		}
		
		List<WebElement>rows=driver.findElements(By.xpath("//table//tr"));
		System.out.println(rows.size());
		driver.findElement(By.xpath("//table//tr//input[@name='select2']")).click();
		
		
		
	}
	
	public static void listOfCountriesTable() {
		String rowText = null;
		String colText = null;
		List<WebElement> rowsOfTable = driver.findElements(By.xpath("//table[@id='countries']//tr"));
		int rowCount = rowsOfTable.size();
		for(WebElement text:rowsOfTable)
		{
			 rowText=text.getText();
			 //System.out.println( rowText);
		}
		System.out.println("No of Rows in table:" +"  " +rowCount);
		
		List<WebElement> columnOfTable = driver.findElements(By.xpath("//table[@id='countries']//td//h3"));
		int colCount = columnOfTable.size();
		for(WebElement textclm:rowsOfTable)
		{
			 colText=textclm.getText();
			 //System.out.println(colText);
		}
		System.out.println("No of Column in table:" +"  " +colCount);
		
		//List<String> al = new ArrayList<String>();
		
		for(int i=2;i<=10;i++)
		{
			
			for(int j=2;j<=colCount;j++)
			{
				String data =driver.findElement(By.xpath("//table[@id='countries']//tr["+i+"]//td["+j+"]")).getText();
				System.out.print(data +"  ");
				//al.add(data + "  ");
				//System.out.print(al);
			}
			
			System.out.println();
		}
		
		//WebElement ele = driver.findElement(By.xpath("//table[@id='countries']//tr['"+i+"']//td['"+j+"']"));
		
		
	}

}

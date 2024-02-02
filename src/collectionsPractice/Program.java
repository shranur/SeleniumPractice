package collectionsPractice;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Program p = new Program();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\anurag.shrivastava1\\New folder\\chromedriver-win64\\chromedriver.exe");
		driver= new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		//driver.get("https://www.linkedin.com/?trk=article-ssr-frontend-pulse_nav-header-logo");
//		
//		String credentials1 =data().get("x");
//		String[]uarr=credentials1.split("@");
//		for(String s:uarr)
//		{
//			System.out.println(s);
//		}
		
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Program.jqueryDropDown();
		//driver.quit();
		

	}

	
	
	static HashMap<String, String> data() {
		HashMap<String,String> hm = new HashMap<String,String>();
		hm.put("x", "admin@password");
		hm.put("y", "admin1@pass");
		
		return hm;
	}
	
	static void jqueryDropDown() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@id='justAnInputBox1']")).click();
		Thread.sleep(500);
		List<WebElement> elements = driver.findElements(By.xpath("//input[@id='justAnInputBox1']//..//following-sibling::div//span[@class='comboTreeItemTitle']"));
		
		for(WebElement e:elements)
		{
			System.out.println(e.getText());
			e.click();
			Thread.sleep(200);
		}
	}

}

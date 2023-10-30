package Pratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class calendarPopUpFutureDate {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.findElement(By.className("commonModal__close")).click();
		driver.findElement(By.xpath("//label[@for='departure']")).click();
		//driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		for(;;)
		{
			try
			{
				driver.findElement(By.xpath("//div[@aria-label='Thu Jan 11 2024']")).click();
				break;
			}
			catch(Exception e)
			{
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
				Thread.sleep(1000);
				
			}
		}
	}

}

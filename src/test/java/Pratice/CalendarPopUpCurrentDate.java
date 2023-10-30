package Pratice;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarPopUpCurrentDate {

	public static void main(String[] args) throws InterruptedException {
		
		
		Date d = new Date();
		String datenow = d.toString();
		System.out.println(datenow);
		String[] dArr = d.toString().split(" ");
		String currentDate = dArr[0]+" "+dArr[1]+" "+dArr[2]+" "+dArr[5];
		System.out.println(currentDate);
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.findElement(By.className("commonModal__close")).click();
		driver.findElement(By.xpath("//label[@for='departure']")).click();
		Thread.sleep(1000);                       //dynamic xpath
		driver.findElement(By.xpath("//div[@aria-label='"+currentDate+"']")).click();
		                             //div[@aria-label='Sat Jul 08 2023']
		                             //div[@aria-label='Sat Jul 09 2023']
		                             //div[@aria-label='Sat Jul 18 2023']
		
		

	}

}

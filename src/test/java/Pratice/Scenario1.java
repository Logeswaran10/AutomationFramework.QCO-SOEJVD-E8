package Pratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario1 {

	public static void main(String[] args) throws InterruptedException {
		
		//launch the browser
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();
		
		//login to app
		driver.findElement(By.name("user_name")).sendKeys("admin");
        driver.findElement(By.name("user_password")).sendKeys("admin");
        driver.findElement(By.id("submitButton")).click();
        Thread.sleep(2000);
     
        // navigate to contact
        driver.findElement(By.linkText("Contacts")).click();
        //create a contact
        driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
        driver.findElement(By.name("lastname")).sendKeys("Varun123");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        
        //validate
        String Validate = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
        
        if(Validate.contains("Varun123"))
        {
        	System.out.println("PASS");
        }
        else
        {
        	System.out.println("FAIL");
        }
        
        //signout
        WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
        Actions act=new Actions(driver);
        act.moveToElement(signout).perform();
        Thread.sleep(1000);
        
        driver.findElement(By.linkText("Sign Out")).click();
        Thread.sleep(1000);
        driver.quit();
        
        
	}

}

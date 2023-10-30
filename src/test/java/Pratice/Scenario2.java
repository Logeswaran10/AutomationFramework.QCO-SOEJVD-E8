package Pratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario2 {

	public static void main(String[] args) throws InterruptedException {

		// launch the browser
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();

		// login to app
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(2000);

		//navigate to org
		driver.findElement(By.linkText("Organizations")).click();
		
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("Qspiders78");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 //validate
		Thread.sleep(1000);
        String Validate = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
        
        if(Validate.contains("Qspiders78"))
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

package Pratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario4 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://localhost:8888");
		driver.findElement(By.xpath("//div[contains(text(),'User Name')]/following::input[1]")).sendKeys("admin");
        driver.findElement(By.xpath("//div[contains(text(),'User Name')]/following::input[2]")).sendKeys("admin");
        driver.findElement(By.id("submitButton")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'Organizations')]")).click();
       // Thread.sleep(2000);
        driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
        driver.findElement(By.name("accountname")).sendKeys("Qspiders123");
        driver.findElement(By.xpath("//b[contains(text(),'Address Information')]/preceding::input[2]")).click();
        
        Select Industry = new Select(driver.findElement(By.name("industry")));
        Industry.selectByVisibleText("Energy");
        
        Select Type = new Select(driver.findElement(By.name("accounttype")));
        Type.selectByVisibleText("Customer");
        driver.findElement(By.xpath("//td[contains(text(),' Organization Information')]/following::input[1]")).click();

	}

}

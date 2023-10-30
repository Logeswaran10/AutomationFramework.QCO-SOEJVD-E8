package Pratice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.loginPage;

public class createOrganization {

	public static void main(String[] args) throws IOException {
		
		// step 1 : create all the req objects
		JavaUtility jutil = new JavaUtility();
		ExcelFileUtility eutil = new ExcelFileUtility();
		PropertyFileUtility putil = new PropertyFileUtility();
		WebDriverUtility wutil = new WebDriverUtility();
		WebDriver driver = null;

		// step 2: read the req data
		String BROWSER = putil.readDataFromPropertyFile("Browser");
		String URL = putil.readDataFromPropertyFile("Url");
		String USERNAME = putil.readDataFromPropertyFile("username");
		String PASSWORD = putil.readDataFromPropertyFile("password");
		
		String ORGNAME = eutil.readDataFromExcel("Organization", 1, 2)+jutil.getRandomNumber();
		 
		//step 3 : launch the browser
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(BROWSER+" launched");
		}
		else if(BROWSER.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(BROWSER+" launched");
		}
		else if(BROWSER.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println(BROWSER+" launched");
		}
		else
		{
			System.out.println("Invalid Browser Name");
		}
		wutil.maximizeWindow(driver);
		wutil.waitForPageLoad(driver);
		
		//step 4 : load the url
		driver.get(URL);
		
		// step 5:login to the application
	//	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		//driver.findElement(By.id("submitButton")).click(); 
		
		loginPage lp = new loginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
	/*	lp.getUserNameEdt().sendKeys(USERNAME);
		lp.getPasswordEdt().sendKeys(PASSWORD);
		lp.getLoginBtn().click(); */
		
		
		//step 6:navigate to organization link
		driver.findElement(By.linkText("Organizations")).click();
		
		//step 7:create on create organization look up image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Step 8: Create Organization with mandatory information
				driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
				
				//Step 9: save
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//Step 10: Validate
				wutil.waitForPageLoad(driver);
				String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				
				if(OrgHeader.contains(ORGNAME))
				{
					System.out.println(OrgHeader);
					System.out.println("PASS");
				}
				else
				{
					System.out.println("FAIL");
				}
				
				//Step 11: Logout of Application
				WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				wutil.mouseHoverAction(driver, ele);
				
				driver.findElement(By.linkText("Sign Out")).click();
				System.out.println("logout successful");
				
				
				

				
				
			}
		
		
		
		
		
		
		
		

	}



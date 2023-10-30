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

public class createContactWithOrganization {

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
				
				String ORGNAME = eutil.readDataFromExcel("Contacts", 7, 3)+jutil.getRandomNumber();
				String LASTNAME = eutil.readDataFromExcel("Contacts", 7, 2);

				 
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
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
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
							System.out.println("Organization created successfully");
						}
						else
						{
							System.out.println("FAIL");
						}
						// Step 10: Navigate to Contacts
						driver.findElement(By.linkText("Contacts")).click();

						// Step 11: Click on create Contact look Up Image
						driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

						// Step 12: Create Contact with mandatory fields
						driver.findElement(By.name("lastname")).sendKeys(LASTNAME);

						// Step 13: click on Organization look Up Image
						driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();

						wutil.switchWindow(driver, "Accounts");

						driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
						driver.findElement(By.name("search")).click();

						driver.findElement(By.xpath("//a[text()='" + ORGNAME + "']")).click();
						// Orgname is dynamic
						// xpath is changing dynamically - dynamic xpath
						// a[text()='"+varible+"']

						wutil.switchWindow(driver, "Contacts");

						// Step 14: save
						driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

						// Step 15: Validate for Organization
						String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

						if (ContactHeader.contains(LASTNAME)) {
							System.out.println(ContactHeader);
							System.out.println("PASS");
						} else {
							System.out.println("FAIL");
						}

						// Step 16: logout of app
						WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
						wutil.mouseHoverAction(driver, ele);

						driver.findElement(By.linkText("Sign Out")).click();
						System.out.println("logout successful");


	}

}

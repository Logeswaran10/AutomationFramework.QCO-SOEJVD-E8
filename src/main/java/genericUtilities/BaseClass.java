package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.homePage;
import objectRepository.loginPage;

public class BaseClass {
	
	public PropertyFileUtility putil = new PropertyFileUtility();
	public ExcelFileUtility eutil = new ExcelFileUtility();
	public JavaUtility jutil = new JavaUtility();
	public WebDriverUtility wutil = new WebDriverUtility();
	public WebDriver driver = null;
	
	//used for Listeners
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	public void bsconfig()
	{
		System.out.println("---- DB Connection Succesfull ----");
	}
	
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcconfig(/*String BROWSER*/) throws IOException
	{
		String BROWSER = putil.readDataFromPropertyFile("Browser");
		String URL = putil.readDataFromPropertyFile("Url");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(BROWSER+"---- launched ----");
		}
		else if(BROWSER.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(BROWSER+"---- launched ----");
		}
		else if(BROWSER.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println(BROWSER+"---- launched ----");
		}
		else
		{
			System.out.println("Invalid Browser Name");
		}
		wutil.maximizeWindow(driver);
		wutil.waitForPageLoad(driver);
		
		//used for listeners
		sdriver=driver;
		
		driver.get(URL);
		
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmconfig() throws IOException
	{
		
		String USERNAME = putil.readDataFromPropertyFile("username");
		String PASSWORD = putil.readDataFromPropertyFile("password");
		
		loginPage lp = new loginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("---- Login Succesfull ----");
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void amconfig() throws InterruptedException
	{
		
		homePage hp =  new homePage(driver);
		hp.logOutOfApp(driver);
		
		System.out.println("---- Logout Succesfull ----");
		
	}
	
	//@AfterTest
	@AfterClass(alwaysRun = true)
	public void acconfig()
	{
		
		driver.quit();
		
		System.out.println("---- Browser Closed ----");
		
	}
	
	
	@AfterSuite(alwaysRun = true)
	public void asconfig()
	{
		System.out.println("---- DB Closed Succesfull ----");
	}
	
	
	
	

}

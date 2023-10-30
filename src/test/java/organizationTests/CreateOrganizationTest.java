package organizationTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.createNewOrganizationPage;
import objectRepository.homePage;
import objectRepository.loginPage;
import objectRepository.organizationInformationPage;
import objectRepository.organizationPage;

public class CreateOrganizationTest extends BaseClass {

	@Test
	
	public void createOrganizationTest() throws IOException, InterruptedException
	
	{
		
		
	/*	String ORGNAME = eutil.readDataFromExcel("Contacts", 7, 3)+jutil.getRandomNumber();
		String LASTNAME = eutil.readDataFromExcel("Contacts", 7, 2); */
		
		String ORGNAME = eutil.readDataFromExcel("Organization", 4, 2)+jutil.getRandomNumber();
	//	String INDUSTRY = eutil.readDataFromExcel("Organization", 4, 3);

		 
		
		
		
		
		//step 6 : click on organization
		homePage hp =  new homePage(driver);
		hp.clickOnOrganizationLink();
		
		// step 7: click on create organization look up image
		organizationPage op = new organizationPage(driver);
		op.clickOnOrganizationLookUpImg();
		
		// step 8:create new organization with industry
		createNewOrganizationPage cnop = new createNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);
		
		// step 9 : validate for organization
		organizationInformationPage oip = new organizationInformationPage(driver);
		String orgheader = oip.getHeaderText();
		Assert.assertTrue(orgheader.contains(ORGNAME));
		
			System.out.println(orgheader);
			
		
		

		

	}

}

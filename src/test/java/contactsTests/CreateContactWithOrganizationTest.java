package contactsTests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
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
import objectRepository.contactsPage;
import objectRepository.contatcsInformationpage;
import objectRepository.createNewContactsPage;
import objectRepository.createNewOrganizationPage;
import objectRepository.homePage;
import objectRepository.loginPage;
import objectRepository.organizationInformationPage;
import objectRepository.organizationPage;

public class CreateContactWithOrganizationTest extends BaseClass {

	@Test(groups = "RegressionSuite")
	
	public void createContactWithOrgTest() throws IOException, InterruptedException
	{
		
		
		
		String ORGNAME = eutil.readDataFromExcel("Contacts", 7, 3)+jutil.getRandomNumber();
		String LASTNAME = eutil.readDataFromExcel("Contacts", 7, 2);

		 
	
		
		
		
		//step 6 : click on organization
		homePage hp =  new homePage(driver);
		hp.clickOnOrganizationLink();
		
		// step 7: click on create organization look up image
		organizationPage op = new organizationPage(driver);
		op.clickOnOrganizationLookUpImg();
		
		// step 8:create new organization with mandatory fields
		createNewOrganizationPage cnop = new createNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);
		
		// step 9 : validate for organization
		organizationInformationPage oip = new organizationInformationPage(driver);
		String orgheader = oip.getHeaderText();
		if(orgheader.contains(ORGNAME))
		{
			System.out.println(orgheader);
			System.out.println("Organization Created");
		}
		else
		{
			System.out.println("fail");
			}
		
		// step 10 : click on contacts link
		hp.clickOnContactsLink();
		
		// step 11:click on create contact look up image
		contactsPage cp = new contactsPage(driver);
		cp.clickOnContactLookUpImage();

		// step 12:create contact with organization
		createNewContactsPage cncp = new createNewContactsPage(driver);
		cncp.createNewContact(driver, LASTNAME, ORGNAME);
		
		//step 13:validation
		contatcsInformationpage cip = new contatcsInformationpage(driver);
		String contactsheader = cip.getHeaderText();
		Assert.assertTrue(contactsheader.contains(LASTNAME));
		
			System.out.println(contactsheader);
			
		
		
	}

}

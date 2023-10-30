package contactsTests;

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
import objectRepository.contactsPage;
import objectRepository.contatcsInformationpage;
import objectRepository.createNewContactsPage;
import objectRepository.homePage;
import objectRepository.loginPage;

public class CreateContactWithLeadSourceTest extends BaseClass {
	
	@Test
	
	public void createContactWithLeadSource() throws IOException, InterruptedException

	
	{
		
		
		
		
	//	String ORGNAME = eutil.readDataFromExcel("Contacts", 7, 3)+jutil.getRandomNumber();
		String LASTNAME = eutil.readDataFromExcel("Contacts", 4, 2);
		String LEADSOURCE = eutil.readDataFromExcel("Contacts", 4, 3);

		 
		
		

		// step 10 : click on contacts link
		homePage hp =  new homePage(driver);
		hp.clickOnContactsLink();
		
		// step 11:click on create contact look up image
		contactsPage cp = new contactsPage(driver);
		cp.clickOnContactLookUpImage();

		// step 12:create contact with organization
		createNewContactsPage cncp = new createNewContactsPage(driver);
	//	cncp.createNewContact(driver, LASTNAME, ORGNAME);
		//cncp.createNewContact(LASTNAME);
		cncp.createNewContact(LASTNAME, LEADSOURCE);
		
		//step 13:validation
		contatcsInformationpage cip = new contatcsInformationpage(driver);
		String contactsheader = cip.getHeaderText();
		Assert.assertTrue(contactsheader.contains(LASTNAME));
		
			System.out.println(contactsheader);

	}

}

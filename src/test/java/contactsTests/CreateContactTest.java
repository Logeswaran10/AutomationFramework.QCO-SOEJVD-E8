package contactsTests;

import java.io.IOException;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;

import objectRepository.contactsPage;
import objectRepository.contatcsInformationpage;
import objectRepository.createNewContactsPage;
import objectRepository.homePage;

@Listeners(genericUtilities.ListenersImplementationClass.class)

public class CreateContactTest extends BaseClass {

	@Test(groups = "SmokeSuite")

	public void createContactTest() throws IOException, InterruptedException

	{

		// String ORGNAME = eutil.readDataFromExcel("Contacts", 7,
		// 3)+jutil.getRandomNumber();
		String LASTNAME = eutil.readDataFromExcel("Contacts", 1, 2);

		// step 10 : click on contacts link
		homePage hp = new homePage(driver);
		hp.clickOnContactsLink();
		Reporter.log("Clicked on contacts link");

		// step 11:click on create contact look up image
		contactsPage cp = new contactsPage(driver);
		cp.clickOnContactLookUpImage();
		Reporter.log("Clicked on create contact lookup image");

		// step 12:create contact with organization
		createNewContactsPage cncp = new createNewContactsPage(driver);
		// cncp.createNewContact(driver, LASTNAME, ORGNAME);
		cncp.createNewContact(LASTNAME);
		Reporter.log("Contact created succesfully");

		// step 13:validation
		contatcsInformationpage cip = new contatcsInformationpage(driver);
		String contactsheader = cip.getHeaderText();
		Reporter.log("Header Captured");
		//Assert.fail();
		Assert.assertTrue(contactsheader.contains(LASTNAME));
		Reporter.log("Header Validated");

		System.out.println(contactsheader);

	}
	
	@Test
	public void demo()
	{
		System.out.println("Hi Demo");
	}

}

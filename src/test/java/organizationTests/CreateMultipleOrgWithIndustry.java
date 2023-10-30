package organizationTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
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

public class CreateMultipleOrgWithIndustry extends BaseClass {

	

	@Test(dataProvider = "getData")
	public void createMultipleOrg(String ORG, String IndustryName) throws InterruptedException, IOException {
		

		String ORGNAME = ORG + jutil.getRandomNumber();

		

		// step 6 : click on organization
		homePage hp = new homePage(driver);
		hp.clickOnOrganizationLink();

		// step 7: click on create organization look up image
		organizationPage op = new organizationPage(driver);
		op.clickOnOrganizationLookUpImg();

		// step 8:create new organization with industry
		createNewOrganizationPage cnop = new createNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME, IndustryName);
		wutil.captureScreenshot(driver, ORGNAME);

		// step 9 : validate for organization
		organizationInformationPage oip = new organizationInformationPage(driver);
		String orgheader = oip.getHeaderText();
		if (orgheader.contains(ORGNAME)) {
			System.out.println(orgheader);
			System.out.println("Organization Created");
		} else {
			System.out.println("fail");
		}

		
	}

	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException {
		return eutil.readMultipleData("MultipleOrganizations");

	}

}

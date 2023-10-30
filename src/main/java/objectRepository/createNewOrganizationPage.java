package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class createNewOrganizationPage extends WebDriverUtility { //rule 1
	
	//rule 2 decleration
	
	
	@FindBy(name = "accountname")
	private WebElement organizationNameEdt;
	
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
	@FindBy(name="accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//rule 3 initialization
	public createNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	
	}

	//rule 4 utilisation
	

	public WebElement getOrganizationNameEdt() {
		return organizationNameEdt;
		
		
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}
	
	//business library
	/**
	 * this method will create organization and save it
	 * @param ORGNAME
	 */
	
	public void createNewOrganization(String ORGNAME)
	{
		organizationNameEdt.sendKeys(ORGNAME);
		saveBtn.click();
	}
	
	/**
	 * this method will create organization with industry dropdown
	 * @param ORGNAME
	 * @param INDUSTRY
	 */
	public void createNewOrganization(String ORGNAME , String INDUSTRY)
	{
		organizationNameEdt.sendKeys(ORGNAME);
		handleDropDown(industryDropDown,INDUSTRY);
		
		saveBtn.click();
		}
	
	/**
	 * this method will create organization with industry and type dropdown
	 * @param ORGNAME
	 * @param INDUSTRY
	 * @param TYPE
	 */
	public void createNewOrganization(String ORGNAME , String INDUSTRY , String TYPE)
	{
		organizationNameEdt.sendKeys(ORGNAME);
		handleDropDown(industryDropDown,INDUSTRY);
		handleDropDown(typeDropDown, TYPE);
		saveBtn.click();
		}
	
	
	
	
	
}

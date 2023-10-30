package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class createNewContactsPage extends WebDriverUtility { //rule 1
	
	//rule 2 declarization
	
	
	
	@FindBy(name = "lastname")
	private WebElement contactsNameBtn;
	
	@FindBy(name = "leadsource")
	private WebElement leadSourceDropDown;
	
	@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement organizationLookUpBtn;
	
	@FindBy(id = "search_txt")
	private WebElement searchEdt;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement contatcsSaveBtn;
	
	//rule 3 intialization
	public createNewContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	

	//rule 4 utilization
	

	public WebElement getContactsNameBtn() {
		return contactsNameBtn;
	}

	public WebElement getOrganizationLookUpBtn() {
		return organizationLookUpBtn;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}



	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}



	public WebElement getContatcsSaveBtn() {
		return contatcsSaveBtn;
	}
	
	//business library
	
	/**
	 * this method will create contact with mandatory field and save
	 * @param LASTNAME
	 */
	public void createNewContact(String LASTNAME)
	{
		contactsNameBtn.sendKeys(LASTNAME);
		contatcsSaveBtn.click();
	}
	
	/**
	 * this method will create contact with organization
	 * @param driver
	 * @param LASTNAME
	 * @param ORGNAME
	 */
	public void createNewContact(WebDriver driver , String LASTNAME , String ORGNAME)
	{
       contactsNameBtn.sendKeys(LASTNAME);
       organizationLookUpBtn.click();
       switchWindow(driver, "Accounts");
       searchEdt.sendKeys(ORGNAME);
       searchBtn.click();
       driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
       switchWindow(driver, "Contacts");
       contatcsSaveBtn.click();
		
		
		
	}
	
	/**
	 * this method will create contact with leadsource dropdown
	 * @param LASTNAME
	 * @param LEADSOURCE
	 */
	
	public void createNewContact (String LASTNAME , String LEADSOURCE)
	{
		contactsNameBtn.sendKeys(LASTNAME);
		handleDropDown(leadSourceDropDown, LEADSOURCE);
		contatcsSaveBtn.click();
	}
	
	

}

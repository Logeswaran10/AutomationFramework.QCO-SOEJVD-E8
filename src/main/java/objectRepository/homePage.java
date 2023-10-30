package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class homePage extends WebDriverUtility { //rule 1
	
	//rule 2 decleration dropdown , frames, windows, textfields , windows
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsBtn;
	
	@FindBy(linkText = "Products")
	private WebElement productsLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLnk;
	
	//intilalization
	public homePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//utilization
	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}

	public WebElement getContactsBtn() {
		return contactsBtn;
	}

	public WebElement getProductsLnk() {
		return productsLnk;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignOutLnk() {
		return signOutLnk;
	}
	
	//business library
	/**
	 * this method will click on organization link
	 */
	public void clickOnOrganizationLink()
	{
		organizationLnk.click();
	}
	/**
	 * this method will click on contacts link
	 */
	public void clickOnContactsLink()
	{
		contactsBtn.click();
	}
	/**
	 * this method will logout of the application
	 * @param driver
	 * @throws InterruptedException
	 */
	
	public void logOutOfApp(WebDriver driver) throws InterruptedException
	{
		mouseHoverAction(driver, administratorImg);
		Thread.sleep(1000);
		signOutLnk.click();
		
	}
	
	
	
	

}

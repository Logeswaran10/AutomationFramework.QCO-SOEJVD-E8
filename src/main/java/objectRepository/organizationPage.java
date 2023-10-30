package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class organizationPage { //rule 1
	
	//rule 2 decleration
	
	@FindAll({@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']"),@FindBy(xpath = "//img[@alt='Create Organization...']")})
	private WebElement createOrganizationLookUpImg;
	
	//rule 3 initialisation
	public organizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//rule 4 utilisation
	public WebElement getCreateOrganizationLookUpImg() {
		return createOrganizationLookUpImg;
	}
	
	//business library
	/**
	 * this method will click on organization look up image
	 */
	
	public void clickOnOrganizationLookUpImg()
	{
		createOrganizationLookUpImg.click();
	}


	
	

}

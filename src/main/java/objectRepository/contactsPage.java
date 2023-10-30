package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactsPage { //rule 1
	
	//rule 2 declaration
	
	@FindAll({@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']"),@FindBy(xpath = "//img[@alt='Create Contact...']")})
	private WebElement contatctsLookUpImg;
	
	//rule 3 initialisation
	public contactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//rule 4 utilisation
	public WebElement getContatctsBtn() {
		return contatctsLookUpImg;
	}
	
	//business library
	
	/**
	 * this method will click on contacts lookup image
	 */
	
	public void clickOnContactLookUpImage()
	{
		contatctsLookUpImg.click();
	}
	
	
	

	
	

	
	

}

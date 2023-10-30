package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class organizationInformationPage { //rule 1
	
	//rule 2 decleration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement organizationHeaderTxt;
	
	//rule 3 initialization
	public organizationInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//rule 4 utilisation
	public WebElement getOrganizationTxt() {
		return organizationHeaderTxt;
	}
	
	//business library
	
	/**
	 * this method will capture the header text and return it to caller
	 * @return
	 */
	
	public String getHeaderText()
	{
		return organizationHeaderTxt.getText();
		
	}
	

}

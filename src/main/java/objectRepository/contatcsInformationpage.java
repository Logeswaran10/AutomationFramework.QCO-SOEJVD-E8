package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contatcsInformationpage { //rule 1
	
	//rule 2 decleration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactsTxt;
	
	//rule 3 intialization
	public contatcsInformationpage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//rule 4 utilization
	public WebElement getContactsTxt() {
		return contactsTxt;
	}
	
	//business library
	
	/**
	 * this method will capture the header and return it to caller
	 * @return
	 */
	
	public String getHeaderText()
	{
		return contactsTxt.getText();
	}
	

	
	
	

}

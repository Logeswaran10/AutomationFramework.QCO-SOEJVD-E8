package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage { //rule 1
	
	//rule 2 - decleration
	@FindBy(name = "user_name")
	private WebElement userNameEdt;
	
	@FindBy(name = "user_password")
	private WebElement passwordEdt;
	
	@FindAll({@FindBy(id = "submitButton"),@FindBy(xpath = "//input[@type='submit']")})
	private WebElement loginBtn;
	
	//rule 3 intialisation
	public loginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//rule 4 utilisation

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//business library - generic methods according to the need of project
	/**
	 * this method will login to the application
	 * @param USERNAME
	 * @param PASSWORD
	 */
	
	public void loginToApp(String USERNAME , String PASSWORD)
	{
		userNameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
		
		
		}
	
	

}

package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * this class consist of all generic methods related to webdriver actions
 * 
 * @author loges
 *
 */

public class WebDriverUtility {

	/**
	 * this method will maximize the window
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();

	}

	/**
	 * this method will minimize the window
	 * 
	 * @param driver
	 */

	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * this method will wait for page to load
	 * 
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	/**
	 * this method wait for particular element to be visible in DOM
	 * 
	 * @param driver
	 * @param element
	 */

	public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * this method will wait for particular element to be clickable
	 * 
	 * @param driver
	 * @param element
	 */

	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * this method is used to handle the dropdown by index
	 * 
	 * @param element
	 * @param index
	 */

	public void handleDropDown(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * this method is used to handle the dropdown by value
	 * 
	 * @param element
	 * @param Value
	 */

	public void handleDropDown(WebElement element, String Value) {
		Select sel = new Select(element);
		sel.selectByValue(Value);
	}

	/**
	 * this method is used to handle the dropdown by visible text
	 * 
	 * @param Value
	 * @param element
	 */
	public void handleDropDown(String Value, WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(Value);
	}

	/**
	 * this method will perform mouse hovering action
	 * 
	 * @param driver
	 * @param element
	 */

	public void mouseHoverAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	/**
	 * this method will move the cursor based on the offset and click on web page
	 * 
	 * @param driver
	 */
	public void moveAndClick(WebDriver driver) {
		Actions act = new Actions(driver);
		act.moveByOffset(10, 10).click().perform();
	}

	/**
	 * this method will perform right click
	 * 
	 * @param driver
	 */

	public void rightClickAction(WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick().perform();

	}

	/**
	 * this method will perform double click
	 * 
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver) {
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}

	/**
	 * this method will perform drag and drop operation
	 * 
	 * @param driver
	 * @param srcEle
	 * @param tarEle
	 */

	public void dragAndDropActions(WebDriver driver, WebElement srcEle, WebElement tarEle) {
		Actions act = new Actions(driver);
		act.dragAndDrop(srcEle, tarEle).perform();
		;
	}

	/**
	 * this method will handle frame by index
	 * 
	 * @param driver
	 * @param index
	 */

	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);

	}

	/**
	 * this method will handle frame by name or id
	 * 
	 * @param driver
	 * @param NameOrID
	 */

	public void switchToFrame(WebDriver driver, String NameOrID) {
		driver.switchTo().frame(NameOrID);
	}

	/**
	 * this method will handle frame by web elememt
	 * 
	 * @param driver
	 * @param element
	 */

	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * this method will scroll up by 500units
	 * 
	 * @param driver
	 */

	public void scrollUpAction(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-500)", "");
	}

	/**
	 * this method will scroll down by 500 units
	 * 
	 * @param driver
	 */
	public void scrollDownAction(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.srollBy(0,500)", "");
	}

	/**
	 * this method will accept the alert popup
	 * 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * this method will cancel the alert popup
	 * 
	 * @param driver
	 */

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * this method will fetch the alert text and return it to caller
	 * 
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	/**
	 * this method will take screenshot and return to dst path
	 * 
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public String captureScreenshot(WebDriver driver, String screenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE); // temporary location
		File dst = new File(".\\Screenshots\\" + screenshotName + ".png");
		// scenario1.png
		Files.copy(src, dst);

		return dst.getAbsolutePath(); // used for extent reports

	}

	/**
	 * this method will switch from one window to another based on window title
	 * 
	 * @param driver
	 * @param partialwintitle
	 */
	public void switchWindow(WebDriver driver, String partialwintitle) {
		// step 1 : all the windowIDs
		Set<String> allwinIDs = driver.getWindowHandles();

		// step -2 : navigate through each window
		for (String winIDs : allwinIDs) {
			// step 3: switch to each window and capture the title
			String actTitle = driver.switchTo().window(winIDs).getTitle();

			// step 4 : compare the act title with expected partial title
			if (actTitle.contains(partialwintitle)) {
				break;
			}

		}

	}

}

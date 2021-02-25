package suite.base;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import suite.constants.WebdriverConstants;

/**
 * Wrapper library around webdriver interface
 * 
 * @author arth.kumar
 *
 */
public class PageBase {
	private static Logger log = LoggerFactory.getLogger(PageBase.class);

	private WebDriverWait wait;
	private WebDriver driver;
	private Actions builder;
	private JavascriptExecutor js;

	public PageBase(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, WebdriverConstants.MAX_TIMEOUT);
		this.builder = new Actions(driver);
		this.js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * for handling alerts
	 */
	protected void handlingAlert() {

		Alert alert = driver.switchTo().alert();
		String alertMessage = driver.switchTo().alert().getText();
		alert.accept();

	}

	/**
	 * for clicking element by action class
	 * 
	 * @param element
	 */
	protected void clickingElementAction(WebElement element) {
		getWebElement(element);
		builder.moveToElement(element).click().build().perform();
	}

	/**
	 * Press enter button from keyboard
	 * 
	 * @param element
	 */
	public void pressEnterBtn(WebElement element) {
		getWebElement(element).sendKeys(Keys.ENTER);
	}

	/**
	 * Switch to iframe
	 * 
	 * @param element
	 *//*
		 * protected WebElement switchToIframe(String id) { // return
		 * wait.Until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(id));
		 * 
		 * }
		 */

	/**
	 * Switch to iframe
	 * 
	 * @param element
	 */
	protected void switchToIframe(String id) {
		driver.switchTo().frame(id);
	}

	/**
	 * Get webelement
	 * 
	 * @param element
	 * @param inputText
	 */
	protected void selectDropDownWithValue(WebElement element, String inputText) {
		getWebElement(element);
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(inputText);

	}

	/**
	 * switch back to page
	 */
	protected void switchToPage() {

		driver.switchTo().defaultContent();
	}

	/**
	 * Clicking element using JS
	 * 
	 * @param element WebElement variable
	 */
	protected void clickingElementJS(WebElement element) {
		getWebElement(element);
		js.executeScript("arguments[0].click();", element);
	}

	/**
	 * scroll to given webelement
	 * 
	 * @param element WebElement variable
	 */
	protected void scrollTo(WebElement element) {
		getWebElement(element);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * get the element if the element is visible in the Webpage or not
	 * 
	 * @param element WebElement variable
	 */
	protected WebElement getWebElement(WebElement element) {
		try {
			return wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
			return wait.until(ExpectedConditions.visibilityOf(element));
		} catch (NoSuchElementException e) {
			log.error("Please check the locator you've entered--> ", element.toString());
			log.error("Element not found please check the locator", e);
			Assert.fail();
		} catch (StaleElementReferenceException e) {
			return new WebDriverWait(driver, WebdriverConstants.MAX_TIMEOUT)
					.until(ExpectedConditions.visibilityOf(element));
		}
		return element;
	}

	/**
	 * Verify if all the elements are visible in the the list
	 * 
	 * @param elements List of webElements
	 */
	protected List<WebElement> getWebElements(List<WebElement> elements) {

		return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

	/**
	 * Verify that element is visible if yes return true if no return false
	 */
	protected Boolean isElementInvisible(WebElement element) {

		return wait.until(ExpectedConditions.invisibilityOf(element));

	}
	/**
	 * Load the web url in the browser
	 * 
	 * @param pageURL url of the webpage
	 */
	protected void NavigatetoPage(String pageURL) {
		driver.navigate().to(pageURL);
	}

	/**
	 * Clicking on Webelement
	 * 
	 * @param element WebElement variable
	 */
	protected void clickingElement(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		} catch (ElementNotInteractableException e) {
			clickingElementJS(element);
		}
	}

	/**
	 * Enter value in the text box
	 * 
	 * @param textBoxLabel TextBox WebElement
	 * @param inputText    text that needs to be inserted
	 */
	protected void setText(WebElement textBoxLabel, String inputText) {
		clickingElement(textBoxLabel);
		getWebElement(textBoxLabel).clear();
		getWebElement(textBoxLabel).sendKeys(inputText);
	}
	
	protected void setTextforZip(WebElement textBoxLabel) {

		getWebElement(textBoxLabel).sendKeys(Keys.ESCAPE);
	}


	/**
	 * Gets the textual value of WebElement
	 * 
	 * @param element WebElement variable
	 * @return the textual value of WebElement
	 */
	protected String getText(WebElement element) {
		return getWebElement(element).getText();
	}

	/**
	 * Get value of the attribute
	 * 
	 * @param element   WebElement variable
	 * @param attribute Attribute Value
	 * @return the value of the attribute
	 */
	protected String getAttributeValue(WebElement element, String attribute) {
		return getWebElement(element).getAttribute(attribute);
	}

	/**
	 * Hover over a the specified webelement
	 * 
	 * @param element WebElement variable
	 */
	protected void hoverOverElement(WebElement element) {
		getWebElement(element);
		builder.moveToElement(element).perform();
	}

	/**
	 * Returns false if element is disabled. Returns true if element is enabled.
	 * 
	 * @param element WebElement variable
	 */
	protected boolean isWebElementEnabled(WebElement element) {
		return getWebElement(element).isEnabled();
	}

	protected boolean isWebElementSelected(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeSelected(element));
			return true;
		} catch (TimeoutException e) {
			return false;
		}

	}

	/**
	 * Clear the text area of the Textbox.
	 * 
	 * @param textboxLabel TextBox WebElement
	 */
	protected void clearTextArea(WebElement textboxLabel) {
		getWebElement(textboxLabel).clear();
	}

	/**
	 * Returns the number of elements inside the list
	 * 
	 * @param elementList WebElement List
	 */
	protected Integer getListSizeOfElements(List<WebElement> elementList) {
		return getWebElements(elementList).size();
	}
	
	protected boolean isElementDisplayed(WebElement element) {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, 1);
	        wait.until(ExpectedConditions.visibilityOf(element));
	        return element.isDisplayed();
	    } catch (org.openqa.selenium.NoSuchElementException
	            | org.openqa.selenium.StaleElementReferenceException
	            | org.openqa.selenium.TimeoutException e) {
	        return false;
	    }
	}
	
	protected void waitForElementToBeGone(WebElement element, int timeout) {
	    if (isElementDisplayed(element)) {
	        new WebDriverWait(driver, timeout).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(element)));
	    }
	}

}
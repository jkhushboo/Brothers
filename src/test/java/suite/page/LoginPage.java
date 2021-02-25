package suite.page;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import suite.base.PageBase;

/**
 * Page Object Class for Login Page
 * 
 * @author arth
 *
 */
public class LoginPage extends PageBase {

	private WebDriver driver;

	@FindBy(id = "LoginEmail")
	private WebElement unameTxt;

	@FindBy(id = "LoginPassword")
	private WebElement passTxt;

	@FindBy(id = "loginbtn")
	private WebElement submitBtn;

	@FindBy(id = "sitecoreId")
	private WebElement crossIcon;

	@FindBy(className = "j-exp-error")
	private WebElement initialPassValidationMessage;

	@FindBy(className = "list-unstyled")
	private WebElement userValidationMessage;

	@FindBy(css = ".help-block:nth-child(1)")
	private WebElement passValidationMessage;
	
	@FindBy(css = "#main > div.site-body > section.janus-login-top.m-t-30 > div > h3")
	private WebElement welcomeMessage;
	
	@FindBy(linkText="Forgot your password?")
	private WebElement forgotPassLink;
	
	@FindBy(css = ".form-control.fieldRequired.tealiumClass")
	private WebElement emailText;
	
	@FindBy(css = "div.text-center > input")
	private WebElement continueBtn;
	
	@FindBy(css = "div.summary-error > div")
	private WebElement errorMessage;
	
	@FindBy(css = "#main > div.site-body > div > div > div > h6")
	private WebElement thankYouMessage;
	
	@FindBy(css = "div.close_button-7125-position.close_button-7125-position-d0 > button")
	private WebElement cancelBtn;
	
	

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public LoginPage getLoginPage(String pageURL) {
		NavigatetoPage(pageURL);
		try {
			clickingElement(crossIcon);
		} catch (TimeoutException e) {
			e.getMessage();
		}
		/*
		 * try { if (crossIcon.isDisplayed()) { crossIcon.click(); } } catch (Exception
		 * e) { }
		 */
		return this;
	}

	/**
	 * for entering username on login page
	 * 
	 * @param uname
	 * @return object of current class
	 */
	public LoginPage enterUname(String uname) {
		setText(unameTxt, uname);
		return this;
	}

	/**
	 * for entering password on login page
	 * 
	 * @param pass
	 * @return object of current class
	 */
	public LoginPage enterPass(String pass) {
		setText(passTxt, pass);
		return this;
	}

	/**
	 * for clicking on submit button on login page
	 * 
	 * @return object of current class
	 */
	public LoginPage clkSubmitBtn() {

		clickingElement(submitBtn);

		return this;
	}

	/**
	 * for getting username validation message on login page
	 * 
	 * @return user validation message 
	 */
	public String getUserNameValidationMessage() {
		return getText(userValidationMessage);
	}

	/**
	 * for getting password validation message on login page
	 * 
	 * @return password validation message 
	 */
	public String getPasswordValidationMessage() {
		return getText(passValidationMessage);
	}

	/**
	 * for getting initial password validation message on login page
	 * @return initial password validation message 
	 */
	public String getInitialPasswordValidationMessage() {
		return getText(initialPassValidationMessage);
	}
	

	/**
	 * for getting page Title
	 * @return
	 */
	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getWelcomeMessage() {
		return getText(welcomeMessage);
	}

	/**
	 * for getting forgot password validation message on login page
	 * 
	 * @return password validation message 
	 */
	
	public LoginPage clickOnForgotPasswordLink() {
		
		clickingElement(forgotPassLink);

		return this;
	}

	
	public LoginPage enterEmailAddress(String uname) {
		setText(emailText, uname);
		return this;

	}

	
	public LoginPage clickOnContinueBtn() {

		clickingElement(continueBtn);

		return this;
	}

	public String getErrorMessage() {
		return getText(errorMessage);
	}

	
	  public String getThankYouMessage() { return getText(thankYouMessage); }

	public LoginPage clickOnCancelBtn() {
		
		clickingElement(cancelBtn);

		return this;
	}
	 
	
}
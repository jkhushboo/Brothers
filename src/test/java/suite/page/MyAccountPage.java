package suite.page;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import suite.base.PageBase;

public class MyAccountPage extends PageBase {
	
	private WebDriver driver;

	public MyAccountPage(WebDriver driver) {
	super(driver);
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}

	public MyAccountPage getLoginPage(String pageURL) {
	NavigatetoPage(pageURL);
	return this;
	}


	@FindBy(css = ".janus-icon-listing>li:nth-child(1)>h6>a")
	private WebElement editInfoClk;


	@FindBy(id = "FirstName")
	private WebElement firstName;

	@FindBy(xpath = "//*[@id='LastName']")
	private WebElement lastName;

	@FindBy(id = "Phone")
	private WebElement phoneNum;

	@FindBy(css = ".btn.janus-btn-blue.btn-lg.text-uppercase")
	private WebElement updateProfileBtn;

	@FindBy(css = ".janus-icon-listing>li:nth-child(3)>h6>a")
	private WebElement logout;
	
	@FindBy(linkText="Address Book")
	private WebElement addressLink;
	
	@FindBy(linkText="My Orders")
	private WebElement myOrder;
	
	@FindBy(linkText="Payment Information")
	private WebElement paymentInformation;
	
	@FindBy(linkText="Registered Products")
	private WebElement registeredProduct;

	/**
	* for clicking on edit personal information link
	*
	* @return object of current class
	*/
	public MyAccountPage clickOnEditInfo() {
	clickingElement(editInfoClk);
	return this;
	}


	/**
	* for editing the first username on Update page
	*
	* @param uname
	* @return object of current class
	*/
	public MyAccountPage UpdateFname(String fName) {
	clearTextArea(firstName);
	setText(firstName, fName);
	return this;
	}


	/**
	* for editing the first lastname on Update page
	*
	* @param uname
	* @return object of current class
	*/
	public MyAccountPage UpdateLname(String lName) {
	clearTextArea(lastName);
	setText(lastName, lName);
	return this;
	}

	/**
	* for editing the first phone no. on Update page
	*
	* @param uname
	* @return object of current class
	*/
	public MyAccountPage UpdatePhone(String phone) {
	clearTextArea(phoneNum);
	setText(phoneNum, phone);
	return this;
	}


	/**
	* for clicking on update button on update page
	*
	* @return object of current class
	*/
	public MyAccountPage clickOnUpdateProfileBtn() {
	clickingElement(updateProfileBtn);
	return this;
	}


	/**
	* for clicking on logout button on logout page
	*
	* @return object of current class
	*/
	public MyAccountPage clickOnLogOut() {
	clickingElement(logout);
	return this;
	}


	/**
	* for clicking on submit button on login page
	*
	* @return object of current class
	*/

	public String getFname() {
	return getAttributeValue(firstName, "value");
	}

	/**
	* for clicking on submit button on login page
	*
	* @return object of current class
	*/

	public String getLname() {
	return getAttributeValue(lastName, "value");
	}


	/**
	* for clicking on submit button on login page
	*
	* @return object of current class
	*/

	public String getPhoneNum() {
	return getAttributeValue(phoneNum, "value");
	}
	
	/**
	* for verifying Address Book is Displayed
	*
	* @return object of current class
	*/

	public Boolean isAddressMessageDisplay() {
		return getWebElement(addressLink).isDisplayed();
		
	}
	
	/**
	* for verifying My order tab is Displayed
	*
	* @return object of current class
	*/
	
	public Boolean isMyOrderDisplay() {
		return getWebElement(myOrder).isDisplayed();
		
	}
	
	/**
	* for verifying Payment Information tab is Displayed
	*
	* @return object of current class
	*/
	
	public Boolean isPaymentInformationDisplay() {
		return getWebElement(paymentInformation).isDisplayed();
		
	}
	
	/**
	* for verifying Registered Product tab is Displayed
	*
	* @return object of current class
	*/
	
	public Boolean isRegisteredProductDisplay() {
		return getWebElement(registeredProduct).isDisplayed();
		
	}
	
	}



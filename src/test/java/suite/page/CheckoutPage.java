package suite.page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import suite.base.PageBase;

public class CheckoutPage extends PageBase {

	private WebDriver driver;
	

	@FindBy(id = "sitecoreId")
	private WebElement crossIcon;

	@FindBy(css = ".close > a")
	private WebElement cookiesCrossIcon;

	@FindBy(css = ".btn-lg:nth-child(8)")
	private WebElement AddToCartBtn;

	@FindBy(css = ".checkout-button")
	private WebElement proceedToCartBtn;
	
	@FindBy(css = ".atc-modal-btn-checkout")
	private WebElement proceedToCartBtn1;

	@FindBy(css = ".janus-shopp-c-item-info > h4")
	private WebElement productName;

	@FindBy(id = "checkoutBtn") //.btn-lg
	private WebElement checkoutBtn;

	@FindBy(css = ".m-r-20")
	private WebElement guestCheckoutBtn;

	@FindBy(id = "ShipAllItemsInput-FName")
	private WebElement guestFnameTxt;

	@FindBy(id = "ShipAllItemsInput-LName")
	private WebElement guestLnameTxt;

	@FindBy(id = "ShipAllItemsInput-Email")
	private WebElement guestEmailTxt;

	@FindBy(id = "ShipAllItemsInput-Phone")
	private WebElement guestPhoneNoTxt;

	@FindBy(id = "form2Address1")
	private WebElement guestAddressTxt;

	@FindBy(id = "form2Address2")
	private WebElement guestAddressTxt2;

	@FindBy(css = ".col-md-12:nth-child(2) .janus-checkboxs > label")
	private WebElement poBoxBtn;

	@FindBy(id = "form2City")
	private WebElement guestCityTxt;

	@FindBy(id = "form2States")
	private WebElement guestStateSdd;

	@FindBy(id = "form2ZipCode")
	private WebElement guestZipTxt;

	@FindBy(css = "#standard-shipping > div > div.janus-standard-shipping-listing > div > div:nth-child(3) > div > label")
	private WebElement groundShipping;

	@FindBy(id = "orderGetShippingMethods")
	private WebElement guestInfoNextBtn;

	@FindBy(css = "button#orderGetShippingMethods")
	private WebElement guestInfoNextBtnDpc;

	@FindBy(css = "#ToBillingButton")
	private WebElement guestShippingNextBtn;

	@FindBy(css = ".janus-shipping-method-block:nth-child(2) > .shipping-option > .radio-label")
	private WebElement secondDayAirShipBtn;

	@FindBy(css = ".janus-standard-shipping-listing > .janus-shipping-method-block:nth-child(2) .radio-label")
	private WebElement guestPaypalCrBtn;

	@FindBy(css = ".janus-standard-shipping-listing > .janus-shipping-method-block:nth-child(3) .radio-label")
	private WebElement guestPaypalCrRegBtn;

	@FindBy(css = ".to-confirm-button")
	private WebElement guestConfirmBtn;

	@FindBy(id = "PlaceOrderButton")
	private WebElement guestPlaceOrderBtn;

	@FindBy(css = "#email")
	private WebElement PpUserNameTxt;

	@FindBy(id = "btnNext")
	private WebElement ppUnNextBtn;

	@FindBy(css = "#password")
	private WebElement ppPassTxt;

	@FindBy(id = "acceptAllButton")
	private WebElement cookiesAcceptPpCrBtn;

	@FindBy(id = "btnLogin")
	private WebElement ppLoginBtn;

	@FindBy(css = ".fundingsource:nth-child(3) .noBottom")
	private WebElement ppcAmericanBtn;

	@FindBy(id = "payment-submit-btn")
	private WebElement ppContinueBtn;

	@FindBy(css = "#acceptAllButton")
	private WebElement acceptCookies;
	
	@FindBy(css = ".PayLater_headerContainer_3RSAC .src_heading_1SHop")
	private WebElement payLater;

	@FindAll({ @FindBy(id = "confirmButtonTop"), @FindBy(id = "payment-submit-btn") })
	private WebElement ppcContinueBtn;

	@FindBy(id = "cciFrame")
	private WebElement switchtoIframe;

	@FindBy(id = "ChatPaymetric_NameOnCard")
	private WebElement nameOnCardCcTxt;

	@FindBy(id = "Paymetric_CreditCardType")
	private WebElement PaymentCtypeSdd;

	@FindBy(id = "Paymetric_CreditCardNumber")
	private WebElement cardNoCcTxt;

	@FindBy(id = "Paymetric_Exp_Month")
	private WebElement expiryMmCcTxt;

	@FindBy(id = "Paymetric_Exp_Year")
	private WebElement expiryYyCcTxt;

	@FindBy(css = "#Paymetric_CVV")
	private WebElement cvvCcTxt;

	@FindBy(id = "registerTab")
	private WebElement newUserTab;

	@FindBy(id = "Email")
	private WebElement checkoutEmailTxt;

	@FindBy(id = "txtNewPassowrd")
	private WebElement checkoutNewPassTxt;

	@FindBy(id = "ConfirmPassword")
	private WebElement checkoutConfirmPassTxt;

	@FindBy(id = "FirstName")
	private WebElement checkoutFnameTxt;

	@FindBy(id = "LastName")
	private WebElement checkoutLnameTxt;

	/*
	 * @FindBy(linkText = "Products for Business") private WebElement
	 * productForBusinessBtn;
	 */
	
	//*[@id="CreateAccount"]/div[2]/input
	@FindBy(css = ".btn.janus-btn-blue.janus-sign-up-btn.text-uppercase")
	private WebElement productForBusinessBtn;

	@FindBy(css = ".janus-sign-up-btn")
	private WebElement createAccountBtn;

	@FindBy(css = ".janus-standard-shipping-listing > .janus-shipping-method-block:nth-child(1) .radio-label")
	private WebElement guestPaypalBtn;

	@FindBy(css = ".janus-standard-shipping-listing > .janus-shipping-method-block:nth-child(2) .radio-label")
	private WebElement guestPaypalRegBtn;

	@FindBy(css = ".janus-standard-shipping-listing:nth-child(1) > div:nth-child(1) .radio-label")
	private WebElement usePrimaryPaymentBtn;

	@FindBy(css = ".address-wrapper:nth-child(4) .radio-label")
	private WebElement useAlternateAddressBtn;

	@FindBy(id = "LoginEmail")
	private WebElement checkoutUnameTxt;

	@FindBy(id = "LoginPassword")
	private WebElement checkoutPassTxt;

	@FindBy(css = ".m-t-10 > label")
	private WebElement taxExemptBtn;

	@FindBy(id = "")
	private WebElement paymentLoader;

	@FindBy(id = "loginbtn")
	private WebElement submitBtn;

	@FindBy(css = "div[class='component-content'] h1")
	private WebElement paymentConfirmMess;

	@FindBy(id = "ShipAllItemsInput-FName")
	private WebElement dpcFnameTxt;

	@FindBy(id = "ShipAllItemsInput-LName")
	private WebElement dpcLnameTxt;

	@FindBy(id = "ShipAllItemsInput-Email")
	private WebElement dpcEmailTxt;

	@FindBy(id = "ShipAllItemsInput-Phone")
	private WebElement dpcPhoneNoTxt;

	@FindBy(css = ".address-street-textbox")
	private WebElement dpcAddressTxt;

	@FindBy(css = ".address-city-textbox")
	private WebElement dpcCityTxt;

	@FindBy(css = ".address-state-dropdown")
	private WebElement DpcStateSdd;

	@FindBy(css = ".shipall-addresses > .janus-shipping-method-block .radio-label")
	private WebElement useNewAddressBtn;

	@FindBy(id = "billingAddress-Zipcode")
	private WebElement dpcZipTxt;

	@FindBy(css = ".janus-shipping-method-block:nth-child(3) > .shipping-option > .radio-label")
	private WebElement nextDayAirShipBtn;

	@FindBy(css = "div.container>h3>strong#sapOrderId")
	private WebElement orderId;
	
	@FindBy(id = "emailSubTagLine")
	private WebElement 	text;
	
	@FindBy(css = "div.mini-cart-product-description > a > h5")
	private WebElement pdpProductName;
	
	@FindBy(css = "div.spinner-border.text-primary.janus-loader-sect.brother-second-step-icon")
	private WebElement iLoader;
	
	@FindBy(xpath = "//span[@class=\"shipping-address-filled\"]")
	private WebElement zipCodeValidation;
	
	

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * for navigating to pdp page url
	 * 
	 * @param pageURL
	 * @return
	 */
	public CheckoutPage getPdpCheckoutPage(String pageURL) {
		NavigatetoPage(pageURL);
		try {
			clickingElement(crossIcon);
		} catch (TimeoutException e) {
			e.getMessage();
		}
		try {
			clickingElement(cookiesCrossIcon);
		} catch (TimeoutException e) {
			e.getMessage();
		}
		return this;
	}

	/**
	 * for clicking on add to cart button on pdp
	 * 
	 * @return object of the current class
	 */
	public CheckoutPage clkAddtoCartBtn() {

		clickingElement(AddToCartBtn);

		return this;
	}

	/**
	 * For clicking on Proceed To Cart button in Mini cart.
	 * 
	 * @return object of the current class
	 */
	public CheckoutPage clkProceedToCartBtn() {
		try {
			clickingElementJS(proceedToCartBtn);
		} catch (Exception e) {
			clickingElementJS(proceedToCartBtn1);
		}

		
		return this;
	}

	/**
	 * for clicking on checkout button on shopping cart button
	 * 
	 * @return object of the current class
	 */
	public CheckoutPage clkCheckoutBtn() {
		//getWebElement(productName);
		clickingElement(checkoutBtn);
		return this;

	}

	/**
	 * for clicking on checkout as a guest on login page
	 * 
	 * @return object of the current class
	 */
	public CheckoutPage clkCheckoutGuestBtn() {
		clickingElement(guestCheckoutBtn);
		try {
			clickingElement(cookiesCrossIcon);
		} catch (TimeoutException e) {
			e.getMessage();
		}
		return this;

	}

	/**
	 * for entering first name in checkout as a guest
	 * 
	 * @param fName
	 * @return object of the current class
	 */
	public CheckoutPage enterGuestFname(String fName) {
		setText(guestFnameTxt, fName);
		return this;
	}

	/**
	 * for entering last name in checkout
	 * 
	 * @param inputText
	 * @return object of the current class
	 */
	public CheckoutPage enterGuestLname(String inputText) {
		setText(guestLnameTxt, inputText);
		return this;
	}

	/**
	 * for entering email email in checkout
	 * 
	 * @param inputText
	 * @return object of the current class
	 */
	public CheckoutPage enterGuestEmail(String inputText) {
		setText(guestEmailTxt, inputText);
		return this;
	}

	/**
	 * for entering phone number in checkout
	 * 
	 * @param inputText
	 * @return object of the current class
	 */
	public CheckoutPage enterGuestPhoneNo(String inputText) {

		try {
			setText(guestPhoneNoTxt, inputText);
		} catch (TimeoutException e) {
			setText(guestPhoneNoTxt, inputText);
			e.printStackTrace();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}

	/**
	 * for entering phone address in checkout as a guest
	 * 
	 * @param inputText
	 * @return object of the current class
	 */
	public CheckoutPage enterGuestAddress(String inputText) {
		setText(guestAddressTxt, inputText);
		
		return this;
	}

	/**
	 * for entering address line 2 in checkout as a guest
	 * 
	 * @param inputText
	 * @return object of the current class
	 */
	public CheckoutPage enterGuestAddress2(String inputText) {
		setText(guestAddressTxt2, inputText);
		return this;
	}

	/**
	 * for clicking on po box check box
	 * 
	 * @return
	 */
	public CheckoutPage clkPoBoxBtn() {

		clickingElement(poBoxBtn);

		return this;
	}

	/**
	 * for entering city in checkout
	 * 
	 * @param inputText
	 * @return object of the current class
	 */
	public CheckoutPage enterGuestCity(String inputText) {
		setText(guestCityTxt, inputText);
		
		return this;
	}

	/**
	 * for selecting state from drop down in checkout
	 * 
	 * @param inputText
	 * @return object of current class
	 */
	public CheckoutPage selectGuestState(String inputText) {
		
		Select dropdown = new Select(guestStateSdd);
		dropdown.selectByVisibleText(inputText);
		
		return this;
	}

	/**
	 * for entering phone number zip in checkout
	 * 
	 * @param inputText
	 * @return object of the current class
	 */
	public CheckoutPage enterGuestZip(String inputText) {
		setText(guestZipTxt, inputText);
		setTextforZip(guestZipTxt);
		
		  try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 
		
		return this;
	}

	/**
	 * for scrolling to info next button
	 * 
	 * @return object of current class
	 */
	public CheckoutPage scrolltoInfoNextBtn() {
		scrollTo(guestInfoNextBtn);
		return this;
	}

	/**
	 * for clicking on next btn of info in checkout
	 *
	 * @return object of the current class
	 */
	public CheckoutPage clkInfoNextBtn() {
		/* clickingElementAction(guestInfoNextBtn); */
		 clickingElement(guestInfoNextBtn); 
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;

	}

	/**
	 * for clicking on next btn of info two times in checkout for dpc
	 *
	 * @return object of the current class
	 */
	public CheckoutPage clkInfoNextBtnDpc() {
		for (int i = 0; i < 2; i++) {
			clickingElement(guestInfoNextBtnDpc);
			try {
				if (guestPaypalBtn.isDisplayed())
					return this;
			} catch (NoSuchElementException e) {
				clickingElement(guestInfoNextBtnDpc);
				break;
			}
		}
		return this;
	}

	/**
	 * for clicking on next btn of info in checkout for dpc
	 * 
	 * @return object of the current class
	 */
	public CheckoutPage clkInfoNextBtnOneDpc() {

		clickingElement(guestInfoNextBtnDpc);
		return this;
	}

	/**
	 * for clicking on next btn of shipping in checkout
	 * 
	 * @return object of the current class
	 * @throws InterruptedException 
	 */
	public CheckoutPage clkShippingNextBtn() {
		//waitForElementToBeGone(iLoader, 1);
		getWebElement(groundShipping);
		getWebElement(guestShippingNextBtn);
		clickingElement(guestShippingNextBtn);
		return this;
	}

	/**
	 * for clicking on next btn of shipping in checkout
	 * 
	 * @return object of the current class
	 */
	public CheckoutPage clkSecondDayAirShip() {
		getWebElement(groundShipping);
		clickingElement(secondDayAirShipBtn);
		return this;

	}

	/**
	 * for clicking on paypal credit in checkout
	 * 
	 * @return object of the current class
	 */
	public CheckoutPage selectPaypalCr() {
		clickingElement(guestPaypalCrBtn);
		return this;

	}

	/**
	 * for clicking on paypal credit in checkout for registered
	 * 
	 * @return object of the current class
	 */
	public CheckoutPage selectPaypalCrReg() {
		clickingElement(guestPaypalCrRegBtn);
		return this;

	}

	/**
	 * for clicking on confirm button of shipping in checkout
	 * 
	 * @return object of the current class
	 */
	public CheckoutPage clkConfirmBtn() {
		clickingElement(guestConfirmBtn);
		return this;

	}

	/**
	 * for clicking on Place Order btn of shipping in checkout
	 * 
	 * @return object of the current class
	 */
	public CheckoutPage clkPlaceOrderBtn() {

		try {
			clickingElement(guestPlaceOrderBtn);
		} catch (TimeoutException e) {
			clickingElement(guestPlaceOrderBtn);
			e.printStackTrace();
		}
		return this;

	}

	/**
	 * for entering user name in paypal page
	 * 
	 * @param inputText
	 * @return object of the current class
	 */
	public CheckoutPage enterPpUserName(String inputText) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getText(text);
		setText(PpUserNameTxt, inputText);
		return this;
	}

	/**
	 * for clicking on next button after entering user name
	 * 
	 * @return
	 */

	public CheckoutPage clkppUnNextBtn() {
		clickingElement(ppUnNextBtn);
		return this;

	}

	/**
	 * for entering password on paypal page
	 * 
	 * @param inputText
	 * @return object of the current class
	 */
	public CheckoutPage enterPpPass(String inputText) {
		setText(ppPassTxt, inputText);
		return this;
	}

	/**
	 * for clicking on accept cookies in paypal
	 * 
	 * @return
	 */
	public CheckoutPage clkCookiesAcceptPpCr() {
		clickingElement(cookiesAcceptPpCrBtn);
		return this;

	}

	/**
	 * for clicking on login button on paypal page
	 * 
	 * @return object of the current class
	 */
	public CheckoutPage clkPpLoginBtn() {
		clickingElement(ppLoginBtn);
		return this;

	}

	/**
	 * for clicking on american card button in paypal page
	 * 
	 * @return
	 */
	public CheckoutPage clkAmericanCBtn() {
		getWebElement(ppcAmericanBtn);
		clickingElement(ppcAmericanBtn);
		return this;

	}

	/**
	 * for clicking on continue button on paypal credit page
	 * 
	 * @return object of the current class
	 */
	public CheckoutPage clkppcContinue() {
		getWebElement(ppcContinueBtn);
		scrollTo(ppcContinueBtn);
		clickingElement(ppcContinueBtn);
		return this;

	}

	/**
	 * for clicking on continue button on paypal page
	 * 
	 * @return object of the current class
	 */
	public CheckoutPage clkppContinue() {
		//clickingElement(acceptCookies);
		getWebElement(payLater);
		scrollTo(ppContinueBtn);
		clickingElement(ppContinueBtn);
		return this;

	}

	/**
	 * for switching to iframe in checkout page
	 * 
	 * @param id
	 * @return object of current class
	 */
	public CheckoutPage switchToPaymentIframe(String id) {
		
		try {
			getWebElement(switchtoIframe);
			switchToIframe(id);
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}

	/**
	 * for entering credit card username
	 * 
	 * @param inputText
	 * @return object of current class
	 */
	public CheckoutPage enterNameOnCardCc(String inputText) {

		try {

			getWebElement(cvvCcTxt);
			getWebElement(PaymentCtypeSdd);
			getWebElement(nameOnCardCcTxt);
			setText(nameOnCardCcTxt, inputText);
		} catch (StaleElementReferenceException e) {
			getWebElement(nameOnCardCcTxt);
			setText(nameOnCardCcTxt, inputText);
			e.printStackTrace();
		}
		return this;
	}

	/**
	 * for selecting credit card type
	 * 
	 * @param inputText
	 * @return object of current class
	 */
	public CheckoutPage selectCardType(String inputText) {
		getWebElement(cardNoCcTxt);
		try {
			selectDropDownWithValue(PaymentCtypeSdd, inputText);
		} catch (NoSuchElementException e) {
			selectDropDownWithValue(PaymentCtypeSdd, inputText);
			e.printStackTrace();
		}
		return this;
	}

	/**
	 * for entering card no.
	 * 
	 * @param inputText
	 * @return object of current class
	 */
	public CheckoutPage enterCardNoCc(String inputText) {
		getWebElement(expiryMmCcTxt);
		setText(cardNoCcTxt, inputText);
		return this;
	}

	/**
	 * for entering expiry month
	 * 
	 * @param inputText
	 * @return object of current class
	 */
	public CheckoutPage enterExpiryMmCc(String inputText) {
		getWebElement(expiryYyCcTxt);
		setText(expiryMmCcTxt, inputText);
		return this;
	}

	/**
	 * for entering expiry year
	 * 
	 * @param inputText
	 * @return object of current class
	 */
	public CheckoutPage enterExpiryYyCc(String inputText) {
		getWebElement(cvvCcTxt);
		setText(expiryYyCcTxt, inputText);
		return this;
	}

	/**
	 * for entering cvv
	 * 
	 * @param inputText
	 * @return object of current class
	 */
	public CheckoutPage enterCvvCc(String inputText) {
		setText(cvvCcTxt, inputText);
		return this;
	}

	/**
	 * for switching from iframe to checkout page
	 * 
	 * @return object of current class
	 */
	public CheckoutPage switchToPaymentPage() {
		switchToPage();
		return this;
	}

	/**
	 * click on create new account tab
	 * 
	 * @return object of current class
	 */
	public CheckoutPage clkCreateNewUserTab() {
		clickingElement(newUserTab);
		return this;
	}

	/**
	 * for entering new user email on create new account form
	 * 
	 * @param inputText
	 * @return object of current class
	 */
	public CheckoutPage enterCheckoutEmail(String inputText) {
		setText(checkoutEmailTxt, inputText);
		return this;
	}

	/**
	 * for entering new user password create new account form
	 * 
	 * @param inputText
	 * @return object of current class
	 */
	public CheckoutPage enterCheckoutPass(String inputText) {
		setText(checkoutNewPassTxt, inputText);
		return this;
	}

	/**
	 * for entering registration confirm password create new account form
	 * 
	 * @param inputText
	 * @return object of current class
	 */
	public CheckoutPage enterCheckoutConfirmPass(String inputText) {
		setText(checkoutConfirmPassTxt, inputText);
		return this;
	}

	/**
	 * for entering registration first name on create new account form
	 * 
	 * @param inputText
	 * @return object of current class
	 */
	public CheckoutPage enterCheckoutFname(String inputText) {
		setText(checkoutFnameTxt, inputText);
		return this;
	}

	/**
	 * for entering registration last name on create new account form
	 * 
	 * @param inputText
	 * @return object of current class
	 */
	public CheckoutPage enterCheckoutLname(String inputText) {
		setText(checkoutLnameTxt, inputText);
		return this;
	}

	/**
	 * scroll to product for business button
	 * 
	 * @return object of current class
	 */
	public CheckoutPage scrollToCreateAccountBtn() {
		scrollTo(productForBusinessBtn);
		return this;
	}

	/**
	 * for clicking on create account button on create new account forom
	 * 
	 * @return object of current class
	 */
	public CheckoutPage clkCreateAccountBtn() {
		clickingElement(createAccountBtn);
		clickingElement(cookiesCrossIcon);
		return this;
	}

	/**
	 * for getting payment confirm message
	 * 
	 * @return payment confirm message
	 */
	public String paymentConfirmMessage() {
		getWebElement(paymentConfirmMess);
		return getText(paymentConfirmMess);
	}

	/**
	 * for selecting paypal in payment checkout as guest
	 * 
	 * @return object of the current class
	 */
	public CheckoutPage selectPaypal() {
		clickingElement(guestPaypalBtn);
		return this;

	}

	/**
	 * for selecting paypal in payment checkout as Registered
	 * 
	 * @return object of the current class
	 */
	public CheckoutPage selectPaypalReg() {
		clickingElement(guestPaypalRegBtn);
		return this;

	}

	/**
	 * for entering username on checkout login page
	 * 
	 * @param uname
	 * @return object of current class
	 */
	public CheckoutPage enterUname(String uname) {
		setText(checkoutUnameTxt, uname);
		return this;
	}

	/**
	 * for entering password on checkout login page
	 * 
	 * @param pass
	 * @return object of current class
	 */
	public CheckoutPage enterPass(String pass) {
		setText(checkoutPassTxt, pass);
		return this;
	}

	/**
	 * for clicking on submit button on checkout login page
	 * 
	 * @return object of current class
	 */
	public CheckoutPage clkSubmitBtn() {

		clickingElement(submitBtn);

		return this;
	}

	/**
	 * for navigating to pdp page url for had and dpc
	 * 
	 * @param pageURL
	 * @return
	 */
	public CheckoutPage getPdpCheckoutPageProd(String pageURL) {
		NavigatetoPage(pageURL);
		try {
			clickingElement(cookiesCrossIcon);
		} catch (TimeoutException e) {
			e.getMessage();
		}
		return this;
	}

	/**
	 * for clicking on cookies cross icon
	 * 
	 * @return object of the current class
	 */
	public CheckoutPage clkCookiesCrossBtn() {
		try {
			clickingElement(cookiesCrossIcon);
		} catch (TimeoutException e) {
			e.getMessage();
		}
		return this;

	}

	/**
	 * for clicking on add to cart button on pdp bmg product
	 * 
	 * @return
	 */
	public CheckoutPage clkAddtoCartBmgProdBtn() {

		clickingElement(AddToCartBtn);

		return this;
	}

	/**
	 * for clicking on add to cart button on pdp had Product
	 * 
	 * @return
	 */
	public CheckoutPage clkAddtoCartHadProdBtn() {

		clickingElement(AddToCartBtn);

		return this;
	}

	/**
	 * for clicking on add to cart button on pdp of Dpc product
	 * 
	 * @return
	 */
	public CheckoutPage clkAddtoCartDpcProdBtn() {

		clickingElement(AddToCartBtn);

		return this;
	}

	/**
	 * for clicking on tax exempt
	 * 
	 * @return
	 */
	public CheckoutPage clkTaxExempt() {

		clickingElement(taxExemptBtn);

		return this;
	}

	/**
	 * for checking if the payment loader is invisible
	 * 
	 * @return
	 */
	public CheckoutPage isPaymentLoaderInvisible() {
		isElementInvisible(paymentLoader);
		return this;
	}

	/**
	 * for entering first name in dpc checkout as a guest
	 * 
	 * @param fName
	 * @return object of the current class
	 */
	public CheckoutPage enterDpcFname(String fName) {
		setText(dpcFnameTxt, fName);
		return this;
	}

	/**
	 * for entering last name in dpc checkout
	 * 
	 * @param inputText
	 * @return object of the current class
	 */
	public CheckoutPage enterDpcLname(String inputText) {
		setText(dpcLnameTxt, inputText);
		return this;
	}

	/**
	 * for entering email in dpc checkout
	 * 
	 * @param inputText
	 * @return object of the current class
	 */
	public CheckoutPage enterDpcEmail(String inputText) {
		setText(dpcEmailTxt, inputText);
		return this;
	}

	/**
	 * for entering phone number in dpc checkout
	 * 
	 * @param inputText
	 * @return object of the current class
	 */
	public CheckoutPage enterDpcPhoneNo(String inputText) {
		setText(dpcPhoneNoTxt, inputText);
		return this;
	}

	/**
	 * for entering dpc address
	 * 
	 * @param inputText
	 * @return
	 */
	public CheckoutPage enterDpcAddress(String inputText) {
		setText(dpcAddressTxt, inputText);
		return this;
	}

	/**
	 * for entering dpc city
	 * 
	 * @param inputText
	 * @return
	 */
	public CheckoutPage enterDpcCity(String inputText) {
		setText(dpcCityTxt, inputText);
		return this;
	}

	/**
	 * for selecting dpc state
	 * 
	 * @param inputText
	 * @return
	 */
	public CheckoutPage selectDpcState(String inputText) {
		Select dropdown = new Select(DpcStateSdd);
		dropdown.selectByVisibleText(inputText);
		return this;
	}

	/**
	 * for entering dpc zip
	 * 
	 * @param inputText
	 * @return
	 */
	public CheckoutPage enterDpcZip(String inputText) {
		setText(dpcZipTxt, inputText);
		return this;
	}

	/**
	 * for clicking on Primary payment
	 * 
	 * @return
	 */
	public CheckoutPage clkPrimaryPayment() {
		getWebElement(usePrimaryPaymentBtn);
		clickingElement(usePrimaryPaymentBtn);

		return this;
	}

	/**
	 * for clicking on Alternate address
	 * 
	 * @return
	 */
	public CheckoutPage clkAlternateAddress() {
		clickingElement(useAlternateAddressBtn);

		return this;
	}

	/**
	 * for clicking on new address
	 * 
	 * @return
	 */
	public CheckoutPage clkNewAddressBtn() {
		clickingElement(useNewAddressBtn);

		return this;
	}

	public CheckoutPage getLoginPage(String loginPageUrl) {
		NavigatetoPage(loginPageUrl);
		try {
			clickingElement(crossIcon);
		} catch (TimeoutException e) {
			e.getMessage();
		}
		try {
			clickingElement(cookiesCrossIcon);
		} catch (TimeoutException e) {
			e.getMessage();
		}
		return this;
	}

	public CheckoutPage clkNextDayAirShip() {
		getWebElement(groundShipping);
		clickingElement(nextDayAirShipBtn);
		return this;
	}

	public String getOrderId() {
		return getText(orderId);

	}

	public String getProductNameAddToMiniCart() {
		return getText(pdpProductName);
	}

	public CheckoutPage enterAddressLine2(String inputText) {
		setText(guestAddressTxt2, inputText);
		return this;
	}
}

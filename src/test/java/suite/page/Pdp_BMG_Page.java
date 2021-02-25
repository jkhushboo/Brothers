package suite.page;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import suite.base.PageBase;

public class Pdp_BMG_Page extends PageBase {

	public Pdp_BMG_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private WebDriver driver;

	@FindBy(css = ".btn.janus-where-to-buy-btn.btn-md.m-b-15 > div span")
	private List<WebElement> whereToASBuyBtn;

	@FindBy(css = ".component.cxa-product-kit-component > h2")
	private WebElement supplySection;

	@FindBy(css = "#sitecoreId")
	private WebElement crossIcon;

	@FindBy(css = ".close > a")
	private WebElement cookiesCrossIcon;

	@FindBy(css = ".btn-lg:nth-child(8)")
	private WebElement AddToCartBtn;

	@FindBy(css = "div.mini-cart-product-description > a > h5")
	private WebElement pdpProductName;

	@FindBy(linkText = "PriceSpider Terms of Service")
	private WebElement whereToBuyPopUpBottom;

	@FindBy(css = "a.btn-lg > div.ps-enabled.ps-widget")
	private WebElement whereToBuyBtn;

	/*
	 * @FindBy(css = ".active > .janus-scroll-trigger") private WebElement
	 * aboutThePageSection;
	 */

	@FindBy(xpath = "//a[@href='#about-product']")
	private WebElement aboutThePageSection;

	@FindBy(css = "h2.m-b-30")
	private WebElement aboutTheProdText;

	@FindBy(css = "li:nth-child(5) > .janus-scroll-trigger")
	private WebElement prodReviewBtn;

	@FindBy(css = "li:nth-child(2) > .janus-scroll-trigger")
	private WebElement prodSpecification;

	@FindBy(css = "li:nth-child(2) > .janus-scroll-trigger")
	private WebElement prodSpecificationTxt;

	@FindBy(css = "#accordion > .panel:nth-child(1) a")
	private WebElement basicFeatureDropDown;

	@FindBy(css = "#bv-text-field-search-contentSearch1")
	private WebElement prodReviewSearchBox;

	@FindBy(css = ".bv-search-control-icon:nth-child(1)")
	private WebElement reviewSearchbtn;

	@FindBy(css = ".bv-content-search-results")
	private WebElement productReviewPopUp;

	@FindBy(css = "#supportIcon .img-responsive")
	private WebElement contactUsBtn;

	@FindBy(css = ".modal-body .janus-btn-blue")
	private WebElement emailSupportBtn;

	@FindBy(css = "#rn_PageTitle > h1")
	private WebElement emailSupportPageTitle;

	@FindBy(css = ".support-link > a")
	private WebElement supportTab;

	@FindBy(css = ".janus-s-p-titles > a")
	private WebElement supportPageTitleTxt;

	@FindBy(css = "li:nth-child(3) > .janus-scroll-trigger")
	private WebElement suppliesAccessoriesBtn;

	@FindBy(css = ".janus-pdp-supplies-card:nth-child(1) h2")
	private WebElement firstDisplayedAccName;

	@FindBy(css = ".ps-product-details-title")
	private WebElement locateDealerPageTitle;

	@FindBy(css = ".janus-pdp-supplies-card:nth-child(1) form")
	private WebElement addToCartASBtn;

	@FindBy(xpath = "//*[@id=\"janus-minicart2\"]/div/div[2]/div/div[3]/div[3]/div/div[3]/div[1]/div/div[2]/a/h5")
	private WebElement selectedProdNameMiniCart;

	@FindBy(css = ".btn-lg:nth-child(8)")
	private WebElement addToCartInStockBtn;

	@FindBy(linkText = "Compact Laser All-in-One")
	private WebElement productNameInMiniCart;

	@FindBy(css = ".checkout-button")
	private WebElement clkProceedToCartBtn;

	@FindBy(css = ".janus-pdp-supplies-card:nth-child(1) .add-to-cart-btn")
	private WebElement clkAccessory1Btn;

	@FindBy(css = ".janus-pdp-supplies-card:nth-child(2) .add-to-cart-btn")
	private WebElement clkAccessory2Btn;

	@FindBy(css = ".hidden-sm-:nth-child(1)")
	private WebElement clkContinueToShopBtn;

	@FindBy(css = ".form-control")
	private WebElement applyPromoCodeTxtBox;

	@FindBy(css = ".janus-apply-btn")
	private WebElement clkApplyBtn;

	@FindBy(css = ".janus-cart-count")
	private WebElement noOfProductsAddedToMiniCart;

	@FindBy(css = "b > span")
	private WebElement productCostAfterSavings;

	@FindBy(css = ".janus-cart-count")
	private WebElement clkMiniCart;

	@FindBy(css = ".m-r-10")
	private WebElement ShoppingCartPageContinueToShopBtn;

	@FindBy(css = ".j-instant-reb-text")
	private WebElement instantRebateTxt;

	@FindBy(css = "#wc-features-3b68dc2a > h2")
	private WebElement aPlusWebContent;
	
	@FindBy(css = "#divAccessoriesKit > h2")
	private WebElement selectAcce;
	

	public Pdp_BMG_Page getPdpPage(String pageURL) {
		
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
		/*
		 * NavigatetoPage(pageURL); clickingElement(crossIcon);
		 * clickingElement(acceptCookiesBtn);
		 * 
		 * return this;
		 */


	public String getProductNameAddToMiniCart() {
		return getText(pdpProductName);
	}

	/**
	 * For clicking on add to cart button on pdp
	 * 
	 * @return object of current class
	 */

	public Pdp_BMG_Page clkAddtoCartBtn() {
		clickingElementAction(AddToCartBtn);
		return this;
	}

	/**
	 * For clicking the where to buy button of the pdp page.
	 * 
	 * @return the object of the current class.
	 */

	public Pdp_BMG_Page clkwhereToBuyBtn() {
		for (int i = 0; i < 2; i++) {
			clickingElementJS(whereToBuyBtn);
			try {
				if (getWebElement(whereToBuyPopUpBottom).isDisplayed())
					return this;
			} catch (TimeoutException | NoSuchElementException e) {

				clickingElementJS(whereToBuyBtn);
				break;
			}
		}
		return this;
	}

	/**
	 * for getting price spider logo from where to buy pop up
	 * 
	 * @return product name from where to buy pop up
	 */
	public String getWhereToBuyPopUp() {
		return getText(whereToBuyPopUpBottom);
	}

	/**
	 * For clicking the product specification specfication tab
	 * 
	 * @return the object of the current class.
	 */

	public Pdp_BMG_Page clkAboutProductSpecification() {
		clickingElement(prodSpecification);
		return this;

	}

	/**
	 * For clicking the about product section of the pdp page
	 * 
	 * @return the object of the current class.
	 * @throws InterruptedException
	 */

	public Pdp_BMG_Page clkAboutProductSection() {

		clickingElementJS(aboutThePageSection);
		return this;
	}

	/**
	 * For getting the about the product section text
	 * 
	 * @return text displayed inside about the section
	 */

	public String getAboutTheProdTxt() {
		return getText(aboutTheProdText);

	}

	/**
	 * For getting attribute value of the basic feature section under about the
	 * product tab.
	 * 
	 * @return the attribute of the basic feature dropdown.
	 */

	public String isBasicFeatureDisplayed() {
		return getAttributeValue(basicFeatureDropDown, "aria-expanded");
	}

	/**
	 * For clicking on the Supplies and Accessories tab.
	 * 
	 * @return the object of the current class.
	 */

	public Pdp_BMG_Page clkSuppliesAccessoriesTab() {
		
		clickingElement(suppliesAccessoriesBtn);
		
		return this;
	}

	/**
	 * For getting the first displayed accessory name under the supplies and
	 * accessories tab.
	 * 
	 * @return the object of the current class.
	 */

	public String getFirstDisplayedAccName() {
		return getText(firstDisplayedAccName);
	}

	/**
	 * For getting support page title text.
	 * 
	 * @return the text displayed under support page
	 */

	public Pdp_BMG_Page clkAddToCartASBtn() {
		scrollTo(supplySection);
		clickingElement(addToCartASBtn);
		return this;
	}

	/**
	 * For getting selected product name.
	 * 
	 * @return the text of the selected product.
	 */

	public String getSelectedProductName() {
		return getText(selectedProdNameMiniCart);
	}
	
	/**
	 * For getting product specification text under product specification section
	 * 
	 * @return text displayed under product specification section.
	 */

	public String getProdSpecificationTxt() {
		getWebElement(prodSpecificationTxt);
		return getText(prodSpecificationTxt);
	}

	/**
	 * For clicking the product review button of the pdp page
	 * 
	 * @return the object of the current class.
	 */

	public Pdp_BMG_Page clkProdReviewBtn() {
		clickingElement(prodReviewBtn);
		return this;
	}

	/**
	 * For setting the text inside the product review text box.
	 * 
	 * @param prodReviewSearchText
	 * @return the object of the current class.
	 */

	public Pdp_BMG_Page enterReviewProd(String prodReviewSearchText) {
		setText(prodReviewSearchBox, prodReviewSearchText);
		return this;
	}

	/**
	 * For clicking the review search button of the pdp page.
	 * 
	 * @return the object of the current class.
	 */

	public Pdp_BMG_Page clkSearchBtn() {
		clickingElement(reviewSearchbtn);
		return this;

	}

	/**
	 * For clicking the enter button under the product review search text box
	 * 
	 * @return the object of the current class.
	 */

	public Pdp_BMG_Page clkEnterBtn() {
		pressEnterBtn(prodReviewSearchBox);
		return this;
	}

	

	

	/**
	 * For clicking on the contact us button.
	 * 
	 * @return the object of the current class.
	 */

	public Pdp_BMG_Page clkContactUsBtn() {
		clickingElement(contactUsBtn);
		return this;
	}

	/**
	 * For clicking the email support button
	 * 
	 * @return the object of the current class.
	 */

	public Pdp_BMG_Page clkEmailSupportBtn() {
		clickingElement(emailSupportBtn);
		return this;
	}

	/**
	 * For getting the email support page title
	 * 
	 * @return the text displayed under email support page title
	 */

	public String getEmailSupportPageTitle() {
		clickingElement(crossIcon);
		return getText(emailSupportPageTitle);
	}

	/**
	 * For clicking the support tab of the pdp page.
	 * 
	 * @return the object of the current class.
	 */

	public Pdp_BMG_Page clkSupportTab() {
		clickingElement(supportTab);
		return this;
	}

	/**
	 * For getting support page title text.
	 * 
	 * @return the text displayed under support page
	 */

	public String getSupportPageTitleTxt() {
		return getText(supportPageTitleTxt);
	}

	/**
	 * For getting locate a dealer page title
	 * 
	 * @return the text displayed under locate a dealer page title.
	 */

	public String getLocateDealerPageTitle() {
		return getText(whereToBuyPopUpBottom);
	}

	
	

	/**
	 * For clicking the add to cart button for the item in stock
	 * 
	 * @return the object of the current class.
	 */

	public Pdp_BMG_Page clkAddToCartInStock() {
		clickingElementAction(addToCartInStockBtn);
		return this;
	}
	
	public Pdp_BMG_Page clkAddToCartBtn() {
		scrollTo(selectAcce);
		clickingElementAction(addToCartInStockBtn);
		return this;
	}

	/**
	 * For getting the text of the selected product in the mini cart
	 * 
	 * @return the text displayed under mini cart
	 */

	public String isMiniCartDisplayed() {
		return getText(productNameInMiniCart);
	}

	

	/**
	 * For getting product review popup text.
	 * 
	 * @return the text displayed under product review popup.
	 */

	public String isProdReviewPopUpTxt() {
		return getText(productReviewPopUp);
	}

	
	/**
	 * For clicking the proceed to cart button of the mini cart
	 * 
	 * @return the object of the current class.
	 */

	public Pdp_BMG_Page clkProceedToCartBtn() {
		clickingElement(clkProceedToCartBtn);
		return this;
	}

	/**
	 * For clicking the first accessory displayed under supplies and accessories
	 * tab.
	 * 
	 * @return the object of the current class.
	 */

	public Pdp_BMG_Page clkAccessory1AddToCartBtn() {
		scrollTo(clkAccessory1Btn);
		clickingElement(clkAccessory1Btn);
		return this;
	}

	/**
	 * For clicking the add to cart for the secind accessory under supplies and
	 * accessories tab.
	 * 
	 * @return the object of the current class.
	 */

	public Pdp_BMG_Page clkAccessory2AddToCartBtn() {
		clickingElement(clkAccessory2Btn);
		return this;
	}

	/**
	 * For clicking the continue to shop button under the Mini cart.
	 * 
	 * @return the object of the current class.
	 */

	public Pdp_BMG_Page clkContinueToShopBtn() {
		clickingElement(clkContinueToShopBtn);
		return this;
	}

	/**
	 * For setting the text inside the promo code text box.
	 * 
	 * @param enterPromoCode
	 * @return the object of the current class.
	 */

	public Pdp_BMG_Page enterPromoCode(String enterPromoCode) {
		setText(applyPromoCodeTxtBox, enterPromoCode);
		return this;
	}

	/**
	 * For clicking on the apply button for applying the promo code under shopping
	 * cart page.
	 * 
	 * @return the object of the current class.
	 */

	public Pdp_BMG_Page clkApplyBtn() {
		clickingElement(clkApplyBtn);
		return this;
	}

	/**
	 * For getting the number the number of products added to the mini cart.
	 * 
	 * @return noOfProductsAddedToMiniCart.
	 */

	public String getProductsAddedToMiniCart() {
		return getText(noOfProductsAddedToMiniCart);
	}

	/**
	 * For getting the estimated cost after applying the promo code on the purchased
	 * products.
	 * 
	 * @return productCostAfterSavings.
	 */

	public String getproductsEstimatedCostAfterSavings() {
		return getText(productCostAfterSavings);
	}

	/**
	 * For clicking on the mini cart of the pdp page.
	 * 
	 * @return the object of the current class.
	 */

	public Pdp_BMG_Page clkMiniCart() {
		clickingElement(clkMiniCart);
		return this;
	}

	/**
	 * For clicking on the continue to shop button of the shopping cart page.
	 * 
	 * @return the object of the current class.
	 */

	public Pdp_BMG_Page clkShoppingCartPageContinueToShopBtn() {
		clickingElement(ShoppingCartPageContinueToShopBtn);
		return this;
	}

	/**
	 * For getting the instant rebate text present for the product.
	 * 
	 * @return instantRebateTxt.
	 */

	public String getInstantRebateTxt() {
		return getText(instantRebateTxt);
	}

	/**
	 * For getting A plus content of the about the product tab.
	 * 
	 * @return aPlusWebContent.
	 */

	public String getAPlusContent() {
		return getText(aPlusWebContent);
	}

	/**
	 * For clicking on where to buy button of the supplies and accessories tab
	 * 
	 * @return the object of the current class.
	 */

	public Pdp_BMG_Page whereToASBuyBtn() {
		scrollTo(supplySection);
		for (int i = 0; i < 2; i++) {
			clickingElementJS(whereToASBuyBtn.get(1));
			try {
				if (getWebElement(whereToBuyPopUpBottom).isDisplayed())
					return this;
			} catch (TimeoutException | NoSuchElementException e) {

				clickingElementJS(whereToASBuyBtn.get(0));
				break;
			}
		}
		return this;
	}

	/**
	 * for getting page Title
	 * 
	 * @return
	 */
	public String getPageTitle() {
		return driver.getTitle();
	}

}
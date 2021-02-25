package suite.page;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import suite.base.PageBase;

/**
 * Page Object Class for Page
 * 
 * @author sumit
 *
 */
public class PlpHomePage extends PageBase {

	private WebDriver driver;

	public PlpHomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public PlpHomePage getPlpPage(String pageURL) {
		NavigatetoPage(pageURL);

		try {
			clickingElement(crossIcon);
		} catch (TimeoutException e) {
			e.getMessage();
		}
		return this;
	}

	@FindBy(id = "sitecoreId")
	private WebElement crossIcon;

	@FindBy(css = "#coveo239fea27 > div.CoveoOmnibox.coveo-query-syntax-disabled.magic-box > div.magic-box-input > input")
	private WebElement SearchBarTxt;

	@FindBy(css = ".CoveoSearchButton:nth-child(5)")
	private WebElement SearchBtn;

	@FindBy(linkText = "MFC-7240")
	private WebElement ProductName1;

	@FindBy(css = ".coveo-did-you-mean-no-results-for-custom")
	private WebElement invalidProductValidationMess;

	@FindBy(css = "#coveo3317cc8e > div.coveo-result-list-container.coveo-card-layout-container > div:nth-child(1) > div > div.product-card-bottom > div.janus-plp-rating")
	private WebElement checkRefurbishedCheckBox;

	@FindBy(xpath = "//*[@id=\"coveo3317cc8e\"]/div[2]/div[1]/div/div[1]/div[2]/img")
	private WebElement refurbishedImg;

	@FindBy(css = ".btnAddToCartSecondary_MFCJ805DWXL .add-to-cart-btn")
	private WebElement addToCartBtn;

	@FindBy(css = "#coveo3317cc8e > div.coveo-result-list-container.coveo-card-layout-container > div:nth-child(1) > div > div.product-card-bottom > div.product-cta-container.rebate-price-container > div.btn-container.btnAddToCartSecondary.btnAddToCartSecondary_MFC7240 > div > div > form > button")
	private WebElement addToCartInStockBtn;

	@FindBy(css = ".productPriceforMFC7240")
	private WebElement productInStockPrice;

	@FindBy(css = ".utility-nav > .container > .row")
	private WebElement onMiniCart;

	@FindBy(css = "#mini-cart-very-unique a")
	private WebElement miniCartPopUp;

	@FindBy(css = "a > h5")
	private WebElement productNameFromMiniCart;

	@FindBy(css = ".coveo-list-layout:nth-child(3) .ps-button-label")
	private WebElement whereToBuyBtn;

	@FindBy(css = ".coveo-list-layout:nth-child(3) .janus-org-price")
	private WebElement priceWhereToBuyProd;

	@FindBy(linkText = "PriceSpider Terms of Service")
	private WebElement whereToBuyPopUpBottom;

	@FindBy(css = "#coveo3317cc8e > div.coveo-result-list-container.coveo-card-layout-container > div:nth-child(1) > div > div.product-card-bottom > div:nth-child(4) > a")
	private WebElement viewDetailBtn;

	@FindBy(css = ".janus-model-number")
	private WebElement pdpTitle;

	@FindBy(css = ".load-more > strong")
	private WebElement LoadMoreBtn;

	@FindBy(css = ".coveo-list-layout.CoveoResult:nth-child(24)")
	private WebElement lastProductDisplayed;

	@FindBy(css = ".coveo-list-layout")
	private List<WebElement> productList;

	@FindBy(linkText = "View products")
	private WebElement discontinuedProductViewDetailBtn;

	@FindBy(css = "h1")
	private WebElement discontinuedProductTitle;

	@FindBy(css = ".btnAddToCartSecondary_MFCJ5945DW .add-to-cart-btn")
	private WebElement addToCartofProdBtn;

	@FindBy(css = ".coveo-list-layout:nth-child(1) .component-content")
	private WebElement scrollToAddToCartofProdBtn;

	@FindBy(css = ".coveo-list-layout:nth-child(1) .component-content")
	private WebElement notInStockValidationMess;

	@FindBy(css = ".productPriceforMFC7240")
	private WebElement productPrice;

	@FindBy(css = ".checkout-button")
	private WebElement proceedToCartBtn;

	@FindBy(css = ".janus-s-c-item-head > .janus-s-c-col:nth-child(2)")
	private WebElement shoppingCartTitle;

	@FindBy(css = ".coveo-list-layout:nth-child(1) label")
	private WebElement OnCompareOfProd1Btn;

	@FindBy(css = ".coveo-list-layout:nth-child(2) label")
	private WebElement OnCompareOfProd2Btn;

	@FindBy(css = ".coveo-list-layout:nth-child(3) label")
	private WebElement OnCompareOfProd3Btn;

	@FindBy(css = ".coveo-list-layout:nth-child(4) label ")
	private WebElement OnCompareOfProd4Btn;

	@FindBy(css = ".number-active")
	private WebElement prodActive;

	@FindBy(css = ".btn-primary")
	private WebElement compareBtn;

	@FindBy(css = "h1")
	private WebElement comparePageTile;

	@FindBy(css = ".product:nth-child(3) > .fa")
	private WebElement crossBtnOfProd3;

	@FindBy(css = ".btn:nth-child(1) > .fa")
	private WebElement compareClearBtn;

	@FindBy(xpath = "//div[@id='Comparer']//div ")
	private WebElement comparePopUpSize;

	@FindBy(id = "productsCompareBar")
	private WebElement comparePopUp;

	@FindBy(css = "#coveoc4a13a80")
	private WebElement productRatingBtn;

	@FindBy(css = ".coveo-list-layout:nth-child(1) .janus-plp-rating a")
	private WebElement starRatingId;

	@FindBy(css = "#coveo3317cc8e > div.coveo-result-list-container.coveo-card-layout-container > div:nth-child(1) > div > div.product-card-bottom > div.janus-plp-rating")
	private WebElement priceForRating;
	
	@FindBy(css = "#bluecoreActionScreen > div.close_button-14102-position.close_button-14102-position-d0 > button")
	private WebElement popUpCrossIcon;
	
	
	

	/**
	 * for entering product name in search bar on plp page
	 * 
	 * @param productName
	 * @return object of current class
	 */
	public PlpHomePage enterProductNameInSearchBar(String productName) {
		getWebElement(SearchBarTxt);
		clickingElement(popUpCrossIcon);
		clickingElement(SearchBarTxt);
		clickingElement(SearchBarTxt);
		setText(SearchBarTxt, productName);
		return this;
	}

	/**
	 * for clicking on search icon on plp page
	 * 
	 * @return object of current class
	 */
	public PlpHomePage clkSearchIcon() {
		clickingElement(SearchBtn);
		return this;
	}

	/**
	 * for getting product name after search
	 * 
	 * @return product name
	 */
	public String getProductName() {
		return getText(ProductName1);
	}

	/**
	 * for getting invalid product validation message after search
	 * 
	 * @return invalid product validation message
	 */
	public String getInvalidProductValidationMess() {
		return getText(invalidProductValidationMess);
	}

	/**
	 * for checking refurbished check box
	 * 
	 * @return object of current class
	 */
	public PlpHomePage checkRefurbishedCheckBox() {
		clickingElement(checkRefurbishedCheckBox);
		return this;
	}

	/**
	 * for getting refurbished header on top of product
	 * 
	 * @return true if rufurbished image is displyed
	 */

	public boolean isRefurbishedPresent() {
		getWebElement(refurbishedImg);
		return refurbishedImg.isDisplayed();
	}

	/**
	 * for clicking on add to cart button in plp page
	 * 
	 * @return object of current class
	 */
	public PlpHomePage clkAddToCart() {
		getWebElement(productPrice);
		clickingElement(addToCartBtn);
		return this;
	}

	/**
	 * for clicking on add to cart for product which is in stock
	 * 
	 * @return object of current class
	 */
	public PlpHomePage clkAddToCartInStock() {
		getWebElement(productInStockPrice);
		clickingElement(addToCartInStockBtn);
		return this;
	}

	/**
	 * for clicking out of the cart
	 * 
	 * @return object of current class
	 */
	public PlpHomePage clkOnMiniCart() {
		clickingElementJS(onMiniCart);
		return this;
	}

	/**
	 * for is mini cart displayed
	 * 
	 * @return false when mini cart pop up is not displayed
	 */
	public String isMiniCartDisplayed() {
		return getAttributeValue(miniCartPopUp, "aria-expanded");
	}

	/**
	 * for getting product name from mini cart
	 * 
	 * @return name from mini cart
	 */
	public String getProductNameFromMiniCart() {
		return getText(productNameFromMiniCart);
	}

	/**
	 * for clicking where to buy button
	 * 
	 * @return object of current class
	 */
	public PlpHomePage clkWhereToBuyBtn() {
		getWebElement(priceWhereToBuyProd);
		scrollTo(priceWhereToBuyProd);

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
	 * for clicking on view detail button
	 * 
	 * @return object of current class
	 */
	public PlpHomePage clkViewDetailBtn() {
		scrollTo(productPrice);
		getWebElement(productPrice);
		clickingElement(viewDetailBtn);
		return this;
	}

	/**
	 * for getting text from pdp title
	 * 
	 * @return pdp title
	 */
	public String getPdpTitle() {
		return getText(pdpTitle);
	}

	/**
	 * for clicking on load more
	 * 
	 * @return object of current class
	 */
	public PlpHomePage clkLoadMoreBtn() {
		clickingElement(LoadMoreBtn);
		return this;
	}

	/**
	 * for checking if product 24 is diplayed after clicking on load more
	 * 
	 * @return if product 24 is diplayed after clicking on load more true
	 */
	public boolean islastProductDisplayed() {
		getWebElement(lastProductDisplayed);
		return lastProductDisplayed.isDisplayed();
	}

	/**
	 * for scrolling to load more button
	 * 
	 * @return object of current class
	 */
	public PlpHomePage scrollLoadMore() {
		scrollTo(LoadMoreBtn);
		return this;
	}

	/**
	 * for clicking on discontinued product view details button
	 * 
	 * @return object of current class
	 */
	public PlpHomePage clkVeiwProducts() {
		clickingElement(discontinuedProductViewDetailBtn);
		return this;
	}

	/**
	 * for getting discontinued product title
	 * 
	 * @return discontinued product title
	 */
	public String getDiscontinuedTitle() {
		return getText(discontinuedProductTitle);
	}

	/**
	 * for scrolling ot add to cart button in of product
	 * 
	 * @return object of current class
	 */
	public PlpHomePage scrollToAddToCartofProd() {
		scrollTo(scrollToAddToCartofProdBtn);
		return this;
	}

	/**
	 * for clicking on add to cart button of product
	 * 
	 * @return object of current class
	 */
	public PlpHomePage clkOnAddToCartofProd() {
		clickingElementJS(productPrice);
		clickingElementJS(addToCartofProdBtn);
		return this;
	}

	/**
	 * for getting validation message for not in stock
	 * 
	 * @return validation message for not in stock
	 */
	public String getNotInStockValidationMess() {
		return getText(notInStockValidationMess);

	}

	/**
	 * for clicking on proceed to cart button
	 * 
	 * @return object of current class
	 */
	public PlpHomePage clkProceedToCart() {
		clickingElement(proceedToCartBtn);
		return this;
	}

	/**
	 * for getting shopping cart title
	 * 
	 * @return shopping cart title
	 */
	public String getShoppingCartTitle() {
		return getText(shoppingCartTitle);
	}

	/**
	 * for clicking on compare button of product 1
	 * 
	 * @return object of current class
	 */
	public PlpHomePage clkOnCompareOfProd1() {
		clickingElementJS(OnCompareOfProd1Btn);
		return this;
	}
	/**
	 * for clicking on compare button of product 2
	 * 
	 * @return object of current class
	 */
	public PlpHomePage clkOnCompareOfProd2() {
		clickingElementJS(OnCompareOfProd2Btn);
		return this;
	}

	/**
	 * for clicking on compare button of product 3
	 * 
	 * @return object of current class
	 */
	public PlpHomePage clkOnCompareOfProd3() {
		clickingElementJS(OnCompareOfProd3Btn);
		return this;
	}

	/**
	 * for getting how many number of product are present in compare pop up
	 * 
	 * @return number of product are present in compare pop up
	 */
	public String getProdActive() {
		return getText(prodActive);
	}

	/**
	 * for clicking compare button in pop up
	 * 
	 * @return object of current class
	 */
	public PlpHomePage clkOnCompareBtn() {
		clickingElement(compareBtn);
		return this;
	}

	/**
	 * for getting compare page title
	 * 
	 * @return compare page title
	 */
	public String getComparePageTitle() {
		return getText(comparePageTile);
	}

	/**
	 * for clicking on cross button of product 3
	 * 
	 * @return object of current class
	 */
	public PlpHomePage clkOnCrossBtnOfProd3() {
		clickingElementJS(crossBtnOfProd3);
		return this;
	}

	/**
	 * for clicking on clear button on compare pop up
	 * 
	 * @return object of current class
	 */
	public PlpHomePage clkOnClearAll() {
		clickingElement(compareClearBtn);
		return this;
	}

	/**
	 * for checking if compare pop up size
	 * 
	 * @return number of product active
	 */
	public String isPopUpEmpty() {
		return getText(prodActive);
	}

	/**
	 * for clicking on product rating button
	 * 
	 * @return product rating
	 */
	public Object clkProductRating() {
		clickingElement(productRatingBtn);
		return this;
	}

	/**
	 * for scrolling to rufurbished check box
	 * 
	 * @return object of current class
	 */
	public PlpHomePage scrollToRefurbishedCheckBox() {
		scrollTo(checkRefurbishedCheckBox);
		return this;
	}

	/**
	 * for getting attribute value of star rating
	 * 
	 * @return
	 */
	public String getRating() {
		getWebElement(priceForRating);
		return  getAttributeValue(starRatingId, "aria-label") ;
	}

	/**
	 * for getting the number of product on plp
	 * 
	 * @return size of list
	 */

	public int getProductList() {
		clickingElement(LoadMoreBtn);
		return productList.size();
	}

	/**
	 * for checking if compare box is enabled
	 * 
	 * @return false if disabled true if enabled
	 */
	public boolean compareBoxEnable() {
		scrollTo(OnCompareOfProd4Btn);
		clickingElement(OnCompareOfProd4Btn);
		return isWebElementSelected(OnCompareOfProd4Btn);

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
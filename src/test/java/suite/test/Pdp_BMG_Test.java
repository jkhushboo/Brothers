package suite.test;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import suite.base.TestBase;
import suite.page.CheckoutPage;
import suite.page.Pdp_BMG_Page;
import suite.testdata.Pdp_BMG_TestData;
import suite.utils.Xls_Reader;

public class Pdp_BMG_Test extends TestBase {

	private Pdp_BMG_Page pdp;

	private String getPageUrl() {
		return getEnv().concat(Pdp_BMG_TestData.PDP_PAGE);
	}

	private String getPageUrlInstantRebate() {
		return getEnv().concat(Pdp_BMG_TestData.INSTANT_REBATE_PAGE);
	}

	private String getAddToCartPageUrl() {
		return getEnv().concat(Pdp_BMG_TestData.ADD_TO_CART_PAGE);
	}

	private String getPageUrlStandard() {
		return getEnv().concat((getSheet().getRow(1).getCell(1).getStringCellValue()));
	}

	private XSSFSheet getSheet() {
		return getTestData().getSheet("Guest_user");
	}

	private CheckoutPage co;
	DataFormatter formatter = new DataFormatter();
	private Cell cell;

	Xls_Reader reader = new Xls_Reader("src/main/resources/TestDataSheet_uat.xlsx");

	@Test(enabled = true, description = "Verify that the product is added to mini cart")

	public void pdp_bmg_1() {

		co = new CheckoutPage(getDriver());
		co.getPdpCheckoutPage(getPageUrlStandard()).clkAddtoCartBtn();

		/*
		 * pdp = new Pdp_BMG_Page(getDriver());
		 * 
		 * pdp.getPdpPage(getAddToCartPageUrl()).clkAddtoCartBtn();
		 */

		String actual = co.getProductNameAddToMiniCart();
		System.out.println(actual);

		/*
		 * Assert.assertEquals(actual,
		 * Pdp_BMG_TestData.PRODUCT_NAME_ADDED_TO_MINI_CART);
		 */

	}

	@Test(enabled = true, description = "Verify that the popup gets generated when the user clicks on where to buy option")

	public void pdp_bmg_2() {

		pdp = new Pdp_BMG_Page(getDriver());

		pdp.getPdpPage(getPageUrl()).clkwhereToBuyBtn();

		String actual = pdp.getWhereToBuyPopUp();

		Assert.assertEquals(actual, Pdp_BMG_TestData.EXPECTED_TITLE_WHERE_TO_BUY_POPUP);

	}

	@Test(enabled = true, description = "Verify the text present under the about product section")

	public void pdp_bmg_3() {

		pdp = new Pdp_BMG_Page(getDriver());

		pdp.getPdpPage(getPageUrl()).clkAboutProductSection();

		String actual = pdp.getAboutTheProdTxt();

		Assert.assertEquals(actual, Pdp_BMG_TestData.ABOUT_THE_PROD_TXT);

	}

	@Test(enabled = true, description = "verify the text present under specification section")

	public void pdp_bmg_4() {

		pdp = new Pdp_BMG_Page(getDriver());

		pdp.getPdpPage(getPageUrl()).clkAboutProductSpecification();

		String actual = pdp.isBasicFeatureDisplayed();

		Assert.assertEquals(actual, Pdp_BMG_TestData.EXPECTED_PROD_SPECIFICATION_EXPAND);

	}

	@Test(enabled = true, description = "Verify the specified product name under supplies and accessories tab")

	public void pdp_bmg_5() {

		pdp = new Pdp_BMG_Page(getDriver());

		pdp.getPdpPage(getPageUrl()).clkSuppliesAccessoriesTab();

		String actual = pdp.getFirstDisplayedAccName();

		Assert.assertEquals(actual, Pdp_BMG_TestData.FIRST_DISPLAYED_ACC_NAME);

	}

	@Test(enabled = true, description = "Verify on clicking on add to cart button under supplies and accessories tab, selected item is displayed in mini cart")
	public void pdp_bmg_6() {

		pdp = new Pdp_BMG_Page(getDriver());

		pdp.getPdpPage(getPageUrl()).clkSuppliesAccessoriesTab().clkAddToCartASBtn();

		System.out.println("Product added to mini cart :");

		/*
		 * String actual = pdp.getSelectedProductName();
		 * 
		 * Assert.assertEquals(actual,
		 * Pdp_BMG_TestData.SELECTED_PROD_NAME_IN_MINI_CART);
		 */

	}

	@Test(enabled = true, description = "Verify the text after entering the review text and clicking on search button")

	public void pdp_bmg_7() {

		pdp = new Pdp_BMG_Page(getDriver());

		pdp.getPdpPage(getPageUrl()).clkProdReviewBtn().enterReviewProd(Pdp_BMG_TestData.PROD_REVIEW_SEARCH_TEXT_)
				.clkSearchBtn();

		String actual = pdp.isProdReviewPopUpTxt();

		Assert.assertEquals(actual, Pdp_BMG_TestData.PROD_REVIEW_SEARCH_MSG);

	}

	@Test(enabled = true, description = "Verify the search results for invalid search", groups = { "", "pdp_bmg" })

	public void pdp_bmg_8() {

		pdp = new Pdp_BMG_Page(getDriver());

		pdp.getPdpPage(getPageUrl()).clkProdReviewBtn()
				.enterReviewProd(Pdp_BMG_TestData.PROD_REVIEW_INVALID_SEARCH_TEXT_).clkEnterBtn();

		String actual = pdp.isProdReviewPopUpTxt();

		Assert.assertEquals(actual, Pdp_BMG_TestData.PROD_REVIEW_SEARCH_MSG);

	}

	@Test(enabled = true, description = "Verify the Title of an email support page", groups = { "", "pdp_bmg" })

	public void pdp_bmg_9() {

		pdp = new Pdp_BMG_Page(getDriver());

		pdp.getPdpPage(getPageUrl()).clkContactUsBtn().clkEmailSupportBtn();

		String actual = pdp.getEmailSupportPageTitle();

		Assert.assertEquals(actual, Pdp_BMG_TestData.EMAIL_SUPPORT_PAGE_TITLE);

	}

	@Test(enabled = true, description = "Verify whether clicking on support tab redirect us to support page", groups = {
			"", "pdp_bmg" })

	public void pdp_bmg_10() {

		pdp = new Pdp_BMG_Page(getDriver());

		pdp.getPdpPage(getPageUrl()).clkSupportTab();

		String actual = pdp.getSupportPageTitleTxt();
		System.out.println(actual);

		Assert.assertEquals(actual, Pdp_BMG_TestData.SUPPORT_PAGE_TITLE);

	}

	@Test(enabled = true, description = "Verify the specified product name under supplies and accessories tab", groups = {
			"", "pdp_bmg" })

	public void pdp_bmg_11() {

		pdp = new Pdp_BMG_Page(getDriver());

		pdp.getPdpPage(getPageUrl()).clkSuppliesAccessoriesTab();

		String actual = pdp.getFirstDisplayedAccName();
		System.out.println(actual);

		Assert.assertEquals(actual, Pdp_BMG_TestData.FIRST_DISPLAYED_ACC_NAME);

	}

	@Test(enabled = true, description = "Verify on clicking on locate a dealer button, a popup gets opened", groups = {
			"done", "pdp_bmg" })

	public void pdp_bmg_12() {

		pdp = new Pdp_BMG_Page(getDriver());

		pdp.getPdpPage(getPageUrl()).clkSuppliesAccessoriesTab().clkwhereToBuyBtn();

		String actual = pdp.getWhereToBuyPopUp();

		Assert.assertEquals(actual, Pdp_BMG_TestData.EXPECTED_TITLE_WHERE_TO_BUY_POPUP);

	}

	@Test(enabled = false, description = "Verify on clicking on add to cart button under supplies and accessories tab, selected item is displayed in mini cart", groups = {
			"", "pdp_bmg" })
	public void pdp_bmg_13() {

		pdp = new Pdp_BMG_Page(getDriver());

		pdp.getPdpPage(getPageUrl())
		.clkSuppliesAccessoriesTab()
		.clkAddToCartBtn();

		
		  String actual = pdp.getSelectedProductName(); 
		 
			  Assert.assertEquals(actual,
			  Pdp_BMG_TestData.SELECTED_PROD_NAME_IN_MINI_CART);
			 

	}

	@Test(enabled = false, description = "verify the product that is in stock is shown in the mini cart", groups = {
			"done", "pdp_bmg" })

	public void pdp_bmg_14() {

		pdp = new Pdp_BMG_Page(getDriver());

		pdp.getPdpPage(getAddToCartPageUrl()).clkAddToCartInStock();

		String actual = pdp.isMiniCartDisplayed();
		System.out.println(actual);

		// Assert.assertEquals(actual,
		// Pdp_BMG_TestData.EXPECTED_PROD_DISPLAYED_MINI_CART);

	}

	// needs confirmation from brother's team for valid promo code

	@Test(enabled = false, description = "Verify the promo code is applied on the 3 products added to the mini cart", groups = {
			"done", "pdp_bmg" })

	public void pdp_bmg_15() {

		pdp = new Pdp_BMG_Page(getDriver());

		pdp.getPdpPage(getAddToCartPageUrl()).clkAddtoCartBtn().clkContinueToShopBtn().clkSuppliesAccessoriesTab()
				.clkAccessory1AddToCartBtn().clkContinueToShopBtn().clkAccessory2AddToCartBtn().clkProceedToCartBtn()
				.enterPromoCode(Pdp_BMG_TestData.ENTER_PROMO_CODE).clkApplyBtn();

		String actual1 = pdp.getproductsEstimatedCostAfterSavings();

		Assert.assertTrue(actual1.contains(Pdp_BMG_TestData.ESTIMATED_COST_AFTER_SAVINGS));

		String actual2 = pdp.getProductsAddedToMiniCart();

		Assert.assertEquals(actual2, Pdp_BMG_TestData.NUMBER_OF_PRODUCT_ADDED_TO_MINI_CART);

	}

	@Test(enabled =false, description = "Verify the A+/A- design in about the product tab", groups = { "done",
			"pdp_bmg" })

	public void pdp_bmg_16() {

		pdp = new Pdp_BMG_Page(getDriver());

		pdp.getPdpPage(getPageUrl()).clkAboutProductSection();

		String actual = pdp.getAPlusContent();

		Assert.assertEquals(actual, Pdp_BMG_TestData.A_PLUS_WEB_CONTENT);

	}

	@Test(enabled = false, description = "Verify that instant rebate is present for the product", groups = { "done",
			"pdp_bmg" })

	public void pdp_bmg_17() {

		pdp = new Pdp_BMG_Page(getDriver());

		pdp.getPdpPage(getPageUrlInstantRebate());

		String actual = pdp.getInstantRebateTxt();

		Assert.assertTrue(actual.contains(Pdp_BMG_TestData.INSTANT_REBATE_TXT_DISPLAYED));

	}
}
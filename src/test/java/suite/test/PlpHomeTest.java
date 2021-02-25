package suite.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import suite.base.TestBase;
import suite.page.PlpHomePage;
import suite.testdata.PlpHomeTestData;

/**
 * This class contains the automation Test Cases
 * 
 * @author sumit
 *
 */
public class PlpHomeTest extends TestBase {

	private PlpHomePage plpHome; 
	/**
	 * create page url
	 * 
	 * @return plp pageurl
	 */
	private String getPageUrl() {
		return getEnv().concat(PlpHomeTestData.PLP_PAGE);
	}

	@Test(enabled = true,description = "Verify that product is displayed when searched", groups = {"done","plp" })
	public void plpHome_1() {

		plpHome = new PlpHomePage(getDriver());
		
		plpHome.getPlpPage(getPageUrl())
					  .enterProductNameInSearchBar(PlpHomeTestData.PLP_PRODUCT_NAME)
					  .clkSearchIcon();
				
		String actual = plpHome.getProductName();
		
		Assert.assertEquals(actual, PlpHomeTestData.EXPECTED_PRODUCT_NAME);
	}
	
	@Test(enabled = true,description = "Veirfy that validation message is displayed when invalid product is searched", groups = {"done","plp" })
	public void  plpHome_2() {

		plpHome = new PlpHomePage(getDriver());
		
		plpHome.getPlpPage(getPageUrl())
					   .enterProductNameInSearchBar(PlpHomeTestData.PLP_INVALID_PRODUCT_NAME)
					   .clkSearchIcon();
		
		String actual = plpHome.getInvalidProductValidationMess();
		
		Assert.assertEquals(actual, PlpHomeTestData.EXPECTED_INVLAID_PRODUCT_VALIDATION_MESSAGE);
	}
	
	@Test(enabled = true,description = "Verify where to buy pop up when clicked on where to buy button ", groups = {"done","plp" })
	public void  plpHome_3() {

		plpHome = new PlpHomePage(getDriver());
		
			plpHome.getPlpPage(getPageUrl())
					       .enterProductNameInSearchBar(PlpHomeTestData.PLP_WHERE_TO_BUY_PRODUCT_NAME)
					       .clkSearchIcon()
						   .clkWhereToBuyBtn();
			
			String actual = plpHome.getWhereToBuyPopUp();
			
			Assert.assertEquals(actual, PlpHomeTestData.EXPECTED_TITLE_WHERE_TO_BUY_POPUP);
	}
	
	@Test(enabled = true,description = "Verify that more products are added when clicking on load more ", groups = {"done","plp" })
	public void  plpHome_4() {

		plpHome = new PlpHomePage(getDriver());
		
		plpHome.getPlpPage(getPageUrl())
					   .scrollLoadMore()
					   .clkLoadMoreBtn();
		
		boolean actual = plpHome.islastProductDisplayed();
		
		Assert.assertTrue(actual);
	}
	
	@Test(enabled = true,description = "verify that product is added to mini cart when clicked on add to cart btn", groups = {"done","plp" })
	public void  plpHome_5() {

		plpHome = new PlpHomePage(getDriver());
		
		plpHome.getPlpPage(getPageUrl())
					   .enterProductNameInSearchBar(PlpHomeTestData.EXPECTED_PLP_PRODUCT_NAME_IN_STOCK)
					   .clkSearchIcon()
					   .clkAddToCartInStock();
		
		String actual = plpHome.getProductNameFromMiniCart();
		
		Assert.assertEquals(actual, PlpHomeTestData.EXPECTED_PRODUCT_NAME_MINI_CART);
		}
	
	@Test(enabled = true,description = "Verify that Redirected to Pdp page  ", groups = {"done","plp" })
	public void  plpHome_6() {


			plpHome = new PlpHomePage(getDriver());
			
			plpHome.getPlpPage(getPageUrl())
						   .enterProductNameInSearchBar(PlpHomeTestData.PLP_PRODUCT_NAME)
						   .clkSearchIcon();
			
			plpHome .clkViewDetailBtn();
				
			String actual = plpHome.getPdpTitle();
				
			Assert.assertEquals(actual, PlpHomeTestData.EXPECTED_PRODUCT_NAME_PDP_TITLE);
		} 
	
	@Test(enabled = true,description = "Verify that sort is working", groups = {"done","plp" })
	public void plpHome_7() {

			plpHome = new PlpHomePage(getDriver());
			
			plpHome.getPlpPage(getPageUrl())
						   .clkProductRating();

			String actual=plpHome.getRating();
			
			Assert.assertTrue(actual.contains(PlpHomeTestData.EXPECTED_PRODUCT_RATING));
				
	}
	
	@Test(enabled = true,description = "Verify that refurbished products are displayed when click on check box", groups = { "done",	"plp" })
	public void  plpHome_8() {

		plpHome = new PlpHomePage(getDriver());
		
		plpHome.getPlpPage(getPageUrl())
			           .checkRefurbishedCheckBox();
		
		boolean actual = plpHome.isRefurbishedPresent();
		
		Assert.assertTrue(actual);
		
	}
	
	@Test(enabled = false,description = "Verify that redirect to compare page after clicking on compare ", groups = {"","plp" })
	public void  plpHome_9() {

		plpHome = new PlpHomePage(getDriver());
		
		plpHome.getPlpPage(getPageUrl())
					  .clkOnCompareOfProd1()
					  .clkOnCompareOfProd2()
					  .clkOnCompareOfProd3()
					  .clkOnCompareBtn();
		
		String actual=plpHome.getComparePageTitle();
		
		Assert.assertEquals(actual, PlpHomeTestData.EXPECTED_COMPARE_PAGE_TITLE);
	}

}
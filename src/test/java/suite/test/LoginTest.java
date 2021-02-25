package suite.test;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.Assert;
import org.testng.annotations.Test;
import suite.base.TestBase;

import suite.page.LoginPage;

import suite.testdata.LoginTestData;

/**
 * This class contains the automation Test Cases
 */

public class LoginTest extends TestBase {

	private LoginPage login;

	/**
	 * create page url
	 * 
	 * @return login pageurl
	 */
	private String getPageUrl() {
		return getEnv().concat(LoginTestData.LOGIN_PAGE);
	}
	
	/**
     * create excel file
     *
     * @return excel file path
     */
    private XSSFSheet getSheet() {
        return getTestData().getSheet("Registered_user");
    }
    
    @Test(enabled = true, description = "Verify that the user can log in with valid Credentials.")
	public void log_1() {
		login = new LoginPage(getDriver());
		login.getLoginPage(getPageUrl()).enterUname(getSheet().getRow(1).getCell(1).getStringCellValue())
		.enterPass(getSheet().getRow(1).getCell(2).getStringCellValue())
				.clkSubmitBtn();
		String actual = login.getWelcomeMessage();
		System.out.println(actual);
		
    }

	@Test(enabled = true, description = "Verify that the user can log in with valid Credentials.")
	public void log() {
		login = new LoginPage(getDriver());
		login.getLoginPage(getPageUrl()).enterUname(LoginTestData.VALID_UNAME).enterPass(LoginTestData.VALID_PASS)
				.clkSubmitBtn();
		String actual = login.getWelcomeMessage();
		System.out.println(actual);
		String[] name = LoginTestData.VALID_UNAME.split("@brother.com");
		String validate = name[0].substring(0, 1).toUpperCase() + name[0].substring(1);
		System.out.println(validate);

		Assert.assertEquals(actual, LoginTestData.EXPECTED_WELCOME_MESSAGE.concat(validate).concat(","));

	}

	@Test(enabled = true, description = "Verify that Validation message is displayed on Entering Invalid Email ID ", groups = {
			"login" })
	public void log_2() {

		login = new LoginPage(getDriver());

		login.getLoginPage(getPageUrl()).enterUname(LoginTestData.INVALID_UNAME);
		String actualName = login.getUserNameValidationMessage();
		Assert.assertEquals(actualName, LoginTestData.EXPECTED_USERNAME_VALIDATION_MESSAGE);

	}

	@Test(enabled = true, description = "Verify that Validation message is displayed on Entering Invalid Creds ", groups = {
			"login" })
	public void log_3() {

		login = new LoginPage(getDriver());

		login.getLoginPage(getPageUrl()).enterUname(LoginTestData.INVALID_UserNAME)
				.enterPass(LoginTestData.INVALID_PASS).clkSubmitBtn();
		String actualPass = login.enterPass(LoginTestData.INVALID_PASS).clkSubmitBtn().getPasswordValidationMessage();
		Assert.assertEquals(actualPass, LoginTestData.EXPECTED_PASSWORD_VALIDATION_MESSAGE);

	}

	@Test(enabled = true, description = "Verify ForgotPasswordLink with ThankYou Message ", groups = {
	"login" })
	public void log_4() {

		login = new LoginPage(getDriver());

		login.getLoginPage(getPageUrl()).clickOnForgotPasswordLink()
						.enterEmailAddress(LoginTestData.VALID_EMAILID).clickOnContinueBtn();
						
					String actual= 	login.getThankYouMessage();
		Assert.assertEquals(actual, LoginTestData.EXPECTED_THANKYOU_MESSAGE);
	}
	
	@Test(enabled = true, description = "Verify ForgotPasswordLink with Invalid EmailAddress ", groups = {
	"login" })
	public void log_5() {

		login = new LoginPage(getDriver());

		login.getLoginPage(getPageUrl()).clickOnForgotPasswordLink()
						.enterEmailAddress(LoginTestData.INVALID_EMAILID).clickOnContinueBtn();
						
					String actual= 	login.getErrorMessage();
		Assert.assertEquals(actual, LoginTestData.EXPECTED_ERROR_MESSAGE);
	}
	
		  
		
	/*
	 * @Test(enabled = false,description =
	 * "Verify that Initial Validation message is displayed on Entering Invalid Password"
	 * , groups = { "login" }) public void log_6() {
	 * 
	 * login = new LoginPage(getDriver()); login.getLoginPage(getPageUrl())
	 * .enterUname(LoginTestData.VALID_UNAME) .enterPass(LoginTestData.INVALID_PASS)
	 * .clkSubmitBtn(); String actualPass =
	 * login.getInitialPasswordValidationMessage(); Assert.assertEquals(actualPass,
	 * LoginTestData.EXPECTED_INITAL_PASSWORD_VALIDATION_MESSAGE); }
	 */
		
}



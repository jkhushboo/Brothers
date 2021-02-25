package suite.testdata;

public class LoginTestData {

	public static final String LOGIN_PAGE = "/login";
	public static final String VALID_UNAME = "amrita@brother.com";
	public static final String VALID_PASS = "Welcome1";
	public static final String EXPECTED_WELCOME_MESSAGE = "Welcome ";
	public static final String INVALID_UNAME = "Aditya@aol";
	public static final String EXPECTED_USERNAME_VALIDATION_MESSAGE = "Please enter a valid email.";
	public static final String INVALID_PASS = "abc123";
	public static final String INVALID_UserNAME = "abc@test.com";
	public static final String EXPECTED_PASSWORD_VALIDATION_MESSAGE = "Sorry, we could not verify your account. Please verify the information you entered, or click on \"Create New Account\", or click here if you have forgotten your password.";
	public static final String VALID_EMAILID = "ananya.sharma@mailinator.com";
	public static final String EXPECTED_ERROR_MESSAGE = "Your email was not found in our system please try again.";
	public static final String EXPECTED_THANKYOU_MESSAGE = "Thank You";
	public static final String EXPECTED_INITAL_PASSWORD_VALIDATION_MESSAGE = "Encountered issue with backend services, please try again after some time";
	public static final String INVALID_EMAILID = "ananya1@mailinator.com";
	

}

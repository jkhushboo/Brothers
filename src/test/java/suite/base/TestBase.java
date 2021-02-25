package suite.base;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import suite.init.SessionInit;
import suite.listener.WebDriverListener;
import suite.utils.ExcelUtils;

/**
 * This is Test Base class for automation framework contains all the common test
 * prerequisites for automation
 * 
 * @author arth
 *
 */
public class TestBase extends EnvBase {

	private WebDriver driver;
	private WebDriverWait wait;
	private EventFiringWebDriver eventHandler;
	private WebDriverListener ecapture;

	@Parameters({ "env" })
	@BeforeClass
	public void setUpEnv(@Optional("qa") String env) {
		setEnv(env);
	}

	@Parameters({ "browser" })
	@BeforeMethod
	public void setDriver(@Optional("chrome") String browser) {
		
		SessionInit.getDriverSession().initiateBrowserSession(browser);
		this.driver = SessionInit.getDriverSession().getBrowserSession();

		this.eventHandler = new EventFiringWebDriver(driver);
		this.ecapture = new WebDriverListener();
		this.eventHandler.register(ecapture);
	}

	@AfterMethod
	public void screenShot(ITestResult result){
        //using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
        if(ITestResult.FAILURE==result.getStatus()){
        	
        try{
        // To create reference of TakesScreenshot
        TakesScreenshot screenshot=(TakesScreenshot)driver;
        // Call method to capture screenshot
        File src=screenshot.getScreenshotAs(OutputType.FILE);
        // Copy files to specific location 
        // result.getName() will return name of test case so that screenshot name will be same as test case name
        FileUtils.copyFile(src, new File("Screenshots/"+result.getName()+".png"));



        System.out.println("Successfully captured a screenshot");



        }catch (Exception e){
            
        System.out.println("Exception while taking screenshot "+e.getMessage());
        }
        }
     
        this.eventHandler.unregister(ecapture);
         SessionInit.getDriverSession().terminateBrowserSession(driver);



        }
	
	/*
	 * public void tearDown() { this.eventHandler.unregister(ecapture);
	 * SessionInit.getDriverSession().terminateBrowserSession(driver); }
	 */

	public EventFiringWebDriver getDriver() {
		return this.eventHandler;
	}

	@Override
	public String getEnv() {
		return super.getEnv();
	}

	public WebDriverWait getWait() {
		return wait;
	}
	
	/**
	* for getting the data from excel sheet
	*
	* @return path of the sheet
	*/
	public XSSFWorkbook getTestData() {
	return new ExcelUtils().ExcelDataConfig("src/main/resources/TestDataSheet_uat.xlsx");
	}
	
	
}
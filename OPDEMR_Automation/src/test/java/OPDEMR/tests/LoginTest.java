package OPDEMR.tests;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import OPDEMR.pages.LoginPage;
import OPDEMR.utils.TestUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
public class LoginTest extends BaseTest {
//	String UniqueNumber=GetCurrentTimeAndDate();
	private static Logger Log = LogManager.getLogger(LoginPage.class.getName());
	
	
	
	
	@Test(priority = 1)
	public void VerifyObjectsOfLoginPage() throws Exception {
		test = extent.startTest("User login for OPDEMR Application");
		
		
		test.log(LogStatus.INFO, "Successfully loaded login page of OPDEMR Application");
		pages.getLoginPage().LoadToOPDEMR();
		
		test.log(LogStatus.INFO, "Successfully entered Invalid credentials and clicked on Login Button");
		pages.getLoginPage().LoginToOPDEMRwithCredentials("wood", "@!@&*&&");
		
	
		test.log(LogStatus.INFO, "Successfully Validated the Alert Message On Entering the  Invalid Credentials");
		Assert.assertEquals(pages.getLoginPage().ValidateInvalidCredentialsAlertMessage(), true,"Validation Message is missing on Invalid Credentials");

		
		test.log(LogStatus.INFO, "Successfully Verified the Objects Present in loginPage");
		Assert.assertEquals(pages.getLoginPage().VerifyTheElementsOfLoginPage(), true,"Objects are missing at login page.");

		
		test.log(LogStatus.INFO, "Successfully Verified that password  field is not displaying the values to the user.");
		Assert.assertEquals(pages.getLoginPage().ValidateMaskedValueForPasswordField(), true,"Password values are not masked");

		test.log(LogStatus.INFO, "Successfully Verified that password  field is displaying the values to the user on click of Show Button.");
		Assert.assertEquals(pages.getLoginPage().ValidateUNMaskedValueForPasswordFieldWhenClickedOnEyeButton(), true,"Password values are not displaying on CLick of Show button.");

	//	test.log(LogStatus.INFO, "Successfully Verified the privacy policy.");
	//	pages.getLoginPage().getAllPolicyDocumentPrintedInExcel();
		
		test.log(LogStatus.INFO, "Successfully entered Valid credentials and clicked on Login Button");
		pages.getLoginPage().LoginToOPDEMRwithCredentials("WOOD123456", "Wood@098");
		
		test.log(LogStatus.INFO, "Successfully validated that user successfully logged in by valid credentials");
		Assert.assertEquals(pages.getLoginPage().VerifyUserLoggedINSuccessfully(), true,"User is not able to logg in by WOOD123456/Wood@098 ");
	}
	
	@Test(priority = 1)
	public void VerifyChangePasswordTestCases() throws Exception
	{
	
		test = extent.startTest("User Change Password TestCases for OPDEMR Application");
		test.log(LogStatus.INFO, "Successfully loaded login page of OPDEMR Application");
		pages.getLoginPage().LoadToOPDEMR();
	
	
		test.log(LogStatus.INFO, "Successfully entered Valid credentials and clicked on Login Button");
		pages.getLoginPage().LoginToOPDEMRwithCredentials("WOOD123456", "Wood@098");
		
		test.log(LogStatus.INFO, "Successfully Clicked On Change Password button");
		pages.getBasicControllerPage().CliCkOnAnyUserDropDownButton("Change Password");
		
		test.log(LogStatus.INFO, "Successfully clicked on Change Password Button");
		pages.getChangePasswordPage().CLickOnChangePAsswordButton();
		
		
		test.log(LogStatus.INFO, "Sucessfully Verified the Validation Alert on Password field.");
		Assert.assertEquals(pages.getChangePasswordPage().VerifyValidationONPasswordFields(), true,"Validation message is not getting displayed on Change Password field");
		
		
		test.log(LogStatus.INFO, "Sucessfully Entered the text values in all the Password fields.");
		pages.getChangePasswordPage().SetPasswordsField("uwuwhuh", "Uhuhsuud", "insninei");
		
		test.log(LogStatus.INFO, "Sucessfully Verified the Validation Alert on Password field.");
		Assert.assertEquals(pages.getChangePasswordPage().VerifyValidationONPasswordFields(), true,"Validation message is not getting displayed on Change Password field");
		
		
	}
	
	
	@Test(priority = 1)
	public void VerifyChangePasswordAndLoggingInAndChangingAgain() throws Exception
	{
	
		test = extent.startTest("User Change Password and looging in with the new password and  changing back the password again to default");
		test.log(LogStatus.INFO, "Successfully loaded login page of OPDEMR Application");
		pages.getLoginPage().LoadToOPDEMR();
	
	
		test.log(LogStatus.INFO, "Successfully entered Valid credentials and clicked on Login Button");
		pages.getLoginPage().LoginToOPDEMRwithCredentials("WHD0001", "Pass@123");
		
		test.log(LogStatus.INFO, "Successfully Clicked On Change Password button");
		pages.getBasicControllerPage().CliCkOnAnyUserDropDownButton("Change Password");
		
		test.log(LogStatus.INFO, "Sucessfully Entered the text values in all the Password fields.");
		pages.getChangePasswordPage().SetPasswordsField("Pass@123", "Wood@099", "Wood@099");
		
		test.log(LogStatus.INFO, "Successfully clicked on Change Password Button");
		pages.getChangePasswordPage().CLickOnChangePAsswordButton();
		
		test.log(LogStatus.INFO, "Successfully entered Valid New credentials and clicked on Login Button");
		pages.getLoginPage().LoginToOPDEMRwithCredentials("WHD0001", "Wood@099");
		
		test.log(LogStatus.INFO, "Successfully validated that user successfully logged in by valid credentials");
		Assert.assertEquals(pages.getLoginPage().VerifyUserLoggedINSuccessfully(), true,"User is not able to logg in by WOOD123456/Wood@098 ");
	
		test.log(LogStatus.INFO, "Successfully Clicked On Change Password button");
		pages.getBasicControllerPage().CliCkOnAnyUserDropDownButton("Change Password");
		
		test.log(LogStatus.INFO, "Sucessfully Entered the default text values in all the Password fields.");
		pages.getChangePasswordPage().SetPasswordsField("Wood@099", "Pass@123", "Pass@123");
		
		test.log(LogStatus.INFO, "Successfully clicked on Change Password Button");
		pages.getChangePasswordPage().CLickOnChangePAsswordButton();
		
		
		test.log(LogStatus.INFO, "Successfully entered Valid New credentials and clicked on Login Button");
		pages.getLoginPage().LoginToOPDEMRwithCredentials("WHD0001", "Pass@123");
		
		
		test.log(LogStatus.INFO, "Successfully validated that user successfully logged in by valid credentials");
		Assert.assertEquals(pages.getLoginPage().VerifyUserLoggedINSuccessfully(), true,"User is not able to logg in by WHD0001/Pass@123 ");

	}
	

	@Test(priority = 1)
	public void VerifyLoginByMobileNumber()throws Exception
	{
		
		test = extent.startTest("Verify the login by Mobile Number Functionality");
		test.log(LogStatus.INFO, "Successfully loaded login page of OPDEMR Application");
		pages.getLoginPage().LoadToOPDEMR();
		
		
		pages.getLoginPage().ClickOnClickHereLink();
		
		pages.getLoginPage().SetMobileNUmberFieldwithValues("2563635681");
		
		pages.getLoginPage().ClickOnLoginButtonOnLoginMobileScreen();
		
		pages.getLoginPage().getOtPNumber();
		
	}


	
	








}
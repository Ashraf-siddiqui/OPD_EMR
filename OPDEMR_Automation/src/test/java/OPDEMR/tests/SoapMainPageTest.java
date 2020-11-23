package OPDEMR.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import OPDEMR.pages.LoginPage;

public class SoapMainPageTest extends BaseTest{
	private static Logger Log = LogManager.getLogger(LoginPage.class.getName());



  
	
	@Test
	public void VerifyElementsPresentOnSoapMainPage() throws Exception {
		test = extent.startTest("Verifying the complete flow for adding/deleting medicines tests under plan.");
		test.log(LogStatus.INFO, "Successfully loaded login page of OPDEMR Application");
		Log.info("Verify The Test Cases For OrderSet");
		pages.getLoginPage().LoadToOPDEMR();
		
		
		test.log(LogStatus.INFO, "Successfully Logged in to application.");
		pages.getLoginPage().LoginToOPDEMRwithCredentials("WOOD123456", "Wood@098");
		
	
	
		test.log(LogStatus.INFO, "Successfully Logged in to application.");
		pages.getLoginPage().LoginToOPDEMRwithCredentials("WOOD123456", "Wood@098");
		
		
		test.log(LogStatus.INFO, "Successfully Clicked On DashBoard Button");
		pages.getBasicControllerPage().ClickOnAnyMainMenuButton("DashBoard");
		
		
		
		test.log(LogStatus.INFO, "Successfully clicked on Hospital Card.");
		pages.getDashBoardPage().ClickOnHospitalCard();
		
		
		test.log(LogStatus.INFO, "Successfully Handled Dialouge Box");
		pages.getLoginPage().HandlePendingPatientsDialougeBox();
		
		
		test.log(LogStatus.INFO, "Successfully Clicked On Call_Next Button");
		pages.getBasicControllerPage().ClickOn_CallNext_Button();
		
		test.log(LogStatus.INFO, "Successfully Clicked On Assessment Button");
		pages.getSoapConfiguration_AssesmentPage().ClickOnAny_SOAP_Button("Plan");
		
		
	
		pages.getSoapMainPage().ClickOnContinueButtonUntilReachToMainPage();
	
	
	
		
	
	
	
	
	
	
	
	
	
	
	
	}
	
}



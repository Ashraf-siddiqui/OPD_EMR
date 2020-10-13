package OPDEMR.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import OPDEMR.pages.LoginPage;

public class SoapConfiguration_AssesmentTest extends BaseTest{
	private static Logger Log = LogManager.getLogger(LoginPage.class.getName());



  
	
	@Test
	public void VerifyTheTestCasesForSOAP_Plan() throws Exception {
		test = extent.startTest("Verifying the basic functionality of Order Sets");
		test.log(LogStatus.INFO, "Successfully loaded login page of OPDEMR Application");
		Log.info("Verify The Test Cases For OrderSet");
		pages.getLoginPage().LoadToOPDEMR();
		
		
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
		pages.getSoapConfiguration_AssesmentPage().ClickOnAny_SOAP_Button("P");
		
		test.log(LogStatus.INFO, "Successfully Added Medicines");
		pages.getTemplatesPages().AddMedicineswithTaperDose("Althrocin 500 Tablet");
		
		test.log(LogStatus.INFO, "Successfully Handled Drug Interaction Alert Box.");
		pages.getSoapConfiguration_AssesmentPage().Handle_Drug_Interaction_Alert_Box();
		
		test.log(LogStatus.INFO, "Successfully Clicked on edit button of desired medicine name.");
		pages.getSoapConfiguration_AssesmentPage().EditDesiredMedicine("Althrocin 500 Tablet");
		
		
		
		test.log(LogStatus.INFO, "Successfully Added Medicines");
		pages.getTemplatesPages().AddMedicineswithTaperDose("Althrocin 500 Tablet");
		

		test.log(LogStatus.INFO, "Successfully Handled Drug Interaction Alert Box.");
		pages.getSoapConfiguration_AssesmentPage().DeleteDesiredMedicine("Althrocin 500 Tablet");
		
		
		
	}
	
	
	@Test
	public void VerifyTheTestCasesForSOAP_Assesment() throws Exception {
		test = extent.startTest("Verifying the basic functionality of Order Sets");
		test.log(LogStatus.INFO, "Successfully loaded login page of OPDEMR Application");
		Log.info("Verify The Test Cases For OrderSet");
		pages.getLoginPage().LoadToOPDEMR();
		
		
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
		pages.getSoapConfiguration_AssesmentPage().ClickOnAny_SOAP_Button("A");
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
package OPDEMR.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import OPDEMR.pages.LoginPage;

public class Soap_PlanTest extends BaseTest {
	private static Logger Log = LogManager.getLogger(LoginPage.class.getName());

	@Test
	public void VerifyTheTestCasesForSOAP_PlanAccordingtoTestCase193To200() throws Exception {
		test = extent.startTest("Verifying the Test cases from 193 to 200");
		test.log(LogStatus.INFO, "Successfully loaded login page of OPDEMR Application");
		Log.info("Verify The Test Cases For Medicine Under SOAP configuration.");
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
		pages.getSoapConfiguration_AssesmentPage().ClickOnAny_SOAP_Button("Plan");

		test.log(LogStatus.INFO, "Successfully Clicked on Continue=> TC_195 ");
		pages.getSoapConfiguration_AssesmentPage().ClickOnContinueButton();

		test.log(LogStatus.INFO, "Successfully Clicked On Assessment Button");
		pages.getSoapConfiguration_AssesmentPage().ClickOnAny_SOAP_Button("Plan");

		pages.getSoapConfiguration_AssesmentPage().DeleteAllTheMedicines();

		test.log(LogStatus.INFO, "Successfully Added Medicines =>TestCase_193");
		pages.getTemplatesPages().AddMedicines("Disprin ", "");

		pages.getSoapConfiguration_AssesmentPage().DeleteAllTheMedicines();

		test.log(LogStatus.INFO, "Successfully Added Medicines =>TestCase_194");
		pages.getTemplatesPages().AddMedicines("Calpol Paediatric Drops", "PRN");

		test.log(LogStatus.INFO, "Successfully Added Medicines =>TestCase_195");
		pages.getTemplatesPages().AddMedicines("Dolo 500", "PRN");

		test.log(LogStatus.INFO, "Successfully Added Medicines");
		pages.getTemplatesPages().AddAMedicineToTest("Disprin ", "PRN");

		test.log(LogStatus.INFO, "Successfully Cleared the strength field which is mandatory");
		pages.getTemplatesPages().ChangeStrengthField("");

		test.log(LogStatus.INFO,
				"Successfully verified the add button is disable after the mandatory field is kept blank.=>196");
		Assert.assertFalse(pages.getTemplatesPages().VerifyStateOfAddButton());

		test.log(LogStatus.INFO, "Added a medicine with taper dose.=>198");
		pages.getTemplatesPages().AddMedicineswithTaperDose("acneguard");

		test.log(LogStatus.INFO, "Successfully Added Medicines");
		pages.getTemplatesPages().AddAMedicineToTest("gel", "");

		test.log(LogStatus.INFO, "Successfully Clicked on Clear Button.");
		pages.getTemplatesPages().ClickOnClearButton();

		test.log(LogStatus.INFO, "Successfully got a Test NameField.Testcase=>200");
		String str = pages.getTemplatesPages().getValueOfStrengthNameField();
		if (str.isEmpty()) {
			Assert.assertTrue(true);

		} else {
			Assert.assertTrue(false);
		}

	}

	
	@Test
	public void VerifyTheTestCasesForSOAP_PlanAccordingtoTestCase210to212()
	{
		
		test = extent.startTest("Verifying the basic Plan TestCAses from 210 to 212.");
		test.log(LogStatus.INFO, "Successfully loaded login page of OPDEMR Application");
		Log.info("Verify The Test Cases For Medicine Under SOAP configuration. from testcase 210 to ");
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
		pages.getSoapConfiguration_AssesmentPage().ClickOnAny_SOAP_Button("Plan");
		
		
		test.log(LogStatus.INFO, "Successfully Added Medicines =>TestCase_195");
		pages.getTemplatesPages().AddMedicines("Dolo 500", "PRN");

		test.log(LogStatus.INFO, "Successfully edited a Medicine");
		pages.getSoapConfiguration_AssesmentPage().EditDesiredMedicine("Dolo 500");
		
		test.log(LogStatus.INFO, "Successfully Clicked On Assessment Button");
		pages.getSoapConfiguration_AssesmentPage().ClickOnBackButton();
		
		
		test.log(LogStatus.INFO, "Successfully Clicked On Assessment Button");
		pages.getSoapConfiguration_AssesmentPage().ClickOnAny_SOAP_Button("Plan");
		
		
		test.log(LogStatus.INFO, "Successfully edited a Medicine");
		pages.getSoapConfiguration_AssesmentPage().EditDesiredMedicine("Dolo 500");
		
		
		
		test.log(LogStatus.INFO, "Successfully Cleared the strength field which is mandatory");
		pages.getTemplatesPages().ChangeStrengthField("100 mg");

		
		test.log(LogStatus.INFO, "Successfully Clicked on Add Medicine Button and saved a edited medicine.");
		pages.getTemplatesPages().CLickOnAddmedicineButton();
	

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

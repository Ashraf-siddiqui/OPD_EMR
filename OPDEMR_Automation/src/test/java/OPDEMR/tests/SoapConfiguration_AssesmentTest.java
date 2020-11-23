package OPDEMR.tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import OPDEMR.pages.LoginPage;
import OPDEMR.utils.TestUtils;

public class SoapConfiguration_AssesmentTest extends BaseTest{
	private static Logger Log = LogManager.getLogger(LoginPage.class.getName());



  
	
	@Test
	public void VerifyTheFlowOfAdding_DeletingMedicineAndTestUnderPlan() throws Exception {
		test = extent.startTest("Verifying the complete flow for adding/deleting medicines tests under plan.");
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
		pages.getSoapConfiguration_AssesmentPage().ClickOnAny_SOAP_Button("Plan");
		
		
		test.log(LogStatus.INFO, "Successfully Deleted a medicine.");
		pages.getSoapConfiguration_AssesmentPage().DeleteAllTheMedicines();
		
		
		test.log(LogStatus.INFO, "Successfully Added Medicines");
		pages.getTemplatesPages().AddMedicines("Disprin ");
		
		test.log(LogStatus.INFO, "Successfully Handled Drug Interaction Alert Box.");
		pages.getSoapConfiguration_AssesmentPage().Handle_Drug_Interaction_Alert_Box();
		
		test.log(LogStatus.INFO, "Successfully Clicked on Continue ");
		pages.getSoapConfiguration_AssesmentPage().ClickOnContinueButton();

		pages.getTemplatesPages().DeleteDesiredTest("SGPT (ALT)");
		
		test.log(LogStatus.INFO, "Successfully Added a Test. ");
		pages.getTemplatesPages().AddTest("Alt");
		
		
		test.log(LogStatus.INFO, "Successfully Clicked on Continue ");
		pages.getSoapConfiguration_AssesmentPage().ClickOnContinueButton();
		
		
		test.log(LogStatus.INFO, "Successfully Clicked On Confirmation Button.");
		pages.getSoapConfiguration_AssesmentPage().ClickOnContinueButton();
		
		
		
	}
	
	
	@Test
	public void VerifyTheTestCasesForSOAP_Plan_Adding_DeletingATestAndVerifyingIt() throws Exception {
		test = extent.startTest("Verifying the basic functionality of Adding Test.");
		test.log(LogStatus.INFO, "Successfully loaded login page of OPDEMR Application");
		Log.info("Verify The Test Cases For Assessment Under SOAP Module");
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
		
		
		
		
		test.log(LogStatus.INFO, "Successfully Clicked On Continue Button");
		pages.getSoapConfiguration_AssesmentPage().ClickOnContinueButton();
		
		test.log(LogStatus.INFO, "Successfully Deleted All the Tests.");
		pages.getSoapConfiguration_AssesmentPage().DeleteALLTest();
		
		
		test.log(LogStatus.INFO, "Successfully Added a Test.");
		pages.getTemplatesPages().AddTest(" HLA 1 D");
		
		TestUtils.sleep(5);
		
		test.log(LogStatus.INFO, "Successfully Verified a Test.");
		Assert.assertTrue(pages.getSoapConfiguration_AssesmentPage().VerifyTestPrsentInTableUnderTestPage("HLA 1 D"),"Test is not found");
		
		
		test.log(LogStatus.INFO, "Successfully Deleted a Test.");
		if(pages.getTemplatesPages().DeleteDesiredTest(" HLA 1 D"));
		{
		TestUtils.sleep(5);
		
		test.log(LogStatus.INFO, "Successfully Verified a Test has been deleted.");
		Assert.assertFalse(pages.getSoapConfiguration_AssesmentPage().VerifyTestPrsentInTableUnderTestPage(" HLA 1 D"),"Test is not found");
		}
		
		
	}

	@Test
	public void VerifyTheTestCasesForSoap_PlanOrderSetAndVerifyingThemOnMainPage()
	{
		test = extent.startTest("Verifying the basic functionality of Order Sets");
		test.log(LogStatus.INFO, "Successfully loaded login page of OPDEMR Application");
		Log.info("Verify The Test Cases For Plan Under SOAP Module");
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
		
		
		  test.log(LogStatus.INFO, "Successfully Deleted all medicine.");
		  pages.getSoapConfiguration_AssesmentPage().DeleteAllTheMedicines();
		  
		  
		  
		  test.log(LogStatus.INFO, "Successfully Clicked on Order Set Tab.");
		  pages.getSoapConfiguration_PlanPage().ClickOnOrderSetTab();
		  
		  test.log(LogStatus.INFO,
		  "Successfully got the first Order Set name from Order Set Tab."); String
		  FirstOrderSet=pages.getSoapConfiguration_PlanPage().getFirstOrderSetName();
		  
		  test.log(LogStatus.INFO,
		  "Successfully Clicked On View Button of "+FirstOrderSet+".");
		  pages.getSoapConfiguration_PlanPage().ClickOnViewBUttonOfDesiredElement(
		  FirstOrderSet);
		  
		  
		  test.log(LogStatus.INFO,
		  "Successfully Got All Medicine from ."+FirstOrderSet+".");
		  ArrayList<String>listOfMedicines=pages.getSoapConfiguration_PlanPage().
		  getAllMedicineListFromAOrderSet();
		  
		  test.log(LogStatus.INFO,
		  "Successfully Got All Tests from ."+FirstOrderSet+".");
		  ArrayList<String>listOfTest=pages.getSoapConfiguration_PlanPage().
		  getAllTestListFromAOrderSet();
		  
		  test.log(LogStatus.INFO,
		  "Successfully clicked on First Order Set CheckBox.");
		  pages.getSoapConfiguration_PlanPage().ClickOnDesiredOrderSetNameCheckbox(
		  FirstOrderSet);
		  
		  System.out.println("list of medicines--->"+listOfMedicines);
		  
		  System.out.println("list of Test--->"+listOfTest);
		  
		  test.log(LogStatus.INFO,
		  "Successfully Verified All the Medicines appearing on Medicine Page.");
		  for(String Medicine : listOfMedicines) {
		  Assert.assertTrue(pages.getSoapConfiguration_AssesmentPage().
		  VerifyMedicinePresentInTableUnderPlanPage(Medicine), Medicine+" not found");
		  }
		  
		  
		  test.log(LogStatus.INFO, "Successfully Clicked on Continue ");
		  pages.getSoapConfiguration_AssesmentPage().ClickOnContinueButton();
		  
		  
		  
		  test.log(LogStatus.INFO,
		  "Successfully Verified All the Medicines appearing on Medicine Page.");
		  for(String Test : listOfTest) {
		  Assert.assertTrue(pages.getSoapConfiguration_AssesmentPage().
		  VerifyTestPrsentInTableUnderTestPage(Test), Test+" not found"); }
		 
		test.log(LogStatus.INFO, "Successfully Clicked on Continue button. ");
		pages.getSoapMainPage().ClickOnContinueButtonUntilReachToMainPage();
		
		pages.getSoapMainPage().ClickOnMedicineCollapseOrExpandButton();
		
		
	Assert.assertTrue(pages.getSoapMainPage().VerifyMedicinesUnderPlanSection(listOfMedicines), "medicines does not match on Soap main page.");
		
	Assert.assertTrue(pages.getSoapMainPage().VerifyTestUnderPlanSection(listOfTest), "medicines does not match on Soap main page.");
		
		
	}
	
	
	@Test
	public void VerifyTheTestCasesForSoap_PlanInstructions()
	{
		test = extent.startTest("Verifying the test cases for Instructions.");
		test.log(LogStatus.INFO, "Successfully loaded login page of OPDEMR Application");
		Log.info("Verify The Test Cases For Instructions Page");
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
		
		test.log(LogStatus.INFO, "Successfully Clicked on Continue ");
		pages.getSoapConfiguration_AssesmentPage().ClickOnContinueButton();

		
		test.log(LogStatus.INFO, "Successfully Clicked on Continue ");
		pages.getSoapConfiguration_AssesmentPage().ClickOnContinueButton();

		test.log(LogStatus.INFO, "Successfully Counted All the Checkboxes.");
		pages.getSoapConfiguration_AssesmentPage().CountallCheckboxes();
		
		
		test.log(LogStatus.INFO, "successfully got FirstInstruction.");
		String FirstInstruction=pages.getSoapConfiguration_AssesmentPage().GetFirstInstruction();
		
		test.log(LogStatus.INFO, "Successfully Unchecked All the checkboxes.");
		pages.getSoapConfiguration_AssesmentPage().UncheckAllCheckBoxes();
		
		test.log(LogStatus.INFO, "successfully Searched for the instruction.");
		pages.getSoapConfiguration_AssesmentPage().SearchForInstructions(FirstInstruction);
		
		
		test.log(LogStatus.INFO, "successfully Validated the presence of the instruction on search.");
		Assert.assertTrue(pages.getSoapConfiguration_AssesmentPage().ValidateSeacrhedInstruction(FirstInstruction), "Instruction seacrh is not working.");
		
		
		
		test.log(LogStatus.INFO, "Successfully clicked on desired checkbox");
		pages.getSoapConfiguration_AssesmentPage().ClickOnCheckboxOfDesiredInstruction(FirstInstruction);
		
		
		
	}
	
	
	
	@Test
	public void VerifyTheTestCasesForRefrralPage() throws Exception {
		test = extent.startTest("Verifying the basic functionality of Refrral Page.");
		test.log(LogStatus.INFO, "Successfully loaded login page of OPDEMR Application");
		Log.info("Verify The Test Cases For Refrral Under SOAP Module");
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
		
		
		test.log(LogStatus.INFO, "Successfully Clicked on Continue button. ");
		pages.getSoapMainPage().ClickOnContinueButtonUntilReachToMainPage();
		
		
		pages.getReferralPage().ClickOnReferralArrow();
		
		test.log(LogStatus.INFO, "Successfully Deleted all medicine.");
		pages.getReferralPage().DeleteAllReffrealsFromTable();
		  
		
		pages.getReferralPage().SelectSpecialityValueFromDropdown("Woodlandd-speciality");
		
		
		pages.getReferralPage().EnterDoctorNote("Test Note For Doctor");
		
		pages.getReferralPage().clickonSaveButton();
		
		pages.getReferralPage().waitforvisibilityOfTable();
		
		Assert.assertTrue(pages.getReferralPage().VerifySpecialityUnderTable("Woodlandd-speciality"), "Did not found the refrreal under the table..");
		
	}
	
	
	
	
	@Test
	public void VerifyTheTestCasesForRefrralPageByDoctor() throws Exception {
		test = extent.startTest("Verifying the basic functionality of Refrral Page BY doctor.");
		test.log(LogStatus.INFO, "Successfully loaded login page of OPDEMR Application");
		Log.info("Verify The Test Cases For Refrral By Doctor Under SOAP Module");
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
		
		
		test.log(LogStatus.INFO, "Successfully Clicked on Continue button. ");
		pages.getSoapMainPage().ClickOnContinueButtonUntilReachToMainPage();
		
		
		pages.getReferralPage().ClickOnReferralArrow();
		
		
		pages.getReferralPage().ClickOnByDoctorTab();
		
		
		pages.getReferralPage().ClickonBySpecialityTab();
		
		pages.getReferralPage().ClickOnByDoctorTab();
		
		test.log(LogStatus.INFO, "Successfully Deleted all medicine.");
		pages.getReferralPage().DeleteAllReffrealsFromTable();
		pages.getReferralPage().AddDoctor("Ashraf");
		

		pages.getReferralPage().EnterDoctorNoteByDoctor("Test Note For Doctor");

		pages.getReferralPage().clickonSaveButtonByDoctor();
		
		pages.getReferralPage().waitforvisibilityOfTable();
		
		
		Assert.assertTrue(pages.getReferralPage().VerifySpecialityUnderTableByDoctor("Ashraf Siddiqui"), "Did not found Doctor Name under reffreal table..");
		
		
	}
	
	
}

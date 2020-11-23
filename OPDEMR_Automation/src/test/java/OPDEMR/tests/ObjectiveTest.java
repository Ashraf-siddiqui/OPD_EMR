package OPDEMR.tests;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import OPDEMR.pages.LoginPage;
import OPDEMR.utils.TestUtils;

public class ObjectiveTest extends BaseTest {
	private static Logger Log = LogManager.getLogger(LoginPage.class.getName());

	@Test
	public void VerifyTheFlowOfAddingVitalsUnderObjective() throws Exception {
		test = extent.startTest("Verifying the complete flow for adding vitals under objective.");
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
		pages.getSoapConfiguration_AssesmentPage().ClickOnAny_SOAP_Button("Obj");
		
		
		
		
		test.log(LogStatus.INFO, "Successfully Clicked On Add Vitals Button");
		pages.getObjectivePage().CLickOnAddVitalsButton();
		
		ArrayList<String>VitalsDetails=new ArrayList<String>();
		VitalsDetails.add("170");
		VitalsDetails.add("65");
		VitalsDetails.add(pages.getObjectivePage().getBmi());
		VitalsDetails.add("38");
		VitalsDetails.add("21");
		VitalsDetails.add("270");
		VitalsDetails.add("11");
		VitalsDetails.add("67");
		VitalsDetails.add("18");
		VitalsDetails.add("88");
		VitalsDetails.add("455");
		
		ArrayList<String>VitalsDetails2=new ArrayList<String>();
		test.log(LogStatus.INFO, "Successfully Add All Entries for vitals");
		pages.getObjectivePage().AddVitalsEntries(VitalsDetails);
		
		test.log(LogStatus.INFO, "Successfully Clicked on Confirm Button.");
		pages.getObjectivePage().ClickOnConfirmVitalButton();
		
		TestUtils.sleep(10);
		test.log(LogStatus.INFO, "Successfully Add All Entries for vitals");
		VitalsDetails2=pages.getObjectivePage().GetVitalsDetailsFromObjectivePage();
		System.out.println("vitals details "+VitalsDetails2);
		
		Assert.assertTrue(pages.getObjectivePage().VerifyAllThe(VitalsDetails, VitalsDetails2), "Vitals Entries not matched.");
		
	}

	
	@Test
	public void VerifyTheFlowOfstateOfAllergiesButtonWhenKnownAllergiesCheckboxIsCheckedUnderObjective() throws Exception {
		test = extent.startTest("Verifying the complete flow for adding vitals under objective.");
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
		pages.getSoapConfiguration_AssesmentPage().ClickOnAny_SOAP_Button("Obj");
		
		test.log(LogStatus.INFO, "Successfully Deleted All the Allergies.");
		pages.getObjectivePage().DeleteALLAllergies();
		
		test.log(LogStatus.INFO, "Successfully Clicked On Add Allergies Button");
		pages.getObjectivePage().ClickOnAllergiesCheckBox("Checked");
		
		
		test.log(LogStatus.INFO, "Successfully Verified the state of Allergies button when known allergies  checkbox is checked");
		Assert.assertTrue(!pages.getObjectivePage().VerifyStateOfAddAllergiesButton(), "Allergies button is clickable regardless the known allergies checkbox is checked.");
		
		
	}

	
	@Test
	public void VerifyTheFlowOfAddingAndEditingOfDrugsUnderAllergies() throws Exception {
		test = extent.startTest("Verifying the complete flow for adding vitals under objective.");
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
		pages.getSoapConfiguration_AssesmentPage().ClickOnAny_SOAP_Button("Obj");
		
		
		test.log(LogStatus.INFO, "Successfully Deleted All the Allergies.");
		pages.getObjectivePage().DeleteALLAllergies();
	
		test.log(LogStatus.INFO, "Successfully Clicked On Add Allergies Button");
		pages.getObjectivePage().ClickOnAddAllergiesButton();
	
	
		test.log(LogStatus.INFO, "Successfully Clicked On Add Allergies Button");
		pages.getObjectivePage().AddDrugUnderAllergies("Calamine", "Headache", "Moderate", "By Hospital");
	
	
		test.log(LogStatus.INFO, "Successfully Clicked On Save Allergies Button");
		pages.getObjectivePage().ClickOnSaveAllergiesButton();
	
		test.log(LogStatus.INFO, "Successfully Verified the added allergy caused by drug.");
		Assert.assertTrue(pages.getObjectivePage().VerifyNameOfDrugOnMainPage("Calamine"), "Name of Drug is not available on main page.");
		
		test.log(LogStatus.INFO, "Successfully Clicked on Edit button of desired Drug.");
		pages.getObjectivePage().ClickOnEditButtonOfDesiredDrug("Calamine");
		
		test.log(LogStatus.INFO, "Successfully Added a reaction.");
		pages.getObjectivePage().AddReaction("Second Reaction");
		
		test.log(LogStatus.INFO, "Successfully Clicked on Save Allergies button.");
		pages.getObjectivePage().ClickOnSaveAllergiesButton();
		
		test.log(LogStatus.INFO, "Successfully Verified the Reaction after editing the drug.");
		Assert.assertTrue(pages.getObjectivePage().VerifyReactionOfDrugOnMainPage("Calamine"), "Name of Drug is not available on main page.");
		
		
	}
	
	
	@Test
	public void VerifyTheFlowOfAddingAndEditingOfFoodUnderAllergies() throws Exception {
		test = extent.startTest("Verifying the complete flow for adding vitals under objective.");
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
		pages.getSoapConfiguration_AssesmentPage().ClickOnAny_SOAP_Button("Obj");
		
		
		test.log(LogStatus.INFO, "Successfully Deleted All the Allergies.");
		pages.getObjectivePage().DeleteALLAllergies();
	
		test.log(LogStatus.INFO, "Successfully Clicked On Add Allergies Button");
		pages.getObjectivePage().ClickOnAddAllergiesButton();
	
	
		test.log(LogStatus.INFO, "Successfully Clicked On Food Tab.");
		pages.getObjectivePage().ClickOnFoodTab();
		
		
		test.log(LogStatus.INFO, "Successfully Clicked On Food Tab.");
		pages.getObjectivePage().SetFoodName("Egg");
		
		
		test.log(LogStatus.INFO, "Successfully Added a reaction.");
		pages.getObjectivePage().AddReactionForFood("Egg Reaction");
		
		test.log(LogStatus.INFO, "Successfully Selected intensity.");
		pages.getObjectivePage().SelectIntensityForFood("High");
		
		test.log(LogStatus.INFO, "Successfully Clicked on Save Allergies button.");
		pages.getObjectivePage().ClickOnSaveAllergiesButton();
		
		test.log(LogStatus.INFO, "Successfully Verified the added allergy caused by drug.");
		Assert.assertTrue(pages.getObjectivePage().VerifyNameOfDrugOnMainPage("Egg"), "Name of Drug is not available on main page.");
		
		
		test.log(LogStatus.INFO, "Successfully Verified the Reaction after editing the drug.");
		Assert.assertTrue(pages.getObjectivePage().VerifyReactionOfDrugOnMainPage("Egg Reaction"), "Name of Drug is not available on main page.");
		
		
		test.log(LogStatus.INFO, "Successfully Clicked on Edit button of desired Drug.");
		pages.getObjectivePage().ClickOnEditButtonOfDesiredFood("Egg");
		
		test.log(LogStatus.INFO, "Successfully Added a reaction.");
		pages.getObjectivePage().AddReactionForFood("Hen Reaction");
		
		test.log(LogStatus.INFO, "Successfully Selected intensity.");
		pages.getObjectivePage().SelectIntensityForFood("Moderate");
		
		
		test.log(LogStatus.INFO, "Successfully Clicked on Save Allergies button.");
		pages.getObjectivePage().ClickOnSaveAllergiesButton();
		
		
		test.log(LogStatus.INFO, "Successfully Verified the Reaction after editing the drug.");
		Assert.assertTrue(pages.getObjectivePage().VerifyReactionOfDrugOnMainPage("Hen Reaction"), "Name of Hen Reaction is not available on main page.");
		
	}
	
	@Test
	public void VerifyTheFlowOfAddingAndEditingOfOtherUnderAllergies()
	{
		
		test = extent.startTest("Verifying the complete flow for adding vitals under objective.");
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
		pages.getSoapConfiguration_AssesmentPage().ClickOnAny_SOAP_Button("Obj");
		
		
		test.log(LogStatus.INFO, "Successfully Deleted All the Allergies.");
		pages.getObjectivePage().DeleteALLAllergies();
	
		test.log(LogStatus.INFO, "Successfully Clicked On Add Allergies Button");
		pages.getObjectivePage().ClickOnAddAllergiesButton();
	
	
		test.log(LogStatus.INFO, "Successfully Clicked On Others Tab.");
		pages.getObjectivePage().ClickOnOthersTab();
		
		test.log(LogStatus.INFO, "Successfully Others name has been published.");
		pages.getObjectivePage().SetOthersName("Sunlight");
		
		
		test.log(LogStatus.INFO, "Successfully Added Reaction.");
		pages.getObjectivePage().AddReactionForOthers("Vitamin D");
		
		
		test.log(LogStatus.INFO, "Successfully Selected intensity for others.");
		pages.getObjectivePage().SelectIntensityForOthers("Moderate");
		
		
		test.log(LogStatus.INFO, "Successfully Clicked on Save Allergies button.");
		pages.getObjectivePage().ClickOnSaveAllergiesButton();
		
		
		test.log(LogStatus.INFO, "Successfully Verified the added allergy.");
		Assert.assertTrue(pages.getObjectivePage().VerifyNameOfDrugOnMainPage("Sunlight"), "Name of Drug is not available on main page.");
		
		
		test.log(LogStatus.INFO, "Successfully Verified the Reaction after editing.");
		Assert.assertTrue(pages.getObjectivePage().VerifyReactionOfDrugOnMainPage("Vitamin D"), "Name of Reaction is not available on main page.");
		
		
		
		test.log(LogStatus.INFO, "Successfully Clicked on Edit button of desired Others.");
		pages.getObjectivePage().ClickOnEditButtonOfDesiredOthers("Sunlight");
		
		
		test.log(LogStatus.INFO, "Successfully Added Reaction.");
		pages.getObjectivePage().AddReactionForOthers("Vitamin Edited");
		
		test.log(LogStatus.INFO, "Successfully Clicked on Save Allergies button.");
		pages.getObjectivePage().ClickOnSaveAllergiesButton();
		
		
		test.log(LogStatus.INFO, "Successfully Verified the Reaction after editing.");
		Assert.assertTrue(pages.getObjectivePage().VerifyReactionOfDrugOnMainPage("Vitamin Edited"), "Name of Reaction is not available on main page.");
		
		
	}

	
	@Test
	public void VerifyTheFlowOfNoKnownExistingConditionsUnderConditions()
	{
		
		test = extent.startTest("Verifying the complete flow for adding vitals under objective.");
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
		pages.getSoapConfiguration_AssesmentPage().ClickOnAny_SOAP_Button("Obj");
		
	
		test.log(LogStatus.INFO, "Successfully Deleted All the Existing Conditions.");
		pages.getObjectivePage().DeleteAllExistingConditions();
		
		
		test.log(LogStatus.INFO, "Successfully Clicked on the Condition Checkbox..");
		pages.getObjectivePage().ClickOnNoKnownExistingConditions("Checked");
		
		
		test.log(LogStatus.INFO, "Successfully Verified the Condition Checkbox..");
		Assert.assertTrue(!pages.getObjectivePage().GetStatusOfConditionButton(), "Check of condition is not working properly.");
		
	
	}

	@Test
	public void VerifyTheFlowOfAddingAndEditingOfConditions()
	{
		
		test = extent.startTest("Verifying the complete flow for adding vitals under objective.");
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
		pages.getSoapConfiguration_AssesmentPage().ClickOnAny_SOAP_Button("Obj");
		
		test.log(LogStatus.INFO, "Successfully Deleted All the Existing Conditions.");
		pages.getObjectivePage().DeleteAllExistingConditions();

		test.log(LogStatus.INFO, "Successfully Clicked on Conditions Button.");
		pages.getObjectivePage().ClickOnAddConditionButton();
		
		
		test.log(LogStatus.INFO, "Successfully Selected condition.");
		pages.getObjectivePage().SetCondition("HyperTension");
	
	
		test.log(LogStatus.INFO, "Successfully Selected Duration.");
		pages.getObjectivePage().SelectDuration("Months", "1");
		
		
		test.log(LogStatus.INFO, "Successfully Selected Medication.");
		pages.getObjectivePage().SelectMedication("Yes");
		
		
		test.log(LogStatus.INFO, "Successfully Clicked on Save Condition Button.");
		pages.getObjectivePage().ClickOnSaveConditionButton();
		
		
		
		
		
		
		
		
		
	
	
	}
	
	
	
}

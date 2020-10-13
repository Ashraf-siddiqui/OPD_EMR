package OPDEMR.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.base.CharMatcher;
import com.relevantcodes.extentreports.LogStatus;

import OPDEMR.pages.LoginPage;

public class SearchTest extends BaseTest{

	private static Logger Log = LogManager.getLogger(LoginPage.class.getName());
	
	
	
	
	@Test(priority = 1)
	public void VerifyValidationMessagesOfSeacrhPages() throws Exception {
		test = extent.startTest("User login for OPDEMR Application");
		test.log(LogStatus.INFO, "Successfully loaded login page of OPDEMR Application");
		pages.getLoginPage().LoadToOPDEMR();
	
		test.log(LogStatus.INFO, "Successfully entered Valid credentials and clicked on Login Button");
		pages.getLoginPage().LoginToOPDEMRwithCredentials("WOOD123456", "Wood@098");
		
	
//		test.log(LogStatus.INFO, "Successfully Clicked On DashBoard Button");
//		pages.getBasicControllerPage().ClickOnAnyMainMenuButton("DashBoard");
//		
//		
//		test.log(LogStatus.INFO, "Successfully Clicked On Hospital Card");
//		pages.getDashBoardPage().ClickOnHospitalCard();
//		
//		test.log(LogStatus.INFO, "Successfully Clicked On Pending Patients Dialouge Box");
//		pages.getBasicControllerPage().HandlePendingPatientsDialougeBox();
		
		
//		String UHID=pages.getDashBoardPage().getFirstUHID();
//		String Name=pages.getDashBoardPage().getFirstUHIDName();
//		
		
		test.log(LogStatus.INFO, "Successfully Clicked On Search Button");
		pages.getBasicControllerPage().ClickOnAnyMainMenuButton("Search");
		
		
		test.log(LogStatus.INFO, "Successfully Entered the Invalid Patient Name and Searched for the Name.");
		pages.getSearchPatientPage().EnterPatientNameAndSeacrch("assasddwwq");
		
		
		test.log(LogStatus.INFO, "Successfully validated error message on searching for Invalid Name.");
		Assert.assertEquals(pages.getSearchPatientPage().VerifyErrorToastMessage(), true,"Validation error message is not displayed in minimal wait time");
	
		
		
		
		test.log(LogStatus.INFO, "Successfully Entered And Searched For the Invalid UHID .");
		pages.getSearchPatientPage().EnterUHIDOrPhoneNumberAndSeacrch("9878787878");
		
		
		test.log(LogStatus.INFO, "Successfully validated error message on searching for Invalid Name.");
		Assert.assertEquals(pages.getSearchPatientPage().VerifyErrorToastMessage(), true,"Validation error message is not displayed in minimal wait time");
	
	}
	
	
	@Test(priority = 1)
	public void VerifySeacrhFunctionalityOfSeacrhPages() throws Exception {
		test = extent.startTest("User login for OPDEMR Application");
		test.log(LogStatus.INFO, "Successfully loaded login page of OPDEMR Application");
		pages.getLoginPage().LoadToOPDEMR();
	
		test.log(LogStatus.INFO, "Successfully entered Valid credentials and clicked on Login Button");
		pages.getLoginPage().LoginToOPDEMRwithCredentials("WOOD123456", "Wood@098");
		
	
		test.log(LogStatus.INFO, "Successfully Clicked On DashBoard Button");
		pages.getBasicControllerPage().ClickOnAnyMainMenuButton("DashBoard");
		
		
		test.log(LogStatus.INFO, "Successfully Clicked On Hospital Card");
		pages.getDashBoardPage().ClickOnHospitalCard();
		
		test.log(LogStatus.INFO, "Successfully Clicked On Pending Patients Dialouge Box");
		pages.getBasicControllerPage().HandlePendingPatientsDialougeBox();
		
		
		String UHID=CharMatcher.anyOf("UHID ").removeFrom(pages.getDashBoardPage().getFirstUHID());
		String Name=pages.getDashBoardPage().getFirstUHIDName();
		
		
		System.out.println("--------------------------->UHID - "+UHID);


		System.out.println("--------------------------->Name - "+Name);
		
		test.log(LogStatus.INFO, "Successfully Clicked On Search Button");
		pages.getBasicControllerPage().ClickOnAnyMainMenuButton("Search");
		
		
		test.log(LogStatus.INFO, "Successfully clicked on Search button with blank Inputs.");
		pages.getSearchPatientPage().EnterPatientNameAndSeacrch("");
		
		test.log(LogStatus.INFO, "Successfully verified the error message for the Balnk Fields.");
		softAssert.assertEquals(pages.getSearchPatientPage().VerifyErrorToastMessage(), true,"Validation error is not showing up on the seacrhing with blank inputs");
		
		
		
		test.log(LogStatus.INFO, "Successfully Entered the Invalid Patient Name and Searched for the Name.");
		pages.getSearchPatientPage().EnterPatientNameAndSeacrch(Name);
		
		
		test.log(LogStatus.INFO, "Successfully Entered And Searched For the Invalid UHID .");
		pages.getSearchPatientPage().EnterUHIDOrPhoneNumberAndSeacrch(UHID);
		
		test.log(LogStatus.INFO, "Successfully Verified the Patient on Patient Seacrh page.");	
		softAssert.assertEquals(pages.getSearchPatientPage().VerifyPatientCardPresentONSearchPatientPage(Name, UHID), true,"Patient is not found with "+UHID+" and "+"Name- "+Name);
		
		
		test.log(LogStatus.INFO, "Successfully Entered And Searched For the Invalid Phone Number.");
		pages.getSearchPatientPage().EnterUHIDOrPhoneNumberAndSeacrch("98989898989");
		
		
		test.log(LogStatus.INFO, "Successfully verified the error message for the Invalid Phone Number.");
		softAssert.assertEquals(pages.getSearchPatientPage().VerifyErrorToastMessage(), true,"Patient is not found with "+UHID+" and "+"Name- "+Name);
		
		
		test.log(LogStatus.INFO, "Successfully Entered the Invalid Patient Name and Searched for the Name.");
		pages.getSearchPatientPage().EnterPatientNameAndSeacrch("");
		
		
		test.log(LogStatus.INFO, "Successfully Entered And Searched For the Invalid UHID .");
		pages.getSearchPatientPage().EnterUHIDOrPhoneNumberAndSeacrch(UHID);
		
		test.log(LogStatus.INFO, "Successfully Verified the Patient on Patient Seacrh page.");	
		softAssert.assertEquals(pages.getSearchPatientPage().VerifyPatientCardPresentONSearchPatientPage("", UHID), true,"Patient is not found with by searching only with "+UHID);
		
		softAssert.assertAll();
		
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

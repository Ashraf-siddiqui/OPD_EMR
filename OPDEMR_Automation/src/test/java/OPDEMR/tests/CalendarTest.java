package OPDEMR.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import OPDEMR.pages.LoginPage;
import OPDEMR.utils.DataUtils;
import OPDEMR.utils.TestUtils;

public class CalendarTest extends BaseTest{
	
	
private static Logger Log = LogManager.getLogger(LoginPage.class.getName());

     String firstName="Ashraf",
lastName="Test",time="";
	
	
	@Test(priority = 1)
	public void BookSlotForAPatient() throws Exception {
		test = extent.startTest("Book Slot For A Patient In OPDEMR Application");
		test.log(LogStatus.INFO, "Successfully loaded login page of OPDEMR Application");
		Log.info("part--------------------------------->1");
		pages.getLoginPage().LoadToOPDEMR();
	
	
		test.log(LogStatus.INFO, "Successfully Logged in to application.");
		pages.getLoginPage().LoginToOPDEMRwithCredentials("WOOD123456", "Wood@098");
	
	
		test.log(LogStatus.INFO, "Successfully clicked on My Calendar button.");
		pages.getBasicControllerPage().ClickOnAnyMainMenuButton("My Calendar");
		
		TestUtils.sleep(10);
		test.log(LogStatus.INFO, "Successfully clicked on Mark Leave Tab.");
		pages.getCalendarPage().ClickOnDesiredTab("Mark Leave");
	
		test.log(LogStatus.INFO, "Successfully clicked on Book Slots Tab.");
		pages.getCalendarPage().ClickOnDesiredTab("Book Slots");
		
		
		test.log(LogStatus.INFO, "Successfully clicked on Available Slots.");
		time=pages.getCalendarPage().ClickOnAvailableSlots();
		
		System.out.println("time is ----------->>>>>"+time);
		
		test.log(LogStatus.INFO, "Successfully filled Patients Details Form.");
		pages.getCalendarPage().FillPatientDetailsForm(TestUtils.generate10DigitNumberNewMethod(),firstName,lastName);
		
		test.log(LogStatus.INFO, "Successfully clicked on Confirm Button.");
		pages.getCalendarPage().ConfirmTheSlot();
	

//		TestUtils.sleep(10);
//		System.out.println("name of the patient to be seacrhed>------>>>>>>>>"+firstName+" "+lastName);
//		test.log(LogStatus.INFO, "Successfully Verified Patient Name Under Patient Tab");
//		Assert.assertEquals(pages.getCalendarPage().VerifyPatientNameUnderPatientTab(firstName+" "+lastName, time), true,"User is not present under patient Tab.");
//	
		
	}
	
	
	

	@Test(dependsOnMethods = "BookSlotForAPatient")
	public void RescheduleBookedSlotForAPatient() throws Exception {
		test = extent.startTest("Book Slot For A Patient In OPDEMR Application");
		test.log(LogStatus.INFO, "Successfully loaded login page of OPDEMR Application");
		pages.getLoginPage().LoadToOPDEMR();
	
	
		test.log(LogStatus.INFO, "Successfully Logged in to application.");
		pages.getLoginPage().LoginToOPDEMRwithCredentials("WOOD123456", "Wood@098");
	
	
		test.log(LogStatus.INFO, "Successfully clicked on My Calendar button.");
		pages.getBasicControllerPage().ClickOnAnyMainMenuButton("My Calendar");
		
		TestUtils.sleep(10);
	
	
	
		test.log(LogStatus.INFO, "Successfully clicked on Confirmed button under patient tab.");
		pages.getCalendarPage().ClickOnConfirmButtonUnderPatientTab(firstName+" "+lastName, time);
	
	
		
	
		test.log(LogStatus.INFO, "Successfully clicked on Reschedule button.");
		pages.getCalendarPage().ClickOnRescheduleButton();
		
		TestUtils.sleep(5);
	
		System.out.println("new booked slot ------------->"+time);
		test.log(LogStatus.INFO, "Successfully clicked on Available Slots.");
		time=pages.getCalendarPage().ClickOnAvailableSlots();
	
		System.out.println("new booked slot ------------->"+time);
	
		test.log(LogStatus.INFO, "Successfully Verified Patient Name Under Patient Tab");
		Assert.assertEquals(pages.getCalendarPage().VerifyPatientNameUnderPatientTab(firstName+" "+lastName, time), true,firstName+" is not present under patient Tab.");

	}
	
	
	
	
	@Test
	public void BlockSlotForAPatient() throws Exception {
		test = extent.startTest("Block And Unblock a slot for patient.");
		test.log(LogStatus.INFO, "Successfully loaded login page of OPDEMR Application");
		pages.getLoginPage().LoadToOPDEMR();
	
	
		test.log(LogStatus.INFO, "Successfully Logged in to application.");
		pages.getLoginPage().LoginToOPDEMRwithCredentials("WOOD123456", "Wood@098");
	
	
		test.log(LogStatus.INFO, "Successfully clicked on My Calendar button.");
		pages.getBasicControllerPage().ClickOnAnyMainMenuButton("My Calendar");
		
		TestUtils.sleep(10);
	
	
		test.log(LogStatus.INFO, "Successfully clicked on Book Slots Tab.");
		pages.getCalendarPage().ClickOnDesiredTab("Block Slots");
		
	
	
		test.log(LogStatus.INFO, "Successfully clicked on Available Slots.");
		time=pages.getCalendarPage().ClickOnAvailableSlots();
	
	
	
		test.log(LogStatus.INFO, "Successfully entered reason for Block.");	
		pages.getCalendarPage().EnterReasonForBlock("Blocked for testing.");
		
		
		test.log(LogStatus.INFO, "Successfully clicked on Blocked Button and verified the notification.");
		pages.getCalendarPage().ClickOnBlockButton();
	
		
		test.log(LogStatus.INFO, "Successfully clicked on a Blocked Slot.");
		pages.getCalendarPage().ClickOnABlockedSlot(time);
	
		test.log(LogStatus.INFO, "Successfully entered reason for unblock.");		
		pages.getCalendarPage().EnterReasonForBlock("Unblocked for Testing purpose.");
		
		
		test.log(LogStatus.INFO, "Successfully clicked on UnBlocked Button and verified the notification.");
		pages.getCalendarPage().ClickOnBlockButton();
		
		
	}
	
	
	
	
	
	
	
}

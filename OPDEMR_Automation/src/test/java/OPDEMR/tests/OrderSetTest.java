package OPDEMR.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import OPDEMR.pages.LoginPage;
import OPDEMR.utils.TestUtils;

public class OrderSetTest extends BaseTest{

	
	
	
private static Logger Log = LogManager.getLogger(LoginPage.class.getName());



     String NameOfOrderSet="Test OrderSet 1st Oct";
	
	@Test
	public void VerifyTheTestCasesForOrderSet() throws Exception {
		test = extent.startTest("Verifying the basic functionality of Order Sets");
		test.log(LogStatus.INFO, "Successfully loaded login page of OPDEMR Application");
		Log.info("Verify The Test Cases For OrderSet");
		pages.getLoginPage().LoadToOPDEMR();
		
		
		test.log(LogStatus.INFO, "Successfully Logged in to application.");
		pages.getLoginPage().LoginToOPDEMRwithCredentials("WOOD123456", "Wood@098");
		
		
		test.log(LogStatus.INFO, "Successfully Hovered on OrderSets and Clicked on ");
		pages.getOrderSetPage().HoverOnOrderSetsAndClickOnSpecifiedButton();
	
		
		test.log(LogStatus.INFO, "got first name from OrderSet table");
		String NameOfOrderSet=pages.getOrderSetPage().GetFirstOrderSetFromOrderSetsTable();
	
	
		test.log(LogStatus.INFO, "Successfully entered the "+NameOfOrderSet+" in search box.");
		pages.getOrderSetPage().SearchForOrderSetOrMedicine(NameOfOrderSet);
		
		
		test.log(LogStatus.INFO, "got first name from Order Set table");
		String NameOfOrderSet2=pages.getOrderSetPage().GetFirstOrderSetFromOrderSetsTable();
	
	
	
		test.log(LogStatus.INFO, "Search is working for OrderSet Name.");
		Assert.assertTrue(NameOfOrderSet.equals(NameOfOrderSet2), "Search is not working for OrderSet.");
		
		
		
		test.log(LogStatus.INFO, "Successfully fetched class name of star icon.");
		 String className1=pages.getOrderSetPage().GetclassNameofDesiredOrderSet(NameOfOrderSet);
	     
		
		 test.log(LogStatus.INFO, "Clicked on Star Icon Of first OrderSet");
		 String className2=	pages.getOrderSetPage().ClickOnStarIconAndReturnClassOfDesiredOrderSetName(NameOfOrderSet);
			
		 Assert.assertEquals(className1.equals(className2),false, "favorite icon is not getting star marked.");
			
	}
	
	
	@Test
	public void VerifyCreatedOrderSetAndDeleteIfAlreadyPresent() throws Exception {
		test = extent.startTest("Verifying the basic functionality of Order Sets");
		test.log(LogStatus.INFO, "Successfully loaded login page of OPDEMR Application");
		Log.info("part--------------------------------->1");
		pages.getLoginPage().LoadToOPDEMR();
		
		test.log(LogStatus.INFO, "Successfully Logged in to application.");
		pages.getLoginPage().LoginToOPDEMRwithCredentials("WOOD123456", "Wood@098");
	
		test.log(LogStatus.INFO, "Successfully Hovered on OrderSets and Clicked on ");
		pages.getOrderSetPage().HoverOnOrderSetsAndClickOnSpecifiedButton();
	
		
		test.log(LogStatus.INFO, "OrderSet has been deleted successfully if it has been present");
		if(pages.getOrderSetPage().VerifyAndDeleteTheOrderSetIfAlreadyPresent(NameOfOrderSet))
			{
			
			test.log(LogStatus.INFO, "Deleted OrderSet has been verified that it is has been successfully deleted.");
			Assert.assertEquals(pages.getOrderSetPage().VerifyTheCreatedOrderSet(NameOfOrderSet), false,"OrderSet is not deleted.");
		
			}
		
         
		
	}

	
	
	@Test
	public void CreateAOrderSet() throws Exception {
		test = extent.startTest("Verifying the basic functionality of Order Sets");
		test.log(LogStatus.INFO, "Successfully loaded login page of OPDEMR Application");
		Log.info("part--------------------------------->1");
		pages.getLoginPage().LoadToOPDEMR();
		
		
		test.log(LogStatus.INFO, "Successfully Logged in to application.");
		pages.getLoginPage().LoginToOPDEMRwithCredentials("WOOD123456", "Wood@098");
	
	
		
		test.log(LogStatus.INFO, "Successfully Hovered on OrderSets and Clicked on ");
		pages.getOrderSetPage().HoverOnOrderSetsAndClickOnSpecifiedButton();
	
		
		test.log(LogStatus.INFO, "Successfully Clicked on Create OrderSet Button. ");
		pages.getOrderSetPage().ClickOnCreateOrderSetButton();
		
		test.log(LogStatus.INFO, "Successfully Named the Order Set. ");
		
		pages.getOrderSetPage().SetOrderSetName(NameOfOrderSet);
		
		test.log(LogStatus.INFO, "Successfully Added Medicines");
		pages.getTemplatesPages().AddMedicineswithTaperDose("Alth");
		

		test.log(LogStatus.INFO, "Successfully Added a Test. ");
		pages.getTemplatesPages().AddTest("Alt");
		
		test.log(LogStatus.INFO, "Successfully Clicked on Save OrderSet Button. ");
		pages.getOrderSetPage().clickOnSaveOrderSetButton();
		
	}
	
	@Test
	public void VerifyCreatedOrderSet() throws Exception {
		test = extent.startTest("Verifying the basic functionality of Order Sets");
		test.log(LogStatus.INFO, "Successfully loaded login page of OPDEMR Application");
		Log.info("part--------------------------------->1");
		pages.getLoginPage().LoadToOPDEMR();
		
		test.log(LogStatus.INFO, "Successfully Logged in to application.");
		pages.getLoginPage().LoginToOPDEMRwithCredentials("WOOD123456", "Wood@098");
	
		test.log(LogStatus.INFO, "Successfully Hovered on OrderSets and Clicked on ");
		pages.getOrderSetPage().HoverOnOrderSetsAndClickOnSpecifiedButton();
	
		
		test.log(LogStatus.INFO, "Successfully verified the created OrderSet. ");
		Assert.assertEquals(pages.getOrderSetPage().VerifyTheCreatedOrderSet(NameOfOrderSet), true,"OrderSet is not present");
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

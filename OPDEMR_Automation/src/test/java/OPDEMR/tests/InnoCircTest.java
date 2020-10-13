package OPDEMR.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import OPDEMR.pages.LoginPage;

public class InnoCircTest  extends BaseTest{

	private static Logger Log = LogManager.getLogger(LoginPage.class.getName());

	@Test(priority = 1)
	public void InnoCircOPDEMR() throws Exception {
//This test will Create a group and verify those group users.
		
		
		
		test = extent.startTest("Regression TestCase for Group Management");
		test.log(LogStatus.INFO, "Successfully login to productivise Application");
	//	pages.getInnoCircPage().LoginToOPDEMR("WOOD123456","Wood@098");
	
	
	
	
	
	
	
	
	
	}
	
	
	
}

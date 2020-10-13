package OPDEMR.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import OPDEMR.pages.LoginPage;
import OPDEMR.utils.TestUtils;

public class TemplatesTest extends BaseTest{
	
	
private static Logger Log = LogManager.getLogger(LoginPage.class.getName());

	String NameOfTemplate="Test Template 22 sep";
	
	@Test(priority = 0)
	public void VerifyTheTestCasesForTemplateList() throws Exception {
		test = extent.startTest("Verifying the basic functionality of Template List");
		test.log(LogStatus.INFO, "Successfully loaded login page of OPDEMR Application");
		Log.info("running ");
		pages.getLoginPage().LoadToOPDEMR();
		
		
		test.log(LogStatus.INFO, "Successfully Logged in to application.");
		pages.getLoginPage().LoginToOPDEMRwithCredentials("WOOD123456", "Wood@098");
		
		test.log(LogStatus.INFO, "Hovered on Template Button and clicked on Speceified button");
		pages.getTemplatesPages().HoverOnTemplatesAndClickOnSpecifiedButton("Template List");
		
		
		test.log(LogStatus.INFO, "got first name from template table");
		String NameOfTemplate=pages.getTemplatesPages().GetFirstTemplateNameFromTemplatesTable();
		
		test.log(LogStatus.INFO, "got first name from template table");
		String NameOfDiagnosis=pages.getTemplatesPages().GetFirstDiagnosisFromTemplatesTable();
		
		test.log(LogStatus.INFO, "Successfully entered the "+NameOfTemplate+" in search box.");
		pages.getTemplatesPages().SearchForTemplate(NameOfTemplate);
		
		test.log(LogStatus.INFO, "got first name from template table");
		String NameOfTemplate2=pages.getTemplatesPages().GetFirstTemplateNameFromTemplatesTable();
		
		test.log(LogStatus.INFO, "Search is working for Template Name.");
		Assert.assertTrue(NameOfTemplate.equals(NameOfTemplate2), "Search is not working for template.");
		
		
		
		test.log(LogStatus.INFO, "Successfully entered the "+NameOfDiagnosis+" in search box.");
		pages.getTemplatesPages().SearchForTemplate(NameOfDiagnosis);
		
		
		test.log(LogStatus.INFO, "got first Diagnosis name from template table");
		String NameOfDiagnosis2=pages.getTemplatesPages().GetFirstDiagnosisFromTemplatesTable();
		
		test.log(LogStatus.INFO, "Search is working for Diagnosis.");
		Assert.assertTrue(NameOfDiagnosis.equals(NameOfDiagnosis2), "Search is not working for Diagnosis.");
		
		test.log(LogStatus.INFO, "Successfully cleared the test result.");
		pages.getTemplatesPages().clearTheSearchResult();
		
		test.log(LogStatus.INFO, "Successfully fetched class name of star icon.");
		 String className1=pages.getTemplatesPages().GetclassNameofDesiredTemplateName(NameOfTemplate2);
	     
		 System.out.println("------------------------------------------------------->>>>>>>>>>>>>>>>>>>>>>>"+className1);
		
		 test.log(LogStatus.INFO, "Clicked on Star Icon Of first Template");
		 String className2=	pages.getTemplatesPages().ClickOnStarIconAndReturnClassOfDesiredTemplateName(NameOfTemplate2);
		
			
		 System.out.println("------------------------------------------------------->>>>>>>>>>>>>>>>>>>>>>>"+className2);
		
		 Assert.assertEquals(className1.equals(className2),false, "favorite icon is not getting star marked.");
		 
		 
		 
		 
		 
		 
		 
		 
}
	
	
	@Test
	public void VerifyCreatedTemplateAndDeleteIfAlreadyExist() throws Exception {
		test = extent.startTest("Verifying a template and deleting if present.");
		test.log(LogStatus.INFO, "Successfully loaded login page of OPDEMR Application");
		Log.info("part--------------------------------->1");
		pages.getLoginPage().LoadToOPDEMR();
		
		
		test.log(LogStatus.INFO, "Successfully Logged in to application.");
		pages.getLoginPage().LoginToOPDEMRwithCredentials("WOOD123456", "Wood@098");
		
		test.log(LogStatus.INFO, "Hovered on Template Button and clicked on Speceified button");
		pages.getTemplatesPages().HoverOnTemplatesAndClickOnSpecifiedButton("Template List");
		
		test.log(LogStatus.INFO, "Template has been deleted successfully if it has been present");
		if(pages.getTemplatesPages().VerifyAndDeleteTheTemplateIfAlreadyPresent(NameOfTemplate));
		{
		TestUtils.sleep(3);
		test.log(LogStatus.INFO, "Deleted template has been verified that it is has been successfully deleted.");
		Assert.assertEquals(pages.getTemplatesPages().VerifyTheCreatedTemplate(NameOfTemplate), false,"Template is not deleted.");
		}
	}
	
	
	@Test(priority = 2)
	public void CreateATemplate() throws Exception {
		test = extent.startTest("Creating a template");
		test.log(LogStatus.INFO, "Successfully loaded login page of OPDEMR Application");
		Log.info("part--------------------------------->1");
		pages.getLoginPage().LoadToOPDEMR();
		
		
		test.log(LogStatus.INFO, "Successfully Logged in to application.");
		pages.getLoginPage().LoginToOPDEMRwithCredentials("WOOD123456", "Wood@098");
		
		test.log(LogStatus.INFO, "Hovered on Template Button and clicked on Speceified button");
		pages.getTemplatesPages().HoverOnTemplatesAndClickOnSpecifiedButton("Template List");
		
		test.log(LogStatus.INFO, "Successfully clicked on Create Template button.");
		pages.getTemplatesPages().ClickOnCreateTemplateButton();
		
		
		pages.getTemplatesPages().SetTemplateName(NameOfTemplate);
		
		test.log(LogStatus.INFO, "Successfully Verified that Save Button is Disabled.");
		Assert.assertFalse(pages.getTemplatesPages().VerifyStateOfSaveBUtton(), "Save button is enabled without entering the data into mandatory field.");
		
		
		test.log(LogStatus.INFO, "Successfully Added diagnosis.");
		pages.getTemplatesPages().AddDiagnosis("FLU");	
		
		TestUtils.sleep(5);
		test.log(LogStatus.INFO, "Successfully Clicked on Add diagnosis button.");
		pages.getTemplatesPages().ClickOnAddDiagnosisButton();
		
		
		test.log(LogStatus.INFO, "Successfully Clicked on Delete Action Button.");
		pages.getTemplatesPages().ClickOnDeleteButtonOfDiagnosis();
		
		
		
		test.log(LogStatus.INFO, "Successfully Added diagnosis.");
		pages.getTemplatesPages().AddDiagnosis("sar");	
		
		TestUtils.sleep(5);
		test.log(LogStatus.INFO, "Successfully Clicked on Add diagnosis button.");
		pages.getTemplatesPages().ClickOnAddDiagnosisButton();
		
		
		test.log(LogStatus.INFO, "Successfully Added Medicines");
		pages.getTemplatesPages().AddMedicineswithTaperDose("Alth");
		

		test.log(LogStatus.INFO, "Successfully Added a Test. ");
		pages.getTemplatesPages().AddTest("Alt");
		
		
		test.log(LogStatus.INFO, "Successfully Clicked On Save Template Button. ");
		pages.getTemplatesPages().ClickOnSaveTemplateButton();
		
		
	}
	
	
	
	@Test(priority = 3)
	public void VerifyCreatedTemplate() throws Exception {
		test = extent.startTest("Verifying a template");
		test.log(LogStatus.INFO, "Successfully loaded login page of OPDEMR Application");
		Log.info("part--------------------------------->1");
		pages.getLoginPage().LoadToOPDEMR();
		
		
		test.log(LogStatus.INFO, "Successfully Logged in to application.");
		pages.getLoginPage().LoginToOPDEMRwithCredentials("WOOD123456", "Wood@098");
		
		test.log(LogStatus.INFO, "Hovered on Template Button and clicked on Speceified button");
		pages.getTemplatesPages().HoverOnTemplatesAndClickOnSpecifiedButton("Template List");
		
		test.log(LogStatus.INFO, "Successfully verified the created Template. ");
		Assert.assertEquals(pages.getTemplatesPages().VerifyTheCreatedTemplate(NameOfTemplate), true,"Template is not present");
		
	
	}
	
	
	
	
	
	@Test(priority = 3)
	public void EditATemplate() throws Exception {
		test = extent.startTest("Creating a template");
		test.log(LogStatus.INFO, "Successfully loaded login page of OPDEMR Application");
		Log.info("part--------------------------------->1");
		pages.getLoginPage().LoadToOPDEMR();
		
		
		test.log(LogStatus.INFO, "Successfully Logged in to application.");
		pages.getLoginPage().LoginToOPDEMRwithCredentials("WOOD123456", "Wood@098");
		
		
		test.log(LogStatus.INFO, "Hovered on Template Button and clicked on Speceified button");
		pages.getTemplatesPages().HoverOnTemplatesAndClickOnSpecifiedButton("Template List");
		
		
		test.log(LogStatus.INFO, "Founded the first Template name sucessfully.");
		String NameOFtemplate=pages.getTemplatesPages().GetFirstTemplateNameFromTemplatesTable();
		
		
		test.log(LogStatus.INFO, "Hovered on Template Button and clicked on Speceified button");
		pages.getTemplatesPages().EditDesiredTemplate(NameOFtemplate);
	
		test.log(LogStatus.INFO, "Name of template has been successfully changed.");
		
		pages.getTemplatesPages().SetTemplateName(NameOFtemplate+" Test");
	
		test.log(LogStatus.INFO, "Successfully Added diagnosis.");
		pages.getTemplatesPages().AddDiagnosis("FLU");	
		
		TestUtils.sleep(5);
		test.log(LogStatus.INFO, "Successfully Clicked on Add diagnosis button.");
		pages.getTemplatesPages().ClickOnAddDiagnosisButton();
	
		
		test.log(LogStatus.INFO, "Successfully Clicked On Save Template Button. ");
		pages.getTemplatesPages().ClickOnSaveTemplateButton();
		
		
		test.log(LogStatus.INFO, "Successfully verified the created Template. ");
		Assert.assertEquals(pages.getTemplatesPages().VerifyTheCreatedTemplate(NameOFtemplate+" Test"), true,"Template is not present");
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
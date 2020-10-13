package OPDEMR.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import OPDEMR.base.BasePage;
import OPDEMR.utils.TestUtils;

public class SoapConfiguration_AssesmentPage extends BasePage {

	
	public SoapConfiguration_AssesmentPage(ThreadLocal<WebDriver> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By ChiefComplaintTextArea=By.xpath("//textarea[@id='subjectives_0']");
	
	By HPI_Field=By.xpath("//textarea[@id='subjectives_1']");
	
	By ReviewOfSystemField=By.xpath("//textarea[@id='subjectives_1']");
	
	By ConfirmButton=By.xpath("//div[@class='fixed-cta']//button");
	
	
	
//	---------------------------------------------------OBjectivePage
	
	By VitalsButton=By.xpath("//button[@id='add-vitals-button']");
//	---------------------------------------------------AssessmentPage
	
	By SearchReportField=By.xpath("//input[@id='search']");
	
//	---------------------------------------------------PlanPage
	By DrugDropdown=By.xpath("//select[@id='drug_id']");
	
	By CloseDrugInteractionButton=By.xpath("//div[@id='myDrugsInteraction']//button");
	
	By DeleteDialogBox=By.xpath("//div[@id='medicine-delete-confirm']");
	By DeleteConfirm=By.xpath("//div[@tabindex='2']");
	By ModalBox=By.xpath("//main[@id='main']//following-sibling::div[@class='modal show']//button[1]");
	
	
	By ContinueButton=By.xpath("//button[text()='CONTINUE']");
	
	
	public void ClickOnAny_SOAP_Button(String NameOfButton)
	{
		if(NameOfButton.startsWith("S"))
		{
			By SubjectiveButton=By.xpath("//body/main[@id='main']/div[3]/div[1]//li[position()=1]");
			clickAndWait(SubjectiveButton, longWait);
			waitForElementToBecomeVisible(ChiefComplaintTextArea, longWait);
			return;
		}
		
		if(NameOfButton.startsWith("O"))
		{
			By ObjectiveButton=By.xpath("//body/main[@id='main']/div[3]/div[1]//li[position()=2]");
			clickAndWait(ObjectiveButton, longWait);
			waitForElementToBecomeVisible(VitalsButton, longWait);
			return;
		}
		
		
		if(NameOfButton.startsWith("A"))
		{
			By AssesmentButton=By.xpath("//body/main[@id='main']/div[3]/div[1]//li[position()=3]");
			clickAndWait(AssesmentButton, longWait);
			waitForElementToBecomeVisible(SearchReportField, longWait);
			return;
		}
		
		if(NameOfButton.startsWith("P"))
		{
			By PlanButton=By.xpath("//body/main[@id='main']/div[3]/div[1]//li[position()=4]");
			clickAndWait(PlanButton, longWait);
			waitForElementToBecomeVisible(DrugDropdown, longWait);
			return;
		}
		
		
		
		 
		if(NameOfButton.startsWith("H"))
		{
			By HomeButton=By.xpath("//body/main[@id='main']/div[3]/div[1]//li[position()=5]");
			clickAndWait(HomeButton, longWait);
			waitForElementToBecomeVisible(DrugDropdown, longWait);
			return;
		}
		
		
		
	}
	
	
	public void Handle_Drug_Interaction_Alert_Box()
	{
		waitForElementToBecomeVisible(CloseDrugInteractionButton, shortWait);
		if(isElementPresent(CloseDrugInteractionButton))
		{
			System.out.println("found Drug Interaction Box,Hence closing");
		clickAndWait(CloseDrugInteractionButton, minimalWait);
		
		}
		waitForElementToBecomeVisible(ModalBox, shortWait);
		if(isElementPresent(ModalBox))
		{
			By yesBUtton=By.xpath("//button[@id='poly-pharmacy-yes']");
			clickAndWait(yesBUtton, longWait);
			
		}
		
		
		
	}
	
	
	public void DeleteDesiredMedicine(String MedicineName)
	{
		By MedicineName1=By.xpath("//div[@id='medicine-list']//tbody//td[text()='"+MedicineName+"']");
		waitForElementToBecomeVisible(MedicineName1, shortWait);
		
		List<WebElement>rows=driver.get().findElements(By.xpath("//div[@id='medicine-list']//tbody//tr"));
		
		int size=rows.size();
		
		for(int i=0;i<size;i++)
		{
			if(driver.get().findElement(By.xpath("//div[@id='medicine-list']//tbody//tr["+(i+1)+"]//td[1]")).getText().equals(MedicineName))
			{
			
			By DesiredMedicineNameDeleteButton=By.xpath("//div[@id='medicine-list']//tbody//td[text()='"+MedicineName+"']//following-sibling::td[position()=9]//a[2]");

		
			
			while(getAttribute(DeleteDialogBox, "class").equals("modal"))
			{
				javascriptButtonClick(DesiredMedicineNameDeleteButton);
				TestUtils.sleep(2);
			}
			
			
			while(getAttribute(DeleteDialogBox, "class").equals("modal show"))
			{
				javascriptButtonClick(DeleteConfirm);
				TestUtils.sleep(2);
			}
			
		}
		
		}
		
		
		
		
	}
	
	
	public void EditDesiredMedicine(String MedicineName)
	{
		By MedicineName1=By.xpath("//div[@id='medicine-list']//tbody//td[text()='"+MedicineName+"']");
		waitForElementToBecomeVisible(MedicineName1, longWait);
		
		List<WebElement>rows=driver.get().findElements(By.xpath("//div[@id='medicine-list']//tbody//tr"));
		
		int size=rows.size();
		
		for(int i=0;i<size;i++)
		{
			if(driver.get().findElement(By.xpath("//div[@id='medicine-list']//tbody//tr["+(i+1)+"]//td[1]")).getText().equals(MedicineName))
			{
			By DesiredMedicineNameEditButton=By.xpath("//div[@id='medicine-list']//tbody//td[text()='"+MedicineName+"']//following-sibling::td[position()=9]//a[1] ");
			
				javascriptButtonClick(DesiredMedicineNameEditButton);
				TestUtils.sleep(2);
				
		}
		
		}
	}
	
	
	
	
	
	public void ClickOnContinueButton()
	{
		
		waitForElementToBecomeVisible(ContinueButton, longWait);
		
		clickAndWait(ContinueButton, longWait);
		
		
	}
	
	
	
	
	
	
}

package OPDEMR.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import OPDEMR.base.BasePage;
import OPDEMR.utils.TestUtils;

public class TemplatesPages extends BasePage{

	public TemplatesPages(ThreadLocal<WebDriver> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	
	By Template =By.xpath("//a[@id='template_menu']");
	
	By TemplateListButton=By.xpath("//a[contains(text(),'Template List')]");
	
	By CreateTemplateButton=By.xpath("//a[contains(text(),'Create Template')]");
	
	By SearchField=By.xpath("//input[@id='search-template']");
	
	
	By firstTemplateNameOnTemplateTable=By.xpath("//tbody[@id='template-list']//tr[1]//td[1]");
	
	
	By firstDiagnosisNameOnTemplateTable=By.xpath("//tbody[@id='template-list']//tr[1]//td[2]//div//div");
	
	By favourite=By.xpath("//i[@class='icon_star favourite']");
	
	
	By DeleteConfirm=By.xpath("//div[@tabindex='2']");
	
	
	By DeleteDialogBox=By.xpath("//div[@id='modalConfirm']");
	
	//-------------------------------------------------------------------Create Template------------------------------------
	
	
	
	By Createtemplate=By.xpath("//a[text()='CREATE TEMPLATE']");
	
	By TemplateNameField=By.xpath("//input[@id='template-name']");
	
	By SaveButton= By.xpath("//button[contains(text(),'Save Template')]");
	
	By DiagnosisArrow=By.xpath("//span[@id='select2-diagnosis-container']//following-sibling::span[@role='presentation']");
	
	By DiagnosisInputField=By.xpath("//span[@class='select2-results']//preceding-sibling::span//input[@class='select2-search__field']");
	
	By DiagnosisOptions=By.xpath("//ul[@id='select2-diagnosis-results']//li");
	
	By AddButton=By.xpath("//button[text()='Add']");
	
	
	By ComboBox=By.xpath("//span[@id='select2-diagnosis-container']//parent::span[@role='combobox']");
	
	
	By DeleteActionButtonOfDiagnosis=By.xpath("//td//a[contains(@class, 'delete-assessment')]");
	
	By DeleteConfirmOfDiagnosis=By.xpath("//div[text()='DELETE']");
	
	//------------------------------------------------------------ADD Medicines------------------------------------------------	

	
	By DrugField=By.xpath("//span[@id='select2-drug_id-container']//parent::span");
	
	By AddMedicineArrow=By.xpath("//span[@id='select2-drug_id-container']//following-sibling::span");
	
	By MedicinesOptions=By.xpath("//ul[@id='select2-drug_id-results']//li");
	
	By AddMedicineButton=By.xpath("//button[@id='drug-save']");
	
	By TaperDoseCheckBox=By.xpath("//input[@id='taper_dose']");
	
	By NumberOfDaysTaper=By.xpath("//input[@id='number_of_days_taper']");
	
	
	By FrequencyofMedicine=By.xpath("//select[@id='daily_frequency_taper']");
	
	By ScheduleField=By.xpath("//select[@id='schedules_taper']");
	
	By AddButtonTaper=By.xpath("//button[@id='drug-save-taper']");
	
	
	
	//------------------------------------------------------------ADD Test------------------------------------------------	

	
	By TestField=By.xpath("//span[@id='select2-test-name-container']//parent::span");
	
	By AddTestArrow=By.xpath("//span[@id='select2-test-name-container']//following-sibling::span");
	
	By TestOptions=By.xpath("//ul[@id='select2-test-name-results']//li");
	 
	By AddTestButton=By.xpath("//button[@id='test-save']");
	
	
	
	By SaveTemplateBUtton=By.xpath("//button[contains(@class,'template-save')]");
	
	
	
	List<WebElement>fav=driver.get().findElements(favourite);
	
	
	public void HoverOnTemplatesAndClickOnSpecifiedButton(String ButtonName)
	{
		waitForElementToBecomeVisible(Template, longWait);
		scrollToElement(Template);
		if(ButtonName.equalsIgnoreCase("Template List"))
		{
//		new Actions(driver.get()).moveToElement(driver.get().findElement(Template)).moveToElement(driver.get().findElement(TemplateListButton)).click().build().perform();

		Actions	act=new Actions(driver.get());
		act.moveToElement(driver.get().findElement(Template)).perform();
		waitForElementToBecomeVisible(TemplateListButton, longWait);
		act.moveToElement(driver.get().findElement(TemplateListButton)).click().perform();
//		TestUtils.sleep(3);
		
		
		
		}
		
		
		else {
			new Actions(driver.get()).moveToElement(driver.get().findElement(Template)).moveToElement(driver.get().findElement(CreateTemplateButton)).click().build().perform();

		}
		waitForElementToBecomeVisible(SearchField, longWait);
	}
	
	
	
	
	public String GetFirstTemplateNameFromTemplatesTable()
	{
		String Name="Not found anything";
		
		waitForElementToBecomeVisible(firstTemplateNameOnTemplateTable, longWait);
		System.out.println("firstTemplateNameOnTemplateTable----------> "+getText(firstTemplateNameOnTemplateTable));
		return Name=getText(firstTemplateNameOnTemplateTable);
		
		
		
	}
	
	public String GetFirstDiagnosisFromTemplatesTable()
	{
		String Name="Not found anything";
		
		waitForElementToBecomeVisible(firstDiagnosisNameOnTemplateTable, longWait);
		return Name=getText(firstDiagnosisNameOnTemplateTable);
		
		
		
	}
	public void clearTheSearchResult()
	{
		setText(SearchField, "", longWait);
		TestUtils.sleep(5);
		
		
		
	}
	
	public void SearchForTemplate(String NameOfTemplateOrDiagnosis)
	{
		
		setText(SearchField, NameOfTemplateOrDiagnosis, longWait);
		String firstTemplateName = getText(firstTemplateNameOnTemplateTable);
		
	}
	
	
	public String ClickOnStarIconAndReturnClassOfDesiredTemplateName(String NameOfTemplate)
	{
		
		By DesiredStarIconOfTemplateNameOnTemplateTable=By.xpath("//tbody[@id='template-list']//tr//td[text()='"+NameOfTemplate+"']//following-sibling::td[position()=4]//i");
		javascriptButtonClick(DesiredStarIconOfTemplateNameOnTemplateTable);
	
		
		TestUtils.sleep(10);
		return getAttribute(DesiredStarIconOfTemplateNameOnTemplateTable, "class");
		
	}
	
	
	public String GetclassNameofDesiredTemplateName(String NameOfTemplate)
	{
		By DesiredStarIconOfTemplateNameOnTemplateTable=By.xpath("//tbody[@id='template-list']//tr//td[text()='"+NameOfTemplate+"']//following-sibling::td[position()=4]//i");
		TestUtils.sleep(4);
		return getAttribute(DesiredStarIconOfTemplateNameOnTemplateTable, "class");
		
		
	}
	
	
	
	public void DeleteDesiredTemplateName(String NameOfTemplate)
	{
		
		By DesiredDeleteIconOfTemplateNameOnTemplateTable=By.xpath("//tbody[@id='template-list']//tr//td[text()='"+NameOfTemplate+"']//following-sibling::td[position()=5]//a[2]");
		javascriptButtonClick(DesiredDeleteIconOfTemplateNameOnTemplateTable);
		waitForElementToBecomeVisible(DeleteConfirm, longWait);
		clickAndWait(DeleteConfirm, longWait);
		
	}
	
	
	
	//---------------------------------------------------*****************************------------------------------------------
	
	public void SetTemplateName(String NameOfTemplate)
	{
		setText(TemplateNameField, NameOfTemplate, longWait);
		
		
	}
	
	
	
	
	
	public void ClickOnCreateTemplateButton()
	{
		waitForElementToBecomeVisible(Createtemplate, longWait);
		clickAndWait(Createtemplate, longWait);
		waitForElementToBecomeVisible(TemplateNameField, longWait);
		
	}
	
	
	
	
	
	
	public boolean VerifyStateOfSaveBUtton()
	{
		
		return verifyIsEnabled(SaveButton, longWait);
		
	}
	
	
	
	public void AddDiagnosis(String DiagnosisCharacters)
	{
	while(getAttribute(ComboBox, "aria-expanded").equals("false"))
	{
		CLickUsingActionClass(DiagnosisArrow);
		TestUtils.sleep(3);
	}	
		setText(DiagnosisInputField, DiagnosisCharacters, longWait);
		waitForElementToBecomeVisible(DiagnosisOptions, longWait);
		//javascriptButtonClick(DiagnosisOptions);
		//pressEnter();
		TestUtils.sleep(5);
		CLickUsingActionClass(DiagnosisOptions);
	}
	
	
	
	public void ClickOnAddDiagnosisButton()
	{
		
		waitForElementToBeClickable(AddButton, longWait);
		clickAndWait(AddButton, longWait);
	}
	
	
	
	public void ClickOnDeleteButtonOfDiagnosis()
	{
		
		waitForElementToBecomeVisible(DeleteActionButtonOfDiagnosis, longWait);
		
		clickAndWait(DeleteActionButtonOfDiagnosis, longWait);
		
        waitForElementToBecomeVisible(DeleteConfirmOfDiagnosis, longWait);
		
		clickAndWait(DeleteConfirmOfDiagnosis, longWait);
		
		
		
	}
	
//------------------------------------------------------------ADD Medicines------------------------------------------------	
	public void AddMedicines(String NameOfMedicines)
	{
		scrollToElement(AddMedicineButton);
		
		while(getAttribute(DrugField, "aria-expanded").equals("false"))
		{
			CLickUsingActionClass(AddMedicineArrow);
			TestUtils.sleep(3);
		}	
			setText(DiagnosisInputField, NameOfMedicines, longWait);
			waitForElementToBecomeVisible(MedicinesOptions, longWait);
			//javascriptButtonClick(DiagnosisOptions);
			//pressEnter();
			TestUtils.sleep(5);
			CLickUsingActionClass(MedicinesOptions);
			TestUtils.sleep(5);
			javascriptButtonClick(AddMedicineButton);
				
	}
	
	
	
	
	public void AddMedicineswithTaperDose(String NameOfMedicines)
	{
		scrollToElement(AddMedicineButton);
		
		if(!driver.get().findElement(TaperDoseCheckBox).isSelected()) {
			System.out.println("TaperDose link is not checked hence checking");
		javascriptButtonClick(TaperDoseCheckBox);
		}
		
		AddMedicines(NameOfMedicines);
		
		waitForElementToBecomeVisible(NumberOfDaysTaper, longWait);
		setText(NumberOfDaysTaper, "2", longWait);
		
		selectByCompleteVisibleText(FrequencyofMedicine, "Once Daily");
		clickAndWait(AddButtonTaper, longWait);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	//------------------------------------------------------------ADD Tests------------------------------------------------	
	
	
	
	public void AddTest(String NameOfTest)
	{
		scrollToElement(AddTestButton);
		while(getAttribute(TestField, "aria-expanded").equals("false"))
		{
			CLickUsingActionClass(AddTestArrow);
			TestUtils.sleep(3);
		}	
			setText(DiagnosisInputField, NameOfTest, longWait);
			waitForElementToBecomeVisible(TestOptions, longWait);
			//javascriptButtonClick(DiagnosisOptions);
			//pressEnter();
			TestUtils.sleep(5);
			CLickUsingActionClass(TestOptions);
//			TestUtils.sleep(5);
//			javascriptButtonClick(AddTestButton);
				
	}
	
	
	public void ClickOnSaveTemplateButton()
	{
		
		//clickAndWait(CreateTemplateButton, longWait);
		TestUtils.sleep(3);
		scrollToElement(SaveTemplateBUtton);
		CLickUsingActionClass(SaveTemplateBUtton);
		
	}
	
	
	public boolean VerifyTheCreatedTemplate(String NameOfTemplate)
	{
		boolean status=false;
		By TemplateName=By.xpath("//tbody[@id='template-list']//tr//td[1]");
		waitForElementToBecomeVisible(TemplateName, longWait);
		
		List<WebElement>AllNames = driver.get().findElements(TemplateName);
		
		
		for(int i=0;i<AllNames.size();i++)
		{
			
			if(AllNames.get(i).getText().equals(NameOfTemplate))
			{
				System.out.println("In if------------------>"+AllNames.get(i).getText());
				
				return status=true;
			}
			
			
			
			
		}
		
		System.out.println(TemplateName +" not found at template table. ");
		return status;
			
		
	}
	
	
	
	public boolean VerifyAndDeleteTheTemplateIfAlreadyPresent(String NameOfTemplate)
	{
		boolean status=false;
		By TemplateName=By.xpath("//tbody[@id='template-list']//tr//td[1]");
		waitForElementToBecomeVisible(TemplateName, longWait);
		
		List<WebElement>AllNames = driver.get().findElements(TemplateName);
		
		System.out.println("No of templates available------------------>"+AllNames.size());
		
		for(int i=0;i<=AllNames.size();i++)
		{
			
			if(AllNames.get(i).getText().equals(NameOfTemplate))
			{
				System.out.println("Template Already Exist------------------>"+AllNames.get(i).getText() +" So Deleting");
				By DeleteButton=By.xpath("//tbody[@id='template-list']//tr["+i+"]//td[6]//a[2]//i");
				while(getAttribute(DeleteDialogBox, "class").equals("modal"))
				{
					javascriptButtonClick(DeleteButton);
					TestUtils.sleep(3);
					return status=true;
				}
			
				
				
				
				while(getAttribute(DeleteDialogBox, "class").equals("modal show"))
				{
					javascriptButtonClick(DeleteConfirm);
					
				}
				
			
			
			
			
			
			
			
			
			
			
			
			}
			
			
			
			
		}
	
		return status;	
		
	}
	
	
	
	
	
	
	
	public void EditDesiredTemplate(String NameOfTemplate)
	{
		boolean status=false;
		By TemplateName=By.xpath("//tbody[@id='template-list']//tr//td[1]");
		waitForElementToBecomeVisible(TemplateName, longWait);
		
		List<WebElement>AllNames = driver.get().findElements(TemplateName);
		
		System.out.println("No of templates available------------------>"+AllNames.size());
		outerloop:
		for(int i=0;i<=AllNames.size();i++)
		{
			
			if(AllNames.get(i).getText().equals(NameOfTemplate))
			{
				System.out.println("Found Desired Template------------------>"+AllNames.get(i).getText() +", So Clicking on Edit Button.");
				By EditButton=By.xpath("//tbody[@id='template-list']//tr["+i+1+"]//td[6]//a[1]//i");
				while(!isElementPresent(TemplateNameField))
				{
					javascriptButtonClick(EditButton);
					TestUtils.sleep(3);	
				}
				break outerloop;
			}			
		}
	
		waitForElementToBecomeVisible(TemplateNameField, longWait);	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

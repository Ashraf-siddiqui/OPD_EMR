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

	By ChiefComplaintTextArea = By.xpath("//textarea[@id='subjectives_0']");

	By HPI_Field = By.xpath("//textarea[@id='subjectives_1']");

	By ReviewOfSystemField = By.xpath("//textarea[@id='subjectives_1']");

	By ConfirmButton = By.xpath("//div[@class='fixed-cta']//button");

//	---------------------------------------------------OBjectivePage

	By VitalsButton = By.xpath("//button[@id='add-vitals-button']");
//	---------------------------------------------------AssessmentPage

	By SearchReportField = By.xpath("//input[@id='search']");

//	---------------------------------------------------PlanPage
	By DrugDropdown = By.xpath("//select[@id='drug_id']");

	By CloseDrugInteractionButton = By.xpath("//div[@id='myDrugsInteraction']//button");

	By DeleteDialogBox = By.xpath("//div[@id='medicine-delete-confirm']");
	By DeleteDialogBoxForMedicine=By.xpath("//div[@id='plan-delete-test']");
	By DeleteConfirm = By.xpath("//div[@tabindex='2']");
	By ModalBox = By.xpath("//main[@id='main']//following-sibling::div[@class='modal show']//button[2]");

	By BackButton = By.xpath("//li[contains(@class,'goback')]//a");
	By ContinueButton = By.xpath("//div[@class='fixed-cta']//*");

	// ---------------------------------------------------InstructionPage------------------------------------

	By InstructionCheckBox = By.xpath("//input[@class='custom-control-input']");

	By ConfirmButtonOnInstructionPage = By.xpath("//div[contains(text(),'CONFIRM')]");
	
	By SeacrhInstructionBox=By.xpath("//input[@id='search-instruction']");
	
	By Instructions=By.xpath("//div[@class='instructions_text']//p");

	public void ClickOnAny_SOAP_Button(String NameOfButton) {
		if (NameOfButton.contains("Sub")) {
			By SubjectiveButton = By.xpath("//body/main[@id='main']/div[3]/div[1]//li[position()=1]");
			clickAndWait(SubjectiveButton, longWait);
			waitForElementToBecomeVisible(ChiefComplaintTextArea, longWait);
			return;
		}

		if (NameOfButton.contains("Obj")) {
			By ObjectiveButton = By.xpath("//body/main[@id='main']/div[3]/div[1]//li[position()=2]");
			clickAndWait(ObjectiveButton, longWait);
			waitForElementToBecomeVisible(VitalsButton, longWait);
			return;
		}

		if (NameOfButton.contains("Ass")) {
			By AssesmentButton = By.xpath("//body/main[@id='main']/div[3]/div[1]//li[position()=3]");
			clickAndWait(AssesmentButton, longWait);
			waitForElementToBecomeVisible(SearchReportField, longWait);
			return;
		}

		if (NameOfButton.contains("Plan")) {
			By PlanButton = By.xpath("//body/main[@id='main']/div[3]/div[1]//li[position()=4]");
			clickAndWait(PlanButton, longWait);
			waitForElementToBecomeVisible(DrugDropdown, longWait);
			return;
		}

		if (NameOfButton.startsWith("H")) {
			By HomeButton = By.xpath("//body/main[@id='main']/div[3]/div[1]//li[position()=5]");
			clickAndWait(HomeButton, longWait);
			waitForElementToBecomeVisible(DrugDropdown, longWait);
			return;
		}

	}

	public void Handle_Drug_Interaction_Alert_Box() {
		waitForElementToBecomeVisible(CloseDrugInteractionButton, shortWait);
		if (isElementPresent(CloseDrugInteractionButton)) {
			System.out.println("found Drug Interaction Box,Hence closing");
			clickAndWait(CloseDrugInteractionButton, minimalWait);

		}
		waitForElementToBecomeVisible(ModalBox, shortWait);
		if (isElementPresent(ModalBox)) {
			// By yesBUtton=By.xpath("//button[@id='poly-pharmacy-yes']");
			clickAndWait(ModalBox, longWait);

		}

	}

	public void DeleteDesiredMedicine(String MedicineName) {
		By MedicineName1 = By.xpath("//div[@id='medicine-list']//tbody//td[text()='" + MedicineName + "']");
		waitForElementToBecomeVisible(MedicineName1, shortWait);

		List<WebElement> rows = driver.get().findElements(By.xpath("//div[@id='medicine-list']//tbody//tr"));

		int size = rows.size();

		for (int i = 0; i < size; i++) {
			if (driver.get().findElement(By.xpath("//div[@id='medicine-list']//tbody//tr[" + (i + 1) + "]//td[1]"))
					.getText().contains(MedicineName)) {

				By DesiredMedicineNameDeleteButton = By.xpath("//div[@id='medicine-list']//tbody//td[text()='"
						+ MedicineName + "']//following-sibling::td[position()=9]//a[2]");

				while (getAttribute(DeleteDialogBox, "class").equals("modal")) {
					javascriptButtonClick(DesiredMedicineNameDeleteButton);
					TestUtils.sleep(2);
				}

				while (getAttribute(DeleteDialogBox, "class").equals("modal show")) {
					javascriptButtonClick(DeleteConfirm);
					TestUtils.sleep(2);
				}

			}

		}

	}

	public void ClickOnBackButton() {

		clickAndWait(BackButton, longWait);
		waitForElementToBecomeVisible(ConfirmButton, longWait);

	}

	public void DeleteAllTheMedicines() {
		int count = 0;
		By allDeleteIcon = By.xpath("//td//a[2]//i");
		waitForElementToBecomeVisible(allDeleteIcon, longWait);
		if (isElementPresent(allDeleteIcon)) {
			List<WebElement> el = driver.get().findElements(allDeleteIcon);

			for (int i = 0; i < el.size(); i++) {
				List<WebElement> el1 = driver.get().findElements(allDeleteIcon);

				waitForElementToBecomeVisible(allDeleteIcon, longWait);

				while (getAttribute(DeleteDialogBox, "class").equals("modal")) {
					javascriptButtonClick(el1.get(0));
					TestUtils.sleep(2);
				}

				while (getAttribute(DeleteDialogBox, "class").equals("modal show")) {
					javascriptButtonClick(DeleteConfirm);
					TestUtils.sleep(2);
				}
				TestUtils.sleep(10);
				count++;
			}

			if (el.size() - 1 == count) {
				System.out.println("All the elemets deleted.");
			}
		}

	}
	
	public void DeleteALLTest()
	{
		

		int count = 0;
		By allDeleteIcon = By.xpath("//td//a[contains(@class,'remove-test')]//i");
		waitForElementToBecomeVisible(allDeleteIcon, longWait);
		if (isElementPresent(allDeleteIcon)) {
			List<WebElement> el = driver.get().findElements(allDeleteIcon);

			for (int i = 0; i < el.size(); i++) {
				List<WebElement> el1 = driver.get().findElements(allDeleteIcon);

				waitForElementToBecomeVisible(allDeleteIcon, longWait);

				while (getAttribute(DeleteDialogBoxForMedicine, "class").equals("modal")) {
					javascriptButtonClick(el1.get(0));
					TestUtils.sleep(2);
				}

				while (getAttribute(DeleteDialogBoxForMedicine, "class").equals("modal show")) {
					javascriptButtonClick(DeleteConfirm);
					TestUtils.sleep(2);
				}
				TestUtils.sleep(10);
				count++;
			}

			if (el.size() - 1 == count) {
				System.out.println("All the elemets deleted.");
			}
		}

	
	}
	
	
	public void CountallCheckboxes()
	{
		waitForElementToBecomeVisible(InstructionCheckBox, longWait);
		List<WebElement>checkboxes=driver.get().findElements(InstructionCheckBox);
		System.out.println("---------------->"+checkboxes.size());
		
	}
	
	public void SearchForInstructions(String NameOFInstructions)
	{
		setText(SeacrhInstructionBox, NameOFInstructions, longWait);
	}
	
	
	public boolean ValidateSeacrhedInstruction(String NameOFInstructions)
	{
		By SearchedInstruction=By.xpath("//p[contains(text(),'"+NameOFInstructions+"')]//parent::div//parent::div[contains(@class,'instructions_list2')]");
		TestUtils.sleep(5);
		if(!getAttribute(SearchedInstruction, "style").contains("none"))
		{
			return true;
			
			
		}
	return false;
	
	}
	
	
	public String GetFirstInstruction()
	{
		List<WebElement>allinstructions=driver.get().findElements(Instructions);
		
		return allinstructions.get(0).getText();
		
		
	}
	
	public void ClickOnCheckboxOfDesiredInstruction(String Instruction)
	{
		
		By DesiredCheckBox=By.xpath("//p[contains(text(),'"+Instruction+"')]//parent::div//parent::div//input");
		System.out.println("Status of checkbox = "+driver.get().findElement(DesiredCheckBox).isSelected());
		while(!driver.get().findElement(DesiredCheckBox).isSelected())
		{
			javascriptButtonClick(DesiredCheckBox);
			
			
		}
		
		
		
	}
	public void UncheckAllCheckBoxes()
	{
		
		By AllCheckBoxes=By.xpath("//p//parent::div//parent::div//input");
		
		List<WebElement>ListOfAllCheckBoxes=driver.get().findElements(AllCheckBoxes);
		
		
		for(WebElement el:ListOfAllCheckBoxes)
		{
			if(el.isSelected())
			{
				javascriptButtonClick(el);
			}
		}
		
	}
	
	
	
	
	
	

	public void ChangeStrengthOfMedicine() {

	}

	public boolean VerifyMedicinePresentInTableUnderPlanPage(String NameOfMedicine) {

		By AllMedicine = By.xpath("//div[@id='medicine-list']//tbody//tr//td[1]");

		List<WebElement> listOfMedicine = driver.get().findElements(AllMedicine);

		waitForElementToBecomeVisible(AllMedicine, longWait);

		if (isElementPresent(AllMedicine)) {

			if (listOfMedicine.size() > 0) {

				for (WebElement el : listOfMedicine) {
					if (el.getText().equalsIgnoreCase(NameOfMedicine)) {
						System.out.println("Medicine Name :" + el.getText() + " Found On Plan Page.");
						return true;
					}
				}

			}

		}

		return false;

	}

	public boolean VerifyTestPrsentInTableUnderTestPage(String NameOfTest) {

		TestUtils.sleep(5);
		By AllTest = By.xpath("//div[@id='test-list-lab']//tbody//tr//td[1]");

		List<WebElement> listOfTest = driver.get().findElements(AllTest);

		waitForElementToBecomeVisible(AllTest, longWait);

		if (isElementPresent(AllTest)) {

			if (listOfTest.size() > 0) {

				for (WebElement el : listOfTest) {
					System.out.println("str1->"+el.getText());


					if (el.getText().equalsIgnoreCase(NameOfTest))
					
					{
						System.out.println("Medicine Name :" + el.getText() + " Found On Plan Page.");
						return true;
					}
				}

			}

		}

		return false;

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

	public void EditDesiredMedicine(String MedicineName) {
		By MedicineName1 = By.xpath("//div[@id='medicine-list']//tbody//td[text()='" + MedicineName + "']");
		waitForElementToBecomeVisible(MedicineName1, longWait);

		List<WebElement> rows = driver.get().findElements(By.xpath("//div[@id='medicine-list']//tbody//tr"));

		int size = rows.size();

		for (int i = 0; i < size; i++) {
			if (driver.get().findElement(By.xpath("//div[@id='medicine-list']//tbody//tr[" + (i + 1) + "]//td[1]"))
					.getText().equals(MedicineName)) {
				By DesiredMedicineNameEditButton = By.xpath("//div[@id='medicine-list']//tbody//td[text()='"
						+ MedicineName + "']//following-sibling::td[position()=9]//a[1] ");

				javascriptButtonClick(DesiredMedicineNameEditButton);
				TestUtils.sleep(2);

			}

		}
	}

	public void ClickOnContinueButton() {

		waitForElementToBecomeVisible(ContinueButton, longWait);
		scrollToElement(ContinueButton);
		clickAndWait(ContinueButton, longWait);

	}
	
	
	
	
	

	public void ClickOnAnyRandomInstruction(String NameOfCheckbox) {
	//	List<WebElement> Elements = driver.get().findElements(InstructionCheckBox);
		waitForElementToBecomeVisible(InstructionCheckBox, longWait);

		clickAndWait(InstructionCheckBox, longWait);
	}

	public void ClickOnConfirmButtonOnInstructionsPage() {
		waitForElementToBecomeVisibleDuplicate(ConfirmButtonOnInstructionPage, longWait);
		clickAndWait(ConfirmButtonOnInstructionPage, longWait);

	}

}

package OPDEMR.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import OPDEMR.base.BasePage;
import OPDEMR.utils.TestUtils;

public class ObjectivePage extends BasePage {

	
	public ObjectivePage(ThreadLocal<WebDriver> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//----------------------------------Vitals----------------------------------------------------------	

	By AddVitalsButton=By.xpath("//button[@id='add-vitals-button']");
	By VitalConfirmButton=By.xpath("//button[@id='objective-form-submit']");
	By VitalsInputFields=By.xpath("//div[contains(@class,'add-vitals')]//input[@type='text']");
	
	//----------------------------------Allergies By Drug----------------------------------------------------------	
	By AddAllergiesButton=By.xpath("//button[@id='add-allergy-button']");
	By known_existing_AllergiesCheckBox=By.xpath("//input[@id='known_allergies']");
	
	By DeleteDialogBoxForAllergies=By.xpath("//div[@id='objective-delete-allergy']");
	
	By DeleteConfirmAllergies=By.xpath("//div[contains(@class,'submit-delete-assessment')]");
	
	By AllergiesArrow=By.xpath("//span[@id='select2-drugs-container']//parent::span//following-sibling::span");
	By DrugComboBox=By.xpath("//span[@id='select2-drugs-container']//parent::span");
	By DrugInputField=By.xpath("//input[@role='searchbox']");
	
	By ReactionField=By.xpath("//input[@id='drugs-reaction']//preceding-sibling::div//input");
	
	By SaveButton=By.xpath("//button[@id='allergies-confirm']");
	
	By NameOfDrugOnMainPage=By.xpath("//ul[@class='allergy-container']//li[1]");
	
	
	//----------------------------------Allergies By Food----------------------------------------------------------	
	
	By FoodTab=By.xpath("//a[contains(text(),'Food')]");
	
	By FoodOption=By.xpath("//ul[@id='select2-food-results']//li[1]");
	
	By ReactionFieldForFood=By.xpath("//input[@id='food-reaction']//preceding-sibling::div//input");
	
	//----------------------------------Allergies By Other----------------------------------------------------------	
	
	By OthersTab=By.xpath("//a[contains(text(),'Others')]");
	
	By OthersOption=By.xpath("//ul[@id='select2-others-results']//li[1]");
	
	By ReactionFieldForOthers=By.xpath("//input[@id='others-reaction']//preceding-sibling::div//input");
	
	
	//----------------------------------Conditions----------------------------------------------------------	
	
	By AddConditionButton=By.xpath("//button[@id='add-condition-button']");
	By KnownConditionCheckBox=By.xpath("//input[@id='known_existing_conditions']");
	
	

	By DeleteDialogBoxForConditions=By.xpath("//div[@id='objective-delete-condition']");
	
	By DeleteConfirmConditions=By.xpath("//div[contains(@class,'submit-delete-condition')]");
	
	By ConditionOption=By.xpath("//ul[@id='select2-condition-results']//li");
	
	By DurationInputField=By.xpath("//input[@id='condition_duration']");
	
	By MedicineNameField=By.xpath("//input[@id='medicine_name']");
	
	By SaveConditionButton=By.xpath("//button[@id='condition-confirm']");
	
	//----------------------------------All functions------------------------------------------------------	
	
	public void CLickOnAddVitalsButton()
	{
		waitForElementToBecomeVisible(AddVitalsButton, longWait);
		clickAndWait(AddVitalsButton, longWait);
		waitForElementToBecomeVisible(VitalConfirmButton, longWait);

	}
	
	public void AddVitalsEntries(ArrayList<String> VitalDetails)
	{
		waitForElementToBecomeVisible(VitalsInputFields, longWait);
		List<WebElement>el=driver.get().findElements(VitalsInputFields);
		for(int i=0;i<el.size();i++)
		{
			if(i==2)
			{
				javascriptButtonClick(el.get(1));
				TestUtils.sleep(3);
				continue;
			}
			System.out.println(i);
			setTextBY(el.get(i), VitalDetails.get(i), longWait);
		}
	}
	
	
	public void ClickOnConfirmVitalButton()
	{
		waitForElementToBecomeVisible(VitalConfirmButton, longWait);
		clickAndWait(VitalConfirmButton, longWait);
			
	}
	
	public ArrayList GetVitalsDetailsFromObjectivePage()
	{
		ArrayList<String>list=new ArrayList<String>();
		for(int i=2;i<=11;i++)
		{
			if(i!=8)
		{
		By VitalDetails=By.xpath("//div[@id='vital-details']//tr["+i+"]//td[2]");
	
		
		list.add(getText(VitalDetails));
		
		
		
		}
		else
		{
			By VitalDetails=By.xpath("//div[@id='vital-details']//tr["+i+"]//td[2]//span");
			List<WebElement>list2=driver.get().findElements(VitalDetails);
			for(WebElement el:list2)
			{
				list.add(el.getText());
			}
		
		
		}
		
		
		
		
	}
	
	return list;
	
	
	}

	public boolean VerifyAllThe(ArrayList<String> VitalDetails,ArrayList<String> VitalDetails2)
	{
		if(VitalDetails.contains(VitalDetails2))
		{return true;}
		
		return false;
	}
	
	
	public String getBmi()
	{
		By bmi=By.xpath("//input[@id='bmi']");
		return getText(bmi);
		
	}
	public String getHeight()
	{
		By bmi=By.xpath("//input[@id='height']");
		return getText(bmi);
		
	} 
	
	public String getWeight()
	{
		By bmi=By.xpath("//input[@id='weight']");
		return getText(bmi);
		
	}
	
	//----------------------------------Allergies By Drug----------------------------------------------------------	

	public void ClickOnAllergiesCheckBox(String State)
	{
		scrollToElement(known_existing_AllergiesCheckBox);
		int j=0;
		while(j<10)
		{
		if(State.equals("Checked"))
		{
			while(!driver.get().findElement(known_existing_AllergiesCheckBox).isSelected())
			{
				javascriptButtonClick(known_existing_AllergiesCheckBox);
				TestUtils.sleep(3);
			}
		}
		
		if(State.equals("UnChecked"))
		{
			while(driver.get().findElement(known_existing_AllergiesCheckBox).isSelected())
			{
				javascriptButtonClick(known_existing_AllergiesCheckBox);
				TestUtils.sleep(3);
			}
		}
		j++;
		}
	}

	public boolean VerifyStateOfAddAllergiesButton()
	{
		return driver.get().findElement(AddAllergiesButton).isEnabled();
		
	}

	public void DeleteALLAllergies()
	{
		

		int count = 0;
		By allDeleteIcon = By.xpath("//a[contains(@class,'remove-allergy')]//i");
		waitForElementToBecomeVisible(allDeleteIcon, longWait);
		if (isElementPresent(allDeleteIcon)) {
			List<WebElement> el = driver.get().findElements(allDeleteIcon);

			for (int i = 0; i < el.size(); i++) {
				List<WebElement> el1 = driver.get().findElements(allDeleteIcon);

				waitForElementToBecomeVisible(allDeleteIcon, longWait);

				while (getAttribute(DeleteDialogBoxForAllergies, "class").equals("modal")) {
					javascriptButtonClick(el1.get(0));
					TestUtils.sleep(2);
				}

				while (getAttribute(DeleteDialogBoxForAllergies, "class").equals("modal show")) {
					javascriptButtonClick(DeleteConfirmAllergies);
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
	
	public void ClickOnAddAllergiesButton()
	{
		waitForElementToBecomeVisible(AddAllergiesButton, longWait);
		javascriptButtonClick(AddAllergiesButton);
		waitForElementToBecomeVisible(AllergiesArrow, longWait);
	}
	
	
	public void AddDrugUnderAllergies(String DrugName,String Reaction,String Intensity,String InformedBY)
	{
		
		TypeDrug(DrugName);
		AddReaction(Reaction);
		SelectIntensity(Intensity);
		SelectInformedBy(InformedBY);
	
	}
	
	public void AddReaction(String Reaction)
	{
	javascriptButtonClick(ReactionField);
	TestUtils.sleep(4);
	SettextByJavaScript(ReactionField, Reaction);
	}
	public void TypeDrug(String DrugName)
	{
		
		clickOnArrowUntilFieldIsVisible();
		setText(DrugInputField, DrugName, longWait);
		By Option=By.xpath("//ul[@id='select2-drugs-results']//li");
		TestUtils.sleep(3);
		CLickUsingActionClass(Option);
		TestUtils.sleep(3);
	}
	public void clickOnArrowUntilFieldIsVisible()
	{
		while(getAttribute(DrugComboBox, "aria-expanded").equals("false"))
		{
			javascriptButtonClick(AllergiesArrow);
			TestUtils.sleep(4);
		}
	}
	
	public void SelectIntensity(String Intensity)
	{

		List<WebElement>listofInput=driver.get().findElements(By.xpath("//input[@name='allergy_intensity']"));
		if(Intensity.startsWith("low"))
		{
			By intensity=By.xpath("//label[contains(@for,'drugs-intensity-low')]");
				javascriptButtonClick(intensity);
				TestUtils.sleep(4);
				
			
		}
		
		if(Intensity.startsWith("Moderate"))
		{
			By intensity=By.xpath("//label[contains(@for,'drugs-intensity-moderate')]");
			
				javascriptButtonClick(intensity);
				TestUtils.sleep(4);
				
			
		}
		
		if(Intensity.startsWith("High"))
		{
			By intensity=By.xpath("//label[contains(@for,'drugs-intensity-severe')]");
			
				javascriptButtonClick(intensity);
				TestUtils.sleep(4);
			
		}
		
		
		
		
		
		
		
		
		
	}
	
	public void SelectInformedBy(String InformedBy)
	{List<WebElement>listofInput=driver.get().findElements(By.xpath("//input[@name='allergy_intensity']"));
	
		if(InformedBy.startsWith("By Hospital"))
		{
			By informedBy=By.xpath("//label[contains(@for,'drugs-informed-hospital')]");
				javascriptButtonClick(informedBy);
				TestUtils.sleep(4);
				
			
			return;
		}
		
		
		if(InformedBy.startsWith("By Patient"))
		{
			By intensity=By.xpath("//label[contains(@for,'drugs-intensity-low')]");
			
				javascriptButtonClick(intensity);
				TestUtils.sleep(4);
				
			
		}
		
		
		
		
		
		
	}

	public void ClickOnSaveAllergiesButton()
	{
		clickAndWait(SaveButton, longWait);
		waitForElementToBecomeVisible(AddAllergiesButton, longWait);
		
	}
	
	public boolean VerifyNameOfDrugOnMainPage(String NameOfDrug)
	{
		waitForElementToBecomeVisible(NameOfDrugOnMainPage, longWait);
		List<WebElement>list=driver.get().findElements(NameOfDrugOnMainPage);
		for(WebElement el:list)
		{
			if(el.getText().equals(NameOfDrug));
			{
				return true;
			}
		}
		return false;
	}
	
	
	public boolean VerifyReactionOfDrugOnMainPage(String NameOfDrug)
	{
		waitForElementToBecomeVisible(NameOfDrugOnMainPage, longWait);
		By DesiredReaction=By.xpath("//li//span[contains(text(),'"+NameOfDrug+"')]");
		List<WebElement>list=driver.get().findElements(DesiredReaction);
		
		for(WebElement el:list)
		{
			if(el.getText().contains(NameOfDrug));
			{
				return true;
			}
		}
		return false;
	}
	
	public void ClickOnEditButtonOfDesiredDrug(String NameOfDrug)
	{
	By DesiredEditButtonOfDrug=By.xpath("//ul[@class='allergy-container']//li[text()='"+NameOfDrug+"']//a[1]//i");
	javascriptButtonClick(DesiredEditButtonOfDrug);
	waitForElementToBecomeVisible(AllergiesArrow, longWait);
	
	}
	
	//----------------------------------Allergies By Food----------------------------------------------------------	
	
	public void ClickOnFoodTab()
	{
		waitForElementToBecomeVisible(FoodTab, longWait);
		clickAndWait(FoodTab, longWait);
		waitForElementToBecomeVisible(DrugInputField, longWait);
	}
	
	public void SetFoodName(String FoodName)
	{
		setText(DrugInputField, FoodName, longWait);
		SelectFoodOption();
	}
	
	public void SelectFoodOption()
	{ waitForElementToBecomeVisible(FoodOption, longWait);
		CLickUsingActionClass(FoodOption);
	}
	
	
	
	public void AddReactionForFood(String Reaction)
	{
	javascriptButtonClick(ReactionFieldForFood);
	TestUtils.sleep(4);
//	SettextByJavaScript(ReactionFieldForFood, Reaction);
	driver.get().findElement(ReactionFieldForFood).sendKeys(Reaction);
	}
	
	
	public void SelectIntensityForFood(String Intensity)
	{

		List<WebElement>listofInput=driver.get().findElements(By.xpath("//input[@name='allergy_intensity']"));
		if(Intensity.startsWith("low"))
		{
			By intensity=By.xpath("//label[contains(@for,'food-intensity-low')]");
				javascriptButtonClick(intensity);
				TestUtils.sleep(4);
				
			
		}
		
		if(Intensity.startsWith("Moderate"))
		{
			By intensity=By.xpath("//label[contains(@for,'food-intensity-moderate')]");
			
				javascriptButtonClick(intensity);
				TestUtils.sleep(4);
				
			
		}
		
		if(Intensity.startsWith("High"))
		{
			By intensity=By.xpath("//label[contains(@for,'food-intensity-severe')]");
			
				javascriptButtonClick(intensity);
				TestUtils.sleep(4);
			
		}
		
		
		
	}
	
	public void ClickOnEditButtonOfDesiredFood(String NameOfDrug)
	{
	By DesiredEditButtonOfDrug=By.xpath("//ul[@class='allergy-container']//li[text()='"+NameOfDrug+"']//a[1]//i");
	javascriptButtonClick(DesiredEditButtonOfDrug);
	waitForElementToBecomeVisible(ReactionFieldForFood, longWait);
	
	}
	
	//----------------------------------Allergies By Others----------------------------------------------------------	
	
	
	public void ClickOnOthersTab()
	{
		waitForElementToBecomeVisible(OthersTab, longWait);
		clickAndWait(OthersTab, longWait);
		waitForElementToBecomeVisible(DrugInputField, longWait);
	}
	
	
	
	public void SetOthersName(String OtherName)
	{
		setText(DrugInputField, OtherName, longWait);
		SelectOthersOption();
	}
	
	
	
	public void SelectOthersOption()
	{ waitForElementToBecomeVisible(OthersOption, longWait);
		CLickUsingActionClass(OthersOption);
	}
	
	public void AddReactionForOthers(String Reaction)
	{
	javascriptButtonClick(ReactionFieldForOthers);
	TestUtils.sleep(4);
//	SettextByJavaScript(ReactionFieldForFood, Reaction);
	driver.get().findElement(ReactionFieldForOthers).sendKeys(Reaction);
	
	}
	
	public void SelectIntensityForOthers(String Intensity)
	{		
		if(Intensity.startsWith("low"))
		{
			By intensity=By.xpath("//label[contains(@for,'others-intensity-low')]");
				javascriptButtonClick(intensity);
				TestUtils.sleep(4);
				
			
		}
		
		if(Intensity.startsWith("Moderate"))
		{
			By intensity=By.xpath("//label[contains(@for,'others-intensity-moderate')]");
			
				javascriptButtonClick(intensity);
				TestUtils.sleep(4);
				
			
		}
		
		if(Intensity.startsWith("High"))
		{
			By intensity=By.xpath("//label[contains(@for,'others-intensity-severe')]");
			
				javascriptButtonClick(intensity);
				TestUtils.sleep(4);
			
		}
		
		
		
	
	}
	
	
	public void ClickOnEditButtonOfDesiredOthers(String NameOfDrug)
	{
	By DesiredEditButtonOfDrug=By.xpath("//ul[@class='allergy-container']//li[text()='"+NameOfDrug+"']//a[1]//i");
	javascriptButtonClick(DesiredEditButtonOfDrug);
	waitForElementToBecomeVisible(ReactionFieldForOthers, longWait);
	
	}
	
	
	public boolean VerifyReactionOfOthersOnMainPage(String NameOfDrug)
	{
		waitForElementToBecomeVisible(NameOfDrugOnMainPage, longWait);
		By DesiredReaction=By.xpath("//li//span[contains(text(),'"+NameOfDrug+"')]");
		List<WebElement>list=driver.get().findElements(DesiredReaction);
		
		for(WebElement el:list)
		{
			if(el.getText().contains(NameOfDrug));
			{
				return true;
			}
		}
		return false;
	}
	
	//----------------------------------Conditions----------------------------------------------------------	
	
	
	public void DeleteAllExistingConditions()
	{

		

		int count = 0;
		By allDeleteIcon = By.xpath("//a[contains(@class,'remove-condition')]//i");
		waitForElementToBecomeVisible(allDeleteIcon, longWait);
		if (isElementPresent(allDeleteIcon)) {
			List<WebElement> el = driver.get().findElements(allDeleteIcon);

			for (int i = 0; i < el.size(); i++) {
				List<WebElement> el1 = driver.get().findElements(allDeleteIcon);

				waitForElementToBecomeVisible(allDeleteIcon, longWait);

				while (getAttribute(DeleteDialogBoxForConditions, "class").equals("modal")) {
					javascriptButtonClick(el1.get(0));
					TestUtils.sleep(2);
				}

				while (getAttribute(DeleteDialogBoxForConditions, "class").equals("modal show")) {
					javascriptButtonClick(DeleteConfirmConditions);
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
	
	
	
	
	
	
	
	public void ClickOnNoKnownExistingConditions(String Status)
	{
		if(Status.equals("UnChecked"))
		{
			if(driver.get().findElement(KnownConditionCheckBox).isSelected())
			{
				javascriptButtonClick(KnownConditionCheckBox);
				
			}
			
		}
	
		if(Status.equals("Checked"))
		{
			if(!driver.get().findElement(KnownConditionCheckBox).isSelected())
			{
				javascriptButtonClick(KnownConditionCheckBox);
				
			}
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	}

	
	public boolean GetStatusOfConditionButton()
	{
		return driver.get().findElement(AddConditionButton).isEnabled();
		
	}
	
	
	
	public void ClickOnAddConditionButton()
	{
	waitForElementToBecomeVisible(AddConditionButton, longWait);
	clickAndWait(AddConditionButton, longWait);
	waitForElementToBecomeVisible(DrugInputField, longWait);
	}
	
	
	
	public void SetCondition(String text)
	{
		setText(DrugInputField, text, longWait);
	
		SelectOptionForCondition();
	}
	
	
	public void SelectOptionForCondition()
	{
		waitForElementToBecomeVisible(ConditionOption, longWait);
		CLickUsingActionClass(ConditionOption);
		
	}
	
	
	public void SelectDuration(String Duration,String DurationInNumbers)
	{
		setText(DurationInputField, DurationInNumbers, longWait);
		if(Duration.contains("Days"))
		{
		By Days=By.xpath("//label[@for='condition-duration-days']");
			javascriptButtonClick(Days);
		}
	
	
		if(Duration.contains("Weeks"))
		{
		By Weeks=By.xpath("//label[@for='condition-duration-weeks']");
			javascriptButtonClick(Weeks);
		}
	
		
		if(Duration.contains("Months"))
		{
		By Months=By.xpath("//label[@for='condition-duration-months']");
			javascriptButtonClick(Months);
		}
	
		
		if(Duration.contains("Years"))
		{
		By Years=By.xpath("//label[@for='condition-duration-years']");
			javascriptButtonClick(Years);
		}
	
		
		
		
		
	}
	
	public void SelectMedication(String YesOrNo)
	{
		if(YesOrNo.contains("Yes"))
		{
			By Yes=By.xpath("//label[@for='condition-medication-yes']");
			javascriptButtonClick(Yes);

		}
		
		if(YesOrNo.contains("Yes"))
		{
			By No=By.xpath("//label[@for='condition-medication-no']");
			javascriptButtonClick(No);

		}
		
		
	}
	
	
	public void SetMedicineName(String MedicineName)
	{
		waitForElementToBecomeVisible(MedicineNameField, longWait);
		setText(MedicineNameField, MedicineName, longWait);
		
	}

	public void ClickOnSaveConditionButton()
	{
		waitForElementToBecomeVisible(SaveConditionButton, longWait);
		clickAndWait(SaveConditionButton, longWait);
		waitForElementToBecomeVisible(AddConditionButton, longWait);
	}
	
	
}

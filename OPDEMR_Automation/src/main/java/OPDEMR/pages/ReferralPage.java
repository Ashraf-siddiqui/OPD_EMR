package OPDEMR.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import OPDEMR.base.BasePage;
import OPDEMR.utils.TestUtils;

/**
 * @author Ashraf
 *
 */
public class ReferralPage extends BasePage{


	public ReferralPage(ThreadLocal<WebDriver> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By BySpecialityTab=By.xpath("//a[@id='pills-speciality-tab']");
	By ReferralArrow=By.xpath("//*[contains(text(),'REFERRAL')]//parent::*[position()=1]");
	By SpecialityDropDown=By.xpath("//select[@id='speciality']");
	By NoteField=By.xpath("//textarea[@id='instructions']");
	By SaveButton=By.xpath("//button[@id='btnspl_save']");
	By SaveButtonByDoctor=By.xpath("//button[@id='btndr_save']");
	By table=By.xpath("//tbody[@id='refer_speciality_list']");
	By DeleteBox=By.xpath("//main[@id='main']//following-sibling::div[@id='modalConfirm']");
	By DeleteConfirm = By.xpath("//div[contains(@class,'deleteOrderSet')]");
	By NoteFieldByDoctor=By.xpath("//textarea[@id='drinstructions']");
	//---------------------------------------------ByDoctorTab---------------------------------------
	By ByDoctorTab=By.xpath("//a[@id='pills-doctor-tab']");
	
	By DiagnosisInputField=By.xpath("//span[@class='select2-results']//preceding-sibling::span//input[@class='select2-search__field']");
	
	By DiagnosisArrow=By.xpath("//span[@id='select2-doctor_name-container']//following-sibling::span");
	
	By ComboBox=By.xpath("//span[@id='select2-doctor_name-container']//parent::span[@role='combobox']");
	
	By DiagnosisOptions=By.xpath("//ul[@id='select2-doctor_name-results']//li");
	
	//----------------------------------------------AllFunctions--------------------------------------
	
    public void ClickOnReferralArrow()
	{
		waitForElementToBecomeVisible(ReferralArrow, shortWait);
		scrollToElement(ReferralArrow);
		javascriptButtonClick(ReferralArrow);
		waitForElementToBecomeVisible(SpecialityDropDown, longWait);
		
	}
	
	
	public void SelectSpecialityValueFromDropdown(String Speciality)
	{
		waitForElementToBecomeVisible(SpecialityDropDown, longWait);
		selectByCompleteVisibleText(SpecialityDropDown, "Woodlandd-speciality");
		
		
	}

	
	public void EnterDoctorNote(String Note) 
	{
		setText(NoteField, Note, longWait);
	}
	
	public void clickonSaveButton()
	{
		clickAndWait(SaveButton, longWait);
	}

	public void clickonSaveButtonByDoctor()
	{
		clickAndWait(SaveButtonByDoctor , longWait);
	}
	public boolean VerifyStateOfSaveButton()
	{
		if(driver.get().findElement(SaveButton).isEnabled())
		{
			return true;
		}
		return false;
	}

	public void waitforvisibilityOfTable() 
	{
		waitForElementToBecomeVisible(table, longWait);
		
	}
	
	public boolean VerifySpecialityUnderTable(String NameOfSpeciality)
	{

		waitforvisibilityOfTable();

		TestUtils.sleep(7);
		By AllSpeciality = By.xpath("//tbody[@id='refer_speciality_list']//tr//td[1]");

		List<WebElement> listOfTest = driver.get().findElements(AllSpeciality);

		if (isElementPresent(AllSpeciality)) {

			if (listOfTest.size() > 0) {

				for (WebElement el : listOfTest) {
					//System.out.println("str1->"+el.getText());


					if (el.getText().trim().equalsIgnoreCase(NameOfSpeciality))
					
					{
						System.out.println("speciality  :" + el.getText() + " Found On Reffreal Page.");
						return true;
					}
				}

			}

		}

		return false;

		
	
	}
	
	public boolean VerifySpecialityUnderTableByDoctor(String NameOfDoctor)
	{


		waitforvisibilityOfTable();

		TestUtils.sleep(7);
		By AllSpeciality = By.xpath("//tbody[@id='refer_speciality_list']//tr//td[2]");

		List<WebElement> listOfTest = driver.get().findElements(AllSpeciality);

		System.out.println("NAme of the doctor "+NameOfDoctor);
		if (isElementPresent(AllSpeciality)) {

			if (listOfTest.size() > 0) {

				for (WebElement el : listOfTest) {
					System.out.println("str1->"+el.getText());


					if (el.getText().trim().contains(NameOfDoctor))
					
					{
						System.out.println("Doctor  :" + el.getText() + "  Found On Reffreal Page.");
						return true;
					}
				}

			}

		}

		return false;

		
	
	
	}
	
	public void DeleteAllReffrealsFromTable()
	{

		int count = 0;
		By allDeleteIcon = By.xpath("//td//a[2]//i");
		waitForElementToBecomeVisible(allDeleteIcon, longWait);
		if (isElementPresent(allDeleteIcon)) {
			List<WebElement> el = driver.get().findElements(allDeleteIcon);

			for (int i = 0; i < el.size(); i++) {
				List<WebElement> el1 = driver.get().findElements(allDeleteIcon);

				waitForElementToBecomeVisible(allDeleteIcon, longWait);

				while (getAttribute(DeleteBox, "class").equals("modal")) {
					javascriptButtonClick(el1.get(0));
					TestUtils.sleep(2);
				}

				while (getAttribute(DeleteBox, "class").equals("modal show")) {
					javascriptButtonClick(DeleteConfirm);
					TestUtils.sleep(2);
				}
				TestUtils.sleep(7);
				count++;
			}

			if (el.size() - 1 == count) {
				System.out.println("All the elemets deleted.");
			}
		}

	
	}
	
	
	
	
	public void ClickOnByDoctorTab()
	{
		 clickAndWait(ByDoctorTab, longWait);
		waitForElementToBecomeVisible(ComboBox, longWait);
		
	}
	
	public void ClickonBySpecialityTab()
	{
		
		clickAndWait(BySpecialityTab, longWait);
		waitForElementToBecomeVisible(SpecialityDropDown, longWait);
	}
	
	
	
	
	
	
	public void AddDoctor(String NameOFDoctor)
	{
	while(getAttribute(ComboBox, "aria-expanded").equals("false"))
	{
		CLickUsingActionClass(DiagnosisArrow);
		TestUtils.sleep(3);
	}	
		setText(DiagnosisInputField, NameOFDoctor, longWait);
		waitForElementToBecomeVisible(DiagnosisOptions, longWait);
		//javascriptButtonClick(DiagnosisOptions);
		//pressEnter();
		TestUtils.sleep(5);
		CLickUsingActionClass(DiagnosisOptions);
	}
	
	
	public void EnterDoctorNoteByDoctor(String Note) 
	{
		setText(NoteFieldByDoctor, Note, longWait);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

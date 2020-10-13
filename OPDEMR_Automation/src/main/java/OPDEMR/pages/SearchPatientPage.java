package OPDEMR.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import OPDEMR.base.BasePage;

public class SearchPatientPage extends BasePage{

	public SearchPatientPage(ThreadLocal<WebDriver> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	
	
	By SearchField=By.id("patient_name");
	
	By PhoneORUHIDField=By.id("mobile");	
	
	
	By SeacrhButton=By.xpath("//button[contains(text(),'SEARCH')]");
	
	By ValidationErrorMessage=By.id("toast-container");
	
	
	public void EnterPatientNameAndSeacrch(String NameToBeSearched)
	{
		
		EnterPatientNameInPatientNameField(NameToBeSearched);
		
		ClickOnSeacrhButton();
	}
	
	
	public void EnterUHIDOrPhoneNumberAndSeacrch(String NameToBeSearched)
	{
		
		EnterUHIDoRPhoneNumberInUHIDoRPhoneNumberField(NameToBeSearched);
		
		ClickOnSeacrhButton();
	}
	
	
	public void EnterPatientNameInPatientNameField(String NameToBeSearched)
	{
		waitForElementToBecomeVisible(SearchField, longWait);
		setText(SearchField, NameToBeSearched, longWait);
		
	}
	
	
	public void ClickOnSeacrhButton()
	{
		waitForElementToBecomeVisibleDuplicate(SeacrhButton, longWait);
		clickAndWait(SeacrhButton, longWait);
	}
	
	public void EnterUHIDoRPhoneNumberInUHIDoRPhoneNumberField(String UHIDoRPhoneNumberToBeSearched)
	{
		waitForElementToBecomeVisibleDuplicate(PhoneORUHIDField, longWait);
		setText(PhoneORUHIDField, UHIDoRPhoneNumberToBeSearched, longWait);
		
		
		
		
	}
	
	public boolean VerifyErrorToastMessage()
	{
		boolean status=false;
		waitForElementToBecomeVisible(ValidationErrorMessage, minimalWait);
		if(isElementPresent(ValidationErrorMessage))
		{
			waitForElementToBecomeInvisible(ValidationErrorMessage, minimalWait);
			return status=true;
		}
			return status;	
	}
	
	
	public boolean VerifyPatientCardPresentONSearchPatientPage(String Name,String UHID)
	{
		boolean status=false;
		By DesiredPatientName=By.xpath("//h5[@class='text-heading']//following-sibling::p[position()=1 and contains(text(),'"+UHID+"')]//preceding-sibling::h5");
		By DesiredUHID=By.xpath("//h5[@class='text-heading']//following-sibling::p[position()=1 and contains(text(),'"+UHID+"')]");
	
		waitForElementToBecomeVisible(DesiredPatientName, minimalWait);
		
		if(isElementPresent(DesiredPatientName))
		{
		if(!(Name.isEmpty() && UHID.isEmpty()))
		{
		if(getText(DesiredPatientName).equalsIgnoreCase(Name))
		{
			return status=true;		
		}
		}
		
		}
		waitForElementToBecomeVisible(DesiredUHID, minimalWait);
		
		if(isElementPresent(DesiredUHID))
		{
		if(Name.isEmpty() || !(UHID.isEmpty()))
		{
			status=isElementPresent(DesiredUHID);
			return status;
		}	
		
	}
		return status;
		
	}
	
	
	
	
	
	
	
	
}

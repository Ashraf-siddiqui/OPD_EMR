package OPDEMR.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import OPDEMR.base.BasePage;
import OPDEMR.utils.TestUtils;

public class SoapMainPage extends BasePage{

	public SoapMainPage(ThreadLocal<WebDriver> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	By MedicinesCollapseAndExpandButton=By.xpath("//a[@data-target='#medicine-details']");
	By ContinueButton = By.xpath("//div[@class='fixed-cta']//*");

	By ReferralArrow=By.xpath("//*[contains(text(),'REFERRAL')]//parent::*[position()=1]");
	
	
	
	
	public void ClickOnMedicineCollapseOrExpandButton()
	{
		
		/*
		 * waitForElementToBecomeVisible(MedicinesCollapseAndExpandButton, longWait);
		 * String status=getAttribute(MedicinesCollapseAndExpandButton, "class");
		 * while(status.equals(status)) {
		 */
		waitForElementToBecomeVisible(MedicinesCollapseAndExpandButton, longWait);
		javascriptButtonClick(MedicinesCollapseAndExpandButton);
		TestUtils.sleep(4);
//	}
			
	}
	
	
	
	
	
	
	
	public boolean VerifyMedicinesUnderPlanSection(ArrayList<String>Medicines)
	{
		if(Medicines.equals(getMedicinefromPlanSection()))
		{
			return true;
		}
		
		return false;
	}
	
	

	public boolean VerifyTestUnderPlanSection(ArrayList<String>Medicines)
	{
		if(Medicines.equals(getTestfromPlanSection()))
		{
			return true;
		}
		
		return false;
	}
	
	
	
	
	public ArrayList getMedicinefromPlanSection()
	{
		
		By MedicineName=By.xpath("//div[@id='medicine-details']//div[contains(@class,'accordion_item_head')]");
		ArrayList<String>Medicines=new ArrayList<String>();
		List<WebElement>AllMedicines=driver.get().findElements(MedicineName);
		for(WebElement el:AllMedicines )
		{
			Medicines.add(el.getText().trim());
		}
		return Medicines;
	}
	
	
	public ArrayList getTestfromPlanSection()
	{
		
		By TestName=By.xpath("//li[@id='test-details']//following-sibling::li[contains(@class,'text')]");
		ArrayList<String>Tests=new ArrayList<String>();
		List<WebElement>AllTest=driver.get().findElements(TestName);
		for(WebElement el:AllTest )
		{
			Tests.add(el.getText().trim());
		}
		return Tests;
	}
	
	
	
	
	
	
	
	
	
	public void ClickOnContinueButtonUntilReachToMainPage() {

	//	waitForElementToBecomeVisible(ContinueButton, longWait);
		while(!isElementPresent(ReferralArrow))
		{
			isElementPresent(ContinueButton);
			{
				waitForElementToBecomeVisible(ContinueButton, longWait);
			//clickAndWait(ContinueButton, longWait);
			javascriptButtonClick(ContinueButton);
				waitForElementToBecomeVisible(ReferralArrow, minimalWait);
		}
			}

	}
	
	
}
